package Controllers;

import Models.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/remove-cart")
public class RemoveCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int maSPCT = Integer.parseInt(request.getParameter("maSPCT"));

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null) {

            cart.remove(maSPCT);

        }

        response.sendRedirect("gio-hang");

    }

}