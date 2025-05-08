package Config;

import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;

public class SeedData {
    public SeedData() {
        seedAccount();
    }

    private void seedAccount() {
        String query = "SELECT * FROM users WHERE username = ?";
        ResultSet rs = dbHelper.executeQuery(query, "admin");
        try {
            if (!rs.next()) {
                String insertQuery = "INSERT INTO users (username, password, name, role) VALUES (?, ?, ?, ?)";
                dbHelper.executeUpdate(
                        insertQuery, "admin", BCrypt.hashpw("admin", BCrypt.gensalt()), "ADMIN", "ADMIN");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Account already exists");
    }
}
