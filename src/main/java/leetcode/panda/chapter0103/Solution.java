package leetcode.panda.chapter0103;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.generate(5));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(null == root){
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = root;
        TreeNode last = root;
        int round =0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(2);
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
            if(round%2 == 0){
                temp.add(current.val);
            }else {
                temp.add(0, current.val);
            }
            if(current == node){
                node = last;
                result.add(temp);
                temp = new ArrayList<>();
                round++;
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