package leetcode.panda.chapter0061;

/**
 *给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        forth.next= fifth;
        third.next= forth;
        second.next = third;
        first.next = second;

        ListNode listNode = s.rotateRight(first, 2);
        System.out.println(listNode);
    }

    /**
     *  遍历一遍， 统计节点数目， k取余节点总数（防止多次循环）， 总数-k（移动次数）， 移动后切断， 并将末尾和首位置链接起来
     *
     *  优化，遍历时获取尾巴节点和节点数目
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        int count = countNodes(head);
        if(count == 0 ){
            return head;
        }
        k %= count;
        if(k == 0){
            return head;
        }
        ListNode next = head;
        k = count -k;
        for(int i =1; i < k;i++){
            next = next.next;
        }
        ListNode end = next;
        while(end.next != null){
            end = end.next;
        }
        end.next = head;
        head = next.next;
        next.next = null;
        return head;
    }

    private int countNodes(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }

        return count;
    }

  static   class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}