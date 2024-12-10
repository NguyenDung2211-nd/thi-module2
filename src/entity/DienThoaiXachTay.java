package entity;

public class DienThoaiXachTay extends DienThoai {
    private String quocGiaXachTay;
    private String trangThai;

    public DienThoaiXachTay() {
    }

    public DienThoaiXachTay(int id, String name, float gia, int soLuong, String nhaSanXuat,
                            String quocGiaXachTay, String trangThai) {
        super(id, name, gia, soLuong, nhaSanXuat);
        this.quocGiaXachTay = quocGiaXachTay;
        this.trangThai = trangThai;
    }

    public String getQuocGiaXachTay() {
        return quocGiaXachTay;
    }

    public void setQuocGiaXachTay(String quocGiaXachTay) {
        this.quocGiaXachTay = quocGiaXachTay;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String hienThiThongTin() {
        return id + "," + name + "," + gia + "," + soLuong + "," + nhaSanXuat + "," + quocGiaXachTay +","+ trangThai + ")";
    }

    @Override
    public String toString() {
        return super.toString() +
                ", quocGiaXachTay='" + quocGiaXachTay + '\'' +
                ", trangThai='" + trangThai + '\'';
    }
}

