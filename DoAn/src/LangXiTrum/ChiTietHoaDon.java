package LangXiTrum;

public class ChiTietHoaDon {
    private String maHD;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private double donGia;
    //constructor
    public ChiTietHoaDon(String maHD, String maSP,String tenSP, int soLuong, double donGia) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tenSP=tenSP;
    }
    //getter
    public ChiTietHoaDon() {
    }
    public String getMaHD() {
        return maHD;
    }
    public String getMaSP() {
        return maSP;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public String getTenSP(){
        return tenSP;
    }
    public double getDonGia() {
        return donGia;
    }
    public double getThanhTien(){
        return this.soLuong*this.donGia;
    }
    //setter
    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    public void hienThi() {
    System.out.printf("%-10s %-20s %5d %10.2f %12.2f\n",
        maSP, tenSP, soLuong, donGia, getThanhTien());
}

    @Override
public String toString() {
    return maHD + "," + maSP + "," + tenSP + "," + soLuong + "," + donGia;
}

}
