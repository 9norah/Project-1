package educationalinstitutionsystem.model;

public class Mark {

    private int idMark;
    private double mark;
    private Course course;
    private Student student;
    private Instructor instructor;

    public Mark(int idMark, double mark, Course course, Student student, Instructor instructor) {
        this.idMark = idMark;
        this.mark = mark;
        this.course = course;
        this.student = student;
        this.instructor = instructor;
    }

    public int getIdMark() {
        return idMark;
    }

    public void setMark(int idMark) {
        this.idMark = idMark;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
