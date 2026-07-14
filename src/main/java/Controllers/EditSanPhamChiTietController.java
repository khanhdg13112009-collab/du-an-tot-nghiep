package Controllers;

import Models.Account;
import Models.SanPhamChiTiet;
import Services.KichCoService;
import Services.MauSacService;
import Services.SanPhamChiTietService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/editSanPhamChiTiet")
public class EditSanPhamChiTietController extends HttpServlet {

    private SanPhamChiTietService service = new SanPhamChiTietService();

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

        int id = Integer.parseInt(request.getParameter("id"));

        SanPhamChiTiet spct = service.getById(id);

        request.setAttribute("spct", spct);

        request.setAttribute("mauSacList",
                new MauSacService().getAll());

        request.setAttribute("kichCoList",
                new KichCoService().getAll());

        request.getRequestDispatcher("editSanPhamChiTiet.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        SanPhamChiTiet spct = new SanPhamChiTiet();

        spct.setMaSPCT(
                Integer.parseInt(request.getParameter("maSPCT"))
        );

        spct.setMaSP(
                Integer.parseInt(request.getParameter("maSP"))
        );

        spct.setMaMau(
                Integer.parseInt(request.getParameter("maMau"))
        );

        spct.setMaSize(
                Integer.parseInt(request.getParameter("maSize"))
        );

        spct.setGia(
                Double.parseDouble(request.getParameter("gia"))
        );

        spct.setSoLuong(
                Integer.parseInt(request.getParameter("soLuong"))
        );

        service.updateSanPhamChiTiet(spct);

        response.sendRedirect(
                "sanphamchitiet?id=" + spct.getMaSP()
        );

    }

}