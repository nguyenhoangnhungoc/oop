package tieccuoi;

import java.util.Scanner;

public abstract class ThucPham {
    private static int dem = 0;
    private String idTp ;
    private String tenTp;
    private String giaTp;
    final Scanner s = new Scanner(System.in);


    {
        idTp = "F" + String.format("%05d", ++dem);
    }

    public ThucPham(String tenTp, String giaTp){
        this.tenTp = tenTp;
        this.giaTp = giaTp;
    }

    public ThucPham(){
    }

    public void xuatTp(){
        System.out.printf("Mã Món: %s\n", this.idTp);
        System.out.printf("Tên Món: %s\n", this.tenTp);
        System.out.printf("Giá món: %s\n", this.giaTp);
    }

    public void nhapTp(){
        System.out.println("Nhập tên thực phẩm: ");
        this.tenTp = s.nextLine();
        System.out.println("Nhập giá thực phẩm: ");
        this.giaTp = s.nextLine();
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
