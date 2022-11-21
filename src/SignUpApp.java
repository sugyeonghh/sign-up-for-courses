import course.CourseRepository;
import member.Member;

import java.util.Scanner;

public class SignUpApp {
    CourseRepository courseRepository;
    Menu menu;

    public SignUpApp(CourseRepository courseRepository, Menu menu) {
        this.courseRepository = courseRepository;
        this.menu = menu;
    }

    public int start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("👨🏻‍🏫수강신청 프로그램");

        // 로그인 or 회원가입
        System.out.println("로그인이 필요합니다.");
        System.out.println("=".repeat(80));
        Member member = menu.login();
        System.out.println("=".repeat(80));

        while (true) {
            menu.printMenu(member);
            String input = sc.nextLine();
            if (input.equals("-")) {
                System.out.println("로그아웃 되었습니다.");
                return start();
            }
            else if ("12345".contains(input)) {
                // 메뉴 실행

            }
            else if (input.equals("/")) {
                return 0;
            }
            else {
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
                return -1;
            }
        }
    }



}
