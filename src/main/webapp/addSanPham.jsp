<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Thêm sản phẩm</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="form-box">

    <h1>SHOP ÁO CHO NAM</h1>

    <h2>THÊM SẢN PHẨM</h2>

    <form action="addSanPham" method="post">

        <label>Tên sản phẩm</label>

        <input type="text"
               name="tenSP"
               required>

        <br><br>

        <label>Thương hiệu</label>

        <input type="text"
               name="thuongHieu"
               required>

        <br><br>

        <label>Chất liệu</label>

        <input type="text"
               name="chatLieu"
               required>

        <br><br>

        <label>Mô tả</label>

        <textarea name="moTa"
                  rows="5"></textarea>

        <br><br>

        <label>Màu sắc</label>

        <select name="maMau">

            <c:forEach items="${mauSacList}" var="ms">

                <option value="${ms.maMau}">
                    ${ms.tenMau}
                </option>

            </c:forEach>

        </select>

        <br><br>

        <label>Kích cỡ</label>

        <select name="maSize">

            <c:forEach items="${kichCoList}" var="kc">

                <option value="${kc.maSize}">
                    ${kc.tenSize}
                </option>

            </c:forEach>

        </select>

        <br><br>

        <label>Giá bán</label>

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

        <label>Trạng thái</label>

        <select name="trangThai">

            <option value="true">

                Đang bán

            </option>

            <option value="false">

                Ngừng bán

            </option>

        </select>

        <br><br>

        <button type="submit">

            Thêm sản phẩm

        </button>

        <a class="back-btn"
           href="sanpham">

            Quay lại

        </a>

    </form>

</div>

</body>

</html>