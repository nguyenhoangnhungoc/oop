package tieccuoi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySanhCuoi {
    private List<SanhCuoi> ds = new ArrayList<>();
    final Scanner scanner = new Scanner(System.in);

    public void themSanhCuoi(SanhCuoi s) {
        this.ds.add(s);
    }

    public void xuatSanh() {
        this.ds.forEach(s -> s.xuatSanh());
    }

    public void docDsSanh() throws FileNotFoundException {

        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        File f = new File(path + "\\src\\main\\resources\\sanhCuoi.txt");
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String tenS = scanner.nextLine();
                String vt = scanner.nextLine();
                int nguoiChua = Integer.valueOf(scanner.nextLine());
                SanhCuoi s = new SanhCuoi(tenS, vt, nguoiChua);
                this.ds.add(s);
            }
        }
    }

    public void xoaSanh() {
        String tenSanhXoa;

        System.out.println("Nhập tên sảnh xoá: ");
        tenSanhXoa = scanner.nextLine();
        for (SanhCuoi s : this.ds)
            if (s.getTenSanh().contains(tenSanhXoa) == true) {
                this.ds.remove(s);
                System.out.println("Xóa thành công!");
                break;
            } else
                System.out.printf("Không tìm thấy sảnh %s để xóa\n", tenSanhXoa);
    }

    public void capNhat() throws IOException {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        File tempFile = new File(path + "\\src\\main\\resources\\temp.txt");
        tempFile.getParentFile().mkdirs();
        FileWriter writer = new FileWriter(tempFile);
        for (SanhCuoi s : this.ds) {
            writer.write(s.getTenSanh() + "\n");
            writer.write(s.getViTri() + "\n");
            writer.write(s.getSucChua() + "\n");
        }
        writer.close();
        File oldFile = new File(path + "\\src\\main\\resources\\sanhCuoi.txt");
        oldFile.delete();
        tempFile.renameTo(oldFile);
    }

    public List<SanhCuoi> timKiem() {
        List<SanhCuoi> kq = new ArrayList<>();
        String tuKhoa;

        System.out.println("Nhập tên sảnh hoặc vị trí hoặc sức chứa: ");
        tuKhoa = scanner.nextLine();
        for (SanhCuoi s : this.ds)
            if (s.getTenSanh().contains(tuKhoa) || s.getViTri().contains(tuKhoa) || String.valueOf(s.getSucChua()).contains(tuKhoa))
                kq.add(s);
        if (kq.size() == 0)
            System.out.println("Không tìm thấy sảnh " + tuKhoa);
        return kq;
    }

    public List<SanhCuoi> traCuuSanh(){
        List<SanhCuoi> traCuu = new ArrayList<>();
        String tuKhoa = new String();

        System.out.println("Nhâp tên sảnh hoặc vị trí hoặc sức chứa: ");
        tuKhoa = scanner.nextLine();
        for(SanhCuoi s : this.ds){
            if(s.getTenSanh().contains(tuKhoa) || s.getViTri().contains(tuKhoa) || String.valueOf(s.getSucChua()).contains(tuKhoa))
                traCuu.add(s);
        }if (traCuu.size() == 0)
            System.out.println("Không tìm thấy sảnh " + tuKhoa);
        return traCuu;
    }

    public List<SanhCuoi> getDs() {
        return ds;
    }

    public void setDs(List<SanhCuoi> ds) {
        this.ds = ds;
    }
}
