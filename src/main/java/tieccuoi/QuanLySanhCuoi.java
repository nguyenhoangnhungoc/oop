package tieccuoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuanLySanhCuoi {
    private List<SanhCuoi> ds = new ArrayList<>();

    public void themSanhCuoi(SanhCuoi s){
        this.ds.add(s);
    }

    public void xuatSanh(){
        this.ds.forEach(s -> s.xuatSanh());
    }

    public void docDsSanh(String tapTin) throws FileNotFoundException, ParseException{
            File f = new File(tapTin);
            try (Scanner scanner = new Scanner(f)){
                while (scanner.hasNext()){
                    String tenS = scanner.nextLine();
                    String viTri = scanner.nextLine();
                    int banChua = scanner.nextByte();

                    SanhCuoi s = new SanhCuoi(tenS, viTri, banChua);
                    this.ds.add(s);
                }
            }
    }

    public SanhCuoi timKiem(int idS){
        return this.ds.stream().filter(s -> s.getIdSanh() == idS).findFirst().get();
//        for(SanhCuoi s : this.ds)
//            if(s.getIdSanh() == idS)
//                return s;
//        return null;
    }

    public List<SanhCuoi> timKiem(String tuKhoa){
        return this.ds.stream().filter(s -> s.getTenSanh().contains(tuKhoa) == true ||
                s.getViTri().contains(tuKhoa) == true).collect(Collectors.toList());
//        List<SanhCuoi> kq = new ArrayList<>();
//
//        for(SanhCuoi s : this.ds)
//            if(s.getTenSanh().contains(tuKhoa) == true || s.getViTri().contains(tuKhoa) == true) {
//                kq.add(s);
//            }else
//                System.out.println("Khong co Sanh " + tuKhoa);
//        return kq;
    }

    public List<SanhCuoi> getDs() {
        return ds;
    }

    public void setDs(List<SanhCuoi> ds) {
        this.ds = ds;
    }
}