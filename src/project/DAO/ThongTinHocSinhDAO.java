package project.DAO;

import project.DTO.ThongTinHocSinhDTO;
import project.GUI.DialogNotification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongTinHocSinhDAO {
    public List<ThongTinHocSinhDTO> getAllThongTinHocSinh() {
        List<ThongTinHocSinhDTO> list = new ArrayList<>();
        String query = "SELECT * FROM ThongTinHocSinh";

        try (PreparedStatement ps = Connect.conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ThongTinHocSinhDTO hocSinh = new ThongTinHocSinhDTO(
                        rs.getString("maHS"),
                        rs.getString("hoTen"),
                        rs.getString("gioiTinh"),
                        rs.getDate("ngaySinh"),
                        rs.getString("noiSinh"),
                        rs.getString("SoDienThoai"),
                        rs.getInt("namNhapHoc"),
                        rs.getString("maLop")
                );
                list.add(hocSinh);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ThongTinHocSinhDTO getThongTinHocSinh(String maHS) {
        ThongTinHocSinhDTO result = null;
        String query = "SELECT * FROM ThongTinHocSinh WHERE maHS=?";
        try (PreparedStatement ps = Connect.conn.prepareStatement(query)) {
            ps.setString(1, maHS);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    result = new ThongTinHocSinhDTO(
                            rs.getString("maHS"),
                            rs.getString("hoTen"),
                            rs.getString("gioiTinh"),
                            rs.getDate("ngaySinh"),
                            rs.getString("noiSinh"),
                            rs.getString("SoDienThoai"),
                            rs.getInt("namNhapHoc"),
                            rs.getString("maLop")
                    );
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public boolean delete(Object[][] data) {
        String query = "DELETE FROM ThongTinHocSinh WHERE maHS = ?";
        try (PreparedStatement ps = Connect.conn.prepareStatement(query)) {
            for (Object[] row : data) {
                ps.setString(1, (String) row[0]); // maHS
                ps.addBatch();
            }
            ps.executeBatch();
            return true;
        } catch (SQLException ex) {
            new DialogNotification("Xoá thất bại!", DialogNotification.ERROR_DIALOG);
        }
        return false;
    }
}