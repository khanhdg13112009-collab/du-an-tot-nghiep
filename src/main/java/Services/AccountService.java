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
}