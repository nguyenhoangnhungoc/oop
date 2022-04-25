package tieccuoi;

import java.util.Scanner;

public class DichVu {
    private static int dem=0;
    private String idDv;
    private String tenDv;
    private String giaDv;
    final Scanner s = new Scanner(System.in);

    {
        idDv = String.format("%05d", ++dem);
    }

    public DichVu(String tenDv, String giaDv) {
        this.tenDv = tenDv;
        this.giaDv = giaDv;
    }

    public DichVu(){

    }

    public void xuatDv(){
        System.out.printf("Mã dịch vụ: %s\n", this.idDv);
        System.out.printf("Tên dịch vụ: %s\n", this.tenDv);
        System.out.printf("Giá dịch vụ: %s\n", this.giaDv);
    }

    public void nhapDv(){
        System.out.println("Nhập tên dịch vụ: ");
        this.tenDv = s.nextLine();
        System.out.println("Nhập giá dịch vụ: ");
        this.giaDv = s.nextLine();
    }

    public String getIdDv() {
        return idDv;
    }

    public void setIdDv(String idDv) {
        this.idDv = idDv;
    }

    public String getTenDv() {
        return tenDv;
    }

    public void setTenDv(String tenDv) {
        this.tenDv = tenDv;
    }

    public String getGiaDv() {
        return giaDv;
    }

    public void setGiaDv(String giaDv) {
        this.giaDv = giaDv;
    }
}
