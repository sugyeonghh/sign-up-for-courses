package member.submember;

import member.Member;

public class Professor extends Member {
    private String lab;

    public Professor(int id, int password, String name, String major, String lab) {
        super(id, password, name, major);
        this.lab = lab;
    }

    public String getLab() {
        return lab;
    }

    @Override
    public void printMyInfo(Member member) {
        super.printMyInfo(member);
        System.out.println("연구실: " + ((Professor) member).getLab());
    }
}
