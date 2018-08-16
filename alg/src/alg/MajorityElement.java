package alg;

import java.util.HashMap;

/**
 * Created by Vidya on 12/18/16.
 */
public class MajorityElement {

    public static int majorityElementSimple(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int maxCount = 0;
        Integer majority = null;

        for (int i = 0; i < nums.length; i++) {
            Integer temp = hm.get(nums[i]);
            if (temp == null) {
                temp = 1;
            } else {
                temp++;
            }
            hm.put(nums[i], temp);
            if (temp >= maxCount) {
                maxCount = temp;
                majority = nums[i];
            }

            if (temp > nums.length / 2) {
                break;
            }
        }

        if (majority == null) {
            majority = 0;
        }
        return (int) majority;
    }


    public static int majorityElement(int[] nums) {
        int majority = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++){
            if (count == 0) {
                count ++; //we have a new majority
                majority = nums[i];
            } else if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }

        }
        return majority;
    }

    public static void main(String args[]) {
        int inp[] = {1, 2, 2,1,1,1,3,3,3,3,3,3,1,1,1,1,1,1,1,1};
        System.out.println(majorityElement(inp));
    }

}
