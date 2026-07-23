<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Trang chủ</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style2.css">

</head>


<body>

<div class="form-box">

    <div class="logo">👔</div>

    <h1>SHOP ÁO CHO NAM</h1>

    <h2>THÊM NHÂN VIÊN</h2>

    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>

    <form action="addNhanVien" method="post">

        <table>

            <tr>
                <td>Họ và tên</td>
                <td>
                    <input type="text"
                           name="hoTen"
                           placeholder="Nhập họ tên"
                           maxlength="100"
                           required>
                </td>
            </tr>

            <tr>
                <td>CCCD</td>
                <td>
                    <input type="text"
                           name="cccd"
                           maxlength="12"
                           pattern="\d{12}"
                           placeholder="012345678901"
                           required>
                </td>
            </tr>

            <tr>
                <td>Ngày cấp CCCD</td>
                <td>
                    <input type="date"
                           name="ngayCapCCCD"
                           required>
                </td>
            </tr>

            <tr>
                <td>Nơi cấp CCCD</td>
                <td>
                    <input type="text"
                           name="noiCapCCCD"
                           placeholder="Cục Cảnh sát QLHC về TTXH"
                           required>
                </td>
            </tr>

            <tr>
                <td>CCCD mặt trước</td>
                <td>
                    <input type="text"
                           name="anhCCCDTruoc"
                           placeholder="images/cccd/front.jpg">
                </td>
            </tr>

            <tr>
                <td>CCCD mặt sau</td>
                <td>
                    <input type="text"
                           name="anhCCCDSau"
                           placeholder="images/cccd/back.jpg">
                </td>
            </tr>

            <tr>
                <td>Ngày sinh</td>
                <td>
                    <input type="date"
                           name="ngaySinh"
                           required>
                </td>
            </tr>

            <tr>
                <td>Giới tính</td>
                <td>
                    <select name="gioiTinh">
                        <option value="true">Nam</option>
                        <option value="false">Nữ</option>
                    </select>
                </td>
            </tr>
                        <tr>
                            <td>Số điện thoại</td>
                            <td>
                                <input type="text"
                                       name="soDienThoai"
                                       placeholder="09xxxxxxxx"
                                       pattern="(0[0-9]{9})|(\+84[0-9]{9})"
                                       required>
                            </td>
                        </tr>

                        <tr>
                            <td>Email</td>
                            <td>
                                <input type="email"
                                       name="email"
                                       placeholder="abc@gmail.com"
                                       maxlength="100"
                                       required>
                            </td>
                        </tr>

                        <tr>
                            <td>Cơ sở</td>
                            <td>
                                <select name="coSo">
                                    <option value="FPT PolySchool Hà Nội">
                                        FPT PolySchool Hà Nội
                                    </option>

                                    <option value="FPT PolySchool Hồ Chí Minh">
                                        FPT PolySchool Hồ Chí Minh
                                    </option>

                                    <option value="FPT PolySchool Đà Nẵng">
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
                                        required>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>Phường / Xã</td>
                            <td>
                                <select id="ward"
                                        name="phuongXa"
                                        required>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>Địa chỉ chi tiết</td>
                            <td>
                                <input type="text"
                                       name="diaChiChiTiet"
                                       required>
                            </td>
                        </tr>

                        <tr>
                            <td>Trạng thái</td>
                            <td>
                                <select name="trangThaiID">
                                    <option value="1">
                                        Đang làm
                                    </option>

                                    <option value="2">
                                        Nghỉ việc
                                    </option>
                                </select>
                            </td>
                        </tr>

                    </table>

                    <br>

                    <button type="submit">
                        ➕ Thêm nhân viên
                    </button>

                    <a class="back-btn" href="nhanvien">
                        ↩ Quay lại
                    </a>

                </form>

                <div class="footer">
                    © 2026 SHOP ÁO CHO NAM
                    <br>
                    FPT PolySchool - Nhóm 7
                </div>

            </div>
<script src="${pageContext.request.contextPath}/js/address.js"></script>
            </body>
            </html>