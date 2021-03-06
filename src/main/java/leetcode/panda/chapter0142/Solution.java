package leetcode.panda.chapter0142;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 *
 */
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ints = {1, 2};
    }

    public ListNode detectCycle(ListNode head) {
        if(null == head || head.next == null || head.next.next ==null){
            return null;
        }
        ListNode first = head.next;
        ListNode second = head.next.next;
        boolean  hasCycle = false;
        while(second != null && second.next != null){
            if(second == first){
                hasCycle = true;
                break;
            }
            second = second.next.next;
            first = first.next;
        }
        if(!hasCycle){
            return null;
        }
        first = head;
        while(first != second){
            first = first.next;
            second = second.next;
        }
        return first;
    }

    }


class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
}