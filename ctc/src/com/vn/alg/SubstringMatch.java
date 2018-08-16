package com.vn.alg;

/**
 * Created by Vidya on 1/3/17.
 */
public class SubstringMatch {

    private int[] preprocessPattern(String pattern) {
        char[] chars = pattern.toCharArray();
        int[] indexTable = new int[chars.length];
        int p = 0;
        for (int i = 1 ; i < chars.length; i++) {
            if (chars[p] == chars[i]) {
                p++;
                indexTable[i] = p;
            } else {
                if (p == 0) {
                    indexTable[i] = p;
                } else {
                    p = indexTable[i - 1];
                    i--;
                }
            }

        }
        return indexTable;

    }


    private boolean findPattern(String text, String pattern) {
        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int[] piTable = preprocessPattern(pattern);
        int p = 0;
        boolean found = false;
        for (int i =  0; i < textChars.length && p < patternChars.length; i++) {
            if (textChars[i] == patternChars[p]) {
                if (p == patternChars.length) {
                    found = true;
                }
                p++;
            } else {
                if (p != 0) {
                    p = piTable[p - 1];
                    i--;
                }

            }

        }
        return found;

    }
}
