package project.DAO;

import project.DTO.KhoiThiDTO;
import project.GUI.DialogNotification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhoiThiDAO {
    public List<KhoiThiDTO> getAllKhoiThi() {
        List<KhoiThiDTO> list = new ArrayList<>();
        String query = "SELECT * FROM KhoiThi";

        try (PreparedStatement ps = Connect.conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                KhoiThiDTO khoiThi = new KhoiThiDTO(
                        rs.getString("maKT"),
                        rs.getString("maMH1"),
                        rs.getString("maMH2"),
                        rs.getString("maMH3")
                );
                list.add(khoiThi);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean delete(Object[][] data) {
        String query = "DELETE FROM KhoiThi WHERE maKT = ?";
        try (PreparedStatement ps = Connect.conn.prepareStatement(query)) {
            for (Object[] row : data) {
                ps.setString(1, (String) row[0]);
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
