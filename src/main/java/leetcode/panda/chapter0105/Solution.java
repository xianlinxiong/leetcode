package leetcode.panda.chapter0105;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder ={9,3,15,20,7};
        TreeNode node = s.buildTree(preOrder, inOrder);
        System.out.println(node);
//        System.out.println(s.generate(5));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        return doBuild(preorder,0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode doBuild(int[] pre, int preStrat, int preEnd, int[] in, int inStart, int inEnd){
        if(preStrat > preEnd ){
            return null;
        }
        TreeNode node = new TreeNode(pre[preStrat]);
        if(preStrat ==  preEnd){
            return node;
        }
        int cur = pre[preStrat];
        int index = inStart;
        while(in[index] != cur){
            index++;
        }
        int count = index - inStart;
        TreeNode left = doBuild(pre, preStrat+1,preStrat+count, in, inStart, index-1);
        TreeNode right = doBuild(pre, preStrat+count+1,preEnd, in, index+1, inEnd);
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