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
                    System.out.println("이름 : ");
                    name = sc.nextLine();
                    System.out.println("국어 : ");
                    kor = sc.nextInt();
                    System.out.println("영어 : ");
                    eng = sc.nextInt();
                    System.out.println("수학 : ");
                    mat = sc.nextInt();


                    break;

                case 2:
                    //삭제


                    break;
                case 3:
                    //전체보기
                    controller.getStudentList();

                    break;
                case 4:
                    //찾기


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
