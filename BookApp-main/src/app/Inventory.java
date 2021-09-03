package app;

import java.util.Iterator;

public class Inventory extends QuanLy {

    @Override
    protected void add(Object object) {
        super.add(object);
    }

    @Override
    protected void remove(Object object) {
        super.remove(object);
    }

    @Override
    protected Iterator<Object> search(Object object) {
        return super.search(object);
    }

    @Override
    protected void inDS() {
        super.inDS();
    }

    public void inDSS() {
        for (int i = 0; i < 4; i++) {
            System.out.println(list.get(i).toString());
        }
    }

}
