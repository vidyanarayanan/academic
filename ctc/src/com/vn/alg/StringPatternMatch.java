package com.vn.alg;

/**
 * Uses KMP Knuth-Morris-Pratt algorithm
 */
public class StringPatternMatch {


    /**
     * Create a state machine representing the pattern using KMP-algorithm
     * @param pattern
     * @return
     */
    private static int[] processPattern(String pattern) {

        int[] piTable = new int[pattern.length()];
        char[] array = pattern.toCharArray();

        for (int i = 1, p = 0; i < array.length; i++) {
            if (array[p] == array[i]) {
                piTable[i] = p + 1;
                p++;
            } else {
                if (p != 0) {
                    p = piTable[p - 1];
                    i--;
                } else {
                    piTable[i] = 0;
                }
            }
        }
        return piTable;
    }

    private static boolean containsPattern(String text, String pattern) {
        boolean found = false;
        int[] piTable = processPattern(pattern);
        char[] patternChars = pattern.toCharArray();
        char[] chars = text.toCharArray();
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == patternChars[k]) {
                if (k == patternChars.length -1) {
                    //we found a match
                    found = true;
                    break;
                }
                k++;
            } else {
                if (k != 0 ) { //we have found some prefix that matched
                    k = piTable[k - 1];
                    i--; //Dont backtrack, stay at i
                }
            }
        }
        return found;
    }

    public static void testPreprocessing() {
        int[] piTable;
//        piTable = processPattern("abcabd");
//        piTable = processPattern("abcabd");

        piTable = processPattern("abcdabca");
        System.out.println("Expected 0 0 0 0 1 2 3 1 ");
        System.out.println("   Found " + printArray(piTable));

        piTable = processPattern("abcde");
        System.out.println("Expected 0 0 0 0 0 ");
        System.out.println("   Found " + printArray(piTable));

        piTable = processPattern("AAACAAAAAC");
        System.out.println("Expected 0 1 2 0 1 2 3 3 3 4 ");
        System.out.println("   Found " + printArray(piTable));


        piTable = processPattern("AABAACAABAA");
        System.out.println("Expected 0 1 0 1 2 0 1 2 3 4 5 ");
        System.out.println("   Found " + printArray(piTable));

        piTable = processPattern("AAABAAA");
        System.out.println("Expected 0 1 2 0 1 2 3");
        System.out.println("   Found " + printArray(piTable));

        piTable = processPattern("aabaabaaa");
        System.out.println("Expected 0 1 0 1 2 3 4 5 2");
        System.out.println("   Found " + printArray(piTable));

        piTable = processPattern("abcaby");
        System.out.println("Expected 0 0 0 1 2 0");
        System.out.println("   Found " + printArray(piTable));

    }

    private static String printArray(int[] indexes) {
        StringBuilder sb = new StringBuilder();
        for (int i : indexes) {
            sb.append(i + " ");
        }
        return(sb.toString());
    }

    public static void main(String args[]) {
        testPreprocessing();
        System.out.println(containsPattern("abxabcabcaby", "abcaby"));
        System.out.println(containsPattern("abxabcabcaby", "abcabyz"));
    }
}
