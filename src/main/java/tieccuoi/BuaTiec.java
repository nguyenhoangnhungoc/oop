package tieccuoi;

import java.io.FileNotFoundException;
import java.util.*;

public class BuaTiec {
    private String tenBuaTiec;
    private SanhCuoi sanhCuoi;
    private ThoiGianThue thoiGianThue;
    private List<ThucPham> thucPhams = new ArrayList<>();
    private List<DichVu> dichVus = new ArrayList<>();
    final Scanner s = new Scanner(System.in);


    public BuaTiec(String tenBuaTiec, SanhCuoi sanhCuoi, ThoiGianThue thoiGianThue, List<ThucPham> thucPhams, List<DichVu> dichVus) {
        this.tenBuaTiec = tenBuaTiec;
        this.sanhCuoi = sanhCuoi;
        this.thoiGianThue = thoiGianThue;
        this.thucPhams = thucPhams;
        this.dichVus = dichVus;
    }

    public BuaTiec() {

    }

    public void nhapBuaTiec() throws FileNotFoundException {
        System.out.printf("Nhập tên bữa tiệc: ");
        this.tenBuaTiec = s.nextLine();
        QuanLySanhCuoi quanLySanhCuoi = new QuanLySanhCuoi();
        quanLySanhCuoi.docDsSanh();
        for (SanhCuoi ql : quanLySanhCuoi.getDs()) {
            System.out.println(ql.getIdSanh() + "." + ql.getTenSanh());
        }
        do {
            System.out.printf("Chọn ID sảnh: ");
            String sanhSelected;
            sanhSelected = s.nextLine();
            for (SanhCuoi s : quanLySanhCuoi.getDs()) {
                if (sanhSelected.equals(s.getIdSanh()))
                    this.sanhCuoi = s;
            }
            if (this.sanhCuoi == null)
                System.out.println("Mã không hợp lệ rồi! Vui lòng nhập lại nha!");
        } while (this.sanhCuoi == null);
        for (ThoiGianThue tgt : ThoiGianThue.values()) {
            System.out.println(tgt.name() + "." + tgt.value);
        }
        do {
            System.out.printf("Chọn mã thời gian thuê: ");
            String thoiDiemThue;
            thoiDiemThue = s.nextLine();
            for (ThoiGianThue thue : ThoiGianThue.values()) {
                if (thoiDiemThue.equals(thue.name()))
                    this.thoiGianThue = thue;
            }
            if (this.thoiGianThue == null)
                System.out.println("Mã không hợp lệ rồi! Vui lòng nhập lại nha!");
        } while (this.thoiGianThue == null);
        QuanLyThucPham quanLyThucPham = new QuanLyThucPham();
        quanLyThucPham.docDsThucAn();
        quanLyThucPham.docDsThucUong();
        for (ThucPham tp : quanLyThucPham.getDs()) {
            System.out.println(tp.getIdTp() + "." + tp.getTenTp());
        }
        String luaChon;
        do {
            System.out.printf("Chọn thực phẩm cho buổi tiệc (Nhập \"Xong\" để hoàn tất): ");
            luaChon = s.nextLine();
            Boolean isValid = false;
            for (ThucPham tp : quanLyThucPham.getDs()) {
                if (luaChon.equals(tp.getIdTp())) {
                    this.thucPhams.add(tp);
                    System.out.println("Thêm thực phẩm " + tp.getTenTp() + " hoàn tất");
                    isValid = true;
                }
            }
            if (!isValid && !luaChon.toLowerCase(Locale.ROOT).equals("xong")) {
                System.out.println("Mã không hợp lệ! Vui lòng chọn lại!");
            }
        } while (!luaChon.toLowerCase(Locale.ROOT).equals("xong"));
        QuanLyDichVu quanLyDichVu = new QuanLyDichVu();
        quanLyDichVu.docDsDichVu();
        for (DichVu dv : quanLyDichVu.getDs()) {
            System.out.println(dv.getIdDv() + "." + dv.getTenDv());
        }
        String s1;
        do {
            System.out.printf("Chọn thực phẩm cho buổi tiệc (Nhập \"Xong\" để hoàn tất): ");
            s1 = s.nextLine();
            Boolean isValid = false;
            for (DichVu dv : quanLyDichVu.getDs()) {
                if (s1.equals(dv.getIdDv())) {
                    this.dichVus.add(dv);
                    System.out.println("Thêm dịch vụ " + dv.getTenDv() + " hoàn tất");
                    isValid = true;
                }
            }
            if (!isValid && !s1.toLowerCase(Locale.ROOT).equals("xong")) {
                System.out.println("Mã không hợp lệ! Vui lòng chọn lại!");
            }
        } while (!s1.toLowerCase(Locale.ROOT).equals("xong"));
    }

