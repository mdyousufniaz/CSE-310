import java.util.List;
import java.util.LinkedList;
import java.util.Stack;
import java.lang.Math;

import org.antlr.v4.runtime.Token;


class Identifier {
    String name;
    int type;
    List<Identifier> parameters;

    Identifier(String name, int type, List<Identifier> parameters) {
        this.name = name;
        this.type = type;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return " < " + this.name + " : ID >";
    }
}

class ScopeTable {
    private static final int numBuckets = 7;

    private List<Identifier>[] identifiers;
    String scopeId;
    ScopeTable parentScope;

    private static int SDBMHash(String id) {
        long hash = 0;
        for (char c: id.toCharArray()) {
            hash = c + (hash << 6) + (hash << 16) - hash;
        }

        return Math.floorMod(hash, numBuckets);
    }

    @SuppressWarnings("unchecked")
    ScopeTable(String scopeId, ScopeTable parentScope) {
        this.identifiers = (List<Identifier>[]) new LinkedList[numBuckets];

        for (byte i = 0; i < numBuckets; i++) {
            this.identifiers[i] = new LinkedList<Identifier>();
        }
        this.scopeId = scopeId;
        this.parentScope = parentScope;
    }

    private List<Identifier> getIdList(String idName) {
        int hashIndex = SDBMHash(idName);
       return this.identifiers[hashIndex];
    }

    boolean insertId(Identifier id) {
        if (getId(id.name) != null) return false;

        getIdList(id.name).add(id);
        return true;
    }

    Identifier getId(String idName) {
        List<Identifier> idList = getIdList(idName);
        if (idList.isEmpty()) return null;

        for (Identifier id: idList) {
            if (id.name.equals(idName)) return id;
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
            "ScopeTable # "
            + this.scopeId
            + '\n'
        );

        for (byte i = 0; i < numBuckets; i++) {
            List<Identifier> idList = this.identifiers[i];
            if (idList.isEmpty()) continue;

            sb.append(i + " -->");
            for (Identifier id: idList) sb.append(id.toString());
            sb.append('\n');
        }
        return sb.toString();
    }

}

class SymbolTable {
    private ScopeTable currScope;
    private Stack<Integer> childCounts;

    SymbolTable() {
        this.currScope = new ScopeTable("1", null);
        this.childCounts = new Stack<Integer>();
        this.childCounts.push(1);
    }

    void enterScope() {
        Integer currChildCount = this.childCounts.peek();
        ScopeTable topScope = new ScopeTable(
            this.currScope.scopeId + "." + currChildCount,
            this.currScope
        );
        
        this.currScope = topScope;
        this.childCounts.push(1);
        System.out.println(childCounts + this.currScope.scopeId);
    }

    void exitScope() {
        if (this.currScope.parentScope == null)  return;

        this.currScope = this.currScope.parentScope;
        this.childCounts.pop();
        Integer currChildCount = this.childCounts.pop();
        this.childCounts.push(currChildCount + 1);
    }

    public boolean insertId(Identifier ID) {
        return this.currScope.insertId(ID);
    }

    public Identifier getId(String idName) {
        ScopeTable tempScope = this.currScope;

        while (tempScope != null) {
            Identifier id = tempScope.getId(idName);
            if (id != null) return id;
            tempScope = tempScope.parentScope;
        }
        return null;
    }
    

    @Override
    public String toString() {
        ScopeTable tempScope = this.currScope;
        StringBuilder sb = new StringBuilder();

        while (tempScope != null) {
            System.out.println(tempScope.scopeId);
            sb.append(tempScope.toString());
            tempScope = tempScope.parentScope;
        }
        return sb.toString();
    }

}