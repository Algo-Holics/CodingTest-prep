package algo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main10825 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Score> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String name = sc.next();
            int ko = sc.nextInt();
            int en = sc.nextInt();
            int math = sc.nextInt();

            list.add(new Score(name, ko, en, math));
        }

        Collections.sort(list);

        for(Score s: list){
            System.out.println(s.name);
        }

    }
}

class Score implements Comparable<Score>{
    String name;
    int ko;
    int en;
    int math;

    Score(String name, int ko, int en, int math){
        this.name = name;
        this.ko = ko;
        this.en = en;
        this.math = math;
    }

    @Override
    public int compareTo(Score o) {
        //1. 국어점수 다른 경우엔 내림차(감소하는 순)
        if(this.ko != o.ko){
            return Integer.compare(o.ko, this.ko);
        //2. 영어점수 다른 경우 오름차
        }else if(this.en != o.en){
            return Integer.compare(this.en, o.en);
        //3. 수학점수 다른 경우 내림차
        }else if(this.math != o.math){
            return Integer.compare(o.math, this.math);
        //4. 점수 모두 같은 경우, 사전 증가
        }else{
            return this.name.compareTo(o.name);
        }
    }
}
