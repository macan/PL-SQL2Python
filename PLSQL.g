/*
Oracle PL/SQL grammar built with ANTLR v3.2 and v3.1.3. I only vouch that it works for v3.2, though.

Author: Patrick Higgins
License: GNU Lesser General Public License, version 2.1 or (at your option) any later version.

I have used a swallow_to_semi trick to avoid parsing SQL statements and other statements that were not of value to me.
The idea was that a separate parser for SQL would be created (I believe this is what Oracle itself does).

Nearly all of the PL/SQL language from 11g is in this grammar, though. It works on all files in a fairly large code
base.

This has some limited support for parsing SQL*Plus files, which turns out to be pretty hard to work into ANTLR.

It works for my usage, but I think doing it properly would mean writing a Java class to parse the SQL*Plus language
(which is pretty simple and shouldn't need ANTLR) and another adapter for ANTLR which enables tracking back to the
original source line numbers. This PL/SQL parser might be invoked many times for each SQL*Plus file.
*/

/**
 * Copyright (c) 2010,2011 Ma Can <ml.macana@gmail.com>
 *
 * We modified this gramma file to transform Oracle PL/SQL scripts to Python for TDW project. The target code
 * can ONLY run in a HIVE-like runtime environment.
 */

grammar PLSQL;

@header {
package org.plsql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
}

@members {

Map<String, Integer> map = new HashMap<String, Integer>();

public void emitFunctionName(String fname, int lnr)
{
    	Integer i;
    	int cnt;
    	i = map.get(fname);
    	if (i == null)
    		cnt = 1;
    	else {
    		cnt = i.intValue() + 1;
    	}
	map.put(fname, cnt);
	//System.out.print(getSourceName() + ":" + lnr + ":" + fname + '\n');
}
Map<String, String> support_set = new HashMap<String, String>();
Map<String, String> changed_set = new HashMap<String, String>();
Map<String, String> unsupport_set = new HashMap<String, String>();
public void functionAPIChange()
{
	// API Supported
	support_set.put("length", "support");
	support_set.put("substr", "support");
	support_set.put("upper", "support");
	support_set.put("lower", "support");
	support_set.put("instr", "support");
	support_set.put("replace", "support");
	support_set.put("nvl", "support");
	support_set.put("nvl2", "support");
	support_set.put("mod", "support");
	support_set.put("abs", "support");
	support_set.put("floor", "support");
	support_set.put("ln", "support");
	support_set.put("acos", "support");
	support_set.put("sin", "support");
	support_set.put("sinh", "support");
	support_set.put("cos", "support");
	support_set.put("cosh", "support");
	support_set.put("tan", "support");
	support_set.put("tanh", "support");

	// API Changed
	changed_set.put("to_number", "changed");
	changed_set.put("ltrim", "changed");
	changed_set.put("rtrim", "changed");
	changed_set.put("trim", "changed");
	changed_set.put("to_date", "changed");
	changed_set.put("to_char", "changed");
	changed_set.put("tz_offset", "changed");
	changed_set.put("last_day", "changed");
	changed_set.put("next_day", "changed");
	changed_set.put("add_months", "changed");
	changed_set.put("months_between", "changed");
	changed_set.put("mod", "changed");
	changed_set.put("round", "changed");
	changed_set.put("power", "changed");
	changed_set.put("trunc", "changed");

	// API Unsupported

}

public String getErrorHeader(RecognitionException e) {
    return getSourceName()+":"+e.line+":"+(e.charPositionInLine+1)+":";
}

public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    List stack = getRuleInvocationStack(e, this.getClass().getName());
    String msg = null;
    if (e instanceof NoViableAltException) {
        NoViableAltException nvae = (NoViableAltException) e;
        msg = " no viable alt; token="+e.token+
              " (decision="+nvae.decisionNumber+
              " state "+nvae.stateNumber+")"+
              " decision=<<"+nvae.grammarDecisionDescription+">>";
    }
    else {
        msg = super.getErrorMessage(e, tokenNames);
    }
    return stack+" "+msg;
}
    
public String getTokenErrorDisplay(Token t) {
    return t.toString();
}

public File outf = null;//the main python file
public FileOutputStream fops = null;
public File poutf = null;//package output, every package generate a python file
public FileOutputStream pfops = null;
public String output = "";
public String[] parameter_list = new String[20];
public int parameter_list_count = -1;
public String[] initial_statement = new String[20];
public int initial_statement_count = -1;
public String exp = "";
public int indent_count = 0;
public String stat = "";
public String __par = "";
public String __sql = "";
public int sql_count = 0;
public int todo_count = 0;
public int create_package = 0;
public String path = "";//the output file path
public String filename = "";
public String[] import_package = new String[50];//import packages for package body
public int import_package_count = -1;
public String[] global_import_package = new String[50];//import packages for the whole files
public int global_import_package_count = -1;
public int global = 1;//1:global file 0:package file

public int has_record_type = 0;//composite struct:record, varray, table
public String[] record_define = new String[50];
public int record_define_cnt = -1;
public String[] record_declare = new String[50];
public int record_declare_cnt = -1;

public int has_collection_type = 0;//composite struct:record, varray, table
public String[] collection_type_define = new String[50];
public int collection_type_define_cnt = -1;
public String[] collection_type_declare = new String[50];
public int collection_type_declare_cnt = -1;
public int collection_var_cnt = -1;
public String[] collection_variables = new String[200];

public String into_exp = "";
public int has_into_exp = 0;

public String last_id = "";

public String[] variables_list = new String[150];
public int variables_list_cnt = -1;
public int replace_length = 0;

public String[][] pkg_list = new String[200][2];
public int pkg_list_cnt = -1;
String pkg_current = "";

public PLSQLParser(TokenStream input, String NewPath, String NewFileName) throws IOException {
	this(input, new RecognizerSharedState());
	outf = new File(NewPath + "/anonymous_" + NewFileName);
	
	path = NewPath;
	filename = outf.getName();
	
	if(!outf.exists()){
    		outf.createNewFile();
    	}
    	
    	try {
		fops = new FileOutputStream(outf);
	} catch (FileNotFoundException e) {
		System.out.print("File not Found");
		e.printStackTrace();
	}
}

}

@lexer::header {
package org.plsql;
}

@lexer::members {

public String getErrorHeader(RecognitionException e) {
    return getSourceName()+":"+e.line+":"+(e.charPositionInLine+1)+":";
}

// needed for things like BETWEEN 1..2 where 1. would be treated as a literal
private boolean numberDotValid() {
    int i = 1;
    while (input.LA(i) >= '0' && input.LA(i) <= '9') {
        i++;
    }
    return input.LA(i) == '.' && input.LA(i+1) != '.';
}

public int row_count = 0;
}


sqlplus_file
@after{
	functionAPIChange();
	// emit all the function calls now
	Set set = map.entrySet();
	int total_function = 0, support_function = 0, changed_function = 0, unsupport_function = 0, other = 0, total_calls = 0;
	
	Iterator it = set.iterator();
	while (it.hasNext()) {
		Map.Entry me = (Map.Entry)it.next();
		System.out.println(me.getKey() + ":" + me.getValue());
		total_calls += ((Integer)me.getValue()).intValue();
		total_function++;
		if (support_set.containsKey(me.getKey()))
			support_function++;
		else if (changed_set.containsKey(me.getKey()))
			changed_function++;
		else if (unsupport_set.containsKey(me.getKey()))
			unsupport_function++;
		else 
			other++;
	}
	System.out.println("Total     Functions: " + total_function);
	System.out.println("Support   Functions: " + support_function);
	System.out.println("Change    Functions: " + changed_function);
	System.out.println("Unsupport Functions: " + unsupport_function);
	System.out.println("Other     Functions: " + other);
	double ratio = Double.parseDouble(Integer.toString(changed_function + unsupport_function + other)) / total_function * 100;
	System.out.println("Ratio of functions need to revise: " + (ratio) + "\%");
	// reinit the dicts
	has_record_type = 0;
	record_declare_cnt = -1;
	record_define_cnt = -1;
	has_collection_type = 0;
	collection_type_define_cnt = -1;
	collection_type_declare_cnt = -1;
	collection_var_cnt = -1;
	// other operations
	fops.close();
	FileInputStream ipfs = new FileInputStream(outf);
	
	String FileName = "tmp.py";
	File writefile = new File(path + FileName);
	if(!writefile.exists()){
		writefile.createNewFile();
    	}
	FileOutputStream opfs = new FileOutputStream(writefile);
	
	byte[] b = new byte[1024];
		
	int x = 0;
	
	ipfs.read(b, 0, 13);
	opfs.write(b, 0, 13);
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();

	String outs = "'''---THIS FILE IS CREATED AUTOMATICALLY @ " + dateFormat.format(date) + "---'''\n\n";
	outs += "from tdw import HiveServerException\n";
	outs += "from tdw import dynamic_type\n";
	outs += "from tdw_sql_lib import *\n\n";
	outs += "import " + filename.substring(0, filename.indexOf(".")) + "\n\n";

	if(global_import_package_count != -1){
       		for(int i = 0; i<= global_import_package_count; i++){
       			outs += "import " + global_import_package[i].toLowerCase() + "\n";
       		}
	}
	outs += "\n";
	opfs.write(outs.getBytes());
			
	while((x = ipfs.read(b, 0, 1024)) != -1){
		opfs.write(b, 0, x);
	}
	ipfs.close();
	opfs.close();  
	
	outf.delete();
	writefile.renameTo(outf);
}
:   {
	String tmp = "# coding=gbk\n\n";
	fops.write(tmp.getBytes());
	}
	( create_object ( DIVIDE show_errors )? DIVIDE? )+ EOF {pkg_list_cnt = -1;}
    ;   
   catch[RecognitionException re] {reportError(re);recover(input,re);}
   catch[IOException e] {e.printStackTrace();}	
       
show_errors
    : kSHOW kERRORS SEMI?
    ;

create_object
    : create_package    { 
    	for (int i = 0; i <= pkg_list_cnt; i++) {
    		if (pkg_current.equalsIgnoreCase(pkg_list[i][0])) {
    			System.out.println("Package " + pkg_current + " is redefined!");
    		}
    	}
    	System.out.println("Add package " + pkg_current + " at index " + (pkg_list_cnt + 1));
    	pkg_list_cnt++;
    	pkg_list[pkg_list_cnt][0] = pkg_current;
    	pkg_list[pkg_list_cnt][1] = output;
    	output = "";
    }
    | create_package_body { output = "";}
    | create_function {fops.write(output.getBytes()); fops.write("\n\n".getBytes()); output = "";}       	
    | create_procedure {fops.write(output.getBytes()); fops.write("\n\n".getBytes()); output = "";}
    ;
   catch[RecognitionException re] {reportError(re);recover(input,re);}
   catch[IOException e] {e.printStackTrace();}	

