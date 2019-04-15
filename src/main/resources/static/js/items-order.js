$(document).ready(function () {
    $('#inputOffice').on('change', function () {
    	let selectedOffice = document.getElementById("inputOffice").value;
    	
    	let serviceSelect = $('#divinputService');
    	if (selectedOffice === 'Please select...') {
    	  serviceSelect.hide();
      } else {
        serviceSelect.show();
      }	

    	loadOfficeServices(selectedOffice);
    });



    $('#inputEmployee').on('change', function () {
      let selectedOffice = document.getElementById("inputService").value;

      let availableHours = $('#available-hours');
      if (selectedOffice === 'Please select...') {
        availableHours.hide();
      } else {
        availableHours.show();
      }
    });
});

function loadOfficeServices(officeId) {	
  fetch('http://localhost:8080/service/fetch/' + officeId).then((response) => response.json()).then((json) => {
  	 $('#divinputService').empty();
	    let servicesSelect = `<select class="form-control" id="inputService" name="serviceId">`
	      + `<option value="Please select...">Please select...</option>`
	      
	    	json.forEach((x) => {
	    	  servicesSelect += `<option name="" value="${x.id}">${x.name}</option>`;
	    	});
	    	
	    	servicesSelect += `</select>`;
	    	
	    	$('#divinputService').append(servicesSelect);
	    	
	      $('#inputService').on('change', function () {
	        let selectedOffice = document.getElementById("inputService").value;

	        let availableHours = $('#available-hours');
	        if (selectedOffice === 'Please select...') {
	          availableHours.hide();
	        } else {
	          availableHours.show();
	        }
	      });
});
}