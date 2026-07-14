package Services;

import Models.KichCo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KichCoService {

    ConnectService connect = new ConnectService();


    public ArrayList<KichCo> getAll() {

        ArrayList<KichCo> list = new ArrayList<>();

        String sql = "SELECT * FROM KichCo ORDER BY TenSize";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                KichCo kc = new KichCo();

                kc.setMaSize(rs.getInt("MaSize"));
                kc.setTenSize(rs.getString("TenSize"));

                list.add(kc);

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;

    }


    public KichCo getById(int id) {

        KichCo kc = null;

        String sql = "SELECT * FROM KichCo WHERE MaSize=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                kc = new KichCo();

                kc.setMaSize(rs.getInt("MaSize"));
                kc.setTenSize(rs.getString("TenSize"));

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return kc;

    }


    public void addKichCo(KichCo kc) {

        String sql = "INSERT INTO KichCo(TenSize) VALUES(?)";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, kc.getTenSize());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void updateKichCo(KichCo kc) {

        String sql = "UPDATE KichCo SET TenSize=? WHERE MaSize=?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, kc.getTenSize());
            ps.setInt(2, kc.getMaSize());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    public void deleteKichCo(int id) {

        String sql = "DELETE FROM KichCo WHERE MaSize=?";

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
