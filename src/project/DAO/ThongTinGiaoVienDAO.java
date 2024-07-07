package project.DAO;

import project.DTO.ThongTinGiaoVienDTO;
import project.GUI.DialogNotification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongTinGiaoVienDAO {
    public List<ThongTinGiaoVienDTO> getAllThongTinGiaoVien() {
        List<ThongTinGiaoVienDTO> list = new ArrayList<>();
        String query = "SELECT * FROM ThongTinGiaoVien";

        try (PreparedStatement ps = Connect.conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ThongTinGiaoVienDTO giaoVien = new ThongTinGiaoVienDTO(
                        rs.getString("maGV"),
                        rs.getString("hoTen"),
                        rs.getString("gioiTinh"),
                        rs.getDate("ngaySinh"),
                        rs.getString("noiSinh"),
                        rs.getString("SoDienThoai"),
                        rs.getString("maTCM")
                );
                list.add(giaoVien);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ThongTinGiaoVienDTO getThongTinGiaoVien(String maGV) {
        ThongTinGiaoVienDTO result = null;
        String query = "SELECT * FROM ThongTinGiaoVien WHERE maGV=?";

        try (PreparedStatement ps = Connect.conn.prepareStatement(query)) {
            ps.setString(1, maGV);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    result = new ThongTinGiaoVienDTO(
                            rs.getString("maGV"),
                            rs.getString("hoTen"),
                            rs.getString("gioiTinh"),
                            rs.getDate("ngaySinh"),
                            rs.getString("noiSinh"),
                            rs.getString("SoDienThoai"),
                            rs.getString("maTCM")
                    );
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public boolean delete(Object[][] data) {
        String query = "DELETE FROM ThongTinGiaoVien WHERE maGV = ?";
        try (PreparedStatement ps = Connect.conn.prepareStatement(query)) {
            for (Object[] row : data) {
                ps.setString(1, (String) row[0]); // maGV
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