package DAL;

import Config.dbHelper;
import DTO.AccountDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAL {
    public AccountDTO getAccountByUsername(String username) throws SQLException {
        ResultSet rs = dbHelper.executeQuery("SELECT * FROM users WHERE username = ?", username);
        if (rs.next()) {
            return new AccountDTO(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("role"),
                    rs.getTimestamp("created_at"));
        }
        return null;
    }

    public boolean createAccount(AccountDTO account) throws SQLException {
        String sql = "INSERT INTO users (username, password, name, role) VALUES (?, ?, ?, ?)";
        int rowsAffected = dbHelper.executeUpdate(sql,
                account.getUsername(),
                account.getPassWord(),
                account.getName(),
                account.getRole());

        return rowsAffected > 0;
    }
}
