HOME = $(shell pwd)

CP = $(HOME)/lib/antlr-3.2.jar:$(HOME)/lib/antlr-runtime-3.2.jar:$(HOME)/lib/antlrworks-1.4.jar

all : 
	CLASSPATH=$(CP) javac -d build output/*.java
	CLASSPATH=$(CP) javac -d build ANTLRNoCaseFileStream.java
	cd build; jar cvf plsql.jar org/plsql/*.class
	CLASSPATH=$(CP):build/plsql.jar javac -d build pl2py.java
	#cd build; echo "Main-Class: org.pl2py.pl2py" > manifest.txt
	#cd build; jar cvfm pl2py.jar manifest.txt org/ABC/*.class
	cd build; jar cvf pl2py.jar org/pl2py/*.class plsql.jar

run :
	cd build; CLASSPATH=$(CP):plsql.jar:pl2py.jar java org.pl2py.pl2py ../input

clean : 
	rm -rf build/*
