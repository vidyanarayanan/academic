package com.vn.alg;

/**
 * Created by Vidya on 12/10/16.
 */
public class WordPermutationBak {

    public static void createPermutation(String c, String word) {

        if (word.length() == 1) {
            System.out.println(c + word);
        } else if (word.length() == 2) {
            System.out.println(c + word);
            System.out.println(c + reverse(word));
        } else {
            for (int i = 0; i < word.length(); i++) {
                char yanked = word.charAt(i);
                String restOfWord = yank(word, i);
                String yankedString = c + yanked;
                createPermutation(yankedString, restOfWord);
            }
        }

    }

    private static String  yank(String s, int pos) {
        if (pos == 0) {
            return (s.substring(1));
        } else {
            String left = s.substring(0, pos);
            String right = s.substring(pos + 1);
            return left + right;
        }

    }


    private static String reverse(String s) {
        char [] rev = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            rev[i] = s.charAt(s.length() - 1 - i);
        }
        return new String(rev);
    }


    public static void main(String args[]) {
        createPermutation("", args[0]);
    }
}

