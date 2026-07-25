<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="Models.SanPhamChiTiet"%>
<%@ page import="Models.CartItem"%>

<%
ArrayList<SanPhamChiTiet> dsSP =
        (ArrayList<SanPhamChiTiet>) request.getAttribute("dsSP");

ArrayList<CartItem> cart =
        (ArrayList<CartItem>) request.getAttribute("cart");

BigDecimal tongTien =
        (BigDecimal) request.getAttribute("tongTien");

if(dsSP == null){
    dsSP = new ArrayList<SanPhamChiTiet>();
}

if(cart == null){
    cart = new ArrayList<CartItem>();
}

if(tongTien == null){
    tongTien = BigDecimal.ZERO;
}
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Bán hàng</title>

<link rel="stylesheet" href="/DATN-nhom2/css/admin.css">

<style>

.wrapper{
    display:flex;
    gap:20px;
}

.left{
    width:60%;
}

.right{
    width:40%;
}

table{
    width:100%;
    border-collapse:collapse;
    margin-top:15px;
    background:white;
}

th{
    background:#2c3e50;
    color:white;
    padding:10px;
}

td{
    padding:10px;
    text-align:center;
    border:1px solid #ddd;
}

input[type=text]{
    width:100%;
    padding:10px;
    margin-bottom:10px;
}

.btn{
    padding:7px 12px;
    border:none;
    border-radius:5px;
    cursor:pointer;
    text-decoration:none;
}

.them{
    background:#27ae60;
    color:white;
}

.cong{
    background:#3498db;
    color:white;
}

.tru{
    background:#f39c12;
    color:white;
}

.xoa{
    background:#e74c3c;
    color:white;
}

.thanhtoan{
    width:100%;
    padding:15px;
    background:#27ae60;
    color:white;
    border:none;
    font-size:18px;
    margin-top:20px;
    cursor:pointer;
}

.total{
    margin-top:20px;
    text-align:right;
    font-size:22px;
    font-weight:bold;
}

</style>

</head>

<body>

<div class="sidebar">

<h2>BO THẰNG CHÁ</h2>

<a href="admin">🏠 Dashboard</a>

<a href="banHang">🛒 Bán hàng</a>

<a href="sanpham">👕 Quản lý sản phẩm</a>

<a href="nhanvien">👨 Quản lý nhân viên</a>

<a href="khachhang">👤 Quản lý khách hàng</a>

<a href="hoaDon">🧾 Quản lý hóa đơn</a>

<a href="/DATN-nhom2/logout">🚪 Đăng xuất</a>

</div>

<div class="content">

<h1>Bán hàng</h1>

<div class="wrapper">

<div class="left">

<h2>Danh sách sản phẩm</h2>

<form action="banHang" method="get">

    <input
            type="text"
            name="keyword"
            placeholder="Nhập tên sản phẩm...">

    <button
            class="btn them"
            type="submit">

        Tìm

    </button>

</form>

<table>

<tr>

    <th>Tên</th>
    <th>Màu</th>
    <th>Size</th>
    <th>Giá</th>
    <th>Tồn</th>
    <th></th>

</tr>

<%

for(SanPhamChiTiet sp : dsSP){

%>

<tr>

    <td><%=sp.getTenSP()%></td>

    <td><%=sp.getTenMau()%></td>

    <td><%=sp.getTenSize()%></td>

    <td><%=String.format("%,.0f",sp.getGia())%> đ</td>

    <td><%=sp.getSoLuong()%></td>

    <td>

        <% if(sp.getSoLuong()>0){ %>

        <form action="banHang" method="post">

            <input
                    type="hidden"
                    name="maSPCT"
                    value="<%=sp.getMaSPCT()%>">

            <button
                    type="submit"
                    class="btn them">

                Thêm

            </button>

        </form>

        <% }else{ %>

        <span style="color:red;font-weight:bold">

            Hết hàng

        </span>

        <% } %>

    </td>

</tr>

<%

}

%>

</table>

</div>

<div class="right">

<h2>HÓA ĐƠN ĐANG BÁN</h2>

<table>

<tr>

<th>Sản phẩm</th>

<th>SL</th>

<th>Đơn giá</th>

<th>TT</th>

<th></th>

</tr>
<%

for(CartItem item : cart){

%>

<tr>

    <td>

        <b><%=item.getTenSanPham()%></b>

        <br>

        <%=item.getMauSac()%> -
        <%=item.getKichCo()%>

    </td>

    <td>

        <a class="btn tru"
           href="banHang?action=decrease&maSPCT=<%=item.getMaSPCT()%>">

            -

        </a>

        <%=item.getSoLuong()%>

        <a class="btn cong"
           href="banHang?action=increase&maSPCT=<%=item.getMaSPCT()%>">

            +

        </a>

    </td>

    <td>

        <%=String.format("%,.0f",item.getDonGia())%> đ

    </td>

    <td>

        <%=String.format("%,.0f",item.getThanhTien())%> đ

    </td>

    <td>

        <a class="btn xoa"
           href="banHang?action=remove&maSPCT=<%=item.getMaSPCT()%>">

            X

        </a>

    </td>

</tr>

<%

}

%>

</table>

<% if(!cart.isEmpty()){ %>

<a href="banHang?action=clear"
   class="btn xoa"
   style="display:inline-block;margin-top:10px;">

    Xóa tất cả

</a>

<% } %>

<div class="total">

    Tổng tiền:

    <span style="color:red;">

        <%=String.format("%,.0f",tongTien)%> đ

    </span>

</div>

<form action="thanhToan" method="post">

    <table style="margin-top:20px;">

        <tr>

            <td style="text-align:left;">

                <b>Khách hàng</b>

            </td>

            <td>

                <select
                        name="maKH"
                        style="width:100%;padding:8px;">

                    <option value="1">

                        Khách lẻ

                    </option>

                </select>

            </td>

        </tr>

        <tr>

            <td style="text-align:left;">

                <b>Ghi chú</b>

            </td>

            <td>

                <textarea
                        name="ghiChu"
                        rows="4"
                        style="width:100%;"></textarea>

            </td>

        </tr>

    </table>

    <button
            class="thanhtoan"
            type="submit"
            <%= cart.isEmpty() ? "disabled" : "" %>>

        THANH TOÁN

    </button>

</form>

</div>

</div>

</div>

</body>

</html>