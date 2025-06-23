import java.util.List;
import java.util.LinkedList;
import java.util.Stack;


abstract class Idenitifier {
    private String name;

    Idenitifier(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    abstract IDType getIDType();

    @Override
    public String toString() {
        return "< " + this.name + " , " + "ID" + " >";
    }

}

class Variable extends Idenitifier {
    public DataType dataType;
    Variable(String name, DataType dataType) {
        super(name);
        this.dataType = dataType;
    }

    @Override
    IDType getIDType() {
        return IDType.VARIABLE;
    }
}

class Function extends Idenitifier {
    DataType returnType;
    List<Variable> parameters;

    Function(String name, DataType returnType, List<Variable> parameters) {
        super(name);
        this.returnType = returnType;
        this.parameters = new LinkedList<Variable>();
        if (parameters != null) {
            this.parameters.addAll(parameters);
        }
    }

    @Override
    IDType getIDType() {
        return IDType.FUNCTION;
    }
}

class ScopeTable {
    private static final int numBuckets = 7;

    private List<Idenitifier>[] identifiers;
    String scopeID;
    ScopeTable parentScope;

    private static int SDBMHash(String id) {
        long hash = 0;
        for (char c: id.toCharArray()) {
            hash = c + (hash << 6) + (hash << 16) - hash;
        }

        return (int) ((hash + numBuckets) % numBuckets);
    }

    @SuppressWarnings("unchecked")
    ScopeTable(String scopeID, ScopeTable parentScope) {
        this.identifiers = (List<Idenitifier>[]) new LinkedList[numBuckets];

        for (byte i = 0; i < numBuckets; i++) {
            this.identifiers[i] = new LinkedList<Idenitifier>();
        }
        this.scopeID = scopeID;
        this.parentScope = parentScope;
    }

    boolean hasID(Idenitifier ID) {
        int hashIndex = SDBMHash(ID.getName());
        List<Idenitifier> idList = this.identifiers[hashIndex];

        for (Idenitifier id: idList) {
            if (id.getName().equals(ID.getName())) return true;
        }
        return false;
    }

    boolean insert(Idenitifier ID) {
        if (hasID(ID)) return false;

        int hashIndex = SDBMHash(ID.getName());
        this.identifiers[hashIndex].add(ID);
        return true;
    }

    Idenitifier getID(String idName) {
        int hashIndex = SDBMHash(idName);
        List<Idenitifier> idList = this.identifiers[hashIndex];

        for (Idenitifier id: idList) {
            if (id.getIDType() == IDType.FUNCTION) {
                for (Variable param: ((Function) id).parameters) {
                    if (param.getName().equals(idName)) return param;
                }
            }

            if (id.getName().equals(idName)) return id;
        }
        return null;
    }

    Variable getVariable(String varName) {
        Idenitifier id = getID(varName);
        if (id != null && id.getIDType() == IDType.VARIABLE) {
            return (Variable) id;
        }
        return null;
    }
    
    Function getFunction(String funcName) {
        Idenitifier id = getID(funcName);
        if (id != null && id.getIDType() == IDType.FUNCTION) {
            return (Function) id;
        }
        return null;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
            "ScopeTable # "
            + this.scopeID
            + '\n'
        );

        for (byte i = 0; i < numBuckets; i++) {
            List<Idenitifier> idList = this.identifiers[i];
            if (idList.isEmpty()) continue;

            sb.append(i + " -->");
            for (Idenitifier id: idList) sb.append(" " + id.toString());
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
            this.currScope.scopeID + "." + currChildCount,
            this.currScope
        );
        System.err.println(topScope.scopeID);
        
        this.currScope = topScope;
        this.childCounts.push(1);
    }

    void exitScope() {
        if (this.currScope.parentScope == null) {
            return;
        }
        this.currScope = this.currScope.parentScope;
        this.childCounts.pop();
        Integer currChildCount = this.childCounts.pop();
        this.childCounts.push(currChildCount + 1);
    }

    public boolean insert(Idenitifier ID) {
        return this.currScope.insert(ID);
    }

    public Idenitifier getID(String idName) {
        ScopeTable tempScope = this.currScope;

        while (tempScope != null) {
            Idenitifier id = tempScope.getID(idName);
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
            sb.append(tempScope.toString());
            tempScope = tempScope.parentScope;
        }
        return sb.toString();
    }

}