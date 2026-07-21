package Models;

import java.util.ArrayList;

public class Cart {

    private ArrayList<CartItem> items = new ArrayList<>();

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void add(SanPhamChiTiet sp, int soLuong) {

        for (CartItem item : items) {

            if (item.getSanPham().getMaSPCT() == sp.getMaSPCT()) {

                item.setSoLuong(item.getSoLuong() + soLuong);

                return;
            }

        }

        items.add(new CartItem(sp, soLuong));

    }

    public void remove(int maSPCT) {

        items.removeIf(item -> item.getSanPham().getMaSPCT() == maSPCT);

    }
    public void update(int maSPCT, int soLuong) {

        for (CartItem item : items) {

            if (item.getSanPham().getMaSPCT() == maSPCT) {

                if (soLuong <= 0) {

                    remove(maSPCT);

                } else {

                    item.setSoLuong(soLuong);

                }

                return;

            }

        }

    }
    public void tangSoLuong(int maSPCT) {

        for (CartItem item : items) {

            if (item.getSanPham().getMaSPCT() == maSPCT) {

                item.setSoLuong(item.getSoLuong() + 1);

                return;

            }

        }

    }

    public void giamSoLuong(int maSPCT) {

        for (CartItem item : items) {

            if (item.getSanPham().getMaSPCT() == maSPCT) {

                if (item.getSoLuong() == 1) {

                    remove(maSPCT);

                } else {

                    item.setSoLuong(item.getSoLuong() - 1);

                }

                return;

            }

        }

    }

    public double getTongTien() {

        double tong = 0;

        for (CartItem item : items) {

            tong += item.getThanhTien();

        }

        return tong;

    }

}