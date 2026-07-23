document.addEventListener("DOMContentLoaded", function () {

    const province = document.getElementById("province");
    const ward = document.getElementById("ward");

    if (!province || !ward) return;

    // Lấy giá trị cũ (nếu là trang sửa)
    const oldProvince = province.getAttribute("data-selected");
    const oldWard = ward.getAttribute("data-selected");

    fetch("data/vietnam.json")
        .then(res => res.json())
        .then(data => {

            province.innerHTML =
                '<option value="">-- Chọn Tỉnh / Thành phố --</option>';

            ward.innerHTML =
                '<option value="">-- Chọn Phường / Xã --</option>';

            data.forEach(p => {

                const option = document.createElement("option");
                option.value = p.FullName;
                option.textContent = p.FullName;

                if (p.FullName === oldProvince) {
                    option.selected = true;
                }

                province.appendChild(option);
            });

            function loadWard(provinceName) {

                ward.innerHTML =
                    '<option value="">-- Chọn Phường / Xã --</option>';

                const p = data.find(x => x.FullName === provinceName);

                if (!p) return;

                p.Wards.forEach(w => {

                    const option = document.createElement("option");
                    option.value = w.FullName;
                    option.textContent = w.FullName;

                    if (w.FullName === oldWard) {
                        option.selected = true;
                    }

                    ward.appendChild(option);
                });
            }

            if (oldProvince) {
                loadWard(oldProvince);
            }

            province.addEventListener("change", function () {
                loadWard(this.value);
            });

        })
        .catch(console.error);

});