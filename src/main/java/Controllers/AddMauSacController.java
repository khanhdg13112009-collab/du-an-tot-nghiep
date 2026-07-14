package Controllers;

import Models.Account;
import Models.MauSac;
import Services.MauSacService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addMauSac")
public class AddMauSacController extends HttpServlet {

    MauSacService service = new MauSacService();

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

        request.getRequestDispatcher("addMauSac.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        MauSac ms = new MauSac();

        ms.setTenMau(request.getParameter("tenMau"));

        service.addMauSac(ms);

        response.sendRedirect("mausac");

    }

}