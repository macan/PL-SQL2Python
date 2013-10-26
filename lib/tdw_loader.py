#!/usr/bin/env python
''' Copyright (c) 2010 Ma Can <ml.macana@gmail.com>

This is the Server-Side job loader.
'''
import sys, os
import getopt

sys.path.append("./lib/py/")

from hive_service import ThriftHive
from hive_service.ttypes import HiveServerException
from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

import tdw

def tdw_file_checking(fname):
    '''Do file checking'''
    f = open(fname, "r")
    for line in f.readlines():
        # Ignore the import instruction now
        # if 'import' in line:
        #     raise IOError(-1, "'import' is NOT allowed in the TDW/PL code.")
        if 'os.kill' in line:
            raise IOError(-1, "'os.kill' is NOT allowed in the TDW/PL code.")
        if 'os.rmdir' in line:
            raise IOError(-1, "'os.rmdir' is NOT allowed in the TDW/PL code.")
    f.close()

def main(argv):
    '''Main loader'''
    try:
        opts, args = getopt.getopt(argv, 
                                   "d:f:s:a:u:p:x:j:t:", 
                                   ["file=", "session=", "authid=", "user=", 
                                    "passwd=", "path=", "jobid=", "dbname=", 
                                    "port="])
    except getopt.GetoptError:
        sys.exit()
    fname = None
    sid = None
    svid = None
    path = None
    jobid = None
    dbname = None
    port = None
    for opt, arg in opts:
        if opt in ("-f", "--file"):
            fname = arg
        elif opt in ("-s", "--session"):
            sid = arg
        elif opt in ("-a", "--authid"):
            svid = arg
        elif opt in ("-u", "--user"):
            user = arg
        elif opt in ("-p", "--passwd"):
            passwd = arg
        elif opt in ("-x", "--path"):
            path = arg
        elif opt in ("-j", "--jobid"):
            jobid = arg
        elif opt in ("-d", "--dbname"):
            dbname = arg
        elif opt in ("-t", "--port"):
            port = arg

    # Check the file
    try:
        print "Checking TDW/PL code from file '%s'" % (path + fname)
        tdw_file_checking(path + fname + ".py")
    except IOError, ie:
        print "PL checking error(%d) %s" % (ie.errno, ie.strerror)
        return

    # ok, we will just create another connection and attache to the created
    # session
    sys.path.append("./pl/lib/" + user)
    sys.path.append("./pl/lib/")
    sys.path.append("./pl/lib/global")
    print "Module : %s, sid : %s, dbname %s" % (fname, sid, dbname)
    module = __import__(fname)
    string = "ok"

    try:
        transport = TSocket.TSocket('localhost', port)
        transport = TTransport.TBufferedTransport(transport)
        protocol = TBinaryProtocol.TBinaryProtocol(transport)
        
        client = ThriftHive.Client(protocol)
        transport.open()
        
        res = client.audit(user, passwd, dbname)
        if str(res) == "":
            string = "failed"
        print "Audit: " + string
        if str(res) == "":
            sys.exit()

        res = client.requireSession(sid, svid)
        if str(res) == "":
            string = "failed"
        print "Require Session: " + sid + " " + string
        if str(res) == "":
            sys.exit()

        print "Session " + sid + " " + jobid
        res = client.setHistory(sid, int(jobid))

        module.TDW_PL(tdw.TDW(client))

        # detach the session and exit
        client.detachSession(sid, svid)
        if str(res) == "":
            string = "failed"
        print "Detach Session: " + sid + " " + string
        if str(res) == "":
            sys.exit()

        transport.close()
    except Thrift.TException, tx:
        print '%s' % (tx.message)

if __name__ == '__main__':
    main(sys.argv[1:])
