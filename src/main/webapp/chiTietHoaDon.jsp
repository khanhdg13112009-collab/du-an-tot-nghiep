<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Chi tiết hóa đơn</title>

<style>

body{

    font-family: Arial, sans-serif;
    background:#f5f5f5;
    margin:30px;

}

.invoice{

    width:900px;
    margin:auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 0 10px #ccc;

}

h1{

    text-align:center;

}

.info{

    margin-top:20px;
    margin-bottom:20px;

}

.info p{

    font-size:17px;

}

table{

    width:100%;
    border-collapse:collapse;

}

table th,
table td{

    border:1px solid #ccc;
    padding:10px;
    text-align:center;

}

table th{

    background:#222;
    color:white;

}

.total{

    text-align:right;
    margin-top:20px;
    font-size:22px;
    font-weight:bold;

}

.btn{

    margin-top:30px;
    text-align:center;

}

.btn button{

    padding:12px 25px;
    border:none;
    background:#0d6efd;
    color:white;
    border-radius:5px;
    cursor:pointer;
    font-size:16px;

}

.btn a{

    padding:12px 25px;
    background:#198754;
    color:white;
    text-decoration:none;
    border-radius:5px;

}

@media print{

    .btn{

        display:none;

    }

    body{

        background:white;

    }

}

</style>

</head>

<body>

<div class="invoice">

<h1>BO THẰNG CHÁ</h1>

<h2 style="text-align:center;">HÓA ĐƠN</h2>

<hr>

<div class="info">

<p><b>Mã hóa đơn:</b> ${hoaDon.maHD}</p>

<p><b>Mã khách hàng:</b> ${hoaDon.maKH}</p>

<p><b>Mã nhân viên:</b> ${hoaDon.maNV}</p>

<p><b>Ngày đặt:</b> ${hoaDon.ngayDat}</p>

<p><b>Trạng thái:</b> ${hoaDon.trangThai}</p>

<c:if test="${not empty hoaDon.ghiChu}">

<p><b>Ghi chú:</b> ${hoaDon.ghiChu}</p>

</c:if>

</div>

<table>

<tr>

<th>Mã SPCT</th>

<th>Số lượng</th>

<th>Đơn giá</th>

<th>Thành tiền</th>

</tr>

<c:forEach items="${listCT}" var="ct">

<tr>

<td>${ct.maSPCT}</td>

<td>${ct.soLuong}</td>

<td>${ct.donGia}</td>

<td>${ct.thanhTien}</td>

</tr>

</c:forEach>

</table>

<div class="total">

Tổng tiền:
${hoaDon.tongTien} VNĐ

</div>

<div class="btn">

<button onclick="window.print()">

🖨 In hóa đơn

</button>

<a href="hoaDon">

Quay lại

</a>

</div>

</div>

</body>
</html>