package leetcode.panda.chapter0094;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 * <p>
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 *  
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.right = two;
        two.left = three;
        System.out.println(s.inorderTraversal(one));

    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node;
        while (null != root || !stack.empty()) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            node = stack.pop();
            result.add(node.val);
            if (null != node.right) {
                root = node.right;
            }
        }
        return result;

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        doTravel(root, result);
        return result;

    }

    private void doTravel(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        doTravel(treeNode.left, list);
        list.add(treeNode.val);
        doTravel(treeNode.right, list);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}