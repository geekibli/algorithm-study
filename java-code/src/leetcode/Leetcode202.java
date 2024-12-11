package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode202 {

    /**
     * 我们不是只跟踪链表中的一个值，而是跟踪两个值，称为快跑者和慢跑者。在算法的每一步中，慢速在链表中前进 1 个节点，快跑者前进 2 个节点（对 getNext(n) 函数的嵌套调用）。
     *
     * 如果 n 是一个快乐数，即没有循环，那么快跑者最终会比慢跑者先到达数字 1。
     *
     * 如果 n 不是一个快乐的数字，那么最终快跑者和慢跑者将在同一个数字上相遇。
     *
     */
    class Solution {

        public int getNext(int n) {
            int totalSum = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                totalSum += d * d;
            }
            return totalSum;
        }

        public boolean isHappy(int n) {
            int slowRunner = n;
            int fastRunner = getNext(n);
            while (fastRunner != 1 && slowRunner != fastRunner) {
                slowRunner = getNext(slowRunner);
                fastRunner = getNext(getNext(fastRunner));
            }
            return fastRunner == 1;
        }
    }


    /**
     *
     */
    class Solution2 {
        public boolean isHappy(int n) {

            Set<Integer> ans = new HashSet();

            while (n != 1 && !ans.contains(n)) {
                ans.add(n);
                n = calc(n);
            }

            return n == 1;

        }

        public int calc (int a){
            int sum = 0;
            while(a > 0) {
                int b = a % 10;
                sum += b * b;
                a = a / 10;
            }
            return sum;
        }
    }

}
