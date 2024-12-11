package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 两数组交集
 */
public class Leetcode349 {

    /**
     * 排序 + 双指针
     */
    class Solution_2 {

        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int indexA = 0;
            int indexB = 0;

            Set<Integer> set = new HashSet();
            while (indexA < nums1.length && indexB < nums2.length) {
                if (nums1[indexA] < nums2[indexB]) {
                    indexA++;
                } else if (nums1[indexA] > nums2[indexB]) {
                    indexB++;
                } else if (nums1[indexA] == nums2[indexB]) {
                    set.add(nums1[indexA]);
                    indexA++;
                    indexB++;

                }

            }

            int[] result = new int[set.size()];
            int index = 0;
            for (int temp : set) {
                result[index] = temp;
                index++;
            }

            return result;
        }
    }

    /**
     *
     */
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet();

            for (int i = 0; i < nums1.length; i++) {
                if (set.contains(nums1[i])) {
                    continue;
                }
                for (int j = 0; j < nums2.length; j++) {
                    if (set.contains(nums2[j])) {
                        continue;
                    }
                    if (nums1[i] == nums2[j]) {
                        set.add(nums1[i]);
                    }
                }
            }

            if (set.isEmpty()) {
                return new int[0];
            }


            int[] result = new int[set.size()];
            int index = 0;
            for (Integer temp : set) {
                result[index] = temp;
                index++;
            }

            return result;

        }

    }
}
