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

<div class="form-box">

    <div class="logo">👔</div>

    <h1>SHOP ÁO CHO NAM</h1>

    <h2>SỬA NHÂN VIÊN</h2>

    <c:if test="${not empty error}">

        <p class="error">

            ${error}

        </p>

    </c:if>

    <form action="editNhanVien" method="post">

        <input type="hidden"
               name="maNV"
               value="${nv.maNV}">

        <table>

            <tr>

                <td>Họ và tên</td>

                <td>

                    <input type="text"
                           name="hoTen"
                           value="${nv.hoTen}"
                           required>

                </td>

            </tr>

            <tr>

                <td>CCCD</td>

                <td>

                    <input type="text"
                           name="cccd"
                           value="${nv.cccd}"
                           maxlength="12"
                           required>

                </td>

            </tr>

            <tr>

                <td>Ngày sinh</td>

                <td>

                    <input type="date"
                           name="ngaySinh"
                           value="${nv.ngaySinh}"
                           required>

                </td>

            </tr>

            <tr>

                <td>Giới tính</td>

                <td>

                    <select name="gioiTinh">

                        <option value="true"
                            ${nv.gioiTinh ? "selected" : ""}>

                            Nam

                        </option>

                        <option value="false"
                            ${!nv.gioiTinh ? "selected" : ""}>

                            Nữ

                        </option>

                    </select>

                </td>

            </tr>

            <tr>

                <td>Số điện thoại</td>

                <td>

                    <input type="text"
                           name="soDienThoai"
                           value="${nv.soDienThoai}"
                           required>

                </td>

            </tr>

            <tr>

                <td>Email</td>

                <td>

                    <input type="email"
                           name="email"
                           value="${nv.email}"
                           required>

                </td>

            </tr>

            <tr>

                <td>Cơ sở</td>

                <td>

                    <select name="coSo">

                        <option value="FPT PolySchool Hà Nội"
                            ${nv.coSo == 'FPT PolySchool Hà Nội' ? 'selected' : ''}>

                            FPT PolySchool Hà Nội

                        </option>

                        <option value="FPT PolySchool Hồ Chí Minh"
                            ${nv.coSo == 'FPT PolySchool Hồ Chí Minh' ? 'selected' : ''}>

                            FPT PolySchool Hồ Chí Minh

                        </option>

                        <option value="FPT PolySchool Đà Nẵng"
                            ${nv.coSo == 'FPT PolySchool Đà Nẵng' ? 'selected' : ''}>

                            FPT PolySchool Đà Nẵng

                        </option>

                    </select>

                </td>

            </tr>

            <tr>

                <td>Địa chỉ</td>

                <td>

                    <input type="text"
                           name="diaChi"
                           value="${nv.diaChi}"
                           required>

                </td>

            </tr>

            <tr>

                <td>Trạng thái</td>

                <td>

                    <select name="trangThaiID">

                        <option value="1"
                            ${nv.trangThaiID == 1 ? 'selected' : ''}>

                            Đang làm

                        </option>

                        <option value="2"
                            ${nv.trangThaiID == 2 ? 'selected' : ''}>

                            Nghỉ việc

                        </option>

                    </select>

                </td>

            </tr>

        </table>

        <br>

        <button type="submit">

            💾 Cập nhật

        </button>

        <a class="back-btn"
           href="nhanvien">

            ↩ Quay lại

        </a>

    </form>

    <div class="footer">

        © 2026 SHOP ÁO CHO NAM

        <br>

        FPT PolySchool - Nhóm 7

    </div>

</div>

</body>

</html>