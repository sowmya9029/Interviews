//package com.practice.ctci;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import com.datastructures.graphs.GraphNode;
//import com.datastructures.graphs.Graphs;
//
//public class StringManipulation {
//
////Find the first non-repeating character from a stream of characters
//	StringBuilder replaceSpaces(String string ,String replaceWith)
//	{
//		StringBuilder s= new StringBuilder();
//		for (int i = 0; i < string.length(); i++) {
//			if(string.charAt(i)==' ')
//			{
//				s.append("%20");
//			}
//			else
//			{
//				s.append(string.charAt(i));
//			}
//		}
//		return s;
//	}
//
//	public static int stringToint( String str ){
//		int i = 0, number = 0;
//		boolean isNegative = false;
//		int len = str.length();
//		if( str.charAt(0) == '-' ){
//			isNegative = true;
//			i = 1;
//		}
//		while( i < len ){
//			number *= 10;
//			number += ( str.charAt(i++) - '0' );
//		}
//		if(isNegative)
//			number = -number;
//		return number;
//	}
//	void permutationOfString(char[] s,int start,int end)
//	{
//		if(start==end)
//		{
//			System.out.println(s);
//		}
//		else
//		{
//			for(int i=start;i<=end;i++)   //abc acb bac bca
//			{
//				swap(s,i,start);
//				permutationOfString(s, start+1, end);
//				swap(s,i,start);
//			}
//		}
//
//	}
//	public  void wordcompress(String[] args) {
//		String str = "ABCC";       //input String
//		int length = str.length();      //length of a String
//
//		//Created an object of a StringBuilder class
//		StringBuilder sb = new StringBuilder();
//
//		int count=1;   //counter for counting number of occurances
//
//		for(int i=0; i<length; i++){
//			//if i reaches at the end then append all and break the loop
//			if(i==length-1){
//				sb.append(str.charAt(i)+""+count);
//				break;
//			}
//
//			//if two successive chars are equal then increase the counter
//			if(str.charAt(i)==str.charAt(i+1)){
//				count++;
//			}
//			else{
//				//else append character with its count
//				sb.append(str.charAt(i)+""+count);
//				count=1;     //reseting the counter to 1
//			}
//		}
//
//		//String representation of a StringBuilder object
//		System.out.println(sb.toString());
//
//	}
//	public static void printRLE(String str)
//	{
//		int n = str.length();
//		for (int i = 0; i < n; i++) {
//
//			// Count occurrences of current character
//			int count = 1;
//			while (i < n - 1 &&
//					str.charAt(i) == str.charAt(i + 1)) {
//				count++;
//				i++;
//			}
//
//			// Print character and its count
//			System.out.print(str.charAt(i));
//			System.out.print(count);
//		}
//	}
//
//	StringBuilder output = new StringBuilder();
//	private void combinations(int start,String inputstring ){//  ac abc b
//
//        for( int i = start; i < inputstring.length(); ++i ){
//            output.append(inputstring.charAt(i));
//            System.out.println(output);
//            if (i < inputstring.length())
//            	combinations(start + 1,inputstring);
//            output.setLength( output.length() - 1 );
//        }
//    }
//
//
//	//you can store f[n] and return that by making f[n] =-1 intially and then storing the values.
//	int fibonacii(int n)
//	{
//		if(n<=1)
//		{
//			return n;
//		}
//		return fibonacii(n-1)+fibonacii(n-2);
//	}
//	static int fib(int n)
//	{
//		/* Declare an array to store Fibonacci numbers. */
//		int f[] = new int[n+1];
//		int i;
//
//		/* 0th and 1st number of the series are 0 and 1*/
//		f[0] = 0;
//		f[1] = 1;
//
//		for (i = 2; i <= n; i++)
//		{
//			/* Add the previous 2 numbers in the series
//	         and store it */
//			f[i] = f[i-1] + f[i-2];
//		}
//
//		return f[n];
//	}
//	// Java program for Fibonacci Series using Space
//	// Optimized Method
//
//	int fib2(int n)
//	{
//		int a = 0, b = 1, c;
//		if (n == 0)
//			return a;
//		for (int i = 2; i <= n; i++)
//		{
//			c = a + b;
//			a = b;
//			b = c;
//		}
//		return b;
//	}
//
//
//
//	public static void main (String args[])
//	{
//		int n = 9;
//		System.out.println(fib(n));
//	}
//	/*move n-1 disc from A to B using c
//	 * move a disc from A to C
//	 * move n-1 disc from B to C using A
//	 * */
//	void TOH(int n,int A,int B,int C)
//	{
//		if(n>0)
//		{
//			TOH(n-1, A, C, B);
//			System.out.println(A+" --> "+C);
//			TOH(n-1, B, A, C);
//		}
//
//	}
//
//	private void swap(char[] s, int i, int start) {
//		char temp=s[i];
//		s[i]=s[start];
//		s[start]=temp;
//	}
//
//	String replaceSpaceWithCharArray(String string ,String replaceWith)
//	{
//		char [] original = string.toCharArray();
//		string = string.trim();
//		int j=0;
//		char [] replace = replaceWith.toCharArray();
//		for(int i = 0;i < original.length && i<string.length();i++) {
//			if(original[j]==' ') {
//				System.out.println(i);
//				for(int k=0;k<replace.length;k++) {
//					original[k+j] = replace[k];
//					j = j+replace.length;
//				}
//			}
//			else {
//				original[j] = string.charAt(i);
//				j++;
//			}
//		}
//		return new String(original);
//	}
//	String compressedString(String string)
//	{
//		String temp="";
//		boolean canCompress=false;
//		int count=1;
//		for (int i = 0; i < string.length(); i++) {
//
//			if(count==1)
//				temp=temp+string.charAt(i);
//
//			if(i<string.length()-1)
//			{
//				if(string.charAt(i)==string.charAt(i+1))
//				{
//
//					++count;
//					canCompress=true;
//				}
//				else
//				{
//
//					temp=temp+count;
//					count=1;
//				}
//			}
//			else
//			{
//				temp=temp+count;
//				count=1;
//			}
//		}
//		if(canCompress)
//			return temp;
//		else
//			return string;
//	}
//	String compress(String s)
//    {
//        StringBuilder sb = new StringBuilder();
//
//    }



