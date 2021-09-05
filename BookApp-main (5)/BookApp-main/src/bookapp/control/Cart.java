package bookapp.control;

import bookapp.entity.*;
import java.util.Iterator;

public class Cart extends QuanLy {

    Inventory inventory;

    public Cart(QuanLy inventory) {
        this.inventory = (Inventory) inventory;
    }

    @Override
    public void add(Object object) {
        Book book = inventory.check((Book) object);
        if (book == null) {
            System.out.println("Sach da het vui long chon quyen sach khac!!!");
        } else {
            add1(book);
        }
    }

    private void add1(Book object) {

        for (Object book : getList()) {
            if (object.check((Book) book)) {

                ((Book) getList().get(getList().indexOf(book)))
                        .setSoluong(((Book) getList().get(getList().indexOf(book))).getSoluong() + 1);
                System.out.println("add successfully");
                return;
            }
        }

        super.add(new Book(object.getMaSach(), object.getTenSach(), object.getNhaXuatBan(), object.getNgayPhatHanh(),
                object.getDonGia(), 1, object.getTacGia(), object.getTheLoai()));

        System.out.println("add successfully");
    }

    public double tongTien() {
        double tongTien = 0;
        Iterator iterator = getList().iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            tongTien += book.getDonGia() * book.getSoluong();
        }
        return tongTien;
    }

    public void removeAll() {
        Iterator iterator = getList().iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

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
    public void inDS() {
        Iterator i = getList().iterator();
        while (i.hasNext()) {
            Book book = (Book) i.next();
            System.out.println(book.toString());
        }
    }

}
