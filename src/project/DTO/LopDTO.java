package project.DTO;

public class LopDTO {
    private String maLop;
    private String maKT;
    private int namMoLop;

    public LopDTO(String maLop, String maKT, int namMoLop) {
        this.maLop = maLop;
        this.maKT = maKT;
        this.namMoLop = namMoLop;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaKT() {
        return maKT;
    }

    public void setMaKT(String maKT) {
        this.maKT = maKT;
    }

    public int getNamMoLop() {
        return namMoLop;
    }

    public void setNamMoLop(int namMoLop) {
        this.namMoLop = namMoLop;
    }
}