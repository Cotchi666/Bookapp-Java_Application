package app;

import java.util.Scanner;

public class CustomerInfo {
    private String hoTen;
    private String diaChi;
    private int sdt;
    private Scanner sc = new Scanner(System.in);

    public CustomerInfo() {
    }

    public CustomerInfo(String hoTen, String diaChi, int sdt) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public void nhap() {
        System.out.println("nhap ho ten: ");
        this.hoTen = sc.nextLine();
        System.out.println("Nhap dia chi: ");
        this.diaChi = sc.nextLine();
        System.out.println("Nhap so dien thoai: ");
        this.sdt = sc.nextInt();
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }
}
