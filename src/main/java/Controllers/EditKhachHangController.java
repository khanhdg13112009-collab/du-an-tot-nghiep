package Controllers;

import Models.Account;
import Models.KhachHang;
import Services.KhachHangService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/editKhachHang")
public class EditKhachHangController extends HttpServlet {

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

        KhachHang kh = service.getById(id);

        request.setAttribute("kh", kh);

        request.getRequestDispatcher("editKhachHang.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        KhachHang kh = new KhachHang();

        kh.setMaKH(Integer.parseInt(request.getParameter("maKH")));
        kh.setHoTen(request.getParameter("hoTen"));
        kh.setSoDienThoai(request.getParameter("soDienThoai"));
        kh.setEmail(request.getParameter("email"));
        kh.setDiaChi(request.getParameter("diaChi"));

        service.updateKhachHang(kh);

        response.sendRedirect("khachhang");

    }

}