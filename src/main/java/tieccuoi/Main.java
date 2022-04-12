package tieccuoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        SanhCuoi s1 = new SanhCuoi("Sanh 1", "Tret Khu A", 500);
        SanhCuoi s2 = new SanhCuoi("Sanh 2", "Tret Khu B", 1000);
        SanhCuoi s3 = new SanhCuoi();

        QuanLySanhCuoi ql = new QuanLySanhCuoi();

        s1.xuatSanh();
        s2.xuatSanh();
        ql.themSanhCuoi(s1);
        ql.themSanhCuoi(s2);

        System.out.println("DANH SACH SANH CUOI");
//        ql.docDsSanh("src/main/resource/sanhCuoi.txt");
        ql.xuatSanh();

        System.out.println("DANH SACH TIM KIEM");
        List<SanhCuoi> kq = ql.timKiem("2");
        kq.forEach(s -> s.xuatSanh());

    }
}