package alg.nestedint;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 12/15/16.
 * 339. Nested List Weight Sum
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 * Example 2:
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 */
public class NestedListWeightedSum {


    public int depthSum(List<NestedInteger> nl) {
        int level = 1;
        int sum = 0;

        if (nl != null) {
            sum = getSum(nl, 1, 0);
        }
        return sum;
    }

    private int getSum(List<NestedInteger> nl, int level, int sum) {

        for (NestedInteger ni : nl) {
            if (ni.isInteger()) {
                sum += (ni.getInteger() * level);
            }  else {
                level ++;
                List<NestedInteger> childList = ni.getList();
                sum = getSum(childList, level, sum);
                level--;
            }

        }
        return sum;
    }

    public static void main(String args[]) {
        String input = "[[1,1, [3]],2,[1,1]]";
        int l = input.length();

        List<NestedInteger> lni = new ArrayList<NestedInteger>();
        List<Integer> li = new ArrayList<Integer>();
        Integer val = Integer.valueOf(1);
        li.add(val);
        val = Integer.valueOf(1);
        li.add(val);
        val = Integer.valueOf(3);
        li.add(val);

        NestedInt ni = new NestedInt(li, true);
        NestedInt ni2 = new NestedInt(Integer.valueOf(2));

        val = Integer.valueOf(1);
        li = new ArrayList<Integer>();
        li.add(val);
        val = Integer.valueOf(1);
        li.add(val);

        val = Integer.valueOf(2);
        NestedInt two = new NestedInt(2);
        List<NestedInteger> listOfTwo = new ArrayList<NestedInteger>();
        listOfTwo.add(two);
        NestedInteger singularList = new NestedInt(listOfTwo);


        NestedInt ni3 = new NestedInt(li, true);

        ni3.add(singularList);

        lni.add(ni);
        lni.add(ni2);
        lni.add(ni3);

        NestedListWeightedSum nl = new NestedListWeightedSum();
        System.out.println("depth sum = " + nl.depthSum(lni));

    }



    private static class NestedInt implements NestedInteger {

        Integer integer;
        List<NestedInteger> list;

        NestedInt(List<NestedInteger> list) {
            this.integer = null;
            this.list = list;
        }

        NestedInt() {
            this.integer = null;
            this.list = new ArrayList<NestedInteger>();
        }

        NestedInt(Integer integer) {
            this.integer = integer;
            this.list = null;
        }

        NestedInt(List<Integer> l, boolean isInteger) {
            if (isInteger) {
                this.list = new ArrayList<NestedInteger>();
                for (Integer i : l) {
                    NestedInteger ni = new NestedInt(i);
                    list.add(ni);
                }
                this.integer = null;
            }
        }

        @Override
        public boolean isInteger() {
            return (integer != null);
        }

        @Override
        public Integer getInteger() {
            return integer;
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }

        public void add(NestedInteger ni) {
            this.list.add(ni);
        }

        public void print() {
            if (this.integer != null) {
                System.out.print(integer + ", ");
            } else if (list != null) {

                for (int i = 0; i < list.size(); i++) {
                    if (i == 0) {
                        System.out.print(" [ ");
                    }
                    NestedInteger ni = list.get(i);
                    ((NestedInt) ni).print();
                    if (i == list.size() - 1) {
                        System.out.print("] ");
                    }

                }
            }
        }
    }

}