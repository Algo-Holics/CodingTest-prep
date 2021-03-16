package implement;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
	}

	public static int solution(String s) {
        //문자열 길이가 2 이하면 가장 최소 압축은 문자열 길이니까 return
		if(s.length()<=2) return s.length();
		
		//answer가 될수있는 최초의 최소값은 s.length();
		int answer = s.length();

		//i: 문자열의 길이, j: 비교할 문자열 갯수 (최대 s.length()/2)
		for (int i = 1; i <= s.length() / 2; i++) {
			String tempStr = "", prev = "", nxt = "";
			int cnt = 1;
			for (int j = 0; j <= s.length() / i; j++) {
				// j*i: 자를 문자열 시작점, (j+1)*i : 자를 문자열 끝나는 점
				//(j+1) * i 가 문자열 길이보다 길 경우, 문자열 길이까지만 자르기.
				prev = nxt;
				nxt = s.substring(j * i, (j + 1) * i > s.length() ? s.length() : (j + 1) * i);
				if (prev.equals(nxt)) {
					cnt++;
				} else {
					if (cnt > 1) {
						tempStr += (cnt + prev);
						cnt = 1;
					} else {
						tempStr += prev;
					}
				}
			}
			//남은 문자열을 더하기 전, cnt가 1보다 크면 숫자도 더하고 아니면 남은 문자열만 더해줌.
			tempStr += (cnt > 1 ? (cnt + nxt) : nxt);

			//저장되있던answer보다 길이가 작게 압축이 되었다면 값 update해주기.
			if (tempStr.length() < answer) {
				answer = tempStr.length();
			}
		}

		return answer;
	}
}
