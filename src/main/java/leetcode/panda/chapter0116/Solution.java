package leetcode.panda.chapter0116;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
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
 * 示例：
 *
 *
 *
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 *
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
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
        //记录下层节点
        Node last;
        //当前层次的处理节点
        Node next;
        //循环遍历处理下层非叶子节点，
        while(node != null && node.left != null){
            Node temp = doConnect(node);
            next = node.next;
            last = temp.next;
            while(next != null){
                temp = doConnect(next);
                if(last != null){
                    last.next = temp;
                    last = temp.next;
                }
                next = next.next;
            }
            node = node.left;
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
        return node.left;
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