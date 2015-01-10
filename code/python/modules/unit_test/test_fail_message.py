import unittest

class Failure(unittest.TestCase):

    def test_fail(self):
        self.assertTrue(False, 'failure message goes here')

if __name__ == '__main__':
    unittest.main()
