// Copyright (c) 2018, Frappe and contributors
// For license information, please see license.txt

frappe.ui.form.on('Sales Order', {
	send_email: function(frm) {
		if ( frm.doc.email ){
			frappe.call({
				method : "hotel.api.send_confirmation_email",
				args : { 
					hotel :frm.doc.name
				}
			});
		}
	}
});
