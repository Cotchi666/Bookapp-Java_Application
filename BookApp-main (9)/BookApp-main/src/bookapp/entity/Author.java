package bookapp.entity;

public class Author {
    private String hoten;
    private String ngaysinh;
    private String diachi;

    public Author() {
    }

    public Author(String hoten, String ngaysinh, String diachi) {
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        return "TacGia [diachi=" + diachi + ", hoten=" + hoten + ", ngaysinh=" + ngaysinh + "]";
    }
}