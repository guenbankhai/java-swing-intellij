package project.DTO;

import java.util.Date;

public class ThongTinGiaoVienDTO {
    private String maGV;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String noiSinh;
    private String soDienThoai;
    private String maTCM;

    public ThongTinGiaoVienDTO(String maGV, String hoTen, String gioiTinh, Date ngaySinh, String noiSinh, String soDienThoai, String maTCM) {
        this.maGV = maGV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.noiSinh = noiSinh;
        this.soDienThoai = soDienThoai;
        this.maTCM = maTCM;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMaTCM() {
        return maTCM;
    }

    public void setMaTCM(String maTCM) {
        this.maTCM = maTCM;
    }
}