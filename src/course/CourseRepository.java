package course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CourseRepository {
    List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course(1001, "객체지향 프로그래밍", "조영현", 2, 0, 10, "MON", 3),
            new Course(1002, "객체지향 프로그래밍", "구민상", 5, 0, 13, "MON", 3),
            new Course(2001, "리눅스 프로그래밍", "조영현", 5, 0, 11, "TUE", 2),
            new Course(2002, "리눅스 프로그래밍", "구민상", 5, 0, 11, "WED", 2),
            new Course(3001, "HTML", "황선애", 3, 0, 10, "MON", 3),
            new Course(4001, "CSS", "황선애", 3, 0, 14, "FRI", 3),
            new Course(5001, "알고리즘", "이정민", 5, 0, 9, "THU", 3),
            new Course(6001, "자료구조", "이정민", 5, 0, 15, "THU", 3),
            new Course(7001, "네트워크", "조영현", 5, 0, 11, "THU", 3),
            new Course(8001, "메타인지", "김요한", 5, 0, 9, "TUE", 1),
            new Course(9001, "22학점강의", "김요한", 5, 0, 13, "FRI", 22)
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

    public List<Course> findByProfessor(String profName) {
        return courses.stream().filter(c->c.getProf().equals(profName)).collect(Collectors.toList());
    }

    public List<Course> findByCredit(int credit) {
        return courses.stream().filter(c->c.getCredit() == credit).collect(Collectors.toList());
    }
}
