package Models;

public class SanPhamChiTiet {
    private int maSPCT;

    private int maSP;

    private int maMau;

    private int maSize;

    private double gia;

    private int soLuong;

    private String tenSP;

    private String tenMau;

    private String tenSize;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(int maSPCT,
                          int maSP,
                          int maMau,
                          int maSize,
                          double gia,
                          int soLuong,
                          String tenSP,
                          String tenMau,
                          String tenSize) {

        this.maSPCT = maSPCT;
        this.maSP = maSP;
        this.maMau = maMau;
        this.maSize = maSize;
        this.gia = gia;
        this.soLuong = soLuong;
        this.tenSP = tenSP;
        this.tenMau = tenMau;
        this.tenSize = tenSize;
    }

    public int getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(int maSPCT) {
        this.maSPCT = maSPCT;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getMaMau() {
        return maMau;
    }

    public void setMaMau(int maMau) {
        this.maMau = maMau;
    }

    public int getMaSize() {
        return maSize;
    }

    public void setMaSize(int maSize) {
        this.maSize = maSize;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }
}
