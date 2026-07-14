package Controllers;

import Models.Account;
import Models.KichCo;
import Services.KichCoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/kichco")
public class KichCoController extends HttpServlet {

    KichCoService service = new KichCoService();

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

        ArrayList<KichCo> list = service.getAll();

        request.setAttribute("list", list);

        request.getRequestDispatcher("kichco.jsp").forward(request, response);

    }

}