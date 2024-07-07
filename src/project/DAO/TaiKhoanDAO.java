package project.DAO;

import project.DTO.TaiKhoanDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaiKhoanDAO {
    public TaiKhoanDTO DangNhap(TaiKhoanDTO taikhoan) {
        String query = "SELECT * FROM TaiKhoan WHERE tenDN =? AND matKhau=?";
        try {
            PreparedStatement ps = Connect.conn.prepareStatement(query);
            ps.setString(1, taikhoan.getTenDangNhap());
            ps.setString(2, taikhoan.getMatKhau());
            ResultSet rs = ps.executeQuery();
            TaiKhoanDTO result = null;
            if(rs.next()) {
                result = taikhoan;
                result.setVaiTro(rs.getString("vaiTro"));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taikhoan;
    }
}
