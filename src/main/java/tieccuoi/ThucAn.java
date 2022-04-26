package tieccuoi;

public class ThucAn extends ThucPham {
    private boolean isChay;

    public ThucAn(String tenF, String giaF, boolean chay) {
        super(tenF, giaF);
        this.isChay = chay;
    }

    public ThucAn() {
    }

    public void xuatTp() {
        super.xuatTp();
        if (!this.isChay)
            System.out.println("Món mặn");
        else
            System.out.println("Món chay");
    }

    public void nhapTp() {
        super.nhapTp();
        System.out.printf("Có phải món chay khum?");
        this.isChay = s.hasNext();
    }

    public boolean isChay() {
        return isChay;
    }

    public void setChay(boolean chay) {
        isChay = chay;
    }
}
