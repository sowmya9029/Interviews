package com.practice.ctci;

import java.util.HashMap;

public class Trie {

    TrieNode root;
    class TrieNode
    {
        HashMap<Character,TrieNode> children;
        boolean endofWord;
        TrieNode()
        {
            children = new HashMap<>();
            endofWord =false;
        }
    }

    Trie()
    {
        root = new TrieNode();
    }

    void insert(String word)
    {
        TrieNode current = root;
        for(int i=0;i<word.length();i++) {
            TrieNode node = current.children.get(word.charAt(i));
            if (node == null) {
                node = new TrieNode();
                current.children.put(word.charAt(i), node);}
            current = node;
        }current.endofWord=true;
    }

    boolean search(String word)
    {
        TrieNode current = root;
        for(int i=0;i<word.length();i++) {
            TrieNode node = current.children.get(word.charAt(i));
            if(node==null)
            {
                return false;
            }
            current = node;
        }
        return current.endofWord;
    }
    /**
     * Returns true if parent should delete the mapping
     */
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.endofWord) {
                return false;
            }
            current.endofWord = false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }

}
