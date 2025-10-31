package LangXiTrum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSanPham implements XuLiDuLieu{
    private SanPham[] ds;
    private int n;
    Scanner sc= new Scanner(System.in);
    // khoi tao
    public DanhSachSanPham(){
        ds=null;
        n=0;
    }
    //xuat danh sach 
    public void xuat() {
    if (n == 0) {
        System.out.println("Danh sach san pham trong.");
        return;
    }
    System.out.println("Danh muc san pham Thuc An:");
    System.out.printf("%-8s | %-25s | %-10s | %-8s | %-8s | %-8s | %-10s | %-10s%n",
        "Ma SP", "Ten SP", "Don Gia", "DVT", "S.lUONG", "Ma loai", "Do Gion", "Gia Vi");
    System.out.println("------------------------------------------------------------------------------------------------------");
    for (SanPham sp : ds) {
        if(sp instanceof ThucAn){
            System.out.println(sp);
        }
    }
    System.out.println("Danh muc san pham Thuc Uong:");
    System.out.printf("%-8s | %-25s | %-8s | %-8s | %-8s | %-8s | %-10s | %-10s%n",
        "Ma SP", "Ten SP", "Don Gia", "DVT", "S.lUONG", "Ma loai", "Dung Tich", "Gas");
    System.out.println("-----------------------------------------------------------------------------------------------------");
    for (SanPham sp : ds) {
        if(sp instanceof ThucUong){
    System.out.println(sp);
        }
}
}
   // tim san pham
   public SanPham timSPtheoMaSp(String key){
    for(SanPham sp : ds){
        if(sp.getMaSP().equals(key)){
            return sp;
        }
    }
    return null;
   }
   //tim san pham theo ten
   public SanPham[] timSanPhamTen(String tenSP){
     SanPham[] ketqua= new SanPham[0];
     int size=0;
     for(SanPham sp : ds){
        if(sp.getTenSP().equalsIgnoreCase(tenSP)){
            ketqua[size++]=sp;
        }
     }
     return ketqua;
   }
   @Override
   public void nhap(int n) {
    this.n = n;
    ds = new SanPham[n];
    for (int i = 0; i < n; i++) {
        System.out.println("Nhap doi tuong thu " + (i + 1));
        System.out.println("1. Them Thuc An");
        System.out.println("2. Them Thuc Uong");
        System.out.print("Chon: ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        switch (choice) {
            case 1:
                ds[i] = new ThucAn();
                ds[i].nhap();
                break;
            case 2:
                ds[i] = new ThucUong();
                ds[i].nhap();
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                i--; 
        }
    }
}

   @Override
   public void them() {
    System.out.println("1.Them Thuc An");
    System.out.println("1.Them Thuc Uong");
    int choice=sc.nextInt();
    sc.nextLine();
    if(choice == 1) themTA();
    else if(choice == 2) themTU();
   }
   @Override
   public void sua(String maSP) {
    boolean found = false;
    SanPham sp= timSPtheoMaSp(maSP);
        if (sp != null) {
            found = true;
            System.out.println("\n--- SUA THONG TIN SAN PHAM ---");
            System.out.println("1. Sua ten san pham");
            System.out.println("2. Sua don gia");
            System.out.println("3. Sua don vi tinh");
            System.out.println("4. Sua ma loai");
            System.out.print("Chon: ");
            int key = sc.nextInt();
            sc.nextLine(); 

            switch (key) {
                case 1 : {
                    System.out.print("Nhap ten moi: ");
                    String tenMoi = sc.nextLine();
                    sp.setTenSP(tenMoi);
                    System.out.println("Da cap nhat ten san pham!");
                }
                break;
                case 2 : {
                    System.out.print("Nhap don gia moi: ");
                    double giaMoi = sc.nextDouble();
                    sc.nextLine();
                    sp.setDonGia(giaMoi);
                    System.out.println("Da cap nhat don gia!");
                }
                break;
                case 3 :{
                    System.out.print("Nhap don vi tinh moi: ");
                    String dvtMoi = sc.nextLine();
                    sp.setDvt(dvtMoi); 
                    System.out.println("Da cap nhat don vi tinh!");
                }
                break;
                case 4 : {
                    System.out.print("Nhap ma loai moi: ");
                    String loaiMoi = sc.nextLine();
                    sp.setMaLoai(loaiMoi); 
                    System.out.println("Da cap nhat ma loai!");
                }
                break;
            }
        }
    if (!found) {
        System.out.println("Khong tim thay san pham co ma: " + maSP);
    }
   }
   @Override
public void xoa(String key) {
    for (int i = 0; i < n; i++) {
        if (ds[i].getMaSP().equalsIgnoreCase(key)) {
            for (int j = i; j < n - 1; j++) {
                ds[j] = ds[j + 1];
            }
            n--;
            ds = Arrays.copyOf(ds, n);
            System.out.println("Da xoa san pham co ma " + key);
            return;
        }
    }
    System.out.println("Khong tim thay ma san pham: " + key);
}

   @Override
   public void docFile() {
    try (BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream("SanPham.txt"),"UTF-8"))) {
        ds = new SanPham[0];
        int size = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length < 8) continue;
            String maLoai = parts[0];
            String maSP = parts[1];
            String tenSP = parts[2];
            int soLuong = Integer.parseInt(parts[3]);
            double donGia = Double.parseDouble(parts[4]);
            String dvt = parts[5];
            String tt1 = parts[6];
            String tt2= parts[7];
            ds = Arrays.copyOf(ds, size + 1);
            if (maLoai.contains("TA"))
                ds[size] = new ThucAn(maLoai, maSP, tenSP,soLuong, donGia, dvt, tt1, tt2);
            else
                ds[size] = new ThucUong(maLoai, maSP, tenSP,soLuong, donGia, dvt, tt1, tt2);
            size++;
        }
        n = size;
        System.out.println(" doc du lieu thanh cong so luong: " + n);
    } catch (Exception e) {
        System.out.println(" Loi doc file: " + e.getMessage());
        ds = new SanPham[0];
        n = 0;
    }
   }
   @Override
   public void ghiFile() {
    try (BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream("SanPham.txt", false), "UTF-8"))) {
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof ThucAn ta) {
                String line = ta.getMaLoai() + ";" +
                              ta.getMaSP() + ";" +
                              ta.getTenSP() + ";" +
                              ta.getSoLuong() + ";" +
                              ta.getDonGia() + ";" +
                              ta.getDvt() + ";" +
                              ta.getDoGion() + ";"+
                              ta.getGiaVi();
                bw.write(line);
                bw.newLine();
            }
            if (ds[i] instanceof ThucUong tu){
                String line = tu.getMaLoai() + ";" +
                              tu.getMaSP() + ";" +
                              tu.getTenSP() + ";" +
                              tu.getSoLuong() + ";" +
                              tu.getDonGia() + ";" +
                              tu.getDvt() + ";" +
                              tu.getGas() + ";"+
                              tu.getDungTich();
                bw.write(line);
                bw.newLine();
            }
        }
        bw.flush();
System.out.println("Da ghi file SanPham.txt thanh cong!");
    } catch (IOException e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
   }
   //them thuc an
   public void themTA(){
    if (ds == null) {
        ds = new ThucAn[0];
        n = 0;
    }
    ds=Arrays.copyOf(ds, n+1);
    ds[n] = new ThucAn();
    ds[n++].nhap();
   }
   //them thuc Uong
   public void themTU(){
    if (ds == null) {
        ds = new ThucAn[0];
        n = 0;
    }
    ds=Arrays.copyOf(ds, n+1);
    ds[n] = new ThucUong();
    ds[n++].nhap();
   }
}