procedure_heading :	
        PROCEDURE ID
        {
        String tmp = $ID.getText().toLowerCase();
        if(tmp.startsWith("\"")&&tmp.endsWith("\""))
        	tmp = tmp.substring(1, tmp.length() -1 );
        	
        output += "def " + tmp.toLowerCase() + "(tdw, ";}     
        parameter_declarations? {output += __par; __par = "";}
    	{output += ")";}
    	{output += ":\n";
    	if(initial_statement_count >= 0)
    	{
       		for(int i = 0; i <= initial_statement_count; i++)
       		{
       			output += '\t' + initial_statement[i] + "\n";
       		}
       		initial_statement_count = -1;
    	}        
    	}         
    ;
   
function_heading : 
        FUNCTION ID 
        {
        String tmp = $ID.getText().toLowerCase();
        if(tmp.startsWith("\"")&&tmp.endsWith("\""))
        	tmp = tmp.substring(1, tmp.length() -1 );
        	
        output += "def " + tmp.toLowerCase() + "(tdw, ";}
        parameter_declarations? {output += __par; __par = "";}
    	{output += ")";}
    	{output += ":\n";
    	if(initial_statement_count >= 0)
    	{
       		for(int i = 0; i <= initial_statement_count; i++)
       		{
       			output += '\t' + initial_statement[i] + "\n";
       		}
       		initial_statement_count = -1;
    	}        
    	}         
        RETURN datatype
    ;

parameter_declarations :
    ( LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN)
    {
    int has_defaults = 0;
    for(int i = 0; i <= parameter_list_count; i++)
    {
    	if (parameter_list[i].contains("= None"))
    		has_defaults = 1;
    }
    if (has_defaults == 1) {
	for(int i = 0; i <= parameter_list_count; i++)
    	{
    		if (!parameter_list[i].contains("= None"))
    			parameter_list[i] += " = None";
    	}
    }

    if(parameter_list_count >= 0)
    {
       	__par += parameter_list[0];
       	for(int i = 1; i <= parameter_list_count; i++)
       	{
       		__par += ", " + parameter_list[i];
       	}
       	parameter_list_count = -1;
    }    
    }
    ;
   
parameter_declaration 
@init{
String id_name = "";
int has_default = 0;
}
@after{
if (has_default == 0) {
	parameter_list_count++; 
	parameter_list[parameter_list_count] = id_name;
	variables_list_cnt++;
	variables_list[variables_list_cnt]  = id_name;
} else {
	parameter_list_count++; 
	parameter_list[parameter_list_count] = id_name + " = None"; 
	variables_list_cnt++;
	variables_list[variables_list_cnt]  = id_name;
}
}
:
        ID {id_name = $ID.getText().toLowerCase();} ( IN | ( ( OUT | IN OUT ) NOCOPY? ) )? 
        datatype ( ( ASSIGN {has_default = 1;} | DEFAULT {has_default = 1;} ) expression
        {
        	if (has_default == 0) {
        		initial_statement_count++; 
        		initial_statement[initial_statement_count] = $ID.getText().toLowerCase() + " = " + exp;
        		exp = "";
        	} else {
        		initial_statement_count++; 
        		initial_statement[initial_statement_count] = 
        			"if " + $ID.getText().toLowerCase() + " == None: " + $ID.getText().toLowerCase() + " = " + exp;
        		exp = "";
        	}
        }
        )?
    ;
   
declare_section 
@init{
String xout = output;
output = "";
}
@after{
output = xout;
}
:
    	( type_definition SEMI {xout += output; output = "";}
    	| subtype_definition 
    	{int start = input.LT(1).getTokenIndex();} 
    	SEMI
    	{int end = input.LT(-1).getTokenIndex();
        int pos = end + 1;
        while(input.get(pos).getChannel() != 0)
        	pos++;
        end = pos - 1;
        xout += input.toString(start, end).toLowerCase();}
    	| cursor_definition SEMI {xout += output; output = "";}
    	| item_declaration SEMI {xout += output; output = "";}
    	| function_declaration_or_definition SEMI {if (create_package == 0) xout += output; output = "";}
    	| procedure_declaration_or_definition SEMI {if (create_package == 0) xout += output; output = "";}
    	| pragma SEMI {xout += output; output = "";}
    	)+
    	;

cursor_definition 
@init {
	String tmp = "";
}
@after {
	output += tmp + '\n';
        stat = "";
}
:
	{
		String v_cursor = "";
    		output += "\t# FIXME: CURSOR DEFINITION\n";
	} 
        CURSOR ID {v_cursor = input.LT(-1).getText().toLowerCase();} {__par = "";} parameter_declarations ? {
        	if (__par == "") {
			todo_count++;
        	}
        	__par = "";
        } IS select_statement 
        {
        	tmp += "\t" + v_cursor + " = ({'isopen':0, 'sql':" + __sql + "})\n";
        	__sql = "";
        }         
    ;
   
item_declaration
@init{
String indent = "";
for (int i = 0; i < indent_count; i++)
	indent += "\t";
if (create_package == 1) {
	indent = "";
}
}
@after{
exp = "";
}
    : ( ID 
    {int start = input.LT(1).getTokenIndex();}
    datatype 
    {
    int emit = 1;
    int end = input.LT(-1).getTokenIndex();
    String datatype_string = input.toString(start, end).toLowerCase();
    if( has_record_type == 1 )
    {
    	for(int i = 0; i <= record_define_cnt; i++)
    	{
    		if( datatype_string.equalsIgnoreCase(record_define[i]))
    		{
    			output += indent + $ID.getText().toLowerCase() + " = " + record_define[i] + "()\n"; 
    			record_declare_cnt++;
    			record_declare[record_declare_cnt] = $ID.getText().toLowerCase();
    			emit = 0;
    			break;
    		}
    	}
    }

    if( has_collection_type == 1 )
    {
    	for(int i = 0; i <= collection_type_define_cnt; i++)
    	{
    		if( datatype_string.equalsIgnoreCase(collection_type_define[i]))
    		{
    			output += indent + $ID.getText().toLowerCase() + " = " + collection_type_define[i] + "()\n"; 
    			collection_type_declare_cnt++;
    			collection_type_declare[collection_type_declare_cnt] = $ID.getText().toLowerCase();
    			
    			collection_var_cnt++;
    			collection_variables[collection_var_cnt] = $ID.getText().toLowerCase();
    			emit = 0;
    			break;
    		}
    	}
    }
    
    if( datatype_string.contains("\%") ) 
    {
    	String[] tmp = datatype_string.split("\%");
    	String class_name = "";
    	if( tmp[1].equalsIgnoreCase("rowtype"))
    	{
    		class_name = $ID.getText().toLowerCase();
    		output += "\n" + indent + "class " + class_name.toUpperCase() + ":\n";
    		output += indent + "\tpass\n";
    		output += indent + class_name + " = " + class_name.toUpperCase() + "()\n";
    		output += indent + "rowtype_sql = \"describe " + tmp[0] + "\"\n";
    		output += indent + "res = tdw.execute(rowtype_sql)\n";
    		output += indent + "for tmp in res:\n";
    		output += indent + "\t" + $ID.getText().toLowerCase() + ".__dict__[tmp.split()[0]] = None\n";
    		output += "\n"; 
    		has_collection_type = 1;
    		collection_var_cnt++;
    		collection_variables[collection_var_cnt] = $ID.getText().toLowerCase();
    		emit = 0;	
    	} else if (tmp[1].equalsIgnoreCase("type")) {
    		output += indent + "# FIXME: \%type is not supported, you have to rewrite it!\n";
    		output += indent + $ID.getText().toLowerCase() + " = dynamic_type()\n";
    		has_collection_type = 1;
    		collection_var_cnt++;
    		collection_variables[collection_var_cnt] = $ID.getText().toLowerCase();
    		emit = 0;
    	}
    }
    if (datatype_string.toLowerCase().contains("number")) {
    	output += indent + $ID.getText().toLowerCase() + " = int()\n";
    	emit = 0;
    } else if (datatype_string.toLowerCase().contains("smallint")) {
    	output += indent +  $ID.getText().toLowerCase() + " = int()\n";
    	emit = 0;
    } else if (datatype_string.toLowerCase().contains("date")) {
    	output += indent +  $ID.getText().toLowerCase() + " = Dateclass()\n";
    	emit = 0;
    }
    }
    {
    if (emit == 1) {
    	output += indent +  $ID.getText().toLowerCase() + " = None\n";
    }
    exp = "";
    variables_list_cnt++;
    variables_list[variables_list_cnt]  = $ID.getText().toLowerCase(); 
    }( ( NOT NULL )? (  ASSIGN  | DEFAULT ) ( expression
    {output += indent + $ID.getText().toLowerCase() + " = " + exp + '\n'; }
    | dbmsfunc_call )  )?)
    | constant_declaration
    {
    output += indent + "# FIXME: Constant declaration";
    todo_count++;
    }
    | exception_declaration
    {
    output += indent +  exp.toLowerCase() + " = None # This is an exception!\n";
    exp = "";
    }
    ;
    

constant_declaration :
        ID CONSTANT datatype ( NOT NULL )? (   ASSIGN  | DEFAULT  ) expression
        {
        }
    ;

exception_declaration :
        ID EXCEPTION {
        exp = $ID.getText().toLowerCase();
        variables_list_cnt++;
    	variables_list[variables_list_cnt]  = $ID.getText().toLowerCase(); 
	}
    ;   

type_definition : 
    	kTYPE ID IS ( record_type_definition[$ID.getText().toLowerCase()] | collection_type_definition[$ID.getText().toLowerCase()] | ref_cursor_type_definition )  
    ;
   
subtype_definition :
	{int start = input.LT(1).getTokenIndex();}
        SUBTYPE ID IS 
        {int end = input.LT(-1).getTokenIndex();
        int pos = end + 1;
        while(input.get(pos).getChannel() != 0)
        	pos++;
        end = pos - 1;
        output += input.toString(start, end).toLowerCase();}         
        datatype 
        {start = input.LT(1).getTokenIndex();}
        ( NOT NULL )?
        {end = input.LT(-1).getTokenIndex();
        pos = end + 1;
        while(input.get(pos).getChannel() != 0)
        	pos++;
        end = pos - 1;
        output += input.toString(start, end).toLowerCase();}        
    ;
    
