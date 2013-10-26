#!/usr/bin/env python
""" Copyright (c) 2010 Ma Can <ml.macana@gmail.com>

This is the core TDW runtime library, enjoy it :)
"""

import sys, re

from hive_service import ThriftHive
from hive_service.ttypes import HiveServerException
from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

from array import *

def to_type(line, t):
    '''Type conversion'''
    if t == 'int':
        return int(line)
    elif t == 'bigint':
        return long(line)
    elif t == 'array<int>':
        line = line.strip(" ")
        line = line.strip("[")
        line = line.rstrip(" ")
        line = line.rstrip("]")
        l = line.split(",")
        for i in range(0, len(l)):
            if l[i] == "":
                return array('i')
            else:
                l[i] = int(l[i])
        return array('i', l)
    elif t == 'string':
        return str(line)

class dynamic_type:
    '''Dynamic Type Support'''
    pass

class TDW:
    '''This is the runtime TDW class.'''
    running = True
    
    def __init__(self, client=None):
        '''do init job'''
        self.cli = client
        
    def do_exit(self):
        '''begin to exit'''
        self.running = False

    def execute(self, query):
        '''Execute a SQL query and return the result LIST[0:]'''
        if self.running:
            self.cli.execute(query)
            return self.cli.fetchAll()
        else:
            raise IOError (-2, "Interrupted by the caller.")

    def execute2int(self, query):
        '''Execute a SQL query and return a INT result'''
        try:
            if self.running:
                self.cli.execute(query)
            else:
                raise IOError (-2, "Interrupted by the caller.")
        except KeyboardInterrupt:
            print "Recv KeyboardInterrupt, please wait for this SQL execution"
            self.do_exit()
            self.cli.recv_execute()

        try:
            res = self.cli.fetchAll()
            return int(res[0])
        except TypeError, e :
            print "Result '%s' to INT failed %s" % (res[0], e.message)
            raise IOError (-3, "Result type transform to INT failed, "
                            "TypeError.")
        except ValueError :
            print "Result '%s' to INT failed, ValueError" % res[0]
            raise IOError (-3, "Result type transform to INT failed, "
                            "ValueError.")
        except KeyboardInterrupt:
            print "Recv KeyboardInterrupt, your client should be reset."
            self.do_exit()

    def execute2str(self, query):
        '''Execute a SQL query and return a STRING (LIST[0])'''
        try:
            if self.running:
                self.cli.execute(query)
            else:
                raise IOError (-2, "Interrupted by the caller.")
        except KeyboardInterrupt:
            print "Recv KeyboardInterrupt, please wait for this SQL execution"
            self.do_exit()
            self.cli.recv_execute()

        try:
            res = self.cli.fetchAll()
            return str(res[0])
        except TypeError, e:
            print "Result '%s' to STRING failed %s" % (res[0], e.message)
            raise IOError (-3, "Result type transform to STRING failed, "
                            "TypeError.")
        except ValueError :
            print "Result '%s' to STRING failed" % res[0]
            raise IOError (-3, "Result type transform to STRING failed, "
                            "ValueError.")
        except KeyboardInterrupt:
            print "Recv KeyboardInterrupt, your client should be reset."
            self.do_exit()

    def printf(self, string, res):
        '''Print the result in a formated manner'''
        try:
            if (type(res) == type(str())):
                print string + " " + res
            elif (type(res) == type(list())):
                print "Q: '" + string + "' |=> '" + " ".join(res) + "'"
            elif (type(res) == type(int())):
                print string + " " + str(res)
            elif (type(res) == type(None)):
                print "Argument is Not A Type."
        except ValueError :
            print "printf convert STRING failed"
            raise IOError (-3, "printf convert STRING failed, ValueError.")

    def result_str(self, res):
        '''Convert a SQL result to a STRING'''
        try:
            __res = str(res)
        except:
            return None
        return __res

    def result_list(self, res):
        '''Convert a SQL result to a LIST'''
        try:
            __res = list(res)
        except:
            return None
        return __res

    def result_int(self, res):
        '''Convert a SQL result to a INT'''
        try:
            __res = int(res)
        except:
            return None
        return __res

    def uploadJob(self, fname):
        '''Upload a job file to server'''
        print "Tring to upload Job '%s' ..." % (fname)
        read_data = ""
        try:
            f = open(fname, "r")
            read_data = f.read()
            f.close()
        except IOError, ie:
            print "IOError %s" % ie
            return

        if read_data == "":
            print "[WARN] Read file '" + fname + "' w/ ZERO content."
        # ok to upload the file to hiveserver
        self.cli.uploadJob(read_data)

    def getschema(self):
        '''Get the Hive Schema from the server'''
        try:
            if self.running:
                return str(self.cli.getSchema())
            else:
                raise IOError (-2, "Interrupted by the caller.")
        except KeyboardInterrupt:
            print "Recv KeyboardInterrupt, please wait for get schema"
            self.do_exit()
            self.cli.recv_getSchema()

    def getschemax(self):
        '''Get the SQL schema info the the Hive Scheme'''
        try:
            if self.running:
                schema_string = str(self.cli.getSchema())
            else:
                raise IOError (-2, "Interrupted by the caller.")
        except KeyboardInterrupt:
            print "Recv KeyboardInterrupt, please wait for get schema"
            self.do_exit()
            self.cli.recv_getSchema()
            return

        # Parse the schema_string
        m = re.findall("name='[^']*", schema_string)
        for i in range(0, len(m)):
            m[i] = m[i].replace("name='", "")
        return m

    def gettypex(self):
        '''Get the SQL type info from the Hive Schema'''
        try:
            if self.running:
                schema_string = str(self.cli.getSchema())
            else:
                raise IOError (-2, "Interrupted by the caller.")
        except KeyboardInterrupt:
            print "Recv KeyboardInterrupt, please wait for get schema"
            self.do_exit()
            self.cli.recv_getSchema()
            return

        # Parse the schema_string
        m = re.findall("type='[^']*", schema_string)
        for i in range(0, len(m)):
            m[i] = m[i].replace("type='", "")
        return m

    def parseschema(self, dict, sql_result):
        '''Parse the SQL result list to a list of lists based on the 'type'
        and 'schema' info in DICT'''
        if sql_result == "" or sql_result == None:
            return list()
        if type(sql_result) != type(list()):
            return list()

        result_list = list()
        column_list = dict['schema']
        type_list = dict['type']
        for i in range(0, len(sql_result)):
            if sql_result[i] == "":
                continue
            new_object = dynamic_type()
            sql_line = sql_result[i].split("\t")
            for j in range(0, len(column_list)):
                setattr(new_object, column_list[j], to_type(sql_line[j], 
                                                            type_list[j]))
            result_list.append(new_object)

        return result_list
        
    def tdw_getrowcount(self):
        '''Get the rowcount from server. The same as %rowcount'''
        try:
            if self.running:
                rc = self.cli.getrowcount()
            else:
                raise IOError (-2, "Interrupt by the caller.")
        except TypeError, e:
            print "TypeError %s" % e
            raise IOError (-2, "%s" % e)
        except KeyboardInterrupt, e:
            print "Recv KeyboardInterrupt, your client should be reset."
            self.do_exit()
            raise IOError (-2, "%s" % e)

        return long(rc)

    def tdw_raise(self, errno=None, strerror=None):
        '''Raise a TDW/PL exception (IOError actually)'''
        if type(errno) != type(int()):
            errno = -1
        if type(strerror) != type(str()):
            strerror = "TDW/PL default exception."
        raise IOError(errno, strerror)
