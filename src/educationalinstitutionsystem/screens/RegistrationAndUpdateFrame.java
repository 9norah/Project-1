package educationalinstitutionsystem.screens;

import educationalinstitutionsystem.model.Instructor;
import educationalinstitutionsystem.model.Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationAndUpdateFrame extends JFrame {

    private JTextField idField;
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private String opName;
    String _id;

    public RegistrationAndUpdateFrame(int opType, int userType) {
        switch (opType) {
            case MYSystem.KEY_CREATE:
                opName = "Create";
                JLabel idLabel = new JLabel("ID:");
                idField = new JTextField();
                add(idLabel);
                add(idField);
                break;
            case MYSystem.KEY_UPDATE:
                opName = "Update";
                _id = JOptionPane.showInputDialog("Enter Id:");
                break;
        }
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");

        nameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();

        JButton registerButton = new JButton(opName);

        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel());
        add(registerButton);

        switch (opType) {
            case MYSystem.KEY_CREATE:
                registerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = idField.getText();
                        String name = nameField.getText();
                        String email = emailField.getText();
                        String password = new String(passwordField.getPassword());

                        if (isEmpty(id, name, email, password)) {
                            JOptionPane.showMessageDialog(RegistrationAndUpdateFrame.this,
                                    "Check all fields", opName + " field", JOptionPane.ERROR_MESSAGE);
                            setVisible(false);
                            new ManageUsersFrame(userType);
                        } else {
                            switch (userType) {
                                case MYSystem.KEY_STUDENT:
                                    if (MYSystem.getStudentById(id) == null) {
                                        JOptionPane.showMessageDialog(RegistrationAndUpdateFrame.this,
                                                opName + " Successful!");
                                        MYSystem.createStudent(new Student(id, name, email, password));
                                        setVisible(false);
                                        new ManageUsersFrame(userType);
                                    } else {
                                        JOptionPane.showMessageDialog(RegistrationAndUpdateFrame.this,
                                                "id is used", opName + " field", JOptionPane.ERROR_MESSAGE);
                                    }
                                    break;
                                case MYSystem.KEY_INSTRUCTOR:
                                    if (MYSystem.getInstructorById(id) == null) {
                                        JOptionPane.showMessageDialog(RegistrationAndUpdateFrame.this,
                                                opName + " Successful!");
                                        MYSystem.createInstructor(new Instructor(id, name, email, password));
                                        setVisible(false);
                                        new ManageUsersFrame(userType);
                                    } else {
                                        JOptionPane.showMessageDialog(RegistrationAndUpdateFrame.this,
                                                "id is used", opName + " field", JOptionPane.ERROR_MESSAGE);
                                    }
                                    break;
                            }
                        }

                    }
                });
                break;
            case MYSystem.KEY_UPDATE:
                if (MYSystem.getStudentById(_id) != null) {
                    registerButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String name = nameField.getText();
                            String email = emailField.getText();
                            String password = new String(passwordField.getPassword());
                            if (isEmpty(_id, name, email, password)) {
                                JOptionPane.showMessageDialog(RegistrationAndUpdateFrame.this,
                                        "Check all fields", opName + " field", JOptionPane.ERROR_MESSAGE);
                            } else {
                                switch (userType) {
                                    case MYSystem.KEY_STUDENT:
                                        JOptionPane.showMessageDialog(RegistrationAndUpdateFrame.this,
                                                opName + " Successful!");
                                        MYSystem.updateStudent(new Student(_id, name, email, password));
                                        setVisible(false);
                                        new ManageUsersFrame(userType);
                                        break;
                                    case MYSystem.KEY_INSTRUCTOR:
                                        JOptionPane.showMessageDialog(RegistrationAndUpdateFrame.this,
                                                opName + " Successful!");
                                        MYSystem.updateInstructor(new Instructor(_id, name, email, password));
                                        setVisible(false);
                                        new ManageUsersFrame(userType);
                                        break;
                                }

                            }

                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(RegistrationAndUpdateFrame.this,
                            "this id is not found", opName + " field", JOptionPane.ERROR_MESSAGE);
                    setVisible(false);
                    new ManageUsersFrame(userType);
                    return;
                }

                break;
        }

        setTitle("User Registration");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private boolean isEmpty(String studentId, String studentName, String studentEmail, String studentPassword) {
        if (studentId.isEmpty()
                || studentName.isEmpty()
                || studentEmail.isEmpty()
                || studentPassword.isEmpty()) {
            return true;

        }
        return false;
    }

}
