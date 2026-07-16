<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Thêm màu sắc</title>

    <link rel="stylesheet"
    href="${pageContext.request.contextPath}/css/style2.css">

</head>

<body>

<div class="form-box">

    <h2>THÊM MÀU SẮC</h2>

    <form action="addMauSac" method="post">

        <label>Tên màu</label>

        <input
                type="text"
                name="tenMau"
                required>

        <br><br>

        <button type="submit">

            Thêm màu

        </button>

        <a href="mausac">

            Quay lại

        </a>

    </form>

</div>

</body>

</html>