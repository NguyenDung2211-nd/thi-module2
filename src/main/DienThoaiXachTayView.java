package main;

import entity.DienThoaiChinhHang;
import entity.DienThoaiXachTay;
import repository.DienThoaiChinhHangRepository;
import repository.DienThoaiXachTayRepository;

import java.util.List;
import java.util.Scanner;

public class DienThoaiXachTayView {
    private final DienThoaiXachTayRepository repository = new DienThoaiXachTayRepository();
    private final Scanner scanner = new Scanner(System.in);

    public void hienThiMenu() {
        while (true) {
            System.out.println();
            System.out.println("--- QUẢN LÝ ĐIỆN THOẠI XÁCH TAY ---");
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
                    System.out.println("Đã thoát.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
    private void themDienThoai() {
        System.out.println("--- Thêm điện thoại xách tay ---");

        System.out.print("Tên điện thoại: ");
        String name = scanner.nextLine();

        System.out.print("Giá: ");
        float gia = Float.parseFloat(scanner.nextLine());

        System.out.print("Số lượng: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhà sản xuất: ");
        String nhaSanXuat = scanner.nextLine();

        System.out.print("Quốc gia xách tay: ");
        String quocGiaXachTay = scanner.nextLine();

        System.out.print("Trạng thái (ví dụ: 'Đã kích hoạt' hoặc 'Chưa kích hoạt'): ");
        String trangThai = scanner.nextLine();

        int id = repository.layDanhSachDienThoaiXachTay().size() + 1;
        DienThoaiXachTay dt = new DienThoaiXachTay(id, name, gia, soLuong, nhaSanXuat, quocGiaXachTay, trangThai);
        repository.themDienThoai(dt);
        System.out.println("Điện thoại xách tay đã được thêm thành công.");
    }

    private void xoaDienThoai() {
        System.out.print("Nhập ID điện thoại cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        DienThoaiXachTay dienThoaiMuonXoa = null;
        for (DienThoaiXachTay dienThoai : repository.layDanhSachDienThoaiXachTay()) {
            if (dienThoai.getId()==(id)) {
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
        List<DienThoaiXachTay> danhSach = repository.layDanhSachDienThoaiXachTay();
        System.out.println("Danh sách điện thoại hiện tại: ");
        for (DienThoaiXachTay dienThoai : danhSach) {
            System.out.println(dienThoai.hienThiThongTin());
        }
    }
}

