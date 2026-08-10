<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Thông tin cá nhân</title>

    <link rel="stylesheet" href="/DATN-nhom2/css/admin.css">

</head>

<body>

<div class="sidebar">

    <h2>BTC</h2>

    <a href="home.jsp" class="active">🏠 Trang chủ</a>

    <a href="profile">👤 Thông tin cá nhân</a>

    <a href="/DATN-nhom2/logout">🚪 Đăng xuất</a>

</div>

<div class="content">

    <h1>Thông tin cá nhân</h1>

    <div class="table-box">

        <table>

            <tr>
                <th width="35%">Thông tin</th>
                <th>Chi tiết</th>
            </tr>

            <tr>
                <td>Mã nhân viên</td>
                <td>${nv.maNV}</td>
            </tr>

            <tr>
                <td>Họ và tên</td>
                <td>${nv.hoTen}</td>
            </tr>

            <tr>
                <td>Căn cước công dân</td>
                <td>${nv.cccd}</td>
            </tr>

            <tr>
                <td>CCCD mặt trước</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty nv.anhCCCDTruoc}">
                            <span class="status-on">✅ Đã cập nhật</span>
                        </c:when>
                        <c:otherwise>
                            <span class="status-off">Chưa cập nhật</span>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>

            <tr>
                <td>CCCD mặt sau</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty nv.anhCCCDSau}">
                            <span class="status-on">✅ Đã cập nhật</span>
                        </c:when>
                        <c:otherwise>
                            <span class="status-off">Chưa cập nhật</span>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>

            <tr>
                <td>Ngày sinh</td>
                <td>${nv.ngaySinh}</td>
            </tr>

            <tr>
                <td>Giới tính</td>
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
            </tr>

            <tr>
                <td>Số điện thoại</td>
                <td>${nv.soDienThoai}</td>
            </tr>

            <tr>
                <td>Email</td>
                <td>${nv.email}</td>
            </tr>

            <tr>
                <td>Cơ sở</td>
                <td>${nv.coSo}</td>
            </tr>

            <tr>
                <td>Địa chỉ</td>
                <td>${nv.diaChi}</td>
            </tr>

            <tr>
                <td>Trạng thái</td>
                <td>
                    <c:choose>
                        <c:when test="${nv.trangThaiID == 1}">
                            <span class="status-on">Đang làm</span>
                        </c:when>
                        <c:otherwise>
                            <span class="status-off">Nghỉ việc</span>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>

        </table>

    </div>

    <br>

    <a href="home.jsp" class="btn btn-gray">

        ↩ Quay lại Trang chủ

    </a>

</div>

</body>

</html>