package ex2.dataStructure;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {

        Exam[] exams = new Exam[3];
        /*exams[0] = new Exam(); //이 부분이 들어가야 밑에 코드가 실행 가능
        exams[0].kor = 30;

        System.out.printf("kor: %d", exams[0].kor);*/

        int menu;
        boolean keepLoop = true;

        while (keepLoop) {
            menu = inputMenu(); //메뉴입력()만 쓰면 에러, 앞에 menu = 를 붙여야 가능

            switch (menu) {
                case 1:
                    inputList(exams); //korList로 받아줌

                    break;
                case 2:
                    printList(exams);

                    break;
                case 3:
                    System.out.println("Bye~~");

                    keepLoop = false;
                    break;

                default:
                    System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
            }
        }
    }

    private static void printList(Exam[] exams) {
        System.out.println("┌──────────────────┐");
        System.out.println("│     성적 출력      │");
        System.out.println("└──────────────────┘");
        System.out.println();

        for(int i = 0; i<3; i++) {//i<exams.length는 방의 개수이지 성적의 개수는 아님
            Exam exam = exams[i]; //0이 아닌 i로 바꿔주기
            int kor = exam.kor;  //for문 안에 변수를 선언한다고 해서 매번 선언되는 것이 아니라서
            int eng = exam.eng;  //for문 안이나 밖에서나 한번만 선언됨 (연산만 반복)
            int math = exam.math;

            int total = kor + eng + math;
            float avg = total / 3.0f;

            System.out.printf("국어 : %d\n", kor);
            System.out.printf("영어 : %d\n", eng);
            System.out.printf("수학 : %d\n", math);

            System.out.printf("총점 : %3d\n", total);
            System.out.printf("평균 : %6.2f\n", avg);
            System.out.println("────────────────────────");
        }
    }

    private static void inputList(Exam[] exams) {
        Scanner scan = new Scanner(System.in);

        System.out.println("┌──────────────────┐");
        System.out.println("│     성적 입력      │");
        System.out.println("└──────────────────┘");
        System.out.println();

        for(int i = 0; i<3; i++) { //여기서는 exams.length가능

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
            } while (math < 0 || 100 < math);

            Exam exam = new Exam();
            exam.kor = kor;
            exam.eng = eng;
            exam.math = math;

            exams[i] = exam; //배열에 담기 위해서 꼭 필요
        }
    }

    static int inputMenu(){
        Scanner scan = new Scanner(System.in);

        System.out.println("┌──────────────────┐");
        System.out.println("│     메인 메뉴      │");
        System.out.println("└──────────────────┘");
        System.out.println("\t1. 성적입력 ");
        System.out.println("\t2. 성적출력 ");
        System.out.println("\t3. 종료 ");
        System.out.println("\t선택> ");

        int menu = scan.nextInt();

        return menu; //return 값이 있으니 void가 아니라 int, menu 앞에도 int 붙여줘야 함
    }
}