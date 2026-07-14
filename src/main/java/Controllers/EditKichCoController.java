package Controllers;

import Models.Account;
import Models.KichCo;
import Services.KichCoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/editKichCo")
public class EditKichCoController extends HttpServlet {

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

        if (account.getRoleID() != 1) {
            response.sendRedirect("403.jsp");
            return;
        }

        int id = Integer.parseInt(request.getParameter("id"));

        KichCo kc = service.getById(id);

        request.setAttribute("kc", kc);

        request.getRequestDispatcher("editKichCo.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        KichCo kc = new KichCo();

        kc.setMaSize(Integer.parseInt(request.getParameter("maSize")));
        kc.setTenSize(request.getParameter("tenSize"));

        service.updateKichCo(kc);

        response.sendRedirect("kichco");

    }

}