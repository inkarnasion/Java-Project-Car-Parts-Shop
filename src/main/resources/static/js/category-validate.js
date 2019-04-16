function validFormScript() {
    const ERROR_INVALID_CATEGORY_LENGHT = "Lenght must be in range of 2 and 20 characters long.";


    $(`#add-category-name`).on(`keyup keypress`, function () {

        let field = $(`#add-category-name`);
        let helpText = $(`#nameHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#edit-category-name`).on(`keyup keypress`, function () {

        let field = $(`#edit-category-name`);
        let helpText = $(`#nameHelp`);
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