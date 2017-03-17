import string
import time
import calendar
from time import asctime
from dateutil import parser
from math import trunc

# Length of Mars day in seconds (88,775.244147 seconds, or 24h 39m 35.244147s)
MARS_DAY = 88775.244

currentTime = time.time()
epoch = calendar.timegm( parser.parse( "1 Jan 2017" ).timetuple() )

diff = currentTime - epoch
day = diff / MARS_DAY
timeOfDay = diff % MARS_DAY

m, s = divmod(timeOfDay, 60)
h, m = divmod(m, 60)

print("Based on epoch {}, at current time {}, it will be {:d}:{:02d}:{:02d} on Mars".format(epoch, currentTime, trunc(h), trunc(m), trunc(s) ) )

