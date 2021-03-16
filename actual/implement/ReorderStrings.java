package implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReorderStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		
		// sum: 숫자만 더해줄 변수, 
		// list: 문자열 저장할 변수, 문자열들 저장후 오름차 정렬해주기
		int sum =0;
		List<Character> list = new ArrayList<>();
		String ans = "";
		
		for(int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if(0 <= c-'0' && c-'0' <10) {
				sum += (c-'0');
			}else {
				list.add(c);
			}
		}
		
		Collections.sort(list);
		
		//문자열 더해주고, 숫자더해진값 더해준다음 출력.
		for(int i = 0; i < list.size(); i++) {
			ans+= list.get(i);
		}
		ans += sum +"";
	
		System.out.println(ans);
	}

}


/*
 * TC1: K1KA5CB7
 * TC2: AJKDLSI412K4JSJ9D
 */