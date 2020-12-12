package implement;

import java.util.Scanner;

class Time {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int count = 0;

        for (int hour = 0; hour <= N; hour++) {
            if (isIncludeNumber(hour, 3)) {
                count += (60 * 60);
            } else {
                for (int min = 0; min <= 59; min++) {
                    if (isIncludeNumber(min, 3)) {
                        count += 60;
                    } else {
                        for (int sec = 0; sec <= 59; sec++) {
                            if (isIncludeNumber(sec, 3)) {
                                count++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static boolean isIncludeNumber( int number, int searchNumber) {
        if ( number == searchNumber
            || number % 10 == searchNumber
            || number / 10 == searchNumber) {
            return true;
        }
        return false;
    }

}
