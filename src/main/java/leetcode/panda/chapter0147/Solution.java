package leetcode.panda.chapter0147;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {

        ListNode result = new ListNode(-1);
        while(head != null){
            ListNode node = head;
            head = head.next;
            ListNode pre = result;
            while(pre.next != null && pre.next.val > node.val){
                pre = pre.next;
            }
            node.next = pre.next;
            pre.next = node;
        }
        ListNode node = result.next;
        result.next =null;
        while(node != null){
            ListNode cur = node;
            node = node.next;
            cur.next= result.next;
            result.next=cur;
        }

        return result.next;

    }

    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
}
