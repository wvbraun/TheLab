
class Matrix:

    def __init__(self, mat):
        self.mat = mat

    def reduced_echelon_form(self):
        for i in range(len(self.mat)):
            if i < len(self.mat) - 1:
                for j in range(len(self.mat[i])):
                    if self._nonZero(self.mat[i+1][j]):
                        m = self.mat[i][j]
                        n = self.mat[i+1][j]
                        print((m,n))
                        scalars = self._findScalars(m, n)
                        self._gaussian(i, i+1, scalars)


    def row_reduced_echelon_form(self):
        pass

    def _gaussian(self, row1, row2, scalars):
        for i in range(len(self.mat[row1])):
            tmp1 = self.mat[row1][i] * scalars[0]
            tmp2 = self.mat[row2][i] * scalars[1]
            self.mat[row2][i] = tmp1 + tmp2

    def _findScalars(self, m, n):
        mScalar = 0
        nScalar = 0
        for i in range(-n, n):
            print(-n)
            if m * i == -n:
                print(i)
                mScalar = i

        for i in range(-m, m):
            if n * i == -m:
                print(i)
                nScalar = i

        return (mScalar, nScalar)


    def _nonZero(self, entry):
        return entry != 0



mat = Matrix([[1, 0, 2],
              [-2, 1, 3],
              [4, 0, 2]])

print(mat.mat)
mat.reduced_echelon_form()
print(mat.mat)

