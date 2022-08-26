package ex2.dataStructure;

import java.util.Scanner;

public class ExtendArray {
    public static void main(String[] args) {

        ExamList list = new ExamList();
        list.exams = new Exam[3];
        list.current = 0;

        /*
        Exam[] exams = new Exam[3];
        int current = 0; //current가 아닌 0만 반환

        Exam[] exams = new Exam[3];    ExamList list = new ExamList();
        int current = 0;               list.exams = new Exam[3]; & list.current = 0;

        inputList(exams,current);      inputList(list);
        printList(exams,current);      printList(list);
        함수 단위에서 공유해야 할 데이터라면 큰 단위의 구조체로 묶어서 공유
        -> class ExamList{
                Exam[] exams;
                int current;   로 바꿀 수 있음
                }
        */

        int menu;
        boolean keepLoop = true;

        while (keepLoop) {
            menu = inputMenu(); //메뉴입력()만 쓰면 에러, 앞에 menu = 를 붙여야 가능

            switch (menu) {
                case 1:
                    inputList(list);

                    break;
                case 2:
                    printList(list);

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

    private static void printList(ExamList list) { //current가 size
        System.out.println("┌──────────────────┐");
        System.out.println("│     성적 출력      │");
        System.out.println("└──────────────────┘");
        System.out.println();

        int size = list.current;
        Exam[] exams = list.exams;

        for(int i = 0; i<size; i++) {//i<exams.length는 방의 개수이지 성적의 개수는 아님
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

    private static void inputList(ExamList list) {
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

            /*
            if(!exams의 공간이 있는지){ 없다면,
                공간을 늘려주기}
            가변적으로 데이터를 수집하기 위해 배열을 이용하는 방법

            정적인 크기의 배열을 동적인 크기로 만들기 -> capacity 변수
            가변 List = [ ] + current + capacity + amount

            연습문제: 공간을 점진적으로 늘리는 위치와 방법
            if(capacity == current)
            1. Exam[] temp = new Exam[capacity + amount]; amount개 확장한 새로운 배열 temp를 생성
            2. for(int i = 0;i<current;i++)    list에 있는 데이터를 temp 배열로 이동
            3.      temp[i] = list[i];     temp가 참조하는 객체를 list가 참조하게 변화
            4. list = temp;                현재 capacity의 값을 +10 증가
               capacity += amount;
              */

        Exam[] exams = list.exams;
        int size = list.current;

        if(list.exams.length == size){
            //1. 크기가 5개 정도 더 큰 새로운 배열 생성
            Exam[] temp = new Exam[size + 5];
            //2. 값 이주시키기
            for(int i=0; i<size ; i++)
                temp[i] = exams[i];
            //3. list.exams가 새로운 temp 배열 참조하기
            list.exams = temp;
        }
        list.exams[list.current] = exam; //배열에 담기 위해서 꼭 필요
        list.current++; //3번 밖에 성적 입력을 못함
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