record_type_definition[String classname] 
@init{
	int __idx = 0;
	String init_func = "";
	indent_count = 1;
}
@after{
	output += init_func;
	indent_count = 1;
}
:
	{
		output += '\n';
		for(int i = 0; i < indent_count; i++)
		{	
			output += '\t';
			init_func += '\t';
		}
		output += "class " + classname + ":\n";
		init_func += "\tdef __init__(self, l = None):\n";
		for(int i = 0; i < indent_count; i++)
		{	
			init_func += '\t';
		}
		init_func += "\t\tif l != None:\n";
		indent_count++;
		has_record_type = 1;
		record_define_cnt++;
		record_define[record_define_cnt] = classname;
	}
	RECORD LPAREN 
	{
		for(int i = 0; i < indent_count; i++)
		{	
			output += '\t';
			init_func += '\t';
		}
		init_func += '\t';
	}
	record_field_declaration
	{
		output += exp.toLowerCase() + " = None\n";
		init_func += "\tself." + exp.toLowerCase() + " = l[" + __idx + "]\n";
		exp = "";
	} 
	( COMMA 
	{
		for(int i = 0; i < indent_count; i++)
		{	
			output += '\t';
			init_func += '\t';
		}
		init_func += '\t';
	}	
	record_field_declaration 
	{
		__idx++;
		output += exp.toLowerCase() + " = None\n";
		init_func += "\tself." + exp.toLowerCase() + " = l[" + __idx + "]\n";
		exp = "";
	} 	
	)* RPAREN
	{init_func += '\n';}
    	;   

record_field_declaration :
	ID datatype {exp = $ID.getText().toLowerCase();} ( ( NOT NULL )? ( ASSIGN | DEFAULT ) expression )?
    	;
   
collection_type_definition[String name]
@init{
output += '\n';
output += "\tclass " + name + ":\n";
output += "\t\t_value = {}\n";
output += "\t\t_count = 0\n";
output += "\t\tdef __init__(self, *values):\n";
output += "\t\t\ti = 1\n";
output += "\t\t\tfor tmp in values:\n";
output += "\t\t\t\tself._value[i] = tmp\n";
output += "\t\t\t\tself._count += 1\n";
output += "\t\t\t\ti += 1\n";
output += "\t\t\n";
output += "\t\tdef __len__(self):\n";
output += "\t\t\treturn self._count\n";
output += "\t\t\n";
output += "\t\tdef count(self):\n";
output += "\t\t\treturn self._count\n";
output += "\t\t\n";
output += "\t\tdef __getitem__(self, key):\n";
output += "\t\t\treturn self._value[key]\n";
output += "\t\t\n";
output += "\t\tdef __setitem__(self, key, value):\n";
output += "\t\t\tself._value[key] = value\n";
output += "\n";

has_collection_type = 1;
collection_type_define_cnt++;
collection_type_define[collection_type_define_cnt] = name;
}
@after{
indent_count = 1;
}
	:	varray_type_definition
	|	nested_table_type_definition
	;

varray_type_definition
   	: ( VARYING ARRAY? | VARRAY ) LPAREN numeric_literal RPAREN kOF datatype ( NOT NULL )? 	 
   	;

nested_table_type_definition
   	: TABLE kOF datatype ( NOT NULL )? ( INDEX BY associative_index_type )? 
   	;

associative_index_type
   	: datatype
   	;

ref_cursor_type_definition
   	: 
   	{int start = input.LT(1).getTokenIndex();
    	output += "\n\t# FIXME: REF CURSOR TYPE DEFINITION\n";
    	output += "\t\"\"\"\n";
    	}
   	REF CURSOR ( RETURN datatype )?
   	{int end = input.LT(-1).getTokenIndex();
        int pos = end + 1;
        while(input.get(pos).getChannel() != 0)
        	pos++;
        end = pos - 1;
        String tmp = input.toString(start, end).toLowerCase();
        int length = tmp.length();

        output += tmp + '\n';
        output += "\t\"\"\"\n";
        } 
   	;
   

datatype
    : ( REF )? ID ( DOT ID )? ( LPAREN numeric_literal ( COMMA numeric_literal )* RPAREN | PERCENT ( kTYPE | ROWTYPE ) )?
    ;
   
function_declaration_or_definition 
@init{
int saved_cp = create_package;
create_package = 0;
indent_count = 1;
}
@after{
variables_list_cnt = -1;
create_package = saved_cp;
}:
        function_heading  
        ( DETERMINISTIC | PIPELINED | PARALLEL_ENABLE | RESULT_CACHE )*
        ( ( IS | AS ) declare_section? body 
        {

        for(int i = 0; i <= variables_list_cnt; i++ )
        {
        	String reg = "(?i)" + variables_list[i];
        	String repl = variables_list[i].toLowerCase();
        	//output = output.replaceAll(reg, repl);
        }	
        
        pfops.write(output.getBytes()); pfops.write("\n\n".getBytes()); output = "";
	if( has_record_type == 1 )
	{
		record_define_cnt = -1;
		record_declare_cnt = -1;
		has_record_type = 0;
	}
	
	if( has_collection_type == 1)
	{
		collection_type_define_cnt = -1;
		collection_type_declare_cnt = -1;
		//collection_var_cnt = -1;
		has_collection_type = 0;		
	}
        }
        )?
	;
   catch[RecognitionException re] {reportError(re);recover(input,re);}
   catch[IOException e] {e.printStackTrace();}
   
procedure_declaration_or_definition 
@init{
int saved_cp = create_package;
create_package = 0;
indent_count = 1;
}
@after{
variables_list_cnt = -1;
create_package = saved_cp;
}:
        procedure_heading 
        ( ( IS | AS ) declare_section? body 
        {
        for(int i = 0; i <= variables_list_cnt; i++ )
        {
        	String reg = "(?i)" + variables_list[i];
        	String repl = variables_list[i].toLowerCase();
        	//output = output.replaceAll(reg, repl);
        }	
        
        pfops.write(output.getBytes()); pfops.write("\n\n".getBytes()); output = "";
	if( has_record_type == 1 )
	{
		record_define_cnt = -1;
		record_declare_cnt = -1;
		has_record_type = 0;
	}
	
	if( has_collection_type == 1 )
	{	
		collection_type_define_cnt = -1;
		collection_type_declare_cnt = -1;
		//collection_var_cnt = -1;
		has_collection_type = 0;
	} 
        }        
        )?
    	;
   catch[RecognitionException re] {reportError(re);recover(input,re);}
   catch[IOException e] {e.printStackTrace();} 
       		
body
@init{
indent_count = 2;
int has_exception_handler = 0;
} 	:	
	BEGIN {
	output += "\t# BEGIN a BODY\n";
	output += "\ttry:\n";
	} statement {
		if(!stat.equals("")) {
			output += stat; 
			stat = "";
		}
	}
	SEMI ( statement
	{
		if(!stat.equals("")) {
			output += stat; 
			stat = "";
		}
	} SEMI | pragma SEMI )*
	({
	stat = "";
    	}
	EXCEPTION {has_exception_handler = 1;} exception_handler+ 
	)? END {
	if (has_exception_handler == 0) {
		output += "\texcept HiveServerException, hse:\n";
		output += "\t\tprint hse\n";	
	}
	} ID?
	;

exception_handler:
	{int start = input.LT(1).getTokenIndex();} 	
	WHEN ( qual_id ( OR qual_id )* {
	for (int i = 0; i < indent_count - 1; i++) {
		output += "\t";
	}
	output += "except HiveServerException, hse:\n";
	} | OTHERS {
	for (int i = 0; i < indent_count - 1; i++) {
		output += "\t";
	}
	output += "except:\n";} ) THEN  
        {
        
        }
	( statement SEMI )+
	{
	output += stat;
	stat = "";
	}
	;	
	
statement :
    label*
    ( assign_or_call_statement
    | case_statement
    | close_statement
    | continue_statement
    | basic_loop_statement
    | execute_immediate_statement
    | exit_statement
    | fetch_statement
    | for_loop_statement
    | forall_statement
    | goto_statement
    | if_statement
    | null_statement
    | open_statement
    | plsql_block 
    | raise_statement 
    | return_statement 
    | sql_statement
    | while_loop_statement 
    | dbmsfunc_call
    )
    ;

lvalue
@init{
String previous_id = "";
last_id = "";
int found = 0;
}
    : 	
    	{int start = input.LT(1).getTokenIndex();
    	int end = 0;}
    	call_lvalue {previous_id = last_id;} ( DOT {end = input.LT(-1).getTokenIndex(); stat += ".";} call_lvalue )* 
    	{
    	if (has_collection_type == 1) {
		for(int i = 0; i <= collection_var_cnt; i++) {
			if (previous_id.contains(collection_variables[i].toLowerCase())) {
				found = 1;
    				break;
			}
		}
    	}
    	if (found == 0) {
    	if(global == 1)
    	{
    		if(end != 0){
		    	String tmp = input.toString(start, end - 1);
		    	global_import_package_count++;
		    	int i = 0;
		    	
		    	if(!tmp.contains("dbms")&&!tmp.contains("DBMS"))
		    	{	    	       
				for(i = 0; i < global_import_package_count; i++)
				{
				    	if(global_import_package[i].equalsIgnoreCase(tmp))
				    		break;
				}
				if(i == global_import_package_count)
				    	global_import_package[i] = tmp;
				else
				    	global_import_package_count--;
			}
			else
				global_import_package_count--;
		}
    	}
    	else
    	{
	    	if(end != 0){
		    	String tmp = input.toString(start, end - 1);
		    	import_package_count++;
		    	int i = 0;
		    	
		    	if(!tmp.contains("dbms")&&!tmp.contains("DBMS"))
		    	{	    	       
				for(i = 0; i < import_package_count; i++)
				{
				    	if(import_package[i].equalsIgnoreCase(tmp))
				    		break;
				}
				if(i == import_package_count)
				    	import_package[i] = tmp;
				else
				    	import_package_count--;
			}
			else
				import_package_count--;	
		}
	}
	}
    	}
    ;	
   
