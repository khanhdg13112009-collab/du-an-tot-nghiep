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
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setSoDienThoai(rs.getString("SoDienThoai"));
                nv.setEmail(rs.getString("Email"));
                nv.setCoSo(rs.getString("CoSo"));
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
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setSoDienThoai(rs.getString("SoDienThoai"));
                nv.setEmail(rs.getString("Email"));
                nv.setCoSo(rs.getString("CoSo"));
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
                        "HoTen,CCCD,NgaySinh,GioiTinh," +
                        "SoDienThoai,Email,CoSo,DiaChi," +
                        "TrangThaiID,AnhCCCDTruoc,AnhCCCDSau) " +
                        "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nv.getHoTen());
            ps.setString(2, nv.getCccd());
            ps.setDate(3, nv.getNgaySinh());
            ps.setBoolean(4, nv.isGioiTinh());
            ps.setString(5, nv.getSoDienThoai());
            ps.setString(6, nv.getEmail());
            ps.setString(7, nv.getCoSo());
            ps.setString(8, nv.getDiaChi());
            ps.setInt(9, nv.getTrangThaiID());
            ps.setString(10, nv.getAnhCCCDTruoc());
            ps.setString(11, nv.getAnhCCCDSau());

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
                        "NgaySinh=?," +
                        "GioiTinh=?," +
                        "SoDienThoai=?," +
                        "Email=?," +
                        "CoSo=?," +
                        "DiaChi=?," +
                        "TrangThaiID=?," +
                        "AnhCCCDTruoc=?," +
                        "AnhCCCDSau=? " +
                        "WHERE MaNV=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nv.getHoTen());
            ps.setString(2, nv.getCccd());
            ps.setDate(3, nv.getNgaySinh());
            ps.setBoolean(4, nv.isGioiTinh());
            ps.setString(5, nv.getSoDienThoai());
            ps.setString(6, nv.getEmail());
            ps.setString(7, nv.getCoSo());
            ps.setString(8, nv.getDiaChi());
            ps.setInt(9, nv.getTrangThaiID());
            ps.setString(10, nv.getAnhCCCDTruoc());
            ps.setString(11, nv.getAnhCCCDSau());
            ps.setInt(12, nv.getMaNV());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}