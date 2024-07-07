package project.DTO;

import java.util.Date;

public class ThongTinHocSinhDTO {
    private String maHS;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String noiSinh;
    private String soDienThoai;
    private int namNhapHoc;
    private String maLop;

    public ThongTinHocSinhDTO(String maHS, String hoTen, String gioiTinh, Date ngaySinh, String noiSinh, String soDienThoai, int namNhapHoc, String maLop) {
        this.maHS = maHS;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.noiSinh = noiSinh;
        this.soDienThoai = soDienThoai;
        this.namNhapHoc = namNhapHoc;
        this.maLop = maLop;
    }

    public String getMaHS()  {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
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

    public int getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(int namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
}