package bookapp.control;

import java.util.Iterator;
import bookapp.entity.*;

public class Login {
    public static boolean singIn(Account account1, QuanLy accountManage) {
        Iterator<Object> i = accountManage.getList().iterator();
        while (i.hasNext()) {
            Account account = (Account) i.next();
            if (account.check(account1)) {
                return true;
            }
        }
        return false;
    }

    public static void signUp(Account account, QuanLy accountManage) {
        Iterator<Object> i = accountManage.getList().iterator();
        while (i.hasNext()) {
            Account account1 = (Account) i.next();
            if (account.check(account1)) {
                System.out.println("Tai khoan da ton tai");
                return;
            }
        }
        accountManage.add(account);
    }
}
