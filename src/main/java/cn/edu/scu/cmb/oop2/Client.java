package cn.edu.scu.cmb.oop2;

public class Client {


    public Account currentAccount;
    private AccountTable accountTable;


    public Client() {
        this.currentAccount = null;
        accountTable = new AccountTable();
    }

    public boolean login(String username, String password) {
        // 判断是否存在表中
        if (accountTable.exist(username)) {
            // 判断是否账号密码相同
            Account account = accountTable.getAccount(username);
            if (password.equals(account.getPassword())) {
                account.setLogin(true);
                this.currentAccount = account;
                return true;
            }
        }
        return false;
    }

    public Account register(String username, String password) {
        // 判断是否已经注册
        if (accountTable.exist(username)) {
            throw new RuntimeException("该账号已注册");
        } else {
            Account account = new Account(username, password);
            accountTable.addAccount(account);
            return account;
        }
    }

    public boolean modify(String username, String password,String newPassword) {
        // 判断是否存在该账号
        if (!accountTable.exist(username)) {
            return false;
//            throw new RuntimeException("账号错误");
        }
        // 判断原始密码是否与原始账号匹配
        Account original = accountTable.getAccount(username);
        String originalPassword = original.getPassword();
        if (password.equals(originalPassword)) {
            original.setPassword(newPassword);
            return true;
        } else {
            return false;
//            throw new RuntimeException("原始密码错误");
        }
    }

}
