import course.Course;
import course.CourseRepository;
import member.Member;
import member.submember.Professor;
import member.submember.Student;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Features {
    List<Member> members;
    CourseRepository courseRepository;
    ResisterPage resisterPage;
    List<Course> courses;
    Scanner sc = new Scanner(System.in);

    public Features(List<Member> members, CourseRepository courseRepository, ResisterPage resisterPage) {
        this.members = members;
        this.courseRepository = courseRepository;
        this.resisterPage = resisterPage;
        this.courses = courseRepository.getCourses();
    }

    public void selectFeatures(Member member, int num) {
        System.out.println("=".repeat(80));
        if (member instanceof Professor) selectProfFeatuers((Professor) member, num);
        else if (member instanceof Student){ selectStudentFeatures((Student) member, num);}
        else selectMemberFeatures(num);
        System.out.println("=".repeat(80));
    }

    private void selectStudentFeatures(Student student, int num) {
        switch (num) {
            case 1:
                System.out.println("내 정보를 조회합니다.");
                System.out.println("-".repeat(80));
                student.printMyInfo(student);
                break;
            case 2:
                System.out.println("수강신청");
                System.out.println("-".repeat(80));
                resisterPage.resister(student);
                break;
            case 3:
                System.out.println("강의를 조회합니다");
                System.out.println("-".repeat(80));
                Menu menu = new Menu(members);
                menu.printSearchCoursesMenu();
                int selectMenu = Integer.parseInt(sc.nextLine());
                selectSearchCoursesMenu(selectMenu);
                break;
            case 4:
                System.out.println("신청한 과목을 조회합니다.");
                System.out.println("-".repeat(80));
                resisterPage.printCourseListDetail(student.getCourseList(), true);
                break;
            case 5:
                // 수정 필요
                System.out.println("교수 정보를 조회합니다.");
                System.out.println("-".repeat(80));
                System.out.print("조회할 교수의 이름을 입력하세요: ");
                searchMemberInfo(student);
                break;
        }
    }

    private void selectSearchCoursesMenu(int selectMenu) {
        switch (selectMenu) {
            case 1:
                System.out.print("교수명을 입력하세요: ");
                String profName = sc.nextLine();
                System.out.println("=".repeat(80));
                resisterPage.printCourseListDetail(courseRepository.findByProfessor(profName), false);
                break;
            case 2:
                System.out.print("강의명을 입력하세요: ");
                String courseName = sc.nextLine();
                System.out.println("=".repeat(80));
                resisterPage.printCourseListDetail(courseRepository.findByName(courseName), false);
                break;
            case 3:
                System.out.print("학점을 입력하세요: ");
                int credit = Integer.parseInt(sc.nextLine());
                System.out.println("=".repeat(80));
                resisterPage.printCourseListDetail(courseRepository.findByCredit(credit), false);
                break;
        }
    }

    private void selectProfFeatuers(Professor prof, int num) {
        switch (num) {
            case 1:
                System.out.println("내 정보를 조회합니다.");
                System.out.println("-".repeat(80));
                prof.printMyInfo(prof);
                break;
            case 2:
                System.out.println("강의를 등록합니다.");
                System.out.println("-".repeat(80));
                Course newCourse = createCourse(prof);
                courses.add(newCourse);
                System.out.println("-".repeat(80));
                resisterPage.printEachCourse(newCourse);
                System.out.println("-".repeat(80));
                System.out.println("강의를 등록하였습니다.");
                break;
            case 3:
                System.out.println("강의 목록을 조회합니다.");
                System.out.println("-".repeat(80));
                resisterPage.printCourseListDetail(courseRepository.findByProfessor(prof.getName()), false);
                break;
            case 4:
                System.out.println("강의별 수강생을 조회합니다.");
                System.out.println("-".repeat(80));
                // 구현
                break;
            case 5:
                System.out.println("학생 정보를 조회합니다.");
                System.out.println("-".repeat(80));
                System.out.print("조회할 학생의 이름을 입력하세요: ");
                searchMemberInfo(prof);
                break;
        }
    }

    private void selectMemberFeatures(int num) {
        switch (num) {
            case 1:
                System.out.println("회원 리스트를 조회합니다.");
                System.out.println("-".repeat(80));
                resisterPage.printMemberList();
                break;
            case 2:
                System.out.println("강의 리스트를 조회합니다.");
                System.out.println("-".repeat(80));
                resisterPage.printCourseList();
                break;
        }
    }

    private void searchMemberInfo(Member member) {
        String name = sc.nextLine();
        List<Member> members1 = members.stream().filter(mem -> mem.getName().equals(name)).collect(Collectors.toList());
        // 예외처리 안 됨
        // 교수 -> 학생 조회할 때 교수이름 입력하면 조회 안되도록 하고싶은데
        if (members1.getClass() == (member).getClass() && members1.isEmpty())
            System.out.println("해당 학생의 정보를 찾지 못했습니다.");
        else {
            members1.forEach(mem -> {
                System.out.println(mem.getName() + "님의 정보");
                System.out.println("*".repeat(80));
                mem.printMyInfo(mem);
            });
        }
    }

    private Course createCourse(Professor prof) {
        System.out.print("학수번호를 입력하세요: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("강의명을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("최대 수강인원을 입력하세요: ");
        int maximum = Integer.parseInt(sc.nextLine());
        System.out.print("강의 시작 시간을 입력하세요: ");
        int time = Integer.parseInt(sc.nextLine());
        System.out.print("강의 요일을 입력하세요: ");
        String day = sc.nextLine().toUpperCase();
        System.out.print("학점을 입력하세요: ");
        int credit = Integer.parseInt(sc.nextLine());
        return new Course(id, name, prof.getName(), maximum, 0, time, day, credit);
    }
}
