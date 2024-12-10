package entity;

public abstract class DienThoai {
    protected int id;
    protected String name;
    protected float gia;
    protected int soLuong;
    protected String nhaSanXuat;

    public DienThoai() {
    }

    public DienThoai(int id, String name, float gia, int soLuong, String nhaSanXuat) {
        this.id = id;
        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public abstract String hienThiThongTin();


    @Override
    public String toString() {
        return "DienThoai{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gia=" + gia +
                ", soLuong=" + soLuong +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                '}';
    }
}
