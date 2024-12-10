package entity;

public class DienThoaiChinhHang extends DienThoai {
    private String thoiGianBaoHanh;
    private String phamViBaoHanh;

    public DienThoaiChinhHang() {
    }

    public DienThoaiChinhHang(int id, String name, float gia, int soLuong, String nhaSanXuat,
                              String thoiGianBaoHanh, String phamViBaoHanh) {
        super(id, name, gia, soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public String getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String hienThiThongTin() {
        return id + "," + name + "," + gia + "," + soLuong + "," + nhaSanXuat + "," + thoiGianBaoHanh +"," + phamViBaoHanh + ")";
    }

    @Override
    public String toString() {
        return super.toString() +
                ", thoiGianBaoHanh=" + thoiGianBaoHanh + " tháng" +
                ", phamViBaoHanh='" + phamViBaoHanh + '\'';
    }
}

