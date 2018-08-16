package alg;

import java.util.ArrayList;

/**
 * Created by Vidya on 12/15/16.
 */

public class MovingAverage {
    int windowSize;
    ArrayList<Integer> list = new ArrayList<Integer>();

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        if (size <= 0) {
            size = 1;
        }
        this.windowSize = size;
    }

    public double next(int val) {
        list.add(val);
        return getAverage();
    }

    private double getAverage() {
        double sum = 0.0;
        int divisor = 0;
        for (int i = list.size() - 1; i >= 0 && divisor < windowSize ; i--) {
            System.out.print(" " + list.get(i) + " ");
            sum += list.get(i);
            divisor++;
        }

        return sum / divisor;
    }

    public static void main(String args[]) {
        MovingAverage m = new MovingAverage(3);
        System.out.println("\n1  " + m.next(1)); //= 1
        System.out.println("\n10 " + m.next(10)); // = (1 + 10) / 2
        System.out.println("\n3 " + m.next(3)); // = (1 + 10 + 3) / 3
        System.out.println("\n5 " + m.next(5)); // = (10 + 3 + 5) / 3
        System.out.println("\n4 " + m.next(4)); // = (3 + 5 + 4) / 3
        System.out.println("\n4 " + m.next(-1)); // = (3 + 5 + 4) / 3
    }

}

