package com.datastructure.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
static String firstRepeatedWord(String s) {
	Set<String> uniqueWordsInString = new HashSet<>();
	StringTokenizer tokenizer = new StringTokenizer(s," \t,-:;.");
	while(tokenizer.hasMoreTokens()) {
		String nextWord = tokenizer.nextToken();
		//uniqueWordsInString.
		if(!uniqueWordsInString.add(nextWord)) {
			return nextWord;
		}
	}
	return "";
}

/*
 * Complete the function below.
 */

    static int bestAverageGrade(String [][] scores)
{
        int largest = Integer.MIN_VALUE;
    HashMap <String,Student> studentsMap = new HashMap<>();
    if(scores.length == 0) {
        return 0;
    }
    for(int i=0;i<scores.length;i++)
    {
        if(scores[i].length!=2) {
            return 0;
        }
        String name = scores[i][0];
        int score =Integer.parseInt(scores[i][1]);
        System.out.println(name);
        System.out.println(score);
        Student student;
        if(studentsMap.containsKey(name))
            {
                student = studentsMap.get(name);
            }
        else
            {
                student = new Student();
            }
        student.addScores(score);
        studentsMap.put(name,student);
    }
    for(String studentName : studentsMap.keySet()) {
        if(studentsMap.get(studentName).getAvg_score() > largest) {
            largest = studentsMap.get(studentName).getAvg_score();
        }
    }
    return largest;
}
  static class Student
 {
     private int count;
     private int avg_score;
     private int totalScore;
     
      void addScores(int score)
     {
         totalScore += score;
         count++;
          avg_score = totalScore/count;
     }
     Integer getAvg_score()
     {
         System.out.println(totalScore);
         System.out.println(count);
         return avg_score;
     }
     
      public String toString() {
          return String.format("total score = %d, avg score = %d and count = %d ",totalScore,avg_score,count);
      }
 }



static String isPangram(String[] strings) {
	// For large input array size, Stringbuffer will be optimal in space to 
	// construct the response String with 1's and 0's.
    StringBuffer panagramOutput=new StringBuffer();
    //Strings defining the return for panagram and no panagram.
    String isPanagram="1";
    String isNotPanagram="0";
    int uniqueAlphabetSize = 26;
    
    //Potential options of data structures include
    // Bitmap of size 26 to check for all alphabets, that is not scalable
    // when input changes. Hash set is scalable to include newer character types and
    // takes O(1) space since the maximum amount of characters in a hashset can be 26 only.
    Set<Character> allUniqueCharactersInString = new HashSet<>();
    for(String input:strings) {
        for(Character character : input.toCharArray()) {
            if(!character.equals(' ')) {
                allUniqueCharactersInString.add(character);
            }
        }
        if(allUniqueCharactersInString.size() == uniqueAlphabetSize) {
            panagramOutput.append(isPanagram);
        } else {
            panagramOutput.append(isNotPanagram);
        }
        allUniqueCharactersInString = new HashSet<>();
    }
    return panagramOutput.toString();
}
		public static void main(String [] args) {
				System.out.println(firstRepeatedWord("He	had		enough	enough.of;this nonsense."));
}

public int missingPositiveNumber(int a[])
{
    for(int k=;)
}
}
