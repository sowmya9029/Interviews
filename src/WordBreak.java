

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