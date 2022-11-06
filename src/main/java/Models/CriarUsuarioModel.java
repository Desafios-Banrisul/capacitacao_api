package Models;

import Utils.FileOperation;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarUsuarioModel {
    private final String email;
    private final String password;
    private final String passwordConfirmation;

    public CriarUsuarioModel() {
        this.email = FileOperation.getProperties("UserData").getProperty("email");
        this.password = FileOperation.getProperties("UserData").getProperty("password");
        this.passwordConfirmation = FileOperation.getProperties("UserData").getProperty("password");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @JsonProperty("password_confirmation")
    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }
}
