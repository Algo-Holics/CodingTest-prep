package chapter04_sort;

import java.util.Arrays;

public class QuickSortTest {

	public static void main(String[] args) {
//		랜덤 배열 선언해서 테스트
		int array[]= new int [10];
		for(int i = 0; i< array.length; i++) {
			array[i] = (int) (Math.random()* 10 + 1); 
		}
//		책 예제
//		int array[] = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};
		System.out.print("선택 정렬 전: ");
		System.out.println(Arrays.toString(array));
		
		quickSort(array, 0, array.length -1);

		System.out.print("선택 정렬 후: ");
		System.out.println(Arrays.toString(array));
		
	}

	public static void quickSort(int[] arr, int start, int end) {
		if(start >= end) return;
		
		int pivot = start;
		int left = start + 1;
		int right = end;

		while(left <= right) {
			while(left <= end &&  arr[left] <= arr[pivot]) {
				left++;
			}
			while (right > start && arr[right] >= arr[pivot]) {
				right--;
			}
			if(left > right) {
				swap(arr,  pivot, right);
			}else {
				swap(arr, left, right);
			}
		}
		
		quickSort(arr, start, right-1);
		quickSort(arr, right+1, end);
		
	}
	
	public static void swap(int[] arr, int a, int b) {
		System.out.println(Arrays.toString(arr) + " " + a+" " + b);
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}

//pivot을 기준으로 [좌에서부터 pivot보다 큰 값의 위치]와 [우에서부터 pivot보다 작은값의 위치] 를 찾는다.
	// 만약 이때 좌, 우의 위치가 반전이 안된 경우에는 서로 swap
	// 반전이 된 경우에는 pivot과 right을 swap해준다.
// pivot을 기준으로, 좌에는 pivot보다 작은 값들만, 우에는 큰값만 들어가진다.
// 다시 좌, 우를 또 quick_sort 반복해주면 정렬 완료

// 시간복잡도: O(NlogN)