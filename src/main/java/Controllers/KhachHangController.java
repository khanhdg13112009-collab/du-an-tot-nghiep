package Controllers;

import Models.Account;
import Models.KhachHang;
import Services.KhachHangService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/khachhang")
public class KhachHangController extends HttpServlet {

    KhachHangService service = new KhachHangService();

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

        ArrayList<KhachHang> list = service.getAll();

        request.setAttribute("list", list);

        request.getRequestDispatcher("khachhang.jsp")
                .forward(request, response);

    }

}