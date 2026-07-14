<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Sửa sản phẩm</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="form-box">

    <h1>SHOP ÁO CHO NAM</h1>

    <h2>SỬA SẢN PHẨM</h2>

    <form action="editSanPham" method="post">

        <input
                type="hidden"
                name="maSP"
                value="${sp.maSP}">

        <label>Tên sản phẩm</label>

        <input
                type="text"
                name="tenSP"
                value="${sp.tenSP}"
                required>

        <br><br>

        <label>Thương hiệu</label>

        <input
                type="text"
                name="thuongHieu"
                value="${sp.thuongHieu}"
                required>

        <br><br>

        <label>Chất liệu</label>

        <input
                type="text"
                name="chatLieu"
                value="${sp.chatLieu}"
                required>

        <br><br>

        <label>Mô tả</label>

        <textarea
                name="moTa"
                rows="5"
                required>${sp.moTa}</textarea>

        <br><br>

        <label>Trạng thái</label>

        <select name="trangThai">

            <option value="true"
                ${sp.trangThai ? "selected" : ""}>

                Đang bán

            </option>

            <option value="false"
                ${!sp.trangThai ? "selected" : ""}>

                Ngừng bán

            </option>

        </select>

        <br><br>

        <button type="submit">

            Cập nhật

        </button>

        <a class="back-btn"
           href="sanpham">

            Quay lại

        </a>

    </form>

</div>

</body>

</html>