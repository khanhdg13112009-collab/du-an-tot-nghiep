package Services;

import Models.HoaDon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HoaDonService {

    ConnectService connect = new ConnectService();

    public int addHoaDon(HoaDon hd) {

        String sql =
                "INSERT INTO HoaDon " +
                        "(MaKH, NgayDat, TongTien, TrangThai) " +
                        "OUTPUT INSERTED.MaHD " +
                        "VALUES (?, GETDATE(), ?, ?)";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, hd.getMaKH());
            ps.setDouble(2, hd.getTongTien());
            ps.setString(3, hd.getTrangThai());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int maHD = rs.getInt(1);

                rs.close();
                ps.close();
                conn.close();

                return maHD;
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return -1;
    }

    public HoaDon getById(int maHD) {

        String sql = "SELECT * FROM HoaDon WHERE MaHD = ?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, maHD);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                HoaDon hd = new HoaDon();

                hd.setMaHD(rs.getInt("MaHD"));
                hd.setMaKH(rs.getInt("MaKH"));
                hd.setNgayDat(rs.getTimestamp("NgayDat"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));

                rs.close();
                ps.close();
                conn.close();

                return hd;
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }

    public ArrayList<HoaDon> getAll() {

        ArrayList<HoaDon> list = new ArrayList<>();

        String sql = "SELECT * FROM HoaDon ORDER BY NgayDat DESC";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                HoaDon hd = new HoaDon();

                hd.setMaHD(rs.getInt("MaHD"));
                hd.setMaKH(rs.getInt("MaKH"));
                hd.setNgayDat(rs.getTimestamp("NgayDat"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));

                list.add(hd);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;
    }
}