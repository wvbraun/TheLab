"""Tests have three possible outcomes:
    OK - pass
    FAIL - fail and raises and AssertionError execption
    ERROR - raises an expection other than AssertionError
"""

import unittest

class Outcomes(unittest.TestCase):

    def test_pass(self):
        self.assertTrue(True)

    def test_fail(self):
        self.assertTrue(False)

    def test_error(self):
        raise RuntimeError('Test Error!')

if __name__ == '__main__':
    unittest.main()
