package com.vn.alg;

import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;

import static com.vn.alg.WordPermutation.createPermutation;

/**
 * Created by Vidya on 12/10/16.
 */
public class WordPermutation {

    public static void createPermutation(ArrayList<String> ret, String c, String word) {
        if (word.length() == 1) {
            ret.add(c + word);
        } else if (word.length() == 2) {
            ret.add(c + word);
            ret.add(c + reverse(word));
        } else {
            for (int i = 0; i < word.length(); i++) {
                char yanked = word.charAt(i);
                String restOfWord = yank(word, i);
                String yankedString = c + yanked;
                createPermutation(ret, yankedString, restOfWord);
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
        ArrayList<String> permutations = new ArrayList<String>();
        String word = args[0];
        createPermutation(permutations, "", word);
        int resultsize = permutations.size();
        int np = numberOfPermutations(word);
        Assert.that((resultsize == np), "Expected " + np + " permutations. Found " + resultsize);
        System.out.println("Just as expected, found " + np + " permutations");
        for (String p : permutations) {
            System.out.print(p + "\t");
        }
    }

    private static int numberOfPermutations(String word) {
        int np = 1;
        if (word !=  null) {
            int wordLen = word.length();
            for (int i = wordLen; i > 1; i--) {
                np = np * i;
            }
        } else {
            throw new IllegalArgumentException("Word must not be null");
        }
        return np;
    }
}

