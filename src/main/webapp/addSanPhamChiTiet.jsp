<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Thêm biến thể sản phẩm</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="form-box">

    <h1>SHOP ÁO CHO NAM</h1>

    <h2>THÊM BIẾN THỂ SẢN PHẨM</h2>

    <form action="addSanPhamChiTiet" method="post">

        <input type="hidden"
               name="maSP"
               value="${maSP}">

        <label>Màu sắc</label>

        <select name="maMau" required>

            <c:forEach items="${mauSacList}" var="ms">

                <option value="${ms.maMau}">
                    ${ms.tenMau}
                </option>

            </c:forEach>

        </select>

        <br><br>

        <label>Kích cỡ</label>

        <select name="maSize" required>

            <c:forEach items="${kichCoList}" var="kc">

                <option value="${kc.maSize}">
                    ${kc.tenSize}
                </option>

            </c:forEach>

        </select>

        <br><br>

        <label>Giá</label>

        <input type="number"
               name="gia"
               min="0"
               required>

        <br><br>

        <label>Số lượng</label>

        <input type="number"
               name="soLuong"
               min="0"
               required>

        <br><br>

        <button type="submit">

            Thêm

        </button>

        <a class="back-btn"
           href="sanphamchitiet?id=${maSP}">

            Quay lại

        </a>

    </form>

</div>

</body>

</html>