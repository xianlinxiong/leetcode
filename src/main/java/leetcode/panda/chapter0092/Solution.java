package leetcode.panda.chapter0092;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 *  
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode first = null;
        ListNode current = head;
        for(int i =1; i < m; i++){
            first = current;
            current = current.next;
        }
        ListNode second = null;
        ListNode end = current;
        ListNode last = null;
        for(int i = m; i <= n; i++){
            last = current.next;
            current.next = second;
            second = current;
            current = last;
        }
        if(first != null){
            first.next = second;
        }else{
            head = second;
        }
        if(null != current){
            end.next = last;
        }
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

}