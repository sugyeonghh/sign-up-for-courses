package member.submember;

import member.Member;

public class Student extends Member {
    private int year;

    public Student(int id, int password, String name, String major, int year) {
        super(id, password, name, major);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

}
