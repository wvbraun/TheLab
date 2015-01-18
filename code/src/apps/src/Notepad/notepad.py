from Tkinter import *
from tkSimpleDialog import askstring
from tkFileDialog import asksaveasfile
from tkMessageBox import askokcancel

class Scrolled(Frame):

    def __init__(self, parent=None):
        Frame.__init__(self, parent)
        self.pack(expand=YES, fill=BOTH)
        self.createWidgets()
        self.setText()

    def createWidgets(self):
        scrollBar = Scrollbar(self)
        scrollBar.config(command=text.yview)
        scrollBar.pack(side=RIGHT, fill=Y)

        text = Text(self, relief=SUNKEN)
        text.config(yscrollcommand = scrollBar.set)
