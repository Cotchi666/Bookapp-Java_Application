package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Scanner;

public class TestDriverBookApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        QuanLy inventoryManage, accountManage, cartManage;
        inventoryManage = new Inventory();
        accountManage = new AccountManage();
        cartManage = new Cart(inventoryManage);

        try {
            khoiTaoDS(inventoryManage, accountManage);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("1. dang nhap");
            System.out.println("2. dang ky");
            int number = sc.nextInt();
            sc.nextLine();
            switch (number) {
                case 1:
                    Account account = nhap();
                    if (Login.singIn(account, accountManage)) {
                        Iterator<Object> iterator = accountManage.search(account);
                        Account account2 = (Account) iterator.next();
                        String str = "admin";
                        int i = accountManage.list.indexOf(account2);
                        if (!str.equals(((Account) accountManage.list.get(i)).getAccount())) {

                            customerFunction(inventoryManage, cartManage, accountManage, account);
                        } else {

                            managerFunction(accountManage, inventoryManage);

                        }

                    } else {
                        System.out.println("Incorrect username or password");
                    }
                    break;

                default:
                    Login.signUp(nhap(), accountManage);
                    break;
            }

        }
    }

    public static Account nhap() {
        System.out.println("Username:  ");
        String account1 = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        return new Account(account1, password);
    }

    public static void khoiTaoDS(QuanLy inventory, QuanLy accountManage) throws ParseException {

        inventory.add(new Book(123, "To Kill a Mockingbird", "Kim Dong",
                new SimpleDateFormat("dd/MM/yyy").parse("12/09/2001"), 100000, 2,
                new Author("Nguyen Ngoc Chien", "18/3/1998", "Ho Chi Minh"), Category.TIEUTHUYET));
        inventory.add(
                new Book(124, "Anna Karenina", "Andrew Matthews", new SimpleDateFormat("dd/MM/yyy").parse("23/09/1998"),
                        170000, 50, new Author("Ngyen Ngoc Nga", "22/9/1977", "Ha Noi"), Category.VANHOC_NGHETHUAT));
        inventory.add(new Book(542, "The Great Gatsby", "Thanh Nien",
                new SimpleDateFormat("dd/MM/yyy").parse("1/1/2004"), 300000, 99,
                new Author("Nguyen Viet Trung", "22/12/1977", "Da Nang"), Category.VANHOC_NGHETHUAT));
        inventory.add(
                new Book(423, "A Passage to India", "Lao Dong", new SimpleDateFormat("dd/MM/yyy").parse("22/8/1995"),
                        125000, 120, new Author("Nguyen Ngoc Anh", "29/1/2001", "HCM"), Category.GIAOTRINH));
        inventory.add(new Book(657, "Invisible Man", "J K Rowling", new SimpleDateFormat("dd/MM/yyy").parse("8/7/2007"),
                248000, 13, new Author("Nguyen Van Thanh", "13/3/1993", "New York"), Category.KHCN_KINHTE));
        inventory
                .add(new Book(56756, "Don Quixote", "Og Mandino", new SimpleDateFormat("dd/MM/yyy").parse("25/10/1998"),
                        131000, 11, new Author("nguyen Minh Dung", "24/04/1994", "Dak Lak"), Category.THIEUNHI));
        inventory.add(new Book(657, "Beloved", "Meredith McIver ", new SimpleDateFormat("dd/MM/yyy").parse("27/9/1989"),
                115000, 93, new Author("Parkstone Press", "18/09/1956", "LONDON"), Category.VANHOC_NGHETHUAT));
        inventory.add(new Book(344, "Bollywood", "J. D. Salinger", new SimpleDateFormat("dd/MM/yyy").parse("2/3/1992"),
                90000, 29, new Author("Nguyen Ngoc Ha", "13/2/1988", "Singapo"), Category.THIEUNHI));
        inventory
                .add(new Book(331, "Thomas Jefferson", "Hemingway", new SimpleDateFormat("dd/MM/yyy").parse("3/4/2001"),
                        30000, 82, new Author("Thomas Jefferson", "9/12/1977", "Lao"), Category.CHINHTRI_PHAPLUAT));

        accountManage.add(new Account("a12345", "ac"));
        accountManage.add(new Account("b", "ac"));

    }

    public static void managerFunction(QuanLy accountManage, QuanLy inventory) {
        boolean check = true;
        while (check) {

            System.out.println("1. xem danh sach tai khoan");
            System.out.println("2. tim tai khoan");
            System.out.println("3. xoa tai khoan");
            System.out.println("4. them sach vao trong kho");
            System.out.println("5. xoa sach khoi kho");
            System.out.println("6. xem danh sach kho");
            System.out.println("0. Log out");

            switch (sc.nextInt()) {
                case 1:
                    accountManage.inDS();
                    break;
                case 2:
                    Iterator<Object> iterator = accountManage.search(new Account("a", "ac"));
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
                    accountManage.remove(new Account("a", "ac"));
                    break;
                case 4:
                    try {
                        inventory.add(new Book(3391, "Java 102", "MJ",
                                new SimpleDateFormat("dd/MM/yyy").parse("12/09/2001"), 120000, 3,
                                new Author("JavSOn", "18/11/1921", "AC"), Category.VANHOC_NGHETHUAT));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.println("add successful");
                    break;
                case 5:
                    inventory.remove(new Book(344, "the Catcher in the Rye"));
                    break;
                case 6:
                    inventory.inDS();
                    break;
                default:
                    check = false;
                    sc.nextLine();
                    break;
            }
        }
    }

    public static void customerFunction(QuanLy inventory, QuanLy cart, QuanLy accountManage, Account accounts) {
        boolean check = true;
        ((Inventory) inventory).inDSS();
        System.out.println();
        while (check) {

            System.out.println("1. xem them sach ");
            System.out.println("2. tim sach");
            System.out.println("3. them sach vao gio do");
            System.out.println("4. xem danh saach gio do");
            System.out.println("5. Nap tien vao tai khoan");
            System.out.println("6. Xem so du tai khoan");
            System.out.println("7. Thanh toan sach trong gio do");
            System.out.println("0. Log out");
            switch (sc.nextInt()) {
                case 1:
                    inventory.inDS();

                    break;
                case 2:

                    Iterator<Object> iterator = ((Inventory) inventory).search(new Book(Category.CHINHTRI_PHAPLUAT));
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
                    System.out.println("Nhap ma sach can them vao gio do");
                    int maSach = sc.nextInt();

                    cart.add(new Book(maSach));

                    break;
                case 4:
                    cart.inDS();
                    break;
                case 5:
                    System.out.println("nhap so tien can nap");
                    if (!((AccountManage) accountManage).napTien(sc.nextDouble(), accounts)) {
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
                    if (((AccountManage) accountManage).thanhToan(cart, accounts)) {
                        System.out.println("Thanh toan thanh cong");

                    } else {
                        System.out.println("so du khong du, vui long nap tien !!!");
                    }
                    break;
                default:
                    check = false;
                    sc.nextLine();
                    break;
            }
        }
    }

    public static Category theloai() {
        Category category;
        System.out.println("1- Chinh tri phap luat, 2- Giao trinh, 3- Khoa hoc cong nghe kinh te,4- Thieu nhi");
        System.out.println("4- Van hoc nghe thuat, 5- xa hoi lich su");
        switch (sc.nextInt()) {
            case 1:
                category = Category.CHINHTRI_PHAPLUAT;
                break;
            case 2:
                category = Category.GIAOTRINH;
                break;
            case 3:
                category = Category.KHCN_KINHTE;
                break;
            case 4:
                category = Category.THIEUNHI;
                break;
            case 5:
                category = Category.TIEUTHUYET;
                break;
            case 6:
                category = Category.VANHOC_NGHETHUAT;
                break;
            case 7:
                category = Category.XAHOI_LICHSU;
                break;

            default:
                break;
        }
        return Category.CHINHTRI_PHAPLUAT;
    }
}
