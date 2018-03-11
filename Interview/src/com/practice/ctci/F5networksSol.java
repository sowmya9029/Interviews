package com.practice.ctci;

public class F5networksSol {

    /*
     * Complete the function below.
     */
    static String[] twins(String[] a, String[] b) {
        boolean error = false;
        String [] result = new String[a.length];
        for(int i = 0; i<a.length;i++) {
            if(a[i].length() != b[i].length()) {
                result[i] = "No";
            } else {
                if(encode(a[i]).equals(encode(b[i]))) {
                    result[i] = "Yes";
                } else {
                    result[i] = "No";                    
                }


            }
        }
        return result;
    }
    
    abcd
    cbad
    
 1 - 1 - --------
 1 - 1

    static String encode(String a) {
        int he[] = new int[26];
        int ho[] = new int[26];    
        for(int i=0;i<a.length();i++) {
            char c = a.charAt(i);
            if(i%2==0) {
                he[c-'a']++;
            } else {
                ho[c-'a']++;
            }        
        }
    String encode = "";
        for(int i=0;i<26;i++) {
            encode+= he[i];
            encode+="-";
            encode+=ho[i];
            encode+="-";
        }
    return encode;
}
}
