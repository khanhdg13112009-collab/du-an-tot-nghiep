<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="vi">

<head>

    <meta charset="UTF-8">

    <title>Giỏ hàng</title>

    <link rel="stylesheet" href="assets/css/cart.css">

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

        <tr>

            <th>Sản phẩm</th>

            <th>Màu</th>

            <th>Size</th>

            <th>Giá</th>

            <th>Số lượng</th>

            <th>Thành tiền</th>

            <th>Thao tác</th>

        </tr>

        <c:forEach items="${cart.items}" var="item">

            <tr>

                <td>${item.sanPham.tenSP}</td>

                <td>${item.sanPham.tenMau}</td>

                <td>${item.sanPham.tenSize}</td>

                <td>${item.sanPham.gia}</td>

                <td>

                    <a href="quantity-cart?action=minus&maSPCT=${item.sanPham.maSPCT}">
                        <button>-</button>
                    </a>

                    <span style="margin:0 10px;">
                        ${item.soLuong}
                    </span>

                    <a href="quantity-cart?action=plus&maSPCT=${item.sanPham.maSPCT}">
                        <button>+</button>
                    </a>

                </td>

                <td>${item.thanhTien}</td>

                <td>

                    <a href="remove-cart?maSPCT=${item.sanPham.maSPCT}">

                        <button>Xóa</button>

                    </a>

                </td>

            </tr>

        </c:forEach>

    </table>

    <h2>

        Tổng tiền:

        ${cart.tongTien} VNĐ

    </h2>

    <br>

    <a href="home">

        <button>Tiếp tục mua</button>

    </a>

</div>

</body>

</html>