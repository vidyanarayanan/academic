package alg;

/**
 * Created by Vidya on 12/25/16.
 */
public class NthDigit {


    public int findNthDigit(int n) {
        int result = n;
        if (n > 9) {
            int digs = 0, ntimes = 0;
            //given n, can I find out the range (1s, 10s, etc)
            for (int i = n; i > 0; i /= 10) {
                ntimes++;
            }
            double numStart = 1, numEnd = 9, digRangeStart = 1, digRangeEnd = 9;

            for (int i = 2; i <= ntimes; i++) {
                digs = i;
                numStart = Math.pow(10, i - 1);
                digRangeStart = digRangeEnd + 1;
                digRangeEnd = digRangeStart + (9 * i * numStart) - 1;
                if ((n >= (int) digRangeStart) && (n <= (int) digRangeEnd)) {
                    break;
                }
            }

            int gap = (int) (n - digRangeStart) / digs;
            int num = (int) numStart + gap;
            double start = digRangeStart + (gap * digs);
            int pos = (int) (n - start);
            String s = Integer.toString(num);
            System.out.println("pos " + pos + " str " + s + " gap was" + gap + " start of num ");
            result = s.charAt(pos) - '0';
        }
        return result;
    }




    public int findNthDigitLC(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        System.out.println(s);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }


    public static void main(String args[]) {
        NthDigit n = new NthDigit();
        System.out.println(" 10th digit " + n.findNthDigit(10));
        System.out.println(" 15th digit " + n.findNthDigit(15));
        System.out.println(" 20th digit " + n.findNthDigit(20));
        System.out.println(" 23rd digit " + n.findNthDigit(23));
        System.out.println(" 190th digit " + n.findNthDigit(190));
        System.out.println(" 2890th digit " + n.findNthDigit(2890));
        System.out.println(" 5888889 digit " + n.findNthDigit(5888889));
        System.out.println(" 999999999 digit " + n.findNthDigit(999999999));

        //999999999
    }
}
