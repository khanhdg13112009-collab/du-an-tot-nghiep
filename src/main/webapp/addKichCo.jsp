<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Thêm kích cỡ</title>

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

    <h1>Thêm kích cỡ</h1>

    <div class="table-box">

        <form action="addKichCo" method="post">

            <table>

                <tr>
                    <td><b>Tên kích cỡ</b></td>
                    <td>
                        <input type="text"
                               name="tenSize"
                               placeholder="Ví dụ: S, M, L, XL..."
                               required>
                    </td>
                </tr>

            </table>

            <br>

            <button type="submit" class="btn btn-success">

                ➕ Thêm kích cỡ

            </button>

            <a href="kichco" class="btn btn-gray">

                ↩ Quay lại

            </a>

        </form>

    </div>

</div>

</body>

</html>