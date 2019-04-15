$(document).ready(function () {
	$('input[type="radio"]').on('click', function(e) {
	    let isDeliverySelected = document.getElementById("deliveryCourier").checked;
	    let isOfficeSelected = document.getElementById("deliveryOffice").checked;
	    
	    let inputAddress = $('#divinputAddress');
	    if (isDeliverySelected){
	    	inputAddress.show();
	    } else {
	    	inputAddress.hide();
	    }
	    
	    let inputOffice = $('#divinputOffice');
	    if (isOfficeSelected){
	    	inputOffice.show();
	    } else {
	    	inputOffice.hide();
	    }
	    
	    activateBuyButton();
	});

  $('#inputOffice').on('change', function () {
    activateBuyButton();
  });
  
  $('#inputAddress').on('change keydown paste input', function () {
    activateBuyButton();
  });
});

function activateBuyButton(){
  let isDeliverySelected = document.getElementById("deliveryCourier").checked;
  let isOfficeSelected = document.getElementById("deliveryOffice").checked;
  
  let selectedOffice = document.getElementById("inputOffice").value;
  let inputAddressLength   = document.getElementById("inputAddress").value.length;
  
  console.log("ïnput="+document.getElementById("inputAddress").value);
  console.log("length="+inputAddressLength);

  let buyButton = $('#buyButton');
  
  if (isDeliverySelected && inputAddressLength>10){
    buyButton.prop("disabled", false);
  } else if (isOfficeSelected && selectedOffice !== 'Please select...'){
    buyButton.prop("disabled", false);
  } else {
    buyButton.prop("disabled", true);
  }
}