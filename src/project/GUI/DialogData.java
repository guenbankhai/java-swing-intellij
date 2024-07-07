package project.GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

public class DialogData extends JDialog {
    private static final String[] COLUMN_NAMES = {"Kiểu dữ liệu", "Giá trị"};

    public DialogData(Window owner, int action, String tableType, String[] columnNames, String[] data) {
        super(owner);
        initComponents();
        table.setRowSelectionAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        showTable(action, columnNames, data);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - guenbankhai
        scrollPane = new JScrollPane();
        table = new JTable();
        btnAccept = new JButton();
        btnCancel = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane ========
        {
            scrollPane.setBackground(Color.white);
            scrollPane.setBorder(null);
            scrollPane.setFocusable(false);
            scrollPane.setOpaque(false);

            //---- table ----
            table.setFocusable(false);
            table.setBackground(Color.lightGray);
            table.setShowHorizontalLines(true);
            table.setShowVerticalLines(true);
            scrollPane.setViewportView(table);
        }

        //---- btnAccept ----
        btnAccept.setText("X\u00e1c nh\u1eadn");
        btnAccept.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnAccept.setBackground(Color.gray);
        btnAccept.setBorderPainted(false);
        btnAccept.setFocusable(false);
        btnAccept.setFocusPainted(false);

        //---- btnCancel ----
        btnCancel.setText("Hu\u1ef7");
        btnCancel.setBackground(Color.gray);
        btnCancel.setBorderPainted(false);
        btnCancel.setFocusable(false);
        btnCancel.setFocusPainted(false);
        btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 12));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(104, 104, 104)
                            .addComponent(btnAccept)
                            .addGap(33, 33, 33)
                            .addComponent(btnCancel)))
                    .addGap(18, 18, 18))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAccept)
                        .addComponent(btnCancel))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - guenbankhai
    private JScrollPane scrollPane;
    private JTable table;
    private JButton btnAccept;
    private JButton btnCancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private Object[][] combineData(String[] varNames, String[] data) {
        int length = Math.max(varNames.length, data != null ? data.length : 0);
        Object[][] combinedData = new Object[length][2];

        for (int i = 0; i < length; i++) {
            combinedData[i][0] = (i < varNames.length) ? varNames[i] : "";
            combinedData[i][1] = (data != null && i < data.length && data[i] != null) ? data[i] : "";
        }

        return combinedData;
    }


    private Object[][] transposeData(Object[][] data) {
        if (data == null || data.length == 0) {
            return data;
        }

        int rows = data.length;
        int columns = data[0].length;
        Object[][] transposedData = new Object[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedData[j][i] = data[i][j];
            }
        }
        return transposedData;
    }

    private void showTable(int action,String[] varNames, String[] data) {
        Object[][] tableData = transposeData(combineData(varNames, data));
        DefaultTableModel model = new DefaultTableModel(transposeData(tableData), COLUMN_NAMES) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return !(action == 1 && row == 0);
            }
        };
        table.setModel(model);
    }

}
