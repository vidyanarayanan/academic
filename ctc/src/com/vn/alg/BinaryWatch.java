package com.vn.alg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Vidya on 1/2/17.
 */
public class BinaryWatch {

    public static List<String> readBinaryWatch(int num) {
        ArrayList<String> list = new ArrayList<>();
        for (int hour = 0; hour <12; hour++) {
            for (int min = 0; min <= 59; min++) {
                if (Integer.bitCount(hour) + Integer.bitCount(min) == num) {
                    list.add(String.format("%d:%02d", hour, min));
                }
            }
        }
        return list;

    }


    public static void main(String args[]) {


        print(readBinaryWatch(1), 1);
        print(readBinaryWatch(2), 2);
        print(readBinaryWatch(3), 3);
        print(readBinaryWatch(4), 4);
        print(readBinaryWatch(5), 5);
        print(readBinaryWatch(6), 6);
        print(readBinaryWatch(7), 7);
        print(readBinaryWatch(8), 8);
        print(readBinaryWatch(9), 9);

/*

["0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"]

 */

    }


    private static void print(List<String> list, int i) {
        System.out.println("== "+ i + " ==");

        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println("====");
    }
}
