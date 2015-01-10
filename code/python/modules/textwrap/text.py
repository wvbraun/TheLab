import textwrap


"""
The default width of textwrap.fill() is 70.
textwrap.fill == "\n".join(wrap(text, ...)).
"""

line = "---------------\n"

text = """
    I am a sinner...
    That's probably gonna sin again.
    Lord forgive me, for things I don't understand. 
    Sometimes I need to be alone. 
    """

# no dedent
# fill
print(textwrap.fill(text))

print(line)

# textwrap.dedent().strip()

print(textwrap.dedent(text).strip())
print(line)

# textwrap.dedent()
print(textwrap.dedent(text))
print(line)

# fill + dedent

detext = textwrap.dedent(text).strip()
for width in [20, 60, 80]:
    print
    print("{0} Columns:\n" .format(width))
    print(textwrap.fill(detext, width=width))

print(line)

print(textwrap.fill(textwrap.dedent(text).strip()))

print(line)

# hanging indent
print(textwrap.fill(detext, initial_indent='', subsequent_indent='     '))
