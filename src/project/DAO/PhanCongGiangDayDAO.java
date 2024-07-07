package project.DAO;

import project.DTO.PhanCongGiangDayDTO;
import project.GUI.DialogNotification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhanCongGiangDayDAO {
    public List<PhanCongGiangDayDTO> getAllPhanCongGiangDay() {
        List<PhanCongGiangDayDTO> list = new ArrayList<>();
        String query = "SELECT * FROM PhanCongGiangDay";

        try (PreparedStatement ps = Connect.conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                PhanCongGiangDayDTO phanCong = new PhanCongGiangDayDTO(
                        rs.getString("maLop"),
                        rs.getString("maMH"),
                        rs.getString("namHoc"),
                        rs.getString("maGV")
                );
                list.add(phanCong);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean delete(Object[][] data) {
        String query = "DELETE FROM PhanCongGiangDay WHERE maLop = ? AND maMH = ? AND namHoc = ?";
        try (PreparedStatement ps = Connect.conn.prepareStatement(query)) {
            for (Object[] row : data) {
                ps.setString(1, (String) row[0]); // maLop
                ps.setString(2, (String) row[1]); // maMH
                ps.setString(3, (String) row[2]); // namHoc
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