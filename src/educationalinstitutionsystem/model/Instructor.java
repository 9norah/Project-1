
package educationalinstitutionsystem.model;


public class Instructor {
    private String instructorId;
    private String instructorName;
    private String instructorEmail;
    private String instructorPassword;

    public Instructor() {
    }

    public Instructor(String instructorId, String instructorName, String instructorEmail, String instructorPassword) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.instructorEmail = instructorEmail;
        this.instructorPassword = instructorPassword;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }

    public String getInstructorPassword() {
        return instructorPassword;
    }

    public void setInstructorPassword(String instructorPassword) {
        this.instructorPassword = instructorPassword;
    }
    
        @Override
    public String toString() {
        return String.format("Id: %s \nName: %s \nEmail: %s \nPassword: %s\n"
                + "----------------------------------------------------\n",
                getInstructorId(), getInstructorName(), getInstructorEmail(), getInstructorPassword());
    }
}
