package Services;

import Models.SanPhamChiTiet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SanPhamChiTietService {

    ConnectService connect = new ConnectService();

    public ArrayList<SanPhamChiTiet> getAll() {

        ArrayList<SanPhamChiTiet> list = new ArrayList<>();

        String sql =
                "SELECT " +
                        "spct.MaSPCT," +
                        "spct.MaSP," +
                        "spct.MaMau," +
                        "spct.MaSize," +
                        "spct.Gia," +
                        "spct.SoLuong," +
                        "sp.TenSP," +
                        "ms.TenMau," +
                        "kc.TenSize " +
                        "FROM SanPhamChiTiet spct " +
                        "INNER JOIN SanPham sp ON spct.MaSP = sp.MaSP " +
                        "INNER JOIN MauSac ms ON spct.MaMau = ms.MaMau " +
                        "INNER JOIN KichCo kc ON spct.MaSize = kc.MaSize " +
                        "WHERE sp.TrangThai = 1";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                SanPhamChiTiet spct = new SanPhamChiTiet();

                spct.setMaSPCT(rs.getInt("MaSPCT"));
                spct.setMaSP(rs.getInt("MaSP"));
                spct.setMaMau(rs.getInt("MaMau"));
                spct.setMaSize(rs.getInt("MaSize"));
                spct.setGia(rs.getDouble("Gia"));
                spct.setSoLuong(rs.getInt("SoLuong"));

                spct.setTenSP(rs.getString("TenSP"));
                spct.setTenMau(rs.getString("TenMau"));
                spct.setTenSize(rs.getString("TenSize"));

                list.add(spct);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public SanPhamChiTiet getById(int id) {

        SanPhamChiTiet spct = null;

        String sql =
                "SELECT * FROM SanPhamChiTiet WHERE MaSPCT=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                spct = new SanPhamChiTiet();

                spct.setMaSPCT(rs.getInt("MaSPCT"));
                spct.setMaSP(rs.getInt("MaSP"));
                spct.setMaMau(rs.getInt("MaMau"));
                spct.setMaSize(rs.getInt("MaSize"));
                spct.setGia(rs.getDouble("Gia"));
                spct.setSoLuong(rs.getInt("SoLuong"));

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return spct;

    }

    public SanPhamChiTiet getByMaSPCT(int maSPCT) {

        SanPhamChiTiet spct = null;

        String sql =
                "SELECT " +
                        "spct.MaSPCT," +
                        "spct.MaSP," +
                        "spct.MaMau," +
                        "spct.MaSize," +
                        "spct.Gia," +
                        "spct.SoLuong," +
                        "sp.TenSP," +
                        "ms.TenMau," +
                        "kc.TenSize " +
                        "FROM SanPhamChiTiet spct " +
                        "INNER JOIN SanPham sp ON spct.MaSP = sp.MaSP " +
                        "INNER JOIN MauSac ms ON spct.MaMau = ms.MaMau " +
                        "INNER JOIN KichCo kc ON spct.MaSize = kc.MaSize " +
                        "WHERE spct.MaSPCT=? " +
                        "AND sp.TrangThai = 1";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, maSPCT);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                spct = new SanPhamChiTiet();

                spct.setMaSPCT(rs.getInt("MaSPCT"));
                spct.setMaSP(rs.getInt("MaSP"));
                spct.setMaMau(rs.getInt("MaMau"));
                spct.setMaSize(rs.getInt("MaSize"));
                spct.setGia(rs.getDouble("Gia"));
                spct.setSoLuong(rs.getInt("SoLuong"));

                spct.setTenSP(rs.getString("TenSP"));
                spct.setTenMau(rs.getString("TenMau"));
                spct.setTenSize(rs.getString("TenSize"));

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return spct;

    }

    public boolean addSanPhamChiTiet(SanPhamChiTiet spct) {

        if (spct.getGia() < 0) {
            return false;
        }

        if (spct.getSoLuong() < 0) {
            return false;
        }

        String sql =
                "INSERT INTO SanPhamChiTiet(MaSP,MaMau,MaSize,Gia,SoLuong) VALUES(?,?,?,?,?)";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, spct.getMaSP());
            ps.setInt(2, spct.getMaMau());
            ps.setInt(3, spct.getMaSize());
            ps.setDouble(4, spct.getGia());
            ps.setInt(5, spct.getSoLuong());

            boolean success = ps.executeUpdate() > 0;

            ps.close();
            conn.close();

            return success;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }

    public boolean updateSanPhamChiTiet(SanPhamChiTiet spct) {

        if (spct.getGia() < 0) {
            return false;
        }

        if (spct.getSoLuong() < 0) {
            return false;
        }

        String sql =
                "UPDATE SanPhamChiTiet SET MaSP=?,MaMau=?,MaSize=?,Gia=?,SoLuong=? WHERE MaSPCT=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, spct.getMaSP());
            ps.setInt(2, spct.getMaMau());
            ps.setInt(3, spct.getMaSize());
            ps.setDouble(4, spct.getGia());
            ps.setInt(5, spct.getSoLuong());
            ps.setInt(6, spct.getMaSPCT());

            boolean success = ps.executeUpdate() > 0;

            ps.close();
            conn.close();

            return success;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }



    public ArrayList<SanPhamChiTiet> getBySanPham(int maSP) {

        ArrayList<SanPhamChiTiet> list = new ArrayList<>();

        String sql =
                "SELECT " +
                        "spct.MaSPCT," +
                        "spct.MaSP," +
                        "spct.MaMau," +
                        "spct.MaSize," +
                        "spct.Gia," +
                        "spct.SoLuong," +
                        "sp.TenSP," +
                        "ms.TenMau," +
                        "kc.TenSize " +
                        "FROM SanPhamChiTiet spct " +
                        "INNER JOIN SanPham sp ON spct.MaSP = sp.MaSP " +
                        "INNER JOIN MauSac ms ON spct.MaMau = ms.MaMau " +
                        "INNER JOIN KichCo kc ON spct.MaSize = kc.MaSize " +
                        "WHERE spct.MaSP = ?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, maSP);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                SanPhamChiTiet spct = new SanPhamChiTiet();

                spct.setMaSPCT(rs.getInt("MaSPCT"));
                spct.setMaSP(rs.getInt("MaSP"));
                spct.setMaMau(rs.getInt("MaMau"));
                spct.setMaSize(rs.getInt("MaSize"));
                spct.setGia(rs.getDouble("Gia"));
                spct.setSoLuong(rs.getInt("SoLuong"));

                spct.setTenSP(rs.getString("TenSP"));
                spct.setTenMau(rs.getString("TenMau"));
                spct.setTenSize(rs.getString("TenSize"));

                list.add(spct);

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;

    }

    public boolean giamSoLuong(int maSPCT, int soLuong) {

        if (soLuong <= 0) {
            return false;
        }

        String sql =
                "UPDATE SanPhamChiTiet " +
                        "SET SoLuong = SoLuong - ? " +
                        "WHERE MaSPCT = ? " +
                        "AND SoLuong >= ?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, soLuong);
            ps.setInt(2, maSPCT);
            ps.setInt(3, soLuong);

            boolean success = ps.executeUpdate() > 0;

            ps.close();
            conn.close();

            return success;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }

    public ArrayList<SanPhamChiTiet> search(String keyword) {

        ArrayList<SanPhamChiTiet> list = new ArrayList<>();

        String sql =
                "SELECT " +
                        "spct.MaSPCT," +
                        "spct.MaSP," +
                        "spct.MaMau," +
                        "spct.MaSize," +
                        "spct.Gia," +
                        "spct.SoLuong," +
                        "sp.TenSP," +
                        "ms.TenMau," +
                        "kc.TenSize " +
                        "FROM SanPhamChiTiet spct " +
                        "INNER JOIN SanPham sp ON spct.MaSP = sp.MaSP " +
                        "INNER JOIN MauSac ms ON spct.MaMau = ms.MaMau " +
                        "INNER JOIN KichCo kc ON spct.MaSize = kc.MaSize " +
                        "WHERE sp.TrangThai = 1 " +
                        "AND (sp.TenSP LIKE ? " +
                        "OR CAST(spct.MaSP AS VARCHAR) LIKE ?)";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                SanPhamChiTiet spct = new SanPhamChiTiet();

                spct.setMaSPCT(rs.getInt("MaSPCT"));
                spct.setMaSP(rs.getInt("MaSP"));
                spct.setMaMau(rs.getInt("MaMau"));
                spct.setMaSize(rs.getInt("MaSize"));
                spct.setGia(rs.getDouble("Gia"));
                spct.setSoLuong(rs.getInt("SoLuong"));

                spct.setTenSP(rs.getString("TenSP"));
                spct.setTenMau(rs.getString("TenMau"));
                spct.setTenSize(rs.getString("TenSize"));

                list.add(spct);
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