package leetcode;

import java.util.Objects;
import java.util.Stack;

public class Leetcode150 {

    static class Solution {
        public static int evalRPN(String[] tokens) {
            if (tokens.length == 0) {
                return 0;
            }

            Stack<Integer> stack = new Stack();
            for (int x = 0; x < tokens.length; x++) {
                String cur = tokens[x];
                System.err.println("cur .... " + cur);

                if (Objects.equals(cur, "+")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push((a + b));
                    continue;
                }
                if (Objects.equals(cur, "-")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                    continue;
                }
                if (Objects.equals(cur, "*")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a * b);
                    continue;
                }
                if (Objects.equals(cur, "/")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                    continue;
                }
                System.out.println("cur " + cur);
                stack.push(Integer.parseInt(cur));
            }

            return stack.pop();
        }
    }

    public static void main(String[] args) {
//        String [] tokens = {"2","1","+","3","*"};
        String [] tokens = {"4","13","5","/","+"};
        int rpn = Solution.evalRPN(tokens);
        System.out.println(rpn);
    }
}
