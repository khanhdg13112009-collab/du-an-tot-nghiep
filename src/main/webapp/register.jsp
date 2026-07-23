<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Đăng ký tài khoản</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style2.css">

</head>

<body>

<div class="login-box">

    <div class="logo">👔</div>

    <h1>SHOP ÁO CHO NAM</h1>

    <h2>Đăng ký tài khoản</h2>

    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>

    <form action="register" method="post">

        <table>

            <tr>
                <td width="35%">Email</td>
                <td>
                    <input
                            type="email"
                            name="email"
                            placeholder="Nhập email"
                            required>
                </td>
            </tr>

            <tr>
                <td>Tên đăng nhập</td>
                <td>
                    <input
                            type="text"
                            name="username"
                            placeholder="Nhập tên đăng nhập"
                            required>
                </td>
            </tr>

            <tr>
                <td>Số điện thoại</td>
                <td>
                    <input
                            type="text"
                            name="soDienThoai"
                            placeholder="Nhập số điện thoại"
                            pattern="0[0-9]{9}"
                            title="Số điện thoại phải gồm 10 chữ số"
                            required>
                </td>
            </tr>

            <tr>
                <td>Mật khẩu</td>
                <td>
                    <input
                            type="password"
                            name="password"
                            placeholder="Nhập mật khẩu"
                            minlength="6"
                            required>
                </td>
            </tr>

            <tr>
                <td>Nhập lại mật khẩu</td>
                <td>
                    <input
                            type="password"
                            name="rePassword"
                            placeholder="Nhập lại mật khẩu"
                            required>
                </td>
            </tr>

        </table>

        <br>

        <button type="submit">

            📝 Đăng ký

        </button>

    </form>

    <br>

    <div style="text-align:center;">

        Đã có tài khoản?

        <a class="forgot-link"
           href="login.jsp">

            Đăng nhập

        </a>

    </div>

    <div class="footer">

        © 2026 SHOP ÁO CHO NAM

        <br>

        FPT PolySchool - Nhóm 7

    </div>

</div>

</body>

</html>