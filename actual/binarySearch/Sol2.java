package algo.binarySearch;

import java.util.Scanner;

// 이진 탐색: 고정점 찾기
public class Sol2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        int startIdx = 0, endIdx = N - 1;
        int answer = -1;

        while (startIdx <= endIdx) {
            int midIdx = (startIdx + endIdx) / 2;
            int element = a[midIdx];

            // 요소랑 해당 인덱스가 같으면 정답! (answer 에 할당하고 끝)
            if (element == midIdx) {
                answer = midIdx;
                break;
            }

            //현재 인덱스보다 요소값이 크다면, 지금인덱스로는 지금 요소보다 큰애들을 만들 수가 없음.
            if (element > midIdx) {
                endIdx = midIdx - 1;
            //위와 반대의 경우.
            } else {
                startIdx = midIdx + 1;
            }
        }

        System.out.println(answer);
    }
}

/*
[TC1]
5
-15 -6 1 3 7

[TC2]
7
-15 -4 2 8 9 13 15

[TC3]
7
-15 -4 3 8 9 13 15

결과도 잘 나오고 logN 시간 만족할 것 같다.
*/