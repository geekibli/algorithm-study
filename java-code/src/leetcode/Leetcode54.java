package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();

            int left = 0;
            int right = matrix[0].length - 1;

            int top = 0;
            int bottom = matrix.length - 1;

            while (left <= right && top <= bottom) {

                for (int i = left ; i <= right ; i++) {
                    result.add(matrix[top][i]);
                }
                for (int j = top + 1 ; j <= bottom ; j++) {
                    result.add(matrix[j][right]);
                }

                if (left < right && top < bottom) {
                    for (int i = right - 1; i > left; i--) {
                        result.add(matrix[bottom][i]);
                    }
                    for (int j = bottom; j > top ; j--) {
                        result.add(matrix[j][left]);
                    }
                }

                left++;
                right--;
                top++;
                bottom--;
            }

            return result;

        }
    }
}
