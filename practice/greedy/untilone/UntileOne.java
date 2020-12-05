package greedy.untilone;

import java.util.Scanner;

class UntileOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int processCount = 0;

        while(N != 1) {
            if (N % K == 0) {
                N /= K;
            } else {
                N -= 1;
            }
            processCount++;
        }

        System.out.println(processCount);
    }

}
