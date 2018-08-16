package com.vn.alg.bit;

/**
 * Created by i841928 on 12/30/16.
 */
public class BinaryDecimal {

    public static String toBinaryFraction(double r) {
        if (r > 1) {
            return "error";
        }
        StringBuilder s = new StringBuilder("0.");
        while (r > 0) {
            double d = r * 2;
            if (d >= 1) {
                s.append('1');
                r = d - 1;
            } else {
                s.append('0');
                r = d;
            }

            if (s.length() == 32) {
                break;
            }
        }

        return s.toString();
    }

    public static void main(String args[]) {
            System.out.println("hello");
            System.out.println(toBinaryFraction(0.5));
        System.out.println(toBinaryFraction(0.625));
        System.out.println(toBinaryFraction(0.1));
    }
}
