# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from . import __version__ as app_version

app_name = "hotel"
app_title = "Hotel"
app_publisher = "Frappe"
app_description = "this is hotel application"
app_icon = "octicon octicon-file-directory"
app_color = "grey"
app_email = "maheshlangote1@gmail.com"
app_license = "MIT"

# Includes in <head>
# ------------------

# include js, css files in header of desk.html
# app_include_css = "/assets/hotel/css/hotel.css"
# app_include_js = "/assets/hotel/js/hotel.js"

# include js, css files in header of web template
# web_include_css = "/assets/hotel/css/hotel.css"
# web_include_js = "/assets/hotel/js/hotel.js"

# include js in page
# page_js = {"page" : "public/js/file.js"}

# include js in doctype views
# doctype_js = {"doctype" : "public/js/doctype.js"}
# doctype_list_js = {"doctype" : "public/js/doctype_list.js"}
# doctype_tree_js = {"doctype" : "public/js/doctype_tree.js"}
# doctype_calendar_js = {"doctype" : "public/js/doctype_calendar.js"}

# Home Pages
# ----------

# application home page (will override Website Settings)
# home_page = "login"

# website user home page (by Role)
# role_home_page = {
#	"Role": "home_page"
# }

# Website user home page (by function)
# get_website_user_home_page = "hotel.utils.get_home_page"

# Generators
# ----------

# automatically create page for each record of this doctype
website_generators = ["Sales Order"]

# Installation
# ------------

# before_install = "hotel.install.before_install"
# after_install = "hotel.install.after_install"

# Desk Notifications
# ------------------
# See frappe.core.notifications.get_notification_config

# notification_config = "hotel.notifications.get_notification_config"

# Permissions
# -----------
# Permissions evaluated in scripted ways

# permission_query_conditions = {
# 	"Event": "frappe.desk.doctype.event.event.get_permission_query_conditions",
# }
#
# has_permission = {
# 	"Event": "frappe.desk.doctype.event.event.has_permission",
# }

# Document Events
# ---------------
# Hook on document methods and events

doc_events={
	"user" :{
	"after_insert" : "hotel.api.make_order"
	}
}
# doc_events = {
# 	"Sales Order": {
# 		"validate": "hotel.hotel.Sales_Order.py",
		
# 	}
# }

# Scheduled Tasks
# ---------------

# scheduler_events = {
# 	"all": [
# 		"hotel.tasks.all"
# 	],
# 	"daily": [
# 		"hotel.tasks.daily"
# 	],
# 	"hourly": [
# 		"hotel.tasks.hourly"
# 	],
# 	"weekly": [
# 		"hotel.tasks.weekly"
# 	]
# 	"monthly": [
# 		"hotel.tasks.monthly"
# 	]
# }

# Testing
# -------

# before_tests = "hotel.install.before_tests"

# Overriding Whitelisted Methods
# ------------------------------
#
# override_whitelisted_methods = {
# 	"frappe.desk.doctype.event.event.get_events": "hotel.event.get_events"
# }

