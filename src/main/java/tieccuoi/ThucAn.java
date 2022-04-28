package tieccuoi;

public class ThucAn extends ThucPham {
    private static int dem = 0;
    private boolean isChay;

    public ThucAn(String tenF, String giaF, boolean chay) {
        super(tenF, giaF);
        this.setIdTp("F" + String.format("%05d", ++dem));
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
        System.out.printf("Có phải món chay không?");
        this.isChay = s.hasNext();
    }

    public boolean isChay() {
        return isChay;
    }

    public void setChay(boolean chay) {
        isChay = chay;
    }
}
