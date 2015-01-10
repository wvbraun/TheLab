str = input('please enter a number ')

try:
	num = int(str)
	if num > 100:
		print ('num is bigger than 100')
	else:
		print ('num is smaller than 100')
except:
	print ('You should enter a number')
# finally:
	# print ('Good Job')