                          <%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
                          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

                          <!DOCTYPE html>
                          <html>
                          <head>
                              <meta charset="UTF-8">
                              <title>Quản lý màu sắc</title>
                              <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
                          </head>
                          <body>

                          <div class="nhanvien-box">

                              <h2>QUẢN LÝ MÀU SẮC</h2>

                              <a class="add-btn" href="addMauSac">
                                  ➕ Thêm màu sắc
                              </a>

                              <table>

                                  <tr>
                                      <th>Mã màu</th>
                                      <th>Tên màu</th>
                                      <th>Chức năng</th>
                                  </tr>

                                  <c:forEach items="${list}" var="ms">

                                      <tr>

                                          <td>${ms.maMau}</td>

                                          <td>${ms.tenMau}</td>

                                          <td>

                                              <a href="editMauSac?id=${ms.maMau}">Sửa</a>

                                              |

                                              <a href="deleteMauSac?id=${ms.maMau}"
                                                 onclick="return confirm('Bạn có chắc muốn xóa?')">

                                                  Xóa

                                              </a>

                                          </td>

                                      </tr>

                                  </c:forEach>

                              </table>

                              <br>

                              <a href="home.jsp">← Trang chủ</a>

                          </div>

                          </body>
                          </html>