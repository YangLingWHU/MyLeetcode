package 剑指offer_后缀为书中题号;

import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * p68 面试题9
 */
public class TwoStacksToOneQueue09 {
    // p68 面试题9
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    // 队列先进先出，栈先进后出
    public int pop() {
        while (!stack1.empty()) {
            int temp = stack1.pop();
            stack2.push(temp);
        }
        int rt = stack2.pop();
        while (!stack2.empty()) {
            int temp = stack2.pop();
            stack1.push(temp);
        }
        return rt;
    }
}
