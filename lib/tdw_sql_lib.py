"""
   Copyright (c) 2010 Ma Can <ml.macana@gmail.com>
                      roachxiang <roachxiang@tencent.com>

This is the TDW SQL Library. We supply the following functions 
for our user.
"""

import time
import datetime
import math
import calendar
import tdw_sql_lib

# String Functions:
def nvl(tdw, string, replace_with):
    '''Fully support Oracle NVL'''
    if string is None:
        return replace_with

def nvl2(tdw, string, value_if_not_null, value_if_null):
    '''Fully support Oracle NVL2'''
    if string is None:
        return value_if_null
    else:
        return value_if_not_null

def substr(tdw, string, start_position, leng = 65535):
    '''Fully support Oracle PL/SQL substr'''
    if string is None:
        return None
    
    #for PL/SQL string start with positon 1, treats 0 as 1
    if start_position > 0:
        start_position -= 1
    if start_position < 0:
        start_position += len(string)
    
    #for PL/SQL if length <= 0 ,return NULL
    if leng <= 0:
        return None
    elif leng > len(string):
        return string[start_position:]
    else:
        if leng < 65535:
            end_position =  start_position + leng
            return string[start_position:end_position]
        else:
            return string[start_position:]

# API Has changed from Oracle 10g (trim, ltrim, rtrim)
def ltrim(tdw, old_str, ch = None):
    '''LTRIM is changed from Oracle'''
    if ch != None:
        return old_str.lstrip(ch)
    else:
        return old_str.lstrip()

def rtrim(tdw, old_str, ch = None):
    '''RTRIM is changed from Oracle'''
    if ch != None:
        return old_str.rstrip(ch)
    else:
        return old_str.rstrip()

def trim(tdw, old_str, ch = None):
    '''TRIM is changed from Oracle'''
    old_str = ltrim(old_str, ch)
    return rtrim(old_str, ch)

def length(tdw, string):
    '''Fully support Oracle LENGTH'''
    if string == None or string == "":
        return None
    return len(string)

def upper(tdw, string):
    '''Fully support Oracle UPPER'''
    return string.upper() 

def lower(tdw, string):
    '''Fully support Oracle LOWER'''
    return string.lower()

def instr(tdw, srcstr, sub_str, start = 0, nth = 1):
    '''Fully support Oracle INSTR'''
    reset = 0
    if start < 0:
        start += len(srcstr)
        reset = 1

    while nth > 0:
        start = srcstr.find(sub_str, start)
        start += 1
        if start == 0 and reset == 1:
            nth += 1
        nth -= 1
    return start

def replace(tdw, src, to_replace, replacement = ""):
    '''Fully support Oracle REPLACE'''
    return src.replace(to_replace, replacement)

# Conversion Functions:
def to_number(tdw, uinput, uformat = None):
    '''TO_NUMBER changed from Oracle TO_NUMBER'''
    try:
        if uinput.find('.') == -1:
            if uinput.isdigit() is True or uinput[0] == '+' or uinput[0] == '-':
                return int(uinput)
            else:
                print "Invalid number format!"
                return None        
        else:
            return float(uinput)
    except ValueError, ve:
        print ve
        return None

def to_char(tdw, uinput, uformat = None):
    '''TO_CHAR changed from Oracle TO_CHAR'''
    if isinstance(uinput, Dateclass):
        return to_char_date(uinput, uformat)
    else:
        try:
            if uformat == None or uformat == "":
                return uinput
            uinput = str(uinput)
            ret = ""
            i = 0
            j = 0
            has_digit = 0
            while i < len(uformat):
                if uformat[i] == '9':
                    ret += uinput[j]
                    i += 1
                    j += 1
                elif uformat[i] == '0':
                    if has_digit == 1:
                        ret += uinput[j]
                        j += 1
                    else:
                        ret += "0"
                    i += 1
                elif uformat[i] == '.':
                    if uinput[j] != '.':
                        print "Value and format mismatch!"
                        return None
                    ret += uinput[j]
                    i += 1
                    j += 1
                    has_digit = 1
                else:
                    ret += uformat[i]
                    i += 1
        except IndexError, ie:
            print ie
            return None

        return ret

