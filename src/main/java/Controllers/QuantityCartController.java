package Controllers;

import Models.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/quantity-cart")
public class QuantityCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int maSPCT = Integer.parseInt(request.getParameter("maSPCT"));

        String action = request.getParameter("action");

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null) {

            if ("plus".equals(action)) {

                cart.tangSoLuong(maSPCT);

            } else if ("minus".equals(action)) {

                cart.giamSoLuong(maSPCT);

            }

        }

        response.sendRedirect("gio-hang");

    }

}