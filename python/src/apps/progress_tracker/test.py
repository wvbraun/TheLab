import curses, math, time

date = time.strftime("%d/%m/%Y")

stdscr = curses.initscr()

curses.start_color()
curses.cbreak()


width  = stdscr.getmaxyx()[1]
height = stdscr.getmaxyx()[0]

stdscr.keypad(1)

for i in range(0, width-1):
    stdscr.addstr(0, i, '*')
    stdscr.addstr(height-1, i, '*')

for i in range(0, height-1):
    stdscr.addstr(i,0, '*') 
    stdscr.addstr(i, width-1, '*')

stdscr.addstr(1, math.floor(width/2), "Progress Tracker")

stdscr.addstr(3, 1, "Date")
stdscr.addstr(3, 11, ":")
stdscr.addstr(3, 13, date)
stdscr.addstr(4, 1, "Bodyweight :")
stdscr.addstr(5, 1, "Energy")
stdscr.addstr(5, 11, ":")
stdscr.addstr(6, 1, "Mood")
stdscr.addstr(6, 11, ":")


bw = stdscr.getstr(4, 13, 3)

stdscr.refresh()
