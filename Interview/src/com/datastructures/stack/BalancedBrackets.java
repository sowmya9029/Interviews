package com.datastructures.stack;
import java.util.Stack;
public class BalancedBrackets {
    public boolean isValid(String s) {

        Stack<String> stack_open = new Stack();

        for(int i=0;i<s.length();i++)
        {

            if (s.charAt(i) == '{' || s.charAt(i) =='(' ||s.charAt(i) == '[' )
                stack_open.push(s.charAt(i)+"");

            if (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']')
            {

                if (stack_open.isEmpty())
                {
                    return false;
                }

                else if ( !isMatchingPair(stack_open.pop(), s.charAt(i)+"") )
                {
                    return false;
                }
            }


        }
        return false;

    }

    static boolean isMatchingPair(String character1, String character2)
    {
        if (character1 == "(" && character2 == ")")
            return true;
        else if (character1 == "{" && character2 == "}")
            return true;
        else if (character1 == "[" && character2 == "]")
            return true;
        else
            return false;
    }
}
