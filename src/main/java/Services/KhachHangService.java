package Services;

import Models.KhachHang;

import java.sql.*;
import java.util.ArrayList;

public class KhachHangService {

    ConnectService connect = new ConnectService();

    public ArrayList<KhachHang> getAll() {

        ArrayList<KhachHang> list = new ArrayList<>();

        String sql = "SELECT * FROM KhachHang";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                KhachHang kh = new KhachHang();

                kh.setMaKH(rs.getInt("MaKH"));
                kh.setHoTen(rs.getString("HoTen"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));

                list.add(kh);

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;

    }

    public KhachHang getById(int id) {

        KhachHang kh = null;

        String sql = "SELECT * FROM KhachHang WHERE MaKH=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                kh = new KhachHang();

                kh.setMaKH(rs.getInt("MaKH"));
                kh.setHoTen(rs.getString("HoTen"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return kh;

    }
    public void addKhachHang(KhachHang kh) {

        String sql = "INSERT INTO KhachHang(HoTen,SoDienThoai,Email,DiaChi) VALUES(?,?,?,?)";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, kh.getHoTen());
            ps.setString(2, kh.getSoDienThoai());
            ps.setString(3, kh.getEmail());
            ps.setString(4, kh.getDiaChi());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void updateKhachHang(KhachHang kh) {

        String sql = "UPDATE KhachHang SET HoTen=?, SoDienThoai=?, Email=?, DiaChi=? WHERE MaKH=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, kh.getHoTen());
            ps.setString(2, kh.getSoDienThoai());
            ps.setString(3, kh.getEmail());
            ps.setString(4, kh.getDiaChi());
            ps.setInt(5, kh.getMaKH());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void deleteKhachHang(int id) {

        String sql = "DELETE FROM KhachHang WHERE MaKH=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}