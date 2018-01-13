#Program virtual.py
import shelve

fs=shelve.open('myfilesystem.fs',writeback=True)
current_dir= []

def install(fs):
	username=raw_input('Enter user name you wanted?')

	fs[""]={"System":{}, "Users":{username:{}}}

def current_dictionary():
	"""Display dictionary containing the files in the current directory"""
	d=fs[""]
	for key in current_dir:
		d=d[key]
		return d

def ls(args):
	print 'Contents of dirctory are:',"/"+"/".join(current_dir)+':'
	for i in current_dictionary():
		print i

def cd(args):
	if len(args)!=1:
		print"Usage:cd<directory>"
	return
	
	if args[0]=="..":
		if len(current_dir)==0:
			print "Sorry!!!Cannot go above root"
		else:
			current_dir.pop()
	elif args[0] not in current_dictionary():
			print "Dirctory"+args[0]+"no found"
	else:
		current_dir.append(args[0])

def mkdir(args):
	if len(args)!=1:
		print"usage :mkdir<directory>"
	return
	d=current_dictionary()[args[0]]={}
	fs.sync()
COMMANDS={'ls':ls,'cd':cd,'mkdir':mkdir}

install(fs)
raw=raw_input('>')
cmd=raw.split()[0]
if cmd in COMMANDS:
		COMMANDS[cmd](raw.split()[1:])

raw_input('press enter key to shutdown the filesystem')
