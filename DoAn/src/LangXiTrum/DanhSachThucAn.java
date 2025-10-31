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
public class DanhSachThucAn implements XuLiDuLieu {
    private ThucAn[] dsTA;
    private int n;
    Scanner sc = new Scanner(System.in);
    public DanhSachThucAn(){
        dsTA = null;
        n=0;
    }
    @Override
    public void nhap(int n) {
        this.n=n;
        dsTA=new ThucAn[n];
        for(int i=0;i<n;i++){
            dsTA[i].nhap();
        }
    }

    @Override
    public void xuat() {
        System.out.println("Danh sach thuc an:");
        for(ThucAn ta : dsTA){
            System.out.println(ta);
        }
    }

    @Override
    public void them() {
        if (dsTA == null) {
        dsTA = new ThucAn[0];
        n = 0;
    }
        dsTA= Arrays.copyOf(dsTA, n+1);
        dsTA[n]=new ThucAn();
        dsTA[n++].nhap();
    }

    @Override
    public void sua(String key) {
    ThucAn ta = timThucAnMa(key);
    if (ta != null) {
        System.out.println("Chon thong tin muon sua:");
        System.out.println("1. Ten san pham");
        System.out.println("2. Don gia");
        System.out.println("3. Don vi tinh");
        System.out.println("4. Do gion");
        System.out.println("5. Gia vi");
        System.out.println("6. Ma loai");
        System.out.println("7. Nhap lai toan bo");
        System.out.print("Nhap lua chon: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Nhap ten san pham moi: ");
                String str=sc.nextLine();
                ta.setTenSP(str);
                break;
            case 2:
                System.out.print("Nhap don gia moi: ");
                Double dg= sc.nextDouble();
                ta.setDonGia(dg);
                sc.nextLine();
                break;
            case 3:
                System.out.print("Nhap don vi tinh moi: ");
                String dvt=sc.nextLine();
                ta.setDvt(dvt);
                break;
            case 4:
                System.out.print("Nhap do gion moi: ");
                String dgion= sc.nextLine();
                ta.setDoGion(dgion);
                break;
            case 5:
                System.out.print("Nhap gia vi moi: ");
                String gv = sc.nextLine();
                ta.setGiaVi(gv);
                break;
            case 6:
                System.out.print("Nhap ma loai moi: ");
                String ml= sc.nextLine();
                ta.setMaLoai(ml);
                break;
            case 7:
                System.out.println("Nhap lai toan bo thong tin thuc an:");
                ta.nhap();
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                return;
        }

        System.out.println("Da cap nhat thong tin thuc an!");
    } else {
        System.out.println("Khong tim thay thuc an co ma: " + key);
    }
}


    @Override
    public void xoa(String key) {
    for (int i = 0; i < n; i++) {
        if (dsTA[i].getMaSP().equalsIgnoreCase(key)) {
            for (int j = i; j < n - 1; j++) {
                dsTA[j] = dsTA[j + 1];
            }
            n--;
            dsTA = Arrays.copyOf(dsTA, n);
            System.out.println("Da xoa san pham co ma " + key);
            return;
        }
    }
    System.out.println("Khong tim thay ma san pham: " + key);
}
    @Override
    public void docFile() {
         try (BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream("ThucAn.txt"),"UTF-8"))) {
        dsTA = new ThucAn[0];
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
            dsTA = Arrays.copyOf(dsTA, size + 1);
            if (maLoai.contains("TA"))
                dsTA[size] = new ThucAn(maLoai, maSP, tenSP,soLuong, donGia, dvt, tt1, tt2);
            size++;
        }
        n = size;
        System.out.println(" doc du lieu thanh cong so luong: " + n);
    } catch (Exception e) {
        System.out.println(" Loi doc file: " + e.getMessage());
        dsTA = new ThucAn[0];
        n = 0;
    }
    }

    @Override
    public void ghiFile() {
         try (BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream("ThucAn.txt", false), "UTF-8"))) {
        for (int i = 0; i < n; i++) {
                String line = dsTA[i].getMaLoai() + ";" +
                              dsTA[i].getMaSP() + ";" +
                              dsTA[i].getTenSP() + ";" +
                              dsTA[i].getSoLuong() + ";" +
                              dsTA[i].getDonGia() + ";" +
                              dsTA[i].getDvt() + ";" +
                              dsTA[i].getDoGion() + ";"+
                              dsTA[i].getGiaVi();
                bw.write(line);
                bw.newLine();
            }
        bw.flush();
System.out.println("Da ghi file ThucAn.txt thanh cong!");
    } catch (IOException e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
    }
    //tim kiem
    public ThucAn timThucAnMa(String maSP) {
    for (ThucAn ta : dsTA) {
        if (ta.getMaSP().equalsIgnoreCase(maSP)) {
            return ta;
        }
    }
    return null;
}
   //tim kiem theo ten
   public ThucAn[] timThucAnTen(String tenSP) {
    ThucAn[] ketQua = new ThucAn[0];
    int size = 0;
    for (ThucAn ta : dsTA) {
        if (ta.getTenSP().equalsIgnoreCase(tenSP)) {
            ketQua = Arrays.copyOf(ketQua, size + 1);
            ketQua[size++] = ta;
        }
    }
    return ketQua;
}

}
