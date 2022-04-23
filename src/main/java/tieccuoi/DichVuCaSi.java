package tieccuoi;

public class DichVuCaSi extends DichVu{
    private String tenCaSi;
    private SoBaiHat soBaiHat;

    public DichVuCaSi(String tenDv, String giaDv, String tenCaSi, SoBaiHat soBaiHat) {
        super(tenDv, giaDv);
        this.tenCaSi = tenCaSi;
        this.soBaiHat = soBaiHat;
    }

    @Override
    public void xuatDv() {
        super.xuatDv();
        System.out.printf("Tên ca sĩ: %s\n", this.tenCaSi);
        System.out.printf("Số lượng bài hát yêu cầu: %s\n", this.soBaiHat);
    }

    @Override
    public void nhapDv() {
        super.nhapDv();
        System.out.println("Nhập tên ca sĩ: ");
        this.tenCaSi = s.nextLine();
    }

    public String getTenCaSi() {
        return tenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        this.tenCaSi = tenCaSi;
    }

    public SoBaiHat getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(SoBaiHat soBaiHat) {
        this.soBaiHat = soBaiHat;
    }
}
