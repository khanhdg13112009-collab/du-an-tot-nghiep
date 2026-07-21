package Services;

import Models.HoaDonChiTiet;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class HoaDonChiTietService {

    ConnectService connect = new ConnectService();

    public boolean add(HoaDonChiTiet ct) {

        String sql =
                "INSERT INTO HoaDonChiTiet " +
                        "(MaHD, MaSPCT, SoLuong, DonGia, ThanhTien) " +
                        "VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, ct.getMaHD());
            ps.setInt(2, ct.getMaSPCT());
            ps.setInt(3, ct.getSoLuong());
            ps.setDouble(4, ct.getDonGia());
            ps.setDouble(5, ct.getThanhTien());

            boolean success = ps.executeUpdate() > 0;

            ps.close();
            conn.close();

            return success;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }

}