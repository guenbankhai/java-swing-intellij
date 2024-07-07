package project.BUS;

import project.DAO.ThongTinGiaoVienDAO;
import project.DTO.ThongTinGiaoVienDTO;
import project.GUI.DialogNotification;

import java.util.List;

public class ThongTinGiaoVienBUS {
    private ThongTinGiaoVienDAO result = new ThongTinGiaoVienDAO();

    public List<ThongTinGiaoVienDTO> getAllThongTinGiaoVien() {return result.getAllThongTinGiaoVien();}

    public ThongTinGiaoVienDTO getThongTinGiaoVien(String maGV) {return result.getThongTinGiaoVien(maGV);}

    public Object[][] getAllData() {
        List<ThongTinGiaoVienDTO> list = getAllThongTinGiaoVien();
        Object[][] data = new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            ThongTinGiaoVienDTO var = list.get(i);
            data[i][0] = var.getMaGV();
            data[i][1] = var.getHoTen();
            data[i][2] = var.getGioiTinh();
            data[i][3] = var.getNgaySinh();
            data[i][4] = var.getNoiSinh();
            data[i][5] = var.getSoDienThoai();
            data[i][6] = var.getMaTCM();
        }
        return data;
    }

    public Object[][] getData(String maGV) {
        ThongTinGiaoVienDTO info = getThongTinGiaoVien(maGV);
        if (info == null) {
            return new Object[0][7];
        }
        Object[][] data = new Object[1][7];
        data[0][0] = info.getMaGV();
        data[0][1] = info.getHoTen();
        data[0][2] = info.getGioiTinh();
        data[0][3] = info.getNgaySinh();
        data[0][4] = info.getNoiSinh();
        data[0][5] = info.getSoDienThoai();
        data[0][6] = info.getMaTCM();
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