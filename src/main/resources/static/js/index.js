function fetchCustomerDetails(customerId) {
    fetch(`/customer-details/${customerId}`)
        .then(repsonse =>Response.json())
        .then(data => {
            // update accessUrl
            document.getElementById('accessUrl').textContent = data.accessUrl;

            // update printer model
            const printerModelSelect = document.getElementById('printerModel');
            printerModelSelect.innerHTML = '<option value="" disabled selected> Select a Printer</option>';
            data.printers.forEach(printer => {
                const option = document.createElement('option');
                option.value = printer.id;
                option.textContent = printer.model;
                printerModelSelect.appendChild(option);
            });

            // update assetTag
            const assetTagSelect = document.getElementById('assetTag');
            assetTagSelect.innerHTML = '<option value="" disabled selected> Asset Tag:</option>';
            data.printers.forEach(printer => {
                const option = document.createElement('option');
                option.value = printer.assetTag;
                option.textContent = printer.assetTag;
                assetTagSelect.appendChild(option);
            });
        });
}