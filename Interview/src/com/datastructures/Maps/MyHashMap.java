package com.datastructures.Maps;

public class MyHashMap {
    // for better re-sizing is taken as 2^4
    private static final int SIZE = 16;
    private Entry table[] = new Entry[SIZE];

    /**
     * To store the Map data in key and value pair.
     * Used linked list approach to avoid the collisions
     */
    class Entry {
        final String key;
        String value;
        Entry next;

        Entry(String k, String v) {
            key = k;
            value = v;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }
    }

    /**
     * Returns the entry mapped to key in the HashMap.
     */
    public Entry get(String k) {
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];

        // Bucket is identified by hashCode and traversed the bucket
        // till element is not found.
        while(e != null) {
            if(e.key.equals(k)) {
                return e;
            }
            e = e.next;
        }
        return null;
    }

    /**
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     */
    public void put(String k, String v) {
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];

        if(e != null) {
            // If we will insert duplicate key-value pair,
            // Old value will be replaced by new one.
            if(e.key.equals(k)) {
                e.value = v;
            } else {
                // Collision: insert new element at the end of list
                // in the same bucket
                while(e.next != null) {
                    e = e.next;
                }
                Entry entryInOldBucket = new Entry(k, v);
                e.next = entryInOldBucket;
            }
        } else {
            // create new bucket for new element in the map.
            Entry entryInNewBucket = new Entry(k, v);
            table[hash] = entryInNewBucket;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put("Awadh", "SSE");
        myHashMap.put("Rahul", "SSE");
        myHashMap.put("Sattu", "SE");
        myHashMap.put("Gaurav", "SE");

        Entry e = myHashMap.get("Awadh");
        System.out.println(""+e.getValue());
    }

    //using entry set

    /* Map<K,V> m=new LinkedHashMap<K,V>();
    for(Map.Entry<K,V> entry: m.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());*/
}
//
public void solveSudoku(char[][] board) {
    helper(board);
}

    private boolean helper(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    continue;
                }

                for(char k='1'; k<='9'; k++){
                    board[i][j]=k;
                    if(isValid(board, i, j) && helper(board)){
                        return true;
                    }
                    board[i][j]='.';
                }

                return false;
            }
        }

        return true; //return true if all cells are checked
    }

    private boolean isValid(char[][] board, int i, int j){
        HashSet<Character> set = new HashSet<>();

        for(int k=0; k<9; k++){
            if(set.contains(board[i][k])){
                return false;
            }
            if(board[i][k]!='.'){
                set.add(board[i][k]);
            }

        }

        set.clear();

        for(int k=0; k<9; k++){
            if(set.contains(board[k][j])){
                return false;
            }
            if(board[k][j]!='.'){
                set.add(board[k][j]);
            }
        }

        set.clear();

        int x=i/3 * 3;
        int y=j/3 * 3;
        for(int m=x; m<x+3; m++){
            for(int n=y; n<y+3; n++){
                if(set.contains(board[m][n])){
                    return false;
                }
                if(board[m][n]!='.'){
                    set.add(board[m][n]);
                }
            }
        }

        set.clear();

        return true;
    }