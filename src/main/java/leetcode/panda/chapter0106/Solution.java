package leetcode.panda.chapter0106;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] postorder  = {9,15,7,20,3};
        int[] inOrder ={9,3,15,20,7};
        TreeNode node = s.buildTree(inOrder, postorder);
        System.out.println(node);
    }

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        if(inOrder == null || inOrder.length == 0){
            return null;
        }
        return doBuild(inOrder,0, inOrder.length-1, postOrder, 0, postOrder.length-1);
    }

    private TreeNode doBuild(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd){
        if(postStart > postEnd ){
            return null;
        }
        TreeNode node = new TreeNode(post[postEnd]);
        if(postStart ==  postEnd){
            return node;
        }
        int cur = post[postEnd];
        int index = inStart;
        while(in[index] != cur){
            index++;
        }
        int count = index - inStart;
        TreeNode left = doBuild(in, inStart,index-1, post, postStart, postStart+count-1);
        TreeNode right = doBuild(in, index+1,inEnd, post, postStart+count, postEnd-1);
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