function validFormScript() {
    const ERROR_INVALID_CATEGORY_LENGHT = "Lenght must be in range of 2 and 20 characters long.";
    const ERROR_INVALID_NUMBER_LENGHT = "Input at least one number.";


    $(`#add-product-name`).on(`keyup keypress`, function () {

        let field = $(`#add-product-name`);
        let helpText = $(`#nameHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#add-product-manufacture`).on(`keyup keypress`, function () {

        let field = $(`#add-product-manufacture`);
        let helpText = $(`#manufatureHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 50) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#add-product-model`).on(`keyup keypress`, function () {

        let field = $(`#add-product-model`);
        let helpText = $(`#modelHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#add-product-description`).on(`keyup keypress`, function () {

        let field = $(`#add-product-description`);
        let helpText = $(`#descriptionHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#add-product-price`).on(`keyup keypress`, function () {

        let field = $(`#add-product-price`);
        let helpText = $(`#priceHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 100000) {
            showHelpText(field, helpText, ERROR_INVALID_NUMBER_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#add-product-quantity`).on(`keyup keypress`, function () {

        let field = $(`#add-product-quantity`);
        let helpText = $(`#quantityHelp`);
        let value = field.val().trim();

        if (value.length < 1 || value.length > 100) {
            showHelpText(field, helpText, ERROR_INVALID_NUMBER_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#edit-product-name`).on(`keyup keypress`, function () {

        let field = $(`#edit-product-name`);
        let helpText = $(`#nameHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#edit-product-description`).on(`keyup keypress`, function () {

        let field = $(`#edit-product-description`);
        let helpText = $(`#descriptionHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#edit-product-price`).on(`keyup keypress`, function () {

        let field = $(`#edit-product-price`);
        let helpText = $(`#priceHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 100) {
            showHelpText(field, helpText, ERROR_INVALID_NUMBER_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });


    function removeHelpText(field, helpText) {
        field.removeClass("border border-danger");
        field.addClass("border border-success");
        helpText.hide();
    }

    function showHelpText(field, helpText, message) {
        field.addClass("border border-danger");
        helpText.text(message);
        helpText.show();
    }

}