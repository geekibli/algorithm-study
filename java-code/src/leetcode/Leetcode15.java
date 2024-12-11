package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class Leetcode15 {

    /**
     * 双指针
     * 先排序
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> ans = new ArrayList();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {


                if (nums[i] > 0) {
                    return ans;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int x = i + 1;
                int y = nums.length - 1;
                while (x < y) {
                    if (nums[i] + nums[x] + nums[y] > 0) {
                        y--;
                    }
                    else if (nums[i] + nums[x] + nums[y] < 0) {
                        x++;
                    }else if (nums[i] + nums[x] + nums[y] == 0){
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[x]);
                        list.add(nums[y]);
                        ans.add(list);

                        // 如果相邻的数是一样的，需要连续收缩
                        // 如果相邻的数是一样的，需要连续收缩
                        while (x < y && nums[y] == nums[y-1]) {
                            y--;
                        }

                        // 如果相邻的数是一样的，需要连续收缩
                        // 如果相邻的数是一样的，需要连续收缩
                        while(x < y && nums[x] == nums[x + 1]) {
                            x++;
                        }

                        x++;
                        y--;
                    }

                }

            }

            return ans;
        }
    }
}
