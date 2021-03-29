package block_6.com.UserModel;

public class Student extends User{
    private int scholarship;
    private int course;

    public Student(String name, int age, int scholarship, int course) {
        super(name, age);
        this.scholarship = scholarship;
        this.course = course;
    }

    public int getScholarship() {
        return scholarship;
    }

    public void setScholarship(int scholarship) {
        this.scholarship = scholarship;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
