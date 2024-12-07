package leetcode;
// 返回环形链表入环的位置
public class Leetcode142 {

    /**
     * 1. 找到快慢指针相遇的位置
     * 2. 从链表head开始往后一个一个走（temp），同时慢指针(slow)从相遇的位置一个一个往后走
     * 3. temp = slow 的时候 就是入环的位置
     *
     * 通过公式推导
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {

            if (head == null) {
                return null;
            }

            ListNode slow = head;
            ListNode fast = head;
            ListNode meet = null;

            while (fast != null && fast.next != null && slow != null) {
                fast = fast.next.next;
                slow = slow.next;

                if (fast == slow) {
                    meet = fast;
                    break;
                }
            }

            if (meet == null) {
                return null;
            }
            ListNode temp = head;
            while (temp != meet) {
                temp = temp.next;
                meet = meet.next;
            }

            return temp;

        }
    }


}
