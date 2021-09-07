package bookapp.control;

import java.util.Iterator;
import bookapp.entity.Bill;

public class BillManage extends Manage {

    @Override
    public void inDS() {
        Iterator i = getList().iterator();
        while (i.hasNext()) {
            Bill bill = (Bill) i.next();
            bill.inDS();
        }
    }
}
