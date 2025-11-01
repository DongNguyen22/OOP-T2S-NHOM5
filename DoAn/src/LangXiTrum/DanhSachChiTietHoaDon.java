package LangXiTrum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class DanhSachChiTietHoaDon implements XuLiDuLieu {
    private ChiTietHoaDon[] dsct;
    
    @Override
    public void xuat() {
        for (ChiTietHoaDon chiTietHoaDon : dsct) {
            chiTietHoaDon.hienThi();
        }
    }
    @Override
    public void docFile() {
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream("ChiTietHoaDon.txt"), "UTF-8"))) {
                dsct = new ChiTietHoaDon[0];
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
                    dsct = Arrays.copyOf(dsct, size+1);
                    dsct[size++] = new ChiTietHoaDon(maHD, maSP, tenSP, soLuong, donGia);
                }
            }
            System.out.println("Doc du lieu chi tiet hoa don thanh cong");
        } catch (IOException e) {
            System.out.println("loi doc file: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("khong tim thay thu muc chi tiet hoa don");
        }
    }

    @Override
    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream("ChiTietHoaDon.txt", false), "UTF-8"))) {
            for (ChiTietHoaDon chiTietHoaDon : dsct) {
                String line = chiTietHoaDon.getMaHD() + ";" +
                          chiTietHoaDon.getMaSP() + ";" +
                          chiTietHoaDon.getTenSP() + ";" +
                          chiTietHoaDon.getSoLuong() + ";" +
                          chiTietHoaDon.getDonGia() ;
            bw.write(line);
            bw.newLine();
        }
        System.out.println("Da ghi moi toan bo du lieu vao file ChiTietHoaDon.txt!");
    } catch (IOException e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
    }
    @Override
    public void nhap(int n) {
    }
    @Override
    public void them() {
    }
    @Override
    public void sua(String key) {
    }
    @Override
    public void xoa(String key) {
    }
}