# Math Functions
def mod(tdw, m, n):
    '''MOD changed from Oracle MOD'''
    return math.fmod(m, n)

def tdw_abs(tdw, number):
    '''Python build-in function abs'''
    return abs(number)

def floor(tdw, number):
    '''Python build-in function floor'''
    return math.floor(number)

def ln(tdw, number):
    '''Python build-in function log'''
    return math.log(number)

def acos(tdw, number):
    '''Python build-in function acos'''
    return math.acos(number)

def sin(tdw, number):
    '''Python build-in function sin'''
    return math.sin(number)

def sinh(tdw, number):
    '''Python build-in function sinh'''
    return math.sinh(number)

def cos(tdw, number):
    '''Python build-in function cos'''
    return math.cos(number)

def cosh(tdw, number):
    '''Python build-in function cosh'''
    return math.cosh(number)

def tan(tdw, number):
    '''Python build-in function tan'''
    return math.tan(number)

def tanh(tdw, number):
    '''Python build-in function tanh'''
    return math.tanh(number)

# round function is a python built-in function!
def tdw_round(tdw, number, dp = 0):
    '''Python build-in function round'''
    return round(number, dp)

def power(tdw, m, n):
    '''Python build-in function math.pow'''
    return math.pow(m, n)

def trunc_number(tdw, f, n = 0):
    '''Internal NUMBER TRUNC function'''
    f = float(f)
    ret = ('%.*f' % (n + 1, f))[:-1]
    if n == 0:
        ret = ret.replace('.', '')
    elif n < 0:
        i = int(f)
        j = -n
        while j > 0:
            i /= 10
            j -= 1
        j = -n
        while j > 0:
            i *= 10
            j -= 1
        ret = str(i)
    return ret
            
def trunc(tdw, uinput, argv1 = 0):
    '''TRUNC changed from Oracle'''
    if isinstance(uinput, Dateclass):
        return trunc_date(tdw, uinput, argv1)
    else:
        return trunc_number(tdw, uinput, argv1)

# Date Functions:
sessiontimezone = time.timezone
dbtimezone = time.timezone

def tz_offset(tdw, name):
    '''TZ_OFFSET changed from Oracle TZ_OFFSET
    tz_offset('-08:00') 	would return '-08:00'
    tz_offset('US/Michigan')    is NOT supported
    '''
    if type(name) == type(str()):
        return name
    else:
        try:
            offset = long(name) / 3600
            ret = ""
            if offset < 0:
                ret += "+"
                ret += "%02d" % (-offset)
            else:
                ret += '-'
                ret += "%02d" % (offset)
            ret += ":00"
            return ret
        except ValueError, ve:
            print ve
            return None

class Dateclass:
    """
    Date type class, give the default value
    """
    year = str(time.localtime(time.time()).tm_year)
    month = str(time.localtime(time.time()).tm_mon)
    day = '01'
    hour = '00'
    min = '00'
    sec = '00'
    subsec = 0.0

    def __init__(self, year = None, month = None, day = None, 
                 hour = None, min = None, sec = None, subsec = None):
        if year != None:
            self.year = str(year)
        if month != None:
            self.month = str(month)
        if day != None:
            self.day = str(day)
        if hour != None:
            self.hour = str(hour)
        if min != None:
            self.min = str(min)
        if sec != None:
            self.sec = str(sec)
        if subsec != None:
            self.subsec = float(subsec)

    def current(self):
        timetmp = time.localtime(time.time())
        self.year = str(timetmp.tm_year)
        self.month = str(timetmp.tm_mon)
        self.day = str(timetmp.tm_mday)
        self.hour = str(timetmp.tm_hour)
        self.min = str(timetmp.tm_min)
        self.sec = str(timetmp.tm_sec)
        _tmp = time.time()
        self.subsec = _tmp - int(_tmp)
        return self

    def __sub__(self, other):
        '''sub two days and return the day gap'''
        dt = datetime.datetime(int(self.year), int(self.month), 
                               int(self.day), int(self.hour), 
                               int(self.min), int(self.sec))
        dt2 = datetime.datetime(int(other.year), int(other.month), 
                                int(other.day), int(other.hour), 
                                int(other.min), int(other.sec))
        dd = dt - dt2
        return (dd.seconds + dd.days * 86400) / 86400

    def __add__(self, seconds):
        '''add seconds to day and return the adjusted day'''
        dt = datetime.datetime(int(self.year), int(self.month), 
                               int(self.day), int(self.hour), 
                               int(self.min), int(self.sec))
        dt += datetime.timedelta(0, seconds)
        # convert to Dateclass
        self.year = str(dt.year)
        self.month = str(dt.month)
        self.day = str(dt.day)
        self.hour = str(dt.hour)
        self.min = str(dt.minute)
        self.sec = str(dt.second)
        return self

