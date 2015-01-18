from Tkinter import *

#
#class File(object):

#    def __init__(self, fileName):
#        self.fileName = fileName

class NotePad(Frame):


    def __init__(self, master):
        Frame.__init__(self, master)
        self.grid()
        self.createWidget()


    def createWidget(self):

        Label(self, text="Filename: ").grid(row=0, column=0)

        self.fileName = Text(self, width = 30, height = 1).grid(row = 0, column = 1)


        self.output = Text(self, width = 100, height = 10, wrap = WORD)
        self.output.grid(row = 2, column = 1)

        Button(self, text="Save", command = self.save).grid(row=3, column=2)


    
    def save(self):
        info = self.output

        filename = open(self.fileName, "w")
        filename.write(info)
        filename.close()

        
root = Tk()
root.title("Text Editor")
root.geometry("1000x300")

app = NotePad(root)
root.mainloop()
