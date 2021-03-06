package leetcode.panda.chapter0023;

public class Solution2 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for(ListNode listNode : lists){
            result = doMerge(result, listNode);
        }
        return result;
    }

    private ListNode doMerge(ListNode node1, ListNode node2){
        ListNode result = new ListNode(0);
        ListNode node = result;
        while(node1 != null && node2 != null){
            int v = 0;
            if(node1.val < node2.val){
                v = node1.val;
                node1 =node1.next;
            }else{
                v = node2.val;
                node2 = node2.next;
            }
            ListNode node3 = new ListNode(v);
            node.next = node3;
            node = node.next;
        }
        if(null != node1){
            node.next = node1;
        }
        if(null != node2){
            node.next = node2;
        }

        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
