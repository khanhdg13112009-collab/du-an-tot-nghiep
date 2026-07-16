<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Quản lý nhân viên</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="nhanvien-box">

    <div class="logo">👔</div>

    <h1>SHOP ÁO CHO NAM</h1>

    <h2>QUẢN LÝ NHÂN VIÊN</h2>

    <a class="add-btn"
       href="addNhanVien">

        ➕ Thêm nhân viên

    </a>

    <table>

        <tr>

            <th>Mã</th>

            <th>Họ tên</th>

            <th>CCCD</th>

            <th>CCCD trước</th>

            <th>CCCD sau</th>

            <th>Ngày sinh</th>

            <th>Giới tính</th>

            <th>SĐT</th>

            <th>Email</th>

            <th>Cơ sở</th>

            <th>Địa chỉ</th>

            <th>Trạng thái</th>

            <th>Thao tác</th>

        </tr>

        <c:forEach items="${list}" var="nv">

            <tr>

                <td>${nv.maNV}</td>

                <td>${nv.hoTen}</td>

                <td>${nv.cccd}</td>

                <td>

                    <c:choose>

                        <c:when test="${not empty nv.anhCCCDTruoc}">

                            <span style="color:green;font-weight:bold;">

                                ✅ Đã có

                            </span>

                        </c:when>

                        <c:otherwise>

                            <span style="color:red;">

                                ❌ Chưa có

                            </span>

                        </c:otherwise>

                    </c:choose>

                </td>

                <td>

                    <c:choose>

                        <c:when test="${not empty nv.anhCCCDSau}">

                            <span style="color:green;font-weight:bold;">

                                ✅ Đã có

                            </span>

                        </c:when>

                        <c:otherwise>

                            <span style="color:red;">

                                ❌ Chưa có

                            </span>

                        </c:otherwise>

                    </c:choose>

                </td>

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

                <td>${nv.diaChi}</td>

                <td>

                    <c:choose>

                        <c:when test="${nv.trangThaiID == 1}">

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

                <td>

                    <a class="action-btn edit-btn"
                       href="editNhanVien?maNV=${nv.maNV}">

                        ✏️ Sửa

                    </a>

                </td>

            </tr>

        </c:forEach>

    </table>

    <br>

    <a class="back-btn"
       href="home.jsp">

        🏠 Trang chủ

    </a>

    <div class="footer">

        © 2026 SHOP ÁO CHO NAM

        <br>

        FPT PolySchool - Nhóm 7

    </div>

</div>

</body>

</html>