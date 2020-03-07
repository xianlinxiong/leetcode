package leetcode.panda.chapter0025;

/**
 * 进阶:k数组，倒过来
 *
 */
public class Solution {
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

        reverseKGroup(one, 9);
        System.out.println();

    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 0 || k ==1 || head == null){
            return head;
        }
        ListNode[] list = new ListNode[k];
        ListNode result = new ListNode(0);
        result.next= head;
        head = result;

        do{
            boolean br = false;
            list[0] = head.next;
            if(list[0] == null){
                break;
            }
            for(int j =1; j < k; j++){
                list[j] = list[j-1].next;
                if(list[j] == null){
                    br = true;
                    break;
                }
            }
            if(br){
                break;
            }
            list[0].next = list[k-1].next;
            head.next = list[k-1];
            for(int j = k-1; j >0; j--){
                list[j].next = list[j-1];
            }
            head = list[0];

        }
        while(list[0] != null);

        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
 }
}
