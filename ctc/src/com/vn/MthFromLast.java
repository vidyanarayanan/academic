package com.vn;

import java.util.Iterator;
import java.util.LinkedList;

public class MthFromLast<E> {

    private static LinkedList<Integer>  list = new LinkedList<Integer>();

    private static void populateList(int n) {
        for (int i = 0; i < n; i++) {
            list.add((i+1) * 100);
        }
    }

    private static int getMthFromLast(int m) {

        Iterator<Integer> cur = list.iterator();
        Iterator<Integer> mthFromEnd = list.iterator();
        Integer result = null;

        if (list.size() < m+1) {
            throw new IndexOutOfBoundsException("Less than " + m + "elements");
        }

        for (int i=0; i< m && cur.hasNext(); i++) {
            cur.next();
        }

        while (cur.hasNext()) {
            result = mthFromEnd.next();
            cur.next();
        }

        return result;


    }


    public static void main(String[] args) {

        int n = Integer.valueOf(args[0]);
        int m = Integer.valueOf(args[1]);

        if (n-1 <= m) {
            throw new IllegalArgumentException("m must be less than n");
        }

        populateList(n);
        printList();
        System.out.println("The mth element from the end is " + getMthFromLast(m));

    }

    private static void printList() {
        for (Integer val : list) {
            int i = 1;
            System.out.print( i + "=" + val + " ");
        }
        System.out.println("");
    }
}
