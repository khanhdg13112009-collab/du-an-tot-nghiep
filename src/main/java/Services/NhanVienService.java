package Services;

import Models.Account;
import Models.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public boolean addNhanVien(
            NhanVien nv,
            String username,
            String password) {

        String sqlNhanVien =
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
                        "DiaChi," +
                        "TrangThaiID," +
                        "AnhCCCDTruoc," +
                        "AnhCCCDSau" +
                        ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String sqlAccount =
                "INSERT INTO Account(Username,Password,RoleID,MaNV,MaKH) " +
                        "VALUES(?,?,?,?,NULL)";

        Connection conn = null;

        try {

            conn = connect.myConnection();

            conn.setAutoCommit(false);

            // =========================
            // THÊM NHÂN VIÊN
            // =========================

            PreparedStatement psNV =
                    conn.prepareStatement(
                            sqlNhanVien,
                            java.sql.Statement.RETURN_GENERATED_KEYS
                    );

            psNV.setString(1, nv.getHoTen());

            psNV.setString(2, nv.getCccd());

            psNV.setDate(3, nv.getNgayCapCCCD());

            psNV.setDate(4, nv.getNgayHetHanCCCD());

            psNV.setString(5, nv.getNoiCapCCCD());

            psNV.setDate(6, nv.getNgaySinh());

            psNV.setBoolean(7, nv.isGioiTinh());

            psNV.setString(8, nv.getSoDienThoai());

            psNV.setString(9, nv.getEmail());

            psNV.setString(10, nv.getCoSo());

            psNV.setString(11, nv.getTinhThanhPho());

            psNV.setString(12, nv.getQuanHuyen());

            psNV.setString(13, nv.getPhuongXa());

            psNV.setString(14, nv.getDiaChiChiTiet());

            // DiaChi bắt buộc NOT NULL
            psNV.setString(
                    15,
                    nv.getDiaChi()
            );

            psNV.setInt(
                    16,
                    nv.getTrangThaiID()
            );

            psNV.setString(
                    17,
                    nv.getAnhCCCDTruoc()
            );

            psNV.setString(
                    18,
                    nv.getAnhCCCDSau()
            );

            psNV.executeUpdate();

            // =========================
            // LẤY MaNV
            // =========================

            ResultSet keys =
                    psNV.getGeneratedKeys();

            int maNV;

            if (keys.next()) {

                maNV = keys.getInt(1);

            } else {

                throw new SQLException(
                        "Không lấy được MaNV vừa tạo."
                );
            }

            // =========================
            // TẠO ACCOUNT
            // =========================

            PreparedStatement psAccount =
                    conn.prepareStatement(sqlAccount);

            psAccount.setString(
                    1,
                    username
            );

            psAccount.setString(
                    2,
                    password
            );

            // 2 = Nhân viên
            psAccount.setInt(3, 2);

            psAccount.setInt(
                    4,
                    maNV
            );

            psAccount.executeUpdate();

            // =========================
            // HOÀN TẤT
            // =========================

            conn.commit();

            psAccount.close();
            keys.close();
            psNV.close();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            try {

                if (conn != null) {
                    conn.rollback();
                }

            } catch (Exception ex) {

                ex.printStackTrace();
            }

            return false;
        }
    }

    public boolean updateNhanVien(
            NhanVien nv,
            String username,
            String password) {

        String sqlNhanVien =
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

        String sqlAccount =
                "UPDATE Account SET " +
                        "Username=?," +
                        "Password=? " +
                        "WHERE MaNV=?";

        Connection conn = null;

        try {

            conn = connect.myConnection();

            conn.setAutoCommit(false);

            // =========================
            // CẬP NHẬT NHÂN VIÊN
            // =========================

            PreparedStatement psNV =
                    conn.prepareStatement(sqlNhanVien);

            psNV.setString(1, nv.getHoTen());
            psNV.setString(2, nv.getCccd());
            psNV.setDate(3, nv.getNgayCapCCCD());
            psNV.setDate(4, nv.getNgayHetHanCCCD());
            psNV.setString(5, nv.getNoiCapCCCD());
            psNV.setDate(6, nv.getNgaySinh());
            psNV.setBoolean(7, nv.isGioiTinh());
            psNV.setString(8, nv.getSoDienThoai());
            psNV.setString(9, nv.getEmail());
            psNV.setString(10, nv.getCoSo());

            psNV.setString(11, nv.getTinhThanhPho());
            psNV.setString(12, nv.getQuanHuyen());
            psNV.setString(13, nv.getPhuongXa());
            psNV.setString(14, nv.getDiaChiChiTiet());

            psNV.setInt(15, nv.getTrangThaiID());

            psNV.setString(16, nv.getAnhCCCDTruoc());
            psNV.setString(17, nv.getAnhCCCDSau());

            psNV.setInt(18, nv.getMaNV());

            psNV.executeUpdate();

            // =========================
            // CẬP NHẬT ACCOUNT
            // =========================

            PreparedStatement psAccount =
                    conn.prepareStatement(sqlAccount);

            psAccount.setString(1, username);
            psAccount.setString(2, password);
            psAccount.setInt(3, nv.getMaNV());

            psAccount.executeUpdate();

            // =========================
            // HOÀN TẤT
            // =========================

            conn.commit();

            psAccount.close();
            psNV.close();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            try {

                if (conn != null) {
                    conn.rollback();
                }

            } catch (Exception ex) {

                ex.printStackTrace();
            }

            return false;
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

    public Account getAccountByMaNV(int maNV) {

        String sql =
                "SELECT AccountID, Username, Password, RoleID, MaNV, MaKH " +
                        "FROM Account " +
                        "WHERE MaNV = ?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, maNV);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Account account = new Account();

                account.setAccountID(
                        rs.getInt("AccountID")
                );

                account.setUsername(
                        rs.getString("Username")
                );

                account.setPassword(
                        rs.getString("Password")
                );

                account.setRoleID(
                        rs.getInt("RoleID")
                );

                account.setMaNV(
                        rs.getInt("MaNV")
                );

                int maKH = rs.getInt("MaKH");

                if (!rs.wasNull()) {
                    account.setMaKH(maKH);
                }

                return account;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

}
