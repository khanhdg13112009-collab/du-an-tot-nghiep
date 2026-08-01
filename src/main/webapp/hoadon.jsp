<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Quản lý hóa đơn</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">

    <style>

        table{

            width:100%;
            border-collapse:collapse;
            background:white;
            margin-top:20px;

        }

        table th,
        table td{

            border:1px solid #ddd;
            padding:10px;
            text-align:center;

        }

        table th{

            background:#222;
            color:white;

        }

        .btn{

            padding:8px 14px;
            border:none;
            border-radius:6px;
            cursor:pointer;
            color:white;
            text-decoration:none;

        }

        .detail{

            background:#0d6efd;

        }

        .delete{

            background:#dc3545;

        }

    </style>

</head>

<body>

<div class="sidebar">

    <h2>BO THẰNG CHÁ</h2>

    <a href="admin">🏠 Dashboard</a>

    <a href="sanpham">👕 Quản lý sản phẩm</a>

    <a href="nhanvien">👨 Quản lý nhân viên</a>

    <a href="khachhang">👤 Quản lý khách hàng</a>

    <a href="hoaDon">🧾 Quản lý hóa đơn</a>

    <a href="logout">🚪 Đăng xuất</a>

</div>

<div class="content">

    <h1>Danh sách hóa đơn</h1>

    <table>

        <tr>

            <th>Mã HD</th>

           <th>Khách hàng</th>

           <th>Nhân viên</th>

            <th>Ngày đặt</th>

            <th>Tổng tiền</th>

            <th>Trạng thái</th>

            <th>Thao tác</th>

        </tr>

        <c:forEach items="${listHoaDon}" var="hd">

            <tr>

                <td>${hd.maHD}</td>

                <td>${hd.tenKhachHang}</td>

                <td>${hd.tenNhanVien}</td>

                <td>${hd.ngayDat}</td>

                <td>${hd.tongTien}</td>

                <td>${hd.trangThai}</td>

                <td>

                    <a class="btn detail"
                       href="chiTietHoaDon?maHD=${hd.maHD}">
                        Chi tiết
                    </a>



                </td>

            </tr>

        </c:forEach>

    </table>

</div>

</body>
</html>