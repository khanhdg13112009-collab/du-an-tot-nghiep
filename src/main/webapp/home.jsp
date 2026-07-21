<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>

    <meta charset="UTF-8">

    <title>BO THẰNG CHÁ</title>

    <link rel="stylesheet" href="/DATN-nhom2/css/home.css">

</head>

<body>


<header>

    <div class="logo">

        <a href="home">

            <h1>BO THẰNG CHÁ</h1>

        </a>

    </div>

    <div class="search">

        <form action="home" method="get">

            <input
                    type="text"
                    name="keyword"
                    value="${keyword}"
                    placeholder="Tìm kiếm sản phẩm...">

            <button type="submit">

                Tìm

            </button>

        </form>

    <div class="login">

        <a href="gio-hang">🛒 Giỏ hàng</a>

        <%
            Models.Account account =
                    (Models.Account) session.getAttribute("account");
        %>

        <% if(account == null){ %>

            <a href="login.jsp">Đăng nhập</a>

        <% }else{ %>

            <span>Xin chào <%= account.getUsername() %></span>

            <a href="logout">Đăng xuất</a>

        <% } %>

    </div>

</header>

<nav>

    <ul>

        <li><a href="#">Áo thun</a></li>

        <li><a href="#">Polo</a></li>

        <li><a href="#">Sơ mi</a></li>

        <li><a href="#">Hoodie</a></li>

        <li><a href="#">Sweater</a></li>

        <li><a href="#">Jacket</a></li>

    </ul>

</nav>

<section class="banner">

    <h2>BO THẰNG CHÁ</h2>

    <p>Thời trang nam hiện đại</p>

</section>

<section class="product-section">

    <h2>SẢN PHẨM</h2>

    <div class="product-grid">

        <c:choose>

            <c:when test="${empty listSanPham}">

                <h3>Không có sản phẩm.</h3>

            </c:when>

            <c:otherwise>

                <c:forEach items="${listSanPham}" var="sp">

                    <div class="product-card">

                        <img src="${pageContext.request.contextPath}/assets/images/no-image.png"
                             alt="Ảnh sản phẩm">

                        <h3>${sp.tenSP}</h3>

                        <p>${sp.thuongHieu}</p>

                        <a href="product-detail?maSP=${sp.maSP}">

                            <button>Mua ngay</button>

                        </a>

                    </div>

                </c:forEach>

            </c:otherwise>

        </c:choose>

    </div>

</section>

<footer>

    <p>

        © 2026 BO THẰNG CHÁ

    </p>

</footer>

</body>

</html>