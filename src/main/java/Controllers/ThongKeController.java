package Controllers;

import Models.ThongKe;
import Services.ThongKeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/thongKe")
public class ThongKeController extends HttpServlet {

    private ThongKeService service = new ThongKeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("thongke.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loai = request.getParameter("loai");

        ThongKe tk = null;

        if ("ngay".equals(loai)) {

            String ngay = request.getParameter("ngay");
            tk = service.thongKeTheoNgay(ngay);

        } else if ("thang".equals(loai)) {

            int thang = Integer.parseInt(request.getParameter("thang"));
            int nam = Integer.parseInt(request.getParameter("nam"));

            tk = service.thongKeTheoThang(thang, nam);

        } else if ("nam".equals(loai)) {

            int nam = Integer.parseInt(request.getParameter("nam"));

            tk = service.thongKeTheoNam(nam);

        }

        request.setAttribute("tk", tk);
        request.getRequestDispatcher("thongke.jsp").forward(request, response);
    }
}