package Controllers;

import Models.Account;
import Models.SanPhamChiTiet;
import Services.SanPhamChiTietService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/deleteSanPhamChiTiet")
public class DeleteSanPhamChiTietController extends HttpServlet {

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

        int maSP = spct.getMaSP();

        service.deleteSanPhamChiTiet(id);

        response.sendRedirect("sanphamchitiet?id=" + maSP);

    }

}