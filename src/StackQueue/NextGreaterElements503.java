package StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements503 {
	public int[] nextGreaterElements(int[] nums) {
		int[] rt = new int[nums.length];
		Arrays.fill(rt, -1); // 默认值是-1，即找不到
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums.length * 2; i++) {
			while (!stack.isEmpty()) {
				int stackTop = stack.peek();
				if (nums[stackTop % nums.length] >= nums[i % nums.length]) {
					stack.push(i);
					break;
				} else if (nums[stackTop % nums.length] < nums[i % nums.length]) {
					stack.pop();
					rt[stackTop % nums.length] = nums[i % nums.length];
				}
			}
			stack.push(i);
		}
		return rt;
	}
	
	public static void main(String[] args) {
		int []a = {1,2,1};
		NextGreaterElements503 oElements503 = new NextGreaterElements503();
		System.out.println(oElements503.nextGreaterElements(a));
		
	}
}
