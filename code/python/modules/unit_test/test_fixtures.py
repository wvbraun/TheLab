import unittest

class FixturesTest(unittest.TestCase):

    def setUp(self):
        print('In setUp()')
        self.fixture = range(1, 10)

    def tearDown(self):
        print('In tearDown()')
        self.fixture

    def test(self):
        print('In test()')
        self.assertEqual(self.fixture, range(1, 10))

if __name__ == '__main__':
    unittest.main()
