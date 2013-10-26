/**
 * Copyright (c) 2010,2011 Ma Can <ml.macana@gmail.com>
 */

package org.pl2py;

import java.io.File;

import org.antlr.runtime.*;
import org.plsql.*;

public class pl2py {
	
    public static void main(String[] args) throws Exception {
    	if (args.length < 1) {
    		System.out.println("Usage: pl2py path/to/file");
    		System.exit(0);
    	}
    	String dir_name = args[0];
    	File myDir = new File(dir_name);
    	File[] contents = myDir.listFiles();
    	int sql_rowcount = 0;
    	int todo_count = 0;
    	int row_count = 0;
    	   	
    	for(int i = 0; i < contents.length; i++) {
		    // Create an input character stream from standard in
		    ANTLRNoCaseFileStream input = new ANTLRNoCaseFileStream(dir_name + '/' + contents[i].getName());
		    	
		    // Create an ExprLexer that feeds from that stream
		    PLSQLLexer lexer = new PLSQLLexer(input);
		        
		    // Create a stream of tokens fed by the lexer
		    CommonTokenStream tokens = new CommonTokenStream(lexer);
		    
		    // Create a parser that feeds off the token stream
		    System.out.print("Transform " + contents[i].getName() + " ...\n");
		    File Dir = new File(dir_name + "/../result/" + contents[i].getName().split("[.]")[0]);
		    if(!Dir.exists())
		    	Dir.mkdirs();
		    System.out.println(dir_name + "/../result/" + contents[i].getName().split("[.]")[0] + "/");
		    PLSQLParser parser = new PLSQLParser(tokens, dir_name + "/../result/" + contents[i].getName().split("[.]")[0] + "/", contents[i].getName().replace("sql", "py"));
		    parser.sqlplus_file();	
		    
		    //System.out.print("row_count: " + lexer.row_count + '\n');
		    //System.out.print("todo_count: " + parser.todo_count + '\n');
		    //System.out.print("sql_rowcount: " + parser.sql_count + '\n');
		    row_count += lexer.row_count;
		    todo_count += parser.todo_count;
		    sql_rowcount += parser.sql_count;
    	}
	    System.out.print("Done" + '\n');
	    System.out.print("sql_rowcount:" + sql_rowcount + '\n');
	    System.out.print("todo_count:" + todo_count + '\n');
	    System.out.print("row_count:" + row_count + '\n');
	    double tis = (1.0 - Double.parseDouble(Integer.toString(todo_count)) / (row_count - sql_rowcount)) * 100;
	    double tes = (Double.parseDouble(Integer.toString(sql_rowcount)) / (row_count)) * 100; 
	    System.out.println("All the SQL should be revised:");
	    System.out.println("\t1. Static SQL should be fixed for converting the variables in VALUES, WHERE.");
	    System.out.println("\t2. Reference to DATE should be fixed.");
	    System.out.print("SQL should be revised is " + 
	    		tes + "%\n");
	    System.out.print("Transform Ratio (-SQL) is " + 
	    		tis + "%\n");   	
    }
}



