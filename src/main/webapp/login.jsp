<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Đăng nhập</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style2.css">

</head>

<body>

<div class="banner-box">

    <img
        src="${pageContext.request.contextPath}/images/banner.png"
        alt="BTC">

</div>

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
                            autocomplete="username"
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
                            autocomplete="current-password"
                            required>
                </td>

            </tr>

        </table>

        <br>

        <button type="submit">

            🔐 Đăng nhập

        </button>

    </form>



    <div class="footer">

        © 2026 SHOP ÁO CHO NAM

        <br>

        FPT PolySchool - Nhóm 7

    </div>

</div>

</body>

</html>