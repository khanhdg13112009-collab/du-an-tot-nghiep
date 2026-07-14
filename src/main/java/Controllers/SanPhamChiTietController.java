package Controllers;

import Models.Account;
import Models.SanPhamChiTiet;
import Services.SanPhamChiTietService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/sanphamchitiet")
public class SanPhamChiTietController extends HttpServlet {

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

        String id = request.getParameter("id");

        if (id == null) {
            response.sendRedirect("sanpham");
            return;
        }

        int maSP = Integer.parseInt(id);

        ArrayList<SanPhamChiTiet> list =
                service.getBySanPham(maSP);

        request.setAttribute("maSP", maSP);
        request.setAttribute("list", list);

        request.getRequestDispatcher("sanphamchitiet.jsp")
                .forward(request, response);

    }

}