<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Trang chủ</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="profile-box">

    <div class="logo">👔</div>

    <h1>SHOP ÁO CHO NAM</h1>

    <h2>THÔNG TIN CÁ NHÂN</h2>

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

                        <span style="color:green;font-weight:bold;">

                            ✅ Đã cập nhật

                        </span>

                    </c:when>

                    <c:otherwise>

                        <span style="color:red;">

                            Chưa cập nhật

                        </span>

                    </c:otherwise>

                </c:choose>

            </td>

        </tr>

        <tr>

            <td>CCCD mặt sau</td>

            <td>

                <c:choose>

                    <c:when test="${not empty nv.anhCCCDSau}">

                        <span style="color:green;font-weight:bold;">

                            ✅ Đã cập nhật

                        </span>

                    </c:when>

                    <c:otherwise>

                        <span style="color:red;">

                            Chưa cập nhật

                        </span>

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

                        Đang làm

                    </c:when>

                    <c:otherwise>

                        Nghỉ việc

                    </c:otherwise>

                </c:choose>

            </td>

        </tr>

    </table>

    <br>

    <a class="back-btn" href="home.jsp">

        🏠 Quay lại Trang chủ

    </a>

    <div class="footer">

        © 2026 SHOP ÁO CHO NAM

        <br>

        FPT PolySchool - Nhóm 7

    </div>

</div>

</body>

</html>