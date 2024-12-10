package repository;

import entity.DienThoaiChinhHang;
import entity.DienThoaiXachTay;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiChinhHangRepository {
    private static final String FILE_PATH ="src/data/data.csv";

    public void themDienThoai(DienThoaiChinhHang dienThoai) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(dienThoai.hienThiThongTin());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu diện thoại chính hãng vào file.");
        }
    }

    public void xoaDienThoai(int id) {
        List<DienThoaiChinhHang> danhSach = layDanhSachDienThoaiChinhHang();
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getId() == id) {
                danhSach.remove(i);
                System.out.println("Đã xóa điện thoại có id: " + id);
                break;
            }
        }
        luuDanhSach(danhSach);
    }

    public List<DienThoaiChinhHang> layDanhSachDienThoaiChinhHang() {
        List<DienThoaiChinhHang> danhSach = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                DienThoaiChinhHang dienThoai = new DienThoaiChinhHang(
                        Integer.parseInt(data[0]),
                        data[1], Float.parseFloat(data[2]),
                        Integer.parseInt(data[3]), data[4],
                        data[5],
                        data[6]
                );
                danhSach.add(dienThoai);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu điện thoại chính hãng.");
        }
        return danhSach;
    }

    private void luuDanhSach(List<DienThoaiChinhHang> danhSach) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (DienThoaiChinhHang dienThoai : danhSach) {
                writer.write(dienThoai.hienThiThongTin());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi danh sách điện thoại xách tay vào file.");
        }
    }

    public List<DienThoaiChinhHang> timKiemDienThoaiChinhHang(String tuKhoa) {
        List<DienThoaiChinhHang> ketQua = new ArrayList<>();
        for (DienThoaiChinhHang dienThoai : layDanhSachDienThoaiChinhHang()) {
            if (dienThoai.getId() == Integer.parseInt(tuKhoa) ||
                    dienThoai.getName().toLowerCase().contains(tuKhoa.toLowerCase())) {
                ketQua.add(dienThoai);
            }
        }
        return ketQua;
    }
}
