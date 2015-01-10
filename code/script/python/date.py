daysOfMonths = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

def isLeapYear(year):
	

def dateIsBefore(year1, month1, day1, year2, month2, day2):
	if year1 < year2:
		return True
	if year1 == year2:
		if month1 < month2:
			return True
		if month1 == month2:
			return day1 < day2:
		return False

def daysBetweenDates(y1, m1, d1, y2, m2, d2):

days = 0 
while dateisBefore(year1, month1, day1, year2, month2, day2):
	year1, month1, day1 = nextDay(year1, month1, day1)
	days += 1
return days

    ##
    # Your code here.
    ##
    return days

def extraFunction(???):
    ##
    # ???
    ##
	
