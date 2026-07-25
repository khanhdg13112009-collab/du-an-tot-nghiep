package Controllers;

import Models.HoaDon;
import Models.HoaDonChiTiet;
import Services.HoaDonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/chiTietHoaDon")
public class ChiTietHoaDonController extends HttpServlet {

    HoaDonService service = new HoaDonService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int maHD =
                Integer.parseInt(request.getParameter("maHD"));

        HoaDon hd =
                service.getHoaDonById(maHD);

        List<HoaDonChiTiet> list =
                service.getChiTietHoaDon(maHD);

        request.setAttribute("hoaDon",hd);
        request.setAttribute("listCT",list);

        request.getRequestDispatcher("/chiTietHoaDon.jsp")
                .forward(request,response);

    }

}