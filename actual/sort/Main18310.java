package algo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main18310 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        //약간은 찍었음;
        //일단 처음에 시간제한도 작고 공간도 작아서 반복문으로 모든 거리의합을 구하는건 아닐거라 예상해봄;
        //두번째는 가운데 두 집이 가장 거리차이의 합이 작을것이니까, 그 둘을 비교하면되는데 문제에서 두 집들 중 작은 집을 출력하라 했음.
        //그래서 (전체 거리 -1) /2 로 가운데 두 개 중 앞에 값을 가져왔음.
        System.out.println(list.get((n-1)/2));
    }
}

