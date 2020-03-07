package leetcode.panda.chapter0019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 进阶：标记位扫描，防止重复循环
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};


    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode run = head, node = head;
        while (n > 0 && run != null) {
            run = run.next;
            n--;
        }
        if (run.next == null) {
            return head.next;
        }
        run = run.next;

        while (run != null) {
            run = run.next;
            node = node.next;
        }
        node.next = node.next.next;
        return head;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
