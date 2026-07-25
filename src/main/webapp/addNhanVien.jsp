<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Thêm nhân viên</title>

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

    <h1>➕ Thêm nhân viên</h1>

    <div class="table-box">

        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>

        <form action="addNhanVien" method="post">

            <table class="form-table">

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

                    <select name="noiCapCCCD" required>

                        <option value="">
                            -- Chọn nơi cấp --
                        </option>

                        <option value="CỤC CẢNH SÁT QUẢN LÝ HÀNH CHÍNH VỀ TRẬT TỰ XÃ HỘI">
                            CỤC CẢNH SÁT QUẢN LÝ HÀNH CHÍNH VỀ TRẬT TỰ XÃ HỘI
                        </option>

                        <option value="CÔNG AN TỈNH, THÀNH PHỐ TRỰC THUỘC TRUNG ƯƠNG">
                            CÔNG AN TỈNH, THÀNH PHỐ TRỰC THUỘC TRUNG ƯƠNG
                        </option>

                        <option value="CÔNG AN CẤP HUYỆN, QUẬN, THỊ XÃ, THÀNH PHỐ THUỘC TỈNH">
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

                        <option value="true">
                            Nam
                        </option>

                        <option value="false">
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
                <td>Mật khẩu</td>
                <td>
                   <div class="password-box">

                       <input type="password"
                              id="password"
                              name="password"
                              placeholder="Nhập mật khẩu">

                       <button type="button"
                               class="eye-btn"
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

                  <tr>
                      <td colspan="2" style="text-align:center;padding:20px;">

                          <button type="submit" class="btn btn-success">
                              ➕ Thêm nhân viên
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