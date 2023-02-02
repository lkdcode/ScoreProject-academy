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

    public int getTot() {
        return 0;
    }

    public double getAvg() {
        return 0;
    }

    public char getGrade() {
        return 0;
    }

    public String getResult() {
        return null;
    }

    @Override
    public String toString() {
        return "Student{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", mat=" + mat +
                ", rank=" + rank +
                '}';
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
