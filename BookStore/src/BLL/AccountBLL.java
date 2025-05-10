package BLL;

import Config.Session;
import DAL.AccountDAL;
import DTO.AccountDTO;
import DTO.LoginFormDTO;
import DTO.RegisterFormDTO;
import DTO.ResponseDTO;
import org.mindrot.jbcrypt.BCrypt;

public class AccountBLL {
    private static final AccountDAL accountDAL = new AccountDAL();

    public static ResponseDTO authenticateUser(LoginFormDTO loginFormDTO) {
        if (loginFormDTO.getUsername().isEmpty() || loginFormDTO.getPassword().isEmpty()) {
            return new ResponseDTO(false, "Please enter both username and password", null);
        }

        try {
            AccountDTO accountDTO = accountDAL.getAccountByUsername(loginFormDTO.getUsername());
            if (accountDTO == null) {
                return new ResponseDTO(false, "Wrong username or password", null);
            }
            if (BCrypt.checkpw(loginFormDTO.getPassword(), accountDTO.getPassWord())) {
                Session.setSession(accountDTO.getId(), accountDTO.getName(), accountDTO.getRole());
                return new ResponseDTO(true, "Login successfully", accountDTO);
            } else {
                return new ResponseDTO(false, "Wrong username or password", null);
            }
        } catch (Exception ex) {
            return new ResponseDTO(false, "Database error: " + ex.getMessage(), null);
        }
    }

    public static ResponseDTO registerUser(RegisterFormDTO dto) {
        if (dto.getUsername().isEmpty() || dto.getPassword().isEmpty() || dto.getName().isEmpty()) {
            return new ResponseDTO(false, "All fields are required", null);
        }

        try {
            if (accountDAL.getAccountByUsername(dto.getUsername()) != null) {
                return new ResponseDTO(false, "Username already exists", null);
            }

            String hashedPassword = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());

            AccountDTO newAccount = new AccountDTO();
            newAccount.setUsername(dto.getUsername());
            newAccount.setPassWord(hashedPassword);
            newAccount.setName(dto.getName());
            newAccount.setRole("User");

            boolean created = accountDAL.createAccount(newAccount);

            if (created) {
                return new ResponseDTO(true, "Register successfully", null);
            } else {
                return new ResponseDTO(false, "Register failed, please try again", null);
            }
        } catch (Exception ex) {
            return new ResponseDTO(false, "Database error: " + ex.getMessage(), null);
        }
    }
}
