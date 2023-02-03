package com.edu.controller;

import com.edu.dao.StudentDAO;
import com.edu.entity.Student;
import com.edu.view.StudentView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentController {
    private final StudentDAO dao;
    private final StudentView view;

    private final String ERROR_MESSAGE = "입력값에 오류가 있습니다.\n";
    private final int MAX_SCORE = 100;
    private final int MIN_SCORE = 0;

    public StudentController() {
        this.dao = new StudentDAO();
        this.view = new StudentView();
    }

    public void insertStudent(Student ob) {
        if (!(ob.getKor() >= MIN_SCORE && ob.getKor() <= MAX_SCORE)) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        if (!(ob.getEng() >= MIN_SCORE && ob.getEng() <= MAX_SCORE)) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        if (!(ob.getMat() >= MIN_SCORE && ob.getMat() <= MAX_SCORE)) {
            System.out.println(ERROR_MESSAGE);
            return;
        }

        int n = dao.insertStudent(ob);
        view.insertStudent(n, ob.getName());

    }


    public void getStudentList() {
        StudentDAO dao = new StudentDAO();
        List<Student> list = dao.getStudentList();

        list = rankCalculator(list);

        StudentView view = new StudentView();
        view.getStudentList(list);
    }

    private List<Student> rankCalculator(List<Student> list) {
        List<Integer> scoreList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            scoreList.add(list.get(i).getTot());
        }

        Collections.sort(scoreList, Collections.reverseOrder());

        for (int i = 0; i < scoreList.size(); i++) {
            int score = scoreList.get(i);

            for (int j = 0; j < list.size(); j++) {
                if (score == list.get(j).getTot()) {
                    list.get(j).setRank(i + 1);
                    break;
                }
            }
        }

        return list;
    }

    public void getStudent(String name) {
        Student student = dao.getStudent(name);
        view.getStudent(student);
    }

    public void deleteStudent(String name) {
        int n = dao.deleteStudent(name);
        view.deleteStudent(n, name);
    }


}
