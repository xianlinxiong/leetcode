package leetcode.panda.chapter0082;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = {3, 1, 1};
    }

    /**
     * 标记记录法，记录某元素出现的次数
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode flag = result;
        ListNode last = head;
        int count = 1;
        int lastValue = head.val;
        head = head.next;
        while (head != null) {
            if (head.val == lastValue) {
                count++;
            } else {
                if (count == 1) {
                    flag.next = last;
                    flag = flag.next;
                }
                count = 1;
                last = head;
                lastValue = head.val;
            }
            head = head.next;
        }
        if (count == 1) {
            flag.next = last;
        } else {
            flag.next = null;
        }
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