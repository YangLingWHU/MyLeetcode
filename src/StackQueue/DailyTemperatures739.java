package StackQueue;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class DailyTemperatures739 {
	public int[] dailyTemperatures(int[] T) {
		int[] rt = new int[T.length]; // 默认初始值为0
		Stack<Integer> stack = new Stack<>();  //存放下标
		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty()) {
				int stackTop = stack.peek();
				if (T[stackTop] >= T[i]) {
					stack.push(i);
					break;
				} else if (T[stackTop] < T[i]) {
					stack.pop();
					rt[stackTop] = i - stackTop;
				}
			}
			stack.push(i);
		}
		return rt;
	}
}
