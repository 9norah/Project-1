package educationalinstitutionsystem.screens;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DisplayTableFrame extends JFrame {

    private JTable table;

    public DisplayTableFrame(String title,String[] columnNames, String[][] data) {
        DefaultTableModel model = new DefaultTableModel(data,columnNames);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        setTitle(title);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
