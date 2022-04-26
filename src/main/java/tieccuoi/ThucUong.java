package tieccuoi;

public class ThucUong extends ThucPham{
    private String nhaSX;

    public ThucUong(String tenD, String giaD, String nhaSx){
        super(tenD, giaD);
        this.nhaSX = nhaSx;
    }

    public ThucUong(){

    }

    public void xuatTp(){
        super.xuatTp();
        System.out.printf("Nhà sản xuất: %s\n", this.nhaSX);
    }

    @Override
    public void nhapTp() {
        super.nhapTp();
        System.out.printf("Nhập tên nhà sản xuất: ");
        this.nhaSX = s.nextLine();
    }

    public String getNhaSX() {
        return nhaSX;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }
}
