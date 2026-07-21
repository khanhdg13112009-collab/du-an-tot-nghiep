package Models;

public class Account {

    private int accountID;
    private String username;
    private String password;
    private int roleID;
    private int maNV;
    private Integer maKH;

    public Account() {
    }

    public Account(int accountID,
                   String username,
                   String password,
                   int roleID,
                   int maNV,
                   Integer maKH) {

        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.roleID = roleID;
        this.maNV = maNV;
        this.maKH = maKH;

    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }
}