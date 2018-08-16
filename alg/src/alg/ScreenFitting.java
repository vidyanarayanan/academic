package alg;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Vidya on 12/22/16.
 */
public class ScreenFitting {


    public int wordsTyping(String[] words, int rows, int cols) {
        String sentence = String.join(" ", words) + " ";
        char s[] = sentence.toCharArray(); //circular sentence
        int pos = 0;
        int length = sentence.length();
        for (int i = 0; i < rows; i++) {
            pos += cols;
            if (s[pos % length] ==  ' ') {
                pos++;
            } else {
                while (pos > 0 && (s[(pos - 1) % length] != ' ')) {
                    pos--;
                }
            }
        }
        return pos / length;
    }

    public int wordsTypingLC(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }

        return start / s.length();
    }

    public static void main(String args[]) {
        ScreenFitting sf = new ScreenFitting();
        String sentence[] = {"hello", "world"};
        System.out.println(sf.wordsTyping(sentence, 2, 8) + " expected 1");
        String sentence2[] = {"I", "had", "apple", "pie"};
        System.out.println(sf.wordsTyping(sentence2, 4, 5));
        String sentence3[] = {"a", "bcd", "e"};
        System.out.println(sf.wordsTyping(sentence3, 3, 6));
        String sentence4[] = {"f", "p", "a"};
        System.out.println(sf.wordsTyping(sentence4, 8, 7) + " expected 10");
        System.out.println(sf.wordsTyping(sentence4, 3, 1) + " expected 1");
        String sentence5[] = {"f", "pqr", "a"};
        System.out.println(sf.wordsTyping(sentence5, 4, 6) + " expected 2") ;

    }
}
