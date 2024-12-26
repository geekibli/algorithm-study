package leetcode;

import java.util.Stack;

public class Leetcode1047 {

    class Solution {
        public String removeDuplicates(String s) {
            Stack<Character> stack = new Stack();

            for (int i = 0; i < s.length() ; i++) {
                char cur = s.charAt(i);
                if (stack.isEmpty()){
                    stack.push(cur);
                    continue;
                }

                if (stack.peek() == cur) {
                    stack.pop();
                }else {
                    stack.push(cur);
                }
            }

            if (stack.isEmpty()) {
                return "";
            }

            System.out.println("stack: {}" + stack);

            char[] array = new char[stack.size()];
            for (int i = stack.size() - 1 ; i>= 0; i--) {
                array[i] = stack.pop();
            }
            return new String(array);

        }
    }
}
