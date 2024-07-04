package project.DTO;

public class PhanCongGiangDayDTO {
    private String maLop;
    private String maMH;
    private String namHoc;
    private String maGV;

    public PhanCongGiangDayDTO(String maLop, String maMH, String namHoc, String maGV) {
        this.maLop = maLop;
        this.maMH = maMH;
        this.namHoc = namHoc;
        this.maGV = maGV;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
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

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }
}