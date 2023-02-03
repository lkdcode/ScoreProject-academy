package com.edu.dao;

import com.edu.entity.Student;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static common.JdbcTemplate.*;

public class StudentDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private int n;

    private void setup() {
        this.conn = getConnection();
        this.pstmt = null;
        this.rs = null;
        this.n = 0;
    }

    private void setClose() {
        close(conn);
        close(pstmt);
        close(rs);
    }

    public List<Student> getStudentList() {
        List<Student> list = new ArrayList<>();
        setup();

        String sql = "SELECT * FROM student";

        try {
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setMid(rs.getInt("mid"));
                student.setName(rs.getString("name"));
                student.setKor(rs.getInt("kor"));
                student.setEng(rs.getInt("eng"));
                student.setMat(rs.getInt("mat"));

                list.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            setClose();
        }

        return list;
    }

    public Student getStudent(String name) {
        Student student = null;

        setup();

        String sql = "SELECT * FROM student WHERE name=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                student = new Student();
                student.setMid(rs.getInt("mid"));
                student.setName(rs.getString("name"));
                student.setKor(rs.getInt("kor"));
                student.setEng(rs.getInt("Eng"));
                student.setMat(rs.getInt("Mat"));
            }

        } catch (SQLException e) {
            student = null;
        } finally {
            setClose();
        }

        return student;
    }

    public int insertStudent(Student ob) {
        setup();

        String sql = "INSERT INTO student VALUES(m_mid.nextval, ?, ?, ?, ?)";

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
        } finally {
            setClose();
        }

        return n;
    }

    public int deleteStudent(String name) {
        setup();

        String sql = "DELETE FROM student WHERE name=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            n = pstmt.executeUpdate();

            if (n > 0) {
                commit(conn);
            }

        } catch (SQLException e) {
            rollback(conn);
            n = 0;
        } finally {
            setClose();
        }

        return n;
    }

}
