package LangXiTrum;

public class ThucAn extends SanPham{
    private String doGion;
    private String giaVi;
    public ThucAn(String maSP, String tenSP, double donGia, String dvt, String maLoai, String doGion, String giaVi) {
        super(maSP, tenSP, donGia, dvt, maLoai);
        this.doGion = doGion;
        this.giaVi = giaVi;
    }
    //constructor de doc file
    public ThucAn( String maLoai, String maSP, String tenSP,int soLuong, double donGia, String dvt, String doGion, String giaVi) {
        super(maSP, tenSP, donGia, dvt, maLoai,soLuong);
        this.doGion = doGion;
        this.giaVi = giaVi;
    }
    public ThucAn() {
    }
    //getter
    public String getDoGion() {
        return this.doGion;
    }
    public String getGiaVi() {
        return this.giaVi;
    }
    //setter
    public void setDoGion(String doGion) {
        this.doGion = doGion;
    }
    public void setGiaVi(String giaVi) {
        this.giaVi = giaVi;
    }
    
    //nhap
    public void nhap(){
        System.out.println("Nhap ma san pham");
        this.maSP=sc.nextLine();
        System.out.println("nhap ma loai ");
        this.maLoai=sc.nextLine();
        System.out.println("nhap ten san pham ");
        this.tenSP=sc.nextLine();
        System.out.println("nhap don gia ");
        this.donGia=sc.nextDouble();
        sc.nextLine();
        System.out.println("nhap don vi tinh ");
        this.dvt=sc.nextLine();
        System.out.println("ban muon san pham co do gion nhu the nao ");
        this.doGion=sc.nextLine();
        System.out.println("Ban muon gia vi nhu the nao ");
        this.giaVi=sc.nextLine();
    }
    @Override
public String toString() {
    return String.format(
        "%-8s | %-25s | %10.0f | %-8s | %8d | %-8s | %-10s | %-10s",
        maSP, tenSP, donGia, dvt, soLuong, maLoai, doGion, giaVi
    );
}

}

