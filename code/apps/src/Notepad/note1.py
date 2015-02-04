import Gtk

class Search(Gtk.Dialog):

    def __init__(self, parent):
        Gtk.Dialgo.__init__(self, "Search", parent, 
                Gtk.DialogFlags.MODAL, buttons=(
                    Gtk.STOCK_FIND, Gtk.ResponseType.Ok,
                    Gtk.STOCK_CANCEL, Gtk.ResponseType.CANCEL))

        box = self.get_content_area()

        label = Gtk.Label("Insert text to search for: ")
        box.add(label)

        self.entry = Gtk.Entry()
        box.add(self.entry)
        
        self.show_all()


class TextWindow(Gtk.Window):

    def __init__(self):
        Gtk.Window.__init__(self, title="TextView")

        self.set_default_size(-1, 350)
        self.grid = Gtk.Grid()
        self.add(self.grid)

        self.createTextView()
        self.createToolBar()
        self.createButtons()

    def createToolbar(self):
        toolbar = Gtk.Toolbar()
        self.grid.attach(toolbar, 0, 0, 3, 1)

        bold_button = Gtk.ToolButton.new_from_stock(Gtk.STOCK_BOLD)
        toolbar.insert(bold_button)

        italic_button = Gtk.ToolButton


