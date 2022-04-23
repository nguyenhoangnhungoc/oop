package tieccuoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyDichVu {
    private List<DichVu> ds = new ArrayList<>();

    public void themDichVu(DichVu dv) {
        this.getDs().add(dv);
    }

    public void xuatDichVu() {
        this.getDs().forEach(dv -> dv.xuatDv());
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

    public List<DichVu> getDs() {
        return ds;
    }

    public void setDs(List<DichVu> ds) {
        this.ds = ds;
    }
}
