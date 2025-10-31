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
public class DanhSachThucUong implements XuLiDuLieu {
    private ThucUong[] dsTU;
    private int n;
    Scanner sc = new Scanner(System.in);
    public DanhSachThucUong(){
        dsTU = null;
        n=0;
    }
    @Override
    public void nhap(int n) {
        this.n=n;
        dsTU=new ThucUong[n];
        for(int i=0;i<n;i++){
            dsTU[i].nhap();
        }
    }

    @Override
    public void xuat() {
        System.out.println("Danh sach thuc uong:");
        for(ThucUong tu : dsTU){
            System.out.println(tu);
        }
    }

    @Override
    public void them() {
        if (dsTU == null) {
        dsTU = new ThucUong[0];
        n = 0;
    }
        dsTU= Arrays.copyOf(dsTU, n+1);
        dsTU[n]=new ThucUong();
        dsTU[n++].nhap();
    }

    @Override
    public void sua(String key) {
    ThucUong tu = timThucUongMa(key);
    if (tu != null) {
        System.out.println("Chon thong tin muon sua:");
        System.out.println("1. Ten san pham");
        System.out.println("2. Don gia");
        System.out.println("3. Don vi tinh");
        System.out.println("4. Gas");
        System.out.println("5. Dung Tich");
        System.out.println("6. Ma loai");
        System.out.println("7. Nhap lai toan bo");
        System.out.print("Nhap lua chon: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Nhap ten san pham moi: ");
                String str=sc.nextLine();
                tu.setTenSP(str);
                break;
            case 2:
                System.out.print("Nhap don gia moi: ");
                Double dg= sc.nextDouble();
                tu.setDonGia(dg);
                sc.nextLine();
                break;
            case 3:
                System.out.print("Nhap don vi tinh moi: ");
                String dvt=sc.nextLine();
                tu.setDvt(dvt);
                break;
            case 4:
                System.out.print("Nhap do Gas: ");
                String gas= sc.nextLine();
                tu.setGas(gas);
                break;
            case 5:
                System.out.print("Nhap Dung tich moi: ");
                String dtich = sc.nextLine();
                tu.setDungTich(dtich);
                break;
            case 6:
                System.out.print("Nhap ma loai moi: ");
                String ml= sc.nextLine();
                tu.setMaLoai(ml);
                break;
            case 7:
                System.out.println("Nhap lai toan bo thong tin thuc an:");
                tu.nhap();
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
        if (dsTU[i].getMaSP().equalsIgnoreCase(key)) {
            for (int j = i; j < n - 1; j++) {
                dsTU[j] = dsTU[j + 1];
            }
            n--;
            dsTU = Arrays.copyOf(dsTU, n);
            System.out.println("Da xoa san pham co ma " + key);
            return;
        }
    }
    System.out.println("Khong tim thay ma san pham: " + key);
}
    @Override
    public void docFile() {
         try (BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream("ThucUong.txt"),"UTF-8"))) {
        dsTU = new ThucUong[0];
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
            dsTU = Arrays.copyOf(dsTU, size + 1);
            if (maLoai.contains("tu"))
                dsTU[size] = new ThucUong(maLoai, maSP, tenSP,soLuong, donGia, dvt, tt1, tt2);
            size++;
        }
        n = size;
        System.out.println(" doc du lieu thanh cong so luong: " + n);
    } catch (Exception e) {
        System.out.println(" Loi doc file: " + e.getMessage());
        dsTU = new ThucUong[0];
        n = 0;
    }
    }

    @Override
    public void ghiFile() {
         try (BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream("ThucUong.txt", false), "UTF-8"))) {
        for (int i = 0; i < n; i++) {
                String line = dsTU[i].getMaLoai() + ";" +
                              dsTU[i].getMaSP() + ";" +
                              dsTU[i].getTenSP() + ";" +
                              dsTU[i].getSoLuong() + ";" +
                              dsTU[i].getDonGia() + ";" +
                              dsTU[i].getDvt() + ";" +
                              dsTU[i].getGas() + ";"+
                              dsTU[i].getDungTich();
                bw.write(line);
                bw.newLine();
            }
        bw.flush();
System.out.println("Da ghi file ThucUong.txt thanh cong!");
    } catch (IOException e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
    }
    //tim kiem
    public ThucUong timThucUongMa(String maSP) {
    for (ThucUong tu : dsTU) {
        if (tu.getMaSP().equalsIgnoreCase(maSP)) {
            return tu;
        }
    }
    return null;
}
   //tim kiem theo ten
   public ThucUong[] timThucUongTen(String tenSP) {
    ThucUong[] ketQua = new ThucUong[0];
    int size = 0;
    for (ThucUong tu : dsTU) {
        if (tu.getTenSP().equalsIgnoreCase(tenSP)) {
            ketQua = Arrays.copyOf(ketQua, size + 1);
            ketQua[size++] = tu;
        }
    }
    return ketQua;
}

}
