import course.CourseRepository;
import member.MemberRepository;

public class AppConfigurer {
    public CourseRepository courseRepository = new CourseRepository();
    public MemberRepository memberRepository = new MemberRepository();
    public Menu menu = new Menu(memberRepository.getMembers());
    public ResisterPage resisterPage = new ResisterPage(courseRepository, memberRepository.getMembers());
    public Features features = new Features(memberRepository.getMembers(), courseRepository, resisterPage);

}
