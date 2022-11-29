import course.Course;
import member.Member;
import member.submember.Professor;
import member.submember.Student;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResisterPage {
    private List<Course> courses;
    private List<Member> members;

    public ResisterPage(List<Course> courses, List<Member> members) {
        this.courses = courses;
        this.members = members;
    }

    public void resist(Student student) {
        Scanner sc = new Scanner(System.in);
        printCourseList();
        System.out.print("수강신청할 강의의 학수번호를 입력하세요: ");
        int courseId = Integer.parseInt(sc.nextLine());
        Course newCourse = courses.stream().filter(c -> c.getId() == courseId).findAny().orElse(null);
        if (isValidCourse(newCourse, student.getCourseList())) {
            student.getCourseList().add(newCourse);
            System.out.println("<" + newCourse.getName() + "-" + newCourse.getProf() + "> 강의를 신청하였습니다.");
        }
    }

    private boolean isValidCourse(Course newCourse, List<Course> courseList) {
        if (newCourse == null) {
            System.out.println("해당 강의를 찾지 못했습니다. ");
            return false;
        }
        for (Course course : courseList) {
            if (course.getDay().equals(newCourse.getDay())) {
                if (course.getTime() < newCourse.getTime()) {
                    if (course.getTime() + course.getCredit() < newCourse.getTime()) return true;
                }
                else if (course.getTime() > newCourse.getTime()) {
                    if (course.getTime() > newCourse.getTime() + newCourse.getCredit()) return true;
                }
                else {
                    System.out.println("시간표가 겹칩니다!");
                    return false;
                }
            }
        }
        return true;
    }

    // 강의 리스트
    public void printCourseList() {
        System.out.println("전체 강의 리스트");
        System.out.println("*".repeat(80));
        printCourseListDetail(courses);
        System.out.println("*".repeat(80));
    }

    // 강의 리스트 - 강의명
    public void printCoursesByName(String courseName) {
        List<Course> courses1 = courses.stream().filter(c->c.getName().equals(courseName)).collect(Collectors.toList());
        printCourseListDetail(courses1);
    }

    // 강의 리스트 - 교수
    public void printCoursesByProf(String prof) {
        List<Course> courses1 = courses.stream().filter(c->c.getProf().equals(prof)).collect(Collectors.toList());
        printCourseListDetail(courses1);
    }

    // 강의 리스트 - 학점
    public void printCoursesByCredit(int credit) {
        List<Course> courses1 = courses.stream().filter(c->c.getCredit() == credit).collect(Collectors.toList());
        printCourseListDetail(courses1);
    }

    // 강의 리스트 - 디테일
    public void printCourseListDetail(List<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("강의를 찾을 수 없습니다.");
            return;
        }
        System.out.printf("%-8s %-20s %-10s %-8s %10s %10s\n", "학수번호", "강의명", "담당교수", "강의시간", "학점", "담은 인원");
        System.out.println("-".repeat(80));
        for (Course course : courses) {
            System.out.printf("%-10d %-17s %-10s [%s]%d시 ~ %d시 %5d학점 %5d\n",
                    course.getId(),
                    course.getName(),
                    course.getProf(),
                    course.getDay(),
                    course.getTime(),
                    course.getTime() + course.getCredit(),
                    course.getCredit(),
                    course.getMaximumPeople()); // 수정필요
        }
    }

    // 회원 리스트
    public void printMemberList() {
        System.out.println("교수 / 학생 리스트");
        System.out.println("=".repeat(80));
        printProfList();
        System.out.println();
        printStudentList();
    }

    private void printProfList() {
        System.out.println("교수 리스트");
        System.out.printf("%-5s %-10s %-10s\n", "이름", "전공", "연구실");
        System.out.println("-".repeat(80));
        for (Member member : members) {
            if (member instanceof Professor) {
                System.out.printf("%-5s %-10s %-10s\n", member.getName(), member.getMajor(), ((Professor) member).getLab());
            }
        }
    }

    private void printStudentList() {
        System.out.println("학생 리스트");
        System.out.printf("%-5s %-10s %-10s\n", "이름", "전공", "학년");
        System.out.println("-".repeat(80));
        for (Member member : members) {
            if (member instanceof Student) {
                System.out.printf("%-5s %-10s %-10s\n", member.getName(), member.getMajor(), ((Student) member).getYear());
            }
        }
    }
}
