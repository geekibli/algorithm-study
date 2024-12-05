package leetcode;

public class Leetcode146 {

    class Solution {
        public int[] spiralArray(int[][] matrix) {

            if (matrix.length == 0) {
                return new int[0];
            }

            int left = 0;
            int right = matrix[0].length - 1;

            int top = 0;
            int bottom = matrix.length - 1;

            int[] result = new int[matrix.length * matrix[0].length];
            int count = 0;

            while (left <= right && top <= bottom) {

                for (int i = left; i <= right; i++) {
                    result[count++] = matrix[top][i];
                }
                for (int j = top + 1; j <= bottom; j++) {
                    result[count++] = matrix[j][right];
                }

                if (left < right && top < bottom) {
                    for (int i = right - 1; i > left; i--) {
                        result[count++] = matrix[bottom][i];
                    }
                    for (int j = bottom; j > top; j--) {
                        result[count++] = matrix[j][left];
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
