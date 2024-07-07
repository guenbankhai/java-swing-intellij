package project.BUS;

import project.DAO.NamHocDAO;
import project.DTO.NamHocDTO;
import project.GUI.DialogNotification;

import java.util.List;

public class NamHocBUS {
    private NamHocDAO result = new NamHocDAO();

    public List<NamHocDTO> getAllNamHoc() {return result.getAllNamHoc();}

    public Object[][] getAllData() {
        List<NamHocDTO> list = getAllNamHoc();
        Object[][] data = new Object[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            NamHocDTO var = list.get(i);
            data[i][0] = var.getNamBatDau();
            data[i][1] = var.getNamKetThuc();
            data[i][2] = var.getNamHoc();
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