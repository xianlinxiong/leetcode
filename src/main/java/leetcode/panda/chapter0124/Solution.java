package leetcode.panda.chapter0124;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] list = {7,6,4,3,1};


    }
    //全局变量，记录最大值
    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        doMaxPathSum(root);
        return maxPathSum;
    }

    /**
     * 递归调用，返回包含当前节点的最大值（最多只有单子树）
     * @param node
     * @return
     */
    private int doMaxPathSum(TreeNode node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int cur = node.val;
        int leftSum = doMaxPathSum(node.left);
        int rightSum = doMaxPathSum(node.right);
        int temMax = Math.max(leftSum, rightSum);
        //不包含当前节点，取左右子树两者最大值
        if(temMax > 0){
            maxPathSum = Math.max(maxPathSum, temMax);
            cur += temMax;
        }
        int tempMin = Math.min(leftSum, rightSum);
        //包含当前节点取最大值，可以有左右两颗子树
        if(tempMin > 0){
            maxPathSum = Math.max(maxPathSum, cur+tempMin);
        }else{
            maxPathSum = Math.max(maxPathSum, cur);
        }
        return cur;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}