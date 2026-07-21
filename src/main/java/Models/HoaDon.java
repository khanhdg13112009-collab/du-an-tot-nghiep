package Models;

import java.util.Date;

public class HoaDon {

    private int maHD;
    private int maKH;
    private Date ngayDat;
    private double tongTien;
    private String trangThai;

    public HoaDon() {
    }

    public HoaDon(int maHD, int maKH, Date ngayDat, double tongTien, String trangThai) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}