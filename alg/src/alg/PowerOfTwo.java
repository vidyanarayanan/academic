package alg;

/**
 * Created by Vidya on 12/15/16.
 */
public class PowerOfTwo {

    static final int MAX2POWERINT = (int) Math.pow(2,30);

    public boolean isPowerOfTwoRecursive(int n) {
        if (n == 1 || n == 2) {
            return true;
        } else if (n == 0 || n % 2 != 0) {
            return false;
        } else {
            return isPowerOfTwoRecursive(n / 2);
        }
    }

    public boolean isPowerOfTwoModulusOperation(int n) {
        return ((n > 0) && (MAX2POWERINT % n ==0));
    }

    public boolean isPowerOfTwo(int n) {
        return ((n & (n -1)) == 0);
    }


    public static void main(String inputs[]) {
        PowerOfTwo p = new PowerOfTwo();
        System.out.println(" 10 " + p.isPowerOfTwo(10));
        System.out.println(" 1 " + p.isPowerOfTwo(1));
        System.out.println(" 2 " + p.isPowerOfTwo(2));
        System.out.println(" 5 " + p.isPowerOfTwo(5));
        System.out.println(" 32 " + p.isPowerOfTwo(32));
        System.out.println(" 3090 " + p.isPowerOfTwo(3090));
        System.out.println(" -2 " + p.isPowerOfTwo(-2));
        System.out.println(" 2^30 " + MAX2POWERINT + " " + p.isPowerOfTwo(MAX2POWERINT));
        System.out.println(" MAX VAL " + Integer.MAX_VALUE + " " + p.isPowerOfTwo(Integer.MAX_VALUE));

    }
}
