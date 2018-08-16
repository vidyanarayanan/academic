package alg;

import java.util.HashMap;

/**
 * Created by Vidya on 12/18/16.
 */
public class RomanToInteger {

    static HashMap<Character, Integer> rtoi = new HashMap<Character, Integer>();

    public static int romanToInt(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        s = s.trim().toUpperCase();
        rtoi.put('I', 1);
        rtoi.put('V', 5);
        rtoi.put('X', 10);
        rtoi.put('L', 50);
        rtoi.put('C', 100);
        rtoi.put('D', 500);
        rtoi.put('M', 1000);

        char ca[] = s.toCharArray();
        int result = 0, prev = 0;

        for (int i = ca.length -1; i >= 0; i--) {
            int t = rtoi.getOrDefault(ca[i], 0);
            if (t == 0) {
                return t;
            }
            if (t >= prev) {
                result += t;
            } else {
                result = result - t;
            }
            prev = t;
        }
        return result;

    }

    public static void main(String args[]) {
        System.out.println(romanToInt("MMMCMXCIX"));
        System.out.println(romanToInt("MCIX"));
        System.out.println(romanToInt("MCMLXIX"));
        System.out.println(romanToInt("MMXVII"));
        System.out.println(romanToInt("MXLVIII"));

        System.out.println(romanToInt("XV"));
        System.out.println(romanToInt("N"));
        System.out.println(romanToInt("ZV"));
        System.out.println(romanToInt(""));
    }

}
