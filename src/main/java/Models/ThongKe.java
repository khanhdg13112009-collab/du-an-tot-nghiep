package Models;

import java.math.BigDecimal;

public class ThongKe {

    private BigDecimal doanhThu;
    private int soHoaDon;
    private int soSanPham;

    public ThongKe() {
    }

    public ThongKe(BigDecimal doanhThu, int soHoaDon, int soSanPham) {
        this.doanhThu = doanhThu;
        this.soHoaDon = soHoaDon;
        this.soSanPham = soSanPham;
    }

    public BigDecimal getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(BigDecimal doanhThu) {
        this.doanhThu = doanhThu;
    }

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public int getSoSanPham() {
        return soSanPham;
    }

    public void setSoSanPham(int soSanPham) {
        this.soSanPham = soSanPham;
    }
}