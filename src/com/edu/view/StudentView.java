package com.edu.view;

import com.edu.entity.Student;

import java.util.List;

public class StudentView {

    public void getStudentList(List<Student> list) {
        // 랭크 계산 해야함
        if (list.size() != 0) {


            System.out.println("번호\t이름\t\t국어\t\t영어\t\t수학\t\t총점\t\t평균\t\t학점\t\t결과\t\t순위");
            System.out.println("-------------------------------------------------------------------------");
            for (Student student : list) {
                System.out.print(student.getMid() + "\t");
                System.out.print(student.getName() + "\t");
                System.out.print(student.getKor() + "\t\t");
                System.out.print(student.getEng() + "\t\t");
                System.out.print(student.getMat() + "\t\t");
                System.out.print(student.getTot() + "\t\t");
                System.out.printf("%.2f\t", student.getAvg());
                System.out.print(student.getGrade() + "\t\t");
                System.out.print(student.getResult() + "\t\t");
                System.out.println(student.getRank());
            }
            System.out.println();
        } else {
            System.out.println("등록된 학생 정보가 없습니다.\n");
        }
    }

    public void getStudent(Student ob) {
        // 찾기
        if (ob != null) {
            System.out.println(ob.toString());
        } else {
            System.out.println("찾는 사람이 존재하지 않습니다.\n");
        }

    }

    public void insertStudent(int n, String name) {
        if (n > 0) {
            System.out.println(name + "을 추가했습니다.\n");
        } else {
            System.out.println("학생 등록에 실패하였습니다.\n");
        }
    }

    public void deleteStudent(int n, String name) {
        if (n > 0) {
            System.out.println(name + "을 살제하였습니다.\n");
        } else {
            System.out.println("해당 학생이 존재하지 않습니다.\n");
        }
    }

}
