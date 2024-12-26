package leetcode;

import java.util.Stack;

/**
 *
 代码
 测试用例
 测试用例
 测试结果
 20. 有效的括号
 */
public class Leetcode20 {

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack();

            for (int i = 0; i < s.length() ; i++) {

                // 如果栈是空的，一上来就是右括号，那肯定不对
                char cur = s.charAt(i);
                if (stack.isEmpty() && (cur == ')' || cur == '}' || cur == ']') ){
                    return false;
                }

                // 如果栈不是空的，则比较当前栈顶元素和当前循环到的元素是不是配对的，如果是，则弹出栈顶元素，继续下一次循环
                if (!stack.isEmpty() && (stack.peek() == '(' && cur == ')' || stack.peek() == '{' && cur == '}' || stack.peek() == '[' && cur == ']')){
                    stack.pop();
                    continue;
                }

                // 入栈，可能不同类型的左括号 或者 "(]"
                stack.push(cur);
            }

            // 有可能最后栈中的元素不是空的， 比如 "(]"
            return stack.isEmpty() ? true : false;
        }
    }
}
