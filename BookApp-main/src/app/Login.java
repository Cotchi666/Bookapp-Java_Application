package app;

import java.util.Iterator;

public class Login {
    public static boolean singIn(Account account1, QuanLy accountManage) {
        Iterator<Object> i = accountManage.list.iterator();
        while (i.hasNext()) {
            Account account = (Account) i.next();
            if (account.check(account1)) {
                return true;
            }
        }
        return false;
    }

    public static void signUp(Account account, QuanLy acountManage) {
        Iterator<Object> i = acountManage.list.iterator();
        while (i.hasNext()) {
            Account account1 = (Account) i.next();
            if (account.check(account1)) {
                System.out.println("Tai khoan da ton tai");
                return;
            }
        }
        acountManage.add(account);
    }
}
