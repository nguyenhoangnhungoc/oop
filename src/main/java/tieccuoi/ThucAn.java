package tieccuoi;

public class ThucAn extends ThucPham {
    private boolean isChay;

    public ThucAn(String tenF, String giaF, boolean chay) {
        super(tenF, giaF);
        this.isChay = chay;
    }

    public ThucAn(){
    }

    public void xuatTp() {
        super.xuatTp();
        System.out.printf("Món chay: %s\n", this.isChay);
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
