package com.vn.alg;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vidya on 1/2/17.
 */
public class PairWithSumEquals {

    public static  boolean hasPairWithSum(int data[], int sum) {

        Set<Integer> set = new HashSet<Integer>();
        boolean found = false;
        if (data.length > 1) {
            set.add(data[0]);
            for (int i = 1; i < data.length && !found; i++) {
                int pair = sum - data[i];
                if (set.contains(pair)) {
                    found = true;
                } else {
                    set.add(data[i]);
                };

            }
        }
        return found;
    }


    public static void main(String args[]) {
        int input[] = {-1,7,2,5,9,3,8};
        int sum = 6;
        System.out.println(hasPairWithSum(input,sum));

    }

}
