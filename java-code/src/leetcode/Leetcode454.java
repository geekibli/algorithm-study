package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加 II
 */
public class Leetcode454 {

    /**
     * 先用map 做加法
     * 再用map 做减法
     */
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

            Map<Integer , Integer> map = new HashMap();

            for (int i = 0 ; i < nums1.length; i++) {
                for (int j = 0 ; j< nums2.length; j++) {
                    int sum = nums1[i] + nums2[j];
                    map.put(sum , map.getOrDefault(sum , 0) + 1 );
                }
            }

            int result = 0;
            for (int x = 0; x < nums3.length ; x++) {
                for (int y =0 ; y < nums4.length ; y++) {
                    int sum = nums3[x] + nums4[y];

                    if (map.containsKey(-sum)) {
                        result += map.get(-sum);
                    }

                }
            }

            return result;
        }
    }
}
