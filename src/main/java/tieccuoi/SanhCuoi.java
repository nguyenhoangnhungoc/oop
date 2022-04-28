package tieccuoi;

import java.util.Scanner;

public class SanhCuoi{
    private String tenSanh;
    private String idSanh;
    private static int dem = 0;
    private String viTri;
    private int sucChua;
    final Scanner s = new Scanner(System.in);

    public SanhCuoi(String tenS, String vt, int nguoiChua){
        this.idSanh = "S" + String.format("%05d", ++dem);
        this.tenSanh = tenS;
        this.viTri = vt;
        this.sucChua = nguoiChua;
    }

    public SanhCuoi(){
    }

    public void nhapSanh(){
        System.out.printf("Nhập tên sảnh: ");
        this.tenSanh = s.nextLine();
        System.out.printf("Nhập vị trí sảnh: ");
        this.viTri = s.nextLine();
        System.out.printf("Nhập sức chứa: ");
        this.sucChua = s.nextInt();
    }

    public void xuatSanh(){
        System.out.printf("Mã Sảnh: %s\n", this.idSanh);
        System.out.printf("Tên Sảnh: %s\n", this.tenSanh);
        System.out.printf("Vị Trí Sảnh: %s\n", this.viTri);
        System.out.printf("Sức chứa: %d\n", this.sucChua);
    }

    public static int getDem() {
        return dem;
    }

    public static void setDem(int dem) {
        SanhCuoi.dem = dem;
    }

    public String getTenSanh() {
        return tenSanh;
    }

    public void setTenSanh(String tenSanh) {
        this.tenSanh = tenSanh;
    }

    public String getIdSanh() {
        return idSanh;
    }

    public void setIdSanh(String idSanh) {
        this.idSanh = idSanh;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }
}
