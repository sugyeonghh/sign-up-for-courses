import course.CourseRepository;
import member.Member;

import java.util.Scanner;

public class SignUpApp {
    CourseRepository courseRepository;
    Menu menu;
    Features features;

    public SignUpApp(CourseRepository courseRepository, Menu menu, Features features) {
        this.courseRepository = courseRepository;
        this.menu = menu;
        this.features = features;
    }

    public int start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("코딩대학 ‍수강신청 프로그램");
        System.out.println("로그인이 필요합니다.");
        System.out.println("=".repeat(80));
        Member member = menu.login();
        System.out.println("=".repeat(80));
        boolean greeting = true;

        while (true) {
            menu.printMenu(member, greeting);
            String input = sc.nextLine();
            if (input.equals("-")) {
                System.out.println("로그아웃 되었습니다.\n");
                return start();
            }
            else if (input.equals("/")) {
                return 0;
            }
            else {
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= 5) {
                    features.selectFeatures(member, num);
                }
                else{
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                }
                greeting = false;
            }
        }
    }



}
