package Models;

import java.sql.Date;

public class NhanVien {

    private int maNV;
    private String hoTen;
    private String cccd;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String soDienThoai;
    private String email;
    private String coSo;

    private String diaChi;

    private String tinhThanhPho;
    private String quanHuyen;
    private String phuongXa;
    private String diaChiChiTiet;


    private Date ngayCapCCCD;
    private String noiCapCCCD;

    private int trangThaiID;


    private String tenTrangThai;
    private int roleID;
    private String anhCCCDTruoc;
    private String anhCCCDSau;

    public NhanVien() {
    }

    public NhanVien(int maNV,
                    String hoTen,
                    String cccd,
                    Date ngaySinh,
                    boolean gioiTinh,
                    String soDienThoai,
                    String email,
                    String coSo,
                    String diaChi,
                    String tinhThanhPho,
                    String quanHuyen,
                    String phuongXa,
                    String diaChiChiTiet,
                    Date ngayCapCCCD,
                    String noiCapCCCD,
                    int trangThaiID,
                    String tenTrangThai,
                    int roleID,
                    String anhCCCDTruoc,
                    String anhCCCDSau) {

        this.maNV = maNV;
        this.hoTen = hoTen;
        this.cccd = cccd;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.coSo = coSo;

        this.diaChi = diaChi;

        this.tinhThanhPho = tinhThanhPho;
        this.quanHuyen = quanHuyen;
        this.phuongXa = phuongXa;
        this.diaChiChiTiet = diaChiChiTiet;

        this.ngayCapCCCD = ngayCapCCCD;
        this.noiCapCCCD = noiCapCCCD;

        this.trangThaiID = trangThaiID;
        this.tenTrangThai = tenTrangThai;
        this.roleID = roleID;
        this.anhCCCDTruoc = anhCCCDTruoc;
        this.anhCCCDSau = anhCCCDSau;
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

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
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

    public String getCoSo() {
        return coSo;
    }

    public void setCoSo(String coSo) {
        this.coSo = coSo;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTinhThanhPho() {
        return tinhThanhPho;
    }

    public void setTinhThanhPho(String tinhThanhPho) {
        this.tinhThanhPho = tinhThanhPho;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getPhuongXa() {
        return phuongXa;
    }

    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }

    public String getDiaChiChiTiet() {
        return diaChiChiTiet;
    }

    public void setDiaChiChiTiet(String diaChiChiTiet) {
        this.diaChiChiTiet = diaChiChiTiet;
    }

    public Date getNgayCapCCCD() {
        return ngayCapCCCD;
    }

    public void setNgayCapCCCD(Date ngayCapCCCD) {
        this.ngayCapCCCD = ngayCapCCCD;
    }

    public String getNoiCapCCCD() {
        return noiCapCCCD;
    }

    public void setNoiCapCCCD(String noiCapCCCD) {
        this.noiCapCCCD = noiCapCCCD;
    }

    public int getTrangThaiID() {
        return trangThaiID;
    }

    public void setTrangThaiID(int trangThaiID) {
        this.trangThaiID = trangThaiID;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getAnhCCCDTruoc() {
        return anhCCCDTruoc;
    }

    public void setAnhCCCDTruoc(String anhCCCDTruoc) {
        this.anhCCCDTruoc = anhCCCDTruoc;
    }

    public String getAnhCCCDSau() {
        return anhCCCDSau;
    }

    public void setAnhCCCDSau(String anhCCCDSau) {
        this.anhCCCDSau = anhCCCDSau;
    }
}