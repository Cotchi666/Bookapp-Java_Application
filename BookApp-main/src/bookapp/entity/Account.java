package bookapp.entity;

public class Account {
    private String account, password;
    private double balance;

    public Account() {

    }

    public Account(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Account(String account, String password, double balance) {
        this.account = account;
        this.password = password;
        this.balance = 0;
    }

    public boolean check(Account account) {
        if (!account.getAccount().equals(this.account) || account.getAccount() == null
                || account.getAccount().equals("")) {
            return false;
        }
        if (!account.getPassword().equals(this.password) || account.getPassword() == null
                || account.getPassword().equals("")) {
            return false;
        }
        return true;
    }
    

    public boolean check(double soTien) {
        if (soTien < 50000) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account [account=" + account + ", balance=" + balance + ", password=" + password + "]";
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
