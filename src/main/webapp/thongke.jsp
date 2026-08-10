<%
double[] chartData =
(double[])request.getAttribute("chartData");
%>

<p>
ChartData:
<%= chartData == null ? "NULL" : chartData.length %>
</p>

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
            margin:0;
            background:#edf2f8;
            font-family:Arial,sans-serif;
        }

        .wrapper{
            display:flex;
        }

        /* Sidebar */

        .sidebar{
            width:240px;
            background:#1f2937;
            min-height:100vh;
            color:white;
            position:fixed;
            border-top-right-radius:18px;
            border-bottom-right-radius:18px;
        }

        .sidebar h2{
            text-align:center;
            padding:25px 0;
            border-bottom:1px solid #374151;
        }

        .sidebar a{
            display:block;
            color:white;
            padding:16px 25px;
            text-decoration:none;
            transition:.3s;
        }

        .sidebar a:hover,
        .sidebar .active{
            background:#2563eb;
        }

        /* Content */

        .content{
            margin-left:240px;
            width:calc(100% - 240px);
            padding:35px;
        }

        h1{
            margin-bottom:25px;
            font-size:34px;
        }

        /* Bộ lọc */

        .filter{
            background:white;
            padding:20px;
            border-radius:18px;
            box-shadow:0 10px 25px rgba(0,0,0,.08);

            display:flex;
            align-items:center;
            gap:12px;
            flex-wrap:wrap;

            margin-bottom:25px;
        }

        .filter input,
        .filter select{

            height:45px;
            padding:0 15px;

            border:1px solid #ddd;

            border-radius:10px;

            font-size:15px;
        }

        .filter button{

            height:45px;

            background:#2563eb;

            color:white;

            border:none;

            padding:0 25px;

            border-radius:10px;

            cursor:pointer;

            transition:.3s;
        }

        .filter button:hover{

            background:#1d4ed8;

        }

        /* Card */

        .cards{

            display:grid;

            grid-template-columns:repeat(4,1fr);

            gap:20px;

            margin-bottom:25px;

        }

        .card{

            background:white;

            border-radius:18px;

            padding:22px;

            display:flex;

            align-items:center;

            gap:18px;

            box-shadow:0 10px 25px rgba(0,0,0,.08);

            transition:.3s;

        }

        .card:hover{

            transform:translateY(-8px);

        }

        .icon{

            width:70px;

            height:70px;

            border-radius:50%;

            display:flex;

            justify-content:center;

            align-items:center;

            font-size:34px;

            background:#eef5ff;

        }

        .card h4{

            color:#777;

            margin:0;

            font-size:18px;

        }

        .card h2{

            margin-top:8px;

            font-size:30px;

            color:#222;

        }

        /* Chart */

        .chart-row{

            display:grid;

            grid-template-columns:380px 1fr;

            gap:25px;

            margin-top:25px;

        }

        .chart-card{

            background:white;

            padding:25px;

            border-radius:18px;

            box-shadow:0 10px 25px rgba(0,0,0,.08);

        }

        .chart-card h3{

            margin-top:0;

            margin-bottom:20px;

            font-size:22px;

        }

        .chart-card.full{

            margin-top:25px;

        }

        #pieChart{

            width:100%!important;

            height:300px!important;

        }

        #lineChart{

            width:100%!important;

            height:300px!important;

        }

        #barChart{

            width:100%!important;

            height:320px!important;

        }

        .money{
            background:#FFF4D8;
        }

        .bill{
            background:#E7F0FF;
        }

        .customer{
            background:#F3E8FF;
        }

        .product{
            background:#E9FFE8;
        }

    </style>

</head>

<body>

