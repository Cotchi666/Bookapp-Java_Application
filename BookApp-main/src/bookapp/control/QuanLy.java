package bookapp.control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class QuanLy {
    private List<Object> list;

    public QuanLy() {
        this.list = new ArrayList<Object>();
    }

    public void add(Object object) {
        list.add(object);
    }

    public void remove(Object object) {

    }

    public Iterator<Object> search(Object object) {
        return null;
    }

    public abstract void inDS();

    public List<Object> getList() {
        return list;
    }
}