package project.GUI;

import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import other.SelectedRowsData;
import project.BUS.*;
import project.DTO.DiemMonHocDTO;
import project.DTO.TaiKhoanDTO;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
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

    public static final String THONGTIN_HOCSINH = "THONGTINHOCSINH";
    public static final String BANGDIEM_HOCSINH = "BANGDIEMHOCSINH";

    public static final String THONGTIN_GIAOVIEN = "THONGTINGIAOVIEN";
    public static final String BANGDIEM_GIAOVIEN = "BANGDIEMGIAOVIEN";

    private static final String[] COLUMN_NAMES = {"Kiểu dữ liệu", "Giá trị"};

    private TaiKhoanDTO taiKhoan = TaiKhoanBUS.taiKhoan;
    private String role = taiKhoan.getVaiTro();
    private String tenDN = taiKhoan.getTenDangNhap();

    public String tableType;
    private Object[][] tempData;
    private String[] columnNames;
    private int rowsPerPage = 100;
    private int currentPage = 1;

    private DiemMonHocBUS diemMonHoc = new DiemMonHocBUS();
    private KhoiThiBUS khoiThi = new KhoiThiBUS();
    private LopBUS lop = new LopBUS();
    private MonHocBUS monHoc = new MonHocBUS();
    private NamHocBUS namHoc = new NamHocBUS();
    private PhanCongGiangDayBUS phanCongGiangDay = new PhanCongGiangDayBUS();
    private ThongTinGiaoVienBUS thongTinGiaoVien = new ThongTinGiaoVienBUS();
    private ThongTinHocSinhBUS thongTinHocSinh = new ThongTinHocSinhBUS();
    private ToChuyenMonBUS  toChuyenMon = new ToChuyenMonBUS();

    public FrameMain() {
        initComponents();
        JFrame frame = this;
        addDrawer(frame);
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

    private void btnDeleteMouseClicked(MouseEvent e) {
        SelectedRowsData selectedRowsData = getSelectedRowsData();
        if (selectedRowsData.getRowCount() > 0) {
            DialogNotification dialog = new DialogNotification("Bạn có chắc chắn muốn xóa " + selectedRowsData.getRowCount() + " dòng?", DialogNotification.WARNING_DIALOG);
            if (dialog.getAction() == DialogNotification.OK_OPTION) {
                switch (tableType) {
                    case DIEMMONHOC_TABLE:
                        diemMonHoc.delete(selectedRowsData.getData());
                        break;
                    case KHOITHI_TABLE:
                        khoiThi.delete(selectedRowsData.getData());
                        break;
                    case  LOP_TABLE:
                        lop.delete(selectedRowsData.getData());
                        break;
                    case MONHOC_TABLE:
                        monHoc.delete(selectedRowsData.getData());
                        break;
                    case NAMHOC_TABLE:
                        namHoc.delete(selectedRowsData.getData());
                        break;
                    case PHANCONG_TABLE:
                        phanCongGiangDay.delete(selectedRowsData.getData());
                        break;
                    case HOCSINH_TABLE:
                        thongTinHocSinh.delete(selectedRowsData.getData());
                        break;
                    case GIAOVIEN_TABLE:
                        thongTinGiaoVien.delete(selectedRowsData.getData());
                        break;
                    case TOCHUYENMON_TABLE:
                        toChuyenMon.delete(selectedRowsData.getData());
                        break;
                }
                this.UpdateTable(selectedRowsData);
            }
        } else {
            new DialogNotification("Chưa chọn dòng nào!", DialogNotification.ERROR_DIALOG);
        }
    }

    private void btnEditMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void btnAddMouseClicked(MouseEvent e) {
        new DialogData(this, 1, tableType, columnNames, null).setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - guenbankhai
        scrollPaneMain = new JScrollPane();
        table = new JTable();
        btnNavigation = new JButton();
        btnPageNumber = new JButton();
        cbxPageNumber = new JComboBox();
        btnAdd = new JButton();
        btnEdit = new JButton();
        btnDelete = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== scrollPaneMain ========
        {
            scrollPaneMain.setOpaque(false);
            scrollPaneMain.setFocusable(false);

            //---- table ----
            table.setBackground(Color.lightGray);
            table.setShowHorizontalLines(true);
            table.setShowVerticalLines(true);
            table.setFocusable(false);
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
        btnPageNumber.setFocusPainted(false);
        btnPageNumber.setBackground(Color.gray);
        btnPageNumber.setFocusable(false);
        btnPageNumber.setBorderPainted(false);
        btnPageNumber.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnPageNumberMouseClicked(e);
            }
        });

        //---- cbxPageNumber ----
        cbxPageNumber.setBackground(Color.gray);
        cbxPageNumber.setFocusable(false);
        cbxPageNumber.setBorder(null);

        //---- btnAdd ----
        btnAdd.setText("Th\u00eam");
        btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnAdd.setFocusPainted(false);
        btnAdd.setFocusable(false);
        btnAdd.setBackground(Color.gray);
        btnAdd.setBorderPainted(false);
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnAddMouseClicked(e);
            }
        });

        //---- btnEdit ----
        btnEdit.setText("S\u1eeda");
        btnEdit.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnEdit.setFocusPainted(false);
        btnEdit.setBackground(Color.gray);
        btnEdit.setFocusable(false);
        btnEdit.setBorderPainted(false);
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnEditMouseClicked(e);
            }
        });

        //---- btnDelete ----
        btnDelete.setText("Xo\u00e1");
        btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnDelete.setFocusPainted(false);
        btnDelete.setBackground(Color.gray);
        btnDelete.setFocusable(false);
        btnDelete.setBorderPainted(false);
        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnDeleteMouseClicked(e);
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
                    .addGap(50, 50, 50)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(btnAdd)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnEdit)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnDelete)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 537, Short.MAX_VALUE)
                            .addComponent(cbxPageNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnPageNumber))
                        .addComponent(scrollPaneMain, GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE))
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
                        .addComponent(cbxPageNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd)
                        .addComponent(btnEdit)
                        .addComponent(btnDelete))
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
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void addDrawer(JFrame frame) {
        DrawerItem  footer = new DrawerItem("Đăng xuất");
        footer.setForeground(Color.WHITE);
        footer.setFocusable(false);

        drawer = Drawer.newDrawer(frame)
                .drawerBackground(new Color(0xff9966))
                .space(5)
                .header(new PanelNavigation())
                .addFooter( footer.build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int i, DrawerItem drawerItem) {
                        if (drawerItem.getLabel().equals("Đăng xuất")) {
                            frame.dispose();
                            FrameLogin login = new FrameLogin();
                            login.setVisible(true);
                        }
                    }
                })
                .build();
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

    public void setTableColumNames(String tableType) {
        switch (tableType) {
            case DIEMMONHOC_TABLE:
                columnNames = new String[]{"Mã học sinh", "Mã môn học", "Năm học", "Học kỳ", "Điểm HS1", "Điểm HS2", "Điểm HS3", "Điểm TB"};
                break;
            case KHOITHI_TABLE:
                columnNames = new String[]{"Mã khối thi", "Mã môn học 1", "Mã môn học 2", "Mã môn học 3"};
                break;
            case  LOP_TABLE:
                columnNames = new String[]{"Mã lớp", "Mã khối thi", "Năm mở lớp"};
                break;
            case MONHOC_TABLE:
                columnNames = new String[]{"Mã môn học", "Tên môn học"};
                break;
            case NAMHOC_TABLE:
                columnNames = new String[]{"Năm bắt đầu", "Năm kết thúc", "Năm học"};
                break;
            case PHANCONG_TABLE:
                columnNames = new String[]{"Mã lớp", "Mã môn học", "Năm học", "Mã giáo viên"};
                break;
            case HOCSINH_TABLE:
                columnNames = new String[]{"Mã học sinh", "Họ tên", "Giới tính", "Ngày sinh", "Nơi sinh", "Số điện thoại", "Năm nhập học", "Mã lớp"};
                break;
            case GIAOVIEN_TABLE:
                columnNames = new String[]{"Mã giáo viên", "Họ tên", "Giới tính", "Ngày sinh", "Nơi sinh", "Số điện thoại", "Mã tổ chuyên môn"};
                break;
            case TOCHUYENMON_TABLE:
                columnNames = new String[]{"Mã tổ chuyên môn", "Tên tổ", "Mã môn học 1", "Mã môn học 2", "Mã môn học 3"};
                break;
            case THONGTIN_HOCSINH:
                columnNames = new String[]{"Mã học sinh", "Họ tên", "Giới tính", "Ngày sinh", "Nơi sinh", "Số điện thoại", "Năm nhập học", "Mã lớp"};
                break;
            case THONGTIN_GIAOVIEN:
                columnNames = new String[]{"Mã giáo viên", "Họ tên", "Giới tính", "Ngày sinh", "Nơi sinh", "Số điện thoại", "Mã tổ chuyên môn"};
                break;
            case BANGDIEM_HOCSINH:
                columnNames = new String[]{"Mã học sinh", "Mã môn học", "Năm học", "Học kỳ", "Điểm HS1", "Điểm HS2", "Điểm HS3", "Điểm TB"};
                break;
            case BANGDIEM_GIAOVIEN:
                columnNames = new String[]{"Mã học sinh", "Mã môn học", "Năm học", "Học kỳ", "Điểm HS1", "Điểm HS2", "Điểm HS3", "Điểm TB"};
                break;
        }
    }

    public void setFuncion(String role, String tableType) {
        if (role.equals("HocSinh")) {
            switch (tableType) {
                case THONGTIN_HOCSINH:
                    btnAdd.setVisible(false);
                    btnEdit.setVisible(true);
                    btnDelete.setVisible(false);
                    break;
                case BANGDIEM_HOCSINH:
                    btnAdd.setVisible(false);
                    btnEdit.setVisible(false);
                    btnDelete.setVisible(false);
                    break;
            }
        } else if (role.equals("GiaoVien")) {
            switch (tableType) {
                case THONGTIN_GIAOVIEN:
                    btnAdd.setVisible(false);
                    btnEdit.setVisible(true);
                    btnDelete.setVisible(false);
                    break;
                case BANGDIEM_GIAOVIEN:
                    btnAdd.setVisible(true);
                    btnEdit.setVisible(false);
                    btnDelete.setVisible(false);
                    break;
            }
        }
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

    public void setTableData( Object[][] data) {
        this.tempData = data;
        currentPage = 1;

        // Tính toán và cập nhật số trang tương ứng với dữ liệu mới
        int totalPages = (int) Math.ceil((double) tempData.length / rowsPerPage);
        addPageNumber(totalPages);

        refreshTable();
    }

    public void showTableData(String tableType, Object[][] data) {
        this.setTableType(tableType);
        this.setTableColumNames(tableType);
        this.setFuncion(role, tableType);

        if (tableType.equals(THONGTIN_GIAOVIEN) || tableType.equals(THONGTIN_HOCSINH)) {
            Object[][] newData;
            newData = new Object[2][];
            newData[0] = columnNames;
            System.arraycopy(data, 0, newData, 1, data.length);
            Object[][] transposedData = transposeData(newData);
            columnNames = COLUMN_NAMES;
            this.columnNames = columnNames;
            this.setTableData(transposedData);
        } else {
            this.columnNames = columnNames;
            this.setTableColumNames(tableType);
            this.setTableData(data);
        }
    }

    public SelectedRowsData getSelectedRowsData() {
        int[] selectedRows = table.getSelectedRows();
        int rowCount = selectedRows.length;
        int columnCount = table.getColumnCount();
        Object[][] data = new Object[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                data[i][j] = table.getValueAt(selectedRows[i], j);
            }
        }
        return new SelectedRowsData(rowCount, data);
    }

    private void UpdateTable(SelectedRowsData selectedRowsData) {
        Object[][] newData = new Object[tempData.length - selectedRowsData.getRowCount()][columnNames.length];
        int newDataIndex = 0;
        for (int i = 0; i < tempData.length; i++) {
            boolean shouldSkip = false;
            for (Object[] selectedRow : selectedRowsData.getData()) {
                if (Arrays.equals(tempData[i], selectedRow)) {
                    shouldSkip = true;
                    break;
                }
            }
            if (!shouldSkip) {
                newData[newDataIndex++] = tempData[i];
            }
        }
        tempData = newData;
        showTableData(tableType, tempData);
    }
}
