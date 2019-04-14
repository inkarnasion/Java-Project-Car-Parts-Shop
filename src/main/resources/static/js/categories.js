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

function formatProduct(product) {
	return '<div class="product">'
		+ '<div class="container">'
		+ '<div class="row">'
		+ '<div class="col-lg-9">'
		+ '<div class="row">'
		+ '<div class="col-lg-4 col-md-6 mb-4">'
		+ '<div class="card h-100">'
		+ `<a href="/products/details/${product.id}"><img src="${product.imageUrl}" class="product-image-home img-thumbnail px-auto" alt="Image not loaded..."/></a>`
		+ '<div class="card-body">'
		+ `<a class="card-title"> <label for="name" class="font-weight-bold">ℙ𝕣𝕠𝕕𝕦𝕔𝕥 ℕ𝕒𝕞𝕖:</label>`
		+ `<hr>`
		+ `<a class="col-md-1 text-center" id="name">${product.name}</a>`
		+ `</a>`
		+ `<hr>`
		+ `<label for="manufacture" class="font-weight-bold">ℙ𝕣𝕠𝕕𝕦𝕔𝕥 𝕄𝕒𝕟𝕦𝕗𝕒𝕔𝕥𝕦𝕣𝕖:</label>`
		+ `<hr>`
		+ `<a class="col-md-3 text-center" id="manufacture">${product.manufacture}</a>`
		+ `<hr>`
		+ `<label for="model" class="font-weight-bold">ℙ𝕣𝕠𝕕𝕦𝕔𝕥 𝕄𝕠𝕕𝕖𝕝:</label>`
		+ `<hr>`
		+ `<a class="col-md-3 text-center" id="model">${product.model}</a>`
		+ `<hr>`
		+ `<label for="price" class="font-weight-bold">ℙ𝕣𝕠𝕕𝕦𝕔𝕥 ℙ𝕣𝕚𝕔𝕖:</label>`
		+ `<hr>`
		+ `<a class="col-md-3 text-center">${product.price}</a>`
		+ `<hr>`
		+ `<label for="price" class="font-weight-bold">ℙ𝕣𝕠𝕕𝕦𝕔𝕥 𝔻𝕖𝕤𝕔𝕣𝕚𝕡𝕥𝕚𝕠𝕟:</label>`
		+ `<hr>`
		+ `<a class="col-md-3 text-center">${product.description}</a>`
		+ `<hr>`
		+ `<label for="price" class="font-weight-bold">ℙ𝕣𝕠𝕕𝕦𝕔𝕥 ℚ𝕦𝕒𝕟𝕥𝕚𝕥𝕪:</label>`
		+ `<hr>`
		+ `<a class="col-md-3 text-center">${product.quantity}</a>`
		+ '</div>'
		+ '<div class="card-footer">'
		+ `<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734; </small>`
		+ '</div>'
		+ `<hr>`
		+ '</div>'
		+ '</div>'
		+ '</div>'
		+ '</div>'
		+ '</div>'
		+ '</div>'

}


function loadItemsFromCategory(categoryId) {
	fetch('http://localhost:8000/products/fetch/' + categoryId).then((response) => response.json()).then((json) => {
		console.log(json);

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
}