package ex2.dataStructure;

import java.util.Scanner;

public class ExamProgram {
    public static void main(String[] args) {

        Exam exam = new Exam(); //new를 붙인 객체 Exam(의 참조변수 가져옴)의 식별자 exam

        /*
        Exam[] exams = new Exam[3]; 이건 객체가 아니라 배열, 따라서 아직 국영수 이름 없음.
        따라서 exams[0].kor = 30; 불가능. 이렇게 하려면
        exams[0] = new Exam(); 이라고 만든 후 > exams[0]번째에 국영수 모두 들어감
        exams[0].kor = 30; 가능

        exam.kor = 30; //Exam이라는 객체의 kor라는 공간
        exam.eng = 40;
        exam.math = 50;

        System.out.printf("kor:%d", exam.kor);
        */

        input(exam);

        print(exam);


    }

    private static void input(Exam exam) {
        Scanner scan = new Scanner(System.in);

        System.out.println("┌──────────────────┐");
        System.out.println("│     성적 입력      │");
        System.out.println("└──────────────────┘");
        System.out.println();

        int kor, eng, math;
        do {
            System.out.printf("국어 : ");
            kor = scan.nextInt();

            if (kor < 0 || 100 < kor) {
                System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
            }
        } while (kor < 0 || 100 < kor);

        do {
            System.out.printf("영어 : ");
            eng = scan.nextInt();

            if (eng < 0 || 100 < eng) {
                System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");
            }
        } while (eng < 0 || 100 < eng);

        do {
            System.out.printf("수학 : ");
            math = scan.nextInt();

            if (math < 0 || 100 < math) {
                System.out.println("수학성적은 0~100까지의 범위만 입력이 가능합니다.");
            }
        } while (math< 0 || 100 < math);

        exam.kor = kor;
        exam.eng = eng;
        exam.math = math;
    }

    private static void print(Exam exam) {
        System.out.println("┌──────────────────┐");
        System.out.println("│     성적 출력      │");
        System.out.println("└──────────────────┘");
        System.out.println();

        int kor = exam.kor;
        int eng = exam.eng;
        int math = exam.math;

        int total = kor+ eng+ math;
        float avg = total/3.0f;

        System.out.printf("국어 : %d\n", kor);
        System.out.printf("영어 : %d\n", eng);
        System.out.printf("수학 : %d\n", math);


        System.out.printf("총점 : %3d\n", total);
        System.out.printf("평균 : %6.2f\n", avg);
        System.out.println("────────────────────────");
    }
}

