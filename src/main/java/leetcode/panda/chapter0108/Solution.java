package leetcode.panda.chapter0108;

import java.util.*;

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

    public TreeNode sortedArrayToBST(int[] nums) {
        if(null == nums && nums.length == 0){
            return null;
        }
       return doBuild(nums, 0, nums.length-1);
    }

    /**
     * 折半查找建树
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private TreeNode doBuild(int[] nums, int start, int end){
        if(start >end){
            return null;
        }
        int middle = (start+end)/2;
        TreeNode node = new TreeNode(nums[middle]);
        TreeNode left = doBuild(nums, start, middle-1);
        TreeNode right = doBuild(nums, middle+1, end);
        node.left = left;
        node.right = right;
        return node;
    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}