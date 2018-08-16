package alg;


/**
 * Created by i841928 on 12/18/16.
 */
public class NumberOfOneBits {

    public static int hammingWeight(int n) {
        if (n < 0) {
            return -1;
        }
        int ones = 0;
        while (n != 0) {
            ones = ones + (n & 1);
            n = n >>1;
        }
        return ones;

    }

    public static int numberOfOnes(int n) {
        int ones = 0;
        while (n > 0) {
            ones += n & 1;
            n >>= 1;
        }
        return ones;
    }

    public static void main(String args[]) {
        print(0);
        print(5);
        print(20);
        print(15);
        print(Integer.MAX_VALUE);
        print(Integer.MAX_VALUE - 2);
        print(Integer.MAX_VALUE - 5);

    }

    public static void print(int n) {
        System.out.println(n + " " + Integer.toBinaryString(n) + " " + hammingWeight(n) + " " + numberOfOnes(n));
    }
}
