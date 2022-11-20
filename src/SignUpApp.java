import course.PrintCourseList;
import course.CourseRepository;
import member.Member;
import member.MemberRepository;

import java.util.List;
import java.util.Scanner;

public class SignUpApp {
    CourseRepository courseRepository;
    Menu menu;

    public SignUpApp(CourseRepository courseRepository, Menu menu) {
        this.courseRepository = courseRepository;
        this.menu = menu;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("👨🏻‍🏫수강신청 프로그램");

        while (true) {
            menu.printMenu();

            String input = sc.nextLine();


        }
    }



}
