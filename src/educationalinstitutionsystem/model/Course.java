package educationalinstitutionsystem.model;

import java.util.ArrayList;

public class Course {
    private String courseId;
    private String courseName;
    private Instructor instructor;

    public Course() {
    }

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


    @Override
    public String toString() {
        String output = String.format("Course Id: %s\nCourse Name: %s\n"
                + "----------------------------------------\n", getCourseId(),getCourseName());
        if (getInstructor()!=null) {
            output = String.format("Course Id: %s\nCourse Name: %s\nInstructor Name: %s\n"
                    + "----------------------------------------\n", getCourseId(),getCourseName(),getInstructor().getInstructorName());
        }
        return output;
    }
    
    
    
}
