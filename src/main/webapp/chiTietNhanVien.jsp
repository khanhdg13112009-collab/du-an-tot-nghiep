<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false"%>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Chi tiết nhân viên</title>

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

    <h1>👤 Chi tiết nhân viên</h1>

    <div class="table-box">

        <table class="form-table">

            <tr>
                <th colspan="2">Thông tin cá nhân</th>
            </tr>

   <table class="form-table">
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
            <td><b>Tên đăng nhập</b></td>
            <td>${account.username}</td>
        </tr>

        <tr>
            <td><b>Mật khẩu</b></td>
            <td>${account.password}</td>
        </tr>

        <tr>
            <td><b>Vai trò</b></td>
            <td>
                <c:choose>
                    <c:when test="${account.roleID == 1}">
                        Quản lý
                    </c:when>

                    <c:when test="${account.roleID == 2}">
                        Nhân viên
                    </c:when>

                    <c:otherwise>
                        Khách hàng
                    </c:otherwise>
                </c:choose>
            </td>
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

    <div style="text-align:center;">

        <a href="nhanvien" class="btn">
            ⬅ Quay lại
        </a>

    </div>

    </div>

    </div>

    </body>

    </html>