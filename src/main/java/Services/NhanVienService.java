package Services;

import Models.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NhanVienService {

    ConnectService connect = new ConnectService();

    public ArrayList<NhanVien> getAllNhanVien() {

        ArrayList<NhanVien> list = new ArrayList<>();

        String sql =
                "SELECT nv.*, tt.TenTrangThai, a.RoleID " +
                        "FROM NhanVien nv " +
                        "INNER JOIN TrangThaiNV tt ON nv.TrangThaiID = tt.TrangThaiID " +
                        "INNER JOIN Account a ON nv.MaNV = a.MaNV " +
                        "ORDER BY nv.MaNV";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                NhanVien nv = new NhanVien();

                nv.setMaNV(rs.getInt("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));

                nv.setCccd(rs.getString("CCCD"));
                nv.setNgayCapCCCD(rs.getDate("NgayCapCCCD"));
                nv.setNgayHetHanCCCD(rs.getDate("NgayHetHanCCCD"));
                nv.setNoiCapCCCD(rs.getString("NoiCapCCCD"));

                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));

                nv.setSoDienThoai(rs.getString("SoDienThoai"));
                nv.setEmail(rs.getString("Email"));

                nv.setCoSo(rs.getString("CoSo"));

                nv.setTinhThanhPho(rs.getString("TinhThanhPho"));
                nv.setQuanHuyen(rs.getString("QuanHuyen"));
                nv.setPhuongXa(rs.getString("PhuongXa"));
                nv.setDiaChiChiTiet(rs.getString("DiaChiChiTiet"));

                nv.setDiaChi(rs.getString("DiaChi"));

                nv.setTrangThaiID(rs.getInt("TrangThaiID"));

                nv.setTenTrangThai(rs.getString("TenTrangThai"));
                nv.setRoleID(rs.getInt("RoleID"));

                nv.setAnhCCCDTruoc(rs.getString("AnhCCCDTruoc"));
                nv.setAnhCCCDSau(rs.getString("AnhCCCDSau"));

                list.add(nv);

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;

    }
    public NhanVien getNhanVienById(int maNV) {

        NhanVien nv = null;

        String sql =
                "SELECT nv.*, tt.TenTrangThai, a.RoleID " +
                        "FROM NhanVien nv " +
                        "INNER JOIN TrangThaiNV tt " +
                        "ON nv.TrangThaiID = tt.TrangThaiID " +
                        "INNER JOIN Account a " +
                        "ON nv.MaNV = a.MaNV " +
                        "WHERE nv.MaNV=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, maNV);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                nv = new NhanVien();

                nv.setMaNV(rs.getInt("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));

                nv.setCccd(rs.getString("CCCD"));
                nv.setNgayCapCCCD(rs.getDate("NgayCapCCCD"));
                nv.setNgayHetHanCCCD(rs.getDate("NgayHetHanCCCD"));
                nv.setNoiCapCCCD(rs.getString("NoiCapCCCD"));

                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));

                nv.setSoDienThoai(rs.getString("SoDienThoai"));
                nv.setEmail(rs.getString("Email"));

                nv.setCoSo(rs.getString("CoSo"));

                nv.setTinhThanhPho(rs.getString("TinhThanhPho"));
                nv.setQuanHuyen(rs.getString("QuanHuyen"));
                nv.setPhuongXa(rs.getString("PhuongXa"));
                nv.setDiaChiChiTiet(rs.getString("DiaChiChiTiet"));

                nv.setDiaChi(rs.getString("DiaChi"));

                nv.setTrangThaiID(rs.getInt("TrangThaiID"));

                nv.setTenTrangThai(rs.getString("TenTrangThai"));
                nv.setRoleID(rs.getInt("RoleID"));

                nv.setAnhCCCDTruoc(rs.getString("AnhCCCDTruoc"));
                nv.setAnhCCCDSau(rs.getString("AnhCCCDSau"));

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return nv;
    }

    public void addNhanVien(NhanVien nv) {

        String sql =
                "INSERT INTO NhanVien(" +
                        "HoTen," +
                        "CCCD," +
                        "NgayCapCCCD," +
                        "NgayHetHanCCCD," +
                        "NoiCapCCCD," +
                        "NgaySinh," +
                        "GioiTinh," +
                        "SoDienThoai," +
                        "Email," +
                        "CoSo," +
                        "TinhThanhPho," +
                        "QuanHuyen," +
                        "PhuongXa," +
                        "DiaChiChiTiet," +
                        "TrangThaiID," +
                        "AnhCCCDTruoc," +
                        "AnhCCCDSau" +
                        ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nv.getHoTen());
            ps.setString(2, nv.getCccd());
            ps.setDate(3, nv.getNgayCapCCCD());
            ps.setDate(4, nv.getNgayHetHanCCCD());
            ps.setString(5, nv.getNoiCapCCCD());
            ps.setDate(6, nv.getNgaySinh());
            ps.setBoolean(7, nv.isGioiTinh());
            ps.setString(8, nv.getSoDienThoai());
            ps.setString(9, nv.getEmail());
            ps.setString(10, nv.getCoSo());

            ps.setString(11, nv.getTinhThanhPho());
            ps.setString(12, nv.getQuanHuyen());
            ps.setString(13, nv.getPhuongXa());
            ps.setString(14, nv.getDiaChiChiTiet());

            ps.setInt(15, nv.getTrangThaiID());

            ps.setString(16, nv.getAnhCCCDTruoc());
            ps.setString(17, nv.getAnhCCCDSau());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    public void updateNhanVien(NhanVien nv) {

        String sql =
                "UPDATE NhanVien SET " +
                        "HoTen=?," +
                        "CCCD=?," +
                        "NgayCapCCCD=?," +
                        "NgayHetHanCCCD=?," +
                        "NoiCapCCCD=?," +
                        "NgaySinh=?," +
                        "GioiTinh=?," +
                        "SoDienThoai=?," +
                        "Email=?," +
                        "CoSo=?," +
                        "TinhThanhPho=?," +
                        "QuanHuyen=?," +
                        "PhuongXa=?," +
                        "DiaChiChiTiet=?," +
                        "TrangThaiID=?," +
                        "AnhCCCDTruoc=?," +
                        "AnhCCCDSau=? " +
                        "WHERE MaNV=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nv.getHoTen());
            ps.setString(2, nv.getCccd());
            ps.setDate(3, nv.getNgayCapCCCD());
            ps.setDate(4, nv.getNgayHetHanCCCD());
            ps.setString(5, nv.getNoiCapCCCD());
            ps.setDate(6, nv.getNgaySinh());
            ps.setBoolean(7, nv.isGioiTinh());
            ps.setString(8, nv.getSoDienThoai());
            ps.setString(9, nv.getEmail());
            ps.setString(10, nv.getCoSo());

            ps.setString(11, nv.getTinhThanhPho());
            ps.setString(12, nv.getQuanHuyen());
            ps.setString(13, nv.getPhuongXa());
            ps.setString(14, nv.getDiaChiChiTiet());

            ps.setInt(15, nv.getTrangThaiID());

            ps.setString(16, nv.getAnhCCCDTruoc());
            ps.setString(17, nv.getAnhCCCDSau());

            ps.setInt(18, nv.getMaNV());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public boolean isExistCCCD(String cccd) {

        String sql = "SELECT 1 FROM NhanVien WHERE CCCD=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cccd);

            ResultSet rs = ps.executeQuery();

            boolean exists = rs.next();

            rs.close();
            ps.close();
            conn.close();

            return exists;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }

    public boolean isExistPhone(String phone) {

        String sql = "SELECT 1 FROM NhanVien WHERE SoDienThoai=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, phone);

            ResultSet rs = ps.executeQuery();

            boolean exists = rs.next();

            rs.close();
            ps.close();
            conn.close();

            return exists;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }

    public boolean isExistEmail(String email) {

        String sql = "SELECT 1 FROM NhanVien WHERE Email=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            boolean exists = rs.next();

            rs.close();
            ps.close();
            conn.close();

            return exists;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }
}
