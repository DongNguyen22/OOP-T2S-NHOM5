package LangXiTrum;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class HoaDon {
    private String maHD;
    private String maNV;
    private String maKH;
    private String ngayLap;
    private ChiTietHoaDon[] dsCT;
    Scanner sc = new Scanner(System.in);
    // constructor
    public HoaDon() {
        dsCT=new ChiTietHoaDon[0];
    }
    public HoaDon(String maHD, String maNV, String maKH, String ngayLap) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ngayLap = ngayLap;
        dsCT = new ChiTietHoaDon[0];
    }
    // public HoaDon(String maHD, String maNV, String maKH, String ngayLap,double TongTien) {
    //     this.maHD = maHD;
    //     this.maNV = maNV;
    //     this.maKH = maKH;
    //     this.ngayLap = ngayLap;
    //     this.tongTien=tongTien;
    //     dsCT = new ChiTietHoaDon[0];
    // }
    // them cthd co tham so
    public void luuCTHD(String maHD, String maSP, String tenSP, int soLuong, double donGia) {
    if (dsCT == null) {
        dsCT = new ChiTietHoaDon[0]; 
    }
    int size = dsCT.length;
    dsCT = Arrays.copyOf(dsCT, size + 1);
    dsCT[size] = new ChiTietHoaDon(maHD, maSP, tenSP, soLuong, donGia);
}

    //them hoa don 
    public void themCTHD(String maHD) {
        this.maHD=maHD;
        System.out.print("Nhap ma nhan vien: ");
        this.maNV = sc.nextLine();
        while(QuanLyBanHang.dsConNguoi.timNvMa(maNV) == null){
            System.out.println("Khong co nhan vien co maNV:" +maNV);
            System.out.print("Vui long nhap lai ma Nhan Vien");
            this.maNV=sc.nextLine();
        }
        System.out.print("Nhap ma khach hang: ");
        this.maKH = sc.nextLine();
        // while(QuanLyBanHang.dsConNguoi.timKhMa(maKH) != null){
        //     System.out.println("Da co Khach Hang co maKH:" +maKH);
        //     System.out.print("Vui long nhap lai ma Khach Hang");
        //     this.maKH=sc.nextLine();
        // }
        System.out.print("Nhap ngay lap don: ");
        this.ngayLap = sc.nextLine();
        System.out.print("Nhap so luong chi tiet hoa don: ");
        int count = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            System.out.print("Nhap ma san pham: ");
            String maSP = sc.nextLine();
            SanPham sp = QuanLyBanHang.dSachSanPham.timSPtheoMaSp(maSP);
            if (sp != null) {
                System.out.print("Nhap so luong: ");
                int soLuong = sc.nextInt();
                sc.nextLine();
                if (soLuong > sp.getSoLuong()) {
            System.out.println("Khong du so luong  KHO CHI CON(" + sp.getSoLuong() + ")");
            i--;
            continue;
        }
        // cap nhat
                sp.setSoLuong(sp.getSoLuong() - soLuong);
                double donGia = sp.getDonGia();
                ChiTietHoaDon cthd = new ChiTietHoaDon(maHD, maSP, sp.getTenSP(), soLuong, donGia);
                dsCT = Arrays.copyOf(dsCT, dsCT.length + 1);
                dsCT[dsCT.length - 1] = cthd;
            } else {
                System.out.println("Khong tim thay san pham, vui long nhap lai!");
                i--;
            }
        }
    }
    //sua chi tiet hoa don
    public void suaChiTiet() {
    boolean found = false;
    
    System.out.print("Nhap ma san pham can sua trong hoa don: ");
    String maSP = sc.nextLine();
    
    for (ChiTietHoaDon ct : dsCT) {
        if (ct.getMaSP().equalsIgnoreCase(maSP)) {
            found = true;
            int choice;
            do {
                System.out.println("=== SUA CHI TIET HOA DON ===");
                System.out.println("1. Sua ma san pham");
                System.out.println("2. Sua so luong");
                System.out.println("3. Sua don gia");
                System.out.println("0. Thoat");
                System.out.print("Chon: ");
                choice = sc.nextInt();
                sc.nextLine();
                
                switch (choice) {
                    case 1:
                        System.out.print("Nhap ma san pham moi: ");
                        String newMaSP = sc.nextLine();
                        ct.setMaSP(newMaSP);
                        System.out.println("Da sua ma san pham!");
                        break;
                    case 2:
                        System.out.print("Nhap so luong moi: ");
                        int newSL = Integer.parseInt(sc.nextLine());
                        ct.setSoLuong(newSL);
                        System.out.println("Da sua so luong!");
                        break;
                    case 3:
                        System.out.print("Nhap don gia moi: ");
                        double newDG = Double.parseDouble(sc.nextLine());
                        ct.setDonGia(newDG);
                        System.out.println("Da sua don gia!");
                        break;
                    case 0:
                        System.out.println("Thoat sua chi tiet...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } while (choice != 0);
            break;
        }
    }
    if (!found) {
        System.out.println("Khong tim thay san pham co ma: " + maSP);
    }
}

    // hien thi
  public void hienThi() {
        System.out.println("========== Thong tin hoa don ==========");
        System.out.println("Ma hoa don: " + maHD);
        System.out.println("Ma nhan vien: " + maNV);
        System.out.println("Ma khach hang: " + maKH);
        System.out.println("Ngay lap hoa don: " + ngayLap);
        System.out.printf("%-10s %-20s %5s %10s %12s\n", "Ma SP", "Ten SP", "SL", "Don gia", "Thanh tien");
        for (ChiTietHoaDon c : dsCT) {
            c.hienThi();
        }
        System.out.println("--------------------------------------");
        System.out.printf("Tong cong: %.2f\n", getTongTien());
    }

    // getter
    public String getMaHD() {
        return maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public double getTongTien() {
        double tongTien = 0;
        for (ChiTietHoaDon cthd : dsCT) {
            tongTien += cthd.getThanhTien();
        }
        return tongTien;
    }

    public ChiTietHoaDon[] getCthd() {
        return dsCT;
    }

    // setter
    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }
    public void setDsCT(ChiTietHoaDon[] dsCT) {
        this.dsCT = dsCT;
    }
}