class SysdateClass(Dateclass):
    '''SysdateClass from Dateclass'''
    def __init__(self):
        Dateclass.__init__(self)
        timetmp = time.localtime(time.time())
        self.year = str(timetmp.tm_year)
        self.month = str(timetmp.tm_mon)
        self.day = str(timetmp.tm_mday)
        self.hour = str(timetmp.tm_hour)
        self.min = str(timetmp.tm_min)
        self.sec = str(timetmp.tm_sec)
    
sysdate = SysdateClass()
systimestamp = Dateclass().current()
   
def to_date(tdw, date_string, uformat):
    '''TO_DATE changed from Oracle'''
    if (date_string == None or date_string == "" 
        or uformat == None or uformat == ""):
        print "Empty date string or format string"
        return None

    dc = Dateclass()
    #0:24 hours, 1:12 hours
    #delete '24' or '12'
    flag12 = 0
    uformat = uformat.lower()
    if uformat.find('hh') != -1:
        pos = uformat.find('24')
        if pos == -1:
            #12hours
            flag12 = 1
            pos1 = uformat.find('12')
            if pos1 != -1:
                uformat = uformat[:pos1] + uformat[pos1+2:]
        else:
            #24hours
            uformat = uformat[:pos] + uformat[pos+2:]
             
    #delete all spaces, ':', '-', '/'
    date_string = ''.join(date_string.split())
    date_string = ''.join(date_string.split(':'))
    date_string = ''.join(date_string.split('-'))
    date_string = ''.join(date_string.split('/'))
    uformat = ''.join(uformat.split())
    uformat = ''.join(uformat.split(':'))
    uformat = ''.join(uformat.split('-'))
    uformat = ''.join(uformat.split('/'))
    
    if len(date_string) > len(uformat):
        print 'date string not match uformat'
        return None
    
    #delete the duplicate,i instead of mi
    position = []
    for i in range(0, len(uformat)):
        if uformat[i] not in position:
            position.append(uformat[i])
    
    #parse the date
    i = 0            
    while i < len(date_string):
        type = position[0]
        position = position[1:]
        if type == 'y':
            if i+4 > len(date_string):
                print 'date string not match format'
                return None
            
            dc.year = date_string[i:i+4]
            i += 4
        else: 
            if i+2 > len(date_string):
                print 'date string not match format'
                return None
            if type == 'm':
                dc.month = date_string[i:i+2]
            elif type == 'd':
                dc.day = date_string[i:i+2]
            elif type == 'h':
                dc.hour = date_string[i:i+2]
            elif type == 'i': 
                dc.min = date_string[i:i+2]
            elif type == 's':
                dc.sec = date_string[i:i+2]
            else:
                print "Can't recognize type:" + type
                return None
                
            i += 2                
    
    #check for value
    if int(dc.month) > 0 and int(dc.month) <= 12:
        pass
    else:
        print 'wrong month value'
        return None
    
    right_day = 0
    if int(dc.month) in [1, 3, 5, 7, 8, 10, 12]:
        if int(dc.day) >0 and int(dc.day) <=31:
            right_day = 1    
    elif int(dc.month) in [4, 6, 9, 11]:
        if int(dc.day) >0 and int(dc.day) <=30:
            right_day = 1
    else:#leap year
        if int(dc.year) %4 == 0 and int(dc.year) % 100 != 0 :
            if int(dc.day) >0 and int(dc.day) <=29:
                right_day = 1
        elif int(dc.year) %400 == 0:
            if int(dc.day) >0 and int(dc.day) <=29:
                right_day = 1
        else:
            if int(dc.day) >0 and int(dc.day) <=29:
                right_day = 1
    
    if right_day == 0:       
        print 'wrong day value'
        return None 
    
    if flag12 == 1 and int(dc.hour) > 12:
        print 'wrong hour value'
        return None
    elif flag12 ==  0 and int(dc.hour) > 24:
        print 'wrong hour value'
        return None
    else:
        pass 
    
    if int(dc.min) >= 0 and int(dc.min) < 60:
        pass
    else:
        print 'wrong minute value'
        return None 
    
    if int(dc.sec) >= 0 and int(dc.sec) < 60:
        pass
    else:
        print 'wrong minute value'
        return None               
    return dc
        
