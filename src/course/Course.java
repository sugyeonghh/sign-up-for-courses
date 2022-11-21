package course;

public class Course {
    private int id;
    private String name;
    private String prof;
    private int maximumPeople;
    private int time;
    private String day;
    private int credit;

    public Course(int id, String name, String prof, int maximumPeople, int time, String day, int credit) {
        this.id = id;
        this.name = name;
        this.prof = prof;
        this.maximumPeople = maximumPeople;
        this.time = time;
        this.day = day;
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProf() {
        return prof;
    }

    public int getMaximumPeople() {
        return maximumPeople;
    }

    public int getTime() {
        return time;
    }

    public String getDay() {
        return day;
    }

    public int getCredit() {
        return credit;
    }
}

