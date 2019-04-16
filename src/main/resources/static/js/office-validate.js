function validFormScript() {
    const ERROR_INVALID_CATEGORY_LENGHT = "Lenght must be in range of 2 and 20 characters long.";


    $(`#input-city`).on(`keyup keypress`, function () {

        let field = $(`#input-city`);
        let helpText = $(`#cityHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#input-address`).on(`keyup keypress`, function () {

        let field = $(`#input-address`);
        let helpText = $(`#addressHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 50) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#input-phone-number`).on(`keyup keypress`, function () {

        let field = $(`#input-phone-number`);
        let helpText = $(`#phoneNumberHelp`);
        let value = field.val().trim();

        if (value.length < 6 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#input-email`).on(`keyup keypress`, function () {

        let field = $(`#input-email`);
        let helpText = $(`#emailHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
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