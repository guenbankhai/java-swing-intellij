package project.BUS;

import project.DAO.ToChuyenMonDAO;
import project.DTO.ToChuyenMonDTO;
import project.GUI.DialogNotification;

import java.util.List;

public class ToChuyenMonBUS {
    private ToChuyenMonDAO result = new ToChuyenMonDAO();

    public List<ToChuyenMonDTO> getAllToChuyenMon() {
        return result.getAllToChuyenMon();
    }

    public Object[][] getAllData() {
        List<ToChuyenMonDTO> list = getAllToChuyenMon();
        Object[][] data = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            ToChuyenMonDTO var = list.get(i);
            data[i][0] = var.getMaTCM();
            data[i][1] = var.getTenTo();
            data[i][2] = var.getMaMH1();
            data[i][3] = var.getMaMH2();
            data[i][4] = var.getMaMH3();
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
