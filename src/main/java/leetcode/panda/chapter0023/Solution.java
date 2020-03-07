package leetcode.panda.chapter0023;

/**
 * 进阶：k标记循环；二分合并， 单循环
 */
public class Solution {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode[] list = {one, two};
        mergeKLists(list);

        System.out.println();

    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0){
            return null;
        }
        int length = lists.length;
        ListNode[] nodes = new ListNode[length];
        int left = 0;
        for(int i=0; i < length; i++){
            nodes[i] = lists[i];
            if(nodes[i] != null){
                left++;
            }
        }
        ListNode result = new ListNode(-1);
        ListNode node = result;
        while(left > 0){
            left=0;
            int k = -1;
            int min = Integer.MAX_VALUE;
            for(int i =0; i< length; i++){
                if(nodes[i]!= null){
                    left++;
                    if(min > nodes[i].val){
                        min = nodes[i].val;
                        k = i;
                    }
                }
            }
            node.next = nodes[k];
            node = node.next;
            nodes[k] = nodes[k].next;
            left--;
        }
        return result.next;

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
 }
}
