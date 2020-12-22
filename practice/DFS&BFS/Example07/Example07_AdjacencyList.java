package chapter03_dfsbfs;

import java.util.ArrayList;

public class Example07_AdjacencyList {
	// ndb code reference. 
	// python tuple객체 대신 Node class를 직접 구현해서, 사용하는 식으로 가능!
	// 인접리스트 방식 (ArrayList로 구현)
	public static ArrayList<ArrayList<Node1>> graph = new ArrayList<ArrayList<Node1>>();
	
	public static void main(String[] args) {
		// 초기화
		for(int i = 0; i< 3 ; i++) {
			graph.add(new ArrayList<Node1>());
		}
		
		graph.get(0).add(new Node1(1, 7));
		graph.get(0).add(new Node1(2, 5));
		graph.get(1).add(new Node1(0, 7));
		graph.get(2).add(new Node1(0, 5));

		for(int i = 0; i < 3; i++) {
			for(int j = 0 ; j < graph.get(i).size(); j ++) {
				graph.get(i).get(j).show();
			}
			System.out.println();
		}
	}
}


class Node1 {
	private int index;
	private int distance;
	
	Node1(int index, int distance){
		this.index = index;
		this.distance = distance;
	}
	
	public void show() {
		System.out.print("(" + this.index + ", " + this.distance+ ")");
	}
}