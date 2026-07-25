<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Sửa màu sắc</title>

    <link rel="stylesheet" href="/DATN-nhom2/css/admin.css">

</head>

<body>

<div class="sidebar">

    <h2>BO THẰNG CHÁ</h2>

    <a href="admin">🏠 Dashboard</a>

    <a href="sanpham" class="active">👕 Quản lý sản phẩm</a>

    <a href="nhanvien">👨 Quản lý nhân viên</a>

    <a href="khachhang">👤 Quản lý khách hàng</a>

    <a href="hoaDon">🧾 Quản lý hóa đơn</a>

    <a href="/DATN-nhom2/logout">🚪 Đăng xuất</a>

</div>

<div class="content">

    <h1>Sửa màu sắc</h1>

    <div class="table-box">

        <form action="editMauSac" method="post">

            <input type="hidden"
                   name="maMau"
                   value="${ms.maMau}">

            <table>

                <tr>
                    <td><b>Tên màu sắc</b></td>
                    <td>
                        <input type="text"
                               name="tenMau"
                               value="${ms.tenMau}"
                               required>
                    </td>
                </tr>

            </table>

            <br>

            <button type="submit" class="btn btn-success">

                💾 Cập nhật

            </button>

            <a href="mausac" class="btn btn-gray">

                ↩ Quay lại

            </a>

        </form>

    </div>

</div>

</body>

</html>