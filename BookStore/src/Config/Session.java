package Config;

public class Session {
    public static int accountId;
    public static String name;
    public static String role;

    public static void setSession(int accountId, String name, String role) {
        Session.accountId = accountId;
        Session.name = name;
        Session.role = role;
    }

    public static int getAccountId() {
        return accountId;
    }
    public static String getName() {
        return name;
    }
    public static String getRole() {
        return role;
    }
    public static void clearSession() {
        accountId = 0;
        name = null;
        role = null;
    }
    public static boolean isLoggedIn() {
        return accountId != 0;
    }
}
