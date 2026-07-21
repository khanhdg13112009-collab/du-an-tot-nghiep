package Models;

public class CartItem {

    private SanPhamChiTiet sanPham;
    private int soLuong;

    public CartItem() {
    }

    public CartItem(SanPhamChiTiet sanPham, int soLuong) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }

    public SanPhamChiTiet getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPhamChiTiet sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return sanPham.getGia() * soLuong;
    }
}