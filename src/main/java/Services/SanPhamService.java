package Services;

import Models.SanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SanPhamService {

    ConnectService connect = new ConnectService();


    public ArrayList<SanPham> getAll() {

        ArrayList<SanPham> list = new ArrayList<>();

        String sql =
                "SELECT " +
                        "sp.MaSP, " +
                        "sp.TenSP, " +
                        "sp.ThuongHieu, " +
                        "sp.ChatLieu, " +
                        "sp.MoTa, " +
                        "sp.TrangThai, " +
                        "ms.TenMau, " +
                        "kc.TenSize, " +
                        "spct.Gia, " +
                        "spct.SoLuong " +
                        "FROM SanPham sp " +
                        "INNER JOIN SanPhamChiTiet spct ON sp.MaSP = spct.MaSP " +
                        "INNER JOIN MauSac ms ON spct.MaMau = ms.MaMau " +
                        "INNER JOIN KichCo kc ON spct.MaSize = kc.MaSize " +
                        "ORDER BY sp.MaSP";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                SanPham sp = new SanPham();

                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setThuongHieu(rs.getString("ThuongHieu"));
                sp.setChatLieu(rs.getString("ChatLieu"));
                sp.setMoTa(rs.getString("MoTa"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));

                sp.setTenMau(rs.getString("TenMau"));
                sp.setTenSize(rs.getString("TenSize"));
                sp.setGia(rs.getDouble("Gia"));
                sp.setSoLuong(rs.getInt("SoLuong"));

                list.add(sp);

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;

    }


    public SanPham getById(int id) {

        SanPham sp = null;

        String sql =
                "SELECT * FROM SanPham WHERE MaSP=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                sp = new SanPham();

                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setThuongHieu(rs.getString("ThuongHieu"));
                sp.setChatLieu(rs.getString("ChatLieu"));
                sp.setMoTa(rs.getString("MoTa"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return sp;

    }

    public void addSanPham(SanPham sp) {

        String sql =
                "INSERT INTO SanPham(TenSP,ThuongHieu,ChatLieu,MoTa,TrangThai) " +
                        "VALUES(?,?,?,?,?)";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, sp.getTenSP());
            ps.setString(2, sp.getThuongHieu());
            ps.setString(3, sp.getChatLieu());
            ps.setString(4, sp.getMoTa());
            ps.setBoolean(5, sp.isTrangThai());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void updateSanPham(SanPham sp) {

        String sql =
                "UPDATE SanPham " +
                        "SET TenSP=?,ThuongHieu=?,ChatLieu=?,MoTa=?,TrangThai=? " +
                        "WHERE MaSP=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, sp.getTenSP());
            ps.setString(2, sp.getThuongHieu());
            ps.setString(3, sp.getChatLieu());
            ps.setString(4, sp.getMoTa());
            ps.setBoolean(5, sp.isTrangThai());
            ps.setInt(6, sp.getMaSP());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void deleteSanPham(int id) {

        String sql = "DELETE FROM SanPham WHERE MaSP=?";

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
