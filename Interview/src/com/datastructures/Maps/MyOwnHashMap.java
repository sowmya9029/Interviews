package com.datastructures.Maps;

public class MyOwnHashMap {
    private static final int SIZE = 16;
    Node hashMapNode[] = new Node[SIZE];


    class Node{
        Node next;
        String value;
        final String key;
        Node(String key,String value)
        {
            this.key=key;
            this.value=value;
        }
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getKey()
        {
            return key;
        }
    }

    public Node get(String key)
    {
        int hash = key.hashCode()%SIZE;

        Node node = hashMapNode[hash];

        while(node!=null)
        {
            if(node.getKey().equals(key))
            {
                return node;
            }
            node =node.next;
        }
        return null;
    }
    public void remove(String key)
    {
        int hash = key.hashCode()%SIZE;

        Node node = hashMapNode[hash];

        while(node!=null)
        {
            if(node.getKey().equals(key))
            {
                node=null;
            }
            node =node.next;
        }
        //node doesnt exists
    }

    public void put(String key,String value)
    {

        int hash = key.hashCode()%this.SIZE;
        System.out.println("index is:"+hash);
        Node node = hashMapNode[hash];
        while(node!=null) {
            if(node.getKey().equals(key)){
                node.setValue(value);
                return;
            } else {
                node = node.next;
            }
        }

        // add new entry to the beginning of the bucket;
        Node newnode = new Node(key,value);
        node.next = newnode;
        hashMapNode[hash] = newnode;
        return;


    }


}
