
class Matrix:

    def __init__(self, mat):
        self.mat = mat

    def reduced_echelon_form(self):
        for i in range(len(self.mat)):
            if i < len(self.mat) - 1:
                for j in range(len(self.mat[i])):
                    if self._nonZero(self.mat[i+1][j]):
                        pass



    def row_reduced_echelon_form(self):
        pass

    def _gaussian(self, row1, row2, scalar):
            
            for i in range(len(self.mat[row1])):
                self.mat[row2][i] += self.mat[row1][i] * scalar 

    def _nonZero(self, entry):
        return entry != 0



mat = Matrix([[1, 0, 2],
              [-2, 1, 3],
              [4, 0, 2]])

mat.reduced_echelon_form()
