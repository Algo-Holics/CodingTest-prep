package chapter03_dfsbfs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Example02_queue {
	public static void main(String[] args) {
		Queue <Integer> queue = new LinkedList<Integer>();
		
		// 삽입: add() | offer()
		queue.add(5);
		queue.add(2);
		queue.add(3);
		queue.offer(7);
		
		// 삭제: poll() | remove()
		// poll - 첫번째 값 반환 (비어있을 경우 null) 후 삭제
		// remove - 삭제만
		queue.poll();
		queue.add(1);
		queue.add(4);
		queue.remove();
		
		//[3, 7, 1, 4]출력
		System.out.println(queue);
		
		//[4, 1, 7, 3] 출력
		Collections.reverse((List<Integer>) queue);
		System.out.println(queue);
		//반복문으로 거꾸로 출력하는 수 밖에 없는지 궁금;
	}
}
