package educationalinstitutionsystem.screens;

import java.awt.GridLayout;
import javax.swing.*;

public class LoginUserFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private String typeUser;

    public LoginUserFrame(int opNumber) {

        switch (opNumber) {
            case MYSystem.KEY_ADMIN:
                typeUser = "Admin";
                break;
            case MYSystem.KEY_STUDENT:
                typeUser = "Student";
                break;
            case MYSystem.KEY_INSTRUCTOR:
                typeUser = "Instructor";
                break;
        }

        setTitle(typeUser + " Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");
        
        
        setLayout(new GridLayout(3, 2));
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(backButton);

        loginButton.addActionListener((e) -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            switch (opNumber) {
                case MYSystem.KEY_ADMIN:
                    if (username.equals("admin") && password.equals("admin")) {
                        setVisible(false);
                        new AdminPanelFrame();
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case MYSystem.KEY_STUDENT:
                    if (MYSystem.studentIsLogedin(username, password)) {
                        setVisible(false);
                        new StudentPanelFrame(username);
                    } else {
                        cleare(usernameField, passwordField);
                        JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case MYSystem.KEY_INSTRUCTOR:
                    if (MYSystem.instructorIsLogedin(username, password)) {
                        setVisible(false);
                        new InstructorPanelFrame(username);
                    } else {
                        cleare(usernameField, passwordField);
                        JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }

        });
        
        backButton.addActionListener((e) -> {
            setVisible(false);
            new SystemLoginFrame();
        });

    }

    private void cleare(JTextField usernameField, JPasswordField passwordField) {
        usernameField.setText("");
        passwordField.setText("");
    }

}
