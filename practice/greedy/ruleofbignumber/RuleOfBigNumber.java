package greedy.ruleofbignumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class RuleOfBigNumber {

    public static void main(String[] args) {
        int maxTotalNumber = 0;

        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        int sumCount = sc.nextInt();
        int maxSumIdxCount = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();
        while(--arraySize >= 0) {
            numbers.add(sc.nextInt());
        }

        Collections.sort(numbers, Comparator.reverseOrder());

        int maxNumber = numbers.get(0);
        int secondNumber = numbers.get(1);

        int numberOfTerm = sumCount / (maxSumIdxCount + 1);
        if (numberOfTerm > 0) {
            maxTotalNumber = ((maxNumber * maxSumIdxCount) + secondNumber) * numberOfTerm;
        }
        maxTotalNumber += (maxNumber * (sumCount % (maxSumIdxCount + 1)));

        System.out.println(maxTotalNumber);
    }
}
