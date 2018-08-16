package alg;

/**
 * Created by Vidya on 12/16/16.
 */
public class AddInt {

    public static int getSum0(int number, int addend) {

        while (addend != 0) {
            // first lets add the positions where the 1 bits are set differently
            number = number ^ addend;
            //This could just be the final answer if the numbers only had complementary bits set
            //.. but that is not always the case - find what common bits have been set for both
            //For those, the bitwise addition should result in a carryOver or a value of 10
            int carryOver = number & addend;
            // carryOver should now have the bit position where both are set to 1. At these positions,
            // the previous xor would have already given us a 0. We now need to shift the bit positions on the carryOver
            // to be able to add it back to the current sum - so shift the carryOver one position and repeat the process
            // until there is no carryOver
            addend = carryOver << 1;
        }
        return number;
    }

    public static void main(String args[]) {
        System.out.println("1+1= " + getSum(1, 1));
        System.out.println("1,2= " + getSum(1, 2));
        System.out.println("1,3= " + getSum(1, 3));
        System.out.println("1,4= " + getSum(1, 4));
        System.out.println("2,2= " + getSum(2,2));
        System.out.println("3,2= " + getSum(3,2));
        System.out.println("100,3= " + getSum(1, 1));
        System.out.println("5,-2 " + getSum(1, 1));

    }

    private static int getSum(int number, int addend) {

        while (addend != 0) {
            int carry = number & addend;
            number = number ^ addend;
            addend = carry << 1;

        }
        return number;
    }
}
