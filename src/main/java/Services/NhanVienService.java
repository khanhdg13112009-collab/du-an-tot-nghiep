package Services;

import Models.NhanVien;

import java.sql.*;
import java.util.ArrayList;

public class NhanVienService {

    ConnectService connect = new ConnectService();

    // Lấy toàn bộ nhân viên
    public ArrayList<NhanVien> getAllNhanVien() {

        ArrayList<NhanVien> list = new ArrayList<>();

        String sql = "SELECT * FROM NhanVien";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                NhanVien nv = new NhanVien();

                nv.setMaNV(rs.getInt("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setSoDienThoai(rs.getString("SoDienThoai"));
                nv.setEmail(rs.getString("Email"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setTrangThaiID(rs.getInt("TrangThaiID"));

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

    // Lấy thông tin nhân viên theo mã
    public NhanVien getNhanVienById(int maNV) {

        NhanVien nv = null;

        String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, maNV);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                nv = new NhanVien();

                nv.setMaNV(rs.getInt("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setSoDienThoai(rs.getString("SoDienThoai"));
                nv.setEmail(rs.getString("Email"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setTrangThaiID(rs.getInt("TrangThaiID"));
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nv;
    }
}