package alg.sort;

/**
 * Created by i841928 on 12/27/16.
 */
public class Sorter {


    /**
     * Starting from the starting of the array, find the min element and swap with current
     * @param nums
     * @return
     */
    public int[] selectionSort1(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int pos = i;
            for (int j= i+1; j < nums.length; j++) {
                if(nums[j] < min) {
                    min = nums[j];
                    pos = j;
                }
            }

            nums[pos] = nums[i];
            nums[i] = min;

        }
        return nums;
    }


    public int[] selectionSort(int[] nums) {
        for (int current = 0; current < nums.length; current++) {
            int min = nums[current];
            int minPos = current;
            for (int i = current + 1; i < nums.length; i++) {
                    if (nums[i] < min) {
                        minPos = i;
                        min = nums[i];
                    }
            }

            if (min != nums[current]) {
                nums[minPos] = nums[current];
                nums[current] = min;
            }
        }
        return nums;
    }

    public int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];

            for (int j = 0; j < i; j++) {
                if (nums[j] > val) {
                    System.arraycopy(nums, j, nums ,j+1, i - j);
                    nums[j] = val;
                    break;
                }
            }
        }
        return nums;
    }


    public static void main(String args[]) {
        int[] input =  {30, 2, 10, 4, 2, 5, 1, 3, 6, 7, 9, 8}; //{23,17,8,35,0,2};
        Sorter sorter = new Sorter();
        int[] output;
        System.out.println("Selection sort");
        output = sorter.selectionSort(input);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
        int[] input2 =  {19, 12, 4, 2, 5, 1, 3, 6, 7, 9, 8};
        // 12, 19, 4, 2, 5, 1, 3, 6, 7,8,9
        //
        System.out.println("\nInsertion sort");
        output = sorter.insertionSort(input2);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }

    }
}
