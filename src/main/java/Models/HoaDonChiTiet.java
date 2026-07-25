package Models;

import java.math.BigDecimal;

public class HoaDonChiTiet {

    private int maHDCT;
    private int maHD;
    private int maSPCT;
    private int soLuong;
    private BigDecimal donGia;
    private BigDecimal thanhTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int maHDCT, int maHD, int maSPCT,
                         int soLuong, BigDecimal donGia, BigDecimal thanhTien) {
        this.maHDCT = maHDCT;
        this.maHD = maHD;
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public int getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(int maHDCT) {
        this.maHDCT = maHDCT;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(int maSPCT) {
        this.maSPCT = maSPCT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }
}