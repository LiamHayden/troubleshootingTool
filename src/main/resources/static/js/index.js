// function updatePrinters(customerId) {
//     if (!customerId || customerId === 'undefined') {
//         console.error('Invalid customer ID:', customerId);
//         return;  // Don't proceed if the ID is invalid
//     }

//     console.log('Fetching printer details for customer ID:', customerId); // Debugging line

//     try {
//         fetch(`/customers/${customerId}/details`)
//             .then(response => response.json())
//             .then(data => {
//                 // update accessUrl
//                 document.getElementById('accessUrl').textContent = data.accessUrl;

//                 // update printer model
//                 const printerModelSelect = document.getElementById('printerModel');
//                 printerModelSelect.innerHTML = '<option value="" disabled selected> Select a Printer</option>';
//                 data.forEach(printer => {
//                     const option = document.createElement('option');
//                     option.value = printer.id;
//                     option.textContent = `${printer.model}`;
//                     printerModelSelect.appendChild(option);
//                 });

//                 // Uncomment if you want to add assetTag functionality
//                 // const assetTagSelect = document.getElementById('assetTag');
//                 // assetTagSelect.innerHTML = '<option value="" disabled selected> Asset Tag:</option>';
//                 // data.printers.forEach(printer => {
//                 //     const option = document.createElement('option');
//                 //     option.value = printer.assetTag;
//                 //     option.textContent = printer.assetTag;
//                 //     assetTagSelect.appendChild(option);
//                 // });
//             });
//     } catch(error) {
//         console.error('Error fetching printer details:', error);
//         alert('Failed to fetch printer details. Please try again later.');
//     }
// }
