$(document).ready(function () {
    $('#bdParts').on('click', function () {
        func();
    });

    fetch('http://localhost:8000/categories/fetch').then((response) => response.json()).then((json) => {
        console.log(json);
        let a = $("<ul id='ks'></ul>");
        for (let i = 0; i < json.length; i++) {
            let id = json[i].id;
            a.append(`<li><a id="${id}" href="#" onclick="loadItemsFromCategory('${id}')">${json[i].name}</a></li>`);
        }
        $('#tst').append(a);
    })
    ;

    function func() {
        let contentDiv = $('#tst');
        if (contentDiv.is(':visible')) {
            contentDiv.hide();
        } else {
            contentDiv.show();
        }
    }
});

$(document).ready(function () {
    $('#allRadio').attr('checked', true);

    fetch('http://localhost:8001/top-offers/all')
        .then((response) => response.json())
        .then((json) => {
            $('.products-data').empty();

            if (json.length === 0) {
                $('.products-data').append(`<h1 class="text-center font-weight-bold">There are no products in the ${category} category.</h1>`)
            } else {
                for (let i = 0; i < json.length; i += 3) {
                    $('.products-data').append('<div class="products-row row d-flex justify-content-around mt-5">');
                    if(i < json.length) $('.products-data .products-row:last-child').append(formatProduct(json[i]));
                    if(i + 1 < json.length) $('.products-data .products-row:last-child').append(formatProduct(json[i + 1]));
                    if(i + 2 < json.length) $('.products-data .products-row:last-child').append(formatProduct(json[i + 2]));
                }
            }
        })
});

$('input[type=radio][name=selection]').change(function () {
    let category = $(this).val();

    fetch('http://localhost:8001/top-offers/' + category)
        .then((response) => response.json())
        .then((json) => {
            $('.products-data').empty();

            if (json.length === 0) {
                $('.products-data').append(`<h1 class="text-center font-weight-bold">There are no products in the ${category} category.</h1>`)
            } else {
                for (let i = 0; i < json.length; i += 3) {
                    $('.products-data').append('<div class="products-row row d-flex justify-content-around mt-5">');
                    if(i < json.length) $('.products-data .products-row:last-child').append(formatProduct(json[i]));
                    if(i + 1 < json.length) $('.products-data .products-row:last-child').append(formatProduct(json[i + 1]));
                    if(i + 2 < json.length) $('.products-data .products-row:last-child').append(formatProduct(json[i + 2]));
                }
            }
        })
});
</script>