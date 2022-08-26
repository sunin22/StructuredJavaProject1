package ex2.dataStructure;

import java.util.Scanner;

public class
StructuredProgram {
    public static void main (String[]args){

        int[] korList = new int[3];
        int[] engList = new int[3];
        int[] mathList = new int[3];

        Exam exam = new Exam();
            /* exam이라는 공간이 값형식 또는 참조형식이냐에 따라 저장 공간 형식이 달라짐
            -> 값형식: 정수, 실수, 문자 등의 기본 형식 / 그외는 참조형식
            참조형식의 기본은 null -> 따라서 new를 통해 값을 입력해야 함.
            so,
            Exam exam;
            exam = new Exam(); new를 통해 공간을 만들어줘야 함: kor, eng, math방이 만들어짐
            exam.kor = 30; .을 통해 그 방에 넣을 수 있음
             */

        exam.kor = 30;
        exam.eng = 30;

        int menu;
        boolean keepLoop = true;

        while (keepLoop) {
            menu = inputMenu(); //메뉴입력()만 쓰면 에러, 앞에 menu = 를 붙여야 가능

            switch (menu) {
                case 1:
                    inputKors(korList); //korList로 받아줌

                    break;
                case 2:
                    printKors(korList);

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
    static void printKors(int[] kors){ //함수를 사용할 때는 'static' 꼭 사용하기!!

        int total = 0;
        float avg;

        for (int i = 0; i < 3; i++) {
            total += kors[i];
        }
        avg = total / 3.0f;

        System.out.println("┌──────────────────┐");
        System.out.println("│     성적 출력      │");
        System.out.println("└──────────────────┘");
        System.out.println();

        for (int i = 0; i < 3; i++) {
            System.out.printf("국어 %d : %3d\n", 3 - i, kors[i]);
        }
        System.out.printf("총점 : %3d\n", total);
        System.out.printf("평균 : %6.2f\n", avg);
        System.out.println("────────────────────────");

    }
    static void inputKors(int[] kors) {
        //이건 바깥쪽에 따로 함수로 나눔,
        // korList를 가져와서 쓰는데 이름을 바꿔서 사용 가능, korList -> kors
        // 함수의 고립화, 독립성 높아짐

        Scanner scan = new Scanner(System.in);
        int kor; //kors[i]를 kor로 변경해서 지역에서만 사용해서 에러 범위 줄임

        System.out.println("┌──────────────────┐");
        System.out.println("│     성적 입력      │");
        System.out.println("└──────────────────┘");
        System.out.println();

        for (int i = 0; i < 3; i++) {
            do {
                System.out.printf("국어%d : ", i + 1);
                //kors[i] = scan.nextInt();
                kor = scan.nextInt();

                //if (kors[i] < 0 || 100 < kors[i]) {
                if (kor < 0 || 100 < kor) {
                    System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
                }
            } while (kor < 0 || 100 < kor);

            kors[i] = kor; //i번째에 kor에 있던 지역변수값 한번에 넣기
        }
        System.out.println("────────────────────────");
    }
}

/*
함수 이름 짓기: 1) 숫자로 시작 불가 2) 문자사이 빈공백 불가 3) 특수문자사용 불가
ex) 로또번호생성 -> 생성로또번호 -> genLotto() 기능 + 재료 (경계만 대문자)
 */
