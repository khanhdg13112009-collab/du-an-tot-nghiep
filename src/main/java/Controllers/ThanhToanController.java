package Controllers;

import Models.Cart;
import Models.CartItem;
import Models.HoaDon;
import Models.HoaDonChiTiet;
import Services.HoaDonChiTietService;
import Services.HoaDonService;
import Services.SanPhamChiTietService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/thanh-toan")
public class ThanhToanController extends HttpServlet {

    HoaDonService hoaDonService = new HoaDonService();
    HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();
    SanPhamChiTietService sanPhamChiTietService = new SanPhamChiTietService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null || cart.getItems().isEmpty()) {
            response.sendRedirect("gio-hang");
            return;
        }

        // Tạm thời dùng khách hàng số 1
        HoaDon hd = new HoaDon();
        hd.setMaKH(1);
        hd.setTongTien(cart.getTongTien());
        hd.setTrangThai("Đã đặt");

        int maHD = hoaDonService.addHoaDon(hd);

        if (maHD == -1) {
            response.sendRedirect("gio-hang");
            return;
        }

        for (CartItem item : cart.getItems()) {

            HoaDonChiTiet ct = new HoaDonChiTiet();

            ct.setMaHD(maHD);
            ct.setMaSPCT(item.getSanPham().getMaSPCT());
            ct.setSoLuong(item.getSoLuong());
            ct.setDonGia(item.getSanPham().getGia());
            ct.setThanhTien(item.getThanhTien());

            hoaDonChiTietService.add(ct);

            // Trừ số lượng tồn kho
            sanPhamChiTietService.giamSoLuong(
                    item.getSanPham().getMaSPCT(),
                    item.getSoLuong()
            );
        }

        session.removeAttribute("cart");

        response.sendRedirect("dat-hang-thanh-cong.jsp");
    }

}