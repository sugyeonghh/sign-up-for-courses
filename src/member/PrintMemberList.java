package member;

import member.submember.Professor;
import member.submember.Student;

import java.util.List;

public class PrintMemberList {
    List<Member> members;

    public PrintMemberList(List<Member> members) {
        this.members = members;
    }

    public void printMemberList() {
        System.out.println("교수 / 학생 리스트");
        System.out.println("=".repeat(80));
        printProfessorList();
        System.out.println("-".repeat(80));
        printStudentList();
        System.out.println("=".repeat(80));
    }

    private void printProfessorList() {
        System.out.println("교수 리스트");
        for (Member member : members) {
            if (member instanceof Professor) {
                System.out.printf("%-5s %-10s %-10s\n", "이름", "전공", "연구실\n");
                System.out.println("-".repeat(80));
                System.out.printf("%-5s %-10s %-10s\n", member.getName(), member.getMajor(), ((Professor) members).getLab());
            }
        }
    }

    private void printStudentList() {
        System.out.println("학생 리스트");
        for (Member member : members) {
            if (member instanceof Student) {
                System.out.printf("%-5s %-10s %-10s\n", "이름", "전공", "학년\n");
                System.out.println("-".repeat(80));
                System.out.printf("%-5s %-10s %-10s\n", member.getName(), member.getMajor(), ((Student) members).getYear());
            }
        }
    }
}
