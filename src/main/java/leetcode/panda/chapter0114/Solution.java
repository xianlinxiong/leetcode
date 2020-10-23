package leetcode.panda.chapter0114;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.generate(5));
    }

    /**
     * 递归遍历，出口 树为空， false
     *                树为叶子节点，且val等于sum,添加到结果集
     * @param root
    * @return
     */
    public void flatten(TreeNode root) {
        doFlattern(root);
    }

    private TreeNode doFlattern(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = doFlattern(root.left);
        TreeNode right = doFlattern(root.right);
        if(left== null){
            root.right = right;
        }else{
            root.left = null;
            root.right = left;
            while(left.right != null){
                left = left.right;
            }
            left.right = right;
        }
        return root;
    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}