<div class="wrapper">

    <!-- Sidebar -->
    <div class="sidebar">

        <h2>BTC</h2>

        <a href="admin">🏠 Dashboard</a>

        <a href="banHang">🛒 Bán hàng</a>

        <a href="sanpham">👕 Quản lý sản phẩm</a>

        <a href="khachhang">👤 Quản lý khách hàng</a>

        <a href="nhanvien">👨 Quản lý nhân viên</a>

        <a href="hoaDon">🧾 Hóa đơn</a>

        <a class="active" href="thongKe">📊 Thống kê</a>

        <a href="logout">🚪 Đăng xuất</a>

    </div>

    <!-- Nội dung -->
    <div class="content">

        <h1>📊 THỐNG KÊ DOANH THU</h1>

        <form action="thongKe" method="post" class="filter">

            <select name="loai">

                <option value="ngay">Theo ngày</option>

                <option value="thang">Theo tháng</option>

                <option value="nam">Theo năm</option>

            </select>

            <input type="date" name="ngay">

            <input type="number"
                   name="thang"
                   min="1"
                   max="12"
                   placeholder="Tháng">

            <input type="number"
                   name="nam"
                   value="2026"
                   placeholder="Năm">

            <button>📈 Thống kê</button>

        </form>

<%
if(tk!=null){
%>

        <div class="cards">

            <div class="card">

                <div class="icon">💰</div>

                <div>

                    <h4>Doanh thu</h4>

                    <h2><%=String.format("%,.0f",tk.getDoanhThu())%>đ</h2>

                </div>

            </div>

            <div class="card">

                <div class="icon">🧾</div>

                <div>

                    <h4>Hóa đơn</h4>

                    <h2><%=tk.getSoHoaDon()%></h2>

                </div>

            </div>

            <div class="card">

                <div class="icon">👤</div>

                <div>

                    <h4>Khách hàng</h4>

                    <h2><%=tk.getSoKhachHang()%></h2>

                </div>

            </div>

            <div class="card">

                <div class="icon">👕</div>

                <div>

                    <h4>Sản phẩm</h4>

                    <h2><%=tk.getSoSanPham()%></h2>

                </div>

            </div>

        </div>

        <!-- Chỗ để biểu đồ -->

        <div class="chart-row">

            <div class="chart-card">

                <h3>🥧 Tỷ lệ doanh thu</h3>

                <canvas id="pieChart"></canvas>

            </div>

            <div class="chart-card">

                <h3>📈 Xu hướng doanh thu</h3>

                <canvas id="lineChart"></canvas>

            </div>

        </div>

        <div class="chart-card full">

            <h3>📊 Doanh thu 12 tháng</h3>

            <canvas id="barChart"></canvas>

        </div>

<%
}
%>

    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>

const doanhThu12Thang=[

<%

if(chartData!=null){

for(int i=0;i<chartData.length;i++){

out.print(chartData[i]);

if(i<chartData.length-1){

out.print(",");

}

}

}

%>

];

</script>

<script>

const pieCtx = document.getElementById("pieChart");

new Chart(pieCtx,{

    type:"doughnut",

    data:{

        labels:[
            "Hóa đơn",
            "Khách hàng",
            "Sản phẩm"
        ],

        datasets:[{

            data:[
                <%=tk.getSoHoaDon()%>,
                <%=tk.getSoKhachHang()%>,
                <%=tk.getSoSanPham()%>
            ],

            backgroundColor:[
                "#3B82F6",
                "#10B981",
                "#F59E0B"
            ],

            borderWidth:0

        }]

    },

    options:{

        cutout:"70%",

        responsive:true,

        plugins:{

            legend:{

                position:"bottom"

            }

        }

    }

});

</script>

<script>

const lineCtx =
document.getElementById("lineChart");

new Chart(lineCtx,{

    type:"line",

    data:{

       labels:[
       "T1","T2","T3","T4","T5","T6",
       "T7","T8","T9","T10","T11","T12"
       ],

       datasets:[{

           label:"Doanh thu",

           data:doanhThu12Thang,

           backgroundColor:"#3B82F6",

           borderRadius:10

       }]

    },

    options:{

        responsive:true

    }

});

</script>

<script>

const barCtx =
document.getElementById("barChart");

new Chart(barCtx,{

    type:"bar",

    data:{

        labels:[
            "T1",
            "T2",
            "T3",
            "T4",
            "T5",
            "T6",
            "T7",
            "T8",
            "T9",
            "T10",
            "T11",
            "T12"
        ],

        datasets:[{

            label:"Doanh thu",

            data:doanhThu12Thang,

            backgroundColor:"#3B82F6",

            borderRadius:10

        }]

    },

    options:{

        responsive:true

    }

});

</script>



</body>
</html>