package Controllers;

import Models.Account;
import Models.HoaDon;
import Services.HoaDonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/hoadon")
public class HoaDonController extends HttpServlet {

    HoaDonService service = new HoaDonService();

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

        if (account == null || account.getRoleID() != 1) {
            response.sendRedirect("home");
            return;
        }

        ArrayList<HoaDon> list = service.getAll();

        request.setAttribute("list", list);

        request.getRequestDispatcher("hoadon.jsp")
                .forward(request, response);
    }
}