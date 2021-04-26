package algo.binarySearch;

import java.util.Scanner;

//이진탐색 1번 문제: 고정점 찾
public class Sol1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int x = sc.nextInt();

        int[] A = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        int start = 0, end = N-1;

        while(start <= end){
            // 양끝에서부터 찾아오던 것들이 둘다 x 면, x 가 가능한 최소, 최대를 구한거니까 break.
            if(A[start] == x && A[end] == x){
               break;
            }

            int mid = (start + end)/2;

            // 중앙(기준값이 x) 일 때, end 와 start 를 업데이트 해야한다.
            if(A[mid] == x){
                // end 위치의 값이 x 면 변동 필요 없지만, 찾던 값이 아니면 한칸 줄여준다.
                end = A[end] == x? end: end-1;
                start = A[start] == x? start: start+1;
            }else{
                // 찾고자 하는 값이 중앙에 있지 않으면 이진 탐색으로 기준점을 찾아준다.
                if(A[mid] > x){
                    end = mid -1;
                }else{
                    start = mid+1;
                }
            }
        }

        if(start>end){
            System.out.println(-1);
        }else{
            System.out.println(end - start + 1);
        }
    }
}

/*
*
7 2
1 1 2 2 2 2 3
(결과 4)

7 4
1 1 2 2 2 2 3
(결과 -1)

7 3
1 1 2 2 2 2 3
(결과 1)

7 1
1 1 2 2 2 2 3
(결과 2)

예상대로 결과는 잘 나오는데, NlogN을 만족할지는 감이 오지 않아서 정해 풀이를 참조해야겠다.
* */