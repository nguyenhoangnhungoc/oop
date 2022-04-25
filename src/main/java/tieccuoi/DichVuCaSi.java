package tieccuoi;

public class DichVuCaSi extends DichVu{
    private String tenCaSi;
    private int soBaiHat;

    public DichVuCaSi(String tenDv, String giaDv, String tenCaSi, int soBaiHat) {
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
        System.out.println("Nhập số lượng bài hát yêu cầu: ");
        this.soBaiHat = s.nextInt();
    }

    public String getTenCaSi() {
        return tenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        this.tenCaSi = tenCaSi;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        this.soBaiHat = soBaiHat;
    }
}
