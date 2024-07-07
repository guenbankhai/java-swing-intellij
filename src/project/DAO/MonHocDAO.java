package project.DAO;

import project.DTO.MonHocDTO;
import project.GUI.DialogNotification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonHocDAO {
    public List<MonHocDTO> getAllMonHoc() {
        List<MonHocDTO> list = new ArrayList<>();
        String query = "SELECT * FROM MonHoc";

        try (PreparedStatement ps = Connect.conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                MonHocDTO monHoc = new MonHocDTO(
                        rs.getString("maMH"),
                        rs.getString("tenMH")
                );
                list.add(monHoc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean delete(Object[][] data) {
        String query = "DELETE FROM MonHoc WHERE maMH = ?";
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