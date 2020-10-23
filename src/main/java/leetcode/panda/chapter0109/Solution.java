package leetcode.panda.chapter0109;

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

    public TreeNode sortedListToBST(ListNode node) {
        return doBuild(node,null);
    }

    /**
     * 参考数组折半法建树
     * @param start
     * @param end
     * @return
     */
    private TreeNode doBuild(ListNode start, ListNode end){
        if(start == end){
            return null;
        }
        ListNode one = start;
        ListNode two = start.next;
        while(two != end){
            one = one.next;
            two = two.next;
            if(two == end){
                break;
            }
            two = two.next;
        }
        TreeNode node = new TreeNode(one.val);
        TreeNode left = doBuild(start, one);
        TreeNode right = doBuild(one.next, end);
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


     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

}