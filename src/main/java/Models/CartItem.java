package Models;

import java.math.BigDecimal;

public class CartItem {

    private int maSPCT;
    private int maSP;

    private String tenSanPham;
    private String mauSac;
    private String kichCo;

    private BigDecimal donGia;
    private int soLuong;

    public CartItem() {
    }

    public CartItem(int maSPCT,
                    int maSP,
                    String tenSanPham,
                    String mauSac,
                    String kichCo,
                    BigDecimal donGia,
                    int soLuong) {

        this.maSPCT = maSPCT;
        this.maSP = maSP;
        this.tenSanPham = tenSanPham;
        this.mauSac = mauSac;
        this.kichCo = kichCo;
        this.donGia = donGia;
        this.soLuong = soLuong;
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

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getThanhTien() {
        if (donGia == null) {
            return BigDecimal.ZERO;
        }
        return donGia.multiply(BigDecimal.valueOf(soLuong));
    }
}