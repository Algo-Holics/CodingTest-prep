package chapter03_dfsbfs;

import java.util.Collections;
import java.util.Stack;

public class Example01_stack {

	public static void main(String[] args) {
		//stack class를 사용해보자!
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(5);
		stack.push(2);
		stack.push(3);
		stack.push(7);
		stack.pop();
		stack.push(1);
		stack.push(4);
		stack.pop();
		
		////[5, 2, 3, 1] 로 출력
		System.out.println(stack);
//		System.out.println("" + stack);
//		System.out.println(stack.toString()); 	
//		System.out.println(Arrays.toString(stack.toArray())); 
		
		System.out.println("------");
		// [1,3,2,5] 로 출력
		Collections.reverse(stack);
		System.out.println(stack);
	}
}


/*
 * 참조 자료: https://www.geeksforgeeks.org/stack-class-in-java/
 * 참조 자료: https://stackoverflow.com/questions/12160183/printing-the-stack-values-in-java
 * 참조 자료: https://www.acmicpc.net/board/view/29554
 */