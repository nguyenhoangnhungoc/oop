package tieccuoi;

public class DichVuKaraoke extends DichVu{
    private int thoiGianThue;

    public DichVuKaraoke(String tenDv, String giaDv, int thoiGianThue) {
        super(tenDv, giaDv);
        this.thoiGianThue = thoiGianThue;
    }

    public DichVuKaraoke(){
        super();
    }

    @Override
    public void xuatDv() {
        super.xuatDv();
        System.out.printf("Thời gian thuê: %s\n", this.thoiGianThue);
    }

    @Override
    public void nhapDv() {
        super.nhapDv();
        System.out.println("Nhập thời gian thuê: ");
        this.thoiGianThue = s.nextInt();
    }

    public int getThoiGianThue() {
        return thoiGianThue;
    }

    public void setThoiGianThue(int thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }
}
