package Controllers;

import Models.Account;
import Services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    AccountService accountService = new AccountService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account account = accountService.login(username, password);

        if (account != null) {

            HttpSession session = request.getSession();

            session.setAttribute("account", account);

            response.sendRedirect("home.jsp");

        } else {

            request.setAttribute("error", "sai tai khoan hoac mat khau");

            request.getRequestDispatcher("login.jsp")
                    .forward(request, response);
        }
    }
}