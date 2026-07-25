<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Sửa sản phẩm</title>

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

    <a href="logout">🚪 Đăng xuất</a>

</div>

<div class="content">

    <h1>Sửa sản phẩm</h1>

    <div class="table-box" style="padding:30px;">

        <form action="editSanPham" method="post">

            <input type="hidden"
                   name="maSP"
                   value="${sp.maSP}">

            <label>Tên sản phẩm</label><br>

            <input type="text"
                   name="tenSP"
                   value="${sp.tenSP}"
                   required>

            <br><br>

            <label>Thương hiệu</label><br>

            <input type="text"
                   name="thuongHieu"
                   value="${sp.thuongHieu}"
                   required>

            <br><br>

            <label>Chất liệu</label><br>

            <input type="text"
                   name="chatLieu"
                   value="${sp.chatLieu}"
                   required>

            <br><br>

            <label>Mô tả</label><br>

            <textarea
                    name="moTa"
                    rows="5">${sp.moTa}</textarea>

            <br><br>

            <label>Trạng thái</label><br>

            <select name="trangThai">

                <option value="true"
                    ${sp.trangThai ? "selected" : ""}>
                    Đang bán
                </option>

                <option value="false"
                    ${!sp.trangThai ? "selected" : ""}>
                    Ngừng bán
                </option>

            </select>

            <br><br>

            <button type="submit" class="btn">
                💾 Cập nhật
            </button>

            <a href="sanpham" class="btn btn-gray">
                ← Quay lại
            </a>

        </form>

    </div>

</div>

</body>
</html>