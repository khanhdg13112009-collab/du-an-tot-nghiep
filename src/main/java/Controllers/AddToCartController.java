package Controllers;

import Models.Cart;
import Models.SanPhamChiTiet;
import Services.SanPhamChiTietService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/add-to-cart")
public class AddToCartController extends HttpServlet {

    SanPhamChiTietService service = new SanPhamChiTietService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int maSPCT = Integer.parseInt(request.getParameter("maSPCT"));

        int soLuong = Integer.parseInt(request.getParameter("soLuong"));

        SanPhamChiTiet sp = service.getByMaSPCT(maSPCT);

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {

            cart = new Cart();

        }

        cart.add(sp, soLuong);

        session.setAttribute("cart", cart);

        response.sendRedirect("gio-hang");

    }

}