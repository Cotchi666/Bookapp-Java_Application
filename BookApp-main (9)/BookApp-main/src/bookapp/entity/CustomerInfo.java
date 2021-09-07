package bookapp.entity;

public class CustomerInfo {
    private String hoTen;
    private String diaChi;
    private int sdt;

    public CustomerInfo() {
    }

    public CustomerInfo(String hoTen, String diaChi, int sdt) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
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

    @Override
    public String toString() {
        return "CustomerInfo [diaChi=" + diaChi + ", hoTen=" + hoTen + ", sdt=" + sdt + "]";
    }

}
