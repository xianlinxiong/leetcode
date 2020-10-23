package leetcode.panda.chapter0107;

import java.util.*;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.generate(5));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(null == root){
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = root;
        TreeNode last = root;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        TreeNode current = queue.poll();;
        do{
            if(current.left != null){
                queue.offer(current.left);
                last = current.left;
            }
            if(current.right != null){
                queue.offer(current.right);
                last = current.right;
            }
            temp.add(current.val);
            if(current == node){
                node = last;
                result.add(0,temp);
                temp = new ArrayList<>();
            }
            current = queue.poll();
        }while(current != null);

        return result;

    }



     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}