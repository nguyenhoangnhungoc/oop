package tieccuoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyDichVu {
    private List<DichVu> ds = new ArrayList<>();
    final Scanner scanner = new Scanner(System.in);

    public void themDichVu(DichVu dv) {
        this.getDs().add(dv);
    }

    public void xuatDichVu(List<DichVu> dichVus) {
        dichVus.forEach(dv -> dv.xuatDv());
    }

    public void docDsDichVu() throws FileNotFoundException {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        File f = new File(path + "\\src\\main\\resources\\dichVu.txt");
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String tenDv = scanner.nextLine();
                String giaDv = scanner.nextLine();
                DichVu dv = new DichVu(tenDv, giaDv);
                this.ds.add(dv);
            }
        }
    }

    public void capNhat() throws IOException {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        File tempFile = new File(path + "\\src\\main\\resources\\temp.txt");
        tempFile.getParentFile().mkdirs();
        FileWriter writer = new FileWriter(tempFile);
        for (DichVu dv : this.ds) {
            writer.write(dv.getTenDv() + "\n");
            writer.write(dv.getGiaDv() + "\n");
        }
        writer.close();
        File oldFile = new File(path + "\\src\\main\\resources\\dichVu.txt");
        oldFile.delete();
        tempFile.renameTo(oldFile);
    }

    public List<DichVu> timKiem() {
        List<DichVu> kq = new ArrayList<>();
        String tuKhoa;

        System.out.println("Nhập tên dịch vụ: ");
        tuKhoa = scanner.nextLine();
        for (DichVu dv : this.ds)
            if (dv.getTenDv().contains(tuKhoa))
                kq.add(dv);
        if (kq.size() == 0)
            System.out.println("Không tìm thấy dịch vụ " + tuKhoa);
        return kq;
    }

    public void xoaDichVu() {
        String tenDichVuXoa;

        System.out.println("Nhập tên dịch vụ xoá: ");
        tenDichVuXoa = scanner.nextLine();
        Boolean isDeleted = false;
        for ( int i = 0;i < this.ds.size(); i ++ ) {
            DichVu dv = this.ds.get(i);
            if (dv.getTenDv().contains(tenDichVuXoa) == true) {
                this.ds.remove(dv);
                System.out.println("Xóa thành công!");
                isDeleted = true;
            }
        }
        if (!isDeleted)
            System.out.printf("Không tìm thấy dịch vụ %s để xóa\n", tenDichVuXoa);
    }

    public List<DichVu> getDs() {
        return ds;
    }

    public void setDs(List<DichVu> ds) {
        this.ds = ds;
    }
}
