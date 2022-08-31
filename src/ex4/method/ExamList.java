package ex4.method;

import java.util.Scanner;

public class ExamList {
    private Exam[] exams;
    private int current; //private으로 바꿔서 다른 클래스 사용시 에러 발생 막음

    /*static void printList(ex06ExamList list) { current가 size
    printList(list, list.current);} 기본함수의 집중화
     */

    public void printList() { //current가 size
        printList(current); //기본함수의 집중화
    }

    public void printList(int size) { //파라미터에 int size가 새로 나옴
        System.out.println("┌──────────────────┐");
        System.out.println("│     성적 출력      │");
        System.out.println("└──────────────────┘");
        System.out.println();

        //int size = list.current;
        Exam[] exams = this.exams; // this 지우면 에러

        for (int i = 0; i < size ; i++) {//i<exams.length는 방의 개수이지 성적의 개수는 아님
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
    /*static void printList(ex06ExamList list, int size) {
        System.out.println("┌──────────────────┐");
        System.out.println("│     성적 출력      │");
        System.out.println("└──────────────────┘");
        System.out.println();

        //int size = list.current;
        Exam[] exams = list.exams;

        for (int i = 0; i < size; i++) {//i<exams.length는 방의 개수이지 성적의 개수는 아님
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
    }*/
    public void inputList() {
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
        } while (math < 0 || 100 < math);

        Exam exam = new Exam();
        exam.kor = kor;
        exam.eng = eng;
        exam.math = math;
        Exam[] exams = this.exams; //list.을 인스턴스 메소드화 시킨 후엔 this.로 바꿔야 함
        int size = current;

        if (exams.length == size) {
            //1. 크기가 5개 정도 더 큰 새로운 배열 생성
            Exam[] temp = new Exam[size + 5];
            //2. 값 이주시키기
            for (int i = 0; i < size; i++)
                temp[i] = exams[i];
            //3. list.exams가 새로운 temp 배열 참조하기
            exams = temp;
        }
        exams[current] = exam; //배열에 담기 위해서 꼭 필요
        current++; //3번 밖에 성적 입력을 못함
    }
    public ExamList(){
        exams = new Exam[3];  //this
        current = 0;
    }
}
