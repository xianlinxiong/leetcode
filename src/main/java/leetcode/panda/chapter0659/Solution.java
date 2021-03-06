package leetcode.panda.chapter0659;

/**
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 * <p>
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *  
 * <p>
 * 示例 3：
 * <p>
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的数组长度范围为 [1, 10000]
 *  
 * *
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,4,4,5};
        System.out.println(s.isPossible(nums));

    }

    public boolean isPossible(int[] nums) {
        Node head = new Node(-1);
        for (int i = 0; i < nums.length; i++) {
            if (head.next == null) {
                head.next = new Node(nums[i]);
            } else {
                boolean dealed = false;
                Node pre = head;
                Node node = head.next;
                while (node != null) {
                    if (node.last == nums[i]) {
                        pre = node;
                        node = node.next;
                    } else if (node.last + 1 == nums[i]) {
                        node.last++;
                        node.length++;
                        dealed = true;
                        break;
                    } else {
                        if (node.length < 3) {
                            return false;
                        } else {
                            pre.next = node.next;
                            node = node.next;
                        }
                    }
                }
                if (!dealed) {
                    node = new Node(nums[i]);
                    node.next = head.next;
                    head.next = node;
                }
            }
        }
        Node node = head.next;
        while (node != null) {
            if (node.length < 3) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    class Node {
        int last;
        int length;
        Node next;

        Node(int k) {
            last = k;
            length = 1;
        }

    }
}