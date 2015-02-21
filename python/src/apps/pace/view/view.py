from npyscreen import NPSApp, Form, FormMutt, FormMultiPage, TitleText, TitleFilename


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



if __name__ == "__main__":
    App = PaceView()
    App.run()
