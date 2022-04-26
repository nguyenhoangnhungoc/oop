package tieccuoi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public int selection;
    Scanner s = new Scanner(System.in);

    public void quanLiSanh() throws FileNotFoundException {
        do {
//            System.out.print("\033[H\033[2J");
//            System.out.flush();
            System.out.println("===QUẢN LÝ SẢNH CƯỚI===");
            System.out.println("1. Tra cứu sảnh");
            System.out.println("2. Thêm sảnh mới");
            System.out.println("3. Xóa sảnh");
            System.out.println("4. Cập nhật danh sách sảnh");
            System.out.println("5. Xuất danh sách sảnh");
            System.out.println("6. Trở về");
            System.out.printf("Bạn chọn: ");
            selection = s.nextInt();

            QuanLySanhCuoi qlS = new QuanLySanhCuoi();
            qlS.docDsSanh();

            switch (selection) {
                case 1:
                    List<SanhCuoi> sanhCuois;
                    sanhCuois = qlS.timKiem();
                    qlS.xuatSanh(sanhCuois);
                    break;
                case 2:
                    SanhCuoi sanhCuoi = new SanhCuoi();
                    sanhCuoi.nhapSanh();
                    qlS.themSanhCuoi(sanhCuoi);
                    System.out.println("==DANH SÁCH SẢNH SAU KHI THÊM==");
                    qlS.xuatSanh(qlS.getDs());
                    break;
                case 3:
                    qlS.xoaSanh();
                    System.out.println("==DANH SÁCH SẢNH SAU KHI XÓA==");
                    qlS.xuatSanh(qlS.getDs());
                    break;
                case 4:
                    try {
                        qlS.capNhat();
                        System.out.println("Cập nhật thành công!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("==DANH SÁCH SẢNH==");
                    qlS.xuatSanh(qlS.getDs());
                    break;
            }
        } while (selection < 6 && selection > 0);

    }

    public void quanLiDichVu() throws FileNotFoundException {
        do {
//            System.out.print("\033[H\033[2J");
//            System.out.flush();
            System.out.println("===QUẢN LÝ DỊCH VỤ===");
            System.out.println("1. Tra cứu dịch vụ");
            System.out.println("2. Thêm dịch vụ mới");
            System.out.println("3. Xóa dịch vụ");
            System.out.println("4. Cập nhật danh sách dịch vụ");
            System.out.println("5. Xuất danh sách dịch vụ");
            System.out.println("6. Trở về");
            System.out.printf("Bạn chọn: ");
            selection = s.nextInt();

            QuanLyDichVu qlDv = new QuanLyDichVu();
            qlDv.docDsDichVu();

            switch (selection) {
                case 1:
                    List<DichVu> dichVus;
                    dichVus = qlDv.timKiem();
                    qlDv.xuatDichVu(dichVus);
                    break;
                case 2:
                    DichVu dichVu = new DichVu();
                    dichVu.nhapDv();
                    qlDv.themDichVu(dichVu);
                    System.out.println("==DANH SÁCH DỊCH VỤ SAU KHI THÊM==");
                    qlDv.xuatDichVu(qlDv.getDs());
                    break;
                case 3:
                    qlDv.xoaSanh();
                    System.out.println("==DANH SÁCH DỊCH VỤ SAU KHI XÓA==");
                    qlDv.xuatDichVu(qlDv.getDs());
                    break;
                case 4:
                    try {
                        qlDv.capNhat();
                        System.out.println("Cập nhật thành công!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("==DANH SÁCH DỊCH VỤ==");
                    qlDv.xuatDichVu(qlDv.getDs());
                    break;
            }
        } while (selection < 6 && selection > 0);

    }

    public void quanLiThucPham() throws FileNotFoundException {
        do {
//            System.out.print("\033[H\033[2J");
//            System.out.flush();
            System.out.println("===QUẢN LÝ THỰC PHẨM===");
            System.out.println("1. Tra cứu thực phẩm");
            System.out.println("2. Thêm thực phẩm mới");
            System.out.println("3. Xóa thực phẩm");
            System.out.println("4. Cập nhật danh sách thực phẩm");
            System.out.println("5. Xuất danh sách thực phẩm");
            System.out.println("6. Trở về");
            System.out.printf("Bạn chọn: ");
            selection = s.nextInt();

            QuanLyThucPham qlTp = new QuanLyThucPham();
            qlTp.docDsThucAn();
            qlTp.docDsThucUong();

            switch (selection) {
                case 1:
                    List<ThucPham> thucPhams;
                    thucPhams = qlTp.timKiem();
                    qlTp.xuatThucPham(thucPhams);
                    break;
                case 2:
                    do{
                        System.out.println("===THÊM THỰC PHẨM===");
                        System.out.println("1. Thêm thức ăn");
                        System.out.println("2. Thêm thức uống");
                        System.out.println("3. Trở về");
                        System.out.printf("Bạn chọn: ");
                        selection = s.nextInt();

                        switch (selection){
                            case 1:
                                ThucPham thucAn = new ThucAn();
                                thucAn.nhapTp();
                                qlTp.themThucPham(thucAn);
                                System.out.println("==DANH SÁCH THỰC PHẨM SAU KHI THÊM==");
                                qlTp.xuatThucPham(qlTp.getDs());
                                break;
                            case 2:
                                ThucPham thucUong = new ThucUong();
                                thucUong.nhapTp();
                                qlTp.themThucPham(thucUong);
                                System.out.println("==DANH SÁCH THỰC PHẨM SAU KHI THÊM==");
                                qlTp.xuatThucPham(qlTp.getDs());
                                break;
                        }
                    }while (selection > 0 && selection < 3);
                    break;
                case 3:
                    qlTp.xoaThucPham();
                    System.out.println("==DANH SÁCH THƯC PHẨM SAU KHI XÓA==");
                    qlTp.xuatThucPham(qlTp.getDs());
                    break;
                case 4:
                    do{
                        System.out.println("===CẬP NHẬT THỰC PHẨM===");
                        System.out.println("1. Cập nhật danh sách thức ăn");
                        System.out.println("2. Cập nhật danh sách thức uống");
                        System.out.println("3. Trở về");
                        System.out.printf("Bạn chọn: ");
                        selection = s.nextInt();

                        switch (selection){
                            case 1:
                                try {
                                    qlTp.capNhatThucAn();
                                    System.out.println("Cập nhật thành công!");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                try {
                                    qlTp.capNhatThucUong();
                                    System.out.println("Cập nhật thành công!");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                        }
                    }while (selection > 0 && selection < 3);


                    break;
                case 5:
                    do{
                        System.out.println("===XUẤT THỰC PHẨM===");
                        System.out.println("1. Xuất tất cả");
                        System.out.println("2. Xuất danh sách thức ăn");
                        System.out.println("3. Xuất danh sách thức uống");
                        System.out.println("4. Trở về");
                        System.out.printf("Bạn chọn: ");
                        selection = s.nextInt();

                        switch (selection){
                            case 1:
                                qlTp.xuatThucPham(qlTp.getDs());
                                break;
                            case 2:
                                for(ThucPham tp : qlTp.getDs()) {
                                    if(tp instanceof ThucAn)
                                        tp.xuatTp();
                                }
                                break;
                            case 3:
                                for(ThucPham tp : qlTp.getDs()) {
                                    if(tp instanceof ThucUong)
                                        tp.xuatTp();
                                }
                                break;
                        }
                    }while (selection > 0 && selection < 4);
            }
        } while (selection < 6 && selection > 0);

    }

    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        int selection = 0;
        Scanner s = new Scanner(System.in);

        do {
            System.out.println("===QUẢN LÝ TIỆC CƯỚI===");
            System.out.println("1. Quản lý sảnh cưới");
            System.out.println("2. Quản lý dịch vụ");
            System.out.println("3. Quản lý thực phẩm");
            System.out.println("4. Thuê sảnh");
            System.out.println("5. Báo cáo doanh thu");
            System.out.println("6. Trở về");
            System.out.printf("Bạn chọn: ");
            selection = s.nextInt();

            switch (selection) {
                case 1:
                    main.quanLiSanh();
                    break;
                case 2:
                    main.quanLiDichVu();
                    break;
                case 3:
                    main.quanLiThucPham();
                    break;
            }
        } while (selection > 0 && selection < 9);
    }
}