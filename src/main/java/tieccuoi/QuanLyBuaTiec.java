package tieccuoi;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class QuanLyBuaTiec {
    private List<BuaTiec> ds = new ArrayList<>();
    private int[] count;
    final Scanner scanner = new Scanner(System.in);
    public static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");


    public void themBuaTiec(BuaTiec bt) {
        this.getDs().add(bt);
    }

    public void xuatSoLanSuDung() throws FileNotFoundException {
        QuanLySanhCuoi quanLySanhCuoi = new QuanLySanhCuoi();
        quanLySanhCuoi.docDsSanh();
        List<SanhCuoi> dsSanhCuoi = quanLySanhCuoi.getDs();
        this.count = new int[dsSanhCuoi.size()];
        Arrays.fill(this.count, 0);
        for (int i = 0; i < dsSanhCuoi.size(); i++) {
            SanhCuoi sanhCuoi = dsSanhCuoi.get(i);
            for (int j = 0; j < this.ds.size(); j++) {
                BuaTiec buaTiec = this.ds.get(j);
                if (sanhCuoi.getTenSanh().equals(buaTiec.getSanhCuoi().getTenSanh())) {
                    count[i]++;
                }
            }
        }
        final List<SanhCuoi> newSanhCuoi = (dsSanhCuoi);
        ArrayList<SanhCuoi> sortedList = new ArrayList(newSanhCuoi);
        Collections.sort(sortedList, Comparator.comparing(s -> count[newSanhCuoi.indexOf(s)]));
        Collections.reverse(sortedList);
        System.out.println("==DANH SÁCH SẢNH THEO TẦN SỐ SỬ DỤNG GIẢM DẦN==");
        for (SanhCuoi sanhCuoi : sortedList) {
            System.out.print(sanhCuoi.getTenSanh());
            for (int i = 0; i < dsSanhCuoi.size(); i++) {
                SanhCuoi item = dsSanhCuoi.get(i);
                if (item == sanhCuoi) {
                    System.out.print(" được thuê " + count[i] + " lần\n");
                }
            }
        }
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
                SanhCuoi tenS = new SanhCuoi();
                QuanLySanhCuoi quanLySanhCuoi = new QuanLySanhCuoi();
                quanLySanhCuoi.docDsSanh();
                String sanhSelected;
                sanhSelected = scanner.nextLine();
                for (SanhCuoi s : quanLySanhCuoi.getDs()) {
                    if (sanhSelected.equals(s.getTenSanh()))
                        tenS = s;
                }
                ThoiGianThue tgt = ThoiGianThue.valueOf(scanner.nextLine());
                Date nt = F.parse(scanner.nextLine());
                BuaTiec bt = new BuaTiec(tenBt, tenS, tgt, nt);
                this.ds.add(bt);
            }
        }
    }

    public void traCuuSanhTheoNam() throws ParseException, FileNotFoundException {
        int nam;
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Vietnam"));
        List<BuaTiec> kq = new ArrayList<>();
        System.out.println("Nhập năm muốn tra cứu: ");
        nam = scanner.nextInt();
        for (BuaTiec bt : this.ds) {
            cal.setTime(bt.getNgayThue());
            int year = cal.get(Calendar.YEAR);
            if (year == nam)
                kq.add(bt);
        }

        if (kq.size() == 0)
            System.out.printf("Không sảnh nào được thuê trong năm %s", nam);

        for (BuaTiec buaTiec : kq) {
            System.out.println(buaTiec.getSanhCuoi().getTenSanh());
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
            writer.write(bt.getNgayThue() + "\n");
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
        for (int i = 0; i < this.ds.size(); i++) {
            BuaTiec bt = this.ds.get(i);
            if (bt.getTenBuaTiec().contains(tuKhoa)) {
                kq.add(bt);
                break;
            }
            if (kq.size() == 0)
                System.out.println("Không tìm thấy bữa tiệc " + tuKhoa);
        }
        return kq;
    }

    public List<BuaTiec> getDs() {
        return ds;
    }

    public void setDs(List<BuaTiec> ds) {
        this.ds = ds;
    }
}
