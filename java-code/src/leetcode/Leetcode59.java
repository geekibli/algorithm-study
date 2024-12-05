package leetcode;

public class Leetcode59 {

    /**
     * 四个指针 left , right , top , bottom 四个指针 完成
     */
    class Solution2 {

        public int[][] generateMatrix(int n) {

            int[][] matrix = new int[n][n];

            int left = 0;
            int right = n - 1;

            int top = 0;
            int bottom = n - 1;
            int count = 1;

            while (left <= right && top <= bottom) {

                for (int i = left ; i <= right ; i++) {
                    matrix[top][i] = count++;
                }
                for (int j = top + 1 ; j <= bottom ; j++) {
                    matrix[j][right] = count++;
                }

                if (left < right && top < bottom) {
                    for (int i = right - 1; i > left; i--) {
                        matrix[bottom][i] = count++;
                    }
                    for (int j = bottom; j > top ; j--) {
                        matrix[j][left] = count++;
                    }
                }

                left++;
                right--;
                top++;
                bottom--;
            }

            return matrix;

        }

    }


    /**
     * 1.保留每一行或者每一列最后一个节点给下一个边处理
     * 2.需要计算一共有几层，正常是 n/2 层，但是需要考虑到 n是奇数
     *
     * 整体思路就是一圈处理完，再往里层处理一圈，依次由外到内
     */
    class Solution {

        public int[][] generateMatrix(int n) {

            int[][] nums = new int[n][n];
            int startX = 0;
            int startY = 0;
            int offsit = 1;
            int count = 1;
            int loop = 0;
            int i, j;

            // 从外到内一共多少层
            while (loop < n / 2) {

                for (j = startY; j < n - offsit; j++) {
                    nums[startX][j] = count++;
                }

                for (i = startX; i < n - offsit; i++) {
                    nums[i][j] = count++;
                }

                for (; j > startY; j--) {
                    nums[i][j] = count++;
                }

                for (; i > startX; i--) {
                    nums[i][startY] = count++;
                }

                offsit++;
                startX++;
                startY++;
                loop++;

            }

            if (n % 2 == 1) {
                nums[startX][startY] = count;
            }


            return nums;
        }


    }
}
