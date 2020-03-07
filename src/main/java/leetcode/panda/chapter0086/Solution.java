package leetcode.panda.chapter0086;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 *  
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] heights = {3, 6, 5, 7, 4, 8, 1, 0};
    }

    /**
     * 链表双标记法则
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode small =  new ListNode(-1);
        ListNode big = new ListNode(1);
        ListNode s1 = small;
        ListNode b1 = big;
        while(head != null){
            if(head.val < x){
                s1.next = head;
                s1 = s1.next;
            }
            else{
                b1.next = head;
                b1 = b1.next;
            }
            head = head.next;
        }
        b1.next = null;
        s1.next = big.next;

        return small.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

}