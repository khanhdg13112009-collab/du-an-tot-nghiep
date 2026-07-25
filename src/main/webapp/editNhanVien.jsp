<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Sửa nhân viên</title>

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

    <h1>✏️ Sửa nhân viên</h1>

    <div class="table-box">

        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>

        <form action="editNhanVien" method="post">

            <input type="hidden"
                   name="maNV"
                   value="${nv.maNV}">

            <table>

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
                           pattern="\d{12}"
                           required>
                </td>
            </tr>

            <tr>
                <td>Ngày cấp CCCD</td>
                <td>
                    <input type="date"
                           name="ngayCapCCCD"
                           value="${nv.ngayCapCCCD}"
                           required>
                </td>
            </tr>

            <tr>
                <td>Nơi cấp CCCD</td>
                <td>

                    <select name="noiCapCCCD" required>

                        <option value="CỤC CẢNH SÁT QUẢN LÝ HÀNH CHÍNH VỀ TRẬT TỰ XÃ HỘI"
                            ${nv.noiCapCCCD == 'CỤC CẢNH SÁT QUẢN LÝ HÀNH CHÍNH VỀ TRẬT TỰ XÃ HỘI' ? 'selected' : ''}>
                            CỤC CẢNH SÁT QUẢN LÝ HÀNH CHÍNH VỀ TRẬT TỰ XÃ HỘI
                        </option>

                        <option value="CÔNG AN TỈNH, THÀNH PHỐ TRỰC THUỘC TRUNG ƯƠNG"
                            ${nv.noiCapCCCD == 'CÔNG AN TỈNH, THÀNH PHỐ TRỰC THUỘC TRUNG ƯƠNG' ? 'selected' : ''}>
                            CÔNG AN TỈNH, THÀNH PHỐ TRỰC THUỘC TRUNG ƯƠNG
                        </option>

                        <option value="CÔNG AN CẤP HUYỆN, QUẬN, THỊ XÃ, THÀNH PHỐ THUỘC TỈNH"
                            ${nv.noiCapCCCD == 'CÔNG AN CẤP HUYỆN, QUẬN, THỊ XÃ, THÀNH PHỐ THUỘC TỈNH' ? 'selected' : ''}>
                            CÔNG AN CẤP HUYỆN, QUẬN, THỊ XÃ, THÀNH PHỐ THUỘC TỈNH
                        </option>

                    </select>

                </td>
            </tr>

            <tr>
                <td>CCCD mặt trước</td>
                <td>
                    <input type="text"
                           name="anhCCCDTruoc"
                           value="${nv.anhCCCDTruoc}"
                           placeholder="images/cccd/lam_front.jpg">
                </td>
            </tr>

            <tr>
                <td>CCCD mặt sau</td>
                <td>
                    <input type="text"
                           name="anhCCCDSau"
                           value="${nv.anhCCCDSau}"
                           placeholder="images/cccd/lam_back.jpg">
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
                           pattern="(0[0-9]{9})|(\+84[0-9]{9})"
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
    <td>Mật khẩu</td>
    <td>
        <div style="display:flex;align-items:center;gap:8px;">

            <input type="password"
                   id="password"
                   name="password"
                   value="${account.password}"
                   minlength="6"
                   maxlength="50"
                   required
                   style="flex:1;">

            <button type="button"
                    onclick="togglePassword()">
                👁
            </button>

        </div>
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

                            <td>Tỉnh / Thành phố</td>

                            <td>

                                <select id="province"
                                        name="tinhThanhPho"
                                        data-selected="${nv.tinhThanhPho}"
                                        required>

                                </select>

                            </td>

                        </tr>

                        <tr>

                            <td>Phường / Xã</td>

                            <td>

                                <select id="ward"
                                        name="phuongXa"
                                        data-selected="${nv.phuongXa}"
                                        required>

                                </select>

                            </td>

                        </tr>

                        <tr>

                            <td>Địa chỉ chi tiết</td>

                            <td>

                                <input type="text"
                                       name="diaChiChiTiet"
                                       value="${nv.diaChiChiTiet}"
                                       required>

                            </td>

                        </tr>

                        <tr>

                            <td>Trạng thái</td>

                            <td>

                                <c:choose>

                                    <c:when test="${nv.roleID == 1}">

                                        <input type="text"
                                               value="Đang làm"
                                               readonly>

                                        <input type="hidden"
                                               name="trangThaiID"
                                               value="1">

                                    </c:when>

                                    <c:otherwise>

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

                                    </c:otherwise>

                                </c:choose>

                            </td>

                        </tr>

                    <tr>
                        <td colspan="2" style="text-align:center;padding:20px;">

                            <button type="submit" class="btn btn-success">
                                💾 Cập nhật
                            </button>

                            <a href="nhanvien" class="btn">
                                ↩ Quay lại
                            </a>

                        </td>
                    </tr>

                    </table>

                    </form>

                    </div>

                    </div>

                    <script src="${pageContext.request.contextPath}/js/address.js"></script>

                    <script>
                    function togglePassword() {
                        const password = document.getElementById("password");

                        if (password.type === "password") {
                            password.type = "text";
                        } else {
                            password.type = "password";
                        }
                    }
                    </script>

                    </body>
                    </html>