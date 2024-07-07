package project.DAO;

import project.DTO.NamHocDTO;
import project.GUI.DialogNotification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NamHocDAO {
    public List<NamHocDTO> getAllNamHoc() {
        List<NamHocDTO> list = new ArrayList<>();
        String query = "SELECT * FROM NamHoc";

        try (PreparedStatement ps = Connect.conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                NamHocDTO namHoc = new NamHocDTO(
                        rs.getInt("namBatDau"),
                        rs.getInt("namKetThuc"),
                        rs.getString("namHoc")
                );
                list.add(namHoc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean delete(Object[][] data) {
        String query = "DELETE FROM NamHoc WHERE namHoc = ?";
        try (PreparedStatement ps = Connect.conn.prepareStatement(query)) {
            for (Object[] row : data) {
                ps.setString(1, (String) row[2]);
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