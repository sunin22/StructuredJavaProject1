package ex7.abstraction;

public abstract class Exam {
    int kor;
    int eng;
    int math;

    public Exam(){

    }

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

    public abstract int total(); // {return kor + eng + math;}

    protected int onTotal(){ //위처럼 사용하거나 이것처럼 protected로 사용 가능
        return kor+eng+math;
    }

    public abstract float avg(); // {return total()/3.0f;}

}
