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

@WebServlet("/editNhanVien")
public class EditNhanVienController extends HttpServlet {

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

        int maNV = Integer.parseInt(request.getParameter("maNV"));

        NhanVien nv = service.getNhanVienById(maNV);

        request.setAttribute("nv", nv);

        request.getRequestDispatcher("editNhanVien.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String maNV = request.getParameter("maNV");
        String hoTen = request.getParameter("hoTen");
        String cccd = request.getParameter("cccd");
        String ngaySinh = request.getParameter("ngaySinh");
        String gioiTinh = request.getParameter("gioiTinh");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
        String coSo = request.getParameter("coSo");
        String diaChi = request.getParameter("diaChi");
        String trangThaiID = request.getParameter("trangThaiID");

        if (!cccd.matches("\\d{12}")) {

            request.setAttribute("error",
                    "CCCD phải gồm đúng 12 chữ số.");

            request.setAttribute("nv",
                    service.getNhanVienById(Integer.parseInt(maNV)));

            request.getRequestDispatcher("editNhanVien.jsp")
                    .forward(request, response);

            return;
        }

        if (!(soDienThoai.matches("0\\d{9}")
                || soDienThoai.matches("\\+84\\d{9}"))) {

            request.setAttribute("error",
                    "Số điện thoại không hợp lệ.");

            request.setAttribute("nv",
                    service.getNhanVienById(Integer.parseInt(maNV)));

            request.getRequestDispatcher("editNhanVien.jsp")
                    .forward(request, response);

            return;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

            request.setAttribute("error",
                    "Email không hợp lệ.");

            request.setAttribute("nv",
                    service.getNhanVienById(Integer.parseInt(maNV)));

            request.getRequestDispatcher("editNhanVien.jsp")
                    .forward(request, response);

            return;
        }

        LocalDate birth = LocalDate.parse(ngaySinh);

        int tuoi = Period.between(birth,
                LocalDate.now()).getYears();

        if (tuoi < 16) {

            request.setAttribute("error",
                    "Nhân viên phải từ 16 tuổi trở lên.");

            request.setAttribute("nv",
                    service.getNhanVienById(Integer.parseInt(maNV)));

            request.getRequestDispatcher("editNhanVien.jsp")
                    .forward(request, response);

            return;
        }

        NhanVien nv = new NhanVien();

        nv.setMaNV(Integer.parseInt(maNV));
        nv.setHoTen(hoTen);
        nv.setCccd(cccd);
        nv.setNgaySinh(Date.valueOf(ngaySinh));
        nv.setGioiTinh(Boolean.parseBoolean(gioiTinh));
        nv.setSoDienThoai(soDienThoai);
        nv.setEmail(email);
        nv.setCoSo(coSo);
        nv.setDiaChi(diaChi);
        nv.setTrangThaiID(Integer.parseInt(trangThaiID));

        service.updateNhanVien(nv);

        response.sendRedirect("nhanvien");
    }

}