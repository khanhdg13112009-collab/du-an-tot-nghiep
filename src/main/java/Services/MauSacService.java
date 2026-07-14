package Services;

import Models.MauSac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MauSacService {

    ConnectService connect = new ConnectService();

    //===================== LẤY DANH SÁCH =====================

    public ArrayList<MauSac> getAll() {

        ArrayList<MauSac> list = new ArrayList<>();

        String sql = "SELECT * FROM MauSac ORDER BY TenMau";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                MauSac ms = new MauSac();

                ms.setMaMau(rs.getInt("MaMau"));
                ms.setTenMau(rs.getString("TenMau"));

                list.add(ms);

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;

    }



    public MauSac getById(int id) {

        MauSac ms = null;

        String sql = "SELECT * FROM MauSac WHERE MaMau=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                ms = new MauSac();

                ms.setMaMau(rs.getInt("MaMau"));
                ms.setTenMau(rs.getString("TenMau"));

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return ms;

    }


    public void addMauSac(MauSac ms) {

        String sql = "INSERT INTO MauSac(TenMau) VALUES(?)";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ms.getTenMau());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }



    public void updateMauSac(MauSac ms) {

        String sql = "UPDATE MauSac SET TenMau=? WHERE MaMau=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ms.getTenMau());
            ps.setInt(2, ms.getMaMau());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    public void deleteMauSac(int id) {

        String sql = "DELETE FROM MauSac WHERE MaMau=?";

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