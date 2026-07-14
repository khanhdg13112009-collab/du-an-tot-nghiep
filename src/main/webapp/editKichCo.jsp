<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Sửa kích cỡ</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="form-box">

    <h2>SỬA KÍCH CỠ</h2>

    <form action="editKichCo" method="post">

        <input type="hidden"
               name="maSize"
               value="${kc.maSize}">

        <label>Tên kích cỡ</label>

        <input type="text"
               name="tenSize"
               value="${kc.tenSize}"
               required>

        <br><br>

        <button type="submit">

            Cập nhật

        </button>

        <a href="kichco">

            Quay lại

        </a>

    </form>

</div>

</body>

</html>