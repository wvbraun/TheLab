def proc4(p):
	q = []
	while p:
		q.appened(p.pop())
	while q:
		p.append(q.pop())
		