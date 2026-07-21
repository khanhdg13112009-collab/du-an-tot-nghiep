<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="vi">

<head>

    <meta charset="UTF-8">

    <title>${sanPham.tenSP}</title>

    <link rel="stylesheet" href="assets/css/product-detail.css">

</head>

<body>

<header>

    <div class="logo">

        <a href="home">

            <h2>BO THẰNG CHÁ</h2>

        </a>

    </div>

</header>

<div class="container">

    <div class="left">

        <img src="assets/images/no-image.png" alt="Sản phẩm">

    </div>

    <div class="right">

        <h1>${sanPham.tenSP}</h1>

        <h3>Thương hiệu: ${sanPham.thuongHieu}</h3>

        <p>${sanPham.moTa}</p>

        <hr>

        <br>

        <h2 class="price">

            <c:choose>

                <c:when test="${not empty listChiTiet}">

                    ${listChiTiet[0].gia} VNĐ

                </c:when>

                <c:otherwise>

                    Chưa có giá

                </c:otherwise>

            </c:choose>

        </h2>

        <br>

        <h3>Màu sắc</h3>

        <div class="color-list" id="colorList">

        </div>

        <br>

        <h3>Size</h3>

        <div class="size-list" id="sizeList">

        </div>

        <br>

        <h3>

            Còn

            <span class="stock">

                <c:choose>

                    <c:when test="${not empty listChiTiet}">

                        ${listChiTiet[0].soLuong}

                    </c:when>

                    <c:otherwise>

                        0

                    </c:otherwise>

                </c:choose>

            </span>

            sản phẩm

        </h3>

        <br>

        <div class="quantity">

            <button type="button" id="minusBtn">-</button>

            <input
                    type="number"
                    id="quantity"
                    value="1"
                    min="1">

            <button type="button" id="plusBtn">+</button>

        </div>

        <br>

        <button class="buy">

            MUA NGAY

        </button>

        <button class="cart">

            THÊM VÀO GIỎ

        </button>

    </div>

</div>

<script>

const maSP = ${sanPham.maSP};

const colorList = document.getElementById("colorList");
const sizeList = document.getElementById("sizeList");

const stock = document.querySelector(".stock");
const price = document.querySelector(".price");

const buyBtn = document.querySelector(".buy");
const cartBtn = document.querySelector(".cart");

const quantity = document.getElementById("quantity");

let data = [];
let selectedSPCT = null;

fetch("get-spct?maSP=" + maSP)
.then(res => res.json())
.then(result => {

    data = result;

    loadColor();

});

function loadColor(){

    colorList.innerHTML="";

    let colors=[];

    data.forEach(item=>{

        if(!colors.includes(item.tenMau)){

            colors.push(item.tenMau);

        }

    });

    colors.forEach(color=>{

        const btn=document.createElement("button");

        btn.type="button";

        btn.className="color-btn";

        btn.innerHTML=color;

        btn.onclick=function(){

            document.querySelectorAll(".color-btn").forEach(x=>{

                x.classList.remove("active");

            });

            btn.classList.add("active");

            loadSize(color);

        };

        colorList.appendChild(btn);

    });

}

function loadSize(color){

    sizeList.innerHTML="";

    stock.innerHTML="0";

    buyBtn.disabled=true;

    cartBtn.disabled=true;

    data.forEach(item=>{

        if(item.tenMau===color){

            const btn=document.createElement("button");

            btn.type="button";

            btn.className="size-btn";

            btn.innerHTML=item.tenSize;

            if(item.soLuong<=0){

                btn.disabled=true;

                btn.classList.add("disabled");

            }

            btn.onclick=function(){

                document.querySelectorAll(".size-btn").forEach(x=>{

                    x.classList.remove("active");

                });

                btn.classList.add("active");

                selectedSPCT=item.maSPCT;

                price.innerHTML=item.gia+" VNĐ";

                stock.innerHTML=item.soLuong;

                if(item.soLuong>0){

                    buyBtn.disabled=false;

                    cartBtn.disabled=false;

                }else{

                    buyBtn.disabled=true;

                    cartBtn.disabled=true;

                }

            };

            sizeList.appendChild(btn);

        }

    });

}

document.getElementById("minusBtn").onclick=function(){

    if(quantity.value>1){

        quantity.value--;

    }

}

document.getElementById("plusBtn").onclick=function(){

    quantity.value++;

}

buyBtn.onclick=function(){

    if(selectedSPCT==null){

        alert("Vui lòng chọn màu và size.");

        return;

    }

    alert("Mua ngay - MaSPCT: " + selectedSPCT);

}

cartBtn.onclick = function () {

    if (selectedSPCT == null) {

        alert("Vui lòng chọn màu và size.");

        return;

    }

    const form = document.createElement("form");

    form.method = "post";

    form.action = "add-to-cart";

    const ma = document.createElement("input");

    ma.type = "hidden";

    ma.name = "maSPCT";

    ma.value = selectedSPCT;

    const sl = document.createElement("input");

    sl.type = "hidden";

    sl.name = "soLuong";

    sl.value = quantity.value;

    form.appendChild(ma);

    form.appendChild(sl);

    document.body.appendChild(form);

    form.submit();

}

</script>

</body>

</html>