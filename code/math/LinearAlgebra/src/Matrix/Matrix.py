
class Matrix:

    def __init__(self, mat):
        self.mat = mat

    def reduced_echelon_form(self):
        for c in range(len(self.mat) - 1):
            for r in range(c+1, len(self.mat)):
                if self._non_zero(self.mat[r][c]):
                    m = self.mat[c][c]
                    n = self.mat[r][c]
                    scalars = self._find_scalars(m, n)
                    self._gaussian(c, r, scalars)


    def row_reduced_echelon_form(self):
        pass

    def consistent(self):
        consistent = True
        length = len(self.mat)

        for r in range(length):
            all_zero = True
            for c in range(length - 1):
                if self._non_zero(self.mat[r][c]):
                    all_zero = False
                    break

            if all_zero and self.mat[r][length - 1] != 0:
                consistent = False
                break

        return consistent

    def _gaussian(self, row1, row2, scalars):
        for i in range(len(self.mat[row1])):
            tmp1 = self.mat[row1][i] * scalars[0]
            tmp2 = self.mat[row2][i] * scalars[1]
            self.mat[row2][i] = tmp1 + tmp2

    def _pos(self, n):
        if n > 0:
            return n
        else:
            return -n

    def _neg(self, n):
        if n > 0:
            return -n
        else:
            return n

    def _find_scalars(self, m, n):
        mScalar = 1
        nScalar = 1
        for i in range(self._neg(n), self._pos(n) + 1):
            if m * i == -n:
                mScalar = i

        for i in range(self._neg(m), self._pos(m) + 1):
            if n * i == -m:
                nScalar = i

        return (mScalar, nScalar)


    def _non_zero(self, entry):
        return entry != 0



mat = Matrix([[1, 0, 2],
              [-2, 1, 3],
              [4, 0, 2]])

print(mat.mat)
mat.reduced_echelon_form()
print(mat.mat)
print(mat.consistent())

