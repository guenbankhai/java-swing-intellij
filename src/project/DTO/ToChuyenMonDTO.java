package project.DTO;

public class ToChuyenMonDTO {
    private String maTCM;
    private String tenTo;
    private String maMH1;
    private String maMH2;
    private String maMH3;

    public ToChuyenMonDTO(String maTCM, String tenTo, String maMH1, String maMH2, String maMH3) {
        this.maTCM = maTCM;
        this.tenTo = tenTo;
        this.maMH1 = maMH1;
        this.maMH2 = maMH2;
        this.maMH3 = maMH3;
    }

    public String getMaTCM() {
        return maTCM;
    }

    public void setMaTCM(String maTCM) {
        this.maTCM = maTCM;
    }

    public String getTenTo() {
        return tenTo;
    }

    public void setTenTo(String tenTo) {
        this.tenTo = tenTo;
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
