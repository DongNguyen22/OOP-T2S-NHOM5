package LangXiTrum;

import java.util.Scanner;

public class QuanLyBanHang {
    Scanner sc= new Scanner(System.in);
    public static DanhSachConNguoi dsConNguoi = new DanhSachConNguoi();
    public QuanLyBanHang(){
        dsConNguoi.docFile();
    }
    public void menuChinh() {
        int choice;
        do {
            System.out.println("╔═══════════════════════════════════╗");
            System.out.println("║         MENU QUAN LY CHINH        ║");
            System.out.println("╠═══════════════════════════════════╣");
            System.out.println("║ 1. Quan ly san pham               ║");
            System.out.println("║ 2. Quan ly hoa don & chi tiet hd  ║");
            System.out.println("║ 3. Quan ly phieu nhap & chi tiet  ║");
            System.out.println("║ 4. Quan ly khach hang             ║");
            System.out.println("║ 5. Quan ly nhan vien              ║");
            System.out.println("║ 0. Ket thuc chuong trinh          ║");
            System.out.println("╚═══════════════════════════════════╝");
            System.out.print("-> Moi ban chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                // case 1:
                //     menuSanPham();
                //     break;
                // case 2:
                //     menuHoaDon();
                //     break;
                // case 3:
                //     menuPhieuNhap();
                //     break;
                case 4:
                    menuKhachHang();
                    break;
                case 5:
                    menuNhanVien();
                    break;
                case 0:
                    dsConNguoi.docFile();
                    System.out.println("-> Thoat chuong trinh. Tam biet!");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le, vui long thu lai!");
            }

        } while (choice != 0);
    }
    // ===================== MENU CON NHAN VIÊN =====================
    public void menuNhanVien() {
        int chon;
        do {
            System.out.println("========== MENU QUAN LY NHAN VIEN ==========");
            System.out.println("1. Xem danh sach nhan vien");
            System.out.println("2. Them nhan vien moi");
            System.out.println("3. Sua thong tin nhan vien");
            System.out.println("4. Xoa nhan vien");
            System.out.println("5. Tim nhan vien theo ten");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> dsConNguoi.xuatNhanVien();
                case 2 -> dsConNguoi.themNV();
                case 3 -> {
                    System.out.print("Nhap ma nhan vien can sua: ");
                    String maSua = sc.nextLine();
                    dsConNguoi.sua(maSua);
                }
                case 4 -> {
                    System.out.print("Nhap ma nhan vien can xoa: ");
                    String maXoa = sc.nextLine();
                    dsConNguoi.xoaNV(maXoa);
                }
                case 5 -> {
                    System.out.print("Nhap ten nhan vien can tim: ");
                    String tenNV = sc.nextLine();
                    NhanVien[] dsNV=dsConNguoi.timNvTheoTen(tenNV);
                    System.out.println("Danh sach khach hang tim thay:");
                    for(NhanVien nv : dsNV) System.out.println(nv);
                }
                case 0 -> System.out.println("Quay lai menu chinh...");
                default -> System.out.println("Lua chon khong hop le!");
            }
            System.out.println();
        } while (chon != 0);
    }

    // ===================== MENU CON KHÁCH HÀNG =====================
    public  void menuKhachHang() {
        int chon;
        do {
            System.out.println("========== MENU QUAN LY KHACH HANG ==========");
            System.out.println("1. Xem danh sach khach hang");
            System.out.println("2. Them khach hang moi");
            System.out.println("3. Sua thong tin khach hang");
            System.out.println("4. Xoa khach hang");
            System.out.println("5. Tim khach hang theo ten");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> dsConNguoi.xuatKhachHang();
                case 2 -> dsConNguoi.themKH();
                case 3 -> {
                    System.out.print("Nhap ma khach hang can sua: ");
                    String maSua = sc.nextLine();
                    dsConNguoi.suaKH(maSua);
                }
                case 4 -> {
                    System.out.print("Nhap ma khach hang can xoa: ");
                    String maXoa = sc.nextLine();
                    dsConNguoi.xoaKH(maXoa);
                }
                case 5 -> {
                    System.out.print("Nhap ten khach hang can tim: ");
                    String tenKH = sc.nextLine();
                    KhachHang[] dskh=dsConNguoi.timKhTen(tenKH);
                    System.out.println("Danh sach khach hang tim thay:");
                    for(KhachHang kh : dskh) System.out.println(kh);
                }
                case 0 -> System.out.println("Quay lai menu chinh...");
                default -> System.out.println("Lua chon khong hop le!");
            }
            System.out.println();
        } while (chon != 0);
    }
}
