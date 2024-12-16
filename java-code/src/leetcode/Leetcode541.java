package leetcode;

/**
 *
 */
public class Leetcode541 {

    class Solution {
        public String reverseStr(String s, int k) {

            int n = s.length();
            char[] array = s.toCharArray();

            // 核心思路
            for (int i = 0; i < n; i += 2 * k) {
                reserve(array, i, Math.min(n, i + k) - 1);
            }

            return new String(array);

        }

        public void reserve(char[] array, int left, int right) {
            while (left < right) {
                char temp = array[right];
                array[right] = array[left];
                array[left] = temp;
                left++;
                right--;
            }
        }

    }

}
