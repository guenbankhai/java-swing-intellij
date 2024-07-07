package project.DAO;

import project.DTO.LopDTO;
import project.GUI.DialogNotification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LopDAO {
    public List<LopDTO> getAllLop() {
        List<LopDTO> list = new ArrayList<>();
        String query = "SELECT * FROM Lop";

        try (PreparedStatement ps = Connect.conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                LopDTO lop = new LopDTO(
                        rs.getString("maLop"),
                        rs.getString("maKT"),
                        rs.getInt("namMoLop")
                );
                list.add(lop);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean delete(Object[][] data) {
        String query = "DELETE FROM Lop WHERE maLop = ?";
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