package com.edu.view;

import com.edu.entity.Student;

import java.util.List;

public class StudentView {

    public void getStudentList(List<Student> list) {
        // 전체 보기
        if (list.size() != 0) {

            System.out.println("번호이름국어영어수학총점평균학점결과순위");
            System.out.println("------------------------------------");
            for (Student student : list) {
                System.out.print(student.getName());
                System.out.println(student.getKor());
                System.out.println(student.getEng());
                System.out.println(student.getMat());
            }
        } else {
            System.out.println("xxxxxxx");
        }
    }

    public void getStudent(Student ob) {
        // 찾기
    }

    public void insertStudent(int n, String name) {
        // 추가
    }

    public void deleteStudent(int n, String name) {
        // 삭제
    }

}
