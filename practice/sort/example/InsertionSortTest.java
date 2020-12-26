package chapter04_sort;

import java.util.Arrays;

public class InsertionSortTest {

	public static void main(String[] args) {
		int array[]= new int [10];
		for(int i = 0; i< array.length; i++) {
			array[i] = (int) (Math.random()* 10 + 1); 
		}
		System.out.print("삽입 정렬 전: ");
		System.out.println(Arrays.toString(array));
		
		System.out.print("삽입 정렬 후: ");
		System.out.println(Arrays.toString(insertsionSort(array)));
	}
	
	public static int[] insertsionSort(int[] arr) {
		for(int i = 1; i< arr.length; i++) {
			for(int j = i; j> 0; j--) {
				if(arr[j-1] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}else {
					break;
				}
			}
		}
		return arr;
	}
}

// idx가 1~len(arr)인 동안, 그 위치를 기준으로 앞에 하나씩 비교하면서, 작은 경우에만 swap
// 만약 한번이라도 기준값이 크다면 더 돌지 않고 넘어간다(break)