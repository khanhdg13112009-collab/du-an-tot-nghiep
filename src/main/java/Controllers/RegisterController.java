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

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String soDienThoai = request.getParameter("soDienThoai");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");

        if (username == null || username.trim().isEmpty()
                || email == null || email.trim().isEmpty()
                || soDienThoai == null || soDienThoai.trim().isEmpty()
                || password == null || password.trim().isEmpty()
                || rePassword == null || rePassword.trim().isEmpty()) {

            request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

            request.setAttribute("error", "Email không hợp lệ.");
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

        if (khService.checkEmail(email)) {

            request.setAttribute("error", "Email đã được sử dụng.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        if (khService.checkSoDienThoai(soDienThoai)) {

            request.setAttribute("error", "Số điện thoại đã được sử dụng.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        KhachHang kh = new KhachHang();

        kh.setHoTen("");
        kh.setSoDienThoai(soDienThoai);
        kh.setEmail(email);
        kh.setDiaChi("");

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