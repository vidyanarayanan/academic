package alg;

/**
 * String To Integer -  12/15/16.
 */
public class StringToInteger {
    static final int ZER0 = (int) '0';
    static final int MAXINT = 2147483647;
    static final int MININT = -2147483648;


    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        // Initialize
        double result = 0;
        int sign = 1;
        str = str.trim();

        if  (str.charAt(0) == '-') {
            sign = -1;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }

        int length = str.length();

        for (int i = 0; i < length ; i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                str = str.substring(0, i);
                length = str.length();
                break;
            }
        }

        double base = Math.pow(10, length -1);
        if (base > MAXINT) {
            return (sign == -1) ? MININT : MAXINT;
        }

        for (int i = 0; i < length ; i++) {
            char c = str.charAt(i);
            int curPlace = c - ZER0;

            try {
                curPlace *= base;
                base /= 10;
                result += curPlace;
            } catch (NumberFormatException nfe) {
                return (sign == -1) ? MININT : MAXINT;
            }
        }

        result *= sign;

        if ((sign == -1) && (result < MININT)) {
            return MININT;
        } else if ((sign == 1) && (result > MAXINT)) {
            return MAXINT;
        }

        return (int) (result);
    }

    public static void main(String args[]) {
        StringToInteger s = new StringToInteger();
        String[] inputs  = { "0", "-9090", "9ty","-123", "123","4294967296", "-2147483649", " 98 ", "+1", "-", "\t-11919730356x", "\n \t20", "\t-1919730356x", "  -11919730356x"};
//        String[] inputs  = {"\t-11919730356x", "  -11919730356x"};
        for (String input : inputs) {
            System.out.println(input + " : " + s.myAtoi(input));
        }
    }
 }

