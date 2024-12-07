package leetcode;

public class Leetcode24 {

    /**
     * 借鉴链表反转
     * 保留一个指针放在头节点上，因为最终要返回
     * 声明一个指针 cur , 指向 1，3，5，7，9
     * 声明一个指针 pre , 指向 cur 前面一个节点
     * 声明一个指针 temp, 指向 cur下一个节点，临时指针，因为需要从前向后移动
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {

        ListNode pre = new ListNode(0);
        ListNode result = pre;

        result.next = head;
        pre.next = head;

        ListNode cur = head;
        ListNode temp = null;

        while (cur != null && cur.next != null) {
            temp = cur.next;
            pre.next = temp;
            cur.next = temp.next;
            temp.next = cur;
            pre = cur;
            cur = cur.next;

        }
        return result.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        print(node1);

        System.err.println("");


        ListNode result = swapPairs(node1);

        print(result);
    }


    public static void print(ListNode node1) {
        ListNode temp = node1;
        while (temp != null) {
            System.err.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
