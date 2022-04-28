package tieccuoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class QuanLyBuaTiec {
    private List<BuaTiec> ds = new ArrayList<>();
    final Scanner scanner = new Scanner(System.in);
    public static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");


    public void themBuaTiec(BuaTiec bt) {
        this.getDs().add(bt);
    }

    public void xuatBuaTiec(List<BuaTiec> buaTiecs) {
        buaTiecs.forEach(s -> s.xuatBuaTiec());
    }

    public void docDsBuaTiec() throws FileNotFoundException, ParseException {

        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        File f = new File(path + "\\src\\main\\resources\\buaTiec.txt");
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String tenBt = scanner.nextLine();
                SanhCuoi tenS = null;
                QuanLySanhCuoi quanLySanhCuoi = new QuanLySanhCuoi();
                quanLySanhCuoi.docDsSanh();
                String sanhSelected;
                sanhSelected = scanner.nextLine();
                for (SanhCuoi s : quanLySanhCuoi.getDs()) {
                    if (sanhSelected.equals(s.getIdSanh()))
                        tenS = s;
                }
                ThoiGianThue tgt = ThoiGianThue.valueOf(scanner.nextLine());
                Date nt = F.parse(scanner.nextLine());
                BuaTiec bt = new BuaTiec(tenBt, tenS, tgt, nt);
                this.ds.add(bt);
            }
        }
    }

    public void xoaBuaTiec() {
        String tenTiecXoa;

        System.out.println("Nhập tên tiệc xoá: ");
        tenTiecXoa = scanner.nextLine();
        Boolean isDeleted = false;
        for (BuaTiec bt : this.ds) {
            if (bt.getTenBuaTiec().contains(tenTiecXoa) == true) {
                this.ds.remove(bt);
                System.out.println("Xóa thành công!");
                isDeleted = true;
                break;
            }
        }
        if (!isDeleted)
            System.out.printf("Không tìm thấy bữa tiệc %s để xóa\n", tenTiecXoa);
    }

    public void capNhat() throws IOException {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        File tempFile = new File(path + "\\src\\main\\resources\\temp.txt");
        tempFile.getParentFile().mkdirs();
        FileWriter writer = new FileWriter(tempFile);
        for (BuaTiec bt : this.ds) {
            writer.write(bt.getTenBuaTiec() + "\n");
            writer.write(bt.getSanhCuoi().getTenSanh() + "\n");
            writer.write(bt.getThoiGianThue().value + "\n");
        }
        writer.close();
        File oldFile = new File(path + "\\src\\main\\resources\\buaTiec.txt");
        oldFile.delete();
        tempFile.renameTo(oldFile);
    }

    public List<BuaTiec> timKiem() {
        List<BuaTiec> kq = new ArrayList<>();
        String tuKhoa;

        System.out.println("Nhập tên bữa tiệc: ");
        tuKhoa = scanner.nextLine();
        for (BuaTiec bt : this.ds)
            if (bt.getTenBuaTiec().contains(tuKhoa))
                kq.add(bt);
        if (kq.size() == 0)
            System.out.println("Không tìm thấy bữa tiệc " + tuKhoa);
        return kq;
    }

    public List<BuaTiec> getDs() {
        return ds;
    }

    public void setDs(List<BuaTiec> ds) {
        this.ds = ds;
    }
}
