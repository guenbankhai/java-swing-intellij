package project.DTO;

public class KhoiThiDTO {
    private String maKT;
    private String maMH1;
    private String maMH2;
    private String maMH3;

    public KhoiThiDTO(String maKT, String maMH1, String maMH2, String maMH3) {
        this.maKT = maKT;
        this.maMH1 = maMH1;
        this.maMH2 = maMH2;
        this.maMH3 = maMH3;
    }

    public String getMaKT() {
        return maKT;
    }

    public void setMaKT(String maKT) {
        this.maKT = maKT;
    }

    public String getMaMH1() {
        return maMH1;
    }

    public void setMaMH1(String maMH1) {
        this.maMH1 = maMH1;
    }

    public String getMaMH2() {
        return maMH2;
    }

    public void setMaMH2(String maMH2) {
        this.maMH2 = maMH2;
    }

    public String getMaMH3() {
        return maMH3;
    }

    public void setMaMH3(String maMH3) {
        this.maMH3 = maMH3;
    }
}
