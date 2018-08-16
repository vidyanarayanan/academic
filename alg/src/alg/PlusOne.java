package alg;

/**
 * Created by Vidya on 12/15/16.
 */
public class PlusOne {


    public static int[] plusOne(int[] digits) {
        int res[] = new int[digits.length]; //unless there is an overflow
        for (int i = digits.length -1; i >= 0; i--) {
            if (digits[i] > 9 || digits[i] < 0) {
                throw new IllegalArgumentException("Valid digits are 0 to 9");
            }
            res[i] = digits[i]+1;
            if (res[i] > 9) {
                if (i == 0) {
                    System.arraycopy(res, 0, res, 1, i);
                    res[i] = 0;
                    res[0] = 1;
                } else {
                    res[i] = 0;
                }
            } else {
                System.arraycopy(digits, 0, res, 0, i);
                break;
            }
        }

        return res;
    }

    public static int[] plusOneNaive(int[] digits) {
        boolean overflow = true;
        boolean done = false;
        int[] res; //= new int[length];

        int length = digits.length;
        if (digits == null || length == 0) {
            return digits;
        }
        int index;
        for(index = length -1; !done && overflow && index >= 0; index --) {
            if (digits[index] < 0 || digits[index] > 9) {
                throw new IllegalArgumentException("Digit must be +ve and must not be > 9");
            }
            if (digits[index] < 9) {
                if (!overflow || index != length - 1) {
                    digits[index] += 1;
                    done = true;
                    overflow = false;
                } else if (overflow) {
                    if (digits[index] < 9) {
                        digits[index] += 1;
                        done = true;
                        overflow = false;
                    } else if (digits [index] == 9 ) {
                        digits[index] = 1;
                        done = false;
                        overflow = true;
                    } else {
                        throw new IllegalArgumentException("Digit must not be > 9");
                    }
                    //overflow in the prev digit


                }
            } else if (digits [index] == 9 ) {
                digits[index] = 0;
                done = false;
                overflow = true;

            } else {
                throw new IllegalArgumentException("Digit must not be > 9");
            }


        }
        if (!done && overflow) {
            res = new int[length + 1];
            res[0] = 1;
            for (int i = 1; i <= length; i ++) {
                res[i] = 0;
            }
        } else {
            res  = digits;
        }

        return res;
    }

    public static void main(String args[]) {
        int inputs[] = {9,8, 9,9, 9};
        int result[] = plusOne(inputs);
        for (int i =0; i < result.length; i++) {
            System.out.print(result[i]);
        }

    }

}
