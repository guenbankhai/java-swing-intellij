package project.DTO;

public class DiemMonHocDTO {
    private String maHS;
    private String maMH;
    private String namHoc;
    private String hocKy;
    private float diemHS1;
    private float diemHS2;
    private float diemHS3;
    private float diemTB;

    public DiemMonHocDTO(String maHS, String maMH, String namHoc, String hocKy, float diemHS1, float diemHS2, float diemHS3, float diemTB) {
        this.maHS = maHS;
        this.maMH = maMH;
        this.namHoc = namHoc;
        this.hocKy = hocKy;
        this.diemHS1 = diemHS1;
        this.diemHS2 = diemHS2;
        this.diemHS3 = diemHS3;
        this.diemTB = diemTB;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public float getDiemHS1() {
        return diemHS1;
    }

    public void setDiemHS1(float diemHS1) {
        this.diemHS1 = diemHS1;
    }

    public float getDiemHS2() {
        return diemHS2;
    }

    public void setDiemHS2(float diemHS2) {
        this.diemHS2 = diemHS2;
    }

    public float getDiemHS3() {
        return diemHS3;
    }

    public void setDiemHS3(float diemHS3) {
        this.diemHS3 = diemHS3;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }
}