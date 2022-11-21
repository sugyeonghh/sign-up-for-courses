import course.CourseRepository;
import member.MemberRepository;

public class AppConfigurer {
    public CourseRepository courseRepository = new CourseRepository();
    public MemberRepository memberRepository = new MemberRepository();
    public Menu menu = new Menu(memberRepository.getMembers());

}
