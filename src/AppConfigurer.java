import course.PrintCourseList;
import course.CourseRepository;
import member.Member;
import member.MemberRepository;

public class AppConfigurer {
    public CourseRepository courseRepository = new CourseRepository();
    public PrintCourseList courseList = new PrintCourseList(courseRepository.getCourses()); // 수정 필요
    public MemberRepository memberRepository = new MemberRepository();
    public Menu menu = new Menu(memberRepository.getMembers());

}
