package jianzhi_offer;

import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106
 */
public class IsStackPopOrder31 {
    /**
     * 面试题31 p168.判断栈的弹出顺序能不能是popA
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int pushPtr = 1;  // 当前遍历到的pushA的位置
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[0]);
        for (int num : popA) {
            while (num != stack.peek()) {
                if (pushPtr < pushA.length) {
                    stack.push(pushA[pushPtr]);
                    pushPtr++;
                } else {
                    return false;
                }
            }
            stack.pop();
        }
        return true;
    }
}
