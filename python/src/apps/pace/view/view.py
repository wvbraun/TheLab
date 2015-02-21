#from npyscreen import NPSApp, Form, FormMutt, FormMultiPage, TitleText, TitleFilename

import urwid


class MenuButton(urwid.Button):
    
    def __init__(self, caption, callback):
        super(MenuButton, self).__init__("")
        urwid.connect_signal(self, 'click', callback)
        self._w = urwid.AttrMap(urwid.SelectableIcon(
            [u' \N{BULLET} ', caption], 2), None, 'selected')


'''
class PaceView(NPSApp):
    def main(self):
        F = Form(name = "PACE")

class LiftPanel (NPSApp):

    def main(self):
        F = Form(name = "LIFTING")
        liftPanel = F.add_page()
        #F.switch_page(0)
        #t = F.add(TitleText, name = "Text: ")

        #F.edit()


'''

if __name__ == "__main__":
    App = PaceView()
    App.run()
