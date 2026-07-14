<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Quản lý kích cỡ</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="nhanvien-box">

    <h2>QUẢN LÝ KÍCH CỠ</h2>

    <a class="add-btn" href="addKichCo">

        ➕ Thêm kích cỡ

    </a>

    <table>

        <tr>

            <th>Mã Size</th>

            <th>Tên Size</th>

            <th>Chức năng</th>

        </tr>

        <c:forEach items="${list}" var="kc">

            <tr>

                <td>${kc.maSize}</td>

                <td>${kc.tenSize}</td>

                <td>

                    <a class="action-btn edit-btn"
                       href="editKichCo?id=${kc.maSize}">

                        Sửa

                    </a>

                    <a class="action-btn delete-btn"
                       href="deleteKichCo?id=${kc.maSize}"
                       onclick="return confirm('Bạn có chắc muốn xóa?')">

                        Xóa

                    </a>

                </td>

            </tr>

        </c:forEach>

    </table>

    <br>

    <a class="back-btn" href="home.jsp">

        ← Quay lại Trang chủ

    </a>

</div>

</body>

</html>