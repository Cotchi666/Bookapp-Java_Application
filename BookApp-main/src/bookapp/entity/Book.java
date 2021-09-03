package bookapp.entity;

import java.util.Date;

public class Book {
    private int maSach;
    private String tenSach, nhaXuatBan;
    private Date ngayPhatHanh;
    private double donGia;
    private int soluong;
    private Author tacGia;
    private Category theLoai;
    int a;

    public Book() {
    }

    public Book(int maSach) {
        this.maSach = maSach;
    }

    public Book(Category theLoai) {
        this.theLoai = theLoai;
    }

    public Book(int maSach, String tenSach) {
        this.maSach = maSach;
        this.tenSach = tenSach;
    }

    public Book(int maSach, String tenSach, String nhaXuatBan, Date ngayPhatHanh, double donGia, int soluong,
            Author tacGia, Category theLoai) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.nhaXuatBan = nhaXuatBan;
        this.ngayPhatHanh = ngayPhatHanh;
        this.donGia = donGia;
        this.soluong = soluong;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
    }

    public boolean check(Book book) {
        if (book.getMaSach() != this.maSach) {
            return false;
        }
        return true;
    }

    public boolean check(Category category) {
        if (category == null) {
            return false;
        }
        if (category != this.theLoai) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book [donGia=" + donGia + ", maSach=" + maSach + ", ngayPhatHanh=" + ngayPhatHanh + ", nhaXuatBan="
                + nhaXuatBan + ", soluong=" + soluong + ", tacGia=" + tacGia + ", tenSach=" + tenSach + ", theLoai="
                + theLoai + "]";
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public Date getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(Date ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public Author getTacGia() {
        return tacGia;
    }

    public void setTacGia(Author tacGia) {
        this.tacGia = tacGia;
    }

    public Category getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(Category theLoai) {
        this.theLoai = theLoai;
    }

}
