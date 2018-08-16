package com.vn;

import com.vn.ds.PossiblyCyclicalList;

/**
 * Created by Vidya on 12/7/16.
 */
public class CycleChecker<E> {

    public static void main(String[] args) {

        int n = Integer.valueOf(args[0]);
        int cycleTo = -1;
        if (args.length == 2) {
            cycleTo = Integer.valueOf(args[1]);
        }
        if (cycleTo >= n ) {
            throw new IllegalArgumentException(cycleTo + " must be less than " + n);
        }

        PossiblyCyclicalList<Integer> list = new PossiblyCyclicalList();

        for (int i = 0; i < n; i++) {
            Integer v = new Integer((i+1) * 10);
            list.add(v);
        }

        if (cycleTo >= 0) {
            list.cycleBackTo(cycleTo);
        }

        list.printList();
        System.out.println(list.checkCycle()? "The list has a cycle" : "Great, no cycle found");

    }
}
