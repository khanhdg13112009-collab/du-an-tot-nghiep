package Controllers;

import Models.SanPhamChiTiet;
import Services.SanPhamChiTietService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/get-spct")
public class GetSanPhamChiTietController extends HttpServlet {

    private final SanPhamChiTietService service = new SanPhamChiTietService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");

        String id = request.getParameter("maSP");

        if (id == null || id.trim().isEmpty()) {
            response.getWriter().write("[]");
            return;
        }

        int maSP = Integer.parseInt(id);

        ArrayList<SanPhamChiTiet> list = service.getBySanPham(maSP);

        Gson gson = new Gson();

        response.getWriter().write(gson.toJson(list));
    }

}