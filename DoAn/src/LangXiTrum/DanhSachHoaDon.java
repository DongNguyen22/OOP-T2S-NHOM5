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

public class DanhSachHoaDon implements XuLiDuLieu{
    private HoaDon[] dsHD;
    Scanner sc= new Scanner(System.in);
    public DanhSachHoaDon() {
        dsHD = new HoaDon[0];
    }
    // doc danh sach hoa don
    public void docHoaDon() {
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream("HoaDon.txt"), "UTF-8"))) {
             String line;
            int size = 0;
            dsHD = new HoaDon[0];
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 4) {
                    String maHD = parts[0];
                    String maNV = parts[1];
                    String maKH = parts[2];
                    String ngayLap = parts[3];
                    dsHD = Arrays.copyOf(dsHD, size + 1);
                    dsHD[size++] = new HoaDon(maHD, maNV, maKH, ngayLap);
                }
            }
            System.out.println("Doc du lieu thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi doc file hoa don: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("khong tim thay file hoa don");
        }
    }
    // doc danh sach chi tiet hoa don
    public void docChiTietHoaDon() {
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream("ChiTietHoaDon.txt"), "UTF-8"))) {
             String line;
            int size = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 5) {
                    String maHD = parts[0];
                    String maSP = parts[1];
                    String tenSP = parts[2];
                    int soLuong = Integer.parseInt(parts[3]);
                    double donGia = Double.parseDouble(parts[4]);
                    HoaDon hd = timHD(maHD);
                    if (hd != null) {
                        hd.luuCTHD(maHD, maSP, tenSP, soLuong, donGia);
                    } else {
                        System.out.println("khong tim duoc hoa don " + maHD );
                    }
                }
            }
            System.out.println("Doc du lieu chi tiet hoa don thanh cong");
        } catch (IOException e) {
            System.out.println("loi doc file: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("khong tim thay thu muc chi tiet hoa don");
        }
    }
    //them hoa don
   public void themHD() {
    HoaDon hd = new HoaDon();
    System.out.print("Nhap ma hoa don: ");
    String maHD=sc.nextLine();
    while(timHD(maHD)!=null){
        System.out.print("Ma hoa don da ton tai vui long nhap ma hoa don moi:");
        maHD=sc.nextLine();
    }
    hd.themCTHD(maHD);
    dsHD = Arrays.copyOf(dsHD, dsHD.length + 1);
    dsHD[dsHD.length - 1] = hd;
}
    @Override
    public void nhap(int n) {
        for (int i = 0; i < n; i++) {
    System.out.print("Nhap ma hoa don: ");
    String ma = sc.nextLine();
    HoaDon hd = new HoaDon();
    hd.themCTHD(ma);
    dsHD = Arrays.copyOf(dsHD, dsHD.length + 1);
    dsHD[dsHD.length - 1] = hd;
} 
    }
    @Override
    public void xuat() {
        System.out.println("========== DANH SÁCH HÓA ĐƠN ==========");
        if (dsHD.length == 0) {
            System.out.println("Chua co hoa don");
            return;
        }
        for (HoaDon hd : dsHD) {
            hd.hienThi();
        }
    }
    @Override
    public void them() {
        System.out.println("Nhap Ma Hoa Don:");
        String ma = sc.nextLine();
        HoaDon hd = new HoaDon();
        hd.themCTHD(ma);
        dsHD = Arrays.copyOf(dsHD, dsHD.length + 1);
        dsHD[dsHD.length - 1] = hd;
    }
    @Override
