package alg;

/**
 * Created by Vidya on 12/19/16.
 */
public class Numerology {

    public int addDigitsIterative(int num) {
        while (num > 9) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
        }
        return num;
    }


    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return(addDigits(num));
    }

    public static void main(String args[]) {
        Numerology numer = new Numerology();
        System.out.println(numer.addDigits(7) + " *7");
        System.out.println(numer.addDigits(0) + " *0");
        System.out.println(numer.addDigits(-23) + " *-23");
        System.out.println(numer.addDigits(Integer.MAX_VALUE) + " " + Integer.MAX_VALUE + "  *1");

        System.out.println(numer.addDigits(79) + " *7");
        System.out.println(numer.addDigits(385) + " *7");
    }
}
