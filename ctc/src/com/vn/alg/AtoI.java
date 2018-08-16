package com.vn.alg;

/**
 * Created by Vidya on 1/3/17.
 */
public class AtoI {

    public static int atoi(String number) {
        char[] nums = number.toCharArray();
        int sign = 1;
        double total = 0;
        for (int i = 0 ; i < nums.length; i++) {
            if (i == 0 && nums[i] == '-') {
                sign = -1;
            } else {
                total*= 10;
                total += nums[i];
            }
        }
        return (int) (total * sign);
    }

    public static void main(String args[]) {
        System.out.println(Integer.toString(2345));
        System.out.println(Integer.toString(-2345));
        System.out.println(Integer.toString(12345));
        System.out.println(Integer.toString(Integer.MAX_VALUE));
        System.out.println(Integer.toString(Integer.MIN_VALUE));
    }
}
