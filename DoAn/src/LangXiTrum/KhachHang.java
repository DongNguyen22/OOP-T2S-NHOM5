package LangXiTrum;

public class KhachHang extends ConNguoi{
    private String maKH;
    //constructor
    public KhachHang() {
    }
    public KhachHang(String ten, String gtinh, String sdt, String diaChi,
     String maKH) {
        super(ten, gtinh, sdt, diaChi);
        this.maKH = maKH;
    }
    //copy constructor
    public KhachHang(KhachHang x){
        super(x);
        this.maKH=x.maKH;
    }
    //nhap thong tin cho 1 khach hang
    @Override
    public void nhap(){
        System.out.println("nhap ma khach hang");
        this.maKH=sc.nextLine();
        super.nhap();
    }
    @Override
public String toString() {
    return String.format("%-10s %-20s %-5s %-12s %-30s",
                         maKH, ten, sdt, gtinh, diaChi);
}

    //getter
    public String getMaKH() {
        return this.maKH;
    }
    //setter
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
}
    
