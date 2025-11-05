package LangXiTrum;

public class ChiTietHoaDon {
    private String maHD;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private double donGia;

    public ChiTietHoaDon(String maHD, String maSP, String tenSP, int soLuong, double donGia) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    public ChiTietHoaDon(String maHD, String maSP, String tenSP, int soLuong, double donGia , double ThanhTien) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public ChiTietHoaDon(ChiTietHoaDon hd1) {
        this.maHD=hd1.maHD;
        this.maSP=hd1.maSP;
        this.donGia=hd1.donGia;
        this.soLuong=hd1.soLuong;
        this.tenSP=hd1.tenSP;
    }

    public String getMaHD() {
        return maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public double getThanhTien() {
        return soLuong * donGia;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    

    public void xuat() {
        System.out.printf("%-10s %-10s %-10s %-10d %-10.2f %-10.2f\n",
        maHD, maSP, tenSP, soLuong, donGia, getThanhTien());
    }
}
