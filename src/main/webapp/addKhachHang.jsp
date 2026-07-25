<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Thêm khách hàng</title>

    <link rel="stylesheet"
          href="/DATN-nhom2/css/admin.css">

</head>

<body>

<div class="sidebar">

    <h2>BO THẰNG CHÁ</h2>

    <a href="admin">🏠 Dashboard</a>

    <a href="sanpham">👕 Quản lý sản phẩm</a>

    <a href="nhanvien">👨 Quản lý nhân viên</a>

    <a href="khachhang" class="active">👤 Quản lý khách hàng</a>

    <a href="hoaDon">🧾 Quản lý hóa đơn</a>

    <a href="/DATN-nhom2/logout">🚪 Đăng xuất</a>

</div>

<div class="content">

    <h1>Thêm khách hàng</h1>

    <div class="table-box">

        <form action="addKhachHang" method="post">

            <table>

                <tr>
                    <td><b>Họ tên</b></td>
                    <td>
                        <input type="text"
                               name="hoTen"
                               required>
                    </td>
                </tr>

                <tr>
                    <td><b>Số điện thoại</b></td>
                    <td>
                        <input type="text"
                               name="soDienThoai"
                               required>
                    </td>
                </tr>

                <tr>
                    <td><b>Email</b></td>
                    <td>
                        <input type="email"
                               name="email">
                    </td>
                </tr>

            </table>

            <br>

            <button type="submit"
                    class="btn btn-success">

                ➕ Thêm khách hàng

            </button>

            <a href="khachhang"
               class="btn btn-gray">

                ↩ Quay lại

            </a>

        </form>

    </div>

</div>

</body>

</html>