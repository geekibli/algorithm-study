package leetcode;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/submissions/585030468/
 */
public class Leetcode209 {

    /**
     * 双指针 + 滑动窗口
     * j 表示子数组的终点
     * i 表示子数组的起点
     * j 从前往后遍历，直到自数组内的所有元素的和加起来 >= target , 这个时候，j不动，i向前移动
     */
    class Solution3 {

        public int minSubArrayLen(int target, int[] nums) {
            int result = Integer.MAX_VALUE;
            int i = 0;
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
                while (sum >= target) {
                    result = Math.min(result, j - i + 1);
                    sum -= nums[i];
                    i++;
                }
            }
            return result == Integer.MAX_VALUE ? 0 : result;
        }


    }

    /**
     * 暴力解法2  基于暴力解法1上优化
     * 超出时间限制
     */
    class Solution2 {
        public int minSubArrayLen(int target, int[] nums) {

            int result = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum >= target) {
                        result = Math.min(result, j - i + 1);
                        break;
                    }
                }
            }

            return result == Integer.MAX_VALUE ? 0 : result;

        }
    }


    /**
     * 暴力解法1
     * 超出时间限制
     */
    class Solution {

        public int minSubArrayLen(int target, int[] nums) {

            int result = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length; i++) {
                int sum = nums[i];
                if (sum >= target) {
                    return 1;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum >= target) {
                        result = Math.min(result, j - i + 1);
                        break;
                    }
                }
            }

            return result == Integer.MAX_VALUE ? 0 : result;

        }

    }


}
