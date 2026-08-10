<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="Models.SanPhamChiTiet" %>
<%@ page import="Models.CartItem" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.Map" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
ArrayList<SanPhamChiTiet> dsSP =
        (ArrayList<SanPhamChiTiet>) request.getAttribute("dsSP");

ArrayList<CartItem> cart =
        (ArrayList<CartItem>) request.getAttribute("cart");

BigDecimal tongTien =
        (BigDecimal) request.getAttribute("tongTien");

        LinkedHashMap<Integer, ArrayList<SanPhamChiTiet>> dsTheoSP =
                (LinkedHashMap<Integer, ArrayList<SanPhamChiTiet>>) request.getAttribute("dsTheoSP");

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

   <form action="banHang" method="get">

       <form action="banHang" method="get">

           <input
                   type="text"
                   name="keyword"
                   value="${keyword}"
                   placeholder="Nhập tên hoặc mã sản phẩm...">

           <button
                   class="btn them"
                   type="submit">
               Tìm
           </button>

       </form>



   </form>

</form>

<table>

<tr>
    <th>Sản phẩm</th>
    <th>Màu</th>
    <th>Size</th>
    <th>Giá</th>
    <th>Tồn</th>
    <th></th>
</tr>

<%
for(Map.Entry<Integer, ArrayList<SanPhamChiTiet>> entry : dsTheoSP.entrySet()){

    ArrayList<SanPhamChiTiet> list = entry.getValue();

    SanPhamChiTiet first = list.get(0);
%>

<tr>

<td>

    <b><%=first.getTenSP()%></b>

</td>

<td>

<select class="mauSelect">

<%
for(SanPhamChiTiet sp : list){
%>

<option
        value="<%=sp.getMaSPCT()%>"
        data-gia="<%=sp.getGia()%>"
        data-ton="<%=sp.getSoLuong()%>">

    <%=sp.getTenMau()%>

</option>

<%
}
%>

</select>

</td>

<td>

<select class="sizeSelect">

<%
for(SanPhamChiTiet sp : list){
%>

<option
        value="<%=sp.getMaSPCT()%>"
        data-gia="<%=sp.getGia()%>"
        data-ton="<%=sp.getSoLuong()%>">

    <%=sp.getTenSize()%>

</option>
<%
}
%>

</select>

</td>

<td class="giaCell">

    <%=String.format("%,.0f",first.getGia())%> đ

</td>

<td class="tonCell">

    <%=first.getSoLuong()%>

</td>

<td>

<form action="banHang" method="post">

<input
        type="hidden"
        name="maSPCT"
        class="maSPCTInput"
        value="<%=first.getMaSPCT()%>">

<button
        type="submit"
        class="btn them">

    Thêm

</button>

</form>

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

        <tr>

            <td style="text-align:left;">

                <b>Nhân viên</b>

            </td>

            <td>

                ${sessionScope.account.username}

            </td>

        </tr>

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

    <c:forEach items="${listKhachHang}" var="kh">

        <c:if test="${kh.maKH != 1}">

            <option value="${kh.maKH}">
                ${kh.hoTen} - ${kh.soDienThoai}
            </option>

        </c:if>

    </c:forEach>

</select>

<br><br>

<a href="khachhang?action=add"
   class="btn them">

    + Thêm khách hàng

</a>

            </td>

        </tr>

        <tr>

            <td style="text-align:left;">

                <b>Tiền khách đưa</b>

            </td>

            <td>

                <input
                        id="tienKhachDua"
                        type="number"
                        style="width:100%;padding:8px;">

            </td>

        </tr>

        <tr>

            <td style="text-align:left;">

                <b>Tiền thừa</b>

            </td>

            <td>

                <span id="tienThua">

                    0 đ

                </span>

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

<script>

document.querySelectorAll("tr").forEach(function(row){

    let mau=row.querySelector(".mauSelect");
    let size=row.querySelector(".sizeSelect");

    if(!mau || !size) return;

    function capNhat(){

        let option=size.options[size.selectedIndex];

        row.querySelector(".tonCell").innerHTML=
                option.dataset.ton;

        row.querySelector(".giaCell").innerHTML=
                Number(option.dataset.gia).toLocaleString("vi-VN")+" đ";

        row.querySelector(".maSPCTInput").value=
                option.value;

    }

    size.onchange=capNhat;

    mau.onchange=function(){

        let id=mau.value;

        for(let i=0;i<size.options.length;i++){

            if(size.options[i].value==id){

                size.selectedIndex=i;

                break;

            }

        }

        capNhat();

    };

    capNhat();

});

</script>

<script>

const tongTien =
<%=tongTien.intValue()%>;

let input =
document.getElementById("tienKhachDua");

let span =
document.getElementById("tienThua");

input.onkeyup=function(){

    let tien =
    Number(this.value);

    let thua =
    tien-tongTien;

    if(thua<0){

        thua=0;

    }

    span.innerHTML=
    thua.toLocaleString("vi-VN")
    +" đ";

};

</script>

</body>

</html>