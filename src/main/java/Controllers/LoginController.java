package Controllers;

import Models.Account;
import Services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import Models.NhanVien;
import Services.NhanVienService;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    AccountService accountService = new AccountService();
    NhanVienService nhanVienService = new NhanVienService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp")
                .forward(request, response);
    }

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

        System.out.println("Username = " + username);
        System.out.println("Password = " + password);
        System.out.println("Account = " + account);

        if (account != null) {


            if (account.getMaNV() > 0) {

                NhanVien nv =
                        nhanVienService.getNhanVienById(account.getMaNV());


                if (nv != null && nv.getTrangThaiID() == 2) {

                    request.setAttribute(
                            "error",
                            "Tài khoản nhân viên đã nghỉ việc, không thể đăng nhập."
                    );

                    request.getRequestDispatcher("login.jsp")
                            .forward(request, response);

                    return;
                }
            }

            HttpSession session = request.getSession();

            session.setAttribute("account", account);

            response.sendRedirect("admin");

        } else {

            request.setAttribute("error", "Sai tài khoản hoặc mật khẩu");

            request.getRequestDispatcher("login.jsp")
                    .forward(request, response);

        }

    }

}