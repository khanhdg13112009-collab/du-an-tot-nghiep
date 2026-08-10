package Controllers;

import Models.ThongKe;
import Services.ThongKeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Models.Account;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/thongKe")
public class ThongKeController extends HttpServlet {

    private ThongKeService service = new ThongKeService();

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
        LocalDate today = LocalDate.now();

        ThongKe tk = service.thongKeTheoNgay(today.toString());

        request.setAttribute("tk", tk);

        request.setAttribute(
                "chartData",
                service.getDoanhThu12Thang(today.getYear())
        );

        request.getRequestDispatcher("thongke.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
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

        String loai = request.getParameter("loai");

        ThongKe tk = null;

        int namChart = LocalDate.now().getYear();

        if ("ngay".equals(loai)) {

            String ngay = request.getParameter("ngay");

            tk = service.thongKeTheoNgay(ngay);

        } else if ("thang".equals(loai)) {

            int thang = Integer.parseInt(request.getParameter("thang"));
            namChart = Integer.parseInt(request.getParameter("nam"));

            tk = service.thongKeTheoThang(thang, namChart);

        } else if ("nam".equals(loai)) {

            namChart = Integer.parseInt(request.getParameter("nam"));

            tk = service.thongKeTheoNam(namChart);

        }

        request.setAttribute("tk", tk);

        request.setAttribute(
                "chartData",
                service.getDoanhThu12Thang(namChart)
        );

        request.getRequestDispatcher("thongke.jsp")
                .forward(request, response);
    }
}