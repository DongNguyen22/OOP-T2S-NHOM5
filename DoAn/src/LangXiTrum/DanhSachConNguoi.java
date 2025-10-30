package LangXiTrum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachConNguoi implements XuLiDuLieu {
    public ConNguoi[] ds;
    public int n;
    Scanner sc= new Scanner(System.in);
    // khoi tao danh sach
    public DanhSachConNguoi(){
        ds=null;
        n=0;
    }
    // them 1 nhan vien moi vao danh sach
    public void themNV(){
        ds=Arrays.copyOf(ds, n+1);
        ds[n]=new NhanVien();
        ds[n++].nhap();
    }
    //them khach hang moi vao danh sach
    public void themKH(){
        ds=Arrays.copyOf(ds, n+1);
        ds[n]=new KhachHang();
        ds[n++].nhap();
    }
    //tim kiem Nhan vien theo ten
    public NhanVien[] timNvTheoTen(String key){
        NhanVien[] ketQua = new NhanVien[0];
        int size = ketQua.length;
        for (ConNguoi cn : ds) {
        if (cn instanceof NhanVien nv && nv.getTen().equalsIgnoreCase(key)) {
        ketQua = Arrays.copyOf(ketQua, size + 1);
        ketQua[size++] = nv;
    }
}
    return ketQua;
    }
    // tim nhan vien theo ma
public NhanVien timNvMa(String key) {
    for (ConNguoi cn : ds) {
        if (cn instanceof NhanVien nv && nv.getMaNV().equalsIgnoreCase(key)){
            return nv;
        }
    }
    return null; 
}

    //tim kiem khach hang 
    public KhachHang[] timKhTen(String key){
        KhachHang[] ketQua= new KhachHang[0];
        int size=ketQua.length;
        for (ConNguoi cn : ds) {
        if (cn instanceof KhachHang) {
            KhachHang kh = (KhachHang) cn;
            if(kh.getTen().equalsIgnoreCase(key)){
                ketQua = Arrays.copyOf(ketQua, size + 1);
                ketQua[size] = kh; 
                size++;
             }
        }
    }
    return ketQua;
    }
    //tim kiem khach hang theo ma
    public KhachHang timKhMa(String key){
        for (ConNguoi cn : ds) {
        if (cn instanceof KhachHang) {
            KhachHang kh = (KhachHang) cn;
            if (kh.getMaKH().equals(key)) {
                return kh; 
            }
        }
    }
    return null; 
    }
    // Xoa thong tin  nhan vien
    public void xoaNV(String id) {
    for (int i = 0; i < n; i++) {
        if (ds[i] instanceof NhanVien) {
            NhanVien nv = (NhanVien) ds[i];
            if (nv.getMaNV().equals(id)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }    
                ds=Arrays.copyOf(ds,--n);     
                break;            
            }
        }
}
    }
    public void xoaKH(String id) {
    for (int i = 0; i < n; i++) {
        if (ds[i] instanceof KhachHang) {
            KhachHang kh = (KhachHang) ds[i];
            if (kh.getMaKH().equals(id)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }    
                ds=Arrays.copyOf(ds,--n);     
                break;            
            }
        }
}
    }
    // sua thong tin nhan vien
    public void suaNV(String maNV) {
    for (ConNguoi cn: ds) {
        if (cn instanceof NhanVien) {
            NhanVien nv = (NhanVien) cn;
            if (nv.getMaNV().equals(maNV)) {
                System.out.println("Da tim thay nhan vien co ma " + maNV);
                System.out.println("Chon thong tin muon sua:");
                System.out.println("1. Ten");
                System.out.println("2. Gioi tinh");
                System.out.println("3. So dien thoai");
                System.out.println("4. Dia chi");
                System.out.println("5. Chuc Vu");
                System.out.println("6. Nhap lai toan bo");
                int choice = sc.nextInt();
                sc.nextLine(); 
                switch (choice) {
                    case 1:
                        System.out.print("Nhap ten moi: ");
                        nv.setTen(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhap gioi tinh moi: ");
                        nv.setGtinh(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Nhap so dien thoai moi: ");
                        nv.setSdt(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Nhap dia chi moi: ");
                        nv.setDiachi(sc.nextLine());
                        break;
                    case 5:
                        System.out.print("Nhap chuc vu moi: ");
                        nv.setChucVu(sc.nextLine());
                        break;
                    case 6:
                        System.out.println("Nhap lai toan bo thong tin nhan vien:");
                        nv.nhap();
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
    
                System.out.println("da cap nhat thong tin nhan vien!");
                return;
            }
        }
    }
    System.out.println("Khong tim thay sinh vien co manv:" + maNV);
}
    public void suaKH(String maKH) {
    for (ConNguoi cn: ds) {
        if (cn instanceof KhachHang) {
            KhachHang kh = (KhachHang) cn;
            if (kh.getMaKH().equals(maKH)) {
                System.out.println("Da tim thay Khach hang co ma " + maKH);
                System.out.println("Chon thong tin muon sua:");
                System.out.println("1. Ten");
                System.out.println("2. Gioi tinh");
                System.out.println("3. So dien thoai");
                System.out.println("4. Dia chi");
                System.out.println("5. Nhap lai toan bo");
                int choice = sc.nextInt();
                sc.nextLine(); 
                switch (choice) {
                    case 1:
                        System.out.print("Nhap ten moi: ");
                        kh.setTen(maKH);
                        break;
                    case 2:
                        System.out.print("Nhap gioi tinh moi: ");
                        kh.setGtinh(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Nhap so dien thoai moi: ");
                        kh.setSdt(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Nhap dia chi moi: ");
                        kh.setDiachi(sc.nextLine());
                        break;
                    case 5:
                        System.out.println("Nhap lai toan bo thong tin nhan vien:");
                        kh.nhap();
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
    
                System.out.println("da cap nhat thong tin nhan vien!");
                return;
            }
        }
    }
    System.out.println("Khong tim thay khach hang co manv:" + maKH);
}
    //xuat thong tin nhan vien
    public void xuatNhanVien() {
    for (ConNguoi cn : ds) {
        if (cn instanceof NhanVien)
            System.out.println(cn);
    }
}
    //xuat thong tin khach hang
    public void xuatKhachHang() {
    for (ConNguoi cn : ds) {
        if (cn instanceof KhachHang)
            System.out.println(cn);
    }
}
    public ConNguoi[] getDs() {
        return ds;
    }
    @Override
    public void docFile() {
    try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream("ConNguoi.txt"), "UTF-8"))) {
        String line;
        ds = new ConNguoi[0];
        int size = 0;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length < 5) continue; 

            if (parts[0].contains("NV")) {
                String maNV = parts[0];
                String ten = parts[1];
                String gtinh = parts[2];
                String sdt = parts[3];
                String diaChi = parts[4];
                String chucVu = parts.length > 5 ? parts[5] : "";
                ds = Arrays.copyOf(ds, size + 1);
                ds[size++] = new NhanVien(maNV, ten, gtinh, sdt, diaChi, chucVu);
            } 
            else if (parts[0].contains("KH")) {
                String maKH = parts[0];
                String ten = parts[1];
                String gtinh = parts[2];
                String sdt = parts[3];
                String diaChi = parts[4];
                ds = Arrays.copyOf(ds, size + 1);
                ds[size++] = new KhachHang(ten, gtinh, sdt, diaChi, maKH);
            }
        }

        n = size;

    } catch (IOException e) {
        System.out.println("Lỗi đọc file: " + e.getMessage());
    }
}

    @Override
    public void ghiFile() {
    try (BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream("ConNguoi.txt", false), "UTF-8"))) {
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof NhanVien nv) {
                String line = nv.getMaNV() + ";" +
                              nv.getTen() + ";" +
                              nv.getGtinh() + ";" +
                              nv.getSdt() + ";" +
                              nv.getDiachi() + ";" +
                              nv.getChucVu();
                bw.write(line);
                bw.newLine();
            }
            if (ds[i] instanceof KhachHang kh){
                String line = kh.getMaKH() + ";" +
                              kh.getTen() + ";" +
                              kh.getGtinh() + ";" +
                              kh.getSdt() + ";" +
                              kh.getDiachi();
                bw.write(line);
                bw.newLine();
            }
        }
    } catch (IOException e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
}
    //cac ham co ban
    @Override
    //khoi tao n doi tuong dau tien bang cach nhap du lieu
    public void nhap(int n){
        this.n=n;
        ds = new ConNguoi[n];
        for(int i=0;i<n;i++){
            System.out.println("nhap doi tuong thu "+(i+1)+" ");
                System.out.println("1/them nhan vien");
                System.out.println("2/them khach hang");
                int key=sc.nextInt();
                sc.nextLine();
                if(key==1){
                    ds[i]=new NhanVien();
                    ds[i].nhap();
                }
                else if(key==2){
                    ds[i]= new KhachHang();
                    ds[i].nhap();
                }
       }
    }
    @Override
    public void xuat() {
        System.out.println("--------------------:Danh Sach Nhan Vien:--------------------");
        xuatNhanVien();
        System.out.println("--------------------:Danh Sach Khach Hang:--------------------");
        xuatKhachHang();
    }
    @Override
    public void them() {
        System.out.println("1.Them Nhan Vien:");
        System.out.println("2.Them Khach Hang:");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice == 1) themNV();
        else if(choice == 2) themKH();
    }
    @Override
    public void sua(String key) {
        System.out.println("1.Sua Nhan Vien:");
        System.out.println("2.Sua Khach Hang:");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice == 1) suaNV(key);
        else if(choice == 2) suaKH(key);
    }
    @Override
    public void xoa(String key) {
        System.out.println("1.Xoa Nhan Vien:");
        System.out.println("2.Xoa Khach Hang:");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice == 1) xoaNV(key);
        else if(choice == 2) xoaKH(key);
    }
}
