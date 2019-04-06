$(document).ready(function () {
    $('#bdParts').on('click', function () {
        func();
    });
    fetch('http://localhost:8000/categories/fetch')
        .then((response) => response.json())
        .then((json) => {
            console.log(json);
            let a = $("<ul id='ks'></ul>");
            for (let i = 0; i < json.length; i++) {
                let id = json[i].id;
                a.append(`<li><a id="${id}" href="#">${json[i].name}</a></li>`);
                $(`#` + id).on('click', function () {

                });
            }
            $('#tst').append(a);
        });

    function func() {
        let contentDiv = $('#tst');
        if (contentDiv.is(':visible')) {
            contentDiv.hide();
        } else {
            contentDiv.show();
        }
    }

    function asd(w) {
        console.log(w)
    }
});