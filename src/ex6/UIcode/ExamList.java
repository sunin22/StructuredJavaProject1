package ex6.UIcode;

public class ExamList {
    private Exam[] exams;
    private int current;

    public Exam get(int i) {
        return this.exams[i];
    }

    public void add(Exam exam) {
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
        exams[current] = exam;
        current++;
    }

    public ExamList(){ //Aggregation Has A 관계, 3자리에 필요할 때마다 추가
        exams = new Exam[3];  //this
        current = 0;
    }

    public int size() {
        return current;
    }
}
