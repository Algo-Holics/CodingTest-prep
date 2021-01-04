package chapter05_binarySearch;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열 입력하세요.");
		 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String target = sc.next();
		
		sc.nextLine();
		System.out.println("앞서 적은 원소 개수 만큼 문자열을 입력하세요. 구분은 띄어쓰기 한칸으로 합니다.");
		String[] array = sc.nextLine().split(" ");
		
		int res = sequentail_search(n, target, array);
		
		System.out.println(res==-1?"해당하는 문자 없음":res);
		sc.close();
	}

	private static int sequentail_search(int n, String target, String[] array) {
		for(int i = 0 ; i < n; i++) {
			if(array[i].equals(target)) return i+1;
		}
		//해당 값 없을 경우 -1 리턴
		return -1;
	}
	
}
