frappe.ready(function() {
	console.log("mahesh")
	// bind events here
	{% if event %}
		let ticket_rate={{event.ticket_rate}}
		console.log("mahesh1")
		$('.event-details').html(
			"<h3>{{event.title}})</h3>\
				<p> {{frappe.format_date(event.event_date)}}</p>\
				<p> Ticket Price :{{frappe.utils.fmt_money(event.ticket_rate)}}</p>")
		console.log("mahesh2")
		$('input[name="rate"]').val(parseInt(ticket_rate));
		console.log("rate")
		$('input[name="no_of_tickets"]').on('change',function(){
			console.log("mahesh3");
			$('input[name="amount"]').val(parseInt($(this).val())*ticket_rate);
			console.log("mahesh4")
		})
	{% endif %}
	console.log("mahesh5")
})
