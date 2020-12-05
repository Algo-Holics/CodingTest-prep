package greedy.untilone;

import java.util.Scanner;

class UntileOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int processCount = 0;

        while(true) {
            int nextN = (N / K) * K;
            processCount += N - nextN;

            N = nextN;
            N /= K;
            processCount++;
            if (N <= 1) {
                break;
            }
        }

        System.out.println(processCount);
    }

}
