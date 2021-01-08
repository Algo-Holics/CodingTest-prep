package binary.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Ddukboki {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] ddukList = new int[N];
        for (int i = 0; i < N; i++) {
            ddukList[i] = sc.nextInt();
        }
        Arrays.sort(ddukList);

        System.out.println(maxDduk(ddukList, M));
    }

    private static int maxDduk(
        int[] sortedList,
        int target) {

        int startLength = 0;
        int endLength = sortedList[sortedList.length - 1];

        while (startLength <= endLength) {
            int currentLength = (endLength + startLength) / 2;

            int cuttedDdukLength = cuttedDdukLength(sortedList, currentLength);
            if (cuttedDdukLength <= target) {
                return currentLength;
            } else {
                startLength = currentLength - 1;
            }
        }
        return -1;
    }

    private static int cuttedDdukLength(
        int[] sortedList,
        int currentLength) {
        int endIdx = sortedList.length - 1;
        int totalCuttedDdukLength = 0;
        for (int i = endIdx; i >= 0; i--) {
            int remainDdukLength = sortedList[i] - currentLength;
            if (remainDdukLength <= 0) {
                break;
            }
            totalCuttedDdukLength += remainDdukLength;
        }
        return totalCuttedDdukLength;
    }
}
