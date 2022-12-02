import course.Course;
import course.CourseRepository;
import member.Member;
import member.submember.Professor;
import member.submember.Student;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResisterPage {
    private CourseRepository courseRepository;
    private List<Member> members;
    private List<Course> courses;

    public ResisterPage(CourseRepository courseRepository, List<Member> members) {
        this.courseRepository = courseRepository;
        this.members = members;
        this.courses = courseRepository.getCourses();
    }

    public void resister(Student student) {
        Scanner sc = new Scanner(System.in);
        printCourseList();
        System.out.print("수강신청할 강의의 학수번호를 입력하세요: ");
        int courseId = Integer.parseInt(sc.nextLine());
        Course newCourse = courseRepository.findById(courseId);
        if (isValidCourse(newCourse, student.getCourseList(), student)) {
            student.setCourseList(newCourse);
            student.setCredit(newCourse.getCredit());
            System.out.println("<" + newCourse.getName() + "-" + newCourse.getProf() + "> 강의를 신청하였습니다.");
            courseRepository.findById(courseId).setNumOfPeople(1);
        }
    }

    private boolean isValidCourse(Course newCourse, List<Course> courseList, Student student) {
        List<Course> studentCourseList = student.getCourseList();
        if (newCourse == null) {
            System.out.println("해당 강의를 찾지 못했습니다. ");
            return false;
        }
        else if (newCourse.isFull()) {
            System.out.println("최대 인원을 초과하였습니다.");
            return false;
        }
        else if (studentCourseList.contains(newCourse)){
            System.out.println("이미 신청하였습니다.");
            return false;
        }
        else if (student.getCredit() + newCourse.getCredit() > student.getMaxCredit()) {
            System.out.println("신청 가능한 학점을 초과하였습니다. ");
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
        printCourseListDetail(courses, false);
        System.out.println("*".repeat(80));
    }

    // 강의 리스트 - 디테일
    public void printCourseListDetail(List<Course> courses, boolean isCredit) {
        if (courses.isEmpty()) {
            System.out.println("강의를 찾을 수 없습니다.");
            return;
        }
        System.out.printf("%-8s %-20s %-10s %-8s %10s %10s\n", "학수번호", "강의명", "담당교수", "강의시간", "학점", "담은 인원");
        System.out.println("-".repeat(80));
        for (Course course : courses) {
            printEachCourse(course);
        }
        System.out.println("-".repeat(80));
        System.out.println("총 " + courses.size() + "개 강의");
        if (isCredit) {
            int credit = courses.stream().mapToInt(c -> c.getCredit()).sum();
            System.out.println("현재 신청한 학점: " + credit + "학점");
        }
    }

    public void printEachCourse(Course course) {
        System.out.printf("%-10d %-17s %-10s [%s]%d시 ~ %d시 %5d학점 %5d명\n",
                course.getId(),
                course.getName(),
                course.getProf(),
                course.getDay(),
                course.getTime(),
                course.getTime() + course.getCredit(),
                course.getCredit(),
                course.getNumOfPeople());
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
