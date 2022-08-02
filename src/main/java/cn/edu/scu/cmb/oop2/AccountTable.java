package cn.edu.scu.cmb.oop2;

import java.util.HashMap;
import java.util.Map;

public class AccountTable {
    private Map<String,Account> accounts;

    public AccountTable() {
        this.accounts = new HashMap<>();
    }

    public boolean addAccount(Account account) {
        String username = account.getUsername();
        if (!accounts.containsKey(username)) {
            accounts.put(username, account);
            return true;
        }
        return false;
    }


    public boolean exist(String username) {
        return accounts.containsKey(username);
    }

    public Account getAccount(String username) {
        return accounts.get(username);
    }
}
