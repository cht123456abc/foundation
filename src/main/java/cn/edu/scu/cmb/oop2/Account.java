package cn.edu.scu.cmb.oop2;


public class Account {


    private String username;
    private String password;
    private Boolean login;

    public void setLogin(Boolean login) {
        this.login = login;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.login = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getLogin() {
        return login;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
