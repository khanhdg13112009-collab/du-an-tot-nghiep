package Controllers;

import Models.Account;
import Models.MauSac;
import Services.MauSacService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/mausac")
public class MauSacController extends HttpServlet {

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

        ArrayList<MauSac> list = service.getAll();

        request.setAttribute("list", list);

        request.getRequestDispatcher("mausac.jsp")
                .forward(request, response);

    }

}