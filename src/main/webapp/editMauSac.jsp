<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Sửa màu sắc</title>

    <link rel="stylesheet"
    href="${pageContext.request.contextPath}/css/style2.css">

</head>

<body>

<div class="form-box">

    <h2>SỬA MÀU SẮC</h2>

    <form action="editMauSac" method="post">

        <input
                type="hidden"
                name="maMau"
                value="${ms.maMau}">

        <label>Tên màu</label>

        <input
                type="text"
                name="tenMau"
                value="${ms.tenMau}"
                required>

        <br><br>

        <button type="submit">

            Cập nhật

        </button>

        <a href="mausac">

            Quay lại

        </a>

    </form>

</div>

</body>

</html>