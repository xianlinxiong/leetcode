package leetcode.panda.chapter0155;

import java.util.Stack;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 */
class MinStack {

    private Stack<Integer> container;

    private Stack<Mini> miniStack;

    public MinStack() {
        container = new Stack<>();
        miniStack = new Stack<>();
    }

    public void push(int x) {
        container.push(x);
        if (miniStack.isEmpty()) {
            miniStack.push(new Mini(x));
        } else {
            Mini top = miniStack.peek();
            if (x < top.value) {
                miniStack.push(new Mini(x));
            } else if (x == top.value) {
                top.count= top.count + 1;
            }
        }
    }

    public void pop() {
        if (!container.isEmpty()) {
            int k = container.pop();
            Mini mini = miniStack.peek();
            if (mini.value == k) {
                mini.count = mini.count - 1;
                if(mini.count == 0){
                    miniStack.pop();
                }
            }
        }

    }

    public int top() {
        return container.peek();
    }

    public int getMin() {
        Mini mini = miniStack.peek();
        return mini.value;
    }

    class Mini {
        int value;
        int count;

        Mini(int value) {
            this.value = value;
            count = 1;
        }
    }
}