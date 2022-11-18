package Models;

import Utils.FileOperation;

public class RealizarLoginModel {
    private final String email;
    private final String password;

    public RealizarLoginModel(){
        this.email = FileOperation.getProperties("UserData").getProperty("email");
        this.password = FileOperation.getProperties("UserData").getProperty("password");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
