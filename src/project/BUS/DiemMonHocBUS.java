package project.BUS;

import project.DAO.DiemMonHocDAO;
import project.DTO.DiemMonHocDTO;
import project.GUI.DialogNotification;

import java.util.List;


public class DiemMonHocBUS {
    private DiemMonHocDAO result = new DiemMonHocDAO();

    public List<DiemMonHocDTO> getAllDiemMonHoc() {
        return result.getALlDiemMonHoc();
    }

    public List<DiemMonHocDTO> getDiemHocSinh(String maHS) {
        return result.getBangDiemHocSinh(maHS);
    }

    public List<DiemMonHocDTO> getDiemGiaoVien(String maGV) {
        return result.getBangDiemGiaoVien(maGV);
    }

    public Object[][]  getAllData() {
        DiemMonHocBUS control = new DiemMonHocBUS();
        List<DiemMonHocDTO> list = control.getAllDiemMonHoc();
        Object[][] data = new Object[list.size()][8];
        for (int i = 0; i < list.size(); i++) {
            DiemMonHocDTO var = list.get(i);
            data[i][0] = var.getMaHS();
            data[i][1] = var.getMaMH();
            data[i][2] = var.getNamHoc();
            data[i][3] = var.getHocKy();
            data[i][4] = var.getDiemHS1();
            data[i][5] = var.getDiemHS2();
            data[i][6] = var.getDiemHS3();
            data[i][7] = var.getDiemTB();
        }
        return data;
    }

    public Object[][]  getHocSinhData(String maHS) {
        DiemMonHocBUS control = new DiemMonHocBUS();
        List<DiemMonHocDTO> list = control.getDiemHocSinh(maHS);
        Object[][] data = new Object[list.size()][8];
        for (int i = 0; i < list.size(); i++) {
            DiemMonHocDTO var = list.get(i);
            data[i][0] = var.getMaHS();
            data[i][1] = var.getMaMH();
            data[i][2] = var.getNamHoc();
            data[i][3] = var.getHocKy();
            data[i][4] = var.getDiemHS1();
            data[i][5] = var.getDiemHS2();
            data[i][6] = var.getDiemHS3();
            data[i][7] = var.getDiemTB();
        }
        return data;
    }

    public Object[][]  getGiaoVienData(String maGV) {
        DiemMonHocBUS control = new DiemMonHocBUS();
        List<DiemMonHocDTO> list = control.getDiemGiaoVien(maGV);
        Object[][] data = new Object[list.size()][8];
        for (int i = 0; i < list.size(); i++) {
            DiemMonHocDTO var = list.get(i);
            data[i][0] = var.getMaHS();
            data[i][1] = var.getMaMH();
            data[i][2] = var.getNamHoc();
            data[i][3] = var.getHocKy();
            data[i][4] = var.getDiemHS1();
            data[i][5] = var.getDiemHS2();
            data[i][6] = var.getDiemHS3();
            data[i][7] = var.getDiemTB();
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

    public boolean add(DiemMonHocDTO data) {
        if(result.add(data)) {
            new DialogNotification("Xoá thành công!", DialogNotification.SUCCESS_DIALOG);
            return true;
        } else {
            return false;
        }
    }
}
