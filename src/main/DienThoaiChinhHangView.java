package main;

import entity.DienThoaiChinhHang;
import repository.DienThoaiChinhHangRepository;

import java.util.List;
import java.util.Scanner;

public class DienThoaiChinhHangView {
    private final DienThoaiChinhHangRepository repository = new DienThoaiChinhHangRepository();
    private final Scanner scanner = new Scanner(System.in);

    public void hienThiMenu() {
        while (true) {
            System.out.println();
            System.out.println("--- QUẢN LÝ ĐIỆN THOẠI CHÍNH HÃNG ---");
            System.out.println("1. Thêm ");
            System.out.println("2. Xóa ");
            System.out.println("3. Hiển thị danh sách ");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    themDienThoai();
                    break;
                case 2:
                    xoaDienThoai();
                    break;
                case 3:
                    hienThiDanhSach();
                    break;
                case 4:
                    timKiemDienThoai();
                    break;
                case 5:
                    System.out.println("Đã thoát.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private void themDienThoai() {
        System.out.println("Nhập thông tin điện thoại chính hãng:");

        System.out.print("Tên điện thoại: ");
        String name = scanner.nextLine();

        System.out.print("Giá: ");
        float gia = Float.parseFloat(scanner.nextLine());

        System.out.print("Số lượng: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhà sản xuất: ");
        String nhaSanXuat = scanner.nextLine();

        System.out.print("Thời gian bảo hành: ");
        String thoiGianBaoHanh = scanner.nextLine();

        System.out.print("Phạm vi bảo hành: ");
        String phamViBaoHanh = scanner.nextLine();

        int id = repository.layDanhSachDienThoaiChinhHang().size() + 1;
        DienThoaiChinhHang dt = new DienThoaiChinhHang(id, name, gia, soLuong, nhaSanXuat, thoiGianBaoHanh, phamViBaoHanh);
        repository.themDienThoai(dt);
        System.out.println("Điện thoại chính hãng đã được thêm thành công.");
    }

    private void xoaDienThoai() {
        System.out.print("Nhập ID điện thoại cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        DienThoaiChinhHang dienThoaiMuonXoa = null;
        for (DienThoaiChinhHang dienThoai : repository.layDanhSachDienThoaiChinhHang()) {
            if (dienThoai.getId() == (id)) {
                dienThoaiMuonXoa = dienThoai;
                break;
            }
        }
        if (dienThoaiMuonXoa == null) {
            System.out.println("Không tìm thấy điện thoại có mã là " + id + ".");
        } else {
            System.out.println("Thông tin điện thoại cần xóa: " + dienThoaiMuonXoa.hienThiThongTin() +
                    ".\nBạn có chắc muốn xóa điện thoại này không?" +
                    "\nLưu ý: Hành động này không thể hoàn tác.");
            System.out.println("Bấm 'y' để xác nhận xóa. Bấm phím bất kỳ để hủy.");

            char confirm = scanner.nextLine().charAt(0);

            if (confirm == 'y') {
                repository.xoaDienThoai(id);
                System.out.println("Xóa điện thoại thành công.");
            } else {
                System.out.println("Hủy xóa điện thoại.");
            }
        }

    }

    private void hienThiDanhSach() {
        List<DienThoaiChinhHang> danhSach = repository.layDanhSachDienThoaiChinhHang();
        System.out.println("Danh sách điện thoại hiện tại: ");
        for (DienThoaiChinhHang dienThoai : danhSach) {
            System.out.println(dienThoai.hienThiThongTin());
        }
    }

    private void timKiemDienThoai() {
        System.out.print("Nhập từ khóa tìm kiếm (ID hoặc tên): ");
        String tuKhoa = scanner.nextLine();

        List<DienThoaiChinhHang> ketQua = repository.timKiemDienThoaiChinhHang(tuKhoa);

        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy điện thoại nào khớp với từ khóa: " + tuKhoa);
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (DienThoaiChinhHang dienThoai : ketQua) {
                System.out.println(dienThoai.hienThiThongTin());
            }
        }
    }
}

