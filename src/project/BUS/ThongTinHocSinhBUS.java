package project.BUS;

import project.DAO.ThongTinHocSinhDAO;
import project.DTO.ThongTinHocSinhDTO;
import project.GUI.DialogNotification;

import java.util.List;

public class ThongTinHocSinhBUS {
    private ThongTinHocSinhDAO result = new ThongTinHocSinhDAO();

    public List<ThongTinHocSinhDTO> getAllThongTinHocSinh() {return result.getAllThongTinHocSinh();}

    public ThongTinHocSinhDTO getThongTinHocSinh(String maHS) {return result.getThongTinHocSinh(maHS);}

    public Object[][] getAllData() {
        List<ThongTinHocSinhDTO> list = getAllThongTinHocSinh();
        Object[][] data = new Object[list.size()][8];
        for (int i = 0; i < list.size(); i++) {
            ThongTinHocSinhDTO var = list.get(i);
            data[i][0] = var.getMaHS();
            data[i][1] = var.getHoTen();
            data[i][2] = var.getGioiTinh();
            data[i][3] = var.getNgaySinh();
            data[i][4] = var.getNoiSinh();
            data[i][5] = var.getSoDienThoai();
            data[i][6] = var.getNamNhapHoc();
            data[i][7] = var.getMaLop();
        }
        return data;
    }

    public Object[][] getData(String maHS) {
        ThongTinHocSinhDTO info = getThongTinHocSinh(maHS);
        if (info == null) {
            return new Object[0][8];
        }
        Object[][] data = new Object[1][8];
        data[0][0] = info.getMaHS();
        data[0][1] = info.getHoTen();
        data[0][2] = info.getGioiTinh();
        data[0][3] = info.getNgaySinh();
        data[0][4] = info.getNoiSinh();
        data[0][5] = info.getSoDienThoai();
        data[0][6] = info.getNamNhapHoc();
        data[0][7] = info.getMaLop();
        return data;
    }

    public boolean delete(Object[][] data) {
        if(result.delete(data)) {
            new DialogNotification("Xoá thành công!", DialogNotification.SUCCESS_DIALOG);
            return true;
        } else {
            return false;
        }
    }
}
