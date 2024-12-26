package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 225. 用队列实现栈
 */
public class Leetcode225 {

    static class MyStack {
        Deque<Integer> q1;
        Deque<Integer> q2;

        public MyStack() {
            q1 = new ArrayDeque();
            q2 = new ArrayDeque();
        }

        public void push(int x) {
            q2.offer(x);
            while (q1.isEmpty()) {
                q2.offer(q1.pop());
            }

            Deque<Integer> temp;
            temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            return q1.pop();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.offer(3);
        System.err.println(deque);
        System.err.println(deque.poll());
        System.err.println(deque);
        System.err.println(deque.pop());
        System.err.println(deque);

    }
}
