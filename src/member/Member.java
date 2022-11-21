package member;

import course.Course;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private int id;
    private int password;
    private String name;
    private String major;
    private List<Course> courseList;

    public Member(int id, int password, String name, String major) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.major = major;
        initCourseList();
    }

    private void initCourseList() {
        courseList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    // 내 정보 조회 -> 여기에 써도 되나??
    public void printMyInfo(Member member) {
        System.out.println("아이디: " + member.getId());
        System.out.println("이름: " + member.getName());
        System.out.println("전공: " + member.getMajor());
    }

}
