package Controllers;

import Models.Account;
import Models.NhanVien;
import Services.NhanVienService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

@WebServlet("/addNhanVien")
public class AddNhanVienController extends HttpServlet {

    NhanVienService service = new NhanVienService();

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

        request.getRequestDispatcher("addNhanVien.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String hoTen = request.getParameter("hoTen");

        String cccd = request.getParameter("cccd");

        String ngayCapCCCD =
                request.getParameter("ngayCapCCCD");

        String ngayHetHanCCCD =
                request.getParameter("ngayHetHanCCCD");

        String noiCapCCCD =
                request.getParameter("noiCapCCCD");

        String ngaySinh =
                request.getParameter("ngaySinh");

        String gioiTinh =
                request.getParameter("gioiTinh");

        String soDienThoai =
                request.getParameter("soDienThoai");

        String email =
                request.getParameter("email");

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        String coSo =
                request.getParameter("coSo");

        String tinhThanhPho =
                request.getParameter("tinhThanhPho");

        String quanHuyen =
                request.getParameter("quanHuyen");

        if (quanHuyen == null || quanHuyen.trim().isEmpty()) {
            quanHuyen = "Không áp dụng";
        }

        String phuongXa =
                request.getParameter("phuongXa");

        String diaChiChiTiet =
                request.getParameter("diaChiChiTiet");

        String trangThai =
                request.getParameter("trangThaiID");

        String anhCCCDTruoc =
                request.getParameter("anhCCCDTruoc");

        String anhCCCDSau =
                request.getParameter("anhCCCDSau");
        hoTen = hoTen.trim();
        cccd = cccd.trim();
        soDienThoai = soDienThoai.trim();
        email = email.trim().toLowerCase();
        password = password.trim();
        username = username.trim();

        if (password.length() < 6) {

            request.setAttribute(
                    "error",
                    "Mật khẩu phải có ít nhất 6 ký tự."
            );

            request.getRequestDispatcher("addNhanVien.jsp")
                    .forward(request, response);

            return;
        }

        if (username.length() < 3) {

            request.setAttribute(
                    "error",
                    "Tên đăng nhập phải có ít nhất 3 ký tự."
            );

            request.getRequestDispatcher("addNhanVien.jsp")
                    .forward(request, response);

            return;
        }
        noiCapCCCD = noiCapCCCD.trim();
        diaChiChiTiet = diaChiChiTiet.trim();

        if (!cccd.matches("\\d{12}")) {

            request.setAttribute("error",
                    "CCCD phải gồm đúng 12 chữ số.");

            request.getRequestDispatcher("addNhanVien.jsp")
                    .forward(request, response);

            return;

        }

        if (!(soDienThoai.matches("0\\d{9}")
                || soDienThoai.matches("\\+84\\d{9}"))) {

            request.setAttribute("error",
                    "Số điện thoại không hợp lệ.");

            request.getRequestDispatcher("addNhanVien.jsp")
                    .forward(request, response);

            return;

        }

        if (!email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

            request.setAttribute("error",
                    "Email không hợp lệ.");

            request.getRequestDispatcher("addNhanVien.jsp")
                    .forward(request, response);

            return;

        }

        if (password.length() < 6) {

            request.setAttribute("error",
                    "Mật khẩu phải có ít nhất 6 ký tự.");

            request.getRequestDispatcher("addNhanVien.jsp")
                    .forward(request, response);

            return;

        }

        if (service.isExistCCCD(cccd)) {

            request.setAttribute("error",
                    "CCCD đã tồn tại.");

            request.getRequestDispatcher("addNhanVien.jsp")
                    .forward(request, response);

            return;

        }

        if (service.isExistPhone(soDienThoai)) {

            request.setAttribute("error",
                    "Số điện thoại đã tồn tại.");

            request.getRequestDispatcher("addNhanVien.jsp")
                    .forward(request, response);

            return;

        }

        if (service.isExistEmail(email)) {

            request.setAttribute("error",
                    "Email đã tồn tại.");

            request.getRequestDispatcher("addNhanVien.jsp")
                    .forward(request, response);

            return;

        }

        LocalDate birth = LocalDate.parse(ngaySinh);

        int tuoi = Period.between(
                birth,
                LocalDate.now()).getYears();

        if (tuoi < 16) {

            request.setAttribute("error",
                    "Nhân viên phải từ 16 tuổi trở lên.");

            request.getRequestDispatcher("addNhanVien.jsp")
                    .forward(request, response);

            return;

        }

        Date ngaySinhDate = Date.valueOf(ngaySinh);
        Date ngayCap = Date.valueOf(ngayCapCCCD);
        Date ngayHetHan = Date.valueOf(ngayHetHanCCCD);

        if (ngayCap.before(ngaySinhDate)) {

            request.setAttribute("error",
                    "Ngày cấp CCCD không hợp lệ.");

            request.getRequestDispatcher("addNhanVien.jsp")
                    .forward(request, response);

            return;

        }

        if (ngayHetHan.before(ngayCap)) {

            request.setAttribute("error",
                    "Ngày hết hạn CCCD phải sau ngày cấp.");

            request.getRequestDispatcher("addNhanVien.jsp")
                    .forward(request, response);

            return;

        }
        NhanVien nv = new NhanVien();

        nv.setHoTen(hoTen);

        nv.setCccd(cccd);

        nv.setNgayCapCCCD(Date.valueOf(ngayCapCCCD));

        nv.setNgayHetHanCCCD(Date.valueOf(ngayHetHanCCCD));

        nv.setNoiCapCCCD(noiCapCCCD);

        nv.setNgaySinh(Date.valueOf(ngaySinh));

        nv.setGioiTinh(Boolean.parseBoolean(gioiTinh));

        nv.setSoDienThoai(soDienThoai);

        nv.setEmail(email);

        nv.setCoSo(coSo);

        nv.setTinhThanhPho(tinhThanhPho);

        nv.setQuanHuyen(quanHuyen);

        nv.setPhuongXa(phuongXa);

        nv.setDiaChiChiTiet(diaChiChiTiet);

        nv.setDiaChi(
                tinhThanhPho + ", "
                        + quanHuyen + ", "
                        + phuongXa + ", "
                        + diaChiChiTiet
        );

        nv.setAnhCCCDTruoc(anhCCCDTruoc);

        nv.setAnhCCCDSau(anhCCCDSau);

        nv.setTrangThaiID(Integer.parseInt(trangThai));

        boolean success = service.addNhanVien(nv, username, password);

        if (!success) {

            request.setAttribute(
                    "error",
                    "Thêm nhân viên thất bại. Vui lòng kiểm tra lại dữ liệu."
            );

            request.getRequestDispatcher("addNhanVien.jsp")
                    .forward(request, response);

            return;
        }

        response.sendRedirect("nhanvien");

    }
}
