package LangXiTrum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachKhachHang implements XuLiDuLieu {
    private KhachHang[] dsKH;
    private int n;
    Scanner sc= new Scanner(System.in);
    public DanhSachKhachHang(){
        dsKH = null;
        n=0;
    }
    //khoi tao tu ban phim
    @Override
    public void nhap(int n) {
        this.n=n;
        dsKH = new KhachHang[n];
        for(int i=0 ; i<n ; i++){
            dsKH[i]=new KhachHang();
            dsKH[i].nhap();
        }
    }
    //xuat
    @Override
    public void xuat() {
        System.out.println("Danh sach Khach Hang:");
        for(KhachHang kh : dsKH){
            System.out.println(kh);
        }
    }
    //them 
    @Override
    public void them() {
        dsKH = Arrays.copyOf(dsKH, n+1);
        dsKH[n] = new KhachHang();
        dsKH[n++].nhap();
    }
    //sua
    @Override
    public void sua(String key) {
                KhachHang kh =timKhMa(key);
                if(kh!=null){
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
                        kh.setTen(sc.nextLine());
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
                        System.out.println("Nhap lai toan bo thong tin Khach Hang:");
                        kh.nhap();
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
    
                System.out.println("da cap nhat thong tin Khach Hang!");
                return;
            }
            }
            //xoa
    @Override
public void xoa(String key) {
    for (int i = 0; i < n; i++) {
        if (dsKH[i].getMaKH().equalsIgnoreCase(key)) {
            for (int j = i; j < n - 1; j++) {
                dsKH[j] = dsKH[j + 1];
            }
            dsKH = Arrays.copyOf(dsKH, --n);
            System.out.println("Da xoa khach hang co ma: " + key);
            return;
        }
    }
    System.out.println("Khong tim thay ma khach hang: " + key);
}
   //tim kiem theo ma
    public KhachHang timKhMa(String key){
        for(KhachHang kh : dsKH){
            if(kh.getMaKH().equalsIgnoreCase(key)){
                return kh;
            }
        }
        return null;
    }
    //doc file
    @Override
    public void docFile() {
    try (BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream("KhachHang.txt"),"UTF-8"))){
            String line;
            dsKH = new KhachHang[0];
            int size = 0;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 5) continue;

                String maKH = parts[0];
                String ten = parts[1];
                String gtinh = parts[2];
                String sdt = parts[3];
                String diaChi = parts[4];

                dsKH = Arrays.copyOf(dsKH, size + 1);
                dsKH[size++] = new KhachHang(ten, gtinh, sdt, diaChi, maKH);
            }
            n = size;

        }
    catch (IOException e) {
        System.out.println("Loi doc file: " + e.getMessage());
    }
}
 //ghi file
 @Override
public void ghiFile() {
    try (BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream("KhachHang.txt", false), "UTF-8"))) {

        for (int i = 0; i < n; i++) {
            String line = dsKH[i].getMaKH() + ";" +
                          dsKH[i].getTen() + ";" +
                          dsKH[i].getGtinh() + ";" +
                          dsKH[i].getSdt() + ";" +
                          dsKH[i].getDiachi();
            bw.write(line);
            bw.newLine();
        }

        System.out.println("Da ghi moi toan bo du lieu vao file KhachHang.txt!");

    } catch (IOException e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
}
}
