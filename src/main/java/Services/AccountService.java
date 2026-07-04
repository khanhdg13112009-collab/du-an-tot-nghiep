package Services;

import Models.Account;

import java.sql.*;

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

}