def to_char_date(tdw, value, *uformat):
    '''Internal function TO_CHAR_DATE chagned from Oracle'''
    # date to char
    if value.__class__.__name__ == 'Dateclass':
        if len(uformat) == 0:
            uformat = 'yyyy-mm-dd'
        else:
            uformat = uformat[0].lower()
            
        result = ''
        i = 0
        try:
            while i < len(uformat):
                if uformat[i] == 'y':
                    year_cnt = uformat.count('y')
                    for tmp in uformat[i:i + year_cnt]:
                        if tmp != 'y':
                            print "Can't recognize type:" +  uformat[i:i+year_cnt+1]
                            return None
                    result += str(value.year[-1 - year_cnt -1:])
            
                    i += year_cnt
                elif uformat[i] == 'm':
                    if uformat[i+1] == 'm':
                        result += str(value.month)
                    elif uformat[i+1] == 'i':
                        result += str(value.min)
                    else:
                        print "Can't recognize type:" +  uformat[i:i+2]
                        return None
                    
                    i = i + 2
                elif uformat[i] == 'd':
                    if uformat[i+1] == 'd':
                        result += str(value.day)
                    else:
                        print "Can't recognize type:" +  uformat[i:i+2]
                        return None
                    
                    i = i + 2
                elif uformat[i] == 'h':
                    if uformat[i+1] == 'h':
                        if uformat[i+2:i+4] == '12':
                            _hour_ = int(value.hour)
                            if _hour_ > 12:
                                _hour_ = _hour_ - 12
                            result += str(_hour_)
                            i = i + 2
                        elif uformat[i+2:i+4] == '24':
                            i = i + 2
                            result += str(value.hour)
                        else:
                            result += str(value.hour)
                    else:
                        print "Can't recognize type:" +  uformat[i:i+2]
                        return None
                
                    i = i + 2
                elif uformat[i] ==  's':
                    if uformat[i+1] == 's':
                        result += str(value.sec)
                    else:
                        print "Can't recognize type:" +  uformat[i:i+2]
                        return None
                
                    i = i + 2
                elif uformat[i] == 'f':
                    if uformat[i+1] == 'f':
                        _tmp = "%.2f" % (value.subsec)
                        _tmp = _tmp[_tmp.index('.') + 1:]
                        result += str(_tmp)
                    i = i + 2
                else:
                    result += uformat[i]
                    i = i+1
        except IndexError, ie:
            print "Invalid format string."
            return None

        return result
    else:
        if value == None:
            print "NoneType date?"
            return None

        if value.isdigit():
            return str(value)
        else:
            print "Need Dateclass or digit"
            return None   
        
#
def last_day(tdw, dc):
    '''LAST_DAY changed from Oracle.
    examples:
    >>> dc = Dateclass(2003, 3, 15)
    >>> last_day(dc)
    '2003/03/31'
    >>> dc = Dateclass(2003, 2, 3)
    >>> last_day(dc)
    '2003/02/28'
    >>> dc = Dateclass(2004, 2, 3)
    >>> last_day(dc)
    '2004/02/29'
    '''
    if not isinstance(dc, Dateclass):
        print "Unsupport type, we only support class Dateclass type!"
        return None
    tc = calendar.TextCalendar()
    l = tc.formatmonth(int(dc.year), 
                       int(dc.month)).replace('\n', ' ').rstrip().split(' ')
    return (str(dc.year) + "/" + ("%02d" % int(dc.month)) + "/" + 
            ("%02d" % int(l[-1])))

