$(document).ready(function () {
    $('#bdParts').on('click', function () {
        func();
    });

    fetch('/categories/fetch').then((response) => response.json()).then((json) => {
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

function formatProduct(product) {
    return '<div class="product">'
        + '<div class="text-center">'
        + `<a href="/products/details/${product.product.id}"><img src="${product.product.imageUrl}" class="product-image-home img-thumbnail px-auto" alt="Image not loaded..."/></a>`
        + '</div>'
        + `<h5 class="text-center font-weight-bold mt-3">Name: ${product.product.name}</h5>`
        + `<h5 class="text-center font-weight-bold">Price: ${product.price.toFixed(2)}</h5>`
        + `<h5 class="text-center font-weight-bold">Original Price: ${product.product.price.toFixed(2)}</h5>`
        + '</div>'
        + '<br>'
}

$(document).ready(function () {
    $('#ks').attr('checked', true);

    fetch('/top-offers/all')
        .then((response) => response.json())
        .then((json) => {
            $('.products-data').empty();

            if (json.length === 0) {
                $('.products-data').append(`<h1 class="text-center font-weight-bold">There are no products in the ${category} category.</h1>`)
            } else {
                for (let i = 0; i < json.length; i += 3) {
                    $('.products-data').append('<div class="products-row row d-flex justify-content-around mt-5">');
                    if (i < json.length) $('.products-data .products-row:last-child').append(formatProduct(json[i]));
                    if (i + 1 < json.length) $('.products-data .products-row:last-child').append(formatProduct(json[i + 1]));
                    if (i + 2 < json.length) $('.products-data .products-row:last-child').append(formatProduct(json[i + 2]));
                }
            }
        })
});

$('input[type=list][name=selection]').change(function () {
    let category = $(this).val();

    fetch('/top-offers/' + category)
        .then((response) => response.json())
        .then((json) => {
            $('.products-data').empty();

            if (json.length === 0) {
                $('.products-data').append(`<h1 class="text-center font-weight-bold">There are no products in the ${category} category.</h1>`)
            } else {
                for (let i = 0; i < json.length; i += 3) {
                    $('.products-data').append('<div class="products-row row d-flex justify-content-around mt-5">');
                    if (i < json.length) $('.products-data .products-row:last-child').append(formatProduct(json[i]));
                    if (i + 1 < json.length) $('.products-data .products-row:last-child').append(formatProduct(json[i + 1]));
                    if (i + 2 < json.length) $('.products-data .products-row:last-child').append(formatProduct(json[i + 2]));
                }
            }
        })
});
