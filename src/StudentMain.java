import com.edu.controller.StudentController;
import com.edu.entity.Student;

import java.util.Scanner;

public class StudentMain {
    private final Scanner sc;
    private final StudentController controller;
    private final Student entity;

    public StudentMain() {
        this.sc = new Scanner(System.in);
        this.controller = new StudentController();
        this.entity = new Student();
    }

    private void menu() {


        while (true) {

            String name;
            int kor;
            int eng;
            int mat;

            System.out.println("1.추가 2.삭제 3.전체보기 4.찾기 5.종료");
            int n = sc.nextInt();

            switch (n) {

                case 1:
                    //추가
                    System.out.print("이름 : ");
                    name = sc.next();
                    System.out.print("국어 : ");
                    kor = sc.nextInt();
                    System.out.print("영어 : ");
                    eng = sc.nextInt();
                    System.out.print("수학 : ");
                    mat = sc.nextInt();
                    Student student = new Student(name, kor, eng, mat);

                    controller.insertStudent(student);

                    break;

                case 2:
                    //삭제
                    System.out.print("삭제할 사람 : ");
                    name = sc.next();
                    controller.deleteStudent(name);

                    break;
                case 3:
                    //전체보기
                    controller.getStudentList();

                    break;
                case 4:
                    //찾기
                    System.out.print("찾는 사람 : ");
                    name = sc.next();

                    controller.getStudent(name);

                    break;
                case 5:

                    System.out.println("*** 작업 끝 ***");
                    return;

            }
        }
    }

    public static void main(String[] args) {
        new StudentMain().menu();

    }
}
