# -*- coding: utf-8 -*-
# Copyright (c) 2018, Frappe and contributors
# For license information, please see license.txt

from __future__ import unicode_literals
import frappe
from frappe.utils import flt
from frappe.model.document import Document
from frappe.website.website_generator import WebsiteGenerator


class SalesOrder(WebsiteGenerator):
	website = frappe._dict(
        template = "templates/generators/hotel.html"
    )
	def validate(self):
		self.page_name ="Hotel0009"
		total_weight = 0.0
		weight=0.0
		discount=0.0
		for row in self.menu :
			row.total=flt(row.rate_per_unit)*flt(row.quantity)
			discount +=flt(row.total)*flt(row.discount)/100
			total_weight += row.total-discount
			self.weight=flt(total_weight)
		self.total=flt(total_weight)
		self.discount=flt(discount)


