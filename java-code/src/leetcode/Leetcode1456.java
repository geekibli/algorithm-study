package leetcode;

public class Leetcode1456 {

    public static void main(String[] args) {
        System.err.println(Solution2.maxVowels("abciiidef", 3));
    }

    // https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/solutions/2809359/tao-lu-jiao-ni-jie-jue-ding-chang-hua-ch-fzfo
    // 定长滑动窗口

    /**
     * 定长滑窗套路
     * <p>
     * 我们要计算所有长度恰好为 k 的子串中，最多可以包含多少个元音字母。
     * <p>
     * 暴力枚举所有子串？时间复杂度是 O(nk)，太慢了。能否 O(1) 计算子串的元音个数？
     * <p>
     * 这是可以做到的，对于下图的字符串 abci，假如我们已经计算出了子串 abc 的元音个数，那么从子串 abc 到子串 bci，只需要考虑移除（离开窗口）的字母 a 是不是元音，以及添加（进入窗口）的字母 i 是不是元音即可，因为中间的字母 b 和 c 都在这两个子串中。
     * <p>
     * <p>
     * 我总结成三步：入-更新-出。
     * <p>
     * 入：下标为 i 的元素进入窗口，更新相关统计量。如果 i<k−1 则重复第一步。
     * 更新：更新答案。一般是更新最大值/最小值。
     * 出：下标为 i−k+1 的元素离开窗口，更新相关统计量。
     * <p>
     * 作者：灵茶山艾府
     * 链接：https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/solutions/2809359/tao-lu-jiao-ni-jie-jue-ding-chang-hua-ch-fzfo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static class Solution2 {
        public static int maxVowels(String S, int k) {

            int result = 0;
            // 当前滑动窗口中的元音字符的数量
            int vowel = 0;
            char[] s = S.toCharArray();
            for (int i = 0; i < S.length(); i++) {

                if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                    vowel++;
                }

                // Solution2.maxVowels("abciiidef", 3)
                // 2
                if (i < k - 1) {
                    continue;
                }

                result = Math.max(result, vowel);

                int index = i - k + 1;
                if (s[index] == 'a' || s[index] == 'e' || s[index] == 'i' || s[index] == 'o' || s[index] == 'u') {
                    vowel--;
                }
            }

            return result;

        }
    }


    /**
     * 暴力解法 应该能通过 但是 ，超时了 103 / 107 个通过的测试用例
     */
    static class Solution {

        public static int maxVowels(String s, int k) {

            Integer count = 0;
            for (int i = 0; i < s.length() - k + 1; i++) {
                String subString = s.substring(i, i + k);
                count = Math.max(getCount(subString), count);
            }
            return count;

        }

        public static int getCount(String str) {
            int count = 0;
            char[] arr = {'a', 'e', 'i', 'o', 'u'};
            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
                    count++;
                }
            }
            return count;
        }

    }
}
