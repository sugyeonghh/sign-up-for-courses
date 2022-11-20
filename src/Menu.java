import course.PrintCourseList;
import member.Member;
import member.MemberRepository;
import member.PrintMemberList;
import member.submember.Professor;
import member.submember.Student;

import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    List<Member> members;

    public Menu(List<Member> members) {
        this.members = members;
    }

    public void printMenu() {
        // 로그인
        System.out.println("로그인이 필요합니다.");
        Member mem = login();

        // 교수 페이지
        if (mem instanceof Professor) {
            System.out.printf("%s 교수님, 안녕하세요!\n", mem.getName());
            System.out.println("[1] 나의 정보 조회");
            System.out.println("[2] 강의 등록");
            System.out.println("[3] 강의 목록 조회");
            System.out.println("[4] 강의별 수강생 조회");
            System.out.println("[5] 수강생 조회");
        }
        // 학생 페이지
        else if (mem instanceof Student) {
            System.out.printf("%s님, 안녕하세요!\n", mem.getName());
            System.out.println("[1] 나의 정보 조회");
            System.out.println("[2] 수강신청");
            System.out.println("[3] 시간표 조회");
            System.out.println("[4] 교수 조회");
        }
    }

    private Member login() {
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Password: ");
        int password = Integer.parseInt(sc.nextLine());

        // 회원인지 확인
        Member mem = members.stream().filter(m->m.getId() == id).findAny().get();
        if (mem != null) {
            if (mem.getPassword() == password) {
                return mem;
            }
            else {
                System.out.println("비밀번호를 틀렸습니다.");
                login();
            }
        }
        else {
            System.out.println("등록되지 않은 회원입니다. 회원가입 후 다시 로그인하세요.");
            login();
        }
        return null;
    }
}
