package course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CourseRepository {
    List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course(1001, "객체지향 프로그래밍", "조영현", 5, 10, Course.CourseDays.MON, 3),
            new Course(1002, "객체지향 프로그래밍", "구민상", 5, 13, Course.CourseDays.MON, 3),
            new Course(2001, "리눅스 프로그래밍", "조영현", 5, 11, Course.CourseDays.TUE, 2),
            new Course(2002, "리눅스 프로그래밍", "구민상", 5, 11, Course.CourseDays.WED, 2),
            new Course(3001, "HTML", "황선애", 3, 14, Course.CourseDays.THU, 3),
            new Course(4001, "CSS", "황선애", 3, 14, Course.CourseDays.FRI, 3),
            new Course(5001, "알고리즘", "이정민", 5, 9, Course.CourseDays.THU, 3),
            new Course(6001, "자료구조", "이정민", 5, 15, Course.CourseDays.THU, 3),
            new Course(7001, "네트워크", "조영현", 5, 11, Course.CourseDays.THU, 3),
            new Course(8001, "메타인지", "김요한", 5, 9, Course.CourseDays.TUE, 1)
    ));

    public List<Course> getCourses() {
        return courses;
    }

    public Course findById(int courseId) {
        return courses.stream().filter(c->c.getId() == courseId).findAny().orElse(null);
    }

    public List<Course> findByName(String name) {
        return courses.stream().filter(c->c.getName().equals(name)).collect(Collectors.toList());
    }

    public List<Course> findByProfessor(String prof) {
        return courses.stream().filter(c->c.getProf().equals(prof)).collect(Collectors.toList());
    }

    public List<Course> findByCredit(int credit) {
        return courses.stream().filter(c->c.getCredit() == credit).collect(Collectors.toList());
    }
}
