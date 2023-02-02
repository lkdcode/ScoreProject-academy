package com.edu.controller;

import com.edu.dao.StudentDAO;
import com.edu.entity.Student;
import com.edu.view.StudentView;

import java.util.List;

public class StudentController {
    StudentDAO dao;

    StudentView view;

    public StudentController() {
        this.dao = new StudentDAO();
        this.view = new StudentView();
    }

    public String insertStudent(Student ob) {
        if (!(ob.getKor() >= 0 && ob.getKor() <= 100)) {
            return "입력값에 오류가 있습니다.";
        }
        if (!(ob.getEng() >= 0 && ob.getEng() <= 100)) {
            return "입력값에 오류가 있습니다.";
        }
        if (!(ob.getMat() >= 0 && ob.getMat() <= 100)) {
            return "입력값에 오류가 있습니다.";
        }

        dao.insertStudent(ob);


        return null;
    }


    public void getStudentList() {
        StudentDAO dao = new StudentDAO();
        List<Student> list = dao.getStudentList();

        StudentView view = new StudentView();
        view.getStudentList(list);
    }

    public void getStudent(String name) {

    }

    public void deleteStudent(String name) {

    }


}
