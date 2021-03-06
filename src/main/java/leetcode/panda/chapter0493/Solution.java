package leetcode.panda.chapter0493;

/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * <p>
 * 你需要返回给定数组中的重要翻转对的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 * <p>
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(s.reversePairs(arr1));
    }

    public int reversePairs(int[] nums) {
        int count = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }
        Node head = new Node(-1);
        Node node = new Node(nums[nums.length - 1] * 2L);
        head.next = node;
        for (int i = nums.length - 2; i >= 0; i--) {
            Node cur = head.next;
            Node pre = head;
            while (cur != null && cur.value < nums[i]) {
                count += cur.count;
                cur = cur.next;
                pre = pre.next;
            }
            long d = nums[i] * 2L;
            while (cur != null && cur.value < d) {
                cur = cur.next;
                pre = pre.next;
            }
            if (cur == null) {
                pre.next = new Node(d);
            } else if (cur.value == d) {
                cur.increment();
            } else {
                Node n = new Node(d);
                n.next = cur;
                pre.next = n;
            }
        }

        return count;
    }

    class Node {
        long value;
        int count;
        Node next;

        Node(long key) {
            count = 1;
            value = key;
        }

        void increment() {
            count++;
        }
    }


}