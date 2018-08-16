package alg;

/**
 * Created by Vidya on 12/16/16.
 */
public class FindTheUnique {

    public static int singleNumber(int[] nums) {
        int result = 0;
        if (nums != null) {
            result = nums[0];
            for (int i = 1; i < nums.length; i ++) {
                result ^= nums[i];
            }
        }
        return result;
    }
    public static void main(String args[]) {
        int inp[] = {1,2,1,2,3,4,3,5,6,5,6};
        System.out.println("uniq is " + singleNumber(inp));
    }
}
