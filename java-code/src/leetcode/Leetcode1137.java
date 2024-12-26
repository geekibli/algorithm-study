package leetcode;

/**
 * 第 N 个泰波那契数
 */
public class Leetcode1137 {

    /**
     * 迭代
     */
    class Solution1 {

        public int tribonacci(int n) {

            if (n == 0)
                return 0;
            if (n == 1 || n == 2)
                return 1;
            int a = 0, b = 1, c = 1;
            for (int i = 3; i <= n; i++) {
                int d = a + b + c;
                a = b;
                b = c;
                c = d;
            }
            return c;
        }
    }


    /**
     * 递归
     * 超出了时间限制
     */
    class Solution {

        public int tribonacci(int n) {

            int t0 = 0;
            int t1 = 1;
            int t2 = 1;

            if (n == 0)
                return t0;
            if (n == 1)
                return t1 + t0;
            if (n == 2)
                return t2;

            int ans = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);


            return ans;
        }
    }


}
