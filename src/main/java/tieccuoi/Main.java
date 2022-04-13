package tieccuoi;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
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
//        ql.docDsSanh();
        ql.xuatSanh();


        System.out.println("DANH SACH TIM KIEM");
        List<SanhCuoi> kq = ql.timKiem("2");
        kq.forEach(s -> s.xuatSanh());

        ThucPham f1 = new ThucPham("Pasta", "75000",false);
        ThucPham f2 = new ThucPham("Pizza", "185000",false);
        ThucPham f3 = new ThucPham("Mushroom", "50000",true);

        f1.xuatTp();
        f2.xuatTp();
        f3.xuatTp();
    }
}