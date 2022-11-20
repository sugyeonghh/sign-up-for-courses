package member;

public class Member {
    private int id;
    private int password;
    private String name;
    private String major;

    public Member(int id, int password, String name, String major) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.major = major;
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

}
