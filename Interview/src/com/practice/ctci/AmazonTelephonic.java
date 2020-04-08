package com.practice.ctci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AmazonTelephonic {
    class Node
    {
        int data;
        Node left;
        Node right;
        boolean getHasLeft(){
            if(left==null) {
           return false;
        }
        return true;
        }
        boolean getHasRight(){
            if(right==null) {
                return false;
            }
            return true;
        }


    }
    List<Integer> list = new ArrayList<>();
    public void sumLevelWise(Node root)
    {
        sumLevelWise(root,0);
    }
    int value;
   /*   5         5
    3       4     7
  2   1       6   9
    */


    public void sumLevelWise(Node root,int level)
    {
        if(root==null)
        {
            return;
        }
        value +=root.data;
        if(list.get(level) != null) {
            list.remove(level);
            list.add(level,value);
        }


        if(root.getHasLeft())
        {
            sumLevelWise(root.left,level+1);
        }
        if(root.getHasRight())
        {
            sumLevelWise(root.right,level+1);
        }

    }


    /** Amazon return a;
     * Primemember return P **/
    HashMap<Character,Integer> uniques = new HashMap<>();
    HashSet<Character> duplicatesCheck = new HashSet<>();
    Character findUniqueChar(String s)
    {
        int low = s.length();
        Character finalUniqueChar='x';
        for(int i = 0;i<s.length();i++)
        {
            char c = s.toLowerCase().charAt(i);

            if(duplicatesCheck.contains(c))
            {

            }
            else
            {
                if(!uniques.containsKey(c))
                {
                    uniques.put(c,i); //am
                }
                else {
                    uniques.remove(c,i);
                    duplicatesCheck.add(c);
                }

            }

        }
        for(Character c: uniques.keySet())
        {
            if(uniques.get(c)<low)
            {
                low=uniques.get(c);
                finalUniqueChar=c;
            }
        }

        return finalUniqueChar;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(0,10);
        a.add(1,10);
        a.add(2,10);
        a.add(3,10);
        a.remove(1);
        a.add(1,20);
        a.remove(2);
        a.add(2,30);
        a.remove(3);
        a.add(3,40);
        System.out.println(a);

    }
}
