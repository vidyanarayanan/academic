package alg;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Vidya on 12/19/16.
 */
public class Palindrome {
    public boolean canPermutePalindromeNaive(String s) {
        int foundOdd = 0;
        if (s == null) {
            foundOdd = 100;
        } else {
            s = s.toUpperCase();
            char[] array = s.toCharArray();
            HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
            for (int i = 0; i < array.length; i++) {
                hm.put(array[i], hm.getOrDefault(array[i], 0) + 1);
            }
            for (Character character : hm.keySet()) {
                int count = hm.get(character);
                if (count % 2 == 1) {
                    foundOdd++;
                }
                if (foundOdd > 1) {
                    break;
                }
            }
        }
        return foundOdd <= 1;
    }

    public boolean canPermutePalindrome(String s) {
        boolean hasPalindrome = false;
        if (s != null) {
            char[] array = s.toCharArray();
            HashSet<Character> set = new HashSet();
            for (int i = 0; i < array.length; i++) {
                if (set.contains(array[i])) {
                    set.remove(array[i]);
                } else {
                    set.add(array[i]);
                }
            }
            hasPalindrome = (set.size() <= 1);
        }
        return hasPalindrome;
    }

    public static void main(String args[]) {
        Palindrome pal = new Palindrome();
        System.out.println(pal.canPermutePalindrome("code") + " (Expected: False)");
        System.out.println(pal.canPermutePalindrome("aab") + " (Expected: True)");
        System.out.println(pal.canPermutePalindrome("carerac") + " (Expected: True)");
        System.out.println(pal.canPermutePalindrome("baba") + " (Expected: True)");
    }
}
