package educationalinstitutionsystem.screens;

import javax.swing.*;
import java.awt.*;

public class InstructorPanelFrame extends JFrame {

    public InstructorPanelFrame(String instructorID) {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton recordMarkStudentButton = new JButton("Record Mark Student");
        JButton viewAllMarksButton = new JButton("View All Marks");
        JButton exiteButton = new JButton("Exit");

        add(recordMarkStudentButton);
        add(viewAllMarksButton);
        add(exiteButton);

        setTitle("Admin Panel");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        recordMarkStudentButton.addActionListener((e) -> {
            String studintId = JOptionPane.showInputDialog("Enter Student Id:");
            if (!studintId.isEmpty()) {
                String courseId = JOptionPane.showInputDialog("Enter Course Id:");
                if (!courseId.isEmpty()) {
                    String mark = JOptionPane.showInputDialog("Enter Mark:");
                    if (!mark.isEmpty()) {
                        switch (MYSystem.recordMarkStudent(instructorID, studintId, courseId, Double.parseDouble(mark))) {
                            case 0:
                                JOptionPane.showMessageDialog(this, "Error Entry", "Record Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(InstructorPanelFrame.this,
                                        "Update student mark Successful!");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(InstructorPanelFrame.this,
                                        "Record student mark Successful!");
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(this, "not have this course", "Record Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(this, "student not have this course", "Record Error", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    }
                }

            } else {
                JOptionPane.showMessageDialog(this, "Error Entry", "Record Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        viewAllMarksButton.addActionListener((e) -> {
            String courseId = JOptionPane.showInputDialog("Enter Course Id:");
            if (!MYSystem.viewAllInstructorMyMark(instructorID, courseId)) {
                JOptionPane.showMessageDialog(this, "not have data", "View Marks", JOptionPane.ERROR_MESSAGE);
            }

        });

        exiteButton.addActionListener((e) -> {
            setVisible(false);
            new SystemLoginFrame();
        });
    }

}
