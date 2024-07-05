package project.DTO;

public class NamHocDTO {
    private int namBatDau;
    private int namKetThuc;
    private String namHoc;

    public NamHocDTO(int namBatDau, int namKetThuc, String namHoc) {
        this.namBatDau = namBatDau;
        this.namKetThuc = namKetThuc;
        this.namHoc = namHoc;
    }

    public int getNamBatDau() {
        return namBatDau;
    }

    public void setNamBatDau(int namBatDau) {
        this.namBatDau = namBatDau;
    }

    public int getNamKetThuc() {
        return namKetThuc;
    }

    public void setNamKetThuc(int namKetThuc) {
        this.namKetThuc = namKetThuc;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }
}