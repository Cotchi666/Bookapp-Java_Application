package bookapp.control;

import bookapp.entity.*;

public class Payment {
    private Cart cart;

    public Payment(Cart cart) {
        this.cart = cart;
    }

    public boolean thanhToan(Account account, AccountManage accountManage) {

        boolean check = true;

        for (Object object : accountManage.getList()) {
            if (account.check((Account) object)) {

                if (((Cart) cart).tongTien() > ((Account) object).getBalance()) {
                    check = false;
                } else {
                    accountManage.truTien((Account) object, cart.tongTien());

                }
            }
        }

        return check;
    }
}
