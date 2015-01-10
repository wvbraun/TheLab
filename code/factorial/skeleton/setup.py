try:
    from setuptools import setup
except ImportError:
    from distutils.core import setup

config = {
    'description': 'Factorial',
    'author': 'Brandon',
    'url': 'URL to get it at.',
    'download_url': 'Where to download it.',
    'author_email': 'Brandonpeavler2@gmail.com',
    'version': '0.1',
    'install_requires': ['nose'],
    'packages': ['Factorial'],
    'scripts': [],
    'name': 'factorial'
}

setup(**config)