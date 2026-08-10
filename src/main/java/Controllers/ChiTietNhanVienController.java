package Controllers;

import Models.NhanVien;
import Services.NhanVienService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/chiTietNhanVien")
public class ChiTietNhanVienController extends HttpServlet {

    NhanVienService service = new NhanVienService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int maNV = Integer.parseInt(request.getParameter("maNV"));

        NhanVien nv = service.getNhanVienById(maNV);

        request.setAttribute("nv", nv);

        request.getRequestDispatcher("chiTietNhanVien.jsp")
                .forward(request, response);
    }
}
//kk