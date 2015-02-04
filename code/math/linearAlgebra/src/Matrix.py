
class Matrix:

    def __init__(self, mat):
        self.mat = mat

    def gaussian(self, row1, row2, scalar):
        
        for i in range(len(self.mat[row1])):
            self.mat[row2][i] += self.mat[row1][i] * scalar 

    def reduced_echelon_form(self):
        pass

    def row_reduced_echelon_form(self):
        pass



    


