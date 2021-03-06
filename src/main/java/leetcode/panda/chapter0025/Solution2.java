package leetcode.panda.chapter0025;

public class Solution2 {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next=two;
        two.next = three;
        three.next = four;
        four.next = five;
        Solution2 s = new Solution2();
        s.reverseKGroup(one, 2);
        System.out.println();

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null){
            return head;
        }
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode node = result;
        while(true){
            int i =0;
            while(head != null && i < k){
                head = head.next;
                i++;
            }
            if(i < k){
                break;
            }
            doSwap(node, head);
            while(node.next != head){
                node = node.next;
            }
        }

        return result.next;

    }

    private void doSwap(ListNode header, ListNode last){
        ListNode next = header.next;
        ListNode listNode = last;
        ListNode node = next.next;
        while(node != last){
            next.next = listNode;
            listNode = next;
            next = node;
            node = node.next;
        }
        next.next = listNode;
        header.next = next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
