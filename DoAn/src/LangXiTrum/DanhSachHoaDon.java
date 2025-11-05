package LangXiTrum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachHoaDon {
    HoaDon[] dshd = new HoaDon[0];
    int n;
    Scanner sc = new Scanner(System.in);

    public DanhSachHoaDon() {
    }

    public DanhSachHoaDon(int n, HoaDon[] dshd) {
        this.n = n;
        this.dshd = Arrays.copyOf(dshd, n);

    }

    public void nhap(){
        System.out.print("nhap vao so luong hoa don:");
        n=sc.nextInt();
        sc.nextLine();
        dshd =new HoaDon[n];
        for(int i = 0;i < n ; i++){
            dshd[i]=new HoaDon();
            dshd[i].nhap();

        }
    }

    public HoaDon[] getAll() {
        return Arrays.copyOf(dshd, n + 1);

    }

    public void them(HoaDon hd) {
        dshd = Arrays.copyOf(dshd, n + 1);
        dshd[n] = hd;
        n++;
    }

    public HoaDon TimKiemmaHD(String ma) {
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMaNV().equalsIgnoreCase(ma)) {
                return dshd[i];
            }
        }
        return null;
    }

    public HoaDon[] TimKiemmaNV(String ma) {
        HoaDon[] result = new HoaDon[0];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMaNV().equalsIgnoreCase(ma)) {
                result = Arrays.copyOf(result, index + 1);
                result[index] = dshd[i];
                index++;

            }
        }

        if (index == 0) {
            return new HoaDon[0];
        }
        return result;
    }

    public HoaDon[] TimmaKH(String ma) {
    HoaDon[] result = new HoaDon[0];
    int index = 0;
    for (int i = 0; i < n; i++) {
        if (dshd[i].getMaKH().equalsIgnoreCase(ma)) {
            result = Arrays.copyOf(result, index + 1);
            result[index] = dshd[i];
            index++;
        }
    }
    return result; 
}


    public void XoaHD(String ma) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMaHD().equalsIgnoreCase(ma)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.print("null");
            return;
        }
        for (int i = index; i < n - 1; i++) {
            dshd[i] = dshd[i + 1];
        }
        dshd = Arrays.copyOf(dshd, n - 1);
        n--;
    }

    public int timNV(String[] arr, int size, String maNV) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equalsIgnoreCase(maNV)) {
                return i;
            }
        }
        return -1;

    }
    public void xuat(){
        System.out.printf("%-10s %-10s %-10s %-12s\n",
         "maHD","maNV", "maKH","NgayLap");
         for(int i=0;i<n;i++){
            dshd[i].xuat();
         }

        }
        

}
