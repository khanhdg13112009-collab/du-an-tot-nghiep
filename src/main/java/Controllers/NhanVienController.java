package Controllers;

import Models.Account;
import Models.NhanVien;
import Services.NhanVienService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/nhanvien")
public class NhanVienController extends HttpServlet {

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

        if (account.getRoleID() != 1) {
            response.sendRedirect("403.jsp");
            return;
        }

        ArrayList<NhanVien> list = service.getAllNhanVien();

        request.setAttribute("list", list);

        request.getRequestDispatcher("nhanvien.jsp").forward(request, response);
    }
}