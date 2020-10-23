package leetcode.panda.chapter0111;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.generate(5));
    }

    /**
     * 树的递归遍历：
     *  根为空，返回0
     *  左子树为空，返回右子树高度
     *  右子树为空，返回左子树高度
     *  左右子树都不为空，返回左、右子树的高度最小值
     * @param root
     * @return
     */
    public int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null){
            return 1 + minDepth(root.right);
        }else if(root.right == null){
            return 1 + minDepth(root.left);
        }else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
    /**
     * 队列标志法
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if(null == root){
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tem = root;
        TreeNode last = root;
        queue.offer(root);
        while(true){
            TreeNode cur = queue.poll();
            if(cur.left == null && cur.right == null){
                break;
            }
            if(cur.left != null){
                queue.offer(cur.left);
                tem = cur.left;
            }
            if(cur.right != null){
                queue.offer(cur.right);
                tem = cur.right;
            }
            if(cur == last){
                depth++;
                last = tem;
            }
        }
        queue.clear();
        return depth;

    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}