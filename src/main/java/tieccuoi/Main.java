package tieccuoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        QuanLyDichVu quanLyDichVu = new QuanLyDichVu();
        quanLyDichVu.docDsDichVu();
        quanLyDichVu.xuatDichVu();

    }
}