//	String compressedString(String[] string)
//	{
//		String temp="";
//		boolean canCompress=false;
//		int count=1;
//		for (int i = 0; i < string.length; i++) {
//
//			if(count==1)
//				temp=temp+string[i];
//
//			if(i<string.length-1)
//			{
//				if(string[i]==string[i+1])
//				{
//
//					++count;
//					canCompress=true;
//				}
//				else
//				{
//
//					temp=temp+count;
//					count=1;
//				}
//			}
//			else
//			{
//				temp=temp+count;
//				count=1;
//			}
//		}
//		if(canCompress)
//			return temp;
//		else
//			return string;
//	}


//	boolean checkIsRotation(String s1,String s2)
//	{
//		if(s1.length()!=s2.length())
//		{
//			return false;
//		}
//
//		String s3;
//		s3=s1+s1;
//
//		if(s3.contains(s2))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
//
//	}
//	static boolean isPalRec(String str, int s, int e)
//	{
//		// If there is only one character
//		if (s == e)
//			return true;
//
//		// If first and last characters do not match
//		if ((str.charAt(s)) != (str.charAt(e)))
//			return false;
//
//		// If there are more than two characters,
//		// check if middle substring is also
//		// palindrome or not.
//		if (s < e+1)
//			return isPalRec(str, s+1, e-1);
//
//		return true;
//
//	}
//
//	public boolean isPalindrome(int x)
//	{
//		StringBuffer s = new StringBuffer(Integer.toString(x));
//		String real =s.toString();
//		String reverse =s.reverse().toString();
//		if((real.toString()).equals(reverse))
//		{
//			System.out.println(reverse);
//			System.out.println(s.toString());
//			return true;
//		}
//		else
//		{
//			return false;
//		}
//
//	}
//	public int removeElement(int[] nums, int val) { 12335
//		int len = nums.length;
//		for(int i=0;i<len;i++)
//		{
//			System.out.println(i);
//			while(nums[i]==val&& i<len)
//			{
//				System.out.println(nums[i]+"--"+len+"--"+i);
//				nums[i]=nums[--len];
//			}
//		}
//		return len;
//
//
//	}
//	//parttern Matching
//	public void bruteForceAlgorithm(String s,String subs)
//	{
//		int i=0;
//		int j=0;
//		while (i<(s.length()-subs.length()))
//		{
//			while(subs.length()>=j)
//			{
//			    if(s.charAt(i+j)==subs.charAt(j))
//			    {
//			    	   System.out.println(i+"");
//			    	   j++;
//			    } else {
//			    		break;
//			    }
//
//			    if(j==subs.length())
//			    {
//			    	   System.out.println("pattern matched at location = "+i );
//			    	   break;
//			    }
//			}
////			System.out.println(i+"outside");
//			j=0;
//			i++;
//		}
//
//
//
//	}
//
//	//knuth morris pratt
//	//trie construction
//        //prefix tries using pattern matching contruct graph
//		public Graphs trieConstruction(List<String> Patterns)
//		{
//			//GraphNode node = new GraphNode(0, false);
//			Graphs graph= new Graphs();
//			GraphNode root = new GraphNode(0, false);
//			//graph.a
//			for(String s : Patterns)
//			{
//				//GraphNode node = new GraphNode(Integer.parseInt(s.ch), false);
//
//				GraphNode currentNode = new GraphNode(Integer.parseInt(s.charAt(0)+""), false);
//				graph.addDirectedEdge(root,currentNode);
//				for(int i=1;i<s.length();i++)
//				{
//					//String currentSymbol=s.charAt(i)+"";
//					GraphNode currentSymbol = new GraphNode(Integer.parseInt(s.charAt(i)+""),false);
//					if(graph.adj(currentNode).contains(currentSymbol))
//					{
//						currentNode=graph.getGraphNode(Integer.parseInt(s.charAt(i)+""));
//					}
//					else
//					{
//						 graph.addDirectedEdge(currentNode,currentSymbol);
//						 currentNode=currentSymbol;
//					}
//
//
//				}
//			}
//			return graph;
//		}
//
//
//		public void prefixTrieMatching(String text,Graphs trie)
//		{
//
//
//
//			//int position=0;
////			if(Integer.parseInt(text.charAt(position)+"")==root.getVertice())
////			{
////
////			}
//			GraphNode root = trie.getGraphNode(0);
//
//			for(int j=0;j<text.length();j++)
//			{
//				for(int i=j;i<text.length();i++)
//				{
//					ArrayList<GraphNode> nodeList = trie.adj(root);
//					GraphNode node= trie.getGraphNode(Integer.parseInt(text.charAt(i)+""));
//					if(nodeList.contains(node))
//					{
//						root=node;
//					}
//					if(root==null)
//					{
//					    	System.out.print("Match Found!!");
//					}
//
//				}
//			}
//		}
//
//		//sufix tries
//		//contruct graph using text , o(text+pattern) memory o(text)
//		public void sufixTries(String text)
//		{
//
//		}
//
//		public void reverseString(String[] s)
//		{
//			String []reverse = new String[s.length];
//			for(int i=0;i<s.length;i++)
//			{
//				reverse[i]=s[s.length-i-1];
//			}
//			//StringBuffer s = new StringBuffer();
//		}
//
//		public void removeChar(char s[],char removeS[])
//		{
//			int auxi[] =new int[256];
//			for(int i=0;i<256;i++)
//			{
//				auxi[i]=0;
//
//			}
//			int j=0;
//			while(j<removeS.length)
//			{
//				auxi[removeS[j]]=1;
//				j++;
//			}
//			j=0;
//
//
//			int n=s.length;
//			while(j<n)
//			{
//				if(auxi[s[j]]==1)
//				{
//					s[j]=s[n-1];
//					n--;
//				}
//				else
//				{
//					j++;
//				}
//			}
//		}
//
//		//dynamic programing time and space o(n^2)
//
//		private String longestPalSubstring(String s)
//		{
//			int n=s.length();
//			int max_lenght=0;
//			int palindrome_starting_index=0;
//			boolean palindrome[][] = new boolean[n][n];
//
//			//diagonal always true since single word is pal of itself
//			for(int i=0;i<s.length()-1;i++)
//			{
//				palindrome[i][i]=true;
//				max_lenght=1;
//
//			}
//			for(int i=0;i<s.length()-1;i++)
//			{
//				if(s.charAt(i)==s.charAt(i+1)) {
//					palindrome[i][i + 1] = true;
//					max_lenght = 2;
//				}
//			}
//			//finding pal from
//			for(int current_length=3 ; current_length<=s.length();current_length++)
//			{
//				for(int i =current_length;i<s.length()-current_length+1 ;i++)
//				{
//					int j = i+current_length-1;
//					if(s.charAt(i)==s.charAt(j) && palindrome[i+1][j-1]) {
//						palindrome[i][j] = true;
//						palindrome_starting_index=i;
//						max_lenght = current_length;
//					}
//				}
//
//			}
//
//return s.substring(palindrome_starting_index,max_lenght+1);
//
//		}
//
//	private void removeAdjacent(String s)
//		{
//			int i=0;
//			//ABCCBCBA
//			while(i<s.length()-1)
//			{
//				System.out.println(s);
//				if(s.charAt(i)==s.charAt(i+1))
//				{
//					s= s.substring(0,i)+s.substring(i+2);
//					i = 0;
//					continue;
//				}
//				i++;
//			}
//			System.out.println(s);
//		}
//
//		//search a string in sorted empty array
//		public int Search(String array[],String find,int first,int last)
//		{
//			if(first>last)
//			{
//				return -1;
//			}
//			int mid  = first+(last-first)/2;
//			if(array[mid].equalsIgnoreCase(""))
//			{
//				int left =mid-1;
//				int right = mid+1;
//				while (true)
//				{
//					if(left<first && right>last)
//					{
//						return -1;
//					}
//					else if(left>=first && !array[left].equalsIgnoreCase(""))
//					{
//						mid= left;
//						break;
//					}
//					else if(right>=first && !array[left].equalsIgnoreCase(""))
//					{
//						mid =right;
//						break;
//					}
//					right++;
//					left--;
//				}
//			}
//			if(find.equalsIgnoreCase(array[mid]))
//			{
//				return mid;
//			}
//			else if(array[mid].compareTo(find)<0)
//			{
//				return Search(array, find, mid+1, last);
//			}
//			else
//			{
//				return Search(array, find, mid+1, last);
//			}
//
//		}
//
//
//	//longest common substring with m unique characters
//		public String longestSubstring(String s, int k) {
//
//			int start=0;
//			int end=0;
//			int windowSize=0;
//			int windowStart=0;
//			HashMap<Character,Integer> map = new HashMap<Character,Integer>();
//			map.put(s.charAt(0),1);
//			windowSize=1;
//
//			for(int i=1;i<s.length();i++)
//			{
//				char ch = s.charAt(i);
//				if(map.containsKey(ch))
//				{
//					int val = map.get(ch);
//					map.put(ch,val++);
//				}
//				else
//				{
//					map.put(ch,1);
//				}
//				end++;
//
//				while(!hasLessChar(map,k))
//				{
//					int temp = map.get(s.charAt(start));
//					map.put(s.charAt(start),temp--);
//					start++;
//				}
//				if(end-start+1>windowSize)
//				{
//					windowSize = end-start+1;
//					windowStart = start;
//				}
//			}
//			return s.substring(windowStart,windowStart+windowSize);
//
//		}
//
//		//string to char[];
//
//}
package array;

public class WordBreak {

    public static void main(String[] args) {
        String word = "iloveicecreamandmango";

        wordBreak(word);

    }

    private static void wordBreak(String word) {
        wordBreakUtil(word, word.length(), "");
    }

    private static void wordBreakUtil(String word, int length, String result) {

        for(int i=1; i<=length; i++)
        {
            String prefix = word.substring(0, i);
            if (dictionaryContains(prefix))
            {
                // if no more elements are there, print it
                if (i == length)
                {
                    // add this element to previous prefix
                    result += prefix;
                    System.out.println(result);
                    return;
                }
                wordBreakUtil(word.substring(i, length), length-i, result + prefix + " ");
            }
        }
    }

    private static boolean dictionaryContains(String prefix) {
        // TODO Auto-generated method stub
        String dictionary[] = { "mobile", "samsung", "sam", "sung", "man",
                "mango", "icecream", "and", "go", "i", "love", "ice", "cream" };
        int n = dictionary.length;
        for (int i = 0; i < n; i++)
            if (dictionary[i].compareTo(prefix) == 0)
                return true;
        return false;
    }

}
//
