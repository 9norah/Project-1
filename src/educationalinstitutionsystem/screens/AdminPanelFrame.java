package educationalinstitutionsystem.screens;

import javax.swing.*;
import java.awt.*;

public class AdminPanelFrame extends JFrame {

    public AdminPanelFrame() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton manageStudentButton = new JButton("Manage Student");
        JButton manageInstructorButton = new JButton("Manage Instructor");
        JButton manageCourcesButton = new JButton("Manage Cources");
        JButton exiteButton = new JButton("Exit");

        add(manageStudentButton);
        add(manageInstructorButton);
        add(manageCourcesButton);
        add(exiteButton);

        setTitle("Admin Panel");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(true);

        manageStudentButton.addActionListener((e) -> {
            setVisible(false);
            new ManageUsersFrame(MYSystem.KEY_STUDENT);
        });

        manageInstructorButton.addActionListener((e) -> {
            setVisible(false);
            new ManageUsersFrame(MYSystem.KEY_INSTRUCTOR);
        });

        manageCourcesButton.addActionListener((e) -> {
            setVisible(false);
            new ManageUsersFrame(MYSystem.KEY_COURSE);
        });

        exiteButton.addActionListener((e) -> {
            setVisible(false);
            new SystemLoginFrame();
        });
    }

}
