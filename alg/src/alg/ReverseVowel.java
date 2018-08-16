package alg;

/**
 * Created by Vidya on 12/25/16.
 */
public class ReverseVowel {
    public String reverseVowels(String s) {
        String result = s;
        if (s != null && s.length() > 0) {
            StringBuilder vowels = new StringBuilder();
            char[] word = s.toCharArray();
            int[] pos = new int[word.length];
            for(int i = word.length - 1, j=0; i >= 0; i --) {
                char lower = Character.toLowerCase(word[i]);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    vowels.append(word[i]);
                    pos[j++] = i;
                }
            }
            char[] v = vowels.toString().toCharArray();

            for (int i = 0, j = v.length - 1; i < v.length; i++, j--) {
                word[pos[i]] = v[j];
            }

            result = new String(word);
        }
        return result;

    }

    public static void main(String args[]) {
        ReverseVowel r = new ReverseVowel();
        System.out.println(r.reverseVowels("hello") + " expected=>holle");
        System.out.println(r.reverseVowels("thy") + " expected=>thy");
        System.out.println(r.reverseVowels("thyme") + " expected=>thyme");
        System.out.println(r.reverseVowels("hymn") + " expected=>hymn");
        System.out.println(r.reverseVowels("rhythm") + " expected=>rhythm");
        System.out.println(r.reverseVowels("rice") + " expected=>reci");
        System.out.println(r.reverseVowels("sharat") + " expected=>sharat");
        System.out.println(r.reverseVowels("abba") + " expected=>abba");
    }
}
