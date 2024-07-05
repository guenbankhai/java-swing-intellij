package project.GUI;

import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import project.BUS.DiemMonHocBUS;
import project.DTO.DiemMonHocDTO;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

public class FrameMain extends JFrame {
    public static final String DIEMMONHOC_TABLE = "DIEMMONHOC";
    public static final String KHOITHI_TABLE = "KHOITHI";
    public static final String LOP_TABLE = "LOP";
    public static final String MONHOC_TABLE = "MONHOC";
    public static final String NAMHOC_TABLE = "NAMHOC";
    public static final String PHANCONG_TABLE = "PHANCONGGIANGDAY";
    public static final String GIAOVIEN_TABLE = "GIAOVIEN";
    public static final String HOCSINH_TABLE = "HOCSINH";
    public static final String TOCHUYENMON_TABLE = "TOCHUYENMON";

    private String tableType;
    private Object[][] tempData;
    private String[] columnNames;
    private int rowsPerPage = 100;
    private int currentPage = 1;

    private DiemMonHocBUS control = new DiemMonHocBUS();

    public FrameMain() {
        initComponents();

        table.setDefaultEditor(Object.class, null);
        table.getTableHeader().setReorderingAllowed(false);
    }

    private void btnNavigationMouseClicked(MouseEvent e) {
        if (drawer.isShow()) {
            drawer.hide();
        }
        else {
            drawer.show();
        }
    }

    private void btnPageNumberMouseClicked(MouseEvent e) {
        currentPage = Integer.parseInt(cbxPageNumber.getSelectedItem().toString());
        refreshTable();
    }

    private void initComponents() {
        // Drawer
        drawer = Drawer.newDrawer(this)
                .drawerBackground(new Color(0xff9966))
                .space(5)
                .header(new PanelNavigation())
                .addFooter(new DrawerItem("Exit").build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int i, DrawerItem drawerItem) {

                    }
                })
                .build();

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - guenbankhai
        scrollPaneMain = new JScrollPane();
        table = new JTable();
        btnNavigation = new JButton();
        btnPageNumber = new JButton();
        cbxPageNumber = new JComboBox();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== scrollPaneMain ========
        {

            //---- table ----
            table.setBackground(Color.lightGray);
            table.setShowHorizontalLines(true);
            table.setShowVerticalLines(true);
            scrollPaneMain.setViewportView(table);
        }

        //---- btnNavigation ----
        btnNavigation.setText("|||");
        btnNavigation.setForeground(Color.white);
        btnNavigation.setBackground(Color.gray);
        btnNavigation.setFont(new Font("Segoe UI", Font.BOLD, 11));
        btnNavigation.setFocusable(false);
        btnNavigation.setBorderPainted(false);
        btnNavigation.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnNavigationMouseClicked(e);
            }
        });

        //---- btnPageNumber ----
        btnPageNumber.setText("X\u00e1c nh\u1eadn");
        btnPageNumber.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnPageNumber.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnPageNumberMouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnNavigation, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(991, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(827, Short.MAX_VALUE)
                            .addComponent(cbxPageNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnPageNumber))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(scrollPaneMain, GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)))
                    .addGap(50, 50, 50))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnNavigation)
                    .addGap(75, 75, 75)
                    .addComponent(scrollPaneMain, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPageNumber)
                        .addComponent(cbxPageNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(37, 37, 37))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private DrawerController drawer;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - guenbankhai
    private JScrollPane scrollPaneMain;
    private JTable table;
    private JButton btnNavigation;
    private JButton btnPageNumber;
    private JComboBox cbxPageNumber;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void setTableData(String[] columnNames, Object[][] data) {
        this.columnNames = columnNames;
        this.tempData = data;
        currentPage = 1;

        // Tính toán và cập nhật số trang tương ứng với dữ liệu mới
        int totalPages = (int) Math.ceil((double) tempData.length / rowsPerPage);
        addPageNumber(totalPages);

        refreshTable();
    }

    private void addPageNumber(int totalPages) {
        cbxPageNumber.removeAllItems();
        for (int i = 1; i <= totalPages; i++) {
            cbxPageNumber.addItem(String.valueOf(i));
        }
    }

    private void refreshTable() {
        int startIndex = (currentPage - 1) * rowsPerPage;
        int endIndex = Math.min(startIndex + rowsPerPage, tempData.length);

        Object[][] currentPageData = new Object[endIndex - startIndex][columnNames.length];
        for (int i = startIndex; i < endIndex; i++) {
            currentPageData[i - startIndex] = tempData[i];
        }

        DefaultTableModel model = new DefaultTableModel(currentPageData, columnNames);
        table.setModel(model);
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }


    //Show tabel
    public void showTableDiemMonHoc() {
        this.setTableType(FrameMain.DIEMMONHOC_TABLE);
        List<DiemMonHocDTO> list = control.getAllDiemMonHoc();
        String[] columnNames = {"Mã học sinh", "Mã môn học", "Năm học", "Học kỳ", "Điểm HS1", "Điểm HS2", "Điểm HS3", "Điểm TB"};
        Object[][] data = new Object[list.size()][8];

        for (int i = 0; i < list.size(); i++) {
            DiemMonHocDTO var = list.get(i);
            data[i][0] = var.getMaHS();
            data[i][1] = var.getMaMH();
            data[i][2] = var.getNamHoc();
            data[i][3] = var.getHocKy();
            data[i][4] = var.getDiemHS1();
            data[i][5] = var.getDiemHS2();
            data[i][6] = var.getDiemHS3();
            data[i][7] = var.getDiemTB();
        }

        this.setTableData(columnNames, data);
    }
}
