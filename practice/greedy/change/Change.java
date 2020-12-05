package chapter01_greedy;

public class Change {
	public static void main(String[] args) {
		int n = 1260;
		int count = 0;
	
		int []list = {500, 100, 50, 10};
		
		for(int i : list) {
			count += n/i;
			n %= i;
		}
		
		System.out.println(count);
	}
}