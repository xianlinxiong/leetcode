package leetcode.panda.chapter0148;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 */
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ints = {1, 2};
    }

    public ListNode findMid(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode ret = slow.next;
        slow.next = null;
        return ret;
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
    //归并排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode right = sortList(findMid(head));
        ListNode left = sortList(head);
        return merge(left, right);
    }

    //插入排序
    public ListNode sortList2(ListNode head) {
        ListNode result = new ListNode(-1);
        ListNode cur = head;
        ListNode n;
        while (cur != null) {

            ListNode pre = result;
            ListNode next = pre.next;
            while (next != null && cur.val > next.val) {
                pre = next;
                next = next.next;
            }
            n = cur;
            n.next = pre.next;
            pre.next = n;
            cur = cur.next;
        }

        return result.next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}