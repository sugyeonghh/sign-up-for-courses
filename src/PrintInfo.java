import course.Course;
import member.Member;
import member.submember.Professor;
import member.submember.Student;
import java.util.List;
import java.util.stream.Collectors;

public class PrintInfo {
    private List<Course> courses;
    private List<Member> members;

    public PrintInfo(List<Course> courses, List<Member> members) {
        this.courses = courses;
        this.members = members;
    }

    // 강의 리스트
    public void printCourseList() {
        System.out.println("수강신청 강의 리스트");
        System.out.println("=".repeat(80));
        printCourseListDetail(courses);
        System.out.println("=".repeat(80));
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
    private void printCourseListDetail(List<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("강의를 찾을 수 없습니다.");
            return;
        }
        System.out.printf("%-8s %-20s %-10s %-8s %15s\n", "학수번호", "강의명", "담당교수", "강의시간", "담은 인원");
        System.out.println("-".repeat(80));
        for (Course course : courses) {
            System.out.printf("%-10d %-17s %-10s [%s]%3d시~%3d시 %9d\n",
                    course.getId(),
                    course.getName(),
                    course.getProf(),
                    course.getDay(),
                    course.getTime(),
                    course.getTime() + course.getCredit(),
                    course.getMaximumPeople());
        }
    }

    // 회원 리스트
    public void printMemberList() {
        System.out.println("교수 / 학생 리스트");
        System.out.println("=".repeat(80));
        printProfessorList();
        System.out.println("-".repeat(80));
        printStudentList();
        System.out.println("=".repeat(80));
    }

    // 회원 리스트 - 교수
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

    // 회원 리스트 - 학생
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
