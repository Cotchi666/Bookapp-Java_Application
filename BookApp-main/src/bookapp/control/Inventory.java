package bookapp.control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bookapp.entity.Book;

public class Inventory extends QuanLy {

    @Override
    public void add(Object object) {
        super.add(object);
    }

    @Override
    public void remove(Object object) {
        for (Object book : getList()) {
            if (((Book) book).check((Book) object)) {
                getList().remove(book);
                System.out.println("xoa sach thanh cong");
                return;
            }
        }
        System.out.println("khong tim thay ma sach");
    }

    @Override
    public Iterator<Object> search(Object object) {
        List<Object> lAccounts = new ArrayList<Object>();
        Iterator<Object> i = getList().iterator();
        while (i.hasNext()) {
            Book book = (Book) i.next();
            if (book.check((Book) object)) {
                lAccounts.add(book);
            }
        }
        return lAccounts.iterator();
    }

    @Override
    public void inDS() {
        Iterator i = getList().iterator();
        while (i.hasNext()) {
            Book book = (Book) i.next();
            System.out.println(book.toString());
        }
    }

    public void inDSS() {
        for (int i = 0; i < 4; i++) {
            System.out.println(getList().get(i).toString());
        }
    }

    protected Book check(Book book) {
        Iterator<Object> i = getList().iterator();
        while (i.hasNext()) {
            Book book2 = (Book) i.next();
            int amount = book2.getSoluong();
            if (amount < 1) {
                return null;
            } else {
                if (book.check(book)) {
                    amount--;
                    book2.setSoluong(amount);
                    return book2;
                }
            }
        }
        return null;
    }

}
