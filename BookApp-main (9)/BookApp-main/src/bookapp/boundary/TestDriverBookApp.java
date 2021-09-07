package bookapp.boundary;

import bookapp.control.*;
import bookapp.entity.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class TestDriverBookApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        CustomerInfo customerInfo = new CustomerInfo();
        Manage inventoryManage, accountManage, cartManage, billManage;
        inventoryManage = new Inventory();
        accountManage = new AccountManage();
        cartManage = new Cart(inventoryManage);
        billManage = new BillManage();

        try {
            khoiTaoDS(inventoryManage, accountManage);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean kiemtra = true;

        while (kiemtra) {
            int number = 0;
            boolean kiemtra1 = true;
            while (kiemtra1) {

                try {
                    System.out.println("1. dang nhap");
                    System.out.println("2. dang ky");
                    System.out.println("-> Nhap so khac de thoat");
                    number = sc.nextInt();
                    kiemtra1 = false;
                } catch (InputMismatchException e) {
                    System.out.println("Khong hop le vui long nhap lai!!!");
                    System.out.println();
                    kiemtra1 = true;
                    sc.nextLine();
                }
            }
            switch (number) {
                case 1:
                    Account account = nhap();
                    if (Login.singIn(account, accountManage)) {
                        if (!account.getAccount().equals("admin")) {

                            customerFunction(inventoryManage, (Cart) cartManage, (AccountManage) accountManage, account,
                                    customerInfo, billManage);
                        } else {

                            managerFunction(accountManage, inventoryManage, billManage);

                        }

                    } else {
                        System.out.println("Incorrect username or password");
                    }
                    break;
                case 2:
                    Login.signUp(nhap(), accountManage);
                    break;

                default:
                    System.out.println("------------GOOD BYE------------");
                    kiemtra = false;
                    break;
            }

        }
    }

    public static Account nhap() {
        sc.nextLine();
        System.out.println("Username:  ");
        String account1 = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        return new Account(account1, password);
    }

    public static void khoiTaoDS(Manage inventory, Manage accountManage) throws ParseException {

        inventory.add(new Book(123, "To Kill a Mockingbird", "Kim Dong", "12/09/2001", 100000, 2,
                new Author("Nguyen Ngoc Chien", "18/3/1998", "Ho Chi Minh"), Category.TIEUTHUYET));
        inventory.add(new Book(124, "Anna Karenina", "Andrew Matthews", "23/09/1998", 170000, 50,
                new Author("Ngyen Ngoc Nga", "22/9/1977", "Ha Noi"), Category.VANHOC_NGHETHUAT));
        inventory.add(new Book(542, "The Great Gatsby", "Thanh Nien", "1/1/2004", 300000, 99,
                new Author("Nguyen Viet Trung", "22/12/1977", "Da Nang"), Category.VANHOC_NGHETHUAT));
        inventory.add(new Book(423, "A Passage to India", "Lao Dong", "22/8/1995", 125000, 120,
                new Author("Nguyen Ngoc Anh", "29/1/2001", "HCM"), Category.GIAOTRINH));
        inventory.add(new Book(657, "Invisible Man", "J K Rowling", "8/7/2007", 248000, 13,
                new Author("Nguyen Van Thanh", "13/3/1993", "New York"), Category.KHCN_KINHTE));
        inventory.add(new Book(56756, "Don Quixote", "Og Mandino", "25/10/1998", 131000, 11,
                new Author("nguyen Minh Dung", "24/04/1994", "Dak Lak"), Category.THIEUNHI));
        inventory.add(new Book(657, "Beloved", "Meredith McIver ", "27/9/1989", 115000, 93,
                new Author("Parkstone Press", "18/09/1956", "LONDON"), Category.VANHOC_NGHETHUAT));
        inventory.add(new Book(344, "Bollywood", "J. D. Salinger", "2/3/1992", 90000, 29,
                new Author("Nguyen Ngoc Ha", "13/2/1988", "Singapo"), Category.THIEUNHI));
        inventory.add(new Book(331, "Thomas Jefferson", "Hemingway", "3/4/2001", 30000, 82,
                new Author("Thomas Jefferson", "9/12/1977", "Lao"), Category.CHINHTRI_PHAPLUAT));

        accountManage.add(new Account("a12345", "ac"));
        accountManage.add(new Account("b", "ac"));
        accountManage.add(new Account("huong", "1"));
        accountManage.add(new Account("chien", "2"));

    }

    public static void managerFunction(Manage accountManage, Manage inventory, Manage billManage) {
        boolean check = true;
        while (check) {
            int number = 0;
            boolean kiemtra1 = true;
            while (kiemtra1) {
                try {
                    System.out.println("1. xem danh sach tai khoan");
                    System.out.println("2. tim tai khoan");
                    System.out.println("3. xoa tai khoan");
                    System.out.println("4. them sach vao trong kho");
                    System.out.println("5. xoa sach khoi kho");
                    System.out.println("6. xem danh sach kho");
                    System.out.println("7. xem hoa don");
                    System.out.println("-> Nhap so khac de dang xuat");
                    number = sc.nextInt();
                    kiemtra1 = false;
                } catch (InputMismatchException e) {
                    System.out.println("Khong hop le vui long nhap lai!!!");
                    System.out.println();
                    kiemtra1 = true;
                    sc.nextLine();
                }

            }
            switch (number) {
                case 1:
                    accountManage.inDS();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Nhap ten tai khoan can tim");
                    String accountStr = sc.nextLine();
                    Iterator iterator = accountManage.search(new Account(accountStr));
                    if (iterator.hasNext()) {
                        while (iterator.hasNext()) {
                            Account account = (Account) iterator.next();
                            System.out.println(account.toString());
                        }
                    } else {
                        System.out.println("not found");
                    }
                    break;
                case 3:
                    System.out.println("Username:  ");
                    sc.nextLine();
                    String account1 = sc.nextLine();
                    System.out.println("Password: ");
                    String password = sc.nextLine();
                    try {
                        accountManage.remove(new Account(account1, password));
                    } catch (ConcurrentModificationException e) {
                    }
                    break;
                case 4:
                    int maSach = 0;
                    boolean check1 = false;
                    while (!check1) {
                        try {
                            System.out.println("Nhap ma sach: ");
                            maSach = sc.nextInt();
                            check1 = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Ma sach khong hop le vui long nhap lai!!!");
                            check1 = false;
                            sc.nextLine();
                        }
                    }
                    System.out.println("Nhap ten sach:");
                    sc.nextLine();
                    String tenSach = sc.nextLine();
                    System.out.println("Nhap nha xuat ban: ");
                    String nhaXuatBan = sc.nextLine();
                    boolean check2 = false;
                    String ngayPhatHanh = "";
                    while (!check2) {
                        try {
                            System.out.println("Nhap ngay phat hanh: ");
                            ngayPhatHanh = sc.nextLine();
                            new SimpleDateFormat("dd/MM/yyy").parse(ngayPhatHanh);
                            check2 = true;
                        } catch (ParseException e1) {
                            System.out.println("Khong hop le vui long nhap lai!!!");
                            check2 = false;
                        }
                    }

                    double donGia = 0;
                    boolean check3 = false;
                    while (!check3) {
                        try {
                            System.out.println("Nhap don gia: ");
                            donGia = sc.nextDouble();
                            check3 = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Khong hop le vui long nhap lai!!!");
                            check3 = false;
                            sc.nextLine();
                        }
                    }

                    int soluong = 0;
                    boolean check4 = false;
                    while (!check4) {
                        try {
                            System.out.println("Nhap so luong: ");
                            soluong = sc.nextInt();
                            check4 = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Khong hop le vui long nhap lai!!!");
                            check4 = false;
                            sc.nextLine();
                        }
                    }
                    System.out.println("Nhap ho ten tac gia: ");
                    sc.nextLine();
                    String hoten = sc.nextLine();
                    boolean check5 = false;
                    String ngaysinh = "";
                    while (!check5) {
                        try {
                            System.out.println("Nhap ngay sinh tac gia: ");
                            ngaysinh = sc.nextLine();
                            new SimpleDateFormat("dd/MM/yyy").parse(ngaysinh);
                            check5 = true;
                        } catch (ParseException e1) {
                            System.out.println("Khong hop le vui long nhap lai!!!");
                            check5 = false;
                        }
                    }
                    System.out.println("Nhap dia chi tac gia: ");
                    String diachi = sc.nextLine();

                    inventory.add(new Book(maSach, tenSach, nhaXuatBan, ngayPhatHanh, donGia, soluong,
                            new Author(hoten, ngaysinh, diachi), Category.GIAOTRINH));

                    System.out.println("add successful");
                    break;
                case 5:
                    int masach = 0;
                    boolean che1k = false;
                    while (!che1k) {
                        try {
                            System.out.println("Nhap ma sach can xoa:");
                            masach = sc.nextInt();
                            che1k = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Ma sach khong hop le vui long nhap lai!!!");
                            che1k = false;
                            sc.nextLine();
                        }

                    }
                    inventory.remove(new Book(masach));
                    break;
                case 6:
                    inventory.inDS();
                    break;
                case 7:
                    billManage.inDS();
                    break;
                default:
                    check = false;
                    sc.nextLine();
                    break;
            }
        }

    }

    public static void customerFunction(Manage inventory, Cart cart, AccountManage accountManage, Account accounts,
            CustomerInfo customerInfo, Manage billManage) {
        boolean check = true;
        System.out.println();
        while (check) {
            int number = 0;
            boolean kiemtra1 = true;
            while (kiemtra1) {
                try {
                    System.out.println("1. xem sach ");
                    System.out.println("2. tim sach");
                    System.out.println("3. them sach vao gio do");
                    System.out.println("4. xem danh saach gio do");
                    System.out.println("5. Nap tien vao tai khoan");
                    System.out.println("6. Xem so du tai khoan");
                    System.out.println("7. Thanh toan sach trong gio do");
                    System.out.println("8. Xoa sach khoi gio do");
                    System.out.println("-> Nhap so khac de dang xuat");
                    number = sc.nextInt();
                    kiemtra1 = false;
                } catch (InputMismatchException e) {
                    System.out.println("Khong hop le vui long nhap lai!!!");
                    System.out.println();
                    kiemtra1 = true;
                    sc.nextLine();
                }

            }
            switch (number) {
                case 1:
                    inventory.inDS();

                    break;
                case 2:

                    Iterator<Object> iterator = ((Inventory) inventory).search(new Book(Category.VANHOC_NGHETHUAT));
                    if (iterator.hasNext()) {
                        while (iterator.hasNext()) {
                            Book book2 = (Book) iterator.next();
                            System.out.println(book2.toString());
                        }
                    } else {
                        System.out.println("not found");
                    }
                    break;
                case 3:
                    int maSach = 0;
                    boolean check1 = false;
                    while (!check1) {

                        try {
                            System.out.println("Nhap ma sach can them vao gio do");
                            maSach = sc.nextInt();
                            check1 = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Ma sach khong hop le vui long nhap lai!!!");
                            check1 = false;
                            sc.nextLine();
                        }

                    }

                    cart.add(new Book(maSach));

                    break;
                case 4:
                    cart.inDS();
                    break;
                case 5:

                    double soTien = 0;
                    boolean kiemtr1 = false;
                    while (!kiemtr1) {
                        try {
                            System.out.println("nhap so tien can nap");
                            soTien = sc.nextDouble();
                            kiemtr1 = true;
                        } catch (InputMismatchException e) {
                            System.out.println("So tien khong hop le vui long nhap lai!!!");
                            kiemtr1 = false;
                            sc.nextLine();
                        }
                    }
                    if (!((AccountManage) accountManage).napTien(soTien, accounts)) {
                        System.out.println("so tien toi thieu nap la 50000 vnd");
                    } else {
                        System.out.println("nap tien thanh cong");
                    }
                    break;
                case 6:
                    ((AccountManage) accountManage).xemSoDu(accounts);
                    System.out.println();
                    break;
                case 7:
                    Payment payment = new Payment(cart);
                    System.out.println("danh sach mua hang");
                    cart.inDS();
                    System.out.println();
                    System.out.println();
                    System.out.println("tong tien la: " + cart.tongTien());
                    sc.nextLine();
                    System.out.println("nhap ho ten: ");
                    String hoTen = sc.nextLine();
                    System.out.println("Nhap dia chi: ");
                    String diaChi = sc.nextLine();

                    int sdt = 0;
                    boolean kiemtr2 = false;
                    while (!kiemtr2) {
                        try {
                            System.out.println("Nhap so dien thoai: ");
                            sdt = sc.nextInt();
                            kiemtr2 = true;
                        } catch (InputMismatchException e) {
                            System.out.println("So dien thoai khong hop le vui long nhap lai!!!");
                            kiemtr2 = false;
                            sc.nextLine();
                        }
                    }
                    if (payment.thanhToan(accounts, accountManage)) {
                        billManage.add(new Bill(cart, new CustomerInfo(hoTen, diaChi, sdt)));
                        cart.removeAll();
                        System.out.println("Thanh toan thanh cong");
                    } else {
                        System.out.println("so du khong du, vui long nap tien !!!");
                    }
                    break;
                case 8:

                    int masach = 0;
                    boolean che1k = false;
                    while (!che1k) {

                        try {
                            System.out.println("Nhap ma sach can xoa:");
                            masach = sc.nextInt();
                            che1k = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Ma sach khong hop le vui long nhap lai!!!");
                            che1k = false;
                            sc.nextLine();
                        }

                    }
                    cart.remove(new Book(masach));
                    break;
                default:
                    check = false;
                    sc.nextLine();
                    break;
            }

        }
    }
}
