package Services;

import Models.HoaDon;
import Models.HoaDonChiTiet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonService {

    ConnectService connectService = new ConnectService();

    public int addHoaDon(HoaDon hd) {

        String sql =
                "INSERT INTO HoaDon(MaKH, MaNV, TongTien, TrangThai, GhiChu) " +
                        "VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = connectService.myConnection();
                PreparedStatement ps = conn.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS)
        ) {

            ps.setInt(1, hd.getMaKH());
            ps.setInt(2, hd.getMaNV());
            ps.setBigDecimal(3, hd.getTongTien());
            ps.setString(4, hd.getTrangThai());
            ps.setString(5, hd.getGhiChu());

            int row = ps.executeUpdate();

            if (row > 0) {

                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    return rs.getInt(1);
                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return -1;
    }

    public List<HoaDon> getAllHoaDon() {

        List<HoaDon> list = new ArrayList<>();

        String sql =
                "SELECT * FROM HoaDon ORDER BY NgayDat DESC";

        try (
                Connection conn = connectService.myConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                HoaDon hd = new HoaDon();

                hd.setMaHD(rs.getInt("MaHD"));
                hd.setMaKH(rs.getInt("MaKH"));
                hd.setMaNV(rs.getInt("MaNV"));
                hd.setNgayDat(rs.getTimestamp("NgayDat"));
                hd.setTongTien(rs.getBigDecimal("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));
                hd.setGhiChu(rs.getString("GhiChu"));

                list.add(hd);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;
    }

    public HoaDon getHoaDonById(int maHD) {

        String sql =
                "SELECT * FROM HoaDon WHERE MaHD=?";

        try (
                Connection conn = connectService.myConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, maHD);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                HoaDon hd = new HoaDon();

                hd.setMaHD(rs.getInt("MaHD"));
                hd.setMaKH(rs.getInt("MaKH"));
                hd.setMaNV(rs.getInt("MaNV"));
                hd.setNgayDat(rs.getTimestamp("NgayDat"));
                hd.setTongTien(rs.getBigDecimal("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));
                hd.setGhiChu(rs.getString("GhiChu"));

                return hd;

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }

    public List<HoaDonChiTiet> getChiTietHoaDon(int maHD) {

        List<HoaDonChiTiet> list = new ArrayList<>();

        String sql =
                "SELECT * FROM HoaDonChiTiet WHERE MaHD=?";

        try (
                Connection conn = connectService.myConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, maHD);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                HoaDonChiTiet ct = new HoaDonChiTiet();

                ct.setMaHDCT(rs.getInt("MaHDCT"));
                ct.setMaHD(rs.getInt("MaHD"));
                ct.setMaSPCT(rs.getInt("MaSPCT"));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setDonGia(rs.getBigDecimal("DonGia"));
                ct.setThanhTien(rs.getBigDecimal("ThanhTien"));

                list.add(ct);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;
    }

    public boolean updateTrangThai(int maHD, String trangThai) {

        String sql =
                "UPDATE HoaDon SET TrangThai=? WHERE MaHD=?";

        try (
                Connection conn = connectService.myConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, trangThai);
            ps.setInt(2, maHD);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }

    public boolean deleteHoaDon(int maHD) {

        String sql =
                "DELETE FROM HoaDon WHERE MaHD=?";

        try (
                Connection conn = connectService.myConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, maHD);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }

}