package Services;

import Models.Account;

import java.sql.*;
import java.sql.Types;

public class AccountService {

    ConnectService connect = new ConnectService();

    public Account login(String username, String password) {

        Account account = null;

        String sql = "SELECT * FROM Account WHERE Username = ? AND Password = ?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                account = new Account();

                account.setAccountID(rs.getInt("AccountID"));
                account.setUsername(rs.getString("Username"));
                account.setPassword(rs.getString("Password"));
                account.setRoleID(rs.getInt("RoleID"));
                account.setMaNV(rs.getInt("MaNV"));
                account.setMaKH((Integer) rs.getObject("MaKH"));

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return account;
    }

    public boolean checkAccount(String username, String cccd) {

        String sql = "SELECT * FROM Account a "
                + "JOIN NhanVien n ON a.MaNV = n.MaNV "
                + "WHERE a.Username = ? AND n.CCCD = ?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, cccd);

            ResultSet rs = ps.executeQuery();

            boolean result = rs.next();

            rs.close();
            ps.close();
            conn.close();

            return result;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }

    public boolean updatePassword(String username, String newPassword) {

        String sql = "UPDATE Account SET Password = ? WHERE Username = ?";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, newPassword);
            ps.setString(2, username);

            int row = ps.executeUpdate();

            ps.close();
            conn.close();

            return row > 0;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }
    public boolean register(Account account) {

        String sql =
                "INSERT INTO Account(Username,Password,RoleID,MaNV,MaKH) " +
                        "VALUES(?,?,?,?,?)";

        try {

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getRoleID());

            if (account.getMaNV() == 0) {
                ps.setNull(4, Types.INTEGER);
            } else {
                ps.setInt(4, account.getMaNV());
            }

            if (account.getMaKH() == null) {
                ps.setNull(5, Types.INTEGER);
            } else {
                ps.setInt(5, account.getMaKH());
            }

            int row = ps.executeUpdate();

            ps.close();
            conn.close();

            return row > 0;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }
    public boolean checkUsername(String username){

        String sql = "SELECT * FROM Account WHERE Username=?";

        try{

            Connection conn = connect.myConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            boolean exists = rs.next();

            rs.close();
            ps.close();
            conn.close();

            return exists;

        }catch(Exception e){

            e.printStackTrace();

        }

        return false;

    }

}