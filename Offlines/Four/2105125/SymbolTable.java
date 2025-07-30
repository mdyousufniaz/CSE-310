import java.util.List;
import java.util.LinkedList;

import static java.lang.Math.floorMod;

class Identifier {
    String name;
    String type;
    String offset;

    Identifier(String name, String type, String offset) {
        this.name = name;
        this.type = type;
        this.offset = offset;
    }
}

class SymbolTable {
    private static final int numBuckets = 7;

    private List<List<Identifier>[]> scopeTables;

    private static int SDBMHash(String id) {
        long hash = 0;
        for (char c: id.toCharArray()) 
            hash = c + (hash << 6) + (hash << 16) - hash;

        return floorMod(hash, numBuckets);
    }

    private Identifier getIdInScope(String idName, int scopeindex) {
        if (scopeindex < 0 || scopeindex >= scopeTables.size()) return null;

        List<Identifier>[] identifiers = scopeTables.get(scopeindex);
        int hashIndex = SDBMHash(idName);
        List<Identifier> idList = identifiers[hashIndex];

        for (Identifier id : idList) 
            if (id.name.equals(idName))
                return id;

        return null;
    }

    SymbolTable() {
        this.scopeTables = new LinkedList<>();
        this.enterScope();
    }

    @SuppressWarnings("unchecked")
    void enterScope() {
        List<Identifier>[] identifiers = (List<Identifier>[]) new LinkedList[numBuckets];
        for (byte i = 0; i < numBuckets; i++) 
            identifiers[i] = new LinkedList<Identifier>();

        this.scopeTables.add(identifiers);
    }

    void exitScope() {
        if (!this.scopeTables.isEmpty()) {
            this.scopeTables.remove(scopeTables.size() - 1);
        }
    }

    Identifier getId(String idName) {
        for (int i = scopeTables.size() - 1; i >= 0; i--) {
            Identifier id = getIdInScope(idName, i);
            if (id != null)
                return id;
        }
        return null;
    }

    boolean insertId(String idName, String idType, String offset) {
        if (getIdInScope(idName, scopeTables.size() - 1) != null) 
            return false;

        List<Identifier>[] currScope = scopeTables.get(scopeTables.size() - 1);
        int hashIndex = SDBMHash(idName);
        List<Identifier> idList = currScope[hashIndex];

        idList.add(new Identifier(idName, idType, offset));
        return true;
    }

    String getOffset(String idName) {
        Identifier id = getId(idName);
        return id == null ? "" : id.offset;
    }


}