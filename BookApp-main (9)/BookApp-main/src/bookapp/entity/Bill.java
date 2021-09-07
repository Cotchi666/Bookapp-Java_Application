package bookapp.entity;

import bookapp.control.*;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private CustomerInfo customerInfo;
    private List<Book> list = new ArrayList<Book>();
    private double price;

    public Bill(Cart cart, CustomerInfo customerInfo) {

        this.customerInfo = customerInfo;
        for (Object book : cart.getList()) {
            list.add((Book) book);
            this.price += ((Book) book).getDonGia();
        }

    }

    public void inDS() {

        System.out.println("Thong tin khach hang: ");
        System.out.println(customerInfo.toString());
        System.out.println("Danh sach mua: ");
        for (Book book : list) {
            System.out.println(book.toString());
        }
        System.out.println("Tong tien la: " + this.price);

    }
}
