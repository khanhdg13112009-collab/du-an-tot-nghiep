package Models;

import java.sql.Date;

public class NhanVien {

    private int maNV;
    private String hoTen;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private int trangThaiID;

    public NhanVien() {
    }

    public NhanVien(int maNV, String hoTen, Date ngaySinh, boolean gioiTinh,
                    String soDienThoai, String email, String diaChi, int trangThaiID) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.trangThaiID = trangThaiID;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTrangThaiID() {
        return trangThaiID;
    }

    public void setTrangThaiID(int trangThaiID) {
        this.trangThaiID = trangThaiID;
    }
}