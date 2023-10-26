package educationalinstitutionsystem.screens;

import educationalinstitutionsystem.model.Course;
import educationalinstitutionsystem.model.Instructor;
import educationalinstitutionsystem.model.Student;
import javax.swing.*;
import java.awt.*;

public class ManageUsersFrame extends JFrame {

    private String typeUser;

    public ManageUsersFrame(int opNumber) {
        switch (opNumber) {
            case MYSystem.KEY_STUDENT:
                typeUser = "Student";
                break;
            case MYSystem.KEY_COURSE:
                typeUser = "Course";
                break;
            case MYSystem.KEY_INSTRUCTOR:
                typeUser = "Instructor";
                break;
        }
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        if (opNumber != MYSystem.KEY_COURSE) {
            JButton updateUserButton = new JButton("Update Data " + typeUser);
            add(updateUserButton);
            updateUserButton.addActionListener((e) -> {
                setVisible(false);
                new RegistrationAndUpdateFrame(MYSystem.KEY_UPDATE, opNumber);
            });
        } else {
            JButton addInstructorToCourseButton = new JButton("Add Instractor to " + typeUser);
            add(addInstructorToCourseButton);
            addInstructorToCourseButton.addActionListener((e) -> {
                String inputIdCourse = JOptionPane.showInputDialog("Enter ID of Course:");
                if (inputIdCourse.isEmpty() || MYSystem.getCourseById(inputIdCourse) == null) {
                    JOptionPane.showMessageDialog(ManageUsersFrame.this,
                            "ID Is Not Found", "Field", JOptionPane.ERROR_MESSAGE);
                } else {
                    String inputIdInstructor = JOptionPane.showInputDialog("Enter ID of Instructor:");
                    Instructor instructor = MYSystem.getInstructorById(inputIdInstructor);
                    if (inputIdInstructor.isEmpty() || MYSystem.getInstructorById(inputIdInstructor) == null) {
                        JOptionPane.showMessageDialog(ManageUsersFrame.this,
                                "ID Is Not Found", "Field", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (MYSystem.addInstructorToCourse(inputIdCourse, instructor)) {
                            JOptionPane.showMessageDialog(ManageUsersFrame.this, "Successful!");
                        } else {
                            JOptionPane.showMessageDialog(ManageUsersFrame.this,
                                    "Field", "Field", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }

            });
        }
        JButton createUserButton = new JButton("Create " + typeUser);
        JButton viewUsersButton = new JButton("View " + typeUser + "s");
        JButton deleteUserButton = new JButton("Delete " + typeUser);
        JButton exiteButton = new JButton("Exite");

        add(createUserButton);
        add(viewUsersButton);
        add(deleteUserButton);
        add(exiteButton);

        setTitle(typeUser + " Manager");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        createUserButton.addActionListener((e) -> {
            if (opNumber == MYSystem.KEY_COURSE) {
                String inputIdCourse = JOptionPane.showInputDialog("Enter ID For Course:");
                String inputNameCourse = JOptionPane.showInputDialog("Enter Name For Course:");
                Course course = new Course(inputIdCourse, inputNameCourse);
                if (MYSystem.createCourse(course)) {
                    JOptionPane.showMessageDialog(ManageUsersFrame.this, "Add Course Successful!");
                } else {
                    JOptionPane.showMessageDialog(ManageUsersFrame.this,
                            "ID Is Found", "Added Field", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                setVisible(false);
                new RegistrationAndUpdateFrame(MYSystem.KEY_CREATE, opNumber);
            }
        });
        viewUsersButton.addActionListener((e) -> {
            switch (opNumber) {
                case MYSystem.KEY_STUDENT:
                    if (MYSystem.getStudents().size() == 0) {
                        JOptionPane.showMessageDialog(null, "Not found any Students");
                    } else {
                        MYSystem.viewStudents();
                    }
                    break;
                case MYSystem.KEY_COURSE:
                    if (MYSystem.getCourses().size() == 0) {
                        JOptionPane.showMessageDialog(null, "Not found any Courses");
                    } else {
                        MYSystem.viewCourses();
                    }

                    break;
                case MYSystem.KEY_INSTRUCTOR:
                    if (MYSystem.getInstructors().size() == 0) {
                        JOptionPane.showMessageDialog(null, "Not found any Instructors");
                    } else {
                        MYSystem.viewInstructors();
                    }

                    break;
            }
        });
        deleteUserButton.addActionListener((e) -> {
            switch (opNumber) {
                case MYSystem.KEY_STUDENT:
                    String inputIdStudent = JOptionPane.showInputDialog("Enter ID of Student:");
                    Student s = MYSystem.deleteStudent(inputIdStudent);
                    if (s != null) {
                        JOptionPane.showMessageDialog(ManageUsersFrame.this, "Deleted Successful!");
                    } else {
                        JOptionPane.showMessageDialog(ManageUsersFrame.this,
                                "ID Is Not Found", "Deleted Field", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case MYSystem.KEY_COURSE:
                    String inputIdCourse = JOptionPane.showInputDialog("Enter ID of Course:");
                    Course c = MYSystem.deleteCourse(inputIdCourse);
                    if (c != null) {
                        JOptionPane.showMessageDialog(ManageUsersFrame.this, "Deleted Successful!");
                    } else {
                        JOptionPane.showMessageDialog(ManageUsersFrame.this,
                                "ID Is Not Found", "Deleted Field", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case MYSystem.KEY_INSTRUCTOR:
                    String inputIdInstructor = JOptionPane.showInputDialog("Enter ID of Student:");
                    Instructor i = MYSystem.deleteInstructor(inputIdInstructor);
                    if (i != null) {
                        JOptionPane.showMessageDialog(ManageUsersFrame.this, "Deleted Successful!");
                    } else {
                        JOptionPane.showMessageDialog(ManageUsersFrame.this,
                                "ID Is Not Found", "Deleted Field", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

            }
        });
        exiteButton.addActionListener((e) -> {
            setVisible(false);
            new AdminPanelFrame();
        });
    }

}
