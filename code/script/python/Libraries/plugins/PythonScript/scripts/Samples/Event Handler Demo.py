import datetime

# Just in case, we'll clear all the existing callbacks for FILEBEFORESAVE
notepad.clearCallbacks([NOTIFICATION.FILEBEFORESAVE])

# Define the function to call just before the file is saved
def addSaveStamp(args):
	if notepad.getBufferFilename(args["bufferID"])[-4:] == '.log':
		if MESSAGEBOXFLAGS.RESULTYES == notepad.messageBox('Hello from Python Script... Would you like to append the date to this log file?', 'Python Script', MESSAGEBOXFLAGS.YESNO):
			notepad.activateBufferID(args["bufferID"])
			editor.appendText("File saved on %s\r\n" % datetime.date.today())
		if MESSAGEBOXFLAGS.RESULTYES == notepad.messageBox("Would you like to cancel this callback, so you don't get asked again?", "Python Script", MESSAGEBOXFLAGS.YESNO):
			notepad.clearCallbacks([NOTIFICATION.FILEBEFORESAVE])
		
	
# ... and register the callback	
notepad.callback(addSaveStamp, [NOTIFICATION.FILEBEFORESAVE])

# As this is a sample, we'll inform the user 
notepad.messageBox("FILEBEFORESAVE notification registered.\n*.log files will now automatically be modified before saving.\nCtrl-Click the script to edit.\n", "Python Script Demo", 0)
