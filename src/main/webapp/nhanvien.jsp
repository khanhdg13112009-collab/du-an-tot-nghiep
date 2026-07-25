<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Quản lý nhân viên</title>

    <link rel="stylesheet" href="/DATN-nhom2/css/admin.css">

</head>

<body>

<div class="sidebar">

    <h2>BO THẰNG CHÁ</h2>

    <a href="admin">🏠 Dashboard</a>

    <a href="sanpham">👕 Quản lý sản phẩm</a>

    <a href="nhanvien" class="active">👨 Quản lý nhân viên</a>

    <a href="khachhang">👤 Quản lý khách hàng</a>

    <a href="hoaDon">🧾 Quản lý hóa đơn</a>

    <a href="logout">🚪 Đăng xuất</a>

</div>

<div class="content">

    <h1>Quản lý nhân viên</h1>

    <div class="toolbar">

        <a href="addNhanVien" class="btn btn-success">

            ➕ Thêm nhân viên

        </a>

    </div>

    <div class="table-box">

        <table>

            <thead>

            <tr>

                <th>Mã</th>
                <th>Họ tên</th>
                <th>CCCD</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th>SĐT</th>
                <th>Email</th>
                <th>Cơ sở</th>
                <th>Trạng thái</th>
                <th>Thao tác</th>

            </tr>

            </thead>

            <tbody>

            <c:forEach items="${list}" var="nv">

                <tr>

                    <td>${nv.maNV}</td>

                    <td>${nv.hoTen}</td>

                    <td>${nv.cccd}</td>

                    <td>${nv.ngaySinh}</td>

                    <td>

                        <c:choose>

                            <c:when test="${nv.gioiTinh}">
                                Nam
                            </c:when>

                            <c:otherwise>
                                Nữ
                            </c:otherwise>

                        </c:choose>

                    </td>

                    <td>${nv.soDienThoai}</td>

                    <td>${nv.email}</td>

                    <td>${nv.coSo}</td>

                    <td>

                        <c:choose>

                            <c:when test="${nv.trangThaiID == 1}">

                                <span class="status-on">

                                    🟢 Đang làm

                                </span>

                            </c:when>

                            <c:otherwise>

                                <span class="status-off">

                                    🔴 Nghỉ việc

                                </span>

                            </c:otherwise>

                        </c:choose>

                    </td>

                    <td>

                        <a href="chiTietNhanVien?maNV=${nv.maNV}"
                           class="btn">

                            👁 Chi tiết

                        </a>

                        <a href="editNhanVien?maNV=${nv.maNV}"
                           class="btn">

                            ✏️ Sửa

                        </a>

                    </td>

                </tr>

            </c:forEach>

            </tbody>

        </table>

    </div>

</div>

</body>

</html>