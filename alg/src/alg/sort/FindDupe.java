package alg.sort;

/**
 * Created by i841928 on 2/2/17.
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindDupe {


    public static int findDuplicate(int[] nums) {

        int expectedSum = nums.length * (nums.length - 1) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return (sum - expectedSum);

    }


    public static void main(String args[]) {

        int array[] = {1,2,4,3,4};
        System.out.println(findDuplicate(array));

    }

}
