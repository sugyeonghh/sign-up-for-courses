package member.submember;

import member.Member;

public class Student extends Member {
    private int year;
    private int credit;
    private int maxCredit;

    public Student(int id, int password, String name, String major, int year, int maxCredit) {
        super(id, password, name, major);
        this.year = year;
        this.maxCredit = maxCredit;
        this.credit = 0;
    }

    public int getYear() {
        return year;
    }

    public int getMaxCredit() {
        return maxCredit;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit += credit;
    }

    @Override
    public void printMyInfo(Member member) {
        super.printMyInfo(member);
        System.out.println("학년: " + ((Student) member).getYear() + "학년");
        System.out.println("신청 가능한 학점: " + ((Student) member).getMaxCredit() + "학점");
    }
}
