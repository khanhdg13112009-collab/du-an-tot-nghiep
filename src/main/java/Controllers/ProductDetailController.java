package Controllers;

import Models.SanPham;
import Models.SanPhamChiTiet;
import Services.SanPhamChiTietService;
import Services.SanPhamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/product-detail")
public class ProductDetailController extends HttpServlet {

    private final SanPhamService sanPhamService = new SanPhamService();

    private final SanPhamChiTietService sanPhamChiTietService = new SanPhamChiTietService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("maSP");

        if (id == null || id.trim().isEmpty()) {

            response.sendRedirect("home");
            return;

        }

        int maSP = Integer.parseInt(id);

        SanPham sanPham = sanPhamService.getById(maSP);

        if (sanPham == null) {

            response.sendRedirect("home");
            return;

        }

        ArrayList<SanPhamChiTiet> listChiTiet =
                sanPhamChiTietService.getBySanPham(maSP);

        request.setAttribute("sanPham", sanPham);

        request.setAttribute("listChiTiet", listChiTiet);

        request.getRequestDispatcher("product-detail.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }

}