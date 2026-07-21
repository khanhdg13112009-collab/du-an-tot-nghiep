package Controllers;

import Models.SanPham;
import Models.SanPhamChiTiet;
import Services.SanPhamService;
import Services.SanPhamChiTietService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/home")
public class HomeController extends HttpServlet {

    private final SanPhamService sanPhamService = new SanPhamService();

    private final SanPhamChiTietService sanPhamChiTietService = new SanPhamChiTietService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String keyword = request.getParameter("keyword");

        ArrayList<SanPham> listSanPham;

        if (keyword == null || keyword.trim().isEmpty()) {
            listSanPham = sanPhamService.getAll();
        } else {
            listSanPham = sanPhamService.search(keyword.trim());
        }

        ArrayList<SanPhamChiTiet> listChiTiet = sanPhamChiTietService.getAll();

        request.setAttribute("keyword", keyword);
        request.setAttribute("listSanPham", listSanPham);
        request.setAttribute("listChiTiet", listChiTiet);

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }
}