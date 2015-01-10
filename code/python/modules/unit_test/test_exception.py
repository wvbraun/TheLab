import unittest

def raises_error(*args, **kwds):
    raise ValueError('Invalid value: {0}{1}' .format(args, kwds))


class Exception(unittest.TestCase):

    def test_trap_locally(self):
        try:
            raises_error('a', b='c')
        except ValueError:
            pass
        else:
            self.fail('did not see ValueError')

    def test_assert_raises(self):

        self.assertRaises(ValueError, raises_error, 'a', b='c')

if __name__ == '__main__':
    unittest.main()
