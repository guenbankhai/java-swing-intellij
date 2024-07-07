package project.BUS;

import project.DAO.MonHocDAO;
import project.DTO.MonHocDTO;
import project.GUI.DialogNotification;

import java.util.List;

public class MonHocBUS {
    private MonHocDAO result = new MonHocDAO();

    public List<MonHocDTO> getAllMonHoc() {return result.getAllMonHoc();}

    public Object[][] getAllData() {
        List<MonHocDTO> list = getAllMonHoc();
        Object[][] data = new Object[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            MonHocDTO var = list.get(i);
            data[i][0] = var.getMaMH();
            data[i][1] = var.getTenMH();
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