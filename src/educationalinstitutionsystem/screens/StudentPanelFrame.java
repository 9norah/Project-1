package educationalinstitutionsystem.screens;

import javax.swing.*;
import java.awt.*;

public class StudentPanelFrame extends JFrame {

    public StudentPanelFrame(String studentID) {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton registerCourseButton = new JButton("Register for a Course");
        JButton viewAllCourcesButton = new JButton("View All Cources");
        JButton viewMyCourcesButton = new JButton("View My Cources");
        JButton viewMyMarksButton = new JButton("View My Marks");
        JButton exiteButton = new JButton("Exit");

        add(registerCourseButton);
        add(viewAllCourcesButton);
        add(viewMyCourcesButton);
        add(viewMyMarksButton);
        add(exiteButton);

        setTitle("Admin Panel");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        registerCourseButton.addActionListener((e) -> {
            String courseId = JOptionPane.showInputDialog("Enter ID Course:");
            switch (MYSystem.registerForACourse(studentID, courseId)) {
                case 0:
                    JOptionPane.showMessageDialog(StudentPanelFrame.this, "Failed");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(StudentPanelFrame.this, "This Course not have Instructor");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(StudentPanelFrame.this, " Successful!");
                    break;
                default:
                    throw new AssertionError();
            }
        });
        viewAllCourcesButton.addActionListener((e) -> {
            if (MYSystem.getCourses().size() == 0) {
                JOptionPane.showMessageDialog(null, "Not found any Courses");
            } else {
                MYSystem.viewCourses();
            }
        });

        viewMyCourcesButton.addActionListener((e) -> {
            if (!MYSystem.viewMyCourses(studentID)) {
                JOptionPane.showMessageDialog(null, "Not found any Courses");
            } 
        });

        viewMyMarksButton.addActionListener((e) -> {
             if (!MYSystem.viewAllMyMarksStudent(studentID)) {
                JOptionPane.showMessageDialog(null, "Not found any Marks");
            } 
        });

        exiteButton.addActionListener((e) -> {
            setVisible(false);
            new SystemLoginFrame();
        });
    }

}
