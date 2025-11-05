package LangXiTrum;
 import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;



public class DanhSachChiTietHoaDon {
    ChiTietHoaDon[] dsct = new ChiTietHoaDon[0];
    int n = 0;
    Scanner sc = new Scanner(System.in);

    public DanhSachChiTietHoaDon() {}

    public void them(ChiTietHoaDon ct) {
        dsct = Arrays.copyOf(dsct, n + 1);
        dsct[n] = new ChiTietHoaDon(ct);
        n++;
    }

    public void them(String maHD, String maSP,  String tenSP ,int SoLuong, int DonGia) {
        dsct = Arrays.copyOf(dsct, n + 1);
        dsct[n] = new ChiTietHoaDon(maHD, maSP,tenSP, SoLuong, DonGia);
        n++;
    }

    public void deleteCT(String maHD, String maSP) {
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (dsct[i].getMaHD().equalsIgnoreCase(maHD)
                    && dsct[i].getMaSP().equalsIgnoreCase(maSP)) {
                index = i;
                break;
            }
        }
        
        if (index == -1) {
            System.out.println("Khong ton tai chi tiet hoa don");
            return;
        }

        for (int i = index; i < n - 1; i++) {
            dsct[i] = dsct[i + 1];
        }

        dsct = Arrays.copyOf(dsct, n - 1);
        n--;
    }

    public void deleteAllHD(String maHD)
    {
        for(int i = 0; i < n; i++)
        {
            if(dsct[i].getMaHD().equalsIgnoreCase(maHD))
            {
                deleteCT(maHD, dsct[i].getMaSP());
                i--;
            }
        }
    }

    public ChiTietHoaDon[] findDSCT(String maHD) {
        ChiTietHoaDon[] result = new ChiTietHoaDon[0];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (dsct[i].getMaHD().equalsIgnoreCase(maHD)) {
                result = Arrays.copyOf(result, index + 1);
                result[index] = dsct[i];
                index++;
            }
        }

        if (index == 0) {
            return new ChiTietHoaDon[0];
        }

        return result;
    }


    public boolean editSoLuongInChiTiet(String mahd, String masp, int sl)
    {
        for(int i = 0; i < n; i++)
        {
            if(dsct[i].getMaHD().equalsIgnoreCase(mahd) && dsct[i].getMaSP().equalsIgnoreCase(masp))
            {
                dsct[i].setSoLuong(sl);
                return true;
            }
        }

        return false;
    }

    public int getTongTienHD(String maHD) {
        int Tong = 0;
        for (int i = 0; i < n; i++) {
            if (dsct[i].getMaHD().equalsIgnoreCase(maHD)) {
                Tong += dsct[i].getThanhTien();
            }
        }
        return Tong;
    }

    public void Xuat() {
        System.out.printf("%-10s %-10S %-10s %-10s %-10s %-10s\n",
                "mahd", "masp","tenSP", "soluong", "dongia", "thanhtien");
        for (int i = 0; i < n; i++) {
            dsct[i].xuat();
        }
    }

    public void XuatHD(String maHD)
    {
        System.out.printf("%-10s %-10s %-10S %-10s %-10s %-10s\n",
                "mahd", "masp","tenSP", "soluong", "dongia", "thanhtien");
        for(int i = 0; i < n; i++)
        {
            if(dsct[i].getMaHD().equalsIgnoreCase(maHD))
            {
                dsct[i].xuat();
            }
        }
    }
}
