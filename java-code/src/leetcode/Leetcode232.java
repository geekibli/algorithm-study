package leetcode;

import java.util.Stack;

public class Leetcode232 {


    class MyQueue {
        private Stack<Integer> A;
        private Stack<Integer> B;

        public MyQueue() {
            A = new Stack<>();
            B = new Stack<>();
        }

        public void push(int x) {
            A.push(x);
        }

        public int pop() {
            int peek = peek();
            B.pop();
            return peek;
        }

        public int peek() {
            if (!B.isEmpty()) return B.peek();
            if (A.isEmpty()) return -1;
            while (!A.isEmpty()){
                B.push(A.pop());
            }
            return B.peek();
        }

        public boolean empty() {
            return A.isEmpty() && B.isEmpty();
        }
    }


}
