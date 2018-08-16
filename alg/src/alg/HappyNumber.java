package alg;

import java.util.HashSet;

/**
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the
 * number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * <p>
 * Those numbers for which this process ends in 1 are happy numbers.
 * Example: 19 is a happy number
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {


    public boolean isHappy(int n) {
        boolean happy = false;
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);

        while (n != 1 && n > 0) {
            int happySum = 0;
            while (n > 0) {
                happySum += Math.pow((n % 10), 2);
                n = n / 10;
            }
            n = happySum;
            if (set.contains(n)) {
                //we have seen this before, it is going to lead to an infinite loop
                break;
            }
            set.add(n);
        }
        return happy || n == 1;
    }



/*
2 4 => Not happy
3 9 => 81
4 16 1 + 36 = 37 = 9+49 = 58 = 25 + 64 = 89 64 + 81 = 145 = 1 + 16 + 25 = 42  16 + 4 = 20 4 + 0 = 4 => Not happy
6 36
7 49
8 64
9 81
10
 */

    public static void main(String args[]) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(0) + ": 0");
        System.out.println(hn.isHappy(100) + ": 100");
        System.out.println(hn.isHappy(19) + ": 19");
        System.out.println(hn.isHappy(28) + ": 28");
        System.out.println(hn.isHappy(25) + ": 25");
        System.out.println(hn.isHappy(4) + ": 4");

    }
}