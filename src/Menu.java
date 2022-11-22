import member.Member;
import member.submember.Professor;
import member.submember.Student;

import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private final List<Member> members;

    public Menu(List<Member> members) {
        this.members = members;
    }

    public void printMenu(Member member, boolean greeting) {
        if (member instanceof Professor) {
            if (greeting) System.out.printf("%s 교수님, 안녕하세요!\n", member.getName());
            printProfMenu();
        }
        else if (member instanceof Student) {
            if (greeting) System.out.printf("%s 학우님, 안녕하세요!\n", member.getName());
            printStudentMenu();
        }
        else if (member.getClass() == Member.class) {
            if (greeting) System.out.printf("%s 계정입니다. \n", member.getName());
            printMemberMenu();
        }
    }

    public Member login() {
        System.out.println("로그인");
        System.out.println("-".repeat(80));

        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Password: ");
        int password = Integer.parseInt(sc.nextLine());

        // 회원인지 확인
        Member mem = members.stream().filter(m->m.getId() == id).findAny().orElse(null);
        if (mem != null) {
            if (mem.getPassword() == password) {
                return mem;
            }
            else {
                System.out.println("비밀번호를 틀렸습니다.");
                return login();
            }
        }
        else {
            System.out.print("등록되지 않은 회원입니다. ");
            System.out.print("회원가입 하시겠습니까? [y/n]: ");
            String input = sc.nextLine();
            if (input.equals("y")) {
                System.out.println("=".repeat(80));
                signUp();
                System.out.println("=".repeat(80));
            }
            return login();
        }
    }

    private void signUp() {
        Member member;

        System.out.println("회원가입");
        System.out.println("-".repeat(80));
        System.out.println("[1] 교수 [2] 학생");
        boolean isProf = sc.nextLine().equals("1");

        System.out.print("아이디를 입력하세요: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("비밀번호를 입력하세요: ");
        int pw = Integer.parseInt(sc.nextLine());
        System.out.print("비밀번호를 한 번 더 입력해주세요: ");
        int pwCheck = Integer.parseInt(sc.nextLine());
        while (pw != pwCheck) {
            System.out.print("비밀번호가 틀립니다. 다시 입력해주세요: ");
            pwCheck = Integer.parseInt(sc.nextLine());
        }
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("전공을 입력하세요: ");
        String major = sc.nextLine();
        if (isProf) {
            System.out.print("연구실을 입력하세요: ");
            String lab = sc.nextLine();
            member = new Professor(id, pw, name, major, lab);
        }
        else {
            System.out.print("학년을 입력하세요: ");
            int year = Integer.parseInt(sc.nextLine());
            member = new Student(id, pw, name, major, year);
        }
        members.add(member);
        System.out.printf("%s님 %s계정으로 회원가입 되었습니다.\n", name, isProf ? "교수" : "학생");
        System.out.println("다시 로그인 해주세요.");
    }

    private void printProfMenu() {
        System.out.println("[1] 내 정보 조회");
        System.out.println("[2] 강의 등록");
        System.out.println("[3] 강의 목록 조회");
        System.out.println("[4] 강의별 수강생 조회");
        System.out.println("[5] 학생 정보 조회");
        System.out.println("[-] 로그아웃");
        System.out.println("[/] 프로그램 종료");
    }

    private void printStudentMenu() {
        System.out.println("[1] 내 정보 조회");
        System.out.println("[2] 수강신청");
        System.out.println("[3] 신청 과목 조회");
        System.out.println("[4] 담당교수별 강의 조회"); // 애매하다
        System.out.println("[5] 교수 정보 조회");
        System.out.println("[-] 로그아웃");
        System.out.println("[/] 프로그램 종료");
    }

    private void printMemberMenu() {
        System.out.println("[1] 회원 리스트 조회");
        System.out.println("[2] 강의 리스트 조회");
        System.out.println("[-] 로그아웃");
        System.out.println("[/] 프로그램 종료");
    }
}
