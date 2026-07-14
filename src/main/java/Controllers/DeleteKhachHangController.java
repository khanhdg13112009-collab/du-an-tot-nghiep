package Controllers;

import Models.Account;
import Services.KhachHangService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/deleteKhachHang")
public class DeleteKhachHangController extends HttpServlet {

    KhachHangService service = new KhachHangService();

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

        service.deleteKhachHang(id);

        response.sendRedirect("khachhang");

    }

}