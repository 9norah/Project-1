package educationalinstitutionsystem.model;

import java.util.ArrayList;

public class Student {

    private String studentId;
    private String studentName;
    private String studentEmail;
    private String studentPassword;
    private ArrayList<Course> courses ;

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(Course course) {
        this.courses.add(course);
    }
    public Student() {
        courses = new ArrayList<>();
    }

    public Student(String studentId, String studentName, String studentEmail, String studentPassword) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPassword = studentPassword;
        courses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    @Override
    public String toString() {
        return String.format("Id: %s \nName: %s \nEmail: %s \nPassword: %s\n"
                + "----------------------------------------------------\n",
                getStudentId(), getStudentName(), getStudentEmail(), getStudentPassword());
    }

}
