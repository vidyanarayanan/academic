package alg;

import java.util.HashMap;

/**
 * Created by Vidya on 12/18/16.
 */
public class ValidWordAbbr {
    String[] dictionary;
    HashMap<String, Boolean> abbrevMap = new HashMap<String, Boolean>();

    public ValidWordAbbr(String[] dictionary) {
        this.dictionary = dictionary;

        if (dictionary != null) {
            for (int i = 0 ; i < dictionary.length; i ++) {
                String abbrev = abbreviate(dictionary[i]);
                Boolean uniq = abbrevMap.get(abbrev);
                if (uniq == null) {
                    abbrevMap.put(abbrev, Boolean.TRUE);
                } else {
                    abbrevMap.put(abbrev, Boolean.FALSE);
                }
            }
        }
    }

    private String abbreviate(String word) {
        word = word.trim().toLowerCase();
        int length = word.length();
        if (length > 2) {
            StringBuilder abbrev = new StringBuilder();
            abbrev.append(word.charAt(0));
            abbrev.append(length - 2);
            abbrev.append(word.charAt(length - 1));
            return abbrev.toString();
        } else {
            return word;
        }
    }

    public boolean isUnique(String word) {
        String abbrev = abbreviate(word);
        Boolean matched = abbrevMap.get(abbrev);
        boolean uniq = (matched == null) || matched;
        return uniq;
    }


    public static void main(String args[]) {
        String[] dict = {"deer", "door", "cake", "card", "", "it", "dig" };
//        String[] dict = {"deer"};
        ValidWordAbbr vwa = new ValidWordAbbr(dict);
        System.out.println(vwa.isUnique("cate"));
    }
}
