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

public class DanhSachNhanVien implements XuLiDuLieu {
    private NhanVien[] dsNV;
    int n;
    Scanner sc= new Scanner(System.in);
    public DanhSachNhanVien(){
        dsNV = null;
        n=0;
    }
    //khoi tao tu ban phim
    @Override
    public void nhap(int n) {
        this.n=n;
        dsNV = new NhanVien[n];
        for(int i=0 ; i<n ; i++){
            dsNV[i]=new NhanVien();
            dsNV[i].nhap();
        }
    }
    //xuat
    @Override
    public void xuat() {
        System.out.println("Danh sach Nhan Vien:");
        for(NhanVien nv : dsNV){
            System.out.println(nv);
        }
    }
    //them 
    @Override
    public void them() {
        dsNV = Arrays.copyOf(dsNV, n+1);
        dsNV[n] = new NhanVien();
        dsNV[n++].nhap();
    }
    //sua
    @Override
    public void sua(String key) {
                NhanVien nv =timnvMa(key);
                if(nv!=null){
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
                        System.out.println("Nhap lai toan bo thong tin nhan vien:");
                        nv.nhap();
                        break;
                    default:
                        System.out.println("Lua chon chua hop le!");
                }
    
                System.out.println("da cap nhat thong tin nhan vien!");
                return;
            }
             else {
                System.out.println("Khong tim thay nhan vien");
             }
            }
            //xoa
    @Override
public void xoa(String key) {
    for (int i = 0; i < n; i++) {
        if (dsNV[i].getMaNV().equalsIgnoreCase(key)) {
            for (int j = i; j < n - 1; j++) {
                dsNV[j] = dsNV[j + 1];
            }
            dsNV = Arrays.copyOf(dsNV, --n);
            System.out.println("Da xoa nhan vien hang co ma: " + key);
            return;
        }
    }
    System.out.println("khong tim thay ma nhan vien: " + key);
}

   //tim kiem theo ma
    public NhanVien timnvMa(String key){
        for(NhanVien nv : dsNV){
            if(nv.getMaNV().equalsIgnoreCase(key)){
                return nv;
            }
        }
        return null;
    }
    
    //doc file
    @Override
    public void docFile() {
    try (BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream("NhanVien.txt"),"UTF-8"))){
            String line;
            dsNV = new NhanVien[0];
            int size = 0;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 6) continue;

                String manv = parts[0];
                String ten = parts[1];
                String gtinh = parts[2];
                String sdt = parts[3];
                String diaChi = parts[4];
                String chucVu = parts[5];
                dsNV = Arrays.copyOf(dsNV, size + 1);
                dsNV[size++] = new NhanVien(manv,ten, gtinh, sdt, diaChi,chucVu);
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
        new OutputStreamWriter(new FileOutputStream("NhanVien.txt", false), "UTF-8"))) {

        for (int i = 0; i < n; i++) {
            String line = dsNV[i].getMaNV() + ";" +
                          dsNV[i].getTen() + ";" +
                          dsNV[i].getGtinh() + ";" +
                          dsNV[i].getSdt() + ";" +
                          dsNV[i].getDiachi() + ";"+
                          dsNV[i].getChucVu();
            bw.write(line);
            bw.newLine();
        }

        System.out.println("Da ghi moi toan bo du lieu vao file NhanVien.txt!");

    } catch (IOException e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
}
}
