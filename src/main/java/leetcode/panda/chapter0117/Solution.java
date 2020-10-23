package leetcode.panda.chapter0117;

/**
 *
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.generate(5));
    }

    public Node connect(Node root) {
        //处理根节点
        Node node = root;
        Node next;
        Node last = node;
        //循环遍历处理下层非叶子节点，
        while(node != null){
            next = node;
            node = null;
            while(next != null){
                Node temp = doConnect(next);
                if(node ==  null){
                    node = temp;
                    if(temp != null){
                        last = temp.next == null ? temp : temp.next;
                    }
                }else if(temp != null){
                    last.next = temp;
                    last = temp.next == null ? temp : temp.next;
                }
                next = next.next;
            }
        }

        return root;
    }

    /**
     * 链接node 的子节点，返回左节点（完全二叉树，左节点必然是node节点最左节点）
     * @param node
     * @return
     */
    private Node doConnect(Node node){
        if(node == null){
            return null;
        }
        if(node.left != null){
            node.left.next = node.right;
        }
        return node.left == null ? node.right:node.left;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}