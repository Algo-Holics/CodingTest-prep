package chapter04_sort;

import java.util.ArrayList;
import java.util.Arrays;

public class CountSortTest {

	public static void main(String[] args) {
		int array[]= new int [10];
		for(int i = 0; i< array.length; i++) {
			array[i] = (int) (Math.random()* 10 + 1); 
		}
		System.out.print("계수 정렬 전: ");
		System.out.println(Arrays.toString(array));
		
		System.out.print("계수 정렬 후: ");
		System.out.println(Arrays.toString(countSort(array)));
	}
	public static Object[] countSort(int[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int max = Integer.MIN_VALUE;
		for(int i : arr) {
			if (i > max) {
				max = i;
			}
		}
		
		int[] count = new int[max + 1];
		
		for(int i = 0 ; i < arr.length; i++) {
			count[arr[i]]++;
		}
		
		for(int i = 0; i< count.length; i++) {
			for(int j = 0; j < count[i]; j ++) {
				list.add(i);
			}
		}
		
		return list.toArray();
	}
}

/*
모든 데이터가 양의 정수인 경우
N: 데이터의 개수, 데이터중 최대값: K
최악의 경우 수행시간 O(N+K)

데이터 크기 범위가 제한되어 정수 형태로 표현이 가능할 때만 사용할 수 있다.
*/