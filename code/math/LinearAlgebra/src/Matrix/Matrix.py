
class Matrix:

    def __init__(self, mat):
        self.mat = mat

    def reduced_row_echelon_form(self):
        if not self.mat:
            return

        lead     = 0
        rowCount = len(self.mat)
        colCount = len(self.mat[0])

        for r in range(rowCount):
            if lead >= colCount:
                return

            i = r
            while self.mat[i][lead] == 0:
                i += 1
                if i == rowCount:
                    i     = r
                    lead += 1
                    if colCount == lead:
                        return

            self._swapRow(i, r)

            lv = self.mat[r][lead]
            self.mat[r] = [ mrx / float(lv) for mrx in self.mat[r]]

            for i in range(rowCount):
                if i != r:
                    lv = self.mat[i][lead]
                    self.mat[i] = [ iv - lv*rv for rv, iv in zip(self.mat[r], self.mat[i])]

            lead += 1

    def printMatrix(self):
        for i in range(len(self.mat)):
            print("[ ", end="")
            for j in range(len(self.mat[i])):
                item = self.mat[i][j]
                if item >= 0:
                    print(str(item + 0) + ' ', end="")
                else:
                    print("\b" + str(item) + ' ', end="")
            print("]")

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

    def _swapRow(self, r1, r2):
        self.mat[r1], self.mat[r2] = self.mat[r2], self.mat[r1]



