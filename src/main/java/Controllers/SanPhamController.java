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

        String keyword = request.getParameter("keyword");

        ArrayList<SanPham> list;

        if (keyword == null || keyword.trim().isEmpty()) {

            list = service.getAll();

        } else {

            list = service.search(keyword.trim());

        }

        request.setAttribute("list", list);
        request.setAttribute("keyword", keyword);

        request.getRequestDispatcher("sanpham.jsp")
                .forward(request, response);

    }

}