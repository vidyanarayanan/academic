package alg;

/**
 * Created by Vidya on 12/16/16.
 */
public class StringReversal {


    public static String reverseString(String input) {
        if (input == null) {
            return null;
        }
        int l = input.length();
        if (l == 0) {
            return "";
        }
        char[] output = new char[l];
        for (int i = 0; i < input.length(); i++) {
            output[i] = input.charAt(l - i - 1);
        }
        return new String(output);
    }

    public static void main(String a[]) {
        System.out.println(reverseString("hello"));
        System.out.println(reverseString(null));
        System.out.println(reverseString(""));
        System.out.println(reverseString("nitin"));

    }
}
