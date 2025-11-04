package LangXiTrum;

import java.util.Scanner;
import java.time.LocalDate;

public class HoaDon {
    private String maHD;
    private String maNV;
    private String maKH;
    private LocalDate NgayLap;
    Scanner sc = new Scanner(System.in);

    public HoaDon() {
    }

    public HoaDon(String maHD, String maNV, String maKH, LocalDate NgayLap) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.NgayLap = NgayLap;

    }

    public String getMaHD() {
        return maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public LocalDate getNgayLaP() {
        return NgayLap;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setNgayLap(LocalDate NgayLap) {
        this.NgayLap = NgayLap;
    }

    public void nhap() {
        System.out.print("nhap ma hoa don:");
        maHD = sc.nextLine();
        System.out.print("nhap ma nhan vien:");
        maNV = sc.nextLine();
        System.out.print("nhap ma khach hang:");
        maKH = sc.nextLine();
        System.out.print("nhap ngay lap hoa don(yyyy-mm-dd):");
        String input = sc.nextLine();
        NgayLap = LocalDate.parse(input);
    }

    public void xuat() {
        System.out.printf("%-10s %-10s %-10s %-12s\n",
                maHD, maNV, maKH, NgayLap);
    }
}
