package Models;

import java.math.BigDecimal;

public class ThongKe {

    private BigDecimal doanhThu;
    private int soHoaDon;
    private int soSanPham;
    private int soKhachHang;

    public ThongKe() {
    }

    public ThongKe(BigDecimal doanhThu,
                   int soHoaDon,
                   int soSanPham,
                   int soKhachHang) {

        this.doanhThu = doanhThu;
        this.soHoaDon = soHoaDon;
        this.soSanPham = soSanPham;
        this.soKhachHang = soKhachHang;
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

    public int getSoKhachHang() {
        return soKhachHang;
    }

    public void setSoKhachHang(int soKhachHang) {
        this.soKhachHang = soKhachHang;
    }
}