assign_or_call_statement
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
    :  	
    {int start = input.LT(1).getTokenIndex();}
    lvalue
    {int end = input.LT(-1).getTokenIndex();
    String lvalue_string = input.toString(start, end).toLowerCase();
    }
     ( 
    	DOT 
        {stat += '.';}     
    	delete_call | 
    	ASSIGN   	
    	(expression
    	{
    	if(lvalue_string.contains("("))
    	{
    		if( has_collection_type == 1 ) {
    			for(int i = 0; i <= collection_var_cnt; i++)
    			{
    				if(stat.toLowerCase().contains(collection_variables[i].toLowerCase()))
    				{
    					String tmp1 = lvalue_string.toLowerCase().replace("(", "(tdw, ");
    					String tmp2 = tmp1.replace("(tdw, ", "[");
    					tmp2 = tmp2.replace(")", "]");
    					stat = stat.replace(tmp1, tmp2);
    					break;
    				}
    			}
   		} else {
        		String tmp1 = lvalue_string.replace("(", "[");
	        	tmp1 = tmp1.replace(")", "]");
        		stat = stat.replace(lvalue_string, tmp1);
        	}
    	}

    	if( (has_record_type == 1) && exp.equalsIgnoreCase("none ") )
    	{
    		int i = 0;
    		int found = 0;
		for(i = 0; i <= record_declare_cnt; i++)
		{
			if( lvalue_string.equalsIgnoreCase(record_declare[i]))
			{
    				stat += " = " + lvalue_string + ".__class__()";
    				exp = "";
    				found = 1;
    				break;
    			} 
		}
		
		if( found == 0 )
			stat += " = " + exp; exp = "";
    	}
    	else
    	{
    		stat += " = " + exp; exp = "";
    	}	
    	}| dbmsfunc_call ))?
    ;

call
@init{
String saved_last_id = "";
int bracket = 0;
}
@after{
if (saved_last_id.length() > 0) 
	last_id = saved_last_id;
}
    :   COLON? {if($COLON != null) exp += ":";} ID {
    	String tmp = $ID.getText().toLowerCase();
    	if (tmp.toLowerCase().equals("round"))
    		tmp = tmp.toLowerCase().replace("round", "tdw_round");
    	else if (tmp.toLowerCase().equals("abs"))
    		tmp = tmp.toLowerCase().replace("abs", "tdw_abs");
	exp += tmp;
	last_id = $ID.getText().toLowerCase();
    	}
    	( LPAREN {
    	saved_last_id = last_id;
    	int found = 0;
    	// check the collection 
  	if( has_collection_type == 1 )
    	{
    		for(int i = 0; i <= collection_var_cnt; i++)
    		{
    			if($ID.getText().toLowerCase().contains(collection_variables[i].toLowerCase()))
    			{
    				exp += "[";
    				bracket = 1;
    				found = 1;
    				break;
    			}
    		}
   	}
   	if (found == 0) {
    		exp += "(tdw, "; 
    	}
    	// ok, we should mark the to_data() call as TODO
    	emitFunctionName(tmp.toLowerCase(), $ID.getLine());
    	} 
    	( parameter
    	{
    	}
    	 ( COMMA {exp += ", ";} (parameter 
    	{
    	}
    	|dbmsfunc_call))* )? RPAREN {if (bracket == 0) exp += ")"; else exp += "]";})?
    ;
    
call_lvalue
    	: 
    	COLON? ID 
    	{
    	if($ID.getText().equalsIgnoreCase("dbms_stats"))
    		stat += "";
    	stat += $ID.getText().toLowerCase();
    	last_id = $ID.getText().toLowerCase();
    	} 	    
    	( LPAREN {stat += "(tdw, ";} ( parameter {stat += exp ;exp = "";} ( COMMA {stat += ", ";} (parameter {stat += exp ;exp = "";}|dbmsfunc_call))* )? RPAREN {stat += ")";})?
    ;

dbmsfunc_call
    : t1=DBMS DOT ( ID | EXECUTE) (LPAREN ( parameter (COMMA (parameter |dbmsfunc_call))* )? RPAREN)* 
    ;

delete_call
    : DELETE ( LPAREN parameter? RPAREN )?
    ;

basic_loop_statement 
@init{
stat += "\n";
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
stat += "idx = 0\n";
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
String tmp = "";
}
@after{
stat += '\n';
}
:
     LOOP {stat += "while True:\n";}
     ({indent_count++;} statement {indent_count--;} SEMI  )+ END LOOP label_name?
    ;	
   
case_statement 
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
:
        CASE expression?
        {String variable = exp; exp = "";
        int flag = 0;
        }
        ( WHEN expression THEN  
        {if(flag == 0)
        {
        	stat += "if " + variable + " == " + exp + ":\n";
        	exp = "";
        	flag = 1;
        }
        else
        {
		for(int i = 0; i < indent_count; i++)
		{	
			stat += '\t';
		}        	
        	stat += "elif " + variable + " == " + exp + ":\n";
        	exp = "";
        } 
        }
        ({indent_count++;} statement {indent_count--;} SEMI )+ )+
        ( ELSE 
        {
	for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}        
        stat += "else:\n";
        }
        {indent_count++;} statement SEMI {indent_count--;})? END CASE          
        label_name?
    ;	
   
close_statement 
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
:
	{int start = input.LT(1).getTokenIndex();
	stat += "#FIXME: CURSOR CLOSE STATEMENT\n";
	for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}	
	}
        CLOSE ID ( DOT ID )?
        {
        	stat += "pass";
        }         
    ;

continue_statement 
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
String tmp = "";
}
@after{
stat += '\n';
}
:
    CONTINUE ( lbl=ID )? ( WHEN expression )?
    {
    	if(exp.equals(""))
    	{
    		stat += "continue";
    	}
    	else
    	{
    		stat += "if " + exp + ":\n";
    		exp = "";
    		for(int i = 0; i < indent_count; i++)
		{	
			stat += '\t';
		}
		stat += "\tcontinue\n";
    	}
    }        
    ;
   
execute_immediate_statement
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
String tmp = "";
}
@after{
stat += '\n';
exp = "";
}
 :
        EXECUTE IMMEDIATE expression
         {tmp = exp; exp = "";
	  stat += "__line = tdw.execute(" + tmp.toLowerCase() + ")\n";
         }(
        ( into_clause 
        
        | bulk_collect_into_clause) using_clause?
        | using_clause dynamic_returning_clause?
        | dynamic_returning_clause
        )? 
    ;  

exit_statement 
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
String tmp = "";
exp = "";
}
@after{
stat += '\n';
}
:
    EXIT ( lbl=ID )? ( WHEN expression)?
    {
    	if(exp.equals(""))
    	{
    		stat += "break";
    	} else if (exp.matches(".*\% *NOTFOUND")) {
    		stat += "if " + exp.substring(0, exp.indexOf("\%")) + " == \"\":\n";
    		exp = "";
    		for(int i = 0; i < indent_count; i++)
		{	
			stat += '\t';
		}
		stat += "\tbreak\n";
    	} else {
    		stat += "if " + exp + ":\n";
    		exp = "";
    		for(int i = 0; i < indent_count; i++)
		{	
			stat += '\t';
		}
		stat += "\tbreak\n";
    	}
    }
    ;
   
fetch_statement 
@init{
	String v_cursor = "";
	int saved_ic = indent_count;
	for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}
}
@after{
	for(int i = 0; i < saved_ic; i++)
	{	
		stat += '\t';
	}
	stat += "except TypeError, te:\n";
	for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}
	stat += v_cursor + " = \"\"\n";
	for(int i = 0; i < saved_ic; i++)
	{	
		stat += '\t';
	}
	stat += "except IndexError, ie:\n";
	for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}
	stat += v_cursor + " = \"\"\n";
	stat += '\n';
	indent_count = saved_ic;
}
:
	{int start = input.LT(1).getTokenIndex();
	stat += "# FIXME: FETCH STATEMENT\n";
	for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}
	stat += "try:\n";
	indent_count++;
	for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}
	}
        FETCH qual_id 
        {
        	v_cursor = input.LT(-1).getText().toLowerCase();
		stat += "__line = " + v_cursor + "['result'][0]\n";
		for(int i = 0; i < indent_count; i++)
		{	
			stat += '\t';
		}
		stat += "__line = __line.split(\"\\t\")\n";
        }
        ( into_clause | bulk_collect_into_clause ( LIMIT numeric_expression )? )
	{
		for (int i = 0; i < indent_count; i++) {
			stat += '\t';
		}
		stat += "__TMP__ = " + v_cursor + "['result'].pop(0)\n";
        }  
    ;  

into_clause
@init{
	int __idx = 0;
	String tmp = "", saved = stat;
	stat = "";
	for(int i = 0; i < indent_count; i++)
	{	
		tmp += '\t';
	}
}
@after{
	if (__idx == 0)
		tmp += ")\n";
	stat = saved + tmp;
}
:
    INTO lvalue {
    if( has_collection_type == 1 )
    {
    	for(int i = 0; i <= collection_var_cnt; i++)
    	{
    		if(stat.toLowerCase().contains(collection_variables[i].toLowerCase()))
    		{
    			stat = stat.replace("(", "[");
    			stat = stat.replace(")", "]");
    			break;
    		}
    	}
    }
    tmp += stat + " = " + stat +".__class__(__line";
    stat = "";
    } 
    ( COMMA lvalue {
    	if( has_collection_type == 1 )
    	{	
    		for(int i = 0; i <= collection_var_cnt; i++)
    		{
    			if(stat.toLowerCase().contains(collection_variables[i].toLowerCase()))
    			{
    				stat = stat.replace("(", "[");
    				stat = stat.replace(")", "]");
    				break;
    			}
    		}
    	}
    	if (__idx == 0)
    		tmp += "[0])\n"; 
    	for(int i = 0; i < indent_count; i++)
	{	
		tmp += '\t';
	}
    	__idx++;
    	tmp += stat + " = " + stat + ".__class__(__line[" + __idx + "])\n";
    	stat = "";
    	} )*
    ;
       
bulk_collect_into_clause 
@init{
	int __idx = 0;
	String tmp = "", saved = stat;
	stat = "";
	for(int i = 0; i < indent_count; i++)
	{	
		tmp += '\t';
	}
}
@after{
	if (__idx == 0)
		tmp += ")\n";
	stat = saved + tmp;
}
:
        BULK COLLECT INTO lvalue {
    if( has_collection_type == 1 )
    {
    	for(int i = 0; i <= collection_var_cnt; i++)
    	{
    		if(stat.toLowerCase().contains(collection_variables[i].toLowerCase()))
    		{
    			stat = stat.replace("(", "[");
    			stat = stat.replace(")", "]");
    			break;
    		}
    	}
    }
    tmp += stat + " = " + stat +".__class__(__line";
    stat = "";
    }( COMMA lvalue {
    	if( has_collection_type == 1 )
    	{	
    		for(int i = 0; i <= collection_var_cnt; i++)
    		{
    			if(stat.toLowerCase().contains(collection_variables[i].toLowerCase()))
    			{
    				stat = stat.replace("(", "[");
    				stat = stat.replace(")", "]");
    				break;
    			}
    		}
    	}
    	if (__idx == 0)
    		tmp += "[0])\n"; 
    	for(int i = 0; i < indent_count; i++)
	{	
		tmp += '\t';
	}
    	__idx++;
    	tmp += stat + " = " + stat + ".__class__(__line[" + __idx + "])\n";
    	stat = "";
    	})*
    ;

