package alg;

import java.util.*;

/**
 * Created by i841928 on 12/20/16.
 */
public class DuplicateDetecor {

    public boolean containsDuplicate(int[] nums) {
        boolean dupe = false;
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length && !dupe; i++) {
            if (set.contains(nums[i])) {
                dupe = true;
            }
            set.add(nums[i]);
        }

        return dupe;

    }


    /**
     * Finds existence of duplicates such that the distance between duplicates is atmost k
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean hasDupeNear = false;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length && !hasDupeNear; i++) {
            Integer j = map.get(nums[i]);
            if ((j != null) && ((i - j) <= k)) {
                hasDupeNear = true;
            } else {
                map.put(nums[i], i);
            }
        }
        return hasDupeNear;
    }


    public static void main(String args[]) {

        int[] nums = {10, 12, 20, 30, 40, 50, 60, 70, 90, 100};
        int k = 10000;
        int t = 2;
        DuplicateDetecor dd = new DuplicateDetecor();
        int nums2[] = {0, 10, 22, 15, 0, 5, 22, 12, 1, 5};
        System.out.println(" nums2 :" +
                dd.containsNearbyAlmostDuplicate(nums2, 3, 3));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        boolean hasAlmostDupe = false;
        if (nums != null && k > 0 && t >= 0 && nums.length > 0) {
            NavigableMap<Integer, Integer> nm = new TreeMap<Integer, Integer>();
            for (int i = 0; i < nums.length && !hasAlmostDupe; i++) {
                long current = nums[i];
                Integer foundAt = nm.get(nums[i]);
                if (foundAt != null) {
                    hasAlmostDupe = true;
                    break;
                }
                Map.Entry<Integer, Integer> entry = nm.lowerEntry(nums[i]);
                if (entry != null) {
                    long lower = entry.getKey();
                    if (current - lower <= t) {
                        hasAlmostDupe = true;
                        break;
                    }
                }
                entry = nm.higherEntry(nums[i]);
                if (entry != null) {
                    long higher = entry.getKey();
                    if (higher - current <= t) {
                        hasAlmostDupe = true;
                        break;
                    }
                }

                if (i >= k) {
                    nm.remove(nums[i-k]);
                }
                nm.put(nums[i], i);
            }
        }
        return hasAlmostDupe;
    }

