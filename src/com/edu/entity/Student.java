package com.edu.entity;

public class Student {
    private int mid;
    private String name;
    private int kor;
    private int eng;
    private int mat;
    private int rank;

    public Student() {
    }

    public Student(int mid, String name, int kor, int eng, int mat, int rank) {
        this.mid = mid;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
        this.rank = rank;
    }

    public Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public int getTot() {
        return kor + eng + mat;
    }

    public double getAvg() {
        return getTot() / 3.0;
    }

    public char getGrade() {
        char grade = 'F';
        if (getAvg() >= 90) {
            grade = 'A';
        } else if (getAvg() >= 80) {
            grade = 'B';
        } else if (getAvg() >= 70) {
            grade = 'C';
        } else if (getAvg() >= 60) {
            grade = 'D';
        }
        return grade;
    }

    public String getResult() {
        if (getGrade() == 'F') {
            return "불합격";
        }
        return "합격";
    }

    @Override
    public String toString() {
        return name + "의 총점은 " + getTot() + "점이고 평균은 " + String.format("%.2f", getAvg()) + "점입니다.\n" +
                "학점은 " + getGrade() + "이고 결과는 " + getResult() + "입니다.\n";
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
