package block_9.modelUser;

import block_9.abstractClasses.User;

public class Student extends User {
    private String university;


    public Student(String name, String university) {
        super(name);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public void greet() {
        System.out.println("Hello, my name is " + name + ". I'm studying at " + university + " university.");
    }
}
