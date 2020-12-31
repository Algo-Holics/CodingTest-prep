package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class gradeStudent {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            String[] studentInfo = sc.nextLine().split(" ");
            Student student = Student.newStudent(
                studentInfo[0],
                Integer.parseInt(studentInfo[1]));
            students[i] = student;
        }

        Arrays.sort(students, Comparator.comparing(Student::getScore));

        for (Student student : students) {
            System.out.print(student.getName() + " ");
        }
    }

    private static class Student {
        private final String name;
        private final Integer score;

        private Student(final String name, final Integer score) {
            this.name = name;
            this.score = score;
        }

        public static Student newStudent(final String name, final Integer score) {
            return new Student(name, score);
        }

        public String getName() {
            return name;
        }

        public Integer getScore() {
            return score;
        }
    }

}
