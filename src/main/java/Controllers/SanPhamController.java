package Controllers;

import Models.Account;
import Models.SanPham;
import Services.SanPhamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/sanpham")
public class SanPhamController extends HttpServlet {

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

        ArrayList<SanPham> list = service.getAll();

        request.setAttribute("list", list);

        request.getRequestDispatcher("sanpham.jsp")
                .forward(request, response);

    }

}