package binary.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class SearchPartial {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        binarySearchSolution();
    }

    private static void binarySearchSolution() {
        int N = sc.nextInt();
        int[] partialList = new int[N];
        for (int i = 0; i < N; i++) {
            partialList[i] = sc.nextInt();
        }
        Arrays.sort(partialList);

        int M = sc.nextInt();
        int[] searchPartial = new int[M];
        for (int i = 0; i < M; i++) {
            searchPartial[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int targetPartial = searchPartial[i];

            System.out.print(
                booleanAssembler(
                    binarySearch(partialList, targetPartial)));

            System.out.print(" ");
        }
    }

    private static boolean binarySearch(
        int[] sortedPartialList,
        int targetPartial) {

        int startIdx = 0;
        int endIdx = sortedPartialList.length - 1;

        do {
            int currentIdx = (endIdx + startIdx) / 2;

            if (sortedPartialList[currentIdx] == targetPartial) {
                return true;
            } else if (sortedPartialList[currentIdx] < targetPartial) {
                startIdx = currentIdx + 1;
            } else {
                endIdx = currentIdx - 1;
            }
        } while (startIdx <= endIdx);

        return false;
    }

    private static void setSolution() {
        int N = sc.nextInt();
        Set<Integer> partialList = new HashSet<>();
        for (int i = 0; i < N; i++) {
            partialList.add(sc.nextInt());
        }

        int M = sc.nextInt();
        int[] searchPartial = new int[M];
        for (int i = 0; i < M; i++) {
            searchPartial[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            System.out.print(
                booleanAssembler(
                    partialList.contains(searchPartial[i])));
            System.out.print(" ");
        }
    }

    private static String booleanAssembler(boolean bool) {
        return bool ? "yes" : "no";
    }

}
