package Controllers;

import Models.Account;
import Models.KhachHang;
import Services.AccountService;
import Services.KhachHangService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    private KhachHangService khService = new KhachHangService();
    private AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("register.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String hoTen = request.getParameter("hoTen");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
        String diaChi = request.getParameter("diaChi");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");


        if (hoTen == null || hoTen.trim().isEmpty()
                || soDienThoai == null || soDienThoai.trim().isEmpty()
                || email == null || email.trim().isEmpty()
                || diaChi == null || diaChi.trim().isEmpty()
                || username == null || username.trim().isEmpty()
                || password == null || password.trim().isEmpty()
                || rePassword == null || rePassword.trim().isEmpty()) {

            request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }


        if (!password.equals(rePassword)) {

            request.setAttribute("error", "Mật khẩu nhập lại không đúng.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;

        }


        if (accountService.checkUsername(username)) {

            request.setAttribute("error", "Tên đăng nhập đã tồn tại.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;

        }

        KhachHang kh = new KhachHang();

        kh.setHoTen(hoTen);
        kh.setSoDienThoai(soDienThoai);
        kh.setEmail(email);
        kh.setDiaChi(diaChi);

        int maKH = khService.addKhachHang(kh);

        if (maKH == -1) {

            request.setAttribute("error", "Không thể tạo khách hàng.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;

        }

        Account account = new Account();

        account.setUsername(username);
        account.setPassword(password);
        account.setRoleID(3);
        account.setMaNV(0);
        account.setMaKH(maKH);

        boolean success = accountService.register(account);

        if (success) {

            response.sendRedirect("login.jsp");

        } else {

            request.setAttribute("error", "Đăng ký thất bại.");
            request.getRequestDispatcher("register.jsp").forward(request, response);

        }

    }
}