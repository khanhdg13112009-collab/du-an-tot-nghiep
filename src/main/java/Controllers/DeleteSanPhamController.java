package Controllers;

import Models.Account;
import Services.SanPhamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/deleteSanPham")
public class DeleteSanPhamController extends HttpServlet {

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

        service.deleteSanPham(id);

        response.sendRedirect("sanpham");

    }

}