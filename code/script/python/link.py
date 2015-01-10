def get_page(url):
    try:
        import urllib
        return urllib.urlopen(url).read()
    except:
        return ""
		
def print_all_links(page):
	while True:
		url, endpos = get_next_target(page)
		if url:
			print url
			page = page[endpos:]
		else:
			break
			
print print_all_links(get_page('http://www.reddit.com')