def next_day(tdw, dateclass, wd):
    '''NEXT_DAY changed from Oracle
    examples:
    >>> dc = Dateclass(2003, 8, 6)
    >>> to_char_date(next_day(dc, 'Wednesday'), 'YYYY:MM:DD')
    '2003:8:13'
    >>> to_char_date(next_day(dc, 'Sunday'), 'YYYY:MM:DD')
    '2003:8:10'
    >>> to_char_date(next_day(dc, 'Shitday'), 'YYYY:MM:DD')
    Invalid weekday string. Weekday string we support is:
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    NoneType date?
    '''
    if wd.lower() == "monday":
        wd = 0
    elif wd.lower() == "tuesday":
        wd = 1
    elif wd.lower() == "wednesday":
        wd = 2
    elif wd.lower() == "thursday":
        wd = 3
    elif wd.lower() == "friday":
        wd = 4
    elif wd.lower() == "saturday":
        wd = 5
    elif wd.lower() == "sunday":
        wd = 6
    else:
        print "Invalid weekday string. Weekday string we support is:"
        print "SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY"
        return None

    if not isinstance(dateclass, Dateclass):
        print "Unsupport type, we only support class Dateclass type!"
        return None

    c = calendar.Calendar()
    l = list(c.itermonthdays2(int(dateclass.year), int(dateclass.month)))
    next = 0
    for i in range(0, len(l)):
        if int(l[i][0]) == 0:
            continue
        if int(l[i][0]) == int(dateclass.day):
            next = 1
            wd -= int(l[i][1])
            if wd <= 0:
                wd += 7
        if next == 1 and wd > 0:
            wd -= 1
            continue
        if next == 1 and wd == 0:
            return Dateclass(dateclass.year, dateclass.month, int(l[i][0]))
    # next month or next year?
    year = 0
    month = 0
    if int(dateclass.month) + 1 > 12:
        year = int(dateclass.year) + 1
        month = int(1)
    else:
        year = int(dateclass.year)
        month = int(dateclass.month) + 1
    l = list(c.itermonthdays2(year, month))
    for i in range(0, len(l)):
        if int(l[i][0]) == 0:
            continue
        if next == 1 and wd > 0:
            wd -= 1
            continue
        if next == 1 and wd == 0:
            return Dateclass(year, month, int(l[i][0]))

    return None

def add_months(tdw, dc, n):
    '''ADD_MONTHS changed from Oracle
    examples:
    >>> dc = Dateclass(2003, 8, 31)
    >>> to_char_date(dc, 'yyyy:mm:dd')
    '2003:8:31'
    >>> to_char_date(add_months(dc, 3), 'yyyy:mm:dd')
    '2003:11:30'
    >>> to_char_date(add_months(dc, 3), 'yyyy:mm:dd')
    '2004:2:29'
    >>> to_char_date(add_months(dc, 3), 'yyyy:mm:dd')
    '2004:5:29'
    >>> to_char_date(add_months(dc, 3), 'yyyy:mm:dd')
    '2004:8:29'
    >>> to_char_date(add_months(dc, 3), 'yyyy:mm:dd')
    '2004:11:29'
    >>> to_char_date(add_months(dc, 3), 'yyyy:mm:dd')
    '2005:2:28'
    '''
    if not isinstance(dc, Dateclass):
        print "Unsupported type, we only support Dateclass type!"
        return None
    new_month = int(dc.month) + int(n)
    if new_month <= 0:
        dc.year = str(int(dc.year) - 1)
        dc.month = str(12 + new_month)
    elif new_month > 12:
        dc.month = str(new_month - 12)
        dc.year = str(int(dc.year) + 1)
    else:
        dc.month = str(new_month)
    if int(dc.month) in [4, 6, 9, 11]:
        if int(dc.day) == 31:
            dc.day = "30"
    elif int(dc.month) == 2:
        if int(dc.day) > 29:
            dc.day = "29"
        if int(dc.year) % 100 == 0 or int(dc.year) % 4 != 0:
            if int(dc.year) % 400 != 0:
                if int(dc.day) == 29:
                    dc.day = "28"
    return dc

