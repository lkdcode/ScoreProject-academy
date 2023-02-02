package com.edu.dao;

import com.edu.entity.Student;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static common.JdbcTemplate.*;

public class StudentDAO {

    public List<Student> getStudentList() {
        List<Student> list = new ArrayList<>();

        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM STUDENT";
        System.out.println(sql);

        try {
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                System.out.println(rs.getString("name"));
                student.setName(rs.getString("name"));
                student.setKor(rs.getInt("kor"));
                student.setEng(rs.getInt("eng"));
                student.setMat(rs.getInt("mat"));

                list.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // 전체 보기
        return list;
    }

    public Student getStudent(String name) {
        // 찾기
        return null;
    }

    public int insertStudent(Student ob) {
        // 추가
        int n = 0;

        Connection conn = getConnection();
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO student VALUES(m_mid.nextval,name=?,kor=?,eng=?,mat=?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ob.getName());
            pstmt.setInt(2, ob.getKor());
            pstmt.setInt(3, ob.getEng());
            pstmt.setInt(4, ob.getMat());
            n = pstmt.executeUpdate();

            if (n > 0) {
                commit(conn);
            }

        } catch (SQLException e) {
            rollback(conn);
            n = 0;
        }

        return n;
    }

    public int deleteStudent(String name) {
        // 삭제
        return 0;
    }

}
