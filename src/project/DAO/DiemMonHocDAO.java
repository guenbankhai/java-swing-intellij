package project.DAO;

import project.DTO.DiemMonHocDTO;
import project.GUI.DialogNotification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiemMonHocDAO {
    public List<DiemMonHocDTO> getALlDiemMonHoc() {
        List<DiemMonHocDTO> list = new ArrayList<>();
        String query = "SELECT * FROM DiemMonHoc";

        try (PreparedStatement ps = Connect.conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DiemMonHocDTO diemMonHoc = new DiemMonHocDTO(
                        rs.getString("maHS"),
                        rs.getString("maMH"),
                        rs.getString("namHoc"),
                        rs.getString("hocKy"),
                        rs.getFloat("diemHS1"),
                        rs.getFloat("diemHS2"),
                        rs.getFloat("diemHS3"),
                        rs.getFloat("diemTB")
                );
                list.add(diemMonHoc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<DiemMonHocDTO> getBangDiemHocSinh(String maHS) {
        List<DiemMonHocDTO> list = new ArrayList<>();
        String query = "SELECT * FROM DiemMonHoc WHERE maHS=?";

        try  {
            PreparedStatement ps = Connect.conn.prepareStatement(query);
            ps.setString(1, maHS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DiemMonHocDTO diemMonHoc = new DiemMonHocDTO(
                        rs.getString("maHS"),
                        rs.getString("maMH"),
                        rs.getString("namHoc"),
                        rs.getString("hocKy"),
                        rs.getFloat("diemHS1"),
                        rs.getFloat("diemHS2"),
                        rs.getFloat("diemHS3"),
                        rs.getFloat("diemTB")
                );
                list.add(diemMonHoc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<DiemMonHocDTO> getBangDiemGiaoVien(String maGV) {
        List<DiemMonHocDTO> list = new ArrayList<>();
        String query = "SELECT d.maHS, d.maMH, d.namHoc, d.hocKy, d.diemHS1, d.diemHS2, d.diemHS3, d.diemTB " +
                "FROM DiemMonHoc d " +
                "JOIN ThongTinHocSinh h ON d.maHS = h.maHS " +
                "JOIN Lop l ON h.maLop = l.maLop " +
                "JOIN PhanCongGiangDay p ON l.maLop = p.maLop " +
                "WHERE p.maGV = ?";

        try  {
            PreparedStatement ps = Connect.conn.prepareStatement(query);
            ps.setString(1, maGV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DiemMonHocDTO diemMonHoc = new DiemMonHocDTO(
                        rs.getString("maHS"),
                        rs.getString("maMH"),
                        rs.getString("namHoc"),
                        rs.getString("hocKy"),
                        rs.getFloat("diemHS1"),
                        rs.getFloat("diemHS2"),
                        rs.getFloat("diemHS3"),
                        rs.getFloat("diemTB")
                );
                list.add(diemMonHoc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean delete(Object[][] data) {
        String query = "DELETE FROM DiemMonHoc WHERE maHS = ? AND maMH = ? AND namHoc = ? AND hocKy = ?";
        try (PreparedStatement ps = Connect.conn.prepareStatement(query)) {
            for (Object[] row : data) {
                ps.setString(1, (String) row[0]);
                ps.setString(2, (String) row[1]);
                ps.setString(3, (String) row[2]);
                ps.setString(4, (String) row[3]);
                ps.addBatch();
            }
            ps.executeBatch();
            return true;
        } catch (SQLException ex) {
            new DialogNotification("Xoá thất bại!", DialogNotification.ERROR_DIALOG);
        }
        return false;
    }

    public boolean add(DiemMonHocDTO diemMonHoc) {
        String query = "INSERT INTO DiemMonHoc (maHS, maMH, namHoc, hocKy, diemHS1, diemHS2, diemHS3, diemTB) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = Connect.conn.prepareStatement(query)) {
            ps.setString(1, diemMonHoc.getMaHS());
            ps.setString(2, diemMonHoc.getMaMH());
            ps.setString(3, diemMonHoc.getNamHoc());
            ps.setString(4, diemMonHoc.getHocKy());
            ps.setFloat(5, diemMonHoc.getDiemHS1());
            ps.setFloat(6, diemMonHoc.getDiemHS2());
            ps.setFloat(7, diemMonHoc.getDiemHS3());
            ps.setFloat(8, diemMonHoc.getDiemTB());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException ex) {
            new DialogNotification("Thêm dữ liệu thất bại!", DialogNotification.ERROR_DIALOG);
            ex.printStackTrace();
        }
        return false;
    }
}