def months_between(tdw, date1, date2):
    '''Return the months' gap between date1 and date2 as (date1 - date2)'''
    if not isinstance(date1, Dateclass) or not isinstance(date2, Dateclass):
        print "Unsupported type, we only support Dateclass type!"
        return None

    year_gap = int(date1.year) - int(date2.year)
    month_gap = int(date2.month) - int(date1.month)
    day_gap = int(date2.day) - int(date1.day)

    return float(year_gap * 12 - month_gap) - float(day_gap) / 31

def trunc_date(tdw, uinput, argv1):
    '''Internal DATE TRUNC function, chagned from Oracle TRUNC DATE
    >>> to_char_date(trunc_date(to_date("1998-10-12", 'yyyy-mm-dd'), 'year'), 'yyyy:mm:dd')
    '1998:01:01'
    >>> to_char_date(trunc_date(to_date("1998-10-12", 'yyyy-mm-dd'), 'Q'), 'yyyy:mm:dd')
    '1998:10:01'
    >>> to_char_date(trunc_date(to_date("1998-10-12", 'yyyy-mm-dd'), 'mm'), 'yyyy:mm:dd')
    '1998:10:01'
    '''
    if not isinstance(uinput, Dateclass):
        print "The first argument is not a Dateclass instance."
        return None

    if argv1 == None or argv1 == "":
        return uinput

    dc = Dateclass(uinput.year)
    if argv1.lower() == 'year' or argv1.lower() == 'yyyy':
        dc.year = uinput.year
        dc.month = '01'
        return dc
    if argv1.lower() == 'q':
        dc.year = uinput.year
        dc.month = str(int(uinput.month) - int(uinput.month) % 3 + 1)
        return dc
    if (argv1.lower() == 'month' or argv1.lower() == 'mon' 
        or argv1.lower() == 'mm'):
        dc.year = uinput.year
        dc.month = uinput.month
        return dc
    print "We only support the following format string:"
    print " year/yyyy/q/month/mon/mm"
    print "Other format string will be supported later:)"
    return None

class DBMS_OUTPUT:
    '''Simulate the dbms_output function in Oracle'''
    _enable = True
    def __init__(self):
        pass
    def put_line(self, tdw, str_to_print):
        '''Write a string to the console'''
        if self._enable:
            print str_to_print
    def disable(self):
        '''Disable the output'''
        self._enable = False
    def enable(self):
        '''Enable the output'''
        self._enable = True

# The following region defines the Oracle runtime variables/packages.
# However, they are just a MACRO :)

dbms_output = DBMS_OUTPUT()

def rollback():
    '''Do rollback'''
    return

def commit():
    '''Do commit'''
    return

class DBMS_LOCK:
    '''Simulate the dbms_lock function in Oracle'''
    def __init__(self):
        pass
    def sleep(self, tdw, seconds):
        time.sleep(seconds)

dbms_lock = DBMS_LOCK()

class DBMS_SESSION:
    free_unused_user_memory = None
    '''Simulate the dbms_session function in Oracle'''
    def __init__(self):
        pass
    def set_nls(self, tdw, _type, _format):
        pass
    
dbms_session = DBMS_SESSION()

class DBMS_STATS:
    '''Simulate the dbms_stats function in Oracle'''
    def __init__(self):
        pass
    def gather_table_stats(self, tdw, ownname, tabname, partname = None, 
                           estimate_percent = None, block_sample = False,
                           method_opt = None, degree = None, 
                           granularity = None, cascade = None,
                           stattab = None, statid = None, statown = None,
                           no_invalidate = None, force = None):
        pass

dbms_stats = DBMS_STATS()

class DBMS_APPLICATION_INFO:
    '''Simulate the dbms_application_info package in Oracle'''
    def __init__(self):
        pass
    def set_client_info(self, tdw, string):
        pass

dbms_application_info = DBMS_APPLICATION_INFO()

sqlcode = '''TDW/PL do NOT support SQLCODE at this moment.'''
sqlerrm = '''TDW/PL do NOT support SQLERRM at this moment.'''

# shadow TDW object
tdw = None
