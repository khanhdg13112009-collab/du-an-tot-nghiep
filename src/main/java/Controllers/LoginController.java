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
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account account = accountService.login(username, password);

        // Kiểm tra đăng nhập
        System.out.println("Username = " + username);
        System.out.println("Password = " + password);
        System.out.println("Account = " + account);

        if (account != null) {

            HttpSession session = request.getSession();

            session.setAttribute("account", account);


            if(account.getRoleID() == 1){

                response.sendRedirect("admin");

            }else{

                response.sendRedirect("home");

            }

        } else {

            request.setAttribute("error", "Sai tài khoản hoặc mật khẩu");

            request.getRequestDispatcher("login.jsp")
                    .forward(request, response);
        }
    }
}