package jianzhi_offer;

import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49
 */
public class MinStack30 {
    /**
     * 包含min函数的栈
     * p165，面试题30
     */

    int min;
    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> normalStack = new Stack<>();

    public void push(int node) {
        if (normalStack.empty()) {
            min = node;
            minStack.push(node);
            normalStack.push(node);
        } else {
            min = node > min ? min : node;
            minStack.push(min);
            normalStack.push(node);
        }
    }

    public void pop() {
        normalStack.pop();
        minStack.pop();
    }

    public int top() {
        return normalStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
