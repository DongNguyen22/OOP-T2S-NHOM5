package LangXiTrum;

import java.util.Scanner;

public abstract class SanPham {
    protected String maSP;
    protected String tenSP;
    protected double donGia;
    protected String dvt;
    protected int soLuong;
    protected String maLoai;
    Scanner sc= new Scanner(System.in);
    
    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, double donGia, String dvt, String maLoai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.dvt = dvt;
        this.maLoai = maLoai;
    }
    public SanPham(String maSP, String tenSP, double donGia, String dvt, String maLoai,int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.dvt = dvt;
        this.maLoai = maLoai;
        this.soLuong = soLuong;
    }
    
    public abstract void nhap();
    //getter
    public String getMaSP() {
        return this.maSP;
    }

    public String getTenSP() {
        return this.tenSP;
    }

    public double getDonGia() {
        return this.donGia;
    }

    public String getDvt() {
        return this.dvt;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public String getMaLoai() {
        return this.maLoai;
    }
    //setter
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    @Override
    public String toString() {
        return "maSP=" + maSP + ", tenSP=" + tenSP + ", donGia=" + donGia + ", dvt=" + dvt + ", soLuong="
                + getSoLuong() + ", maLoai=" + maLoai ;
    }
}
