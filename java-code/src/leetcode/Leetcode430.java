package leetcode;

/**
 * 扁平化多级双向链表
 */
public class Leetcode430 {


    class Solution_2 {

        public Node flatten(Node head) {
            Node result = new Node(0);
            result.next = head;
            Node cur = head;
            Node temp = null;
            while (cur != null) {
                temp = cur.next;
                if (cur.child == null) {
                    cur = temp;
                    continue;
                }

                Node childLine = flatten(cur.child);
                cur.next = childLine;
                childLine.prev = cur;

                Node chileTemp = childLine;
                while (chileTemp.next != null) {
                    chileTemp = chileTemp.next;
                }
                chileTemp.next = temp;
                if (temp != null) {
                    temp.prev = chileTemp;
                }
                cur.child = null;
                cur = temp;
            }

            return result.next;
        }

    }



    /**
     * 最先想到的就是递归
     */
    class Solution {
        public Node flatten(Node head) {
            Node result = new Node(0);
            result.next = head;
            diegui(head);
            return result.next;
        }

        public Node diegui(Node head) {
            Node cur = head;
            Node temp = null;
            while (cur != null) {
                temp = cur.next;
                if (cur.child == null) {
                    cur = temp;
                    continue;
                }

                Node childLine = flatten(cur.child);
                cur.next = childLine;
                childLine.prev = cur;

                Node chileTemp = childLine;
                while (chileTemp.next != null) {
                    chileTemp = chileTemp.next;
                }
                chileTemp.next = temp;
                if (temp != null) {
                    temp.prev = chileTemp;
                }
                cur.child = null;
                cur = temp;
            }
            return cur;
        }


    }


}
