package Controllers;

import Models.Account;
import Models.SanPham;
import Services.KichCoService;
import Services.MauSacService;
import Services.SanPhamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addSanPham")
public class AddSanPhamController extends HttpServlet {

    private SanPhamService service = new SanPhamService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        if (account.getRoleID() != 1) {
            response.sendRedirect("403.jsp");
            return;
        }

        request.setAttribute("mauSacList",
                new MauSacService().getAll());

        request.setAttribute("kichCoList",
                new KichCoService().getAll());

        request.getRequestDispatcher("addSanPham.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        SanPham sp = new SanPham();

        sp.setTenSP(request.getParameter("tenSP"));
        sp.setThuongHieu(request.getParameter("thuongHieu"));
        sp.setChatLieu(request.getParameter("chatLieu"));
        sp.setMoTa(request.getParameter("moTa"));

        sp.setTrangThai(
                Boolean.parseBoolean(request.getParameter("trangThai"))
        );

        sp.setMaMau(
                Integer.parseInt(request.getParameter("maMau"))
        );

        sp.setMaSize(
                Integer.parseInt(request.getParameter("maSize"))
        );

        sp.setGia(
                Double.parseDouble(request.getParameter("gia"))
        );

        sp.setSoLuong(
                Integer.parseInt(request.getParameter("soLuong"))
        );

        service.addSanPham(sp);

        response.sendRedirect("sanpham");

    }

}