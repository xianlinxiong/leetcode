package leetcode.panda.chapter0113;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
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
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();

        doPathSum(root, sum, new ArrayList<>(),result);
        return result;
    }

    public void doPathSum(TreeNode node, int sum, List<Integer> list, List<List<Integer>> result){
        if(node == null){
            return;
        }
        list.add(node.val);
        if(node.left== null && node.right== null && sum == node.val){
            result.add(new ArrayList<>(list));
        }
        doPathSum(node.left, sum-node.val, list,result);
        doPathSum(node.right, sum-node.val, list, result);
        list.remove(list.size()-1);
    }


     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}