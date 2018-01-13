import frappe
from frappe.model.document import Document
@frappe.whitelist()
def send_confirmation_email(hotel):
	# i use field as hardcoded so please change according to your req.
	frappe.sendmail(
		recipients="maheshlangote1@gmail.com",
		sender="maheshlangote1@gmail.com",
		subject="sub",
		message="your order has been success , please ready payment within 10 minuts",
			send_priority = 0
		)
	frappe.msgprint("send mail success")

@frappe.whitelist()
def get_calendar(date):
	return frappe.db.sql("""" select timestamp(date,date)
		as date,
		hotel_name,
		from 'tabSales Order'
		""",{
		"date":date
		}, as_dict=True)

@frappe.whitelist()
def make_order(doc,method):
	pass
	# salesorder=frappe.get_doc({
	# "doctype":"Sales Order",
	# "title": "Test",
	# date :add_days(nowdate(),1),
	# item_name="asdf",
	# qyantity=5,
	# rate_per_unit=20
	# })
	# salesorder.insert()
	# frappe.msgprint("insert data success")