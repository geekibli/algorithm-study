package leetcode;

import java.util.stream.StreamSupport;

public class Leetcode151 {

    public static void main(String[] args) {
//        String str = "a good   example";
        String str = "the sky is blue";
        System.err.println(Solution.reverseWords(str));
    }


    class Solution_2 {
        public String reverseWords(String s) {
            s = s.trim();                                    // 删除首尾空格
            int j = s.length() - 1, i = j;
            StringBuilder res = new StringBuilder();
            while (i >= 0) {
                while (i >= 0 && s.charAt(i) != ' ') i--;     // 搜索首个空格
                res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
                while (i >= 0 && s.charAt(i) == ' ') i--;     // 跳过单词间空格
                j = i;                                       // j 指向下个单词的尾字符
            }
            return res.toString().trim();                    // 转化为字符串并返回
        }
    }


    /**
     * 运行可以 提交失败
     *
     * 失败 case "  Bob    Loves  Alice   "
     */
    static class Solution {
        public static String reverseWords(String s) {

            char[] array = s.toCharArray();

            char pre = ' ';
            StringBuilder builder = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                char cur = array[i];
                if (cur == ' ' && pre == ' ') {
                    i--;
                    continue;
                }

                if (cur == ' ') {
                    pre = ' ';
                } else {
                    int end = i;
                    while (i >= 0 && array[i] != ' ') {
                        i--;
                    }
                    i++;
                    String tt = s.substring(i, end + 1);
                    System.err.println( tt);
                    builder.append(tt).append(' ');
                    pre = cur;
                }
            }

            return builder.toString().trim();
        }


    }
}
