<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Sửa biến thể sản phẩm</title>

    <link rel="stylesheet"
    href="${pageContext.request.contextPath}/css/style2.css">

</head>

<body>

<div class="form-box">

    <h1>SHOP ÁO CHO NAM</h1>

    <h2>SỬA BIẾN THỂ</h2>

    <form action="editSanPhamChiTiet" method="post">

        <input type="hidden"
               name="maSPCT"
               value="${spct.maSPCT}">

        <input type="hidden"
               name="maSP"
               value="${spct.maSP}">

        <label>Màu sắc</label>

        <select name="maMau">

            <c:forEach items="${mauSacList}" var="ms">

                <option value="${ms.maMau}"
                    ${spct.maMau==ms.maMau?"selected":""}>

                    ${ms.tenMau}

                </option>

            </c:forEach>

        </select>

        <br><br>

        <label>Kích cỡ</label>

        <select name="maSize">

            <c:forEach items="${kichCoList}" var="kc">

                <option value="${kc.maSize}"
                    ${spct.maSize==kc.maSize?"selected":""}>

                    ${kc.tenSize}

                </option>

            </c:forEach>

        </select>

        <br><br>

        <label>Giá</label>

        <input type="number"
               name="gia"
               value="${spct.gia}"
               required>

        <br><br>

        <label>Số lượng</label>

        <input type="number"
               name="soLuong"
               value="${spct.soLuong}"
               required>

        <br><br>

        <button type="submit">

            Cập nhật

        </button>

        <a class="back-btn"
           href="sanphamchitiet?id=${spct.maSP}">

            Quay lại

        </a>

    </form>

</div>

</body>

</html>