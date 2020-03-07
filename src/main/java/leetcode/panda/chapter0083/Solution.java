package leetcode.panda.chapter0083;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = {3, 1, 1};
    }

    /**
     * 标记记录法，记录某元素出现的次数
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode flag = result;
        flag.next = head;
        flag = flag.next;
        int lastValue = head.val;
        head = head.next;
        while (head != null) {
            if (head.val != lastValue) {
                flag.next = head;
                flag = flag.next;
                lastValue = head.val;
            }
            head = head.next;
        }
        flag.next = null;
        return result.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}