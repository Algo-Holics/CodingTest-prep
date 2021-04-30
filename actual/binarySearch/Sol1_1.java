package algo.binarySearch;

import java.util.Scanner;

public class Sol1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int x = sc.nextInt();

        int[] A = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        int left = leftSearch(A, x, 0, N);
        int right = rightSearch(A, x, 0, N);

        int diff = right - left;

        if(diff == 0) System.out.println(-1);
        else System.out.println(diff);
    }

    public static int leftSearch(int arr[], int target, int start, int end){
        while(start<end){
            int mid = (start + end) /2;
            if(arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int rightSearch(int arr[], int target, int start, int end){
        while(start<end){
            int mid = (start + end) / 2;
            if(arr[mid] > target) end = mid;
            else start = mid+1;
        }
        return end;
    }
}
