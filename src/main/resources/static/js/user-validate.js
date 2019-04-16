function validFormScript() {
    const ERROR_INVALID_CATEGORY_LENGHT = "Lenght must be in range of 2 and 20 characters long.";
    const ERROR_INVALID_NUMBER_LENGHT = "Input at least one number.";


    $(`#usernameRegister`).on(`keyup keypress`, function () {

        let field = $(`#usernameRegister`);
        let helpText = $(`#nameRegisterHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#passwordRegister`).on(`keyup keypress`, function () {

        let field = $(`#passwordRegister`);
        let helpText = $(`#passwordRegisterHelp`);
        let value = field.val().trim();

        if (value.length < 6 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#confirmPasswordRegister`).on(`keyup keypress`, function () {

        let field = $(`#confirmPasswordRegister`);
        let helpText = $(`#confirmPasswordRegisterHelp`);
        let value = field.val().trim();

        if (value.length < 6 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#firstNameRegister`).on(`keyup keypress`, function () {

        let field = $(`#firstNameRegister`);
        let helpText = $(`#firstNameRegisterHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#lastNameRegister`).on(`keyup keypress`, function () {

        let field = $(`#lastNameRegister`);
        let helpText = $(`#LastNameRegisterHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#emailRegister`).on(`keyup keypress`, function () {

        let field = $(`#emailRegister`);
        let helpText = $(`#emailRegisterHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#phoneNumberRegister`).on(`keyup keypress`, function () {

        let field = $(`#phoneNumberRegister`);
        let helpText = $(`#phoneNumberRegisterHelp`);
        let value = field.val().trim();

        if (value.length < 6 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_NUMBER_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#creditCardNumberRegister`).on(`keyup keypress`, function () {

        let field = $(`#creditCardNumberRegister`);
        let helpText = $(`#creditCardNumberRegisterHelp`);
        let value = field.val().trim();

        if (value.length < 9 || value.length > 15) {
            showHelpText(field, helpText, ERROR_INVALID_NUMBER_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#usernameLogin`).on(`keyup keypress`, function () {

        let field = $(`#usernameLogin`);
        let helpText = $(`#userLoginHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#passwordLogin`).on(`keyup keypress`, function () {

        let field = $(`#passwordLogin`);
        let helpText = $(`#passwordLoginHelp`);
        let value = field.val().trim();

        if (value.length < 6 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#usernameEdit`).on(`keyup keypress`, function () {

        let field = $(`#usernameEdit`);
        let helpText = $(`#userNameEditHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#oldPasswordEdit`).on(`keyup keypress`, function () {

        let field = $(`#oldPasswordEdit`);
        let helpText = $(`#oldPasswordEditHelp`);
        let value = field.val().trim();

        if (value.length <6  || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#newpasswordEdit`).on(`keyup keypress`, function () {

        let field = $(`#newpasswordEdit`);
        let helpText = $(`#newPasswordEditHelp`);
        let value = field.val().trim();

        if (value.length < 6 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#confirmPasswordEdit`).on(`keyup keypress`, function () {

        let field = $(`#confirmPasswordEdit`);
        let helpText = $(`#confirmPasswordEditHelp`);
        let value = field.val().trim();

        if (value.length < 6 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });

    $(`#emailEdit`).on(`keyup keypress`, function () {

        let field = $(`#emailEdit`);
        let helpText = $(`#emailHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#firstNameEdit`).on(`keyup keypress`, function () {

        let field = $(`#firstNameEdit`);
        let helpText = $(`#firstNameEditHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#lastNameEdit`).on(`keyup keypress`, function () {

        let field = $(`#lastNameEdit`);
        let helpText = $(`#lastNameEditHelp`);
        let value = field.val().trim();

        if (value.length < 2 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#phoneNumberEdit`).on(`keyup keypress`, function () {

        let field = $(`#phoneNumberEdit`);
        let helpText = $(`#phoneNumberEditHelp`);
        let value = field.val().trim();

        if (value.length < 6 || value.length > 20) {
            showHelpText(field, helpText, ERROR_INVALID_CATEGORY_LENGHT);
        } else {
            removeHelpText(field, helpText);
        }
    });
    $(`#creditCardNumberEdit`).on(`keyup keypress`, function () {

        let field = $(`#creditCardNumberEdit`);
        let helpText = $(`#creditCardEditHelp`);
        let value = field.val().trim();

        if (value.length < 9 || value.length > 15) {
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