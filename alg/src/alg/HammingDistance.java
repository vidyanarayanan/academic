package alg;

/**
 * Created by Vidya on 12/18/16.
 */
public class HammingDistance {

    public static int hammingDistanceNoBinaryOperation(int x, int y) {
        int diff = 0;
        for (int i = 31; i >= 0; i --) {
            int xbin = (x % 2 == 0)  ? 0 : 1;
            int ybin = (y % 2 == 0)  ? 0 : 1;
            if (xbin != ybin) {
                diff ++;
            }
            x = x / 2;
            y = y / 2;
        }
        return (diff);
    }

    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int diff = 0;
        while (xor != 0) {
           diff += xor & 1;
           xor = xor >> 1;
        }
        System.out.println(Integer.toBinaryString(diff));
        return (diff);
    }


    public static void main(String args[]) {
        print(2, 4);
        print(1,3);
        print(27,39);
        print(Integer.MAX_VALUE,0);

    }


    public static void print(int i, int j) {
        System.out.println(i + " " + j);
        StringBuilder s;
        s = new StringBuilder(Integer.toBinaryString(i));
        while (s.length() < 32) {
            s.insert(0, "0");
        }
        System.out.println(s);
        s = new StringBuilder(Integer.toBinaryString(j));
        while (s.length() < 32) {
            s.insert(0, "0");
        }
        System.out.println(s);

        System.out.println(hammingDistance(i, j));
    }

}
