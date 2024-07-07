package project.BUS;

import project.DAO.PhanCongGiangDayDAO;
import project.DTO.PhanCongGiangDayDTO;
import project.GUI.DialogNotification;

import java.util.List;

public class PhanCongGiangDayBUS {
    private PhanCongGiangDayDAO result = new PhanCongGiangDayDAO();

    public List<PhanCongGiangDayDTO> getAllPhanCongGiangDay() {return result.getAllPhanCongGiangDay();}

    public Object[][] getAllData() {
        List<PhanCongGiangDayDTO> list = getAllPhanCongGiangDay();
        Object[][] data = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            PhanCongGiangDayDTO var = list.get(i);
            data[i][0] = var.getMaLop();
            data[i][1] = var.getMaMH();
            data[i][2] = var.getNamHoc();
            data[i][3] = var.getMaGV();
        }
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