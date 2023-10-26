package educationalinstitutionsystem.screens;

import javax.swing.*;
import java.awt.*;

public class SystemLoginFrame extends JFrame {

    public SystemLoginFrame() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // 10 pixels of horizontal and vertical gap

        JButton admin = new JButton("Admin");
        JButton student = new JButton("Student");
        JButton instructor = new JButton("Instructor");
        JButton exiteButton = new JButton("Exit");

        add(admin);
        add(student);
        add(instructor);
        add(exiteButton);

        // Set frame properties
        setTitle("System");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);

        admin.addActionListener((e) -> {
            setVisible(false);
            new LoginUserFrame(MYSystem.KEY_ADMIN);
        });

        student.addActionListener((e) -> {
            setVisible(false);
            new LoginUserFrame(MYSystem.KEY_STUDENT);
        });

        instructor.addActionListener((e) -> {
            setVisible(false);
            new LoginUserFrame(MYSystem.KEY_INSTRUCTOR);
        });

        exiteButton.addActionListener((e) -> {
            System.exit(DO_NOTHING_ON_CLOSE);
        });
    }
    
    
   

}
