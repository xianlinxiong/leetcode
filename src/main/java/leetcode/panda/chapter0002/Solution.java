package leetcode.panda.chapter0002;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int more = 0;
        ListNode result = new ListNode(0);
        ListNode p = result;
        while(l1 != null && l2 != null){
            int re = l1.val + l2.val + more;
            more = re / 10;
            re %= 10;
            ListNode node = new ListNode(re);
            p.next = node;
            p = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int re = l1.val + more;
            more = re / 10;
            re %= 10;
            ListNode node = new ListNode(re);
            p.next = node;
            p = node;
            l1 = l1.next;
        }
        while(l2 != null){
            int re = l2.val + more;
            more = re / 10;
            re %= 10;
            ListNode node = new ListNode(re);
            p.next = node;
            l2 = l2.next;
            p = node;
        }
        if(more != 0){
            ListNode node = new ListNode(more);
            p.next = node;
        }
        return result.next;

    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}