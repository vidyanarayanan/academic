package alg;

import java.util.HashMap;

/**
 * Created by Vidya on 12/18/16.
 */
public class Strobogrammatic {

    public boolean isStrobogrammatic(String num) {
        if (num == null) {
            return false;
        }
        int length = num.length() - 1;
        boolean isStrobogrammatic = true;

        for (int left = 0,  right = length; left <= right && isStrobogrammatic; left++, right--) {
            if (left == right) {
                isStrobogrammatic = ("018".indexOf(num.charAt(left)) >= 0);
            } else {
                char j = num.charAt(left);
                char k = num.charAt(right);
                char jPair = getPair(j);
                char kPair = getPair(k);
                if (jPair == ' ' || kPair == ' ') {
                    isStrobogrammatic = false;
                } else {
                    isStrobogrammatic = (jPair == k);
                }
            }
        }

        return isStrobogrammatic;

    }

    private char getPair(char i) {
        char pair = ' ';
        switch (i) {
            case '6':
                pair = '9';
                break;
            case '9':
                pair = '6';
                break;
            case '8':
                pair = '8';
                break;
            case '0':
                pair = '0';
                break;
            case '1':
                pair = '1';
        }
        return pair;
    }

    public static void main(String args[]) {
        Strobogrammatic s = new Strobogrammatic();

        System.out.println(s.isStrobogrammatic("8"));
        System.out.println(s.isStrobogrammatic("808"));
        System.out.println(s.isStrobogrammatic("608"));
        System.out.println(s.isStrobogrammatic("77608"));
        System.out.println(s.isStrobogrammatic("60109"));
        System.out.println(s.isStrobogrammatic("6009"));
        System.out.println(s.isStrobogrammatic("60809"));
        System.out.println(s.isStrobogrammatic("6018109"));
        System.out.println(s.isStrobogrammatic("6016109"));

    }
}
