package alg;

/**
 * Created by Vidya on 1/23/17.
 */
public class IntegerToBinary {

    public static String intToBinary(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num % 2 == 0) {
                sb = new StringBuilder("0").append(sb);
            } else {
                sb = new StringBuilder("1").append(sb);
            }
            num /= 2;
        }
        return sb.toString();
    }

    public static String intCompliment(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num % 2 == 1) {
                sb = new StringBuilder("0").append(sb);
            } else {
                sb = new StringBuilder("1").append(sb);
            }
            num /= 2;
        }
        return sb.toString();
    }

    public static int binaryToInt(String binary) {
        int num = 0;
        if (binary != null) {
            int l = binary.length();
            if (l <= 31) {
                char bin[] = binary.toCharArray();
                int multiplier = 1;
                for (int i = l; i > 0; i--) {
                    int n = bin[i - 1] - '0';
                    num += (n * multiplier);
                    multiplier *= 2;
                }
            }
        }
        return num;
    }


    public static int findComplementIntArray(int num) {
        int[] comp = new int[31];
        int l = 0;
        while (num > 0) {
            comp[l++] = (num % 2 == 0) ? 1: 0;
            num/= 2;
        }
        int complement = 0;
        int twoPower = 1;
        for (int i = 0; i < l; i++) {
            complement += comp[i] * twoPower;
            twoPower *= 2;
        }
        return complement;
    }

    public static  int findComplementNaive(int num) {

        StringBuilder binary = new StringBuilder();
        while (num > 0) {
            if (num % 2 == 0) {
                binary = new StringBuilder("1").append(binary);
            } else {
                binary = new StringBuilder("0").append(binary);
            }
            num/= 2;
        }

        int l = binary.length();

        int complement = 0;
        int twoPower = 1;
        for (int i = l; i > 0; i--) {
            String t = binary.substring(i -1, i);
            if ("1".equals(t)) {
                complement += twoPower;
            }
            twoPower *= 2;
        }

        return complement;

    }

    public static int findComplement (int num) {
        return   num ^ ((Integer.highestOneBit(num) << 1) - 1);
    }


        public static void main(String args[]) {

        System.out.println(findComplement(5));
        System.out.println(findComplement(Integer.MAX_VALUE));
            System.out.println(findComplement(8));
    }
}
