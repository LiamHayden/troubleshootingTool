$(document).ready(function () {
  // When a customer is selected
  $('#customerSelect').change(function () {
    var customerId = $(this).val();
    window.console && console.log(customerId);

    if (customerId) {
      // Get printers associated with the selected customer
      $.get('/index/customers/' + customerId + '/printers', function (printers) {
        $('#printerSelect').empty().append('<option value="">Select a printer</option>');
        $.each(printers, function (i, printer) {
          $('#printerSelect').append('<option value="' + printer.id + '">' + printer.model + '</option>');
        });
      });

      // Get customer details and update the Access URL
      try {
        $.get('/index/customer/' + customerId, function (customer) {
          if (customer) {
            $('#accessUrl').val(customer.accessUrl);
          } else {
            alert("Customer not found.");
          }
        })
      } catch (err) {
        alert("Error fetching customer details." + err);
      }

    }
  });

  // When a printer is selected
  $('#printerSelect').change(function () {
    var printerId = $(this).val();

    if (printerId) {
      // Get printer details and update the Asset Tag
      $.get('/printers/' + printerId, function (printer) {
        $('#assetTag').val(printer.assettag);
      });
    }
  });
});

// DISPLAY TROUBLESHOOTING SECTION
function displayBottomContainer() {
  document.getElementById("bottom-container").style.display = "block";
}