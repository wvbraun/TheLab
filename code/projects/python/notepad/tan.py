from Tkinter import *

class Animal(object):
    animals = []
    closed = 0

    def __init__(self, species, name):
        self.species = species
        self.name = name
        self.boredom = 0
        self.hunger = 0
        self.visible = True
        Animal.animals.append(self)

    def __str__(self):
        warning = 3
        bad = 5
        reply = self.species + " Name: " + self.name + "\n"
        
        status = ""
        if self.boredom >= bad:
            status += "BORED "
        elif self.boredom >= warning:
            status += "Somewhat Bored "
            
        if self.hunger >= bad:
            status += "HUNGRY "
        elif self.hunger >= warning:
            status += "Somewhat Hungry "

        if self.hunger < warning and self.boredom < warning:
            status += "Fine"

        return reply + "Status: " + status + "\n\n"
    
    def pace(self):
        if self.visible:
            self.boredom += 1
            self.hunger += 1

            if self.boredom == 5 or self.hunger == 5:
                Animal.closed += 1
                self.visible = False


class Application(Frame):

    def __init__(self, master):
        Frame.__init__(self, master)
        self.grid()
        self.create_widget()

    def create_widget(self):
        self.instructions = Label(self, text="Add animals on the left, or interact with them on the right")
        self.instructions.grid(row = 0, column = 0, columnspan = 5)
        
        Label(self, text="Name:").grid(row = 1, column = 0)
        self.name_ent = Entry(self, width=30)
        self.name_ent.grid(row = 1, column = 1)

        Label(self, text="Species:").grid(row = 2, column = 0)
        self.species_ent = Entry(self, width=30)
        self.species_ent.grid(row = 2, column = 1)
        
        self.make_bttn = Button(self, text = "Add Animal", command = self.make_animal)
        self.make_bttn.grid(row = 3, column = 0, columnspan = 2)

        self.closed_lbl = Label(self, text="Closed Exhibits: 0 / 2")
        self.closed_lbl.grid(row = 4, column = 0, columnspan = 5)

        self.display = Text(self, width = 50, height = 15, wrap = WORD)
        self.display.grid(row = 1, column = 2, rowspan = 3)

        Label(self, text="Name:").grid(row = 1, column = 3)
        self.interact_ent = Entry(self, width=30)
        self.interact_ent.grid(row = 1, column = 4)
        
        self.make_bttn = Button(self, text = "Feed Animal", command = self.feed_animal)
        self.make_bttn.grid(row = 2, column = 3, columnspan = 2)
        
        self.make_bttn = Button(self, text = "Entertain Animal", command = self.entertain_animal)
        self.make_bttn.grid(row = 3, column = 3, columnspan = 2) 

    def update_closed(self):
        self.closed_lbl["text"] = "Closed Exhibits: " + str(Animal.closed) + " / 2"

        if Animal.closed == 2:            
            self.display.delete(0.0, END)
            self.display.insert(0.0, "ZOO CLOSED!!!")            

    def make_animal(self):

        if not self.name_ent.get():
            name = "Unnamed Animal"
        else:
            name = self.name_ent.get()
        
        if not self.species_ent.get():
            species = "Unknown Species"
        else:
            species = self.species_ent.get()
                
        animal = Animal(species, name)

        message = ""

        for animal in Animal.animals:
            message += str(animal)
            
        self.display.delete(0.0, END)
        self.display.insert(0.0, message)

        self.name_ent.delete(0, END)
        self.species_ent.delete(0, END)

        self.update_closed()       

    def feed_animal(self):
        if not self.interact_ent.get():
            name = "Unnamed Animal"
        else:
            name = self.interact_ent.get()

        message = "You put food out for " + name +".\n"
        
        for i in range(len(Animal.animals)):
            if Animal.animals[i].name == name:
                if Animal.animals[i].visible:
                    Animal.animals[i].hunger = 0
                    Animal.animals[i].boredom += 1
                    if Animal.animals[i].boredom == 5:
                        Animal.closed += 1
                        Animal.animals[i].visible = False
            else:
                Animal.animals[i].pace()
        message += "All of the other animals pace in their enclosure.\n"

        for animal in Animal.animals:
            message += str(animal)

        self.interact_ent.delete(0, END)
            
        self.display.delete(0.0, END)
        self.display.insert(0.0, message)

        self.update_closed()

    def entertain_animal(self):
        if not self.interact_ent.get():
            name = "Unnamed Animal"
        else:
            name = self.interact_ent.get()

        message = "You try to entertain " + name +".\n"
        
        for i in range(len(Animal.animals)):
            if Animal.animals[i].name == name:
                if Animal.animals[i].visible:
                    Animal.animals[i].boredom = 0
                    Animal.animals[i].hunger += 1
                    if Animal.animals[i].hunger == 5:
                        Animal.closed += 1
                        Animal.animals[i].visible = False
            else:
                Animal.animals[i].pace()
        message += "All of the other animals pace in their enclosure.\n"

        for animal in Animal.animals:
            message += str(animal)

        self.interact_ent.delete(0, END)
            
        self.display.delete(0.0, END)
        self.display.insert(0.0, message)

        self.update_closed()

# main
root = Tk()
root.title("Animal Manager GUI")
root.geometry("1000x300")

app = Application(root)
root.mainloop()

