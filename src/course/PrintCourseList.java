package course;

import java.util.List;
import java.util.stream.Collectors;

public class PrintCourseList {
    private List<Course> courses;

    public PrintCourseList(List<Course> courses) {
        this.courses = courses;
    }

    public void printCourseList() {
        System.out.println("수강신청 강의 리스트");
        System.out.println("=".repeat(80));
        printCourseListDetail(courses);
        System.out.println("=".repeat(80));
    }

    public void printCoursesByName(String courseName) {
        List<Course> courses1 = courses.stream().filter(c->c.getName().equals(courseName)).collect(Collectors.toList());
        printCourseListDetail(courses1);
    }

    public void printCoursesByProf(String prof) {
        List<Course> courses1 = courses.stream().filter(c->c.getProf().equals(prof)).collect(Collectors.toList());
        printCourseListDetail(courses1);
    }

    public void printCoursesByCredit(int credit) {
        List<Course> courses1 = courses.stream().filter(c->c.getCredit() == credit).collect(Collectors.toList());
        printCourseListDetail(courses1);
    }

    private void printCourseListDetail(List<Course> courses) {
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
}
