from Tkinter import *

class Sunglass(object):
    sunglasses = []
    closed = 0

    def __init__(self, brand, char, tint):
        self.brand = brand
        self.char = char
        self.tint = tint
        Sunglass.sunglasses.append(self)

class Application(Frame):

    def __init__(self, master):
        Frame.__init__(self, master)
        self.grid()
        self.create_widget()

    def create_widget(self):

        # creates label of Sunglasses at row 0, col 0, width of 5
        Label(self, text="Sunglasses").grid(row = 0, column = 0, columnspan = 5)
        # creates label at row 1, column 0, width of 5
        Label(self, text="Choose what kind of sunglasses you want: ").grid(row = 1, column = 0, columnspan = 5)

        # creates brand name label, r 2, c 1
        Label(self, text="Brand Name:").grid(row=2, column = 1)

        # the Entry allows us to enter (and store) info
        self.brand = Entry(self, width = 30).grid(row = 2, column = 2, columnspan = 3)

       # to use a checkbutton we need to have a Tkinter variable
       # here we set v to the result of initializing that variable.

        Label(self, text= "Characteristics").grid(row = 4, column = 0)
        # we need 4 dif StringVar()'s bc if you only had one, they would
        # all 'point' to the same location
        # we do .set(None) to keep it empty initally
        self.char1 = StringVar()
        self.char1.set(None)
        self.char2 = StringVar()
        self.char2.set(None)
        self.char3 = StringVar()
        self.char3.set(None)
        self.char4 = StringVar()
        self.char4.set(None)
        
        # create a checkbutton whatever text you want there
        Checkbutton(self, text="blah", variable = self.char1).grid(row = 3, column = 1)
        Checkbutton(self, text="two", variable = self.char2).grid(row = 4, column = 1)
        Checkbutton(self, text="three", variable = self.char3).grid(row = 5, column = 1)
        Checkbutton(self, text="four", variable = self.char4).grid(row = 6, column = 1)


        
        Label(self, text="Tint: ").grid(row=4, column = 2)
        self.tint = StringVar()
        self.tint.set(None)

        # creates a radiobutton
        Radiobutton(self, text="A", variable=self.tint, value = "A").grid(row = 3, column = 4)
        Radiobutton(self, text="B", variable = self.tint, value = "B").grid(row=4, column =4)
        Radiobutton(self, text="C", variable = self.tint, value = "C").grid(row = 5, column = 4)
        Radiobutton(self, text="D", variable = self.tint, value = "D").grid(row = 6, column = 4)


    
        # creates a textbox called output which we will use to display all of our info
        self.output = Text(self, width = 50, height = 10, wrap = WORD)
        self.output.grid(row = 8, column = 1, columnspan = 4)


        # button that calls the add_sunglass function when clicked
        Button(self, text="Add", command = self.add_sunglass).grid(row = 7, column = 1, columnspan = 2)

        # calls clear function when clicked
        Button(self, text="Clear", command = self.clear).grid(row = 7, column = 2)

        # calls save function when clicked
        Button(self, text="Save", command = self.save).grid(row = 9, column = 2)



    def add_sunglass(self):


        glass = "Brand Name: " + self.brand.get() + "\n"
        

        # maybe u need the if statements to check if the values 
        # in the char_.get() are None or not... idk. 
        if self.char1.get() != None:
            glass += "Characteristics: " + self.char1.get() + "\n"
        elif self.char2.get() != None:
            glass += "Characteristics: " + self.char2.get() + "\n"
        elif self.char3.get() != None:
            glass += "Characteristics: " + self.char3.get() + "\n"
        elif self.char4.get() != None:
            glass += "Characteristics: " + self.char4.get() + "\n"

        glass += "Tint: " + self.tint.get() + "\n"

        self.output.delete(0.0, END)
        self.output.insert(0.0, glass)

    def clear(self):

        # deletes what is in brand
        self.brand.delete(0, END)
        # sets the stuff in char1 to None
        self.char1.set(None)
        self.char2.set(None)
        self.char3.set(None)
        self.char4.set(None)
        self.tint.set(None)
        self.output.delete(0.0, END)

    def save(self):
        info = "Brand Name: " + self.brand.get() + "\n"
        info += "Characteristics: " + self.char1.get() + "\n"
        info += "Tint: " + self.tint.get() + "\n"

        filename = open("sunglasses.txt", "w")
        filename.write(info)
        filename.close()

            

# main
root = Tk()
root.title("Sunglass Manager GUI")
root.geometry("1000x300")

app = Application(root)
root.mainloop()

