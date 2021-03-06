package leetcode.panda.chapter0098;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
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

    }



    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        return doTravel(root, stack);

    }

    private boolean  doTravel(TreeNode treeNode,Stack<TreeNode> stack) {
        if (treeNode == null) {
            return true;
        }
        boolean left = doTravel(treeNode.left, stack);
        if(!left){
            return false;
        }
        if(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.val >= treeNode.val){
                return false;
            }
        }
        stack.push(treeNode);
        return doTravel(treeNode.right, stack);
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