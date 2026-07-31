<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Models.ThongKe" %>

<%
    ThongKe tk = (ThongKe) request.getAttribute("tk");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thống kê doanh thu</title>

    <style>
        body{
            font-family: Arial;
            background:#f5f5f5;
            margin:30px;
        }

        .container{
            width:800px;
            margin:auto;
            background:white;
            padding:25px;
            border-radius:10px;
            box-shadow:0 0 10px gray;
        }

        h2{
            text-align:center;
            color:#333;
        }

        form{
            margin-top:20px;
            margin-bottom:30px;
        }

        select,input{
            padding:8px;
            margin:5px;
        }

        button{
            padding:8px 20px;
            background:#007bff;
            color:white;
            border:none;
            border-radius:5px;
            cursor:pointer;
        }

        button:hover{
            background:#0056b3;
        }

        table{
            width:100%;
            border-collapse:collapse;
        }

        table th,table td{
            border:1px solid #ccc;
            padding:10px;
            text-align:center;
        }

        table th{
            background:#007bff;
            color:white;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>THỐNG KÊ DOANH THU</h2>

    <form action="thongKe" method="post">

        <label>Loại thống kê:</label>

        <select name="loai">
            <option value="ngay">Theo ngày</option>
            <option value="thang">Theo tháng</option>
            <option value="nam">Theo năm</option>
        </select>

        <br><br>

        <label>Ngày:</label>
        <input type="date" name="ngay">

        <br><br>

        <label>Tháng:</label>
        <input type="number" name="thang" min="1" max="12">

        <label>Năm:</label>
        <input type="number" name="nam" value="2026">

        <br><br>

        <button type="submit">Thống kê</button>

    </form>

    <%
        if(tk != null){
    %>

    <table>

        <tr>
            <th>Tổng doanh thu</th>
            <th>Số hóa đơn</th>
            <th>Số sản phẩm bán</th>
        </tr>

        <tr>
            <td><%= tk.getDoanhThu() %> VNĐ</td>
            <td><%= tk.getSoHoaDon() %></td>
            <td><%= tk.getSoSanPham() %></td>
        </tr>

    </table>

    <%
        }
    %>

</div>

</body>
</html>