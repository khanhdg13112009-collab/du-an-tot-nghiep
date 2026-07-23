<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         language="java"
         isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="vi">

<head>

    <meta charset="UTF-8">

    <title>Giỏ hàng</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/cart.css">

</head>

<body>

<header>

    <a href="home">

        <h2>BO THẰNG CHÁ</h2>

    </a>

</header>

<div class="container">

    <h1>GIỎ HÀNG</h1>

    <table>

        <thead>

        <tr>

            <th>Sản phẩm</th>
            <th>Màu</th>
            <th>Size</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Thành tiền</th>
            <th>Thao tác</th>

        </tr>

        </thead>

        <tbody>

        <c:forEach items="${cart.items}" var="item">

            <tr>

                <td class="product-name">
                    ${item.sanPham.tenSP}
                </td>

                <td>${item.sanPham.tenMau}</td>

                <td>${item.sanPham.tenSize}</td>

                <td class="price">
                    ${item.sanPham.gia} VNĐ
                </td>

                <td>

                    <div class="quantity">

                        <a href="quantity-cart?action=minus&maSPCT=${item.sanPham.maSPCT}">
                            <button type="button">-</button>
                        </a>

                        <span>${item.soLuong}</span>

                        <a href="quantity-cart?action=plus&maSPCT=${item.sanPham.maSPCT}">
                            <button type="button">+</button>
                        </a>

                    </div>

                </td>

                <td class="total">

                    ${item.thanhTien} VNĐ

                </td>

                <td>

                    <a href="remove-cart?maSPCT=${item.sanPham.maSPCT}">

                        <button class="delete-btn">

                            Xóa

                        </button>

                    </a>

                </td>

            </tr>

        </c:forEach>

        </tbody>

    </table>

    <div class="bottom">

        <h2>

            Tổng tiền:

            <span>${cart.tongTien} VNĐ</span>

        </h2>

        <div>

            <a href="home">

                <button class="continue-btn">

                    Tiếp tục mua

                </button>

            </a>

            <a href="checkout">
                <button class="checkout-btn">
                    Thanh toán
                </button>
            </a>

        </div>

    </div>

</div>

</body>

</html>