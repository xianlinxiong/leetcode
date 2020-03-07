package leetcode.panda.chapter0021;

import java.util.ArrayList;
import java.util.List;

/**
 * 进阶：标记位扫描，防止重复循环
 */
public class Solution {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next=two;
        three.next = four;
        mergeTwoLists(one, three);


    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1 && null ==l2){
            return null;
        }
        ListNode listNode = new ListNode(0);

        ListNode one = l1, two = l2, result = listNode;
        while (one != null && two != null){
            if(one.val < two.val){
                listNode.next = one;
                one = one.next;
                listNode = listNode.next;
            }
            else{
                listNode.next = two;
                two = two.next;
                listNode = listNode.next;
            }
        }
        if(one!=null){
            listNode.next = one;
        }
        if(two != null){
            listNode.next= two;
        }
        return result.next;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
