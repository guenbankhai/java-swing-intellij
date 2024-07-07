package project.DAO;

import project.DTO.ToChuyenMonDTO;
import project.GUI.DialogNotification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToChuyenMonDAO {
    public List<ToChuyenMonDTO> getAllToChuyenMon() {
        List<ToChuyenMonDTO> list = new ArrayList<>();
        String query = "SELECT * FROM ToChuyenMon";

        try (PreparedStatement ps = Connect.conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ToChuyenMonDTO toChuyenMon = new ToChuyenMonDTO(
                        rs.getString("maTCM"),
                        rs.getString("tenTo"),
                        rs.getString("maMH1"),
                        rs.getString("maMH2"),
                        rs.getString("maMH3")
                );
                list.add(toChuyenMon);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean delete(Object[][] data) {
        String query = "DELETE FROM ToChuyenMon WHERE maTCM = ?";
        try (PreparedStatement ps = Connect.conn.prepareStatement(query)) {
            for (Object[] row : data) {
                ps.setString(1, (String) row[0]); // maTCM
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