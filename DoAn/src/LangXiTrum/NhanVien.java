package LangXiTrum;

public class NhanVien extends ConNguoi {
    //thuoc tinh
    public String maNV;
    public String chucVu;
    public double luongCB=3000;
    //constructor
    public NhanVien(String maNV,String ten, String gtinh, String sdt, String diachi,String chucVu) {
        super(ten, gtinh, sdt, diachi);
        this.maNV=maNV;
        this.chucVu=chucVu;
    }
    public NhanVien(){

    }
    //copy constructor 
    public NhanVien(NhanVien x){
        super(x);
        this.maNV=x.maNV;
        this.chucVu=x.chucVu;
    }
    //tinh luong
   public double tinhLuong() {
        if (this.chucVu.equalsIgnoreCase("NV")) {
            return luongCB;
        } else if (this.chucVu.equalsIgnoreCase("QL")) {
            return luongCB *1.05;
        } else {
            return luongCB; 
        }
    }
    @Override
    public void nhap(){
        super.nhap();
        System.out.println("Nhap ma nhan vien");
        this.maNV=sc.nextLine();
        System.out.println("nhap chuc vu");
        this.chucVu=sc.nextLine();
    }
    
   @Override
   public String toString() {
    return "manv:"+maNV+" ten: "+ten+" gtinh: "+gtinh+" sdt: "+sdt+" chucvu: "+chucVu+" dia chi: "+diaChi+" luong: "+tinhLuong();
   }
   //getter
   public String getMaNV() {
    return this.maNV;
   }
   public String getChucVu() {
    return this.chucVu;
   }
   //setter
   public void setMaNV(String maNV) {
    this.maNV = maNV;
   }
   public void setChucVu(String chucVu) {
    this.chucVu = chucVu;
   }
}
