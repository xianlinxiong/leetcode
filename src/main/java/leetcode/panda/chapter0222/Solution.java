package leetcode.panda.chapter0222;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * 输出: 6
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};

    }
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + countNodes(root.left)+countNodes(root.right);
    }

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode last = root;
        TreeNode next ;
        while (true) {
            TreeNode t = queue.poll();
            if (t.right != null) {
                next = t.right;
                if(t == last){
                    last = next;
                }
            } else {
                while (t != last) {
                    t = queue.poll();
                }
                return (int) Math.pow(2, height) + queue.size();
            }
        }

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