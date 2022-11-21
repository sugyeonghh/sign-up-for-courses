import course.CourseRepository;
import member.Member;

import java.util.Scanner;

public class ResisterApp {
    CourseRepository courseRepository;
    Menu menu;

    public ResisterApp(CourseRepository courseRepository, Menu menu) {
        this.courseRepository = courseRepository;
        this.menu = menu;
    }

    public int start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("👨🏻‍🏫수강신청 프로그램");
        System.out.println("로그인이 필요합니다.");
        System.out.println("=".repeat(80));
        Member member = menu.login();
        System.out.println("=".repeat(80));
        boolean greeting = true;

        while (true) {
            menu.printMenu(member, greeting);
            String input = sc.nextLine();
            if (input.equals("-")) {
                System.out.println("로그아웃 되었습니다.");
                return start();
            }
            else if ("12345".contains(input)) {
                // 메뉴 실행

                greeting = false;
            }
            else if (input.equals("/")) {
                return 0;
            }
            else {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                greeting = false;
            }
        }
    }



}
