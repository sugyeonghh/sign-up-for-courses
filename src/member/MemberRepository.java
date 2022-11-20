package member;

import member.submember.Professor;
import member.submember.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemberRepository {
    List<Member> members = new ArrayList<>(Arrays.asList(
            new Professor(202201, 202201, "김요한", "컴퓨터공학", "코드스테이츠 1관"),
            new Professor(202202, 202202, "조영현", "컴퓨터과학", "코드스테이츠 2관"),
            new Professor(202203, 202203, "구민상", "소프트웨어공학", "코드스테이츠 3관"),
            new Professor(202204, 202204, "황선애", "글로벌IT학", "코드스테이츠 4관"),
            new Professor(202205, 202205, "이정민", "컴퓨터공학", "코드스테이츠 5관"),
            new Student(20221001, 20221001, "김지형", "컴퓨터공학", 4),
            new Student(20221002, 20221002, "윤상혁", "글로벌IT학", 3),
            new Student(20221003, 20221003, "이기호", "소프트웨어공학", 2),
            new Student(20221004, 20221004, "최영근", "소프트웨어공학", 3),
            new Student(20221005, 20221005, "홍수경", "컴퓨터공학", 1)
    ));

    public List<Member> getMembers() {
        return members;
    }

    public Member findById(int id) {
        return members.stream().filter(m -> m.getId() == id).findAny().get();
    }

    public List<Member> findByMajor(String major) {
        return members.stream().filter(m -> m.getMajor().equals(major)).collect(Collectors.toList());
    }
}
