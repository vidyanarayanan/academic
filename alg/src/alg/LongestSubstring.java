package alg;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Vidya on 12/19/16.
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3.
 */
public class LongestSubstring {

    public int lengthOfLongestSubstringKDistinct(String input, int k) {
        int longest = 0;
        int left = 0; //leftmost in the streak;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        if (input != null) {
            for (int index = 0; index < input.length(); index ++) {
                char c = input.charAt(index);
                hm.put(c, hm.getOrDefault(c, 0) + 1 );
                while (hm.size() > k) {
                    char leftOfWindow = input.charAt(left);
                    if (hm.containsKey(leftOfWindow)) {
                        hm.put(leftOfWindow, hm.get(leftOfWindow) - 1 );
                        if (hm.get(leftOfWindow) == 0) {
                            hm.remove(leftOfWindow);
                        }
                    }
                    left++;
                }

                longest = Math.max(longest, index - left + 1);
            }
        }
        return longest;
    }



    private void addIfNotFound(char c, HashMap<Character, Integer> hm) {
        Integer n = hm.get(c);
        if (n == null) {
            hm.put(c, 1);
        } else {
            hm.put(c, n + 1);
        }

    }

    private void decreaseCount(char c, HashMap<Character, Integer> hm) {
        Integer n = hm.get(c);
        if (n == null || n == 1) {
            hm.remove(c);
        } else {
            hm.put(c, n - 1);
        }
    }

    public static void main(String args[]) {
//        String s = "ababffzzeee";
        String s = "aabbc8989898989aaaaaaaaaa999999999aahjkuioklhuokhipaaaaljlljkllfiiwerv";
        int k = 2;
        LongestSubstring ls = new LongestSubstring();
        System.out.println("longest with " + k + " uniq in " + s + ": " + ls.lengthOfLongestSubstringKDistinct(s, k));
    }




    /*
        public int lengthOfLongestSubstringKDistinctBak(String input, int k) {
        int longest = 0;
        if (input != null) {
            int strlen = input.length();
            for (int window = strlen; window > 0 ; window--) {
                for (int curStart = 0; curStart + window - 1 < strlen; curStart++) {
                    String cur = input.substring(curStart, window+curStart);
                    HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
                    for (int i = 0; i < cur.length(); i++) {
                        hm.put(cur.charAt(i), hm.getOrDefault(cur.charAt(i), 0) + 1);
                    }
                    if (k >= hm.size()) {
                        longest = Math.max(longest, cur.length());
                    }
                }
            }
        }
        return longest;
    }

     */


    public int lengthOfLongestSubstringKDistinctLC(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int best = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                }
                left++;
            }
            best = Math.max(best, i - left + 1);
        }
        return best;
    }
}