    public double tinhGiaTienSanh() {
        double gia = 10000000;
        if (this.sanhCuoi.getTenSanh().contains("thường"))
            gia = gia * 1;
        if (this.sanhCuoi.getTenSanh().contains("VIP"))
            gia = gia * 1.2;
        if (this.sanhCuoi.getTenSanh().contains("deluxe"))
            gia = gia * 1.5;
        if (this.sanhCuoi.getTenSanh().contains("private"))
            gia = gia * 1.7;
        if (this.thoiGianThue.name().equals("ST"))
            gia = gia * 1;
        if (this.thoiGianThue.name().equals("CT"))
            gia = gia * 1.1;
        if (this.thoiGianThue.name().equals("TT"))
            gia = gia * 1.2;
        if (this.thoiGianThue.name().equals("SCT"))
            gia = gia * 1.3;
        if (this.thoiGianThue.name().equals("CCT"))
            gia = gia * 1.5;
        if (this.thoiGianThue.name().equals("TCT"))
            gia = gia * 1.5;
        for (ThucPham tp : this.thucPhams) {
            gia += Integer.valueOf(tp.getGiaTp()) * this.sanhCuoi.getSucChua();
        }
        for (DichVu dv : this.dichVus) {
            gia += Integer.valueOf(dv.getGiaDv());
        }
        return gia;
    }

    public void xuatHoaDon() {
        System.out.println("==HOÁ ĐƠN==");
        System.out.println("Sảnh bữa tiệc: " + this.sanhCuoi.getTenSanh());
        System.out.println("Thời điểm thuê bữa tiệc: " + this.thoiGianThue.value);
        System.out.println("==DANH SÁCH THỰC PHẨM BẠN ĐÃ CHỌN==");
        for(ThucPham tp : this.thucPhams){
            System.out.println(tp.getTenTp());
            System.out.println(tp.getGiaTp() + "*" + this.sanhCuoi.getSucChua());
        }
        System.out.println("==DANH SÁCH DỊCH VỤ BẠN ĐÃ CHỌN==");
        for(DichVu dv : this.dichVus){
            System.out.println(dv.getTenDv());
            System.out.println(dv.getGiaDv());
        }
        System.out.println("==THÀNH TIỀN==");
        System.out.println(String.format("%.2f", this.tinhGiaTienSanh()));

    }

    public String getTenBuaTiec() {
        return tenBuaTiec;
    }

    public void setTenBuaTiec(String tenBuaTiec) {
        this.tenBuaTiec = tenBuaTiec;
    }

    public SanhCuoi getSanhCuoi() {
        return sanhCuoi;
    }

    public void setSanhCuoi(SanhCuoi sanhCuoi) {
        this.sanhCuoi = sanhCuoi;
    }

    public ThoiGianThue getThoiGianThue() {
        return thoiGianThue;
    }

    public void setThoiGianThue(ThoiGianThue thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }

    public List<ThucPham> getThucPhams() {
        return thucPhams;
    }

    public void setThucPhams(List<ThucPham> thucPhams) {
        this.thucPhams = thucPhams;
    }

    public List<DichVu> getDichVus() {
        return dichVus;
    }

    public void setDichVus(List<DichVu> dichVus) {
        this.dichVus = dichVus;
    }
}
