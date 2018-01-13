from __future__ import unicode_literals

import frappe

def get_context(context):
	if frappe.form_dict.public_event :
		context.event=frappe.get_doc('Public Event',frappe.form_dict.public_event)