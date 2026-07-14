package Controllers;

import Models.Account;
import Models.KhachHang;
import Services.KhachHangService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addKhachHang")
public class AddKhachHangController extends HttpServlet {

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

        request.getRequestDispatcher("addKhachHang.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        KhachHang kh = new KhachHang();

        kh.setHoTen(request.getParameter("hoTen"));
        kh.setSoDienThoai(request.getParameter("soDienThoai"));
        kh.setEmail(request.getParameter("email"));
        kh.setDiaChi(request.getParameter("diaChi"));

        service.addKhachHang(kh);

        response.sendRedirect("khachhang");

    }

}
