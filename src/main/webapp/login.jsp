<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Đăng nhập</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="login-box">

    <div class="logo">👔</div>

    <h1>SHOP ÁO CHO NAM</h1>

    <h2>Đăng nhập hệ thống</h2>

    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>

    <form action="login" method="post">

        <table>

            <tr>

                <td width="35%">Tên đăng nhập</td>

                <td>
                    <input
                            type="text"
                            name="username"
                            placeholder="Nhập tên đăng nhập"
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
                            required>
                </td>

            </tr>

        </table>

        <br>

        <button type="submit">

            🔐 Đăng nhập

        </button>

    </form>

    <br>

    <div style="text-align:center;">

        <a class="forgot-link"
           href="forgotPassword.jsp">

            Quên mật khẩu?

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