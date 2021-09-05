package bookapp.control;

import bookapp.entity.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountManage extends QuanLy {

    public AccountManage() {
        add(new Account("admin", "password"));
    }

    @Override
    public void add(Object object) {
        super.add(object);
    }

    @Override
    public void remove(Object object) {
        for (Object account : getList()) {
            if (((Account) account).check((Account) object)) {
                getList().remove(account);
                System.out.println("Xoa thanh cong");
            }
        }
    }

    @Override
    public Iterator<Object> search(Object object) {
        List<Object> lAccounts = new ArrayList<Object>();
        Iterator<Object> i = getList().iterator();
        while (i.hasNext()) {
            Account account = (Account) i.next();
            if (account.check(((Account) object).getAccount())) {
                lAccounts.add(account);

            }
        }
        return lAccounts.iterator();
    }

    @Override
    public void inDS() {
        Iterator i = getList().iterator();
        while (i.hasNext()) {
            Account account = (Account) i.next();
            System.out.println(account.toString());
        }
    }

    public boolean napTien(double soTien, Account account) {
        if (!account.check(soTien)) {
            return false;
        }
        for (Object object : getList()) {

            if (account.check((Account) object)) {
                congTien((Account) object, soTien);
            }
        }

        return true;
    }

    public void xemSoDu(Account account) {
        for (Object object : getList()) {
            if (account.check((Account) object)) {
                System.out.printf("so du tai khoan la: " + ((Account) object).getBalance());

            }
        }

    }

    private void congTien(Account account, double soTien) {
        account.setBalance(account.getBalance() + soTien);
    }

    protected void truTien(Account account, double soTien) {
        account.setBalance(account.getBalance() - soTien);
    }
}