frappe.views.calendar["sales Order"] = {
	field_map : {
		"start" :"date",
		"id":"name",
		'total':"total"
	},
	get_events_method : "hotel.api.get_calendar"
}