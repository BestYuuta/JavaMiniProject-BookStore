package DTO;

public class RegisterFormDTO {
    private String name;
    private String username;
    private String password;

    public RegisterFormDTO(String username, String password, String name) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