public void sua(String key) {
    boolean found = false;
    for (HoaDon hoaDon : dsHD) {
        if (hoaDon.getMaHD().equalsIgnoreCase(key)) {
            found = true;
            int choice;
            do {
                System.out.println("=== SUA HOA DON ===");
                System.out.println("1. Sua ma nhan vien");
                System.out.println("2. Sua ma khach hang");
                System.out.println("3. Sua ngay lap");
                System.out.println("4. Sua chi tiet hoa don");
                System.out.println("0. Thoat");
                System.out.print("Nhap lua chon: ");
                choice = Integer.parseInt(sc.nextLine());
                
                switch (choice) {
                    case 1:
                        System.out.print("Nhap ma nhan vien moi: ");
                        String maNV = sc.nextLine();
                        hoaDon.setMaNV(maNV);
                        System.out.println("Da sua ma nhan vien thanh cong!");
                        break;
                    case 2:
                        System.out.print("Nhap ma khach hang moi: ");
                        String maKH = sc.nextLine();
                        hoaDon.setMaKH(maKH);
                        System.out.println("Da sua ma khach hang thanh cong!");
                        break;
                    case 3:
                        System.out.print("Nhap ngay lap moi (dd/MM/yyyy): ");
                        String ngayLap = sc.nextLine();
                        hoaDon.setNgayLap(ngayLap);
                        System.out.println("Da sua ngay lap thanh cong!");
                        break;
                    case 4:
                        System.out.println("=== SUA CHI TIET HOA DON ===");
                        hoaDon.suaChiTiet();
                        break;
                    case 0:
                        System.out.println("Thoat sua hoa don...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } while (choice != 0);
            break;
        }
    }
    if (!found) {
        System.out.println("Khong tim thay hoa don co ma: " + key);
    }
}

    @Override
    public void xoa(String key) {
        int n=dsHD.length;
        for (int i = 0; i < n; i++) {
            if(dsHD[i].getMaHD().equalsIgnoreCase(key)){
                for(int j=i;j<n-1;j++){
                    dsHD[j]=dsHD[j+1];
                }
                break;
            }
        }
        --n;
        dsHD=Arrays.copyOf(dsHD, n);
        System.out.println("-> Da xoa hoa don thanh cong");
    }
    @Override
    public void docFile() {
        docHoaDon();
        docChiTietHoaDon();
    }
    @Override
    public void ghiFile() {
        ghiHoaDon();
        ghiCTHD();
    }
    public void ghiHoaDon(){
        try (BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream("HoaDon.txt", false), "UTF-8"))) {

        for (int i = 0; i < dsHD.length; i++) {
            String line = dsHD[i].getMaHD() + ";" +
                          dsHD[i].getMaNV() + ";" +
                          dsHD[i].getMaKH() + ";" +
                          dsHD[i].getNgayLap();
            bw.write(line);
            bw.newLine();
        }

        System.out.println("Da ghi moi toan bo du lieu vao file HoaDon.txt!");

    } catch (IOException e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
    }
    public void ghiCTHD(){
        try (BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream("ChiTietHoaDon.txt", false), "UTF-8"))) {

        for (HoaDon ds : dsHD) {
            ChiTietHoaDon[] cthd = ds.getCthd();
            for (ChiTietHoaDon chiTietHoaDon : cthd) {
                String line = chiTietHoaDon.getMaHD() + ";" +
                          chiTietHoaDon.getMaSP() + ";" +
                          chiTietHoaDon.getTenSP() + ";" +
                          chiTietHoaDon.getSoLuong() + ";" +
                          chiTietHoaDon.getDonGia() ;
            bw.write(line);
            bw.newLine();
            }
        }

        System.out.println("Da ghi moi toan bo du lieu vao file ChiTietHoaDon.txt!");

    } catch (IOException e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
    }
    // tim kiem
    public HoaDon timHD(String key){
        for (HoaDon hoaDon : dsHD) {
            if(hoaDon.getMaHD().equalsIgnoreCase(key))
            {
                return hoaDon;
            }
        }
        return null;
    }
    //tim hoa don theo ma nhan vien 
    public HoaDon[] timHDtheoNV(String maNV) {
    HoaDon[] ketQua = new HoaDon[0];
    for (HoaDon hoaDon : dsHD) {
        if (hoaDon.getMaNV().equalsIgnoreCase(maNV)) {
            ketQua = Arrays.copyOf(ketQua, ketQua.length + 1);
            ketQua[ketQua.length - 1] = hoaDon;
        }
    }
    return ketQua;
}
        
}
