package Services;

import Models.ThongKe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThongKeService {

    // Thống kê theo ngày
    public ThongKe thongKeTheoNgay(String ngay) {

        ThongKe tk = new ThongKe();

        String sql = "SELECT "
                + "ISNULL(SUM(hd.TongTien),0) AS DoanhThu, "
                + "COUNT(DISTINCT hd.MaHD) AS SoHoaDon, "
                + "ISNULL(SUM(ct.SoLuong),0) AS SoSanPham "
                + "FROM HoaDon hd "
                + "LEFT JOIN HoaDonChiTiet ct ON hd.MaHD = ct.MaHD "
                + "WHERE CAST(hd.NgayDat AS DATE)=?";

        try (Connection con = new ConnectService().myConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ngay);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tk.setDoanhThu(rs.getBigDecimal("DoanhThu"));
                tk.setSoHoaDon(rs.getInt("SoHoaDon"));
                tk.setSoSanPham(rs.getInt("SoSanPham"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tk;
    }

    // Thống kê theo tháng
    public ThongKe thongKeTheoThang(int thang, int nam) {

        ThongKe tk = new ThongKe();

        String sql = "SELECT "
                + "ISNULL(SUM(hd.TongTien),0) AS DoanhThu, "
                + "COUNT(DISTINCT hd.MaHD) AS SoHoaDon, "
                + "ISNULL(SUM(ct.SoLuong),0) AS SoSanPham "
                + "FROM HoaDon hd "
                + "LEFT JOIN HoaDonChiTiet ct ON hd.MaHD = ct.MaHD "
                + "WHERE MONTH(hd.NgayDat)=? "
                + "AND YEAR(hd.NgayDat)=?";

        try (Connection con = new ConnectService().myConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, thang);
            ps.setInt(2, nam);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tk.setDoanhThu(rs.getBigDecimal("DoanhThu"));
                tk.setSoHoaDon(rs.getInt("SoHoaDon"));
                tk.setSoSanPham(rs.getInt("SoSanPham"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tk;
    }

    // Thống kê theo năm
    public ThongKe thongKeTheoNam(int nam) {

        ThongKe tk = new ThongKe();

        String sql = "SELECT "
                + "ISNULL(SUM(hd.TongTien),0) AS DoanhThu, "
                + "COUNT(DISTINCT hd.MaHD) AS SoHoaDon, "
                + "ISNULL(SUM(ct.SoLuong),0) AS SoSanPham "
                + "FROM HoaDon hd "
                + "LEFT JOIN HoaDonChiTiet ct ON hd.MaHD = ct.MaHD "
                + "WHERE YEAR(hd.NgayDat)=?";

        try (Connection con = new ConnectService().myConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, nam);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tk.setDoanhThu(rs.getBigDecimal("DoanhThu"));
                tk.setSoHoaDon(rs.getInt("SoHoaDon"));
                tk.setSoSanPham(rs.getInt("SoSanPham"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tk;
    }
}