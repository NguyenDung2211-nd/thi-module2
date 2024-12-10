package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("--- QUẢN LÝ ĐIỆN THOẠI ---");
            System.out.println("1. Quản lý điện thoại chính hãng");
            System.out.println("2. Quản lý điện thoại xách tay");
            System.out.println("3. Thoát chương trình");
            System.out.print("Lựa chọn của bạn: ");
            int luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    DienThoaiChinhHangView viewChinhHang = new DienThoaiChinhHangView ();
                    viewChinhHang.hienThiMenu();
                    break;
                case 2:
                    DienThoaiXachTayView viewXachTay = new DienThoaiXachTayView ();
                    viewXachTay.hienThiMenu();
                    break;
                case 3:
                    System.out.println("Chương trình kết thúc.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}
