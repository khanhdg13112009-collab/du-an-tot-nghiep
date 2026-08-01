package Controllers;

import Models.Account;
import Models.CartItem;
import Models.HoaDon;
import Models.HoaDonChiTiet;
import Models.SanPhamChiTiet;
import Services.HoaDonChiTietService;
import Services.HoaDonService;
import Services.SanPhamChiTietService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/thanhToan")
public class ThanhToanController extends HttpServlet {

    private HoaDonService hoaDonService =
            new HoaDonService();

    private HoaDonChiTietService hoaDonChiTietService =
            new HoaDonChiTietService();

    private SanPhamChiTietService sanPhamChiTietService =
            new SanPhamChiTietService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        Account account =
                (Account) session.getAttribute("account");

        if (account == null) {

            response.sendRedirect("login");

            return;

        }

        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {

            response.sendRedirect("banHang");

            return;

        }

        int maKH = Integer.parseInt(request.getParameter("maKH"));

        if (maKH == 0) {

        }

        String ghiChu =
                request.getParameter("ghiChu");

        System.out.println("=================================");
        System.out.println("GhiChu nhận được: " + ghiChu);
        System.out.println("=================================");

        BigDecimal tongTien = BigDecimal.ZERO;

        for (CartItem item : cart) {

            tongTien =
                    tongTien.add(item.getThanhTien());

        }

        HoaDon hd = new HoaDon();

        hd.setMaKH(maKH);

        hd.setMaNV(account.getMaNV());

        hd.setTongTien(tongTien);

        hd.setTrangThai("Đã thanh toán");

        hd.setGhiChu(ghiChu);

        int maHD =
                hoaDonService.addHoaDon(hd);

        if (maHD == -1) {

            response.sendRedirect("banHang");

            return;

        }

        for (CartItem item : cart) {

            SanPhamChiTiet sp =
                    sanPhamChiTietService.getByMaSPCT(item.getMaSPCT());

            if (sp == null ||
                    sp.getSoLuong() < item.getSoLuong()) {

                response.sendRedirect("banHang");

                return;

            }

            HoaDonChiTiet ct =
                    new HoaDonChiTiet();

            ct.setMaHD(maHD);

            ct.setMaSPCT(item.getMaSPCT());

            ct.setSoLuong(item.getSoLuong());

            ct.setDonGia(item.getDonGia());

            ct.setThanhTien(item.getThanhTien());
            boolean success =
                    hoaDonChiTietService.add(ct);

            if (!success) {

                response.sendRedirect("banHang");

                return;

            }

            boolean giamKho =
                    sanPhamChiTietService.giamSoLuong(
                            item.getMaSPCT(),
                            item.getSoLuong());

            if (!giamKho) {

                response.sendRedirect("banHang");

                return;

            }

        }

        cart.clear();

        session.setAttribute("cart", cart);

        response.sendRedirect("hoaDon");

    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);

    }

}