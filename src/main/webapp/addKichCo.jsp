<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Thêm kích cỡ</title>

    <link rel="stylesheet"
    href="${pageContext.request.contextPath}/css/style2.css">

</head>

<body>

<div class="form-box">

    <h2>THÊM KÍCH CỠ</h2>

    <form action="addKichCo" method="post">

        <label>Tên kích cỡ</label>

        <input type="text"
               name="tenSize"
               required>

        <br><br>

        <button type="submit">

            Thêm kích cỡ

        </button>

        <a href="kichco">

            Quay lại

        </a>

    </form>

</div>

</body>

</html>