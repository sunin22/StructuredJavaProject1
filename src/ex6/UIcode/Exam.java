package ex6.UIcode;

public class Exam {
    int kor;
    int eng;
    int math;

    public Exam(int kor, int eng, int math) {
        this.kor = this.kor;
        this.eng = this.eng;
        this.math = this.math;
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

}
