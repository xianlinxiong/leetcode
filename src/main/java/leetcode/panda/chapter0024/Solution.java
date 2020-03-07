package leetcode.panda.chapter0024;

/**
 * 进阶：k标记循环；二分合并， 单循环
 */
public class Solution {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next=two;
        two.next = three;
        swapPairs(one);

        System.out.println();

    }
    public static ListNode swapPairs(ListNode head) {
        ListNode result , first, second, temp;
        if(head == null){
            return null;
        }
        first = head;
        if(first.next == null){
            return first;
        }
        second = first.next;
        result = new ListNode(0);
        head = result;
        while(first != null){
            if(null == second){
                break;
            }
            head.next = second;
            first.next = second.next;
            second.next = first;
            head = first;
            first = head.next;
            if(first == null){
                break;
            }
            if(null != first){
                second = first.next;
            }
        }
        return result.next;

    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
 }
}
