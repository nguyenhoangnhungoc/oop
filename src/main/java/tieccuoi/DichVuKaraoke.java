package tieccuoi;

public class DichVuKaraoke extends DichVu{
    private ThoiGianThue thoiGianThue;

    public DichVuKaraoke(String tenDv, String giaDv, ThoiGianThue thoiGianThue) {
        super(tenDv, giaDv);
        this.thoiGianThue = thoiGianThue;
    }

    @Override
    public void xuatDv() {
        super.xuatDv();
        System.out.printf("Thời gian thuê: %s\n", this.thoiGianThue);
    }

    @Override
    public void nhapDv() {
        super.nhapDv();
    }

    public ThoiGianThue getThoiGianThue() {
        return thoiGianThue;
    }

    public void setThoiGianThue(ThoiGianThue thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }
}
