package LangXiTrum;

import java.util.Scanner;

public class ConNguoi {
    protected String ten;
    protected String gtinh;
    protected String sdt;
    protected String diaChi;
    Scanner sc= new Scanner(System.in);
    //constructor khong tham so
    public ConNguoi() {
    }
    // constructor co tham so
    public ConNguoi(String ten, String gtinh, String sdt, String diaChi) {
        this.ten = ten;
        this.gtinh = gtinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }
    //constructor sao chep
    public ConNguoi(ConNguoi x){
        this.ten=x.ten;
        this.gtinh=x.gtinh;
        this.sdt=x.sdt;
        this.diaChi=x.diaChi;
    }
    //nhap thong tin
    public void nhap(){
        System.out.println("nhap ten:");
        ten=sc.nextLine();
        System.out.println("nhap so dien thoai");
        sdt=sc.nextLine();
        System.out.println("nhap gioi tinh");
        gtinh=sc.nextLine();
        System.out.println("nhap dia chi");
        diaChi=sc.nextLine();
    }
    // getter
    public String getTen() {
        return ten;
    }
    public String getGtinh() {
        return gtinh;
    }
    public String getSdt() {
        return sdt;
    }
    public String getDiachi() {
        return diaChi;
    }
    //setter
    public void setTen(String ten) {
        this.ten = ten;
    }
    public void setGtinh(String gtinh) {
        this.gtinh = gtinh;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public void setDiachi(String diaChi) {
        this.diaChi = diaChi;
    }
}
