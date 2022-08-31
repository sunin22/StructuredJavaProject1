package ex3.dataEncapsulation;

import java.util.Scanner;

public class functionOverloading {
    public static void main(String[] args) {

        ExamList list = new ExamList();
        ExamList.init(list);

        int menu;
        boolean keepLoop = true;

        while (keepLoop) {
            menu = inputMenu(); //메뉴입력()만 쓰면 에러, 앞에 menu = 를 붙여야 가능

            switch (menu) {
                case 1:
                    ExamList.inputList(list);

                    break;
                case 2:
                    //printList(list); //오버로드 예제 만들기
                    ExamList.printList(list, 2); // 2개만 출력되게 만들기

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
    static int inputMenu() {
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