using_clause :
        USING param_modifiers? expression ( COMMA param_modifiers? expression )*
    ;

param_modifiers
	: IN OUT? | OUT
	;

dynamic_returning_clause :
        ( RETURNING | RETURN ) ( into_clause | bulk_collect_into_clause )
    ;

for_loop_statement
@init{
stat += '\n';
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}:	
        FOR ID IN
        {int start = input.LT(1).getTokenIndex();}  
        ( ~(LOOP) )+ 
    	{int end = input.LT(-1).getTokenIndex();
    	int pos = end + 1;
        while(input.get(pos).getChannel() != 0)
        	pos++;
        end = pos - 1;
        String tmp = input.toString(start, end);
        if(tmp.toUpperCase().contains("SELECT")) {
	        has_collection_type = 1;
        	collection_var_cnt++;
    		collection_variables[collection_var_cnt] = $ID.getText().toLowerCase();
        	stat += "# FIXME: this is a SQL loop block, you have to check it!\n";
        	todo_count++;
        	tmp = tmp.replaceAll("\n", " ");
        	tmp = tmp.trim();
        	if (1 == 0) {
        		stat += "sqlfor = \"\"\"" + tmp + "\"\"\"\n";
			for(int i = 0; i < indent_count; i++)
			{	
				stat += '\t';
			}        	
        		stat += "sqlresult = tdw.execute(sqlfor)\n";
        		for(int i = 0; i < indent_count; i++)
			{	
				stat += '\t';
			}
        		stat += "for " + $ID.getText().toLowerCase() + " in sqlresult:\n";
        	} else {
        		// Is this a cursor variable?
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "# NOTE: implicit for-loop cursor\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "__TMP__ = dict()\n";
			for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "__TMP__['sql'] = '''" + tmp + "'''\n";
			for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "__TMP__['isopen'] = 1\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "__sql_result = tdw.execute(__TMP__['sql'])\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "# __sql_result is a Python List\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "__TMP__['schema'] = tdw.getschemax()\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "# 'schema' is a Python list (col0 => col_name, ...)\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "__TMP__['type'] = tdw.gettypex()\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "# 'type' is a Python list (col0 => col_type, ...)\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "# Convert result list to Python Class Object w/ schema: .col_name=AAA ...\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "__TMP__['result'] = tdw.parseschema(__TMP__, __sql_result)\n\n";
   		        for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
     		        stat += "for " + $ID.getText().toLowerCase() + " in __TMP__['result'] :\n";
     		}
        } else {
        	tmp = input.toString(start, end).toLowerCase();
        	if(tmp.contains("..")) {
        		if(tmp.contains("reverse")) {
        			tmp = tmp.toLowerCase();
        		        tmp = tmp.trim();
        		        tmp = tmp.substring(7, tmp.length());
        		        String[] sArray = tmp.split("\\.\\.");
        			if(sArray[1].contains(".count"))
        			{
        				String[] sArray1 = sArray[1].split("\\.");
        				tmp = "reversed(range(" + sArray[0] + ", len(" + sArray1[0] + ") + 1))";
        			}	
        			else
        			{
        				tmp = "reversed(range(" + sArray[0] + ", " + sArray[1] + "))";
        			}
        		} else {
        			tmp = tmp.toLowerCase();
        			tmp = tmp.replaceAll("\n", " ");
        			tmp = tmp.trim();
        			String[] sArray = tmp.split("\\.\\.");
        			if(sArray[1].contains(".count"))
        			{
        				String[] sArray1 = sArray[1].split("\\.");
        				tmp = "range(" + sArray[0] + ", len(" + sArray1[0] + ") + 1)";
        			} else if (sArray[1].contains("length(")) {
        				tmp = "range(" + sArray[0] + ", " + sArray[1].replace("length(", "length(tdw, ") + ")";
        			} else
        			{
        				tmp = "range(" + sArray[0] + ", " + sArray[1] + ")";
        			}
        		}
        		stat += "for " + $ID.getText().toLowerCase() + " in " + tmp + ":\n";
        	} else {
        		// Is this a cursor variable?
        		// Then, put the $ID.getText() in to the varlist
        		has_collection_type = 1;
        		collection_var_cnt++;
    			collection_variables[collection_var_cnt] = $ID.getText().toLowerCase();
        		if (tmp.contains("(")) {
        			stat += "# FIXME: for-loop cursor with a variable arguments!\n";
        		} else {
        			stat += "# NOTE: for-loop cursor\n";
        		}
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += tmp + "['isopen'] = 1\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "__sql_result = tdw.execute(" + tmp.toLowerCase() + "['sql'])\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "# __sql_result is a Python List\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += tmp + "['schema'] = tdw.getschemax()\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "# 'schema' is a Python list (col0 => col_name, ...)\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += tmp + "['type'] = tdw.gettypex()\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "# 'type' is a Python list (col0 => col_type, ...)\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += "# Convert result list to Python Class Object w/ schema: .col_name=AAA ...\n";
        		for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
        		stat += tmp + "['result'] = tdw.parseschema(" + tmp + ", __sql_result)\n\n";
   		        for (int i = 0; i < indent_count; i++) {
        			stat += '\t';
        		}
     		        stat += "for " + $ID.getText().toLowerCase() + " in " + tmp + "['result'] :\n";
        	}
        }
        }         
        LOOP ( {
        indent_count++;
        } statement {indent_count--;} SEMI )+ END LOOP        
        label_name?
    ;

forall_statement 
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
:
        FORALL ID IN 
        {int start = input.LT(1).getTokenIndex();}                 
        bounds_clause 
        {int end = input.LT(-1).getTokenIndex();
    	int pos = end + 1;
        while(input.get(pos).getChannel() != 0)
        	pos++;
        end = pos - 1;
        String tmp = input.toString(start, end).toLowerCase();
        if(tmp.contains(".."))
        {
        	String[] sArray = tmp.split("\\.\\.");
        	tmp = "range(" + sArray[0] + ", " + sArray[1] + ")";
        	tmp = tmp.replace("\n", "");
        }
        stat += "for " + $ID.getText().toLowerCase() + " in " + tmp + " :\n";
        }         
        {indent_count++;}
        sql_statement
        { indent_count--;} 
        ( kSAVE kEXCEPTIONS )?     
    ; 
   
bounds_clause 
    : numeric_expression {exp = "";} DOUBLEDOT numeric_expression {exp = "";}
    | kINDICES kOF atom ( BETWEEN numeric_expression {exp = "";} AND numeric_expression {exp = "";} )?
    | kVALUES kOF atom
    ;
   
goto_statement :
        GOTO ID
        {
        	// or GOTO lable_name
 		for(int i = 0; i < indent_count; i++)
		{
			stat += '\t';
		}
		stat += "# FIXME: goto statement is not supported. Please fix it!\n";
		for(int i = 0; i < indent_count; i++)
		{
			stat += '\t';
		}
		stat += "# goto " + $ID.getText().toLowerCase() + "\n";
		for(int i = 0; i < indent_count; i++)
		{
			stat += '\t';
		}
		stat += "pass\n";
	}
    ;

if_statement 
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}:
        IF expression THEN 
    	{
    	stat += "if " + exp + ":\n"; exp = "";}        
        ( {indent_count++;} statement {indent_count--;} SEMI )+
        ( ELSIF  expression THEN 
	{
	for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}	
	stat += "elif " + exp + ":\n"; exp = "";}         
        ( {indent_count++;} statement {indent_count--;} SEMI )+ )*
        ( ELSE 
	{
	for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}	
	stat += "else " + ":\n"; exp = "";}           
        ( {indent_count++;}  statement {indent_count--;} SEMI )+ )?       
        END IF          
    ;

null_statement 
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
:
    NULL   {stat += "None";}    
    ;   

open_statement 
@init{
int is_static = 1;
stat += '\n';
String cursor_name = "";
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
:
	{int start = input.LT(1).getTokenIndex();
	stat += "# FIXME: CURSOR OPEN STATEMENT\n";
	for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}	
	}
        OPEN ID {cursor_name = input.LT(-1).getText().toLowerCase(); stat += cursor_name + " = ({'isopen':1, 'result':";} ( DOT ID )* call_args? 
        ( FOR (select_statement {is_static =0; stat += "tdw.execute(" + __sql + ")"; __sql = "";}| ID {
         is_static = 0;
         stat += "tdw.execute(" + input.LT(-1).getText().toLowerCase() + ")";
         } ) )? {
         	if (is_static == 1) {
         		stat += "tdw.execute(" + cursor_name + "['sql'])";
         	}
        	stat += "})\n";
        } 
    ;  
   
pragma :
        PRAGMA swallow_to_semi
    ;

raise_statement 
@after{
stat += ");\n";
}:
       RAISE {
	for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}
	stat += "tdw.tdw_raise(-22, ";
       }
       ( ID {stat += input.LT(-1).getText().toLowerCase();} ( DOT {stat += "."; } ID {
       stat += input.LT(-1).getText().toLowerCase();
       } )* )?       
    ;	

return_statement 
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
:
    	RETURN {stat += "return ";} expression? 
    	{if(!exp.equals("")) 
    	{
    		stat += exp;
    		exp = "";
    	}
    	}
    	;

plsql_block 
@init{
int saved_cp = create_package;
create_package = 0;
}
@after{
create_package = saved_cp;
}
:
    	( DECLARE declare_section )? body_block
    ;

body_block
@init{
indent_count++;
int has_exception_handler = 0;
}
@after{
indent_count--;
}
	:	
	BEGIN {
		for (int i = 0; i < indent_count-1; i++) {
			stat += "\t";
		}
		stat += "# BEGIN a BODY AGAIN\n";
		for (int i = 0; i < indent_count-1; i++) {
			stat += "\t";
		}
		stat += "try:\n";
	}
	statement {
		if (!stat.equals("")) {
			output += stat;
			stat = "";
		}
	}
	SEMI ( statement {
		if (!stat.equals("")) {
			output += stat;
			stat = "";
		}
	}
	SEMI | pragma SEMI )*
	( 
	{
		stat = "";
    	}	
	EXCEPTION {has_exception_handler = 1;} exception_handler+ 
	)? END {
		if (has_exception_handler == 0) {
			for (int i = 0; i < indent_count - 1; i++) {
				stat += "\t";
			}
			stat += "except HiveServerException, hse:\n";
			for (int i = 0; i < indent_count; i++) {
				stat += "\t";
			}

			stat += "print hse\n";	
		}
	}ID?
	; 
      
