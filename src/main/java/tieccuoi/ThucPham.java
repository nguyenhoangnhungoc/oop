package tieccuoi;

public class ThucPham {
    private static int dem = 0;
    private String idTp ;
    private String tenTp;
    private String giaTp;
    private boolean isChay;

    {
       idTp = "F" + String.format("%05d", ++dem);
    }

    public ThucPham(String tenF, String giaF, boolean chay){
        this.tenTp = tenF;
        this.giaTp = giaF;
        this.isChay = chay;
    }

    public ThucPham(){
    }

    public void xuatTp(){
        System.out.printf("Mã Món: %s\n", this.idTp);
        System.out.printf("Tên Món: %s\n", this.tenTp);
        System.out.printf("Giá món: %s\n", this.giaTp);
        System.out.printf("Món chay: %s\n", this.isChay);
    }


    public boolean isIsChay() {
        return isChay;
    }

    public void setIsChay(boolean isChay) {
        this.isChay = isChay;
    }

    public String getIdTp() {
        return idTp;
    }

    public void setIdTp(String idTp) {
        this.idTp = idTp;
    }

    public String getTenTp() {
        return tenTp;
    }

    public void setTenTp(String tenTp) {
        this.tenTp = tenTp;
    }

    public String getGiaTp() {
        return giaTp;
    }

    public void setGiaTp(String giaTp) {
        this.giaTp = giaTp;
    }
}
