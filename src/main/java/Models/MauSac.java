package Models;

public class MauSac {
    private int maMau;

    private String tenMau;

    public MauSac() {
    }

    public MauSac(int maMau, String tenMau) {
        this.maMau = maMau;
        this.tenMau = tenMau;
    }

    public int getMaMau() {
        return maMau;
    }

    public void setMaMau(int maMau) {
        this.maMau = maMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }
}
