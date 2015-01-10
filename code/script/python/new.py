
# Write Python code that assigns to the 
# variable url a string that is the value 
# of the first URL that appears in a link 
# tag in the string page.

# page = contents of a web page
page =('<div id="top_bin"><div id="top_content" class="width960">'
'<div class="udacity float-left"><a href="http://udacity.com">')

quote = page.find('<a href=')
startquote = page.find('"', quote)
endquote = page.find('"', startquote +1)

print quote 
print startquote 
print endquote 

url = page[98:116]
print url