package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class ElementExchange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] array1 = new int[N];
        Integer[] array2 = new Integer[N];

        for (int i = 0; i < N; i++) {
            array1[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            array2[i] = sc.nextInt();
        }

        Arrays.sort(array1);
        Arrays.sort(array2, Comparator.reverseOrder());

        int maxASum = 0;
        for (int i = 0; i < N; i++) {
            if (K-- > 0 && array1[i] < array2[i]) {
                maxASum += array2[i];
            } else {
                maxASum += array1[i];
            }
        }

        System.out.println(maxASum);
    }

}
