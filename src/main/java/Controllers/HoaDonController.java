package Controllers;

import Models.HoaDon;
import Services.HoaDonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/hoaDon")
public class HoaDonController extends HttpServlet {

    HoaDonService hoaDonService = new HoaDonService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {

            List<HoaDon> list =
                    hoaDonService.getAllHoaDon();

            request.setAttribute("listHoaDon", list);

            request.getRequestDispatcher("/hoadon.jsp")
                    .forward(request, response);

            return;
        }

        switch (action) {

            case "delete":

                deleteHoaDon(request, response);

                break;

            default:

                List<HoaDon> list =
                        hoaDonService.getAllHoaDon();

                request.setAttribute("listHoaDon", list);

                request.getRequestDispatcher("/hoadon.jsp")
                        .forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }

    private void deleteHoaDon(HttpServletRequest request,
                              HttpServletResponse response)
            throws IOException {

        int maHD =
                Integer.parseInt(request.getParameter("maHD"));

        hoaDonService.deleteHoaDon(maHD);

        response.sendRedirect("hoaDon");

    }

}