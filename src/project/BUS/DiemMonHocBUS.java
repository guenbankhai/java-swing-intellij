package project.BUS;

import project.DAO.DiemMonHocDAO;
import project.DTO.DiemMonHocDTO;
import project.GUI.FrameMain;

import java.awt.*;
import java.util.List;


public class DiemMonHocBUS {
    private DiemMonHocDAO result = new DiemMonHocDAO();

    public List<DiemMonHocDTO> getAllDiemMonHoc() {
        return result.getALlDiemMonHoc();
    }

}
