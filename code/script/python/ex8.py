formatter = "%r %r %r %r"

print formatter % (1, 2, 3, 4)
print formatter % ("one", "two", "three", "four")
print formatter % (True, False, False, True)
print formatter % (formatter, formatter, formatter, formatter)
print formatter % ( 
	"I had this thing.",
	"That you could type right up.",
	"But it didn't sing.",
	"So I said goodnight."
	#initially on these 4 lines I forgot to use a comma
	#this produced an error.
)
	