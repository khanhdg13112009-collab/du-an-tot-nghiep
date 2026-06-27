package Controllers;

import Models.Account;
import Models.NhanVien;
import Services.NhanVienService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {

    NhanVienService service = new NhanVienService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        NhanVien nv = service.getNhanVienById(account.getMaNV());

        request.setAttribute("nv", nv);

        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
}