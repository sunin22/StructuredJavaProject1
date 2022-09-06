package ex5.getterSetter;

import java.util.Scanner;

public class ExamList {
    private Exam[] exams;
    private int current; //private으로 바꿔서 다른 클래스 사용시 에러 발생 막음

    public void printList() { //current가 size
        printList(current); //기본함수의 집중화
    }

    public void printList(int size) {
        System.out.println("┌──────────────────┐");
        System.out.println("│     성적 출력      │");
        System.out.println("└──────────────────┘");
        System.out.println();

        Exam[] exams = this.exams;

        for (int i = 0; i < size ; i++) {
            Exam exam = exams[i];
            int kor = exam.getKor(); //kor;
            int eng = exam.getEng(); //eng;
            int math = exam.getMath(); //math;

            int total = exam.total(); //kor + eng + math;
            float avg = exam.avg(); //total / 3.0f;

            System.out.printf("국어 : %d\n", kor);
            System.out.printf("영어 : %d\n", eng);
            System.out.printf("수학 : %d\n", math);

            System.out.printf("총점 : %3d\n", total);
            System.out.printf("평균 : %6.2f\n", avg);
            System.out.println("────────────────────────");
        }
    }

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


        /*Exam exam = new Exam();
        exam.setKor(kor); //exam.kor = kor; kor값을 설정해주세요라는 의미의 set
        exam.setEng(eng); //exam.eng = eng;
        exam.setMath(math); //exam.math = math;

         */

        Exam exam = new Exam(kor, eng, math);
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
