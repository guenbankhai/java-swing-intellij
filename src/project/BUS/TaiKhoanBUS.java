package project.BUS;

import project.DAO.TaiKhoanDAO;
import project.DTO.TaiKhoanDTO;
import project.GUI.DialogNotification;

public class TaiKhoanBUS {
    public static TaiKhoanDTO taiKhoan = null;

    public TaiKhoanDTO DangNhap(String tenDN, String matKhau) {
        TaiKhoanDTO variable = new TaiKhoanDTO();
        variable.setTenDangNhap(tenDN);
        variable.setMatKhau(matKhau);

        TaiKhoanDAO dangnhap = new TaiKhoanDAO();
        TaiKhoanDTO result = dangnhap.DangNhap(variable);
        taiKhoan = result;

        if (result == null) {
            new DialogNotification("Sai thông tin đăng nhập!", DialogNotification.ERROR_DIALOG);
        } else {
            new DialogNotification("Đăng nhập thành công!", DialogNotification.SUCCESS_DIALOG);
        }
        return result;
    }
}
