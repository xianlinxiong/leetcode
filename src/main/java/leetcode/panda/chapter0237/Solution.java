package leetcode.panda.chapter0237;

/**
 *chapter0236
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};

    }
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        ListNode pre = node;
        node.val = next.val;
        node = next;
        next = next.next;
        while(next != null){
            node.val = next.val;
            node = next;
            next = next.next;
            pre = pre.next;
        }
        pre.next=null;
    }


    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}