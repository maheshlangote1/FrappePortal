from __future__ import unicode_literals
from frappe import _

def get_data():
	return [
		{
			"label": _("Tools"),
			"icon": "octicon octicon-briefcase",
			"items": [
				{
					"type": "Sales Order",
					"name": "Hotel",
					"label": _("Hotel"),
					"description": _("Documents assigned to you and by you."),
				}
				  
		   ]
		}  
	 ]