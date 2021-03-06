package leetcode.panda.chapter0637;

import java.util.*;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 节点值的范围在32位有符号整数范围内。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int parent = 1;
        int son = 0;
        int cnt = 0;
        double total = 0;
        while (parent > 0) {
            TreeNode node = queue.poll();
            parent--;
            total += node.val;
            cnt++;
            if (node.left != null) {
                queue.offer(node.left);
                son++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                son++;
            }
            if (parent == 0) {
                list.add(total / cnt);
                parent = son;
                son = 0;
                total = 0;
                cnt = 0;
            }
        }

        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}