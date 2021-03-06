package leetcode.panda.chapter1302;

import leetcode.panda.UnionSearchSet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {
                2, 1, 4, 3, 9, 6};

    }

    public int deepestLeavesSum(TreeNode root) {
        int son = 0;
        int p = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        int sum = 0;
        queue.offer(root);
        while (p > 0) {
            TreeNode node = queue.poll();
            sum += node.val;
            p--;
            if (node.left != null) {
                son++;
                queue.offer(node.left);
            }
            if (node.right != null) {
                son++;
                queue.offer(node.right);
            }
            if (p == 0 && son > 0) {
                p = son;
                son = 0;
                sum = 0;
            }
        }
        return sum;
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