label :
        LLABEL ID RLABEL
        {
        	for (int i = 0; i < indent_count; i++) {
				stat += "\t";
		}
        	stat += "# FIXME: there is no goto statement in python. Please fix it!\n";
        	for (int i = 0; i < indent_count; i++) {
				stat += "\t";
		}
		stat += "# <<" + $ID.getText().toLowerCase() + ">>\n";
        }
    ;

qual_id :
    COLON? ID ( DOT COLON? ID )*
    ;	

sql_statement
    : commit_statement
    | delete_statement 
    | insert_statement 
    | lock_table_statement 
    | rollback_statement 
    | savepoint_statement 
    | select_statement 
    | set_transaction_statement
    | update_statement 
    | merge_statement 
    ;

commit_statement 
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
:
    COMMIT swallow_to_semi?
    {
        	stat += "commit()";
    }
    ;
   
delete_statement 
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
:
	{int start = input.LT(1).getTokenIndex();}
        DELETE swallow_to_semi
        {int end = input.LT(-1).getTokenIndex();
        String tmp = input.toString(start, end);
        int length = tmp.length();

        for(int i = 0; i < length; i++)
        	if(tmp.charAt(i) == '\n')
        		sql_count++;        
        stat += "sql_select = \"\"\"" + tmp + "\"\"\"\n";
        for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}
	stat += "tdw.execute(sql_select)\n";
        }         
    ;

insert_statement
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
:
	{int start = input.LT(1).getTokenIndex();} 
        INSERT swallow_to_semi
        {int end = input.LT(-1).getTokenIndex();
        String tmp = input.toString(start, end);
        int length = tmp.length();
        for(int i = 0; i < length; i++)
        	if(tmp.charAt(i) == '\n')
        		sql_count++;        
        stat += "sql_select = \"\"\"" + tmp + "\"\"\"\n";
        for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}
	stat += "tdw.execute(sql_select)\n";
        }
    ;
   
lock_table_statement :
        LOCK TABLE swallow_to_semi
    ;

rollback_statement 
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
:
        ROLLBACK swallow_to_semi?
        {
        	stat += "rollback()";
        }
    ;

savepoint_statement
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
} 
:
	{int start = input.LT(1).getTokenIndex();} 
        SAVEPOINT ID
        {int end = input.LT(-1).getTokenIndex();
        int pos = end + 1;
        while(input.get(pos).getChannel() != 0)
        	pos++;
        end = pos - 1;
        stat += input.toString(start, end);}         
    ;
   
select_statement 
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
:
	{int start = input.LT(1).getTokenIndex();}  
        SELECT swallow_to_semi
        {int end = input.LT(-1).getTokenIndex();
        String tmp = input.toString(start, end);
        int length = tmp.length();
        
        for(int i = 0; i < length; i++)
        	if(tmp.charAt(i) == '\n')
        		sql_count++;
        stat += "sql_select = \"\"\"" + tmp + "\"\"\"\n";
        __sql = "\"\"\"" + tmp + "\"\"\"";
        for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}
	
	if(tmp.toLowerCase().contains("into"))
	{
               int begin_pos = tmp.toLowerCase().indexOf("into");
               int end_pos = tmp.toLowerCase().indexOf("from", begin_pos);

               if(begin_pos > tmp.length() || begin_pos < 0 || end_pos > tmp.length() || end_pos <0 )
               {
               	    System.out.print(tmp);
                    stat += "tdw.execute(sql_select)\n";
               }
               else
               {        				
               		String into_exp = tmp.substring(begin_pos + 4, end_pos - 1);
               		if (into_exp.contains("--"))
               			into_exp = into_exp.substring(0, into_exp.indexOf("--"));
               		else if (into_exp.contains("/*")) {
             			into_exp = into_exp.replaceAll("/\\*.*\\*/", "");
               		}
               		into_exp = into_exp.trim().toLowerCase();
               		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
               		Matcher m = p.matcher(into_exp);
               		into_exp = m.replaceAll("");
               		into_exp = into_exp.replace("(", "[");
               		into_exp = into_exp.replace(")", "]");
               		into_exp = into_exp.replace(",", ", ");
               
               		stat += '(' + into_exp + ") = tdw.execute(sql_select)\n";
              }
	}
	else
		stat += "tdw.execute(sql_select)\n";

        }          
    ;	
catch[StringIndexOutOfBoundsException e] {e.getMessage();}   

set_transaction_statement :
        SET TRANSACTION swallow_to_semi
    ;

update_statement 
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
:
	{int start = input.LT(1).getTokenIndex();} 
        UPDATE swallow_to_semi
        {int end = input.LT(-1).getTokenIndex();
        String tmp = input.toString(start, end);
        int length = tmp.length();
        
        for(int i = 0; i < length; i++)
        	if(tmp.charAt(i) == '\n')
        		sql_count++;        
        stat += "sql_select = \"\"\"" + tmp + "\"\"\"\n";
        for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}
	stat += "tdw.execute(sql_select)\n";
        }        
    ;
       
merge_statement  
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
:
	{int start = input.LT(1).getTokenIndex();} 
	MERGE  swallow_to_semi
        {int end = input.LT(-1).getTokenIndex();
        String tmp = input.toString(start, end);
        int length = tmp.length();

        for(int i = 0; i < length; i++)
        	if(tmp.charAt(i) == '\n')
        		sql_count++;        
        stat += "sql_select = \"\"\"" + tmp + "\"\"\"\n";
        for(int i = 0; i < indent_count; i++)
	{	
		stat += '\t';
	}
	stat += "tdw.execute(sql_select)\n";
        } 	
    ;		

swallow_to_semi :
        ~( SEMI )+
    ;

while_loop_statement 
@init{
for(int i = 0; i < indent_count; i++)
{	
	stat += '\t';
}
}
@after{
stat += '\n';
}
:
    WHILE expression LOOP  
    {
    stat += "while " + exp + ":\n"; 
    exp = "";}       
    ( {indent_count++;} statement {indent_count--;} SEMI )+ END LOOP label_name?        
    ;

match_parens
    : ( options {greedy=false;} : ~( RPAREN | LPAREN | SEMI | AS | IS | IN | OUT ) )*
    | RPAREN match_parens LPAREN
    ;

label_name:
	ID
	;
   
expression
@after{
}
    : or_expr
    ;

or_expr
    :  and_expr ( OR { exp += " or ";} and_expr )*
    ;	 

and_expr
    : not_expr ( AND { exp += " and ";}  not_expr )*
    ;	 
   
not_expr
    :  	NOT? { if($NOT != null) exp += " not ";} compare_expr
    ; 
   
compare_expr
    	: is_null_expr ( 
    	( EQ {exp += " == ";} | NOT_EQ {exp += " != ";}| LTH {exp += " < ";}| LEQ {exp += " <= ";}| GTH {exp += " > ";}| GEQ {exp += " >= ";})   	
    	is_null_expr )?
    ;

is_null_expr
    	: like_expr ( IS {exp += " is ";} NOT? { if($NOT != null) exp += " not ";} NULL { exp += " None ";})?  	
    	;
   
like_expr
    	: between_expr ( 
    	NOT? { if($NOT != null) exp += " not ";} LIKE  { exp += " == ";}
    	between_expr )?
    ;
   
between_expr
    	: in_expr ( NOT? { if($NOT != null) exp += " not ";} BETWEEN  { exp += " between ";}    	
    	in_expr AND {exp += "and";} in_expr )?
    	;
   
in_expr
    : 	add_expr ( NOT? { if($NOT != null) exp += " not ";} IN LPAREN {exp += " in (";} add_expr 
    	( COMMA  {exp += ", ";} add_expr )* RPAREN  {exp += ") ";})?
    ;
   
numeric_expression
    : add_expr
    ;

add_expr
@init{
int double_vertbar = 0;
int pos = 0;
String saved = exp;
exp = "";
}
@after {
exp = saved + exp;
}
    :	mul_expr 
    	( 
    	( MINUS {exp += " - ";} 
    	| PLUS {exp += " + ";} 
    	| DOUBLEVERTBAR { exp += " || "; pos = exp.lastIndexOf("||");double_vertbar = 1;} 
    	)   
    	mul_expr 
    	{
    	if(double_vertbar == 1)
    	{    	
    		String tmp1 = "";
    		String tmp = "";	
    		if(exp.substring(0, pos - 1).contains("=="))
    		{
    			int i = exp.lastIndexOf("==");
    			tmp1 = exp.substring(0, i + 2);
    			tmp = exp.substring(i+2, pos - 1).trim(); 
    		}
    		else
    		{
			tmp = exp.substring(0, pos - 1).trim();
			tmp1 = "";
		}
    		if(tmp.startsWith("\"\"\"")||tmp.startsWith("str("))
    			tmp1 += tmp;
    		else
    			tmp1 += "str(" + tmp + ")";
    		tmp = exp.substring(pos + 2, exp.length()).trim();
    		if(tmp.startsWith("\"\"\"")||tmp.startsWith("str("))
    			tmp1 += " + " + tmp;
    		else
    			tmp1 += " + str(" + tmp + ")";
    		
    		exp = tmp1;
    		double_vertbar = 0;
    	}
    	}
    	)*
    ;
   
mul_expr
    : 	unary_sign_expr ( 
    	( ASTERISK {exp += " * ";}| DIVIDE {exp += " / ";} | kMOD {exp += " \% ";} )     
    	unary_sign_expr )*
    ;
   
unary_sign_expr
    :
    	( MINUS {exp += " - ";} | PLUS {exp += " + ";})?    
    	exponent_expr
    ;
   
exponent_expr
    : atom ( EXPONENT {exp += " ** ";} atom )?
    ;
   
atom
@init{
String saved = exp;
exp = "";
}
@after{
exp = saved + exp;
}
    	: variable_or_function_call (  
    	PERCENT {exp += " \% ";} attribute {
    	if (exp.toLowerCase().contains("rowcount")) {
    		exp = "tdw.getrowcount()";
    	} else if (exp.toLowerCase().contains("isopen")) {
    		String var = exp.substring(0, exp.indexOf("\%"));
    		exp = var + "['isopen']";
    	} else if (exp.toLowerCase().contains("notfound")) {
    		String var = exp.substring(0, exp.indexOf("\%"));
    		exp = var + "== \"\"";
    	} else if (exp.toLowerCase().contains("found")) {
    		String var = exp.substring(0, exp.indexOf("\%"));
    		exp = var + "!= \"\"";
    	}
    	} )?
    	|
    	{int start = input.LT(1).getTokenIndex();}  
    	SQL PERCENT 
    	{int end = input.LT(-1).getTokenIndex();
        int pos = end + 1;
        while(input.get(pos).getChannel() != 0)
        	pos++;
        end = pos - 1;
        exp += input.toString(start, end).toLowerCase();} 
    	attribute {
    		if (exp.toLowerCase().contains("rowcount")) {
    			exp = "tdw.getrowcount()";
    		}
    	}
    	| string_literal
    	| numeric_atom
    	| boolean_atom
    	| NULL{exp += "None ";}    	
    	| 
   	 LPAREN {exp += "( ";}     
    	expression 
    	RPAREN  {exp += " )";}     	
    	| LPAREN dbmsfunc_call ( EQ | NOT_EQ | LTH | LEQ | GTH | GEQ ) INTEGER RPAREN
    ;
    
variable_or_function_call
@init{
String previous_id = "";
String saved_exp = "";
int found = 0;
int suspect = 1;
int replaced = 0;
last_id = "";
}
    : 	call {previous_id = last_id; saved_exp = exp;} ( DOT {
    	if (has_collection_type == 1) {
		for(int i = 0; i <= collection_var_cnt; i++) {
			if (previous_id.toLowerCase().contains(collection_variables[i].toLowerCase())) {
				found = 1;
    				break;
			}
		}
    	}
    	if (found == 0) {
    		if (global == 0) {
	    		import_package_count++;
	    		int i = 0;
	    	
	    		if(!exp.contains("dbms")&&!exp.contains("DBMS"))
			{	    	       
				for(i = 0; i < import_package_count; i++)
				{
					if(import_package[i].equalsIgnoreCase(exp))
						break;
				}
				if(i == import_package_count)
			    		import_package[i] = exp;
				else
			   	 	import_package_count--;
			}
		} else {
	    		global_import_package_count++;
	    		int i = 0;
	    	
	    		if(!exp.contains("dbms")&&!exp.contains("DBMS"))
			{	    	       
				for(i = 0; i < global_import_package_count; i++)
				{
					if(global_import_package[i].equalsIgnoreCase(exp))
						break;
				}
				if(i == global_import_package_count)
				    	global_import_package[i] = exp;
				else
				    	global_import_package_count--;
			}
		}
	}
	suspect = 0;
    	saved_exp += '.'; 
    	exp = "";
    } call {
    if (has_collection_type == 1) {
	for(int i = 0; i <= collection_var_cnt; i++) {
		if (previous_id.contains(collection_variables[i].toLowerCase())) {
    			exp = exp.replace("(tdw, ", "(");
    			suspect = 0;
    			break;
		}
	}
    }
    saved_exp += exp;
    previous_id = last_id;
    })*  {exp = saved_exp;} ( DOT {exp += '.'; suspect = 0;} delete_call )?
    {
    
    if (replaced == 0) {
    	//exp = exp.toLowerCase();
    }
    exp = exp.replace("[tdw, ", "[");
    }
    ;

attribute : 
    	{int start = input.LT(1).getTokenIndex();}
    	BULK_ROWCOUNT LPAREN 
    	{int end = input.LT(-1).getTokenIndex();
        int pos = end + 1;
        while(input.get(pos).getChannel() != 0)
        	pos++;
        end = pos - 1;
        exp += input.toString(start, end).toLowerCase();}     
    	expression 
    	{start = input.LT(1).getTokenIndex();}
    	RPAREN
    	{end = input.LT(-1).getTokenIndex();
        pos = end + 1;
        while(input.get(pos).getChannel() != 0)
        	pos++;
        end = pos - 1;
        exp += input.toString(start, end).toLowerCase();}     	
    	| 
    	{int start = input.LT(1).getTokenIndex();} 
    	kFOUND	
    	{int end = input.LT(-1).getTokenIndex();
        int pos = end + 1;
        while(input.get(pos).getChannel() != 0)
        	pos++;
        end = pos - 1;
        exp += input.toString(start, end).toLowerCase();} 
    	| 
    	{int start = input.LT(1).getTokenIndex();} 
    	ISOPEN 
    	{int end = input.LT(-1).getTokenIndex();
        int pos = end + 1;
        while(input.get(pos).getChannel() != 0)
        	pos++;
        end = pos - 1;
        exp += input.toString(start, end).toLowerCase();} 
    	|
    	{int start = input.LT(1).getTokenIndex();}  
    	NOTFOUND
    	{int end = input.LT(-1).getTokenIndex();
        int pos = end + 1;
        while(input.get(pos).getChannel() != 0)
        	pos++;
        end = pos - 1;
        exp += input.toString(start, end).toUpperCase();}     	 
    	| 
    	{int start = input.LT(1).getTokenIndex();} 
    	kROWCOUNT 
    	{int end = input.LT(-1).getTokenIndex();
        int pos = end + 1;
        while(input.get(pos).getChannel() != 0)
        	pos++;
        end = pos - 1;
        exp += input.toString(start, end).toLowerCase();}     	
    ;
   
call_args
    : 
    LPAREN ( parameter ( COMMA   parameter )* )? RPAREN    	
    ;
   
boolean_atom
    : boolean_literal
    | collection_exists
    | conditional_predicate
    ;

numeric_atom
    : numeric_literal
    ;

numeric_literal
    : INTEGER {exp += $INTEGER.getText();}
    | REAL_NUMBER {exp += $REAL_NUMBER.getText();}
    ;

boolean_literal
    : 	TRUE {exp += "True";}| FALSE {exp += "False";}
    ;

string_literal
    : 
    	{int start = input.LT(1).getTokenIndex();}  
    	QUOTED_STRING
    	{int end = input.LT(-1).getTokenIndex();
        String tmp = input.toString(start, end);
        int length = tmp.length();
        
        for(int i = 0; i < length; i++)
        	if(tmp.charAt(i) == '\n') {
        		sql_count++;
        	}
       	exp += tmp.replace("\'", "\"\"\"");
        }
    ;
   
collection_exists
    : ID DOT EXISTS LPAREN expression RPAREN
    ;

conditional_predicate
    : INSERTING
    | UPDATING ( LPAREN QUOTED_STRING RPAREN )?
    | DELETING
    ;

parameter
@init{
int has_arrow = 0;
}
    :
    ( ID ARROW {has_arrow = 1; exp += "'" + $ID.getText().toLowerCase() + " => ";})?   
    expression 	
    {if (has_arrow == 1) {exp += "'";}}
    ;

index
    : expression
    ;

create_package 
@init{
create_package = 1;
}
@after{
pkg_current = $package_name.getText().toLowerCase();
}
: 
	CREATE  
	( OR kREPLACE )? PACKAGE ( schema_name=ID DOT )? package_name=ID
        ( invoker_rights_clause )?
        ( IS | AS ) 
        ( {indent_count = 1;} declare_section )? {create_package = 0;}
        END ( ID )? SEMI
    ;	

create_package_body 
@init{
String saved_output = "";
indent_count = 1;
}
:
        CREATE ( OR kREPLACE )? PACKAGE BODY ( schema_name=ID DOT )? package_name=ID
        {
        global = 0;
        String FileName = $package_name.getText().toLowerCase() + ".py";
        
	poutf = new File(path + FileName);
	
	if(!poutf.exists()){
    		poutf.createNewFile();
    	}
    	
    	try {
		pfops = new FileOutputStream(poutf);
		
		String tmp = "# coding=gbk\n\n";
		pfops.write(tmp.getBytes());
	} catch (FileNotFoundException e) {
		System.out.print("File not Found");
		e.printStackTrace();
	}
	}        
        ( IS | AS ) ( {create_package = 1;} declare_section)? {create_package = 0; saved_output = output; output = "";}
        ( initialize_section=body | END ( package_name2=ID )? ) SEMI     
        {  
        pfops.close(); 
        
	File readfile = new File(path + FileName);
	FileInputStream ipfs = new FileInputStream(readfile);
	
	FileName = $package_name.getText().toLowerCase() + "_tmp.py";	
	File writefile = new File(path + FileName);
	if(!writefile.exists()){
		writefile.createNewFile();
    	}
	FileOutputStream opfs = new FileOutputStream(writefile);
	
	byte[] b = new byte[1024];
		
	int x = 0;
	
	ipfs.read(b, 0, 13);
	opfs.write(b, 0, 13);
	
	if(import_package_count != -1){
		String outs = "";

       		for(int i = 0; i<= import_package_count; i++){
       			outs = "import " + import_package[i].toLowerCase() + "\n";
       			opfs.write(outs.getBytes());
        	}
	}
	
	String outs = "'''---THIS FILE IS CREATED AUTOMATICALLY---'''\n\n";
	outs += "from tdw import HiveServerException\n";
	outs += "from tdw import dynamic_type\n";
	outs += "from tdw_sql_lib import *\n\n";
	//outs += "import " + filename.substring(0, filename.indexOf(".")) + "\n\n";
	//outs += "from " + filename.substring(0, filename.indexOf(".")) + " import *\n\n";
	
	int i;
	for (i = 0; i <= pkg_list_cnt; i++) {
		if (pkg_list[i][0].equalsIgnoreCase($package_name.getText().toLowerCase())) {
			outs += pkg_list[i][1];
			break;
		}
	}
	System.out.println("Write package " + $package_name.getText() + " and check pkg_list @" + i);
	
	opfs.write(outs.getBytes());
	opfs.write(saved_output.getBytes());
	if (output.length() > 0 && !output.contains("def ")) {
		output = output.replaceAll("^\t", "");
		output = output.replaceAll("\n\t", "\n");
		opfs.write(output.getBytes());
	} else 
		opfs.write(output.getBytes());
		
	while((x = ipfs.read(b, 0, 1024)) != -1){
		opfs.write(b, 0, x);
	}
	ipfs.close();
	opfs.close();  
	
	readfile.delete();
	writefile.renameTo(readfile);  
	global = 1;   
        } 
    ;
   catch[RecognitionException re] {reportError(re);recover(input,re);}
   catch[IOException e] {e.printStackTrace();}

       
create_procedure 
@init{
if( has_record_type == 1 )
{
	record_define_cnt = -1;
	record_declare_cnt = -1;
	has_record_type = 0;
}

if( has_collection_type == 1 )
{
	collection_type_define_cnt = -1;
	collection_type_declare_cnt = -1;
	//collection_var_cnt = -1;
	has_collection_type = 0;
} 

variables_list_cnt = -1;
indent_count = 1;
}: 
        CREATE ( OR kREPLACE )? PROCEDURE ( schema_name=ID DOT )? procedure_name=ID
        {        
        String tmp = $procedure_name.getText();
        if(tmp.startsWith("\"")&&tmp.endsWith("\""))
        	tmp = tmp.substring(1, tmp.length() -1 );
        	
        output += "def " + tmp.toLowerCase() + "(tdw, ";}  
        ( LPAREN parameter_declaration ( COMMA parameter_declaration)* RPAREN 
       	{
       	int has_defaults = 0;
   	for(int i = 0; i <= parameter_list_count; i++)
 	{
  		if (parameter_list[i].contains("= None"))
 	   		has_defaults = 1;
 	}
  	if (has_defaults == 1) {
		for(int i = 0; i <= parameter_list_count; i++)
    		{
    			if (!parameter_list[i].contains("= None"))
    				parameter_list[i] += " = None";
    		}
   	}

       	if(parameter_list_count >= 0)
       	{
       		output += parameter_list[0];
       		for(int i = 1; i <= parameter_list_count; i++)
       		{
       			output += ", " + parameter_list[i];
       		}
       		parameter_list_count = -1;
       	}
       	}
        )?
        {output += ")";}
        {output += ":\n";
       	if(initial_statement_count >= 0)
       	{
       		for(int i = 0; i <= initial_statement_count; i++)
       		{
       			output += '\t' + initial_statement[i] + "\n";
       		}
       		initial_statement_count = -1;
       	}        
        }
        invoker_rights_clause?
        ( IS | AS )                
        ( {indent_count = 1;} declare_section? body
        | call_spec
        | EXTERNAL
        ) 
        {
        	for(int i = 0; i <= variables_list_cnt; i++ )
        	{
        		String reg = "(?i)" + variables_list[i];
        		String repl = variables_list[i].toLowerCase();
        		//output = output.replaceAll(reg, repl);
        	}	
        }
        SEMI
    ;	
   
create_function
@after{
if( has_record_type == 1 )
{
	record_define_cnt = -1;
	record_declare_cnt = -1;
	has_record_type = 0;
} 

if( has_collection_type == 1 )
{
	collection_type_define_cnt = -1;
	collection_type_declare_cnt = -1;
	//collection_var_cnt = -1;
	has_collection_type = 0;
}

variables_list_cnt = -1;
}:      
	CREATE ( OR kREPLACE )? FUNCTION ( schema_name=ID DOT )? function_name=ID
	{
        String tmp = $function_name.getText();
        if(tmp.startsWith("\"")&&tmp.endsWith("\""))
        	tmp = tmp.substring(1, tmp.length() -1 );
        	
        output += "def " + tmp.toLowerCase() + "(tdw, ";}  	
        ( LPAREN parameter_declaration ( COMMA  parameter_declaration )* RPAREN 
       	{
       	int has_defaults = 0;
   	for(int i = 0; i <= parameter_list_count; i++)
 	{
  		if (parameter_list[i].contains("= None"))
 	   		has_defaults = 1;
 	}
  	if (has_defaults == 1) {
		for(int i = 0; i <= parameter_list_count; i++)
    		{
    			if (!parameter_list[i].contains("= None"))
    				parameter_list[i] += " = None";
    		}
   	}
       	if(parameter_list_count >= 0)
       	{
       		output += parameter_list[0];
       		for(int i = 1; i <= parameter_list_count; i++)
       		{
       			output += ", " + parameter_list[i];
       		}
       		parameter_list_count = -1;
       	}
       	}        
        )?
        {output += ")";}
        {output += ":\n";
       	if(initial_statement_count >= 0)
       	{
       		for(int i = 0; i <= initial_statement_count; i++)
       		{
       			output += '\t' + initial_statement[i] + "\n";
       		}
       		initial_statement_count = -1;
       	}        
        }
        RETURN datatype
        invoker_rights_clause?
        ( IS | AS )           
        ( {indent_count = 1;} declare_section? body
        | call_spec
        | EXTERNAL
        )
        {
        	for(int i = 0; i <= variables_list_cnt; i++ )
        	{
        		String reg = "(?i)" + variables_list[i];
        		String repl = variables_list[i].toLowerCase();
        		//output = output.replaceAll(reg, repl);
        	}	
        }        
        SEMI         
    ;	    
   
invoker_rights_clause :
        AUTHID ( CURRENT_USER | DEFINER )
    ;

call_spec
    : LANGUAGE swallow_to_semi
    ;

kERRORS : {input.LT(1).getText().length() >= 3 && "errors".startsWith(input.LT(1).getText().toLowerCase())}? ID;
kEXCEPTIONS : {input.LT(1).getText().equalsIgnoreCase("exceptions")}? ID;
//kFOUND : {input.LT(1).getText().equalsIgnoreCase("found")}? ID;
kFOUND : FOUND;
FOUND	: 'found';	

kINDICES : {input.LT(1).getText().equalsIgnoreCase("indices")}? ID;
kMOD : {input.LT(1).getText().equalsIgnoreCase("mod")}? ID;
kNAME : {input.LT(1).getText().equalsIgnoreCase("name")}? ID;
kOF : 	{input.LT(1).getText().equalsIgnoreCase("of")}? ID;
kREPLACE : {input.LT(1).getText().equalsIgnoreCase("replace")}? ID;
kROWCOUNT : ROWCOUNT;
ROWCOUNT : 'rowcount';	 

kSAVE : {input.LT(1).getText().equalsIgnoreCase("save")}? ID;
kSHOW : {input.LT(1).getText().equalsIgnoreCase("show")}? ID;
kTYPE : {input.LT(1).getText().equalsIgnoreCase("type")}? ID;
kVALUES : {input.LT(1).getText().equalsIgnoreCase("values")}? ID;

AND	:	'and'	;
ARRAY : 'array' ;
AS : 'as' ;
AUTHID: 'authid';
BETWEEN : 'between' ;
BODY	:	'body';
BULK: 'bulk';
BULK_ROWCOUNT: 'bulk_rowcount';
BY	:	'by';
CASE: 'case';
CREATE: 'create';
COLLECT:	'collect';
COMMIT	:	'commit';
CURRENT_USER: 'current_user';
DBMS	:	'dbms_sql';
DEFAULT : 'default' ;
DEFINER: 'definer';
DELETE	:	'delete';
ELSE : 'else' ;
ELSIF	:	'elsif';
EXTERNAL:	'external';
FALSE	:	'false';
FETCH	:	'fetch';
FOR : 'for' ;
FORALL : 'forall' ;
GOTO	:	'goto';
IF	:	'if';
IN : 'in' ;
INDEX : 'index' ;
INSERT	:	'insert';
INTO	:	'into';
IS : 'is' ;
LANGUAGE:	'language';
LIKE : 'like' ;
LIMIT : 'limit' ;
LOCK	:	'lock';
NOT : 'not' ;
NOTFOUND:	'notfound';
NULL : 'null' ;
OPEN	:	'open';
OR : 'or' ;
PACKAGE: 'package';
RAISE	:	'raise';
ROLLBACK:	'rollback';
SAVEPOINT	:	'savepoint';
SELECT	:	'select'; 
SET	:	'set';
SQL	:	'sql';
TABLE	:	'table';
TRANSACTION	:	'transaction';
TRUE	:	'true';
THEN : 'then' ;
UPDATE	:	'update';
WHILE	:	'while';
INSERTING
	:	'inserting';
UPDATING:	'updating';
DELETING:	'deleting';
ISOPEN	:	'isopen';
EXISTS	:	'exists';

BEGIN	:	'begin'	;
CLOSE	:	'close';
CONSTANT	:	'constant'	;
CONTINUE:	'continue';
CURSOR	:	'cursor'	;
DECLARE	:	'declare'	;
DETERMINISTIC	: 'deterministic'	;
END	:	'end'	;
EXCEPTION	:	'exception'	;
EXECUTE	:	'execute';
EXIT	:	'exit';
FUNCTION	:	'function'	;
IMMEDIATE	:	'immediate';
LOOP	:	'loop';
MERGE	:	'merge';
NOCOPY	:	'nocopy'	;
OTHERS	:	'others'	;
OUT	:	'out'	;
PARALLEL_ENABLE	:	'parallel_enable';
PIPELINED	:	'pipelined'	;
PRAGMA	:	'pragma'	;
PROCEDURE	:	'procedure'	;
RECORD	:	'record'	;
REF	:	'ref'	;
RESULT_CACHE	:	'result_cache'	;
RETURN	:	'return'	;
RETURNING	:	'returning'	;
ROWTYPE	:	'rowtype';
SUBTYPE	:	'subtype'	;
USING:	'using'	;
VARRAY	:	'varray'	;
VARYING	:	'varying'	;
WHEN	:	'when'	;

QUOTED_STRING
	:	( 'n' )? '\'' ( '\'\'' | ~('\'') )* '\''
	;

ID
	:	( 'a' .. 'z' )
		( 'a' .. 'z' | '0' .. '9' | '_' | '$' | '#' )*
	|	DOUBLEQUOTED_STRING
	|	('\uB0A1' .. '\uF7FE')
	|	('\u4E00' .. '\u9FA5') 
	| 	('\uF900' .. '\uFA2D')
	;
SEMI
	:	';'
	;
COLON
	:	':'
	;
DOUBLEDOT
	:	POINT POINT
	;
DOT
	:	POINT
	;
fragment
POINT
	:	'.'
	;
COMMA
	:	(',')|('\uFF0C')
	;
EXPONENT
	:	'**'
	;
ASTERISK
	:	'*'
	;
AT_SIGN
	:	'@'
	;
RPAREN
	:	')'|'\uFF09'
	;
LPAREN
	:	'('|'\uFF08'
	;
RBRACK
	:	']'
	;
LBRACK
	:	'['
	;
PLUS
	:	'+'
	;
MINUS
	:	'-'
	;
DIVIDE
	:	'/'
	;
EQ
	:	'='
	;
PERCENT
	:	'%'
	;
LLABEL
	:	'<<'
	;
RLABEL
	:	'>>'
	;
ASSIGN
	:	':='
	;
ARROW
	:	'=>'
	;
VERTBAR
	:	'|'
	;
DOUBLEVERTBAR
	:	'||'
	;
NOT_EQ
	:	'<>' | '!=' | '~='| '^='
	;
LTH
	:	'<'
	;
LEQ
	:	'<='
	;
GTH
	:	'>'
	;
GEQ
	:	'>='
	;
INTEGER
    	:   N
    	;
REAL_NUMBER
	:	NUMBER_VALUE	( 'e' ( PLUS | MINUS )? N )?
	;
fragment
NUMBER_VALUE
	:	{numberDotValid()}?=> N POINT N?
	|	POINT N
	|	N
	;
fragment
N
	: '0' .. '9' ( '0' .. '9' )*
	;
fragment
DOUBLEQUOTED_STRING
	:	'"' ( ~('"') )* '"'
	;
WS	:	(' '|'\r'|'\t'|'\n' {row_count++;} |'\u3000') {$channel=HIDDEN;}
	;
SL_COMMENT
	:	'--' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;} 
	;
ML_COMMENT
	:	'/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
	;
	
SPOOL	:	'spool' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
	;
PROMPT	:	'prompt' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
	;