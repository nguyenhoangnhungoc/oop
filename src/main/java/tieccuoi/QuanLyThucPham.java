package tieccuoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyThucPham {
    private List<ThucPham> ds = new ArrayList<>();
    final Scanner scanner = new Scanner(System.in);

    private double donGiaMenu;

    public void themThucPham(ThucPham tp) {
        this.getDs().add(tp);
    }

    public void xuatThucPham(List<ThucPham> thucPhams) {
        thucPhams.forEach(tp -> tp.xuatTp());
    }

    public void docDsThucAn() throws FileNotFoundException {

        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        File f = new File(path + "\\src\\main\\resources\\thucAn.txt");
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String tenTp = scanner.nextLine();
                String giaTp = scanner.nextLine();
                boolean chay = Boolean.valueOf(scanner.nextLine());
                ThucPham tp = new ThucAn(tenTp, giaTp, chay);
                this.ds.add(tp);
            }
        }
    }

    public void docDsThucUong() throws FileNotFoundException {

        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        File f = new File(path + "\\src\\main\\resources\\thucUong.txt");
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String tenTp = scanner.nextLine();
                String giaTp = scanner.nextLine();
                String nhaSx = scanner.nextLine();
                ThucPham tp = new ThucUong(tenTp, giaTp, nhaSx);
                this.ds.add(tp);
            }
        }
    }

    public void xoaThucPham() {
        String tenThucPham;

        System.out.println("Nhập tên sảnh xoá: ");
        tenThucPham = scanner.nextLine();
        Boolean isDeleted = false;
        for (ThucPham tp : this.ds) {
            if (tp.getTenTp().contains(tenThucPham) == true) {
                this.ds.remove(tp);
                System.out.println("Xóa thành công!");
                isDeleted = true;
            }
        }
        if (!isDeleted)
            System.out.printf("Không tìm thấy thực phẩm %s để xóa\n", tenThucPham);
    }

    public List<ThucPham> timKiem() {
        List<ThucPham> kq = new ArrayList<>();
        String tuKhoa;

        System.out.printf("Nhập tên thực phẩm: ");
        tuKhoa = scanner.next();
        for (ThucPham tp : this.ds)
            if (tp.getTenTp().contains(tuKhoa) || tp.getGiaTp().contains(tuKhoa))
                kq.add(tp);
        if (kq.size() == 0)
            System.out.println("Không tìm thấy thực phẩm " + tuKhoa);
        return kq;
    }

    public void capNhatThucAn() throws IOException {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        File tempFile1 = new File(path + "\\src\\main\\resources\\temp.txt");
        tempFile1.getParentFile().mkdirs();
        FileWriter writer = new FileWriter(tempFile1);
        for (ThucPham tp : this.ds) {
                if( tp instanceof ThucAn) {
                writer.write(tp.getTenTp() + "\n");
                writer.write(tp.getGiaTp() + "\n");
                writer.write(((ThucAn) tp).isChay()+"\n");
            }
        }
        writer.close();
        File oldFile = new File(path + "\\src\\main\\resources\\thucAn.txt");
        oldFile.delete();
        tempFile1.renameTo(oldFile);
    }

    public void capNhatThucUong() throws IOException {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        File tempFile2 = new File(path + "\\src\\main\\resources\\temp.txt");
        tempFile2.getParentFile().mkdirs();
        FileWriter writer = new FileWriter(tempFile2);
        for (ThucPham tp : this.ds) {
            if( tp instanceof ThucAn) {
                writer.write(tp.getTenTp() + "\n");
                writer.write(tp.getGiaTp() + "\n");
                writer.write(((ThucAn) tp).isChay()+"\n");
            }
        }
        writer.close();
        File oldFile = new File(path + "\\src\\main\\resources\\thucUong.txt");
        oldFile.delete();
        tempFile2.renameTo(oldFile);
    }

    public List<ThucPham> getDs() {
        return ds;
    }

    public void setDs(List<ThucPham> ds) {
        this.ds = ds;
    }
}
