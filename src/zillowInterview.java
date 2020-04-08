import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class zillowInterview {

    public List<String> CSVParser(String s)
    {
        // "
        //[sowmya
        //s=" sowmya,
        //  ""harsha best"",
        //  "h , s" ";
        List<String> output = new ArrayList<>();
        int start =0;
        int end = s.length();
        while(start<end)
        {
            StringBuilder sb = new StringBuilder();
         if(s.charAt(start)=='\"' && s.charAt(start+1)=='\"')
         {
               sb.append("\"");
         }
            sb.append(s.charAt(start));

            if(s.charAt(start)=='\"')
            {
                sb = new StringBuilder();

            }
         if(s.charAt(start)==',')
         {
             output.add(sb.toString());

         }
        }
       return null;
    }
    public static void main(String[] args)
    {
        List<String> words = new ArrayList<>();
        words.add("abc");
        words.add("abcd");
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                int letter_index = 0;
                while (letter_index < word1.length()) {
                    letter_index += 1;
                    char letter1 = word1.charAt(letter_index);
                    char letter2 = word2.charAt(letter_index);

                    if (letter1-'a' >letter2-'a') {
                        return -1;


                    } else if (letter2-'a' > letter1-'a') {
                        return 1;

                    }
                }
                return -1;
            }
        });
        System.out.println(words);
    }

}
