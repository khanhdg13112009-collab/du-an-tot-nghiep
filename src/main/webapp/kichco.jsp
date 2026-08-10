<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Quản lý kích cỡ</title>

    <link rel="stylesheet" href="/DATN-nhom2/css/admin.css">

</head>

<body>

<div class="sidebar">

    <h2>BTC</h2>

    <a href="admin">🏠 Dashboard</a>

    <a href="sanpham" class="active">👕 Quản lý sản phẩm</a>

    <a href="nhanvien">👨 Quản lý nhân viên</a>

    <a href="khachhang">👤 Quản lý khách hàng</a>

    <a href="hoaDon">🧾 Quản lý hóa đơn</a>

    <a href="/DATN-nhom2/logout">🚪 Đăng xuất</a>

</div>

<div class="content">

    <h1>Quản lý kích cỡ</h1>

    <div class="toolbar">

        <a href="addKichCo" class="btn btn-success">

            ➕ Thêm kích cỡ

        </a>

    </div>

    <div class="table-box">

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

                        <a href="editKichCo?id=${kc.maSize}"
                           class="btn">

                            ✏ Sửa

                        </a>

                        <a href="deleteKichCo?id=${kc.maSize}"
                           class="btn"
                           onclick="return confirm('Bạn có chắc muốn xóa?')">

                            🗑 Xóa

                        </a>

                    </td>

                </tr>

            </c:forEach>

        </table>

    </div>

    <br>

    <a href="sanpham" class="btn btn-gray">

        ↩ Quay lại

    </a>

</div>

</body>

</html>