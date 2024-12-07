package leetcode;

/**
 * 输出倒数第n个
 */
public class Leetcode19 {


    /**
     * 快慢指针
     * <p>
     * 如果要删除倒数第n个节点，就让快指针先走n步，然后快慢指针在一起走，知道快指针走到最后一个节点的next
     * 此时，慢指针的下一个节点就是要删除的节点
     * 执行 slow.next = slow.next.next
     */
    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode first = head;
            ListNode second = dummy;
            for (int i = 0; i < n; ++i) {
                first = first.next;
            }

            System.out.println("first: " + first.val);
            System.out.println("second: " + second.val);

            while (first != null) {
                first = first.next;
                second = second.next;
            }

            System.out.println("second: " + second.val);

            second.next = second.next.next;
            ListNode ans = dummy.next;
            return ans;
        }
    }


    /**
     * 1、计算链表长度，计算出 如果从前往后遍历，应该删除第几个
     * 2、然后通过两个相邻的指针，定位要删除的位置 ，pre.next = temp.next 就可以了
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int totalCount = getCount(head);
            if (totalCount == 0) {
                return head;
            }

            System.out.println("totalCount: " + totalCount);

            ListNode result = new ListNode(0);
            result.next = head;
            ListNode temp = head;
            ListNode pre = result;

            for (int i = 1; i < totalCount - n + 1; i++) {
                pre = temp;
                if (temp.next != null) {
                    temp = temp.next;
                }
            }

            System.out.println("pre: " + pre.val + " temp: " + temp.val);

            pre.next = temp.next;

            return result.next;
        }


        public int getCount(ListNode head) {
            ListNode temp = head;
            if (temp == null) {
                return 0;
            }

            int count = 0;
            while (temp != null) {
                count++;
                temp = temp.next;
            }

            return count;

        }

    }
}
