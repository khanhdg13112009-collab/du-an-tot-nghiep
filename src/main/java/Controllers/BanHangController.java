package Controllers;

import Models.CartItem;
import Models.SanPhamChiTiet;
import Services.SanPhamChiTietService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

@WebServlet("/banHang")
public class BanHangController extends HttpServlet {

    private SanPhamChiTietService sanPhamChiTietService =
            new SanPhamChiTietService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String keyword = request.getParameter("keyword");

        HttpSession session = request.getSession();

        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {

            cart = new ArrayList<>();

            session.setAttribute("cart", cart);

        }

        ArrayList<SanPhamChiTiet> dsSP;

        if (keyword != null && !keyword.trim().isEmpty()) {

            dsSP = sanPhamChiTietService.search(keyword.trim());

        } else {

            dsSP = sanPhamChiTietService.getAll();

        }

        LinkedHashMap<Integer, ArrayList<SanPhamChiTiet>> dsTheoSP =
                new LinkedHashMap<>();

        for (SanPhamChiTiet sp : dsSP) {

            if (!dsTheoSP.containsKey(sp.getMaSP())) {
                dsTheoSP.put(sp.getMaSP(), new ArrayList<>());
            }

            dsTheoSP.get(sp.getMaSP()).add(sp);
        }

        request.setAttribute("dsTheoSP", dsTheoSP);

        if (action == null) {

            request.setAttribute("dsSP", dsSP);

            request.setAttribute("cart", cart);

            request.setAttribute("tongTien",
                    tinhTongTien(cart));

            request.getRequestDispatcher("/banhang.jsp")
                    .forward(request, response);

            return;

        }

        switch (action) {

            case "remove":

                removeItem(request, cart);

                break;

            case "increase":

                tangSoLuong(request, cart);

                break;

            case "decrease":

                giamSoLuong(request, cart);

                break;

            case "clear":

                cart.clear();

                break;

        }

        session.setAttribute("cart", cart);

        response.sendRedirect("banHang");

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {

            cart = new ArrayList<>();

        }

        int maSPCT =
                Integer.parseInt(request.getParameter("maSPCT"));

        SanPhamChiTiet sp =
                sanPhamChiTietService.getByMaSPCT(maSPCT);

        if (sp == null) {

            response.sendRedirect("banHang");

            return;

        }

        if (sp.getSoLuong() <= 0) {

            response.sendRedirect("banHang");

            return;

        }

        boolean tonTai = false;

        for (CartItem item : cart) {

            if (item.getMaSPCT() == maSPCT) {

                if (item.getSoLuong() < sp.getSoLuong()) {

                    item.setSoLuong(item.getSoLuong() + 1);

                }

                tonTai = true;

                break;

            }

        }

        if (!tonTai) {

            CartItem item = new CartItem();

            item.setMaSPCT(sp.getMaSPCT());

            item.setMaSP(sp.getMaSP());

            item.setTenSanPham(sp.getTenSP());

            item.setMauSac(sp.getTenMau());

            item.setKichCo(sp.getTenSize());

            item.setDonGia(
                    BigDecimal.valueOf(sp.getGia()));

            item.setSoLuong(1);

            cart.add(item);

        }

        session.setAttribute("cart", cart);

        response.sendRedirect("banHang");

    }
    private void removeItem(HttpServletRequest request,
                            List<CartItem> cart) {

        int maSPCT =
                Integer.parseInt(request.getParameter("maSPCT"));

        Iterator<CartItem> iterator = cart.iterator();

        while (iterator.hasNext()) {

            CartItem item = iterator.next();

            if (item.getMaSPCT() == maSPCT) {

                iterator.remove();

                break;

            }

        }

    }

    private void tangSoLuong(HttpServletRequest request,
                             List<CartItem> cart) {

        int maSPCT =
                Integer.parseInt(request.getParameter("maSPCT"));

        SanPhamChiTiet sp =
                sanPhamChiTietService.getByMaSPCT(maSPCT);

        if (sp == null) {

            return;

        }

        for (CartItem item : cart) {

            if (item.getMaSPCT() == maSPCT) {


                if (item.getSoLuong() < sp.getSoLuong()) {

                    item.setSoLuong(item.getSoLuong() + 1);

                }

                return;

            }

        }

    }

    private void giamSoLuong(HttpServletRequest request,
                             List<CartItem> cart) {

        int maSPCT =
                Integer.parseInt(request.getParameter("maSPCT"));

        Iterator<CartItem> iterator = cart.iterator();

        while (iterator.hasNext()) {

            CartItem item = iterator.next();

            if (item.getMaSPCT() == maSPCT) {

                if (item.getSoLuong() <= 1) {

                    iterator.remove();

                } else {

                    item.setSoLuong(item.getSoLuong() - 1);

                }

                return;

            }

        }

    }

    private BigDecimal tinhTongTien(List<CartItem> cart) {

        BigDecimal tong = BigDecimal.ZERO;

        for (CartItem item : cart) {

            tong = tong.add(item.getThanhTien());

        }

        return tong;

    }

}