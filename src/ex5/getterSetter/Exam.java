package ex5.getterSetter;

public class Exam {
    int kor;
    int eng;
    int math;

    public Exam(int kor, int eng, int math) {
        this.kor =kor;
        this.eng =eng;
        this.math =math;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int total() {
        return kor + eng + math;
    }

    public float avg() {
        return total()/3.0f;
    }

    //함수가 없다면 캡슐화되진 않음 - 여기서 수정했을 때 다른 곳에서 에러가 나면 함수가 필요하다는 의미

}
