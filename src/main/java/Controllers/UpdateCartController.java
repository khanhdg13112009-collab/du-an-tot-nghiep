package Controllers;

import Models.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/update-cart")
public class UpdateCartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int maSPCT = Integer.parseInt(request.getParameter("maSPCT"));

        int soLuong = Integer.parseInt(request.getParameter("soLuong"));

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null) {

            cart.update(maSPCT, soLuong);

        }

        response.sendRedirect("gio-hang");

    }

}