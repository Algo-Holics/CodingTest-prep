package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Muji {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2 };
		int k = 5;

		System.out.println(solution(arr, k));
	}
	//효율성 테스트 다 실패(solution)
	private static int solution(int[] food_times, int k) {
		if(sum(food_times) <=k) {
			return -1;
		}
		
		Queue<Food> pq = new PriorityQueue<Food>();
		
		for(int i = 0; i < food_times.length; i++) {
			pq.add(new Food(food_times[i], i+1));
		}
		
		
		//spendTime: 먹기 위해 사용한 시간, //prev: 이전 시간
		long spendTime = 0, prev = 0;
		int len = food_times.length;

		while(spendTime + (pq.peek().time-prev)*len <= k) {
			long now = pq.poll().time;
			spendTime += (now-prev) * len;
			len--;
			prev = now;
		}
		
		List <Food> list = new ArrayList<Food>();
		
		for(int i = 0; i < pq.size(); i++) {
			list.add(pq.poll());
		}
		
		Collections.sort(list, new Comparator<Food>() {
			@Override
			public int compare(Food f1, Food f2) {
				return f1.idx - f2.idx;
			}
		});
		
		return list.get((int)(k-spendTime)%len).idx;
	}

	private static int sum(int[] food_times) {
		int ret = 0;
		for(int i = 0; i < food_times.length; i++) {
			ret+=food_times[i];
		}
		return ret;
	}

}

class Food implements Comparable<Food> {
	int time;
	int idx;

	Food(int time, int idx) {
		this.time = time;
		this.idx = idx;
	}

	@Override
	public int compareTo(Food o) {
		return Integer.compare(this.time, o.time);
	}
}


/*
 * [오래 생각한 부분]
 * 1. Queue를 사용 했는데, deque로 두고 모두 simulation하려 했었다.(제한시간 초과)
 * 2. 큰 수를 생각 못해서 계속 int로 두고 해서 tc가 다 돌아가지 않았었다.
 * 3. sort할 때 처음에 time 기준으로 정렬을 해서 구현하는 것 까진 수월하게 했는데 index 기준으로 어떻게 정렬할지 생각못함;
 *    => list에 add해서 sorting;;ㅠ
 */