package project.BUS;

import project.DAO.LopDAO;
import project.DTO.LopDTO;
import project.GUI.DialogNotification;

import java.util.List;

public class LopBUS {
    private LopDAO result = new LopDAO();

    public List<LopDTO> getAllLop() {return result.getAllLop();}

    public Object[][] getAllData() {
        List<LopDTO> list = getAllLop();
        Object[][] data = new Object[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            LopDTO var = list.get(i);
            data[i][0] = var.getMaLop();
            data[i][1] = var.getMaKT();
            data[i][2] = var.getNamMoLop();
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