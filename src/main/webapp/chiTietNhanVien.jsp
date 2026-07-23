<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Chi tiết nhân viên</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/style2.css">

</head>

<body>

<div class="profile-box">

    <div class="logo">👔</div>

    <h1>SHOP ÁO CHO NAM</h1>

    <h2>CHI TIẾT NHÂN VIÊN</h2>

    <table>

        <tr>
            <th colspan="2">Thông tin cá nhân</th>
        </tr>

        <tr>
            <td><b>Mã nhân viên</b></td>
            <td>${nv.maNV}</td>
        </tr>

        <tr>
            <td><b>Họ tên</b></td>
            <td>${nv.hoTen}</td>
        </tr>

        <tr>
            <td><b>CCCD</b></td>
            <td>${nv.cccd}</td>
        </tr>

        <tr>
            <td><b>Ngày cấp</b></td>
            <td>${nv.ngayCapCCCD}</td>
        </tr>

        <tr>
            <td><b>Nơi cấp</b></td>
            <td>${nv.noiCapCCCD}</td>
        </tr>

        <tr>
            <td><b>Ngày sinh</b></td>
            <td>${nv.ngaySinh}</td>
        </tr>

        <tr>
            <td><b>Giới tính</b></td>

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
            <td><b>Số điện thoại</b></td>
            <td>${nv.soDienThoai}</td>
        </tr>

        <tr>
            <td><b>Email</b></td>
            <td>${nv.email}</td>
        </tr>

        <tr>
            <td><b>Cơ sở</b></td>
            <td>${nv.coSo}</td>
        </tr>

        <tr>
            <td><b>Địa chỉ</b></td>

            <td>

                ${nv.diaChiChiTiet},

                ${nv.phuongXa},

                ${nv.tinhThanhPho}

            </td>

        </tr>

        <tr>
            <td><b>Trạng thái</b></td>

            <td>

                <c:choose>

                    <c:when test="${nv.trangThaiID==1}">
                        <span style="color:green;font-weight:bold;">
                            🟢 Đang làm
                        </span>
                    </c:when>

                    <c:otherwise>
                        <span style="color:red;font-weight:bold;">
                            🔴 Nghỉ việc
                        </span>
                    </c:otherwise>

                </c:choose>

            </td>

        </tr>

    </table>

    <br>

    <h2>ẢNH CCCD</h2>

    <table>

        <tr>

            <th>CCCD mặt trước</th>

            <th>CCCD mặt sau</th>

        </tr>

        <tr>

            <td align="center">

                <c:if test="${not empty nv.anhCCCDTruoc}">

                    <img src="${pageContext.request.contextPath}/${nv.anhCCCDTruoc}"
                         class="cccd-img">

                </c:if>

            </td>

            <td align="center">

                <c:if test="${not empty nv.anhCCCDSau}">

                    <img src="${pageContext.request.contextPath}/${nv.anhCCCDSau}"
                         class="cccd-img">

                </c:if>

            </td>

        </tr>

    </table>

    <br>

    <a class="back-btn"
       href="nhanVien">

        ⬅ Quay lại

    </a>

</div>

</body>

</html>