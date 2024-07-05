package project.DAO;

import project.DTO.DiemMonHocDTO;

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
}
