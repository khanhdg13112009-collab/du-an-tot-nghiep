package Services;

import Models.ThongKe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThongKeService {

    public ThongKe thongKeTheoNgay(String ngay) {

        ThongKe tk = new ThongKe();

        String sql =
                "SELECT " +
                        "ISNULL((SELECT SUM(hd.TongTien) " +
                        "        FROM HoaDon hd " +
                        "        WHERE CAST(hd.NgayDat AS DATE)=?), 0) AS DoanhThu, " +

                        "(SELECT COUNT(*) " +
                        " FROM HoaDon hd " +
                        " WHERE CAST(hd.NgayDat AS DATE)=?) AS SoHoaDon, " +

                        "ISNULL((SELECT SUM(ct.SoLuong) " +
                        "        FROM HoaDon hd " +
                        "        INNER JOIN HoaDonChiTiet ct ON hd.MaHD = ct.MaHD " +
                        "        WHERE CAST(hd.NgayDat AS DATE)=?), 0) AS SoSanPham, " +

                        "(SELECT COUNT(DISTINCT hd.MaKH) " +
                        " FROM HoaDon hd " +
                        " WHERE CAST(hd.NgayDat AS DATE)=?) AS SoKhachHang";

        try (Connection con = new ConnectService().myConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ngay);
            ps.setString(2, ngay);
            ps.setString(3, ngay);
            ps.setString(4, ngay);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                tk.setDoanhThu(rs.getBigDecimal("DoanhThu"));
                tk.setSoHoaDon(rs.getInt("SoHoaDon"));
                tk.setSoSanPham(rs.getInt("SoSanPham"));
                tk.setSoKhachHang(rs.getInt("SoKhachHang"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tk;
    }

    public ThongKe thongKeTheoThang(int thang, int nam) {

        ThongKe tk = new ThongKe();

        String sql =
                "SELECT " +

                        "ISNULL((SELECT SUM(hd.TongTien) " +
                        "        FROM HoaDon hd " +
                        "        WHERE MONTH(hd.NgayDat)=? " +
                        "        AND YEAR(hd.NgayDat)=?), 0) AS DoanhThu, " +

                        "(SELECT COUNT(*) " +
                        " FROM HoaDon hd " +
                        " WHERE MONTH(hd.NgayDat)=? " +
                        " AND YEAR(hd.NgayDat)=?) AS SoHoaDon, " +

                        "ISNULL((SELECT SUM(ct.SoLuong) " +
                        "        FROM HoaDon hd " +
                        "        INNER JOIN HoaDonChiTiet ct ON hd.MaHD = ct.MaHD " +
                        "        WHERE MONTH(hd.NgayDat)=? " +
                        "        AND YEAR(hd.NgayDat)=?), 0) AS SoSanPham, " +

                        "(SELECT COUNT(DISTINCT hd.MaKH) " +
                        " FROM HoaDon hd " +
                        " WHERE MONTH(hd.NgayDat)=? " +
                        " AND YEAR(hd.NgayDat)=?) AS SoKhachHang";

        try (Connection con = new ConnectService().myConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, thang);
            ps.setInt(2, nam);

            ps.setInt(3, thang);
            ps.setInt(4, nam);

            ps.setInt(5, thang);
            ps.setInt(6, nam);

            ps.setInt(7, thang);
            ps.setInt(8, nam);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                tk.setDoanhThu(rs.getBigDecimal("DoanhThu"));
                tk.setSoHoaDon(rs.getInt("SoHoaDon"));
                tk.setSoSanPham(rs.getInt("SoSanPham"));
                tk.setSoKhachHang(rs.getInt("SoKhachHang"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tk;
    }

    public ThongKe thongKeTheoNam(int nam) {

        ThongKe tk = new ThongKe();

        String sql =
                "SELECT " +

                        "ISNULL((SELECT SUM(hd.TongTien) " +
                        "        FROM HoaDon hd " +
                        "        WHERE YEAR(hd.NgayDat)=?), 0) AS DoanhThu, " +

                        "(SELECT COUNT(*) " +
                        " FROM HoaDon hd " +
                        " WHERE YEAR(hd.NgayDat)=?) AS SoHoaDon, " +

                        "ISNULL((SELECT SUM(ct.SoLuong) " +
                        "        FROM HoaDon hd " +
                        "        INNER JOIN HoaDonChiTiet ct ON hd.MaHD = ct.MaHD " +
                        "        WHERE YEAR(hd.NgayDat)=?), 0) AS SoSanPham, " +

                        "(SELECT COUNT(DISTINCT hd.MaKH) " +
                        " FROM HoaDon hd " +
                        " WHERE YEAR(hd.NgayDat)=?) AS SoKhachHang";

        try (Connection con = new ConnectService().myConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, nam);
            ps.setInt(2, nam);
            ps.setInt(3, nam);
            ps.setInt(4, nam);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                tk.setDoanhThu(rs.getBigDecimal("DoanhThu"));
                tk.setSoHoaDon(rs.getInt("SoHoaDon"));
                tk.setSoSanPham(rs.getInt("SoSanPham"));
                tk.setSoKhachHang(rs.getInt("SoKhachHang"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tk;
    }
    public double[] getDoanhThu12Thang(int nam) {

        double[] data = new double[12];

        String sql =
                "SELECT MONTH(NgayDat) AS Thang, " +
                        "SUM(TongTien) AS DoanhThu " +
                        "FROM HoaDon " +
                        "WHERE YEAR(NgayDat)=? " +
                        "GROUP BY MONTH(NgayDat)";

        try (Connection con = new ConnectService().myConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, nam);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int thang = rs.getInt("Thang");

                data[thang - 1] =
                        rs.getDouble("DoanhThu");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return data;
    }
}