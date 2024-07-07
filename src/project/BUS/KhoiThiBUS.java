package project.BUS;

import project.DAO.KhoiThiDAO;
import project.DTO.KhoiThiDTO;
import project.GUI.DialogNotification;

import java.util.List;

public class KhoiThiBUS {
    private KhoiThiDAO result = new KhoiThiDAO();

    public List<KhoiThiDTO> getAllKhoiThi() {return result.getAllKhoiThi();}

    public Object[][] getAllData() {
        List<KhoiThiDTO> list = getAllKhoiThi();
        Object[][] data = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            KhoiThiDTO var = list.get(i);
            data[i][0] = var.getMaKT();
            data[i][1] = var.getMaMH1();
            data[i][2] = var.getMaMH2();
            data[i][3] = var.getMaMH3();
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
