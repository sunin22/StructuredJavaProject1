package ex1.dividingGradeInput;

import java.util.Scanner;

public class StructuredProgram {
/* static int[] kors = new int[3];
         static을 써야 전역변수가 되서 에러가 사라짐, 메인 함수 위에 큰 구조
         위에 쓰면 함수처럼 큰 범위라서 static 지우고 지역변수로 사용*/

    public static void main (String[]args){

        int[] korList = new int[3];
        int menu;
        boolean keepLoop = true;

        while (keepLoop) {
            menu = inputMenu();
                /*inputMenu()만 쓰면 에러, 앞에 'menu =; 를 붙여서 값을 남기면 그 값을 받아서 뒤에서 사용가능
                inputMenu()함수로 가서 1번을 선택하면 menu = 1;로 반환되어서 그 뒤 코드로 넘어감
                예를 들면, 논문의 contents, 목차차 정리한 느낌.
                 */

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


