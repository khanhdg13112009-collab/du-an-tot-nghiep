package Controllers;

import Models.Account;
import Models.SanPham;
import Services.SanPhamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/editSanPham")
public class EditSanPhamController extends HttpServlet {

    SanPhamService service = new SanPhamService();

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

        SanPham sp = service.getById(id);

        request.setAttribute("sp", sp);

        request.getRequestDispatcher("editSanPham.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int maSP = Integer.parseInt(request.getParameter("maSP"));

        String tenSP = request.getParameter("tenSP");
        String thuongHieu = request.getParameter("thuongHieu");
        String chatLieu = request.getParameter("chatLieu");
        String moTa = request.getParameter("moTa");
        boolean trangThai =
                Boolean.parseBoolean(request.getParameter("trangThai"));

        SanPham sp = new SanPham();

        sp.setMaSP(maSP);
        sp.setTenSP(tenSP);
        sp.setThuongHieu(thuongHieu);
        sp.setChatLieu(chatLieu);
        sp.setMoTa(moTa);
        sp.setTrangThai(trangThai);

        service.updateSanPham(sp);

        response.sendRedirect("sanpham");

    }

}