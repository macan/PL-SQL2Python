// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/macan/Private/pl2py/PLSQL.g 2013-10-26 13:48:39

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * Copyright (c) 2010,2011 Ma Can <ml.macana@gmail.com>
 *
 * We modified this gramma file to transform Oracle PL/SQL scripts to Python for TDW project. The target code
 * can ONLY run in a HIVE-like runtime environment.
 */
public class PLSQLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIVIDE", "SEMI", "PROCEDURE", "ID", "FUNCTION", "RETURN", "LPAREN", "COMMA", "RPAREN", "IN", "OUT", "NOCOPY", "ASSIGN", "DEFAULT", "CURSOR", "IS", "NOT", "NULL", "CONSTANT", "EXCEPTION", "SUBTYPE", "RECORD", "VARYING", "ARRAY", "VARRAY", "TABLE", "INDEX", "BY", "REF", "DOT", "PERCENT", "ROWTYPE", "DETERMINISTIC", "PIPELINED", "PARALLEL_ENABLE", "RESULT_CACHE", "AS", "BEGIN", "END", "WHEN", "OR", "OTHERS", "THEN", "COLON", "DBMS", "EXECUTE", "DELETE", "LOOP", "CASE", "ELSE", "CLOSE", "CONTINUE", "IMMEDIATE", "EXIT", "FETCH", "LIMIT", "INTO", "BULK", "COLLECT", "USING", "RETURNING", "FOR", "FORALL", "DOUBLEDOT", "BETWEEN", "AND", "GOTO", "IF", "ELSIF", "OPEN", "PRAGMA", "RAISE", "DECLARE", "LLABEL", "RLABEL", "COMMIT", "INSERT", "LOCK", "ROLLBACK", "SAVEPOINT", "SELECT", "SET", "TRANSACTION", "UPDATE", "MERGE", "WHILE", "EQ", "NOT_EQ", "LTH", "LEQ", "GTH", "GEQ", "LIKE", "MINUS", "PLUS", "DOUBLEVERTBAR", "ASTERISK", "EXPONENT", "SQL", "INTEGER", "BULK_ROWCOUNT", "ISOPEN", "NOTFOUND", "REAL_NUMBER", "TRUE", "FALSE", "QUOTED_STRING", "EXISTS", "INSERTING", "UPDATING", "DELETING", "ARROW", "CREATE", "PACKAGE", "BODY", "EXTERNAL", "AUTHID", "CURRENT_USER", "DEFINER", "LANGUAGE", "FOUND", "ROWCOUNT", "DOUBLEQUOTED_STRING", "POINT", "AT_SIGN", "RBRACK", "LBRACK", "VERTBAR", "N", "NUMBER_VALUE", "WS", "SL_COMMENT", "ML_COMMENT", "SPOOL", "PROMPT"
    };
    public static final int PACKAGE=117;
    public static final int FUNCTION=8;
    public static final int EXTERNAL=119;
    public static final int EXPONENT=101;
    public static final int WHILE=89;
    public static final int DETERMINISTIC=36;
    public static final int VARYING=26;
    public static final int CASE=52;
    public static final int DOUBLEDOT=67;
    public static final int NOT=20;
    public static final int SUBTYPE=24;
    public static final int EOF=-1;
    public static final int SQL=102;
    public static final int RPAREN=12;
    public static final int CREATE=116;
    public static final int INSERT=80;
    public static final int USING=63;
    public static final int RETURNING=64;
    public static final int PROMPT=138;
    public static final int BEGIN=41;
    public static final int LOOP=51;
    public static final int SAVEPOINT=83;
    public static final int RETURN=9;
    public static final int BODY=118;
    public static final int RAISE=75;
    public static final int GEQ=95;
    public static final int GOTO=70;
    public static final int EQ=90;
    public static final int DBMS=48;
    public static final int SELECT=84;
    public static final int ISOPEN=105;
    public static final int INTO=60;
    public static final int ARRAY=27;
    public static final int DIVIDE=4;
    public static final int EXCEPTION=23;
    public static final int SPOOL=137;
    public static final int RBRACK=129;
    public static final int EXIT=57;
    public static final int RECORD=25;
    public static final int N=132;
    public static final int TRANSACTION=86;
    public static final int NULL=21;
    public static final int ELSE=53;
    public static final int AT_SIGN=128;
    public static final int DEFINER=122;
    public static final int DELETE=50;
    public static final int DOUBLEVERTBAR=99;
    public static final int ROLLBACK=82;
    public static final int AUTHID=120;
    public static final int NOCOPY=15;
    public static final int WS=134;
    public static final int LANGUAGE=123;
    public static final int FETCH=58;
    public static final int OUT=14;
    public static final int REAL_NUMBER=107;
    public static final int PIPELINED=37;
    public static final int SL_COMMENT=135;
    public static final int OR=44;
    public static final int CONSTANT=22;
    public static final int ELSIF=72;
    public static final int END=42;
    public static final int FALSE=109;
    public static final int COLLECT=62;
    public static final int CURSOR=18;
    public static final int OTHERS=45;
    public static final int LBRACK=130;
    public static final int POINT=127;
    public static final int CURRENT_USER=121;
    public static final int LIMIT=59;
    public static final int EXECUTE=49;
    public static final int INSERTING=112;
    public static final int GTH=94;
    public static final int NOTFOUND=106;
    public static final int PRAGMA=74;
    public static final int RESULT_CACHE=39;
    public static final int TABLE=29;
    public static final int LLABEL=77;
    public static final int UPDATE=87;
    public static final int FOR=65;
    public static final int ID=7;
    public static final int AND=69;
    public static final int ASTERISK=100;
    public static final int LPAREN=10;
    public static final int LOCK=81;
    public static final int UPDATING=113;
    public static final int IF=71;
    public static final int RLABEL=78;
    public static final int ML_COMMENT=136;
    public static final int AS=40;
    public static final int INDEX=30;
    public static final int ROWTYPE=35;
    public static final int IN=13;
    public static final int THEN=46;
    public static final int CONTINUE=55;
    public static final int COMMA=11;
    public static final int IS=19;
    public static final int QUOTED_STRING=110;
    public static final int PLUS=98;
    public static final int EXISTS=111;
    public static final int DOT=33;
    public static final int ROWCOUNT=125;
    public static final int LIKE=96;
    public static final int INTEGER=103;
    public static final int BY=31;
    public static final int VARRAY=28;
    public static final int PARALLEL_ENABLE=38;
    public static final int PERCENT=34;
    public static final int DOUBLEQUOTED_STRING=126;
    public static final int MERGE=88;
    public static final int DEFAULT=17;
    public static final int FORALL=66;
    public static final int SET=85;
    public static final int MINUS=97;
    public static final int TRUE=108;
    public static final int SEMI=5;
    public static final int PROCEDURE=6;
    public static final int NOT_EQ=91;
    public static final int REF=32;
    public static final int VERTBAR=131;
    public static final int LTH=92;
    public static final int COLON=47;
    public static final int OPEN=73;
    public static final int BULK_ROWCOUNT=104;
    public static final int COMMIT=79;
    public static final int CLOSE=54;
    public static final int WHEN=43;
    public static final int FOUND=124;
    public static final int ASSIGN=16;
    public static final int NUMBER_VALUE=133;
    public static final int IMMEDIATE=56;
    public static final int ARROW=115;
    public static final int DECLARE=76;
    public static final int DELETING=114;
    public static final int BULK=61;
    public static final int BETWEEN=68;
    public static final int LEQ=93;

    // delegates
    // delegators


        public PLSQLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PLSQLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PLSQLParser.tokenNames; }
    public String getGrammarFileName() { return "/home/macan/Private/pl2py/PLSQL.g"; }



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




    // $ANTLR start "sqlplus_file"
    // /home/macan/Private/pl2py/PLSQL.g:232:1: sqlplus_file : ( create_object ( DIVIDE show_errors )? ( DIVIDE )? )+ EOF ;
    public final void sqlplus_file() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:313:1: ( ( create_object ( DIVIDE show_errors )? ( DIVIDE )? )+ EOF )
            // /home/macan/Private/pl2py/PLSQL.g:313:5: ( create_object ( DIVIDE show_errors )? ( DIVIDE )? )+ EOF
            {

            	String tmp = "# coding=gbk\n\n";
            	fops.write(tmp.getBytes());
            	
            // /home/macan/Private/pl2py/PLSQL.g:317:2: ( create_object ( DIVIDE show_errors )? ( DIVIDE )? )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==CREATE) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:317:4: create_object ( DIVIDE show_errors )? ( DIVIDE )?
            	    {
            	    pushFollow(FOLLOW_create_object_in_sqlplus_file58);
            	    create_object();

            	    state._fsp--;

            	    // /home/macan/Private/pl2py/PLSQL.g:317:18: ( DIVIDE show_errors )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==DIVIDE) ) {
            	        int LA1_1 = input.LA(2);

            	        if ( (LA1_1==ID) ) {
            	            alt1=1;
            	        }
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // /home/macan/Private/pl2py/PLSQL.g:317:20: DIVIDE show_errors
            	            {
            	            match(input,DIVIDE,FOLLOW_DIVIDE_in_sqlplus_file62); 
            	            pushFollow(FOLLOW_show_errors_in_sqlplus_file64);
            	            show_errors();

            	            state._fsp--;


            	            }
            	            break;

            	    }

            	    // /home/macan/Private/pl2py/PLSQL.g:317:42: ( DIVIDE )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==DIVIDE) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // /home/macan/Private/pl2py/PLSQL.g:317:42: DIVIDE
            	            {
            	            match(input,DIVIDE,FOLLOW_DIVIDE_in_sqlplus_file69); 

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_sqlplus_file75); 
            pkg_list_cnt = -1;

            }


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
            	System.out.println("Ratio of functions need to revise: " + (ratio) + "%");
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
        catch (RecognitionException re) {
            reportError(re);recover(input,re);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "sqlplus_file"


    // $ANTLR start "show_errors"
    // /home/macan/Private/pl2py/PLSQL.g:322:1: show_errors : kSHOW kERRORS ( SEMI )? ;
    public final void show_errors() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:323:5: ( kSHOW kERRORS ( SEMI )? )
            // /home/macan/Private/pl2py/PLSQL.g:323:7: kSHOW kERRORS ( SEMI )?
            {
            pushFollow(FOLLOW_kSHOW_in_show_errors121);
            kSHOW();

            state._fsp--;

            pushFollow(FOLLOW_kERRORS_in_show_errors123);
            kERRORS();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:323:21: ( SEMI )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==SEMI) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:323:21: SEMI
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_show_errors125); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "show_errors"


    // $ANTLR start "create_object"
    // /home/macan/Private/pl2py/PLSQL.g:326:1: create_object : ( create_package | create_package_body | create_function | create_procedure );
    public final void create_object() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:327:5: ( create_package | create_package_body | create_function | create_procedure )
            int alt5=4;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==CREATE) ) {
                switch ( input.LA(2) ) {
                case OR:
                    {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==ID) ) {
                        switch ( input.LA(4) ) {
                        case PROCEDURE:
                            {
                            alt5=4;
                            }
                            break;
                        case FUNCTION:
                            {
                            alt5=3;
                            }
                            break;
                        case PACKAGE:
                            {
                            int LA5_4 = input.LA(5);

                            if ( (LA5_4==BODY) ) {
                                alt5=2;
                            }
                            else if ( (LA5_4==ID) ) {
                                alt5=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 6, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case FUNCTION:
                    {
                    alt5=3;
                    }
                    break;
                case PACKAGE:
                    {
                    int LA5_4 = input.LA(3);

                    if ( (LA5_4==BODY) ) {
                        alt5=2;
                    }
                    else if ( (LA5_4==ID) ) {
                        alt5=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case PROCEDURE:
                    {
                    alt5=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:327:7: create_package
                    {
                    pushFollow(FOLLOW_create_package_in_create_object143);
                    create_package();

                    state._fsp--;

                     
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
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:339:7: create_package_body
                    {
                    pushFollow(FOLLOW_create_package_body_in_create_object156);
                    create_package_body();

                    state._fsp--;

                     output = "";

                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:340:7: create_function
                    {
                    pushFollow(FOLLOW_create_function_in_create_object166);
                    create_function();

                    state._fsp--;

                    fops.write(output.getBytes()); fops.write("\n\n".getBytes()); output = "";

                    }
                    break;
                case 4 :
                    // /home/macan/Private/pl2py/PLSQL.g:341:7: create_procedure
                    {
                    pushFollow(FOLLOW_create_procedure_in_create_object184);
                    create_procedure();

                    state._fsp--;

                    fops.write(output.getBytes()); fops.write("\n\n".getBytes()); output = "";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);recover(input,re);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "create_object"


    // $ANTLR start "procedure_heading"
    // /home/macan/Private/pl2py/PLSQL.g:346:1: procedure_heading : PROCEDURE ID ( parameter_declarations )? ;
    public final void procedure_heading() throws RecognitionException {
        Token ID1=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:346:19: ( PROCEDURE ID ( parameter_declarations )? )
            // /home/macan/Private/pl2py/PLSQL.g:347:9: PROCEDURE ID ( parameter_declarations )?
            {
            match(input,PROCEDURE,FOLLOW_PROCEDURE_in_procedure_heading225); 
            ID1=(Token)match(input,ID,FOLLOW_ID_in_procedure_heading227); 

                    String tmp = ID1.getText().toLowerCase();
                    if(tmp.startsWith("\"")&&tmp.endsWith("\""))
                    	tmp = tmp.substring(1, tmp.length() -1 );
                    	
                    output += "def " + tmp.toLowerCase() + "(tdw, ";
            // /home/macan/Private/pl2py/PLSQL.g:354:9: ( parameter_declarations )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LPAREN) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:354:9: parameter_declarations
                    {
                    pushFollow(FOLLOW_parameter_declarations_in_procedure_heading252);
                    parameter_declarations();

                    state._fsp--;


                    }
                    break;

            }

            output += __par; __par = "";
            output += ")";
            output += ":\n";
                	if(initial_statement_count >= 0)
                	{
                   		for(int i = 0; i <= initial_statement_count; i++)
                   		{
                   			output += '\t' + initial_statement[i] + "\n";
                   		}
                   		initial_statement_count = -1;
                	}        
                	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "procedure_heading"


    // $ANTLR start "function_heading"
    // /home/macan/Private/pl2py/PLSQL.g:368:1: function_heading : FUNCTION ID ( parameter_declarations )? RETURN datatype ;
    public final void function_heading() throws RecognitionException {
        Token ID2=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:368:18: ( FUNCTION ID ( parameter_declarations )? RETURN datatype )
            // /home/macan/Private/pl2py/PLSQL.g:369:9: FUNCTION ID ( parameter_declarations )? RETURN datatype
            {
            match(input,FUNCTION,FOLLOW_FUNCTION_in_function_heading303); 
            ID2=(Token)match(input,ID,FOLLOW_ID_in_function_heading305); 

                    String tmp = ID2.getText().toLowerCase();
                    if(tmp.startsWith("\"")&&tmp.endsWith("\""))
                    	tmp = tmp.substring(1, tmp.length() -1 );
                    	
                    output += "def " + tmp.toLowerCase() + "(tdw, ";
            // /home/macan/Private/pl2py/PLSQL.g:376:9: ( parameter_declarations )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LPAREN) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:376:9: parameter_declarations
                    {
                    pushFollow(FOLLOW_parameter_declarations_in_function_heading326);
                    parameter_declarations();

                    state._fsp--;


                    }
                    break;

            }

            output += __par; __par = "";
            output += ")";
            output += ":\n";
                	if(initial_statement_count >= 0)
                	{
                   		for(int i = 0; i <= initial_statement_count; i++)
                   		{
                   			output += '\t' + initial_statement[i] + "\n";
                   		}
                   		initial_statement_count = -1;
                	}        
                	
            match(input,RETURN,FOLLOW_RETURN_in_function_heading362); 
            pushFollow(FOLLOW_datatype_in_function_heading364);
            datatype();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "function_heading"


    // $ANTLR start "parameter_declarations"
    // /home/macan/Private/pl2py/PLSQL.g:391:1: parameter_declarations : ( LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN ) ;
    public final void parameter_declarations() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:391:24: ( ( LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN ) )
            // /home/macan/Private/pl2py/PLSQL.g:392:5: ( LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN )
            {
            // /home/macan/Private/pl2py/PLSQL.g:392:5: ( LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN )
            // /home/macan/Private/pl2py/PLSQL.g:392:7: LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_parameter_declarations383); 
            pushFollow(FOLLOW_parameter_declaration_in_parameter_declarations385);
            parameter_declaration();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:392:36: ( COMMA parameter_declaration )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==COMMA) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:392:38: COMMA parameter_declaration
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_parameter_declarations389); 
            	    pushFollow(FOLLOW_parameter_declaration_in_parameter_declarations391);
            	    parameter_declaration();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match(input,RPAREN,FOLLOW_RPAREN_in_parameter_declarations396); 

            }


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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "parameter_declarations"


    // $ANTLR start "parameter_declaration"
    // /home/macan/Private/pl2py/PLSQL.g:420:1: parameter_declaration : ID ( IN | ( ( OUT | IN OUT ) ( NOCOPY )? ) )? datatype ( ( ASSIGN | DEFAULT ) expression )? ;
    public final void parameter_declaration() throws RecognitionException {
        Token ID3=null;


        String id_name = "";
        int has_default = 0;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:438:1: ( ID ( IN | ( ( OUT | IN OUT ) ( NOCOPY )? ) )? datatype ( ( ASSIGN | DEFAULT ) expression )? )
            // /home/macan/Private/pl2py/PLSQL.g:439:9: ID ( IN | ( ( OUT | IN OUT ) ( NOCOPY )? ) )? datatype ( ( ASSIGN | DEFAULT ) expression )?
            {
            ID3=(Token)match(input,ID,FOLLOW_ID_in_parameter_declaration436); 
            id_name = ID3.getText().toLowerCase();
            // /home/macan/Private/pl2py/PLSQL.g:439:53: ( IN | ( ( OUT | IN OUT ) ( NOCOPY )? ) )?
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IN) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==OUT) ) {
                    alt11=2;
                }
                else if ( (LA11_1==ID||LA11_1==REF) ) {
                    alt11=1;
                }
            }
            else if ( (LA11_0==OUT) ) {
                alt11=2;
            }
            switch (alt11) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:439:55: IN
                    {
                    match(input,IN,FOLLOW_IN_in_parameter_declaration442); 

                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:439:60: ( ( OUT | IN OUT ) ( NOCOPY )? )
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:439:60: ( ( OUT | IN OUT ) ( NOCOPY )? )
                    // /home/macan/Private/pl2py/PLSQL.g:439:62: ( OUT | IN OUT ) ( NOCOPY )?
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:439:62: ( OUT | IN OUT )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==OUT) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==IN) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:439:64: OUT
                            {
                            match(input,OUT,FOLLOW_OUT_in_parameter_declaration450); 

                            }
                            break;
                        case 2 :
                            // /home/macan/Private/pl2py/PLSQL.g:439:70: IN OUT
                            {
                            match(input,IN,FOLLOW_IN_in_parameter_declaration454); 
                            match(input,OUT,FOLLOW_OUT_in_parameter_declaration456); 

                            }
                            break;

                    }

                    // /home/macan/Private/pl2py/PLSQL.g:439:79: ( NOCOPY )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==NOCOPY) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:439:79: NOCOPY
                            {
                            match(input,NOCOPY,FOLLOW_NOCOPY_in_parameter_declaration460); 

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            pushFollow(FOLLOW_datatype_in_parameter_declaration477);
            datatype();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:440:18: ( ( ASSIGN | DEFAULT ) expression )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=ASSIGN && LA13_0<=DEFAULT)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:440:20: ( ASSIGN | DEFAULT ) expression
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:440:20: ( ASSIGN | DEFAULT )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==ASSIGN) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==DEFAULT) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:440:22: ASSIGN
                            {
                            match(input,ASSIGN,FOLLOW_ASSIGN_in_parameter_declaration483); 
                            has_default = 1;

                            }
                            break;
                        case 2 :
                            // /home/macan/Private/pl2py/PLSQL.g:440:50: DEFAULT
                            {
                            match(input,DEFAULT,FOLLOW_DEFAULT_in_parameter_declaration489); 
                            has_default = 1;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_expression_in_parameter_declaration495);
                    expression();

                    state._fsp--;


                            	if (has_default == 0) {
                            		initial_statement_count++; 
                            		initial_statement[initial_statement_count] = ID3.getText().toLowerCase() + " = " + exp;
                            		exp = "";
                            	} else {
                            		initial_statement_count++; 
                            		initial_statement[initial_statement_count] = 
                            			"if " + ID3.getText().toLowerCase() + " == None: " + ID3.getText().toLowerCase() + " = " + exp;
                            		exp = "";
                            	}
                            

                    }
                    break;

            }


            }


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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "parameter_declaration"


    // $ANTLR start "declare_section"
    // /home/macan/Private/pl2py/PLSQL.g:456:1: declare_section : ( type_definition SEMI | subtype_definition SEMI | cursor_definition SEMI | item_declaration SEMI | function_declaration_or_definition SEMI | procedure_declaration_or_definition SEMI | pragma SEMI )+ ;
    public final void declare_section() throws RecognitionException {

        String xout = output;
        output = "";

        try {
            // /home/macan/Private/pl2py/PLSQL.g:464:1: ( ( type_definition SEMI | subtype_definition SEMI | cursor_definition SEMI | item_declaration SEMI | function_declaration_or_definition SEMI | procedure_declaration_or_definition SEMI | pragma SEMI )+ )
            // /home/macan/Private/pl2py/PLSQL.g:465:6: ( type_definition SEMI | subtype_definition SEMI | cursor_definition SEMI | item_declaration SEMI | function_declaration_or_definition SEMI | procedure_declaration_or_definition SEMI | pragma SEMI )+
            {
            // /home/macan/Private/pl2py/PLSQL.g:465:6: ( type_definition SEMI | subtype_definition SEMI | cursor_definition SEMI | item_declaration SEMI | function_declaration_or_definition SEMI | procedure_declaration_or_definition SEMI | pragma SEMI )+
            int cnt14=0;
            loop14:
            do {
                int alt14=8;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:465:8: type_definition SEMI
            	    {
            	    pushFollow(FOLLOW_type_definition_in_declare_section548);
            	    type_definition();

            	    state._fsp--;

            	    match(input,SEMI,FOLLOW_SEMI_in_declare_section550); 
            	    xout += output; output = "";

            	    }
            	    break;
            	case 2 :
            	    // /home/macan/Private/pl2py/PLSQL.g:466:8: subtype_definition SEMI
            	    {
            	    pushFollow(FOLLOW_subtype_definition_in_declare_section561);
            	    subtype_definition();

            	    state._fsp--;

            	    int start = input.LT(1).getTokenIndex();
            	    match(input,SEMI,FOLLOW_SEMI_in_declare_section577); 
            	    int end = input.LT(-1).getTokenIndex();
            	            int pos = end + 1;
            	            while(input.get(pos).getChannel() != 0)
            	            	pos++;
            	            end = pos - 1;
            	            xout += input.toString(start, end).toLowerCase();

            	    }
            	    break;
            	case 3 :
            	    // /home/macan/Private/pl2py/PLSQL.g:475:8: cursor_definition SEMI
            	    {
            	    pushFollow(FOLLOW_cursor_definition_in_declare_section593);
            	    cursor_definition();

            	    state._fsp--;

            	    match(input,SEMI,FOLLOW_SEMI_in_declare_section595); 
            	    xout += output; output = "";

            	    }
            	    break;
            	case 4 :
            	    // /home/macan/Private/pl2py/PLSQL.g:476:8: item_declaration SEMI
            	    {
            	    pushFollow(FOLLOW_item_declaration_in_declare_section606);
            	    item_declaration();

            	    state._fsp--;

            	    match(input,SEMI,FOLLOW_SEMI_in_declare_section608); 
            	    xout += output; output = "";

            	    }
            	    break;
            	case 5 :
            	    // /home/macan/Private/pl2py/PLSQL.g:477:8: function_declaration_or_definition SEMI
            	    {
            	    pushFollow(FOLLOW_function_declaration_or_definition_in_declare_section619);
            	    function_declaration_or_definition();

            	    state._fsp--;

            	    match(input,SEMI,FOLLOW_SEMI_in_declare_section621); 
            	    if (create_package == 0) xout += output; output = "";

            	    }
            	    break;
            	case 6 :
            	    // /home/macan/Private/pl2py/PLSQL.g:478:8: procedure_declaration_or_definition SEMI
            	    {
            	    pushFollow(FOLLOW_procedure_declaration_or_definition_in_declare_section632);
            	    procedure_declaration_or_definition();

            	    state._fsp--;

            	    match(input,SEMI,FOLLOW_SEMI_in_declare_section634); 
            	    if (create_package == 0) xout += output; output = "";

            	    }
            	    break;
            	case 7 :
            	    // /home/macan/Private/pl2py/PLSQL.g:479:8: pragma SEMI
            	    {
            	    pushFollow(FOLLOW_pragma_in_declare_section645);
            	    pragma();

            	    state._fsp--;

            	    match(input,SEMI,FOLLOW_SEMI_in_declare_section647); 
            	    xout += output; output = "";

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }


            output = xout;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "declare_section"


    // $ANTLR start "cursor_definition"
    // /home/macan/Private/pl2py/PLSQL.g:483:1: cursor_definition : CURSOR ID ( parameter_declarations )? IS select_statement ;
    public final void cursor_definition() throws RecognitionException {

        	String tmp = "";

        try {
            // /home/macan/Private/pl2py/PLSQL.g:491:1: ( CURSOR ID ( parameter_declarations )? IS select_statement )
            // /home/macan/Private/pl2py/PLSQL.g:492:2: CURSOR ID ( parameter_declarations )? IS select_statement
            {

            		String v_cursor = "";
                		output += "\t# FIXME: CURSOR DEFINITION\n";
            	
            match(input,CURSOR,FOLLOW_CURSOR_in_cursor_definition694); 
            match(input,ID,FOLLOW_ID_in_cursor_definition696); 
            v_cursor = input.LT(-1).getText().toLowerCase();
            __par = "";
            // /home/macan/Private/pl2py/PLSQL.g:496:84: ( parameter_declarations )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==LPAREN) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:496:84: parameter_declarations
                    {
                    pushFollow(FOLLOW_parameter_declarations_in_cursor_definition702);
                    parameter_declarations();

                    state._fsp--;


                    }
                    break;

            }


                    	if (__par == "") {
            			todo_count++;
                    	}
                    	__par = "";
                    
            match(input,IS,FOLLOW_IS_in_cursor_definition708); 
            pushFollow(FOLLOW_select_statement_in_cursor_definition710);
            select_statement();

            state._fsp--;


                    	tmp += "\t" + v_cursor + " = ({'isopen':0, 'sql':" + __sql + "})\n";
                    	__sql = "";
                    

            }


            	output += tmp + '\n';
                    stat = "";

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cursor_definition"


    // $ANTLR start "item_declaration"
    // /home/macan/Private/pl2py/PLSQL.g:508:1: item_declaration : ( ( ID datatype ( ( NOT NULL )? ( ASSIGN | DEFAULT ) ( expression | dbmsfunc_call ) )? ) | constant_declaration | exception_declaration );
    public final void item_declaration() throws RecognitionException {
        Token ID4=null;


        String indent = "";
        for (int i = 0; i < indent_count; i++)
        	indent += "\t";
        if (create_package == 1) {
        	indent = "";
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:520:5: ( ( ID datatype ( ( NOT NULL )? ( ASSIGN | DEFAULT ) ( expression | dbmsfunc_call ) )? ) | constant_declaration | exception_declaration )
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==ID) ) {
                switch ( input.LA(2) ) {
                case CONSTANT:
                    {
                    alt19=2;
                    }
                    break;
                case EXCEPTION:
                    {
                    alt19=3;
                    }
                    break;
                case ID:
                case REF:
                    {
                    alt19=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:520:7: ( ID datatype ( ( NOT NULL )? ( ASSIGN | DEFAULT ) ( expression | dbmsfunc_call ) )? )
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:520:7: ( ID datatype ( ( NOT NULL )? ( ASSIGN | DEFAULT ) ( expression | dbmsfunc_call ) )? )
                    // /home/macan/Private/pl2py/PLSQL.g:520:9: ID datatype ( ( NOT NULL )? ( ASSIGN | DEFAULT ) ( expression | dbmsfunc_call ) )?
                    {
                    ID4=(Token)match(input,ID,FOLLOW_ID_in_item_declaration760); 
                    int start = input.LT(1).getTokenIndex();
                    pushFollow(FOLLOW_datatype_in_item_declaration773);
                    datatype();

                    state._fsp--;


                        int emit = 1;
                        int end = input.LT(-1).getTokenIndex();
                        String datatype_string = input.toString(start, end).toLowerCase();
                        if( has_record_type == 1 )
                        {
                        	for(int i = 0; i <= record_define_cnt; i++)
                        	{
                        		if( datatype_string.equalsIgnoreCase(record_define[i]))
                        		{
                        			output += indent + ID4.getText().toLowerCase() + " = " + record_define[i] + "()\n"; 
                        			record_declare_cnt++;
                        			record_declare[record_declare_cnt] = ID4.getText().toLowerCase();
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
                        			output += indent + ID4.getText().toLowerCase() + " = " + collection_type_define[i] + "()\n"; 
                        			collection_type_declare_cnt++;
                        			collection_type_declare[collection_type_declare_cnt] = ID4.getText().toLowerCase();
                        			
                        			collection_var_cnt++;
                        			collection_variables[collection_var_cnt] = ID4.getText().toLowerCase();
                        			emit = 0;
                        			break;
                        		}
                        	}
                        }
                        
                        if( datatype_string.contains("%") ) 
                        {
                        	String[] tmp = datatype_string.split("%");
                        	String class_name = "";
                        	if( tmp[1].equalsIgnoreCase("rowtype"))
                        	{
                        		class_name = ID4.getText().toLowerCase();
                        		output += "\n" + indent + "class " + class_name.toUpperCase() + ":\n";
                        		output += indent + "\tpass\n";
                        		output += indent + class_name + " = " + class_name.toUpperCase() + "()\n";
                        		output += indent + "rowtype_sql = \"describe " + tmp[0] + "\"\n";
                        		output += indent + "res = tdw.execute(rowtype_sql)\n";
                        		output += indent + "for tmp in res:\n";
                        		output += indent + "\t" + ID4.getText().toLowerCase() + ".__dict__[tmp.split()[0]] = None\n";
                        		output += "\n"; 
                        		has_collection_type = 1;
                        		collection_var_cnt++;
                        		collection_variables[collection_var_cnt] = ID4.getText().toLowerCase();
                        		emit = 0;	
                        	} else if (tmp[1].equalsIgnoreCase("type")) {
                        		output += indent + "# FIXME: %type is not supported, you have to rewrite it!\n";
                        		output += indent + ID4.getText().toLowerCase() + " = dynamic_type()\n";
                        		has_collection_type = 1;
                        		collection_var_cnt++;
                        		collection_variables[collection_var_cnt] = ID4.getText().toLowerCase();
                        		emit = 0;
                        	}
                        }
                        if (datatype_string.toLowerCase().contains("number")) {
                        	output += indent + ID4.getText().toLowerCase() + " = int()\n";
                        	emit = 0;
                        } else if (datatype_string.toLowerCase().contains("smallint")) {
                        	output += indent +  ID4.getText().toLowerCase() + " = int()\n";
                        	emit = 0;
                        } else if (datatype_string.toLowerCase().contains("date")) {
                        	output += indent +  ID4.getText().toLowerCase() + " = Dateclass()\n";
                        	emit = 0;
                        }
                        

                        if (emit == 1) {
                        	output += indent +  ID4.getText().toLowerCase() + " = None\n";
                        }
                        exp = "";
                        variables_list_cnt++;
                        variables_list[variables_list_cnt]  = ID4.getText().toLowerCase(); 
                        
                    // /home/macan/Private/pl2py/PLSQL.g:606:6: ( ( NOT NULL )? ( ASSIGN | DEFAULT ) ( expression | dbmsfunc_call ) )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( ((LA18_0>=ASSIGN && LA18_0<=DEFAULT)||LA18_0==NOT) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:606:8: ( NOT NULL )? ( ASSIGN | DEFAULT ) ( expression | dbmsfunc_call )
                            {
                            // /home/macan/Private/pl2py/PLSQL.g:606:8: ( NOT NULL )?
                            int alt16=2;
                            int LA16_0 = input.LA(1);

                            if ( (LA16_0==NOT) ) {
                                alt16=1;
                            }
                            switch (alt16) {
                                case 1 :
                                    // /home/macan/Private/pl2py/PLSQL.g:606:10: NOT NULL
                                    {
                                    match(input,NOT,FOLLOW_NOT_in_item_declaration791); 
                                    match(input,NULL,FOLLOW_NULL_in_item_declaration793); 

                                    }
                                    break;

                            }

                            if ( (input.LA(1)>=ASSIGN && input.LA(1)<=DEFAULT) ) {
                                input.consume();
                                state.errorRecovery=false;
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            // /home/macan/Private/pl2py/PLSQL.g:606:45: ( expression | dbmsfunc_call )
                            int alt17=2;
                            int LA17_0 = input.LA(1);

                            if ( (LA17_0==ID||LA17_0==LPAREN||(LA17_0>=NOT && LA17_0<=NULL)||LA17_0==COLON||(LA17_0>=MINUS && LA17_0<=PLUS)||(LA17_0>=SQL && LA17_0<=INTEGER)||(LA17_0>=REAL_NUMBER && LA17_0<=QUOTED_STRING)||(LA17_0>=INSERTING && LA17_0<=DELETING)) ) {
                                alt17=1;
                            }
                            else if ( (LA17_0==DBMS) ) {
                                alt17=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 17, 0, input);

                                throw nvae;
                            }
                            switch (alt17) {
                                case 1 :
                                    // /home/macan/Private/pl2py/PLSQL.g:606:47: expression
                                    {
                                    pushFollow(FOLLOW_expression_in_item_declaration812);
                                    expression();

                                    state._fsp--;

                                    output += indent + ID4.getText().toLowerCase() + " = " + exp + '\n'; 

                                    }
                                    break;
                                case 2 :
                                    // /home/macan/Private/pl2py/PLSQL.g:608:7: dbmsfunc_call
                                    {
                                    pushFollow(FOLLOW_dbmsfunc_call_in_item_declaration826);
                                    dbmsfunc_call();

                                    state._fsp--;


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:609:7: constant_declaration
                    {
                    pushFollow(FOLLOW_constant_declaration_in_item_declaration841);
                    constant_declaration();

                    state._fsp--;


                        output += indent + "# FIXME: Constant declaration";
                        todo_count++;
                        

                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:614:7: exception_declaration
                    {
                    pushFollow(FOLLOW_exception_declaration_in_item_declaration855);
                    exception_declaration();

                    state._fsp--;


                        output += indent +  exp.toLowerCase() + " = None # This is an exception!\n";
                        exp = "";
                        

                    }
                    break;

            }

            exp = "";

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "item_declaration"


    // $ANTLR start "constant_declaration"
    // /home/macan/Private/pl2py/PLSQL.g:622:1: constant_declaration : ID CONSTANT datatype ( NOT NULL )? ( ASSIGN | DEFAULT ) expression ;
    public final void constant_declaration() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:622:22: ( ID CONSTANT datatype ( NOT NULL )? ( ASSIGN | DEFAULT ) expression )
            // /home/macan/Private/pl2py/PLSQL.g:623:9: ID CONSTANT datatype ( NOT NULL )? ( ASSIGN | DEFAULT ) expression
            {
            match(input,ID,FOLLOW_ID_in_constant_declaration887); 
            match(input,CONSTANT,FOLLOW_CONSTANT_in_constant_declaration889); 
            pushFollow(FOLLOW_datatype_in_constant_declaration891);
            datatype();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:623:30: ( NOT NULL )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==NOT) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:623:32: NOT NULL
                    {
                    match(input,NOT,FOLLOW_NOT_in_constant_declaration895); 
                    match(input,NULL,FOLLOW_NULL_in_constant_declaration897); 

                    }
                    break;

            }

            if ( (input.LA(1)>=ASSIGN && input.LA(1)<=DEFAULT) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_expression_in_constant_declaration916);
            expression();

            state._fsp--;


                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "constant_declaration"


    // $ANTLR start "exception_declaration"
    // /home/macan/Private/pl2py/PLSQL.g:628:1: exception_declaration : ID EXCEPTION ;
    public final void exception_declaration() throws RecognitionException {
        Token ID5=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:628:23: ( ID EXCEPTION )
            // /home/macan/Private/pl2py/PLSQL.g:629:9: ID EXCEPTION
            {
            ID5=(Token)match(input,ID,FOLLOW_ID_in_exception_declaration947); 
            match(input,EXCEPTION,FOLLOW_EXCEPTION_in_exception_declaration949); 

                    exp = ID5.getText().toLowerCase();
                    variables_list_cnt++;
                	variables_list[variables_list_cnt]  = ID5.getText().toLowerCase(); 
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "exception_declaration"


    // $ANTLR start "type_definition"
    // /home/macan/Private/pl2py/PLSQL.g:636:1: type_definition : kTYPE ID IS ( record_type_definition[$ID.getText().toLowerCase()] | collection_type_definition[$ID.getText().toLowerCase()] | ref_cursor_type_definition ) ;
    public final void type_definition() throws RecognitionException {
        Token ID6=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:636:17: ( kTYPE ID IS ( record_type_definition[$ID.getText().toLowerCase()] | collection_type_definition[$ID.getText().toLowerCase()] | ref_cursor_type_definition ) )
            // /home/macan/Private/pl2py/PLSQL.g:637:6: kTYPE ID IS ( record_type_definition[$ID.getText().toLowerCase()] | collection_type_definition[$ID.getText().toLowerCase()] | ref_cursor_type_definition )
            {
            pushFollow(FOLLOW_kTYPE_in_type_definition973);
            kTYPE();

            state._fsp--;

            ID6=(Token)match(input,ID,FOLLOW_ID_in_type_definition975); 
            match(input,IS,FOLLOW_IS_in_type_definition977); 
            // /home/macan/Private/pl2py/PLSQL.g:637:18: ( record_type_definition[$ID.getText().toLowerCase()] | collection_type_definition[$ID.getText().toLowerCase()] | ref_cursor_type_definition )
            int alt21=3;
            switch ( input.LA(1) ) {
            case RECORD:
                {
                alt21=1;
                }
                break;
            case VARYING:
            case VARRAY:
            case TABLE:
                {
                alt21=2;
                }
                break;
            case REF:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:637:20: record_type_definition[$ID.getText().toLowerCase()]
                    {
                    pushFollow(FOLLOW_record_type_definition_in_type_definition981);
                    record_type_definition(ID6.getText().toLowerCase());

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:637:74: collection_type_definition[$ID.getText().toLowerCase()]
                    {
                    pushFollow(FOLLOW_collection_type_definition_in_type_definition986);
                    collection_type_definition(ID6.getText().toLowerCase());

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:637:132: ref_cursor_type_definition
                    {
                    pushFollow(FOLLOW_ref_cursor_type_definition_in_type_definition991);
                    ref_cursor_type_definition();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "type_definition"


    // $ANTLR start "subtype_definition"
    // /home/macan/Private/pl2py/PLSQL.g:640:1: subtype_definition : SUBTYPE ID IS datatype ( NOT NULL )? ;
    public final void subtype_definition() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:640:20: ( SUBTYPE ID IS datatype ( NOT NULL )? )
            // /home/macan/Private/pl2py/PLSQL.g:641:2: SUBTYPE ID IS datatype ( NOT NULL )?
            {
            int start = input.LT(1).getTokenIndex();
            match(input,SUBTYPE,FOLLOW_SUBTYPE_in_subtype_definition1022); 
            match(input,ID,FOLLOW_ID_in_subtype_definition1024); 
            match(input,IS,FOLLOW_IS_in_subtype_definition1026); 
            int end = input.LT(-1).getTokenIndex();
                    int pos = end + 1;
                    while(input.get(pos).getChannel() != 0)
                    	pos++;
                    end = pos - 1;
                    output += input.toString(start, end).toLowerCase();
            pushFollow(FOLLOW_datatype_in_subtype_definition1056);
            datatype();

            state._fsp--;

            start = input.LT(1).getTokenIndex();
            // /home/macan/Private/pl2py/PLSQL.g:651:9: ( NOT NULL )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==NOT) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:651:11: NOT NULL
                    {
                    match(input,NOT,FOLLOW_NOT_in_subtype_definition1079); 
                    match(input,NULL,FOLLOW_NULL_in_subtype_definition1081); 

                    }
                    break;

            }

            end = input.LT(-1).getTokenIndex();
                    pos = end + 1;
                    while(input.get(pos).getChannel() != 0)
                    	pos++;
                    end = pos - 1;
                    output += input.toString(start, end).toLowerCase();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "subtype_definition"


    // $ANTLR start "record_type_definition"
    // /home/macan/Private/pl2py/PLSQL.g:660:1: record_type_definition[String classname] : RECORD LPAREN record_field_declaration ( COMMA record_field_declaration )* RPAREN ;
    public final void record_type_definition(String classname) throws RecognitionException {

        	int __idx = 0;
        	String init_func = "";
        	indent_count = 1;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:670:1: ( RECORD LPAREN record_field_declaration ( COMMA record_field_declaration )* RPAREN )
            // /home/macan/Private/pl2py/PLSQL.g:671:2: RECORD LPAREN record_field_declaration ( COMMA record_field_declaration )* RPAREN
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
            	
            match(input,RECORD,FOLLOW_RECORD_in_record_type_definition1133); 
            match(input,LPAREN,FOLLOW_LPAREN_in_record_type_definition1135); 

            		for(int i = 0; i < indent_count; i++)
            		{	
            			output += '\t';
            			init_func += '\t';
            		}
            		init_func += '\t';
            	
            pushFollow(FOLLOW_record_field_declaration_in_record_type_definition1142);
            record_field_declaration();

            state._fsp--;


            		output += exp.toLowerCase() + " = None\n";
            		init_func += "\tself." + exp.toLowerCase() + " = l[" + __idx + "]\n";
            		exp = "";
            	
            // /home/macan/Private/pl2py/PLSQL.g:705:2: ( COMMA record_field_declaration )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==COMMA) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:705:4: COMMA record_field_declaration
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_record_type_definition1151); 

            	    		for(int i = 0; i < indent_count; i++)
            	    		{	
            	    			output += '\t';
            	    			init_func += '\t';
            	    		}
            	    		init_func += '\t';
            	    	
            	    pushFollow(FOLLOW_record_field_declaration_in_record_type_definition1159);
            	    record_field_declaration();

            	    state._fsp--;


            	    		__idx++;
            	    		output += exp.toLowerCase() + " = None\n";
            	    		init_func += "\tself." + exp.toLowerCase() + " = l[" + __idx + "]\n";
            	    		exp = "";
            	    	

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            match(input,RPAREN,FOLLOW_RPAREN_in_record_type_definition1171); 
            init_func += '\n';

            }


            	output += init_func;
            	indent_count = 1;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "record_type_definition"


    // $ANTLR start "record_field_declaration"
    // /home/macan/Private/pl2py/PLSQL.g:725:1: record_field_declaration : ID datatype ( ( NOT NULL )? ( ASSIGN | DEFAULT ) expression )? ;
    public final void record_field_declaration() throws RecognitionException {
        Token ID7=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:725:26: ( ID datatype ( ( NOT NULL )? ( ASSIGN | DEFAULT ) expression )? )
            // /home/macan/Private/pl2py/PLSQL.g:726:2: ID datatype ( ( NOT NULL )? ( ASSIGN | DEFAULT ) expression )?
            {
            ID7=(Token)match(input,ID,FOLLOW_ID_in_record_field_declaration1192); 
            pushFollow(FOLLOW_datatype_in_record_field_declaration1194);
            datatype();

            state._fsp--;

            exp = ID7.getText().toLowerCase();
            // /home/macan/Private/pl2py/PLSQL.g:726:51: ( ( NOT NULL )? ( ASSIGN | DEFAULT ) expression )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=ASSIGN && LA25_0<=DEFAULT)||LA25_0==NOT) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:726:53: ( NOT NULL )? ( ASSIGN | DEFAULT ) expression
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:726:53: ( NOT NULL )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==NOT) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:726:55: NOT NULL
                            {
                            match(input,NOT,FOLLOW_NOT_in_record_field_declaration1202); 
                            match(input,NULL,FOLLOW_NULL_in_record_field_declaration1204); 

                            }
                            break;

                    }

                    if ( (input.LA(1)>=ASSIGN && input.LA(1)<=DEFAULT) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_expression_in_record_field_declaration1219);
                    expression();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "record_field_declaration"


    // $ANTLR start "collection_type_definition"
    // /home/macan/Private/pl2py/PLSQL.g:729:1: collection_type_definition[String name] : ( varray_type_definition | nested_table_type_definition );
    public final void collection_type_definition(String name) throws RecognitionException {

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

        try {
            // /home/macan/Private/pl2py/PLSQL.g:762:2: ( varray_type_definition | nested_table_type_definition )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==VARYING||LA26_0==VARRAY) ) {
                alt26=1;
            }
            else if ( (LA26_0==TABLE) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:762:4: varray_type_definition
                    {
                    pushFollow(FOLLOW_varray_type_definition_in_collection_type_definition1249);
                    varray_type_definition();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:763:4: nested_table_type_definition
                    {
                    pushFollow(FOLLOW_nested_table_type_definition_in_collection_type_definition1254);
                    nested_table_type_definition();

                    state._fsp--;


                    }
                    break;

            }

            indent_count = 1;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "collection_type_definition"


    // $ANTLR start "varray_type_definition"
    // /home/macan/Private/pl2py/PLSQL.g:766:1: varray_type_definition : ( VARYING ( ARRAY )? | VARRAY ) LPAREN numeric_literal RPAREN kOF datatype ( NOT NULL )? ;
    public final void varray_type_definition() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:767:5: ( ( VARYING ( ARRAY )? | VARRAY ) LPAREN numeric_literal RPAREN kOF datatype ( NOT NULL )? )
            // /home/macan/Private/pl2py/PLSQL.g:767:7: ( VARYING ( ARRAY )? | VARRAY ) LPAREN numeric_literal RPAREN kOF datatype ( NOT NULL )?
            {
            // /home/macan/Private/pl2py/PLSQL.g:767:7: ( VARYING ( ARRAY )? | VARRAY )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==VARYING) ) {
                alt28=1;
            }
            else if ( (LA28_0==VARRAY) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:767:9: VARYING ( ARRAY )?
                    {
                    match(input,VARYING,FOLLOW_VARYING_in_varray_type_definition1270); 
                    // /home/macan/Private/pl2py/PLSQL.g:767:17: ( ARRAY )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==ARRAY) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:767:17: ARRAY
                            {
                            match(input,ARRAY,FOLLOW_ARRAY_in_varray_type_definition1272); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:767:26: VARRAY
                    {
                    match(input,VARRAY,FOLLOW_VARRAY_in_varray_type_definition1277); 

                    }
                    break;

            }

            match(input,LPAREN,FOLLOW_LPAREN_in_varray_type_definition1281); 
            pushFollow(FOLLOW_numeric_literal_in_varray_type_definition1283);
            numeric_literal();

            state._fsp--;

            match(input,RPAREN,FOLLOW_RPAREN_in_varray_type_definition1285); 
            pushFollow(FOLLOW_kOF_in_varray_type_definition1287);
            kOF();

            state._fsp--;

            pushFollow(FOLLOW_datatype_in_varray_type_definition1289);
            datatype();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:767:78: ( NOT NULL )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==NOT) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:767:80: NOT NULL
                    {
                    match(input,NOT,FOLLOW_NOT_in_varray_type_definition1293); 
                    match(input,NULL,FOLLOW_NULL_in_varray_type_definition1295); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "varray_type_definition"


    // $ANTLR start "nested_table_type_definition"
    // /home/macan/Private/pl2py/PLSQL.g:770:1: nested_table_type_definition : TABLE kOF datatype ( NOT NULL )? ( INDEX BY associative_index_type )? ;
    public final void nested_table_type_definition() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:771:5: ( TABLE kOF datatype ( NOT NULL )? ( INDEX BY associative_index_type )? )
            // /home/macan/Private/pl2py/PLSQL.g:771:7: TABLE kOF datatype ( NOT NULL )? ( INDEX BY associative_index_type )?
            {
            match(input,TABLE,FOLLOW_TABLE_in_nested_table_type_definition1318); 
            pushFollow(FOLLOW_kOF_in_nested_table_type_definition1320);
            kOF();

            state._fsp--;

            pushFollow(FOLLOW_datatype_in_nested_table_type_definition1322);
            datatype();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:771:26: ( NOT NULL )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==NOT) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:771:28: NOT NULL
                    {
                    match(input,NOT,FOLLOW_NOT_in_nested_table_type_definition1326); 
                    match(input,NULL,FOLLOW_NULL_in_nested_table_type_definition1328); 

                    }
                    break;

            }

            // /home/macan/Private/pl2py/PLSQL.g:771:40: ( INDEX BY associative_index_type )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==INDEX) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:771:42: INDEX BY associative_index_type
                    {
                    match(input,INDEX,FOLLOW_INDEX_in_nested_table_type_definition1335); 
                    match(input,BY,FOLLOW_BY_in_nested_table_type_definition1337); 
                    pushFollow(FOLLOW_associative_index_type_in_nested_table_type_definition1339);
                    associative_index_type();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "nested_table_type_definition"


    // $ANTLR start "associative_index_type"
    // /home/macan/Private/pl2py/PLSQL.g:774:1: associative_index_type : datatype ;
    public final void associative_index_type() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:775:5: ( datatype )
            // /home/macan/Private/pl2py/PLSQL.g:775:7: datatype
            {
            pushFollow(FOLLOW_datatype_in_associative_index_type1360);
            datatype();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "associative_index_type"


    // $ANTLR start "ref_cursor_type_definition"
    // /home/macan/Private/pl2py/PLSQL.g:778:1: ref_cursor_type_definition : REF CURSOR ( RETURN datatype )? ;
    public final void ref_cursor_type_definition() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:779:5: ( REF CURSOR ( RETURN datatype )? )
            // /home/macan/Private/pl2py/PLSQL.g:780:5: REF CURSOR ( RETURN datatype )?
            {
            int start = input.LT(1).getTokenIndex();
                	output += "\n\t# FIXME: REF CURSOR TYPE DEFINITION\n";
                	output += "\t\"\"\"\n";
                	
            match(input,REF,FOLLOW_REF_in_ref_cursor_type_definition1388); 
            match(input,CURSOR,FOLLOW_CURSOR_in_ref_cursor_type_definition1390); 
            // /home/macan/Private/pl2py/PLSQL.g:784:16: ( RETURN datatype )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RETURN) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:784:18: RETURN datatype
                    {
                    match(input,RETURN,FOLLOW_RETURN_in_ref_cursor_type_definition1394); 
                    pushFollow(FOLLOW_datatype_in_ref_cursor_type_definition1396);
                    datatype();

                    state._fsp--;


                    }
                    break;

            }

            int end = input.LT(-1).getTokenIndex();
                    int pos = end + 1;
                    while(input.get(pos).getChannel() != 0)
                    	pos++;
                    end = pos - 1;
                    String tmp = input.toString(start, end).toLowerCase();
                    int length = tmp.length();

                    output += tmp + '\n';
                    output += "\t\"\"\"\n";
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ref_cursor_type_definition"


    // $ANTLR start "datatype"
    // /home/macan/Private/pl2py/PLSQL.g:799:1: datatype : ( REF )? ID ( DOT ID )? ( LPAREN numeric_literal ( COMMA numeric_literal )* RPAREN | PERCENT ( kTYPE | ROWTYPE ) )? ;
    public final void datatype() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:800:5: ( ( REF )? ID ( DOT ID )? ( LPAREN numeric_literal ( COMMA numeric_literal )* RPAREN | PERCENT ( kTYPE | ROWTYPE ) )? )
            // /home/macan/Private/pl2py/PLSQL.g:800:7: ( REF )? ID ( DOT ID )? ( LPAREN numeric_literal ( COMMA numeric_literal )* RPAREN | PERCENT ( kTYPE | ROWTYPE ) )?
            {
            // /home/macan/Private/pl2py/PLSQL.g:800:7: ( REF )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==REF) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:800:9: REF
                    {
                    match(input,REF,FOLLOW_REF_in_datatype1429); 

                    }
                    break;

            }

            match(input,ID,FOLLOW_ID_in_datatype1434); 
            // /home/macan/Private/pl2py/PLSQL.g:800:19: ( DOT ID )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==DOT) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:800:21: DOT ID
                    {
                    match(input,DOT,FOLLOW_DOT_in_datatype1438); 
                    match(input,ID,FOLLOW_ID_in_datatype1440); 

                    }
                    break;

            }

            // /home/macan/Private/pl2py/PLSQL.g:800:31: ( LPAREN numeric_literal ( COMMA numeric_literal )* RPAREN | PERCENT ( kTYPE | ROWTYPE ) )?
            int alt37=3;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==LPAREN) ) {
                alt37=1;
            }
            else if ( (LA37_0==PERCENT) ) {
                alt37=2;
            }
            switch (alt37) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:800:33: LPAREN numeric_literal ( COMMA numeric_literal )* RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_datatype1447); 
                    pushFollow(FOLLOW_numeric_literal_in_datatype1449);
                    numeric_literal();

                    state._fsp--;

                    // /home/macan/Private/pl2py/PLSQL.g:800:56: ( COMMA numeric_literal )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==COMMA) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // /home/macan/Private/pl2py/PLSQL.g:800:58: COMMA numeric_literal
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_datatype1453); 
                    	    pushFollow(FOLLOW_numeric_literal_in_datatype1455);
                    	    numeric_literal();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);

                    match(input,RPAREN,FOLLOW_RPAREN_in_datatype1460); 

                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:800:92: PERCENT ( kTYPE | ROWTYPE )
                    {
                    match(input,PERCENT,FOLLOW_PERCENT_in_datatype1464); 
                    // /home/macan/Private/pl2py/PLSQL.g:800:100: ( kTYPE | ROWTYPE )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==ID) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==ROWTYPE) ) {
                        alt36=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:800:102: kTYPE
                            {
                            pushFollow(FOLLOW_kTYPE_in_datatype1468);
                            kTYPE();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // /home/macan/Private/pl2py/PLSQL.g:800:110: ROWTYPE
                            {
                            match(input,ROWTYPE,FOLLOW_ROWTYPE_in_datatype1472); 

                            }
                            break;

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "datatype"


    // $ANTLR start "function_declaration_or_definition"
    // /home/macan/Private/pl2py/PLSQL.g:803:1: function_declaration_or_definition : function_heading ( DETERMINISTIC | PIPELINED | PARALLEL_ENABLE | RESULT_CACHE )* ( ( IS | AS ) ( declare_section )? body )? ;
    public final void function_declaration_or_definition() throws RecognitionException {

        int saved_cp = create_package;
        create_package = 0;
        indent_count = 1;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:812:2: ( function_heading ( DETERMINISTIC | PIPELINED | PARALLEL_ENABLE | RESULT_CACHE )* ( ( IS | AS ) ( declare_section )? body )? )
            // /home/macan/Private/pl2py/PLSQL.g:813:9: function_heading ( DETERMINISTIC | PIPELINED | PARALLEL_ENABLE | RESULT_CACHE )* ( ( IS | AS ) ( declare_section )? body )?
            {
            pushFollow(FOLLOW_function_heading_in_function_declaration_or_definition1509);
            function_heading();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:814:9: ( DETERMINISTIC | PIPELINED | PARALLEL_ENABLE | RESULT_CACHE )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=DETERMINISTIC && LA38_0<=RESULT_CACHE)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:
            	    {
            	    if ( (input.LA(1)>=DETERMINISTIC && input.LA(1)<=RESULT_CACHE) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            // /home/macan/Private/pl2py/PLSQL.g:815:9: ( ( IS | AS ) ( declare_section )? body )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==IS||LA40_0==AS) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:815:11: ( IS | AS ) ( declare_section )? body
                    {
                    if ( input.LA(1)==IS||input.LA(1)==AS ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    // /home/macan/Private/pl2py/PLSQL.g:815:23: ( declare_section )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( ((LA39_0>=PROCEDURE && LA39_0<=FUNCTION)||LA39_0==CURSOR||LA39_0==SUBTYPE||LA39_0==PRAGMA) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:815:23: declare_section
                            {
                            pushFollow(FOLLOW_declare_section_in_function_declaration_or_definition1560);
                            declare_section();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_body_in_function_declaration_or_definition1563);
                    body();

                    state._fsp--;



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
                    break;

            }


            }


            variables_list_cnt = -1;
            create_package = saved_cp;

        }
        catch (RecognitionException re) {
            reportError(re);recover(input,re);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "function_declaration_or_definition"


    // $ANTLR start "procedure_declaration_or_definition"
    // /home/macan/Private/pl2py/PLSQL.g:846:1: procedure_declaration_or_definition : procedure_heading ( ( IS | AS ) ( declare_section )? body )? ;
    public final void procedure_declaration_or_definition() throws RecognitionException {

        int saved_cp = create_package;
        create_package = 0;
        indent_count = 1;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:855:2: ( procedure_heading ( ( IS | AS ) ( declare_section )? body )? )
            // /home/macan/Private/pl2py/PLSQL.g:856:9: procedure_heading ( ( IS | AS ) ( declare_section )? body )?
            {
            pushFollow(FOLLOW_procedure_heading_in_procedure_declaration_or_definition1630);
            procedure_heading();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:857:9: ( ( IS | AS ) ( declare_section )? body )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==IS||LA42_0==AS) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:857:11: ( IS | AS ) ( declare_section )? body
                    {
                    if ( input.LA(1)==IS||input.LA(1)==AS ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    // /home/macan/Private/pl2py/PLSQL.g:857:23: ( declare_section )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( ((LA41_0>=PROCEDURE && LA41_0<=FUNCTION)||LA41_0==CURSOR||LA41_0==SUBTYPE||LA41_0==PRAGMA) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:857:23: declare_section
                            {
                            pushFollow(FOLLOW_declare_section_in_procedure_declaration_or_definition1653);
                            declare_section();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_body_in_procedure_declaration_or_definition1656);
                    body();

                    state._fsp--;


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
                    break;

            }


            }


            variables_list_cnt = -1;
            create_package = saved_cp;

        }
        catch (RecognitionException re) {
            reportError(re);recover(input,re);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "procedure_declaration_or_definition"


    // $ANTLR start "body"
    // /home/macan/Private/pl2py/PLSQL.g:887:1: body : BEGIN statement SEMI ( statement SEMI | pragma SEMI )* ( EXCEPTION ( exception_handler )+ )? END ( ID )? ;
    public final void body() throws RecognitionException {

        indent_count = 2;
        int has_exception_handler = 0;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:891:4: ( BEGIN statement SEMI ( statement SEMI | pragma SEMI )* ( EXCEPTION ( exception_handler )+ )? END ( ID )? )
            // /home/macan/Private/pl2py/PLSQL.g:892:2: BEGIN statement SEMI ( statement SEMI | pragma SEMI )* ( EXCEPTION ( exception_handler )+ )? END ( ID )?
            {
            match(input,BEGIN,FOLLOW_BEGIN_in_body1733); 

            	output += "\t# BEGIN a BODY\n";
            	output += "\ttry:\n";
            	
            pushFollow(FOLLOW_statement_in_body1737);
            statement();

            state._fsp--;


            		if(!stat.equals("")) {
            			output += stat; 
            			stat = "";
            		}
            	
            match(input,SEMI,FOLLOW_SEMI_in_body1742); 
            // /home/macan/Private/pl2py/PLSQL.g:901:7: ( statement SEMI | pragma SEMI )*
            loop43:
            do {
                int alt43=3;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==ID||LA43_0==RETURN||LA43_0==NULL||LA43_0==BEGIN||(LA43_0>=COLON && LA43_0<=CASE)||(LA43_0>=CLOSE && LA43_0<=CONTINUE)||(LA43_0>=EXIT && LA43_0<=FETCH)||(LA43_0>=FOR && LA43_0<=FORALL)||(LA43_0>=GOTO && LA43_0<=IF)||LA43_0==OPEN||(LA43_0>=RAISE && LA43_0<=LLABEL)||(LA43_0>=COMMIT && LA43_0<=SET)||(LA43_0>=UPDATE && LA43_0<=WHILE)) ) {
                    alt43=1;
                }
                else if ( (LA43_0==PRAGMA) ) {
                    alt43=2;
                }


                switch (alt43) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:901:9: statement SEMI
            	    {
            	    pushFollow(FOLLOW_statement_in_body1746);
            	    statement();

            	    state._fsp--;


            	    		if(!stat.equals("")) {
            	    			output += stat; 
            	    			stat = "";
            	    		}
            	    	
            	    match(input,SEMI,FOLLOW_SEMI_in_body1751); 

            	    }
            	    break;
            	case 2 :
            	    // /home/macan/Private/pl2py/PLSQL.g:907:11: pragma SEMI
            	    {
            	    pushFollow(FOLLOW_pragma_in_body1755);
            	    pragma();

            	    state._fsp--;

            	    match(input,SEMI,FOLLOW_SEMI_in_body1757); 

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            // /home/macan/Private/pl2py/PLSQL.g:908:2: ( EXCEPTION ( exception_handler )+ )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==EXCEPTION) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:908:3: EXCEPTION ( exception_handler )+
                    {

                    	stat = "";
                        	
                    match(input,EXCEPTION,FOLLOW_EXCEPTION_in_body1767); 
                    has_exception_handler = 1;
                    // /home/macan/Private/pl2py/PLSQL.g:911:41: ( exception_handler )+
                    int cnt44=0;
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==WHEN) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // /home/macan/Private/pl2py/PLSQL.g:911:41: exception_handler
                    	    {
                    	    pushFollow(FOLLOW_exception_handler_in_body1771);
                    	    exception_handler();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt44 >= 1 ) break loop44;
                                EarlyExitException eee =
                                    new EarlyExitException(44, input);
                                throw eee;
                        }
                        cnt44++;
                    } while (true);


                    }
                    break;

            }

            match(input,END,FOLLOW_END_in_body1779); 

            	if (has_exception_handler == 0) {
            		output += "\texcept HiveServerException, hse:\n";
            		output += "\t\tprint hse\n";	
            	}
            	
            // /home/macan/Private/pl2py/PLSQL.g:917:4: ( ID )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==ID) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:917:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_body1783); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "body"


    // $ANTLR start "exception_handler"
    // /home/macan/Private/pl2py/PLSQL.g:920:1: exception_handler : WHEN ( qual_id ( OR qual_id )* | OTHERS ) THEN ( statement SEMI )+ ;
    public final void exception_handler() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:920:18: ( WHEN ( qual_id ( OR qual_id )* | OTHERS ) THEN ( statement SEMI )+ )
            // /home/macan/Private/pl2py/PLSQL.g:921:2: WHEN ( qual_id ( OR qual_id )* | OTHERS ) THEN ( statement SEMI )+
            {
            int start = input.LT(1).getTokenIndex();
            match(input,WHEN,FOLLOW_WHEN_in_exception_handler1799); 
            // /home/macan/Private/pl2py/PLSQL.g:922:7: ( qual_id ( OR qual_id )* | OTHERS )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==ID||LA48_0==COLON) ) {
                alt48=1;
            }
            else if ( (LA48_0==OTHERS) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:922:9: qual_id ( OR qual_id )*
                    {
                    pushFollow(FOLLOW_qual_id_in_exception_handler1803);
                    qual_id();

                    state._fsp--;

                    // /home/macan/Private/pl2py/PLSQL.g:922:17: ( OR qual_id )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==OR) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // /home/macan/Private/pl2py/PLSQL.g:922:19: OR qual_id
                    	    {
                    	    match(input,OR,FOLLOW_OR_in_exception_handler1807); 
                    	    pushFollow(FOLLOW_qual_id_in_exception_handler1809);
                    	    qual_id();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);


                    	for (int i = 0; i < indent_count - 1; i++) {
                    		output += "\t";
                    	}
                    	output += "except HiveServerException, hse:\n";
                    	

                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:927:6: OTHERS
                    {
                    match(input,OTHERS,FOLLOW_OTHERS_in_exception_handler1818); 

                    	for (int i = 0; i < indent_count - 1; i++) {
                    		output += "\t";
                    	}
                    	output += "except:\n";

                    }
                    break;

            }

            match(input,THEN,FOLLOW_THEN_in_exception_handler1824); 

                    
                    
            // /home/macan/Private/pl2py/PLSQL.g:935:2: ( statement SEMI )+
            int cnt49=0;
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==ID||LA49_0==RETURN||LA49_0==NULL||LA49_0==BEGIN||(LA49_0>=COLON && LA49_0<=CASE)||(LA49_0>=CLOSE && LA49_0<=CONTINUE)||(LA49_0>=EXIT && LA49_0<=FETCH)||(LA49_0>=FOR && LA49_0<=FORALL)||(LA49_0>=GOTO && LA49_0<=IF)||LA49_0==OPEN||(LA49_0>=RAISE && LA49_0<=LLABEL)||(LA49_0>=COMMIT && LA49_0<=SET)||(LA49_0>=UPDATE && LA49_0<=WHILE)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:935:4: statement SEMI
            	    {
            	    pushFollow(FOLLOW_statement_in_exception_handler1841);
            	    statement();

            	    state._fsp--;

            	    match(input,SEMI,FOLLOW_SEMI_in_exception_handler1843); 

            	    }
            	    break;

            	default :
            	    if ( cnt49 >= 1 ) break loop49;
                        EarlyExitException eee =
                            new EarlyExitException(49, input);
                        throw eee;
                }
                cnt49++;
            } while (true);


            	output += stat;
            	stat = "";
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "exception_handler"


    // $ANTLR start "statement"
    // /home/macan/Private/pl2py/PLSQL.g:942:1: statement : ( label )* ( assign_or_call_statement | case_statement | close_statement | continue_statement | basic_loop_statement | execute_immediate_statement | exit_statement | fetch_statement | for_loop_statement | forall_statement | goto_statement | if_statement | null_statement | open_statement | plsql_block | raise_statement | return_statement | sql_statement | while_loop_statement | dbmsfunc_call ) ;
    public final void statement() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:942:11: ( ( label )* ( assign_or_call_statement | case_statement | close_statement | continue_statement | basic_loop_statement | execute_immediate_statement | exit_statement | fetch_statement | for_loop_statement | forall_statement | goto_statement | if_statement | null_statement | open_statement | plsql_block | raise_statement | return_statement | sql_statement | while_loop_statement | dbmsfunc_call ) )
            // /home/macan/Private/pl2py/PLSQL.g:943:5: ( label )* ( assign_or_call_statement | case_statement | close_statement | continue_statement | basic_loop_statement | execute_immediate_statement | exit_statement | fetch_statement | for_loop_statement | forall_statement | goto_statement | if_statement | null_statement | open_statement | plsql_block | raise_statement | return_statement | sql_statement | while_loop_statement | dbmsfunc_call )
            {
            // /home/macan/Private/pl2py/PLSQL.g:943:5: ( label )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==LLABEL) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:943:5: label
            	    {
            	    pushFollow(FOLLOW_label_in_statement1865);
            	    label();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            // /home/macan/Private/pl2py/PLSQL.g:944:5: ( assign_or_call_statement | case_statement | close_statement | continue_statement | basic_loop_statement | execute_immediate_statement | exit_statement | fetch_statement | for_loop_statement | forall_statement | goto_statement | if_statement | null_statement | open_statement | plsql_block | raise_statement | return_statement | sql_statement | while_loop_statement | dbmsfunc_call )
            int alt51=20;
            switch ( input.LA(1) ) {
            case ID:
            case COLON:
                {
                alt51=1;
                }
                break;
            case CASE:
                {
                alt51=2;
                }
                break;
            case CLOSE:
                {
                alt51=3;
                }
                break;
            case CONTINUE:
                {
                alt51=4;
                }
                break;
            case LOOP:
                {
                alt51=5;
                }
                break;
            case EXECUTE:
                {
                alt51=6;
                }
                break;
            case EXIT:
                {
                alt51=7;
                }
                break;
            case FETCH:
                {
                alt51=8;
                }
                break;
            case FOR:
                {
                alt51=9;
                }
                break;
            case FORALL:
                {
                alt51=10;
                }
                break;
            case GOTO:
                {
                alt51=11;
                }
                break;
            case IF:
                {
                alt51=12;
                }
                break;
            case NULL:
                {
                alt51=13;
                }
                break;
            case OPEN:
                {
                alt51=14;
                }
                break;
            case BEGIN:
            case DECLARE:
                {
                alt51=15;
                }
                break;
            case RAISE:
                {
                alt51=16;
                }
                break;
            case RETURN:
                {
                alt51=17;
                }
                break;
            case DELETE:
            case COMMIT:
            case INSERT:
            case LOCK:
            case ROLLBACK:
            case SAVEPOINT:
            case SELECT:
            case SET:
            case UPDATE:
            case MERGE:
                {
                alt51=18;
                }
                break;
            case WHILE:
                {
                alt51=19;
                }
                break;
            case DBMS:
                {
                alt51=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:944:7: assign_or_call_statement
                    {
                    pushFollow(FOLLOW_assign_or_call_statement_in_statement1874);
                    assign_or_call_statement();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:945:7: case_statement
                    {
                    pushFollow(FOLLOW_case_statement_in_statement1882);
                    case_statement();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:946:7: close_statement
                    {
                    pushFollow(FOLLOW_close_statement_in_statement1890);
                    close_statement();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // /home/macan/Private/pl2py/PLSQL.g:947:7: continue_statement
                    {
                    pushFollow(FOLLOW_continue_statement_in_statement1898);
                    continue_statement();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // /home/macan/Private/pl2py/PLSQL.g:948:7: basic_loop_statement
                    {
                    pushFollow(FOLLOW_basic_loop_statement_in_statement1906);
                    basic_loop_statement();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // /home/macan/Private/pl2py/PLSQL.g:949:7: execute_immediate_statement
                    {
                    pushFollow(FOLLOW_execute_immediate_statement_in_statement1914);
                    execute_immediate_statement();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // /home/macan/Private/pl2py/PLSQL.g:950:7: exit_statement
                    {
                    pushFollow(FOLLOW_exit_statement_in_statement1922);
                    exit_statement();

                    state._fsp--;


                    }
                    break;
                case 8 :
                    // /home/macan/Private/pl2py/PLSQL.g:951:7: fetch_statement
                    {
                    pushFollow(FOLLOW_fetch_statement_in_statement1930);
                    fetch_statement();

                    state._fsp--;


                    }
                    break;
                case 9 :
                    // /home/macan/Private/pl2py/PLSQL.g:952:7: for_loop_statement
                    {
                    pushFollow(FOLLOW_for_loop_statement_in_statement1938);
                    for_loop_statement();

                    state._fsp--;


                    }
                    break;
                case 10 :
                    // /home/macan/Private/pl2py/PLSQL.g:953:7: forall_statement
                    {
                    pushFollow(FOLLOW_forall_statement_in_statement1946);
                    forall_statement();

                    state._fsp--;


                    }
                    break;
                case 11 :
                    // /home/macan/Private/pl2py/PLSQL.g:954:7: goto_statement
                    {
                    pushFollow(FOLLOW_goto_statement_in_statement1954);
                    goto_statement();

                    state._fsp--;


                    }
                    break;
                case 12 :
                    // /home/macan/Private/pl2py/PLSQL.g:955:7: if_statement
                    {
                    pushFollow(FOLLOW_if_statement_in_statement1962);
                    if_statement();

                    state._fsp--;


                    }
                    break;
                case 13 :
                    // /home/macan/Private/pl2py/PLSQL.g:956:7: null_statement
                    {
                    pushFollow(FOLLOW_null_statement_in_statement1970);
                    null_statement();

                    state._fsp--;


                    }
                    break;
                case 14 :
                    // /home/macan/Private/pl2py/PLSQL.g:957:7: open_statement
                    {
                    pushFollow(FOLLOW_open_statement_in_statement1978);
                    open_statement();

                    state._fsp--;


                    }
                    break;
                case 15 :
                    // /home/macan/Private/pl2py/PLSQL.g:958:7: plsql_block
                    {
                    pushFollow(FOLLOW_plsql_block_in_statement1986);
                    plsql_block();

                    state._fsp--;


                    }
                    break;
                case 16 :
                    // /home/macan/Private/pl2py/PLSQL.g:959:7: raise_statement
                    {
                    pushFollow(FOLLOW_raise_statement_in_statement1995);
                    raise_statement();

                    state._fsp--;


                    }
                    break;
                case 17 :
                    // /home/macan/Private/pl2py/PLSQL.g:960:7: return_statement
                    {
                    pushFollow(FOLLOW_return_statement_in_statement2004);
                    return_statement();

                    state._fsp--;


                    }
                    break;
                case 18 :
                    // /home/macan/Private/pl2py/PLSQL.g:961:7: sql_statement
                    {
                    pushFollow(FOLLOW_sql_statement_in_statement2013);
                    sql_statement();

                    state._fsp--;


                    }
                    break;
                case 19 :
                    // /home/macan/Private/pl2py/PLSQL.g:962:7: while_loop_statement
                    {
                    pushFollow(FOLLOW_while_loop_statement_in_statement2021);
                    while_loop_statement();

                    state._fsp--;


                    }
                    break;
                case 20 :
                    // /home/macan/Private/pl2py/PLSQL.g:963:7: dbmsfunc_call
                    {
                    pushFollow(FOLLOW_dbmsfunc_call_in_statement2030);
                    dbmsfunc_call();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "statement"


    // $ANTLR start "lvalue"
    // /home/macan/Private/pl2py/PLSQL.g:967:1: lvalue : call_lvalue ( DOT call_lvalue )* ;
    public final void lvalue() throws RecognitionException {

        String previous_id = "";
        last_id = "";
        int found = 0;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:973:5: ( call_lvalue ( DOT call_lvalue )* )
            // /home/macan/Private/pl2py/PLSQL.g:974:6: call_lvalue ( DOT call_lvalue )*
            {
            int start = input.LT(1).getTokenIndex();
                	int end = 0;
            pushFollow(FOLLOW_call_lvalue_in_lvalue2071);
            call_lvalue();

            state._fsp--;

            previous_id = last_id;
            // /home/macan/Private/pl2py/PLSQL.g:976:43: ( DOT call_lvalue )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==DOT) ) {
                    int LA52_1 = input.LA(2);

                    if ( (LA52_1==ID||LA52_1==COLON) ) {
                        alt52=1;
                    }


                }


                switch (alt52) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:976:45: DOT call_lvalue
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_lvalue2077); 
            	    end = input.LT(-1).getTokenIndex(); stat += ".";
            	    pushFollow(FOLLOW_call_lvalue_in_lvalue2081);
            	    call_lvalue();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "lvalue"


    // $ANTLR start "assign_or_call_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1037:1: assign_or_call_statement : lvalue ( DOT delete_call | ASSIGN ( expression | dbmsfunc_call ) )? ;
    public final void assign_or_call_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1047:5: ( lvalue ( DOT delete_call | ASSIGN ( expression | dbmsfunc_call ) )? )
            // /home/macan/Private/pl2py/PLSQL.g:1048:5: lvalue ( DOT delete_call | ASSIGN ( expression | dbmsfunc_call ) )?
            {
            int start = input.LT(1).getTokenIndex();
            pushFollow(FOLLOW_lvalue_in_assign_or_call_statement2134);
            lvalue();

            state._fsp--;

            int end = input.LT(-1).getTokenIndex();
                String lvalue_string = input.toString(start, end).toLowerCase();
                
            // /home/macan/Private/pl2py/PLSQL.g:1053:6: ( DOT delete_call | ASSIGN ( expression | dbmsfunc_call ) )?
            int alt54=3;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==DOT) ) {
                alt54=1;
            }
            else if ( (LA54_0==ASSIGN) ) {
                alt54=2;
            }
            switch (alt54) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1054:6: DOT delete_call
                    {
                    match(input,DOT,FOLLOW_DOT_in_assign_or_call_statement2155); 
                    stat += '.';
                    pushFollow(FOLLOW_delete_call_in_assign_or_call_statement2178);
                    delete_call();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:1057:6: ASSIGN ( expression | dbmsfunc_call )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_or_call_statement2188); 
                    // /home/macan/Private/pl2py/PLSQL.g:1058:6: ( expression | dbmsfunc_call )
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==ID||LA53_0==LPAREN||(LA53_0>=NOT && LA53_0<=NULL)||LA53_0==COLON||(LA53_0>=MINUS && LA53_0<=PLUS)||(LA53_0>=SQL && LA53_0<=INTEGER)||(LA53_0>=REAL_NUMBER && LA53_0<=QUOTED_STRING)||(LA53_0>=INSERTING && LA53_0<=DELETING)) ) {
                        alt53=1;
                    }
                    else if ( (LA53_0==DBMS) ) {
                        alt53=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 53, 0, input);

                        throw nvae;
                    }
                    switch (alt53) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:1058:7: expression
                            {
                            pushFollow(FOLLOW_expression_in_assign_or_call_statement2200);
                            expression();

                            state._fsp--;


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
                                	

                            }
                            break;
                        case 2 :
                            // /home/macan/Private/pl2py/PLSQL.g:1103:9: dbmsfunc_call
                            {
                            pushFollow(FOLLOW_dbmsfunc_call_in_assign_or_call_statement2210);
                            dbmsfunc_call();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "assign_or_call_statement"


    // $ANTLR start "call"
    // /home/macan/Private/pl2py/PLSQL.g:1106:1: call : ( COLON )? ID ( LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN )? ;
    public final void call() throws RecognitionException {
        Token COLON8=null;
        Token ID9=null;


        String saved_last_id = "";
        int bracket = 0;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1115:5: ( ( COLON )? ID ( LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN )? )
            // /home/macan/Private/pl2py/PLSQL.g:1115:9: ( COLON )? ID ( LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN )?
            {
            // /home/macan/Private/pl2py/PLSQL.g:1115:9: ( COLON )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==COLON) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1115:9: COLON
                    {
                    COLON8=(Token)match(input,COLON,FOLLOW_COLON_in_call2241); 

                    }
                    break;

            }

            if(COLON8 != null) exp += ":";
            ID9=(Token)match(input,ID,FOLLOW_ID_in_call2246); 

                	String tmp = ID9.getText().toLowerCase();
                	if (tmp.toLowerCase().equals("round"))
                		tmp = tmp.toLowerCase().replace("round", "tdw_round");
                	else if (tmp.toLowerCase().equals("abs"))
                		tmp = tmp.toLowerCase().replace("abs", "tdw_abs");
            	exp += tmp;
            	last_id = ID9.getText().toLowerCase();
                	
            // /home/macan/Private/pl2py/PLSQL.g:1124:6: ( LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==LPAREN) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1124:8: LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_call2257); 

                        	saved_last_id = last_id;
                        	int found = 0;
                        	// check the collection 
                      	if( has_collection_type == 1 )
                        	{
                        		for(int i = 0; i <= collection_var_cnt; i++)
                        		{
                        			if(ID9.getText().toLowerCase().contains(collection_variables[i].toLowerCase()))
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
                        	emitFunctionName(tmp.toLowerCase(), ID9.getLine());
                        	
                    // /home/macan/Private/pl2py/PLSQL.g:1147:6: ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==ID||LA58_0==LPAREN||(LA58_0>=NOT && LA58_0<=NULL)||LA58_0==COLON||(LA58_0>=MINUS && LA58_0<=PLUS)||(LA58_0>=SQL && LA58_0<=INTEGER)||(LA58_0>=REAL_NUMBER && LA58_0<=QUOTED_STRING)||(LA58_0>=INSERTING && LA58_0<=DELETING)) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:1147:8: parameter ( COMMA ( parameter | dbmsfunc_call ) )*
                            {
                            pushFollow(FOLLOW_parameter_in_call2269);
                            parameter();

                            state._fsp--;


                                	
                            // /home/macan/Private/pl2py/PLSQL.g:1150:7: ( COMMA ( parameter | dbmsfunc_call ) )*
                            loop57:
                            do {
                                int alt57=2;
                                int LA57_0 = input.LA(1);

                                if ( (LA57_0==COMMA) ) {
                                    alt57=1;
                                }


                                switch (alt57) {
                            	case 1 :
                            	    // /home/macan/Private/pl2py/PLSQL.g:1150:9: COMMA ( parameter | dbmsfunc_call )
                            	    {
                            	    match(input,COMMA,FOLLOW_COMMA_in_call2286); 
                            	    exp += ", ";
                            	    // /home/macan/Private/pl2py/PLSQL.g:1150:30: ( parameter | dbmsfunc_call )
                            	    int alt56=2;
                            	    int LA56_0 = input.LA(1);

                            	    if ( (LA56_0==ID||LA56_0==LPAREN||(LA56_0>=NOT && LA56_0<=NULL)||LA56_0==COLON||(LA56_0>=MINUS && LA56_0<=PLUS)||(LA56_0>=SQL && LA56_0<=INTEGER)||(LA56_0>=REAL_NUMBER && LA56_0<=QUOTED_STRING)||(LA56_0>=INSERTING && LA56_0<=DELETING)) ) {
                            	        alt56=1;
                            	    }
                            	    else if ( (LA56_0==DBMS) ) {
                            	        alt56=2;
                            	    }
                            	    else {
                            	        NoViableAltException nvae =
                            	            new NoViableAltException("", 56, 0, input);

                            	        throw nvae;
                            	    }
                            	    switch (alt56) {
                            	        case 1 :
                            	            // /home/macan/Private/pl2py/PLSQL.g:1150:31: parameter
                            	            {
                            	            pushFollow(FOLLOW_parameter_in_call2291);
                            	            parameter();

                            	            state._fsp--;


                            	                	

                            	            }
                            	            break;
                            	        case 2 :
                            	            // /home/macan/Private/pl2py/PLSQL.g:1153:7: dbmsfunc_call
                            	            {
                            	            pushFollow(FOLLOW_dbmsfunc_call_in_call2307);
                            	            dbmsfunc_call();

                            	            state._fsp--;


                            	            }
                            	            break;

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop57;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_call2315); 
                    if (bracket == 0) exp += ")"; else exp += "]";

                    }
                    break;

            }


            }


            if (saved_last_id.length() > 0) 
            	last_id = saved_last_id;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "call"


    // $ANTLR start "call_lvalue"
    // /home/macan/Private/pl2py/PLSQL.g:1156:1: call_lvalue : ( COLON )? ID ( LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN )? ;
    public final void call_lvalue() throws RecognitionException {
        Token ID10=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1157:6: ( ( COLON )? ID ( LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN )? )
            // /home/macan/Private/pl2py/PLSQL.g:1158:6: ( COLON )? ID ( LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN )?
            {
            // /home/macan/Private/pl2py/PLSQL.g:1158:6: ( COLON )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==COLON) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1158:6: COLON
                    {
                    match(input,COLON,FOLLOW_COLON_in_call_lvalue2347); 

                    }
                    break;

            }

            ID10=(Token)match(input,ID,FOLLOW_ID_in_call_lvalue2350); 

                	if(ID10.getText().equalsIgnoreCase("dbms_stats"))
                		stat += "";
                	stat += ID10.getText().toLowerCase();
                	last_id = ID10.getText().toLowerCase();
                	
            // /home/macan/Private/pl2py/PLSQL.g:1165:6: ( LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==LPAREN) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1165:8: LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_call_lvalue2373); 
                    stat += "(tdw, ";
                    // /home/macan/Private/pl2py/PLSQL.g:1165:35: ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==ID||LA63_0==LPAREN||(LA63_0>=NOT && LA63_0<=NULL)||LA63_0==COLON||(LA63_0>=MINUS && LA63_0<=PLUS)||(LA63_0>=SQL && LA63_0<=INTEGER)||(LA63_0>=REAL_NUMBER && LA63_0<=QUOTED_STRING)||(LA63_0>=INSERTING && LA63_0<=DELETING)) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:1165:37: parameter ( COMMA ( parameter | dbmsfunc_call ) )*
                            {
                            pushFollow(FOLLOW_parameter_in_call_lvalue2379);
                            parameter();

                            state._fsp--;

                            stat += exp ;exp = "";
                            // /home/macan/Private/pl2py/PLSQL.g:1165:72: ( COMMA ( parameter | dbmsfunc_call ) )*
                            loop62:
                            do {
                                int alt62=2;
                                int LA62_0 = input.LA(1);

                                if ( (LA62_0==COMMA) ) {
                                    alt62=1;
                                }


                                switch (alt62) {
                            	case 1 :
                            	    // /home/macan/Private/pl2py/PLSQL.g:1165:74: COMMA ( parameter | dbmsfunc_call )
                            	    {
                            	    match(input,COMMA,FOLLOW_COMMA_in_call_lvalue2385); 
                            	    stat += ", ";
                            	    // /home/macan/Private/pl2py/PLSQL.g:1165:96: ( parameter | dbmsfunc_call )
                            	    int alt61=2;
                            	    int LA61_0 = input.LA(1);

                            	    if ( (LA61_0==ID||LA61_0==LPAREN||(LA61_0>=NOT && LA61_0<=NULL)||LA61_0==COLON||(LA61_0>=MINUS && LA61_0<=PLUS)||(LA61_0>=SQL && LA61_0<=INTEGER)||(LA61_0>=REAL_NUMBER && LA61_0<=QUOTED_STRING)||(LA61_0>=INSERTING && LA61_0<=DELETING)) ) {
                            	        alt61=1;
                            	    }
                            	    else if ( (LA61_0==DBMS) ) {
                            	        alt61=2;
                            	    }
                            	    else {
                            	        NoViableAltException nvae =
                            	            new NoViableAltException("", 61, 0, input);

                            	        throw nvae;
                            	    }
                            	    switch (alt61) {
                            	        case 1 :
                            	            // /home/macan/Private/pl2py/PLSQL.g:1165:97: parameter
                            	            {
                            	            pushFollow(FOLLOW_parameter_in_call_lvalue2390);
                            	            parameter();

                            	            state._fsp--;

                            	            stat += exp ;exp = "";

                            	            }
                            	            break;
                            	        case 2 :
                            	            // /home/macan/Private/pl2py/PLSQL.g:1165:132: dbmsfunc_call
                            	            {
                            	            pushFollow(FOLLOW_dbmsfunc_call_in_call_lvalue2394);
                            	            dbmsfunc_call();

                            	            state._fsp--;


                            	            }
                            	            break;

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop62;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_call_lvalue2402); 
                    stat += ")";

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "call_lvalue"


    // $ANTLR start "dbmsfunc_call"
    // /home/macan/Private/pl2py/PLSQL.g:1168:1: dbmsfunc_call : t1= DBMS DOT ( ID | EXECUTE ) ( LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN )* ;
    public final void dbmsfunc_call() throws RecognitionException {
        Token t1=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1169:5: (t1= DBMS DOT ( ID | EXECUTE ) ( LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN )* )
            // /home/macan/Private/pl2py/PLSQL.g:1169:7: t1= DBMS DOT ( ID | EXECUTE ) ( LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN )*
            {
            t1=(Token)match(input,DBMS,FOLLOW_DBMS_in_dbmsfunc_call2425); 
            match(input,DOT,FOLLOW_DOT_in_dbmsfunc_call2427); 
            if ( input.LA(1)==ID||input.LA(1)==EXECUTE ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // /home/macan/Private/pl2py/PLSQL.g:1169:35: ( LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==LPAREN) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:1169:36: LPAREN ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )? RPAREN
            	    {
            	    match(input,LPAREN,FOLLOW_LPAREN_in_dbmsfunc_call2439); 
            	    // /home/macan/Private/pl2py/PLSQL.g:1169:43: ( parameter ( COMMA ( parameter | dbmsfunc_call ) )* )?
            	    int alt67=2;
            	    int LA67_0 = input.LA(1);

            	    if ( (LA67_0==ID||LA67_0==LPAREN||(LA67_0>=NOT && LA67_0<=NULL)||LA67_0==COLON||(LA67_0>=MINUS && LA67_0<=PLUS)||(LA67_0>=SQL && LA67_0<=INTEGER)||(LA67_0>=REAL_NUMBER && LA67_0<=QUOTED_STRING)||(LA67_0>=INSERTING && LA67_0<=DELETING)) ) {
            	        alt67=1;
            	    }
            	    switch (alt67) {
            	        case 1 :
            	            // /home/macan/Private/pl2py/PLSQL.g:1169:45: parameter ( COMMA ( parameter | dbmsfunc_call ) )*
            	            {
            	            pushFollow(FOLLOW_parameter_in_dbmsfunc_call2443);
            	            parameter();

            	            state._fsp--;

            	            // /home/macan/Private/pl2py/PLSQL.g:1169:55: ( COMMA ( parameter | dbmsfunc_call ) )*
            	            loop66:
            	            do {
            	                int alt66=2;
            	                int LA66_0 = input.LA(1);

            	                if ( (LA66_0==COMMA) ) {
            	                    alt66=1;
            	                }


            	                switch (alt66) {
            	            	case 1 :
            	            	    // /home/macan/Private/pl2py/PLSQL.g:1169:56: COMMA ( parameter | dbmsfunc_call )
            	            	    {
            	            	    match(input,COMMA,FOLLOW_COMMA_in_dbmsfunc_call2446); 
            	            	    // /home/macan/Private/pl2py/PLSQL.g:1169:62: ( parameter | dbmsfunc_call )
            	            	    int alt65=2;
            	            	    int LA65_0 = input.LA(1);

            	            	    if ( (LA65_0==ID||LA65_0==LPAREN||(LA65_0>=NOT && LA65_0<=NULL)||LA65_0==COLON||(LA65_0>=MINUS && LA65_0<=PLUS)||(LA65_0>=SQL && LA65_0<=INTEGER)||(LA65_0>=REAL_NUMBER && LA65_0<=QUOTED_STRING)||(LA65_0>=INSERTING && LA65_0<=DELETING)) ) {
            	            	        alt65=1;
            	            	    }
            	            	    else if ( (LA65_0==DBMS) ) {
            	            	        alt65=2;
            	            	    }
            	            	    else {
            	            	        NoViableAltException nvae =
            	            	            new NoViableAltException("", 65, 0, input);

            	            	        throw nvae;
            	            	    }
            	            	    switch (alt65) {
            	            	        case 1 :
            	            	            // /home/macan/Private/pl2py/PLSQL.g:1169:63: parameter
            	            	            {
            	            	            pushFollow(FOLLOW_parameter_in_dbmsfunc_call2449);
            	            	            parameter();

            	            	            state._fsp--;


            	            	            }
            	            	            break;
            	            	        case 2 :
            	            	            // /home/macan/Private/pl2py/PLSQL.g:1169:74: dbmsfunc_call
            	            	            {
            	            	            pushFollow(FOLLOW_dbmsfunc_call_in_dbmsfunc_call2452);
            	            	            dbmsfunc_call();

            	            	            state._fsp--;


            	            	            }
            	            	            break;

            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop66;
            	                }
            	            } while (true);


            	            }
            	            break;

            	    }

            	    match(input,RPAREN,FOLLOW_RPAREN_in_dbmsfunc_call2460); 

            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "dbmsfunc_call"


    // $ANTLR start "delete_call"
    // /home/macan/Private/pl2py/PLSQL.g:1172:1: delete_call : DELETE ( LPAREN ( parameter )? RPAREN )? ;
    public final void delete_call() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:1173:5: ( DELETE ( LPAREN ( parameter )? RPAREN )? )
            // /home/macan/Private/pl2py/PLSQL.g:1173:7: DELETE ( LPAREN ( parameter )? RPAREN )?
            {
            match(input,DELETE,FOLLOW_DELETE_in_delete_call2480); 
            // /home/macan/Private/pl2py/PLSQL.g:1173:14: ( LPAREN ( parameter )? RPAREN )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==LPAREN) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1173:16: LPAREN ( parameter )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_delete_call2484); 
                    // /home/macan/Private/pl2py/PLSQL.g:1173:23: ( parameter )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==ID||LA69_0==LPAREN||(LA69_0>=NOT && LA69_0<=NULL)||LA69_0==COLON||(LA69_0>=MINUS && LA69_0<=PLUS)||(LA69_0>=SQL && LA69_0<=INTEGER)||(LA69_0>=REAL_NUMBER && LA69_0<=QUOTED_STRING)||(LA69_0>=INSERTING && LA69_0<=DELETING)) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:1173:23: parameter
                            {
                            pushFollow(FOLLOW_parameter_in_delete_call2486);
                            parameter();

                            state._fsp--;


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_delete_call2489); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "delete_call"


    // $ANTLR start "basic_loop_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1176:1: basic_loop_statement : LOOP ( statement SEMI )+ END LOOP ( label_name )? ;
    public final void basic_loop_statement() throws RecognitionException {

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

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1193:1: ( LOOP ( statement SEMI )+ END LOOP ( label_name )? )
            // /home/macan/Private/pl2py/PLSQL.g:1194:6: LOOP ( statement SEMI )+ END LOOP ( label_name )?
            {
            match(input,LOOP,FOLLOW_LOOP_in_basic_loop_statement2519); 
            stat += "while True:\n";
            // /home/macan/Private/pl2py/PLSQL.g:1195:6: ( statement SEMI )+
            int cnt71=0;
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==ID||LA71_0==RETURN||LA71_0==NULL||LA71_0==BEGIN||(LA71_0>=COLON && LA71_0<=CASE)||(LA71_0>=CLOSE && LA71_0<=CONTINUE)||(LA71_0>=EXIT && LA71_0<=FETCH)||(LA71_0>=FOR && LA71_0<=FORALL)||(LA71_0>=GOTO && LA71_0<=IF)||LA71_0==OPEN||(LA71_0>=RAISE && LA71_0<=LLABEL)||(LA71_0>=COMMIT && LA71_0<=SET)||(LA71_0>=UPDATE && LA71_0<=WHILE)) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:1195:7: statement SEMI
            	    {
            	    indent_count++;
            	    pushFollow(FOLLOW_statement_in_basic_loop_statement2531);
            	    statement();

            	    state._fsp--;

            	    indent_count--;
            	    match(input,SEMI,FOLLOW_SEMI_in_basic_loop_statement2535); 

            	    }
            	    break;

            	default :
            	    if ( cnt71 >= 1 ) break loop71;
                        EarlyExitException eee =
                            new EarlyExitException(71, input);
                        throw eee;
                }
                cnt71++;
            } while (true);

            match(input,END,FOLLOW_END_in_basic_loop_statement2541); 
            match(input,LOOP,FOLLOW_LOOP_in_basic_loop_statement2543); 
            // /home/macan/Private/pl2py/PLSQL.g:1195:71: ( label_name )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==ID) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1195:71: label_name
                    {
                    pushFollow(FOLLOW_label_name_in_basic_loop_statement2545);
                    label_name();

                    state._fsp--;


                    }
                    break;

            }


            }


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "basic_loop_statement"


    // $ANTLR start "case_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1198:1: case_statement : CASE ( expression )? ( WHEN expression THEN ( statement SEMI )+ )+ ( ELSE statement SEMI )? END CASE ( label_name )? ;
    public final void case_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1208:1: ( CASE ( expression )? ( WHEN expression THEN ( statement SEMI )+ )+ ( ELSE statement SEMI )? END CASE ( label_name )? )
            // /home/macan/Private/pl2py/PLSQL.g:1209:9: CASE ( expression )? ( WHEN expression THEN ( statement SEMI )+ )+ ( ELSE statement SEMI )? END CASE ( label_name )?
            {
            match(input,CASE,FOLLOW_CASE_in_case_statement2580); 
            // /home/macan/Private/pl2py/PLSQL.g:1209:14: ( expression )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==ID||LA73_0==LPAREN||(LA73_0>=NOT && LA73_0<=NULL)||LA73_0==COLON||(LA73_0>=MINUS && LA73_0<=PLUS)||(LA73_0>=SQL && LA73_0<=INTEGER)||(LA73_0>=REAL_NUMBER && LA73_0<=QUOTED_STRING)||(LA73_0>=INSERTING && LA73_0<=DELETING)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1209:14: expression
                    {
                    pushFollow(FOLLOW_expression_in_case_statement2582);
                    expression();

                    state._fsp--;


                    }
                    break;

            }

            String variable = exp; exp = "";
                    int flag = 0;
                    
            // /home/macan/Private/pl2py/PLSQL.g:1213:9: ( WHEN expression THEN ( statement SEMI )+ )+
            int cnt75=0;
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==WHEN) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:1213:11: WHEN expression THEN ( statement SEMI )+
            	    {
            	    match(input,WHEN,FOLLOW_WHEN_in_case_statement2605); 
            	    pushFollow(FOLLOW_expression_in_case_statement2607);
            	    expression();

            	    state._fsp--;

            	    match(input,THEN,FOLLOW_THEN_in_case_statement2609); 
            	    if(flag == 0)
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
            	            
            	    // /home/macan/Private/pl2py/PLSQL.g:1230:9: ( statement SEMI )+
            	    int cnt74=0;
            	    loop74:
            	    do {
            	        int alt74=2;
            	        int LA74_0 = input.LA(1);

            	        if ( (LA74_0==ID||LA74_0==RETURN||LA74_0==NULL||LA74_0==BEGIN||(LA74_0>=COLON && LA74_0<=CASE)||(LA74_0>=CLOSE && LA74_0<=CONTINUE)||(LA74_0>=EXIT && LA74_0<=FETCH)||(LA74_0>=FOR && LA74_0<=FORALL)||(LA74_0>=GOTO && LA74_0<=IF)||LA74_0==OPEN||(LA74_0>=RAISE && LA74_0<=LLABEL)||(LA74_0>=COMMIT && LA74_0<=SET)||(LA74_0>=UPDATE && LA74_0<=WHILE)) ) {
            	            alt74=1;
            	        }


            	        switch (alt74) {
            	    	case 1 :
            	    	    // /home/macan/Private/pl2py/PLSQL.g:1230:10: statement SEMI
            	    	    {
            	    	    indent_count++;
            	    	    pushFollow(FOLLOW_statement_in_case_statement2634);
            	    	    statement();

            	    	    state._fsp--;

            	    	    indent_count--;
            	    	    match(input,SEMI,FOLLOW_SEMI_in_case_statement2638); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt74 >= 1 ) break loop74;
            	                EarlyExitException eee =
            	                    new EarlyExitException(74, input);
            	                throw eee;
            	        }
            	        cnt74++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    if ( cnt75 >= 1 ) break loop75;
                        EarlyExitException eee =
                            new EarlyExitException(75, input);
                        throw eee;
                }
                cnt75++;
            } while (true);

            // /home/macan/Private/pl2py/PLSQL.g:1231:9: ( ELSE statement SEMI )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==ELSE) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1231:11: ELSE statement SEMI
                    {
                    match(input,ELSE,FOLLOW_ELSE_in_case_statement2656); 

                    	for(int i = 0; i < indent_count; i++)
                    	{	
                    		stat += '\t';
                    	}        
                            stat += "else:\n";
                            
                    indent_count++;
                    pushFollow(FOLLOW_statement_in_case_statement2679);
                    statement();

                    state._fsp--;

                    match(input,SEMI,FOLLOW_SEMI_in_case_statement2681); 
                    indent_count--;

                    }
                    break;

            }

            match(input,END,FOLLOW_END_in_case_statement2687); 
            match(input,CASE,FOLLOW_CASE_in_case_statement2689); 
            // /home/macan/Private/pl2py/PLSQL.g:1240:9: ( label_name )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==ID) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1240:9: label_name
                    {
                    pushFollow(FOLLOW_label_name_in_case_statement2709);
                    label_name();

                    state._fsp--;


                    }
                    break;

            }


            }


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "case_statement"


    // $ANTLR start "close_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1243:1: close_statement : CLOSE ID ( DOT ID )? ;
    public final void close_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1253:1: ( CLOSE ID ( DOT ID )? )
            // /home/macan/Private/pl2py/PLSQL.g:1254:2: CLOSE ID ( DOT ID )?
            {
            int start = input.LT(1).getTokenIndex();
            	stat += "#FIXME: CURSOR CLOSE STATEMENT\n";
            	for(int i = 0; i < indent_count; i++)
            	{	
            		stat += '\t';
            	}	
            	
            match(input,CLOSE,FOLLOW_CLOSE_in_close_statement2747); 
            match(input,ID,FOLLOW_ID_in_close_statement2749); 
            // /home/macan/Private/pl2py/PLSQL.g:1261:18: ( DOT ID )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==DOT) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1261:20: DOT ID
                    {
                    match(input,DOT,FOLLOW_DOT_in_close_statement2753); 
                    match(input,ID,FOLLOW_ID_in_close_statement2755); 

                    }
                    break;

            }


                    	stat += "pass";
                    

            }


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "close_statement"


    // $ANTLR start "continue_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1267:1: continue_statement : CONTINUE (lbl= ID )? ( WHEN expression )? ;
    public final void continue_statement() throws RecognitionException {
        Token lbl=null;


        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }
        String tmp = "";

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1278:1: ( CONTINUE (lbl= ID )? ( WHEN expression )? )
            // /home/macan/Private/pl2py/PLSQL.g:1279:5: CONTINUE (lbl= ID )? ( WHEN expression )?
            {
            match(input,CONTINUE,FOLLOW_CONTINUE_in_continue_statement2803); 
            // /home/macan/Private/pl2py/PLSQL.g:1279:14: (lbl= ID )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==ID) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1279:16: lbl= ID
                    {
                    lbl=(Token)match(input,ID,FOLLOW_ID_in_continue_statement2809); 

                    }
                    break;

            }

            // /home/macan/Private/pl2py/PLSQL.g:1279:26: ( WHEN expression )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==WHEN) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1279:28: WHEN expression
                    {
                    match(input,WHEN,FOLLOW_WHEN_in_continue_statement2816); 
                    pushFollow(FOLLOW_expression_in_continue_statement2818);
                    expression();

                    state._fsp--;


                    }
                    break;

            }


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


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "continue_statement"


    // $ANTLR start "execute_immediate_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1298:1: execute_immediate_statement : EXECUTE IMMEDIATE expression ( ( into_clause | bulk_collect_into_clause ) ( using_clause )? | using_clause ( dynamic_returning_clause )? | dynamic_returning_clause )? ;
    public final void execute_immediate_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }
        String tmp = "";

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1310:2: ( EXECUTE IMMEDIATE expression ( ( into_clause | bulk_collect_into_clause ) ( using_clause )? | using_clause ( dynamic_returning_clause )? | dynamic_returning_clause )? )
            // /home/macan/Private/pl2py/PLSQL.g:1311:9: EXECUTE IMMEDIATE expression ( ( into_clause | bulk_collect_into_clause ) ( using_clause )? | using_clause ( dynamic_returning_clause )? | dynamic_returning_clause )?
            {
            match(input,EXECUTE,FOLLOW_EXECUTE_in_execute_immediate_statement2868); 
            match(input,IMMEDIATE,FOLLOW_IMMEDIATE_in_execute_immediate_statement2870); 
            pushFollow(FOLLOW_expression_in_execute_immediate_statement2872);
            expression();

            state._fsp--;

            tmp = exp; exp = "";
            	  stat += "__line = tdw.execute(" + tmp.toLowerCase() + ")\n";
                     
            // /home/macan/Private/pl2py/PLSQL.g:1314:11: ( ( into_clause | bulk_collect_into_clause ) ( using_clause )? | using_clause ( dynamic_returning_clause )? | dynamic_returning_clause )?
            int alt84=4;
            switch ( input.LA(1) ) {
                case INTO:
                case BULK:
                    {
                    alt84=1;
                    }
                    break;
                case USING:
                    {
                    alt84=2;
                    }
                    break;
                case RETURN:
                case RETURNING:
                    {
                    alt84=3;
                    }
                    break;
            }

            switch (alt84) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1315:9: ( into_clause | bulk_collect_into_clause ) ( using_clause )?
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:1315:9: ( into_clause | bulk_collect_into_clause )
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==INTO) ) {
                        alt81=1;
                    }
                    else if ( (LA81_0==BULK) ) {
                        alt81=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 81, 0, input);

                        throw nvae;
                    }
                    switch (alt81) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:1315:11: into_clause
                            {
                            pushFollow(FOLLOW_into_clause_in_execute_immediate_statement2896);
                            into_clause();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // /home/macan/Private/pl2py/PLSQL.g:1317:11: bulk_collect_into_clause
                            {
                            pushFollow(FOLLOW_bulk_collect_into_clause_in_execute_immediate_statement2918);
                            bulk_collect_into_clause();

                            state._fsp--;


                            }
                            break;

                    }

                    // /home/macan/Private/pl2py/PLSQL.g:1317:37: ( using_clause )?
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==USING) ) {
                        alt82=1;
                    }
                    switch (alt82) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:1317:37: using_clause
                            {
                            pushFollow(FOLLOW_using_clause_in_execute_immediate_statement2921);
                            using_clause();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:1318:11: using_clause ( dynamic_returning_clause )?
                    {
                    pushFollow(FOLLOW_using_clause_in_execute_immediate_statement2934);
                    using_clause();

                    state._fsp--;

                    // /home/macan/Private/pl2py/PLSQL.g:1318:24: ( dynamic_returning_clause )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==RETURN||LA83_0==RETURNING) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:1318:24: dynamic_returning_clause
                            {
                            pushFollow(FOLLOW_dynamic_returning_clause_in_execute_immediate_statement2936);
                            dynamic_returning_clause();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:1319:11: dynamic_returning_clause
                    {
                    pushFollow(FOLLOW_dynamic_returning_clause_in_execute_immediate_statement2949);
                    dynamic_returning_clause();

                    state._fsp--;


                    }
                    break;

            }


            }


            stat += '\n';
            exp = "";

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "execute_immediate_statement"


    // $ANTLR start "exit_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1323:1: exit_statement : EXIT (lbl= ID )? ( WHEN expression )? ;
    public final void exit_statement() throws RecognitionException {
        Token lbl=null;


        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }
        String tmp = "";
        exp = "";

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1335:1: ( EXIT (lbl= ID )? ( WHEN expression )? )
            // /home/macan/Private/pl2py/PLSQL.g:1336:5: EXIT (lbl= ID )? ( WHEN expression )?
            {
            match(input,EXIT,FOLLOW_EXIT_in_exit_statement2989); 
            // /home/macan/Private/pl2py/PLSQL.g:1336:10: (lbl= ID )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==ID) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1336:12: lbl= ID
                    {
                    lbl=(Token)match(input,ID,FOLLOW_ID_in_exit_statement2995); 

                    }
                    break;

            }

            // /home/macan/Private/pl2py/PLSQL.g:1336:22: ( WHEN expression )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==WHEN) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1336:24: WHEN expression
                    {
                    match(input,WHEN,FOLLOW_WHEN_in_exit_statement3002); 
                    pushFollow(FOLLOW_expression_in_exit_statement3004);
                    expression();

                    state._fsp--;


                    }
                    break;

            }


                	if(exp.equals(""))
                	{
                		stat += "break";
                	} else if (exp.matches(".*% *NOTFOUND")) {
                		stat += "if " + exp.substring(0, exp.indexOf("%")) + " == \"\":\n";
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


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "exit_statement"


    // $ANTLR start "fetch_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1361:1: fetch_statement : FETCH qual_id ( into_clause | bulk_collect_into_clause ( LIMIT numeric_expression )? ) ;
    public final void fetch_statement() throws RecognitionException {

        	String v_cursor = "";
        	int saved_ic = indent_count;
        	for(int i = 0; i < indent_count; i++)
        	{	
        		stat += '\t';
        	}

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1394:1: ( FETCH qual_id ( into_clause | bulk_collect_into_clause ( LIMIT numeric_expression )? ) )
            // /home/macan/Private/pl2py/PLSQL.g:1395:2: FETCH qual_id ( into_clause | bulk_collect_into_clause ( LIMIT numeric_expression )? )
            {
            int start = input.LT(1).getTokenIndex();
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
            	
            match(input,FETCH,FOLLOW_FETCH_in_fetch_statement3048); 
            pushFollow(FOLLOW_qual_id_in_fetch_statement3050);
            qual_id();

            state._fsp--;


                    	v_cursor = input.LT(-1).getText().toLowerCase();
            		stat += "__line = " + v_cursor + "['result'][0]\n";
            		for(int i = 0; i < indent_count; i++)
            		{	
            			stat += '\t';
            		}
            		stat += "__line = __line.split(\"\\t\")\n";
                    
            // /home/macan/Private/pl2py/PLSQL.g:1418:9: ( into_clause | bulk_collect_into_clause ( LIMIT numeric_expression )? )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==INTO) ) {
                alt88=1;
            }
            else if ( (LA88_0==BULK) ) {
                alt88=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1418:11: into_clause
                    {
                    pushFollow(FOLLOW_into_clause_in_fetch_statement3073);
                    into_clause();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:1418:25: bulk_collect_into_clause ( LIMIT numeric_expression )?
                    {
                    pushFollow(FOLLOW_bulk_collect_into_clause_in_fetch_statement3077);
                    bulk_collect_into_clause();

                    state._fsp--;

                    // /home/macan/Private/pl2py/PLSQL.g:1418:50: ( LIMIT numeric_expression )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==LIMIT) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:1418:52: LIMIT numeric_expression
                            {
                            match(input,LIMIT,FOLLOW_LIMIT_in_fetch_statement3081); 
                            pushFollow(FOLLOW_numeric_expression_in_fetch_statement3083);
                            numeric_expression();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;

            }


            		for (int i = 0; i < indent_count; i++) {
            			stat += '\t';
            		}
            		stat += "__TMP__ = " + v_cursor + "['result'].pop(0)\n";
                    

            }


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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "fetch_statement"


    // $ANTLR start "into_clause"
    // /home/macan/Private/pl2py/PLSQL.g:1427:1: into_clause : INTO lvalue ( COMMA lvalue )* ;
    public final void into_clause() throws RecognitionException {

        	int __idx = 0;
        	String tmp = "", saved = stat;
        	stat = "";
        	for(int i = 0; i < indent_count; i++)
        	{	
        		tmp += '\t';
        	}

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1442:1: ( INTO lvalue ( COMMA lvalue )* )
            // /home/macan/Private/pl2py/PLSQL.g:1443:5: INTO lvalue ( COMMA lvalue )*
            {
            match(input,INTO,FOLLOW_INTO_in_into_clause3120); 
            pushFollow(FOLLOW_lvalue_in_into_clause3122);
            lvalue();

            state._fsp--;


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
                
            // /home/macan/Private/pl2py/PLSQL.g:1459:5: ( COMMA lvalue )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==COMMA) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:1459:7: COMMA lvalue
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_into_clause3133); 
            	    pushFollow(FOLLOW_lvalue_in_into_clause3135);
            	    lvalue();

            	    state._fsp--;


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
            	        	

            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);


            }


            	if (__idx == 0)
            		tmp += ")\n";
            	stat = saved + tmp;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "into_clause"


    // $ANTLR start "bulk_collect_into_clause"
    // /home/macan/Private/pl2py/PLSQL.g:1484:1: bulk_collect_into_clause : BULK COLLECT INTO lvalue ( COMMA lvalue )* ;
    public final void bulk_collect_into_clause() throws RecognitionException {

        	int __idx = 0;
        	String tmp = "", saved = stat;
        	stat = "";
        	for(int i = 0; i < indent_count; i++)
        	{	
        		tmp += '\t';
        	}

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1499:1: ( BULK COLLECT INTO lvalue ( COMMA lvalue )* )
            // /home/macan/Private/pl2py/PLSQL.g:1500:9: BULK COLLECT INTO lvalue ( COMMA lvalue )*
            {
            match(input,BULK,FOLLOW_BULK_in_bulk_collect_into_clause3177); 
            match(input,COLLECT,FOLLOW_COLLECT_in_bulk_collect_into_clause3179); 
            match(input,INTO,FOLLOW_INTO_in_bulk_collect_into_clause3181); 
            pushFollow(FOLLOW_lvalue_in_bulk_collect_into_clause3183);
            lvalue();

            state._fsp--;


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
                
            // /home/macan/Private/pl2py/PLSQL.g:1515:6: ( COMMA lvalue )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==COMMA) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:1515:8: COMMA lvalue
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_bulk_collect_into_clause3188); 
            	    pushFollow(FOLLOW_lvalue_in_bulk_collect_into_clause3190);
            	    lvalue();

            	    state._fsp--;


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
            	        	

            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);


            }


            	if (__idx == 0)
            		tmp += ")\n";
            	stat = saved + tmp;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "bulk_collect_into_clause"


    // $ANTLR start "using_clause"
    // /home/macan/Private/pl2py/PLSQL.g:1540:1: using_clause : USING ( param_modifiers )? expression ( COMMA ( param_modifiers )? expression )* ;
    public final void using_clause() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:1540:14: ( USING ( param_modifiers )? expression ( COMMA ( param_modifiers )? expression )* )
            // /home/macan/Private/pl2py/PLSQL.g:1541:9: USING ( param_modifiers )? expression ( COMMA ( param_modifiers )? expression )*
            {
            match(input,USING,FOLLOW_USING_in_using_clause3215); 
            // /home/macan/Private/pl2py/PLSQL.g:1541:15: ( param_modifiers )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( ((LA91_0>=IN && LA91_0<=OUT)) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1541:15: param_modifiers
                    {
                    pushFollow(FOLLOW_param_modifiers_in_using_clause3217);
                    param_modifiers();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_expression_in_using_clause3220);
            expression();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:1541:43: ( COMMA ( param_modifiers )? expression )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==COMMA) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:1541:45: COMMA ( param_modifiers )? expression
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_using_clause3224); 
            	    // /home/macan/Private/pl2py/PLSQL.g:1541:51: ( param_modifiers )?
            	    int alt92=2;
            	    int LA92_0 = input.LA(1);

            	    if ( ((LA92_0>=IN && LA92_0<=OUT)) ) {
            	        alt92=1;
            	    }
            	    switch (alt92) {
            	        case 1 :
            	            // /home/macan/Private/pl2py/PLSQL.g:1541:51: param_modifiers
            	            {
            	            pushFollow(FOLLOW_param_modifiers_in_using_clause3226);
            	            param_modifiers();

            	            state._fsp--;


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expression_in_using_clause3229);
            	    expression();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "using_clause"


    // $ANTLR start "param_modifiers"
    // /home/macan/Private/pl2py/PLSQL.g:1544:1: param_modifiers : ( IN ( OUT )? | OUT );
    public final void param_modifiers() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:1545:2: ( IN ( OUT )? | OUT )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==IN) ) {
                alt95=1;
            }
            else if ( (LA95_0==OUT) ) {
                alt95=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1545:4: IN ( OUT )?
                    {
                    match(input,IN,FOLLOW_IN_in_param_modifiers3246); 
                    // /home/macan/Private/pl2py/PLSQL.g:1545:7: ( OUT )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==OUT) ) {
                        alt94=1;
                    }
                    switch (alt94) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:1545:7: OUT
                            {
                            match(input,OUT,FOLLOW_OUT_in_param_modifiers3248); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:1545:14: OUT
                    {
                    match(input,OUT,FOLLOW_OUT_in_param_modifiers3253); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "param_modifiers"


    // $ANTLR start "dynamic_returning_clause"
    // /home/macan/Private/pl2py/PLSQL.g:1548:1: dynamic_returning_clause : ( RETURNING | RETURN ) ( into_clause | bulk_collect_into_clause ) ;
    public final void dynamic_returning_clause() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:1548:26: ( ( RETURNING | RETURN ) ( into_clause | bulk_collect_into_clause ) )
            // /home/macan/Private/pl2py/PLSQL.g:1549:9: ( RETURNING | RETURN ) ( into_clause | bulk_collect_into_clause )
            {
            if ( input.LA(1)==RETURN||input.LA(1)==RETURNING ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // /home/macan/Private/pl2py/PLSQL.g:1549:32: ( into_clause | bulk_collect_into_clause )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==INTO) ) {
                alt96=1;
            }
            else if ( (LA96_0==BULK) ) {
                alt96=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1549:34: into_clause
                    {
                    pushFollow(FOLLOW_into_clause_in_dynamic_returning_clause3283);
                    into_clause();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:1549:48: bulk_collect_into_clause
                    {
                    pushFollow(FOLLOW_bulk_collect_into_clause_in_dynamic_returning_clause3287);
                    bulk_collect_into_clause();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "dynamic_returning_clause"


    // $ANTLR start "for_loop_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1552:1: for_loop_statement : FOR ID IN (~ ( LOOP ) )+ LOOP ( statement SEMI )+ END LOOP ( label_name )? ;
    public final void for_loop_statement() throws RecognitionException {
        Token ID11=null;


        stat += '\n';
        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1562:2: ( FOR ID IN (~ ( LOOP ) )+ LOOP ( statement SEMI )+ END LOOP ( label_name )? )
            // /home/macan/Private/pl2py/PLSQL.g:1563:9: FOR ID IN (~ ( LOOP ) )+ LOOP ( statement SEMI )+ END LOOP ( label_name )?
            {
            match(input,FOR,FOLLOW_FOR_in_for_loop_statement3318); 
            ID11=(Token)match(input,ID,FOLLOW_ID_in_for_loop_statement3320); 
            match(input,IN,FOLLOW_IN_in_for_loop_statement3322); 
            int start = input.LT(1).getTokenIndex();
            // /home/macan/Private/pl2py/PLSQL.g:1565:9: (~ ( LOOP ) )+
            int cnt97=0;
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( ((LA97_0>=DIVIDE && LA97_0<=DELETE)||(LA97_0>=CASE && LA97_0<=PROMPT)) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:1565:11: ~ ( LOOP )
            	    {
            	    if ( (input.LA(1)>=DIVIDE && input.LA(1)<=DELETE)||(input.LA(1)>=CASE && input.LA(1)<=PROMPT) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt97 >= 1 ) break loop97;
                        EarlyExitException eee =
                            new EarlyExitException(97, input);
                        throw eee;
                }
                cnt97++;
            } while (true);

            int end = input.LT(-1).getTokenIndex();
                	int pos = end + 1;
                    while(input.get(pos).getChannel() != 0)
                    	pos++;
                    end = pos - 1;
                    String tmp = input.toString(start, end);
                    if(tmp.toUpperCase().contains("SELECT")) {
            	        has_collection_type = 1;
                    	collection_var_cnt++;
                		collection_variables[collection_var_cnt] = ID11.getText().toLowerCase();
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
                    		stat += "for " + ID11.getText().toLowerCase() + " in sqlresult:\n";
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
                 		        stat += "for " + ID11.getText().toLowerCase() + " in __TMP__['result'] :\n";
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
                    		stat += "for " + ID11.getText().toLowerCase() + " in " + tmp + ":\n";
                    	} else {
                    		// Is this a cursor variable?
                    		// Then, put the ID11.getText() in to the varlist
                    		has_collection_type = 1;
                    		collection_var_cnt++;
                			collection_variables[collection_var_cnt] = ID11.getText().toLowerCase();
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
                 		        stat += "for " + ID11.getText().toLowerCase() + " in " + tmp + "['result'] :\n";
                    	}
                    }
                    
            match(input,LOOP,FOLLOW_LOOP_in_for_loop_statement3379); 
            // /home/macan/Private/pl2py/PLSQL.g:1735:14: ( statement SEMI )+
            int cnt98=0;
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==ID||LA98_0==RETURN||LA98_0==NULL||LA98_0==BEGIN||(LA98_0>=COLON && LA98_0<=CASE)||(LA98_0>=CLOSE && LA98_0<=CONTINUE)||(LA98_0>=EXIT && LA98_0<=FETCH)||(LA98_0>=FOR && LA98_0<=FORALL)||(LA98_0>=GOTO && LA98_0<=IF)||LA98_0==OPEN||(LA98_0>=RAISE && LA98_0<=LLABEL)||(LA98_0>=COMMIT && LA98_0<=SET)||(LA98_0>=UPDATE && LA98_0<=WHILE)) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:1735:16: statement SEMI
            	    {

            	            indent_count++;
            	            
            	    pushFollow(FOLLOW_statement_in_for_loop_statement3385);
            	    statement();

            	    state._fsp--;

            	    indent_count--;
            	    match(input,SEMI,FOLLOW_SEMI_in_for_loop_statement3389); 

            	    }
            	    break;

            	default :
            	    if ( cnt98 >= 1 ) break loop98;
                        EarlyExitException eee =
                            new EarlyExitException(98, input);
                        throw eee;
                }
                cnt98++;
            } while (true);

            match(input,END,FOLLOW_END_in_for_loop_statement3394); 
            match(input,LOOP,FOLLOW_LOOP_in_for_loop_statement3396); 
            // /home/macan/Private/pl2py/PLSQL.g:1738:9: ( label_name )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==ID) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1738:9: label_name
                    {
                    pushFollow(FOLLOW_label_name_in_for_loop_statement3414);
                    label_name();

                    state._fsp--;


                    }
                    break;

            }


            }


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "for_loop_statement"


    // $ANTLR start "forall_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1741:1: forall_statement : FORALL ID IN bounds_clause sql_statement ( kSAVE kEXCEPTIONS )? ;
    public final void forall_statement() throws RecognitionException {
        Token ID12=null;


        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1751:1: ( FORALL ID IN bounds_clause sql_statement ( kSAVE kEXCEPTIONS )? )
            // /home/macan/Private/pl2py/PLSQL.g:1752:9: FORALL ID IN bounds_clause sql_statement ( kSAVE kEXCEPTIONS )?
            {
            match(input,FORALL,FOLLOW_FORALL_in_forall_statement3445); 
            ID12=(Token)match(input,ID,FOLLOW_ID_in_forall_statement3447); 
            match(input,IN,FOLLOW_IN_in_forall_statement3449); 
            int start = input.LT(1).getTokenIndex();
            pushFollow(FOLLOW_bounds_clause_in_forall_statement3487);
            bounds_clause();

            state._fsp--;

            int end = input.LT(-1).getTokenIndex();
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
                    stat += "for " + ID12.getText().toLowerCase() + " in " + tmp + " :\n";
                    
            indent_count++;
            pushFollow(FOLLOW_sql_statement_in_forall_statement3527);
            sql_statement();

            state._fsp--;

             indent_count--;
            // /home/macan/Private/pl2py/PLSQL.g:1772:9: ( kSAVE kEXCEPTIONS )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==ID) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1772:11: kSAVE kEXCEPTIONS
                    {
                    pushFollow(FOLLOW_kSAVE_in_forall_statement3550);
                    kSAVE();

                    state._fsp--;

                    pushFollow(FOLLOW_kEXCEPTIONS_in_forall_statement3552);
                    kEXCEPTIONS();

                    state._fsp--;


                    }
                    break;

            }


            }


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "forall_statement"


    // $ANTLR start "bounds_clause"
    // /home/macan/Private/pl2py/PLSQL.g:1775:1: bounds_clause : ( numeric_expression DOUBLEDOT numeric_expression | kINDICES kOF atom ( BETWEEN numeric_expression AND numeric_expression )? | kVALUES kOF atom );
    public final void bounds_clause() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:1776:5: ( numeric_expression DOUBLEDOT numeric_expression | kINDICES kOF atom ( BETWEEN numeric_expression AND numeric_expression )? | kVALUES kOF atom )
            int alt102=3;
            alt102 = dfa102.predict(input);
            switch (alt102) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1776:7: numeric_expression DOUBLEDOT numeric_expression
                    {
                    pushFollow(FOLLOW_numeric_expression_in_bounds_clause3582);
                    numeric_expression();

                    state._fsp--;

                    exp = "";
                    match(input,DOUBLEDOT,FOLLOW_DOUBLEDOT_in_bounds_clause3586); 
                    pushFollow(FOLLOW_numeric_expression_in_bounds_clause3588);
                    numeric_expression();

                    state._fsp--;

                    exp = "";

                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:1777:7: kINDICES kOF atom ( BETWEEN numeric_expression AND numeric_expression )?
                    {
                    pushFollow(FOLLOW_kINDICES_in_bounds_clause3598);
                    kINDICES();

                    state._fsp--;

                    pushFollow(FOLLOW_kOF_in_bounds_clause3600);
                    kOF();

                    state._fsp--;

                    pushFollow(FOLLOW_atom_in_bounds_clause3602);
                    atom();

                    state._fsp--;

                    // /home/macan/Private/pl2py/PLSQL.g:1777:25: ( BETWEEN numeric_expression AND numeric_expression )?
                    int alt101=2;
                    int LA101_0 = input.LA(1);

                    if ( (LA101_0==BETWEEN) ) {
                        alt101=1;
                    }
                    switch (alt101) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:1777:27: BETWEEN numeric_expression AND numeric_expression
                            {
                            match(input,BETWEEN,FOLLOW_BETWEEN_in_bounds_clause3606); 
                            pushFollow(FOLLOW_numeric_expression_in_bounds_clause3608);
                            numeric_expression();

                            state._fsp--;

                            exp = "";
                            match(input,AND,FOLLOW_AND_in_bounds_clause3612); 
                            pushFollow(FOLLOW_numeric_expression_in_bounds_clause3614);
                            numeric_expression();

                            state._fsp--;

                            exp = "";

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:1778:7: kVALUES kOF atom
                    {
                    pushFollow(FOLLOW_kVALUES_in_bounds_clause3627);
                    kVALUES();

                    state._fsp--;

                    pushFollow(FOLLOW_kOF_in_bounds_clause3629);
                    kOF();

                    state._fsp--;

                    pushFollow(FOLLOW_atom_in_bounds_clause3631);
                    atom();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "bounds_clause"


    // $ANTLR start "goto_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1781:1: goto_statement : GOTO ID ;
    public final void goto_statement() throws RecognitionException {
        Token ID13=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1781:16: ( GOTO ID )
            // /home/macan/Private/pl2py/PLSQL.g:1782:9: GOTO ID
            {
            match(input,GOTO,FOLLOW_GOTO_in_goto_statement3655); 
            ID13=(Token)match(input,ID,FOLLOW_ID_in_goto_statement3657); 

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
            		stat += "# goto " + ID13.getText().toLowerCase() + "\n";
            		for(int i = 0; i < indent_count; i++)
            		{
            			stat += '\t';
            		}
            		stat += "pass\n";
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "goto_statement"


    // $ANTLR start "if_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1803:1: if_statement : IF expression THEN ( statement SEMI )+ ( ELSIF expression THEN ( statement SEMI )+ )* ( ELSE ( statement SEMI )+ )? END IF ;
    public final void if_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1812:2: ( IF expression THEN ( statement SEMI )+ ( ELSIF expression THEN ( statement SEMI )+ )* ( ELSE ( statement SEMI )+ )? END IF )
            // /home/macan/Private/pl2py/PLSQL.g:1813:9: IF expression THEN ( statement SEMI )+ ( ELSIF expression THEN ( statement SEMI )+ )* ( ELSE ( statement SEMI )+ )? END IF
            {
            match(input,IF,FOLLOW_IF_in_if_statement3696); 
            pushFollow(FOLLOW_expression_in_if_statement3698);
            expression();

            state._fsp--;

            match(input,THEN,FOLLOW_THEN_in_if_statement3700); 

                	stat += "if " + exp + ":\n"; exp = "";
            // /home/macan/Private/pl2py/PLSQL.g:1816:9: ( statement SEMI )+
            int cnt103=0;
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==ID||LA103_0==RETURN||LA103_0==NULL||LA103_0==BEGIN||(LA103_0>=COLON && LA103_0<=CASE)||(LA103_0>=CLOSE && LA103_0<=CONTINUE)||(LA103_0>=EXIT && LA103_0<=FETCH)||(LA103_0>=FOR && LA103_0<=FORALL)||(LA103_0>=GOTO && LA103_0<=IF)||LA103_0==OPEN||(LA103_0>=RAISE && LA103_0<=LLABEL)||(LA103_0>=COMMIT && LA103_0<=SET)||(LA103_0>=UPDATE && LA103_0<=WHILE)) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:1816:11: statement SEMI
            	    {
            	    indent_count++;
            	    pushFollow(FOLLOW_statement_in_if_statement3730);
            	    statement();

            	    state._fsp--;

            	    indent_count--;
            	    match(input,SEMI,FOLLOW_SEMI_in_if_statement3734); 

            	    }
            	    break;

            	default :
            	    if ( cnt103 >= 1 ) break loop103;
                        EarlyExitException eee =
                            new EarlyExitException(103, input);
                        throw eee;
                }
                cnt103++;
            } while (true);

            // /home/macan/Private/pl2py/PLSQL.g:1817:9: ( ELSIF expression THEN ( statement SEMI )+ )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==ELSIF) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:1817:11: ELSIF expression THEN ( statement SEMI )+
            	    {
            	    match(input,ELSIF,FOLLOW_ELSIF_in_if_statement3749); 
            	    pushFollow(FOLLOW_expression_in_if_statement3752);
            	    expression();

            	    state._fsp--;

            	    match(input,THEN,FOLLOW_THEN_in_if_statement3754); 

            	    	for(int i = 0; i < indent_count; i++)
            	    	{	
            	    		stat += '\t';
            	    	}	
            	    	stat += "elif " + exp + ":\n"; exp = "";
            	    // /home/macan/Private/pl2py/PLSQL.g:1824:9: ( statement SEMI )+
            	    int cnt104=0;
            	    loop104:
            	    do {
            	        int alt104=2;
            	        int LA104_0 = input.LA(1);

            	        if ( (LA104_0==ID||LA104_0==RETURN||LA104_0==NULL||LA104_0==BEGIN||(LA104_0>=COLON && LA104_0<=CASE)||(LA104_0>=CLOSE && LA104_0<=CONTINUE)||(LA104_0>=EXIT && LA104_0<=FETCH)||(LA104_0>=FOR && LA104_0<=FORALL)||(LA104_0>=GOTO && LA104_0<=IF)||LA104_0==OPEN||(LA104_0>=RAISE && LA104_0<=LLABEL)||(LA104_0>=COMMIT && LA104_0<=SET)||(LA104_0>=UPDATE && LA104_0<=WHILE)) ) {
            	            alt104=1;
            	        }


            	        switch (alt104) {
            	    	case 1 :
            	    	    // /home/macan/Private/pl2py/PLSQL.g:1824:11: statement SEMI
            	    	    {
            	    	    indent_count++;
            	    	    pushFollow(FOLLOW_statement_in_if_statement3781);
            	    	    statement();

            	    	    state._fsp--;

            	    	    indent_count--;
            	    	    match(input,SEMI,FOLLOW_SEMI_in_if_statement3785); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt104 >= 1 ) break loop104;
            	                EarlyExitException eee =
            	                    new EarlyExitException(104, input);
            	                throw eee;
            	        }
            	        cnt104++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop105;
                }
            } while (true);

            // /home/macan/Private/pl2py/PLSQL.g:1825:9: ( ELSE ( statement SEMI )+ )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==ELSE) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1825:11: ELSE ( statement SEMI )+
                    {
                    match(input,ELSE,FOLLOW_ELSE_in_if_statement3803); 

                    	for(int i = 0; i < indent_count; i++)
                    	{	
                    		stat += '\t';
                    	}	
                    	stat += "else " + ":\n"; exp = "";
                    // /home/macan/Private/pl2py/PLSQL.g:1832:9: ( statement SEMI )+
                    int cnt106=0;
                    loop106:
                    do {
                        int alt106=2;
                        int LA106_0 = input.LA(1);

                        if ( (LA106_0==ID||LA106_0==RETURN||LA106_0==NULL||LA106_0==BEGIN||(LA106_0>=COLON && LA106_0<=CASE)||(LA106_0>=CLOSE && LA106_0<=CONTINUE)||(LA106_0>=EXIT && LA106_0<=FETCH)||(LA106_0>=FOR && LA106_0<=FORALL)||(LA106_0>=GOTO && LA106_0<=IF)||LA106_0==OPEN||(LA106_0>=RAISE && LA106_0<=LLABEL)||(LA106_0>=COMMIT && LA106_0<=SET)||(LA106_0>=UPDATE && LA106_0<=WHILE)) ) {
                            alt106=1;
                        }


                        switch (alt106) {
                    	case 1 :
                    	    // /home/macan/Private/pl2py/PLSQL.g:1832:11: statement SEMI
                    	    {
                    	    indent_count++;
                    	    pushFollow(FOLLOW_statement_in_if_statement3833);
                    	    statement();

                    	    state._fsp--;

                    	    indent_count--;
                    	    match(input,SEMI,FOLLOW_SEMI_in_if_statement3837); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt106 >= 1 ) break loop106;
                                EarlyExitException eee =
                                    new EarlyExitException(106, input);
                                throw eee;
                        }
                        cnt106++;
                    } while (true);


                    }
                    break;

            }

            match(input,END,FOLLOW_END_in_if_statement3860); 
            match(input,IF,FOLLOW_IF_in_if_statement3862); 

            }


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "if_statement"


    // $ANTLR start "null_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1836:1: null_statement : NULL ;
    public final void null_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1846:1: ( NULL )
            // /home/macan/Private/pl2py/PLSQL.g:1847:5: NULL
            {
            match(input,NULL,FOLLOW_NULL_in_null_statement3898); 
            stat += "None";

            }


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "null_statement"


    // $ANTLR start "open_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1850:1: open_statement : OPEN ID ( DOT ID )* ( call_args )? ( FOR ( select_statement | ID ) )? ;
    public final void open_statement() throws RecognitionException {

        int is_static = 1;
        stat += '\n';
        String cursor_name = "";
        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1863:1: ( OPEN ID ( DOT ID )* ( call_args )? ( FOR ( select_statement | ID ) )? )
            // /home/macan/Private/pl2py/PLSQL.g:1864:2: OPEN ID ( DOT ID )* ( call_args )? ( FOR ( select_statement | ID ) )?
            {
            int start = input.LT(1).getTokenIndex();
            	stat += "# FIXME: CURSOR OPEN STATEMENT\n";
            	for(int i = 0; i < indent_count; i++)
            	{	
            		stat += '\t';
            	}	
            	
            match(input,OPEN,FOLLOW_OPEN_in_open_statement3942); 
            match(input,ID,FOLLOW_ID_in_open_statement3944); 
            cursor_name = input.LT(-1).getText().toLowerCase(); stat += cursor_name + " = ({'isopen':1, 'result':";
            // /home/macan/Private/pl2py/PLSQL.g:1871:123: ( DOT ID )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==DOT) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:1871:125: DOT ID
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_open_statement3950); 
            	    match(input,ID,FOLLOW_ID_in_open_statement3952); 

            	    }
            	    break;

            	default :
            	    break loop108;
                }
            } while (true);

            // /home/macan/Private/pl2py/PLSQL.g:1871:135: ( call_args )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==LPAREN) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1871:135: call_args
                    {
                    pushFollow(FOLLOW_call_args_in_open_statement3957);
                    call_args();

                    state._fsp--;


                    }
                    break;

            }

            // /home/macan/Private/pl2py/PLSQL.g:1872:9: ( FOR ( select_statement | ID ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==FOR) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1872:11: FOR ( select_statement | ID )
                    {
                    match(input,FOR,FOLLOW_FOR_in_open_statement3971); 
                    // /home/macan/Private/pl2py/PLSQL.g:1872:15: ( select_statement | ID )
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( (LA110_0==SELECT) ) {
                        alt110=1;
                    }
                    else if ( (LA110_0==ID) ) {
                        alt110=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 110, 0, input);

                        throw nvae;
                    }
                    switch (alt110) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:1872:16: select_statement
                            {
                            pushFollow(FOLLOW_select_statement_in_open_statement3974);
                            select_statement();

                            state._fsp--;

                            is_static =0; stat += "tdw.execute(" + __sql + ")"; __sql = "";

                            }
                            break;
                        case 2 :
                            // /home/macan/Private/pl2py/PLSQL.g:1872:100: ID
                            {
                            match(input,ID,FOLLOW_ID_in_open_statement3979); 

                                     is_static = 0;
                                     stat += "tdw.execute(" + input.LT(-1).getText().toLowerCase() + ")";
                                     

                            }
                            break;

                    }


                    }
                    break;

            }


                     	if (is_static == 1) {
                     		stat += "tdw.execute(" + cursor_name + "['sql'])";
                     	}
                    	stat += "})\n";
                    

            }


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "open_statement"


    // $ANTLR start "pragma"
    // /home/macan/Private/pl2py/PLSQL.g:1883:1: pragma : PRAGMA swallow_to_semi ;
    public final void pragma() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:1883:8: ( PRAGMA swallow_to_semi )
            // /home/macan/Private/pl2py/PLSQL.g:1884:9: PRAGMA swallow_to_semi
            {
            match(input,PRAGMA,FOLLOW_PRAGMA_in_pragma4015); 
            pushFollow(FOLLOW_swallow_to_semi_in_pragma4017);
            swallow_to_semi();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pragma"


    // $ANTLR start "raise_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1887:1: raise_statement : RAISE ( ID ( DOT ID )* )? ;
    public final void raise_statement() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:1890:2: ( RAISE ( ID ( DOT ID )* )? )
            // /home/macan/Private/pl2py/PLSQL.g:1891:8: RAISE ( ID ( DOT ID )* )?
            {
            match(input,RAISE,FOLLOW_RAISE_in_raise_statement4041); 

            	for(int i = 0; i < indent_count; i++)
            	{	
            		stat += '\t';
            	}
            	stat += "tdw.tdw_raise(-22, ";
                   
            // /home/macan/Private/pl2py/PLSQL.g:1898:8: ( ID ( DOT ID )* )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==ID) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1898:10: ID ( DOT ID )*
                    {
                    match(input,ID,FOLLOW_ID_in_raise_statement4054); 
                    stat += input.LT(-1).getText().toLowerCase();
                    // /home/macan/Private/pl2py/PLSQL.g:1898:61: ( DOT ID )*
                    loop112:
                    do {
                        int alt112=2;
                        int LA112_0 = input.LA(1);

                        if ( (LA112_0==DOT) ) {
                            alt112=1;
                        }


                        switch (alt112) {
                    	case 1 :
                    	    // /home/macan/Private/pl2py/PLSQL.g:1898:63: DOT ID
                    	    {
                    	    match(input,DOT,FOLLOW_DOT_in_raise_statement4060); 
                    	    stat += "."; 
                    	    match(input,ID,FOLLOW_ID_in_raise_statement4064); 

                    	           stat += input.LT(-1).getText().toLowerCase();
                    	           

                    	    }
                    	    break;

                    	default :
                    	    break loop112;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            stat += ");\n";

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "raise_statement"


    // $ANTLR start "return_statement"
    // /home/macan/Private/pl2py/PLSQL.g:1903:1: return_statement : RETURN ( expression )? ;
    public final void return_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1913:1: ( RETURN ( expression )? )
            // /home/macan/Private/pl2py/PLSQL.g:1914:6: RETURN ( expression )?
            {
            match(input,RETURN,FOLLOW_RETURN_in_return_statement4107); 
            stat += "return ";
            // /home/macan/Private/pl2py/PLSQL.g:1914:34: ( expression )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==ID||LA114_0==LPAREN||(LA114_0>=NOT && LA114_0<=NULL)||LA114_0==COLON||(LA114_0>=MINUS && LA114_0<=PLUS)||(LA114_0>=SQL && LA114_0<=INTEGER)||(LA114_0>=REAL_NUMBER && LA114_0<=QUOTED_STRING)||(LA114_0>=INSERTING && LA114_0<=DELETING)) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1914:34: expression
                    {
                    pushFollow(FOLLOW_expression_in_return_statement4111);
                    expression();

                    state._fsp--;


                    }
                    break;

            }

            if(!exp.equals("")) 
                	{
                		stat += exp;
                		exp = "";
                	}
                	

            }


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "return_statement"


    // $ANTLR start "plsql_block"
    // /home/macan/Private/pl2py/PLSQL.g:1923:1: plsql_block : ( DECLARE declare_section )? body_block ;
    public final void plsql_block() throws RecognitionException {

        int saved_cp = create_package;
        create_package = 0;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1931:1: ( ( DECLARE declare_section )? body_block )
            // /home/macan/Private/pl2py/PLSQL.g:1932:6: ( DECLARE declare_section )? body_block
            {
            // /home/macan/Private/pl2py/PLSQL.g:1932:6: ( DECLARE declare_section )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==DECLARE) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1932:8: DECLARE declare_section
                    {
                    match(input,DECLARE,FOLLOW_DECLARE_in_plsql_block4150); 
                    pushFollow(FOLLOW_declare_section_in_plsql_block4152);
                    declare_section();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_body_block_in_plsql_block4157);
            body_block();

            state._fsp--;


            }


            create_package = saved_cp;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "plsql_block"


    // $ANTLR start "body_block"
    // /home/macan/Private/pl2py/PLSQL.g:1935:1: body_block : BEGIN statement SEMI ( statement SEMI | pragma SEMI )* ( EXCEPTION ( exception_handler )+ )? END ( ID )? ;
    public final void body_block() throws RecognitionException {

        indent_count++;
        int has_exception_handler = 0;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1943:2: ( BEGIN statement SEMI ( statement SEMI | pragma SEMI )* ( EXCEPTION ( exception_handler )+ )? END ( ID )? )
            // /home/macan/Private/pl2py/PLSQL.g:1944:2: BEGIN statement SEMI ( statement SEMI | pragma SEMI )* ( EXCEPTION ( exception_handler )+ )? END ( ID )?
            {
            match(input,BEGIN,FOLLOW_BEGIN_in_body_block4181); 

            		for (int i = 0; i < indent_count-1; i++) {
            			stat += "\t";
            		}
            		stat += "# BEGIN a BODY AGAIN\n";
            		for (int i = 0; i < indent_count-1; i++) {
            			stat += "\t";
            		}
            		stat += "try:\n";
            	
            pushFollow(FOLLOW_statement_in_body_block4186);
            statement();

            state._fsp--;


            		if (!stat.equals("")) {
            			output += stat;
            			stat = "";
            		}
            	
            match(input,SEMI,FOLLOW_SEMI_in_body_block4191); 
            // /home/macan/Private/pl2py/PLSQL.g:1960:7: ( statement SEMI | pragma SEMI )*
            loop116:
            do {
                int alt116=3;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==ID||LA116_0==RETURN||LA116_0==NULL||LA116_0==BEGIN||(LA116_0>=COLON && LA116_0<=CASE)||(LA116_0>=CLOSE && LA116_0<=CONTINUE)||(LA116_0>=EXIT && LA116_0<=FETCH)||(LA116_0>=FOR && LA116_0<=FORALL)||(LA116_0>=GOTO && LA116_0<=IF)||LA116_0==OPEN||(LA116_0>=RAISE && LA116_0<=LLABEL)||(LA116_0>=COMMIT && LA116_0<=SET)||(LA116_0>=UPDATE && LA116_0<=WHILE)) ) {
                    alt116=1;
                }
                else if ( (LA116_0==PRAGMA) ) {
                    alt116=2;
                }


                switch (alt116) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:1960:9: statement SEMI
            	    {
            	    pushFollow(FOLLOW_statement_in_body_block4195);
            	    statement();

            	    state._fsp--;


            	    		if (!stat.equals("")) {
            	    			output += stat;
            	    			stat = "";
            	    		}
            	    	
            	    match(input,SEMI,FOLLOW_SEMI_in_body_block4200); 

            	    }
            	    break;
            	case 2 :
            	    // /home/macan/Private/pl2py/PLSQL.g:1966:9: pragma SEMI
            	    {
            	    pushFollow(FOLLOW_pragma_in_body_block4204);
            	    pragma();

            	    state._fsp--;

            	    match(input,SEMI,FOLLOW_SEMI_in_body_block4206); 

            	    }
            	    break;

            	default :
            	    break loop116;
                }
            } while (true);

            // /home/macan/Private/pl2py/PLSQL.g:1967:2: ( EXCEPTION ( exception_handler )+ )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==EXCEPTION) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1968:2: EXCEPTION ( exception_handler )+
                    {

                    		stat = "";
                        	
                    match(input,EXCEPTION,FOLLOW_EXCEPTION_in_body_block4220); 
                    has_exception_handler = 1;
                    // /home/macan/Private/pl2py/PLSQL.g:1971:41: ( exception_handler )+
                    int cnt117=0;
                    loop117:
                    do {
                        int alt117=2;
                        int LA117_0 = input.LA(1);

                        if ( (LA117_0==WHEN) ) {
                            alt117=1;
                        }


                        switch (alt117) {
                    	case 1 :
                    	    // /home/macan/Private/pl2py/PLSQL.g:1971:41: exception_handler
                    	    {
                    	    pushFollow(FOLLOW_exception_handler_in_body_block4224);
                    	    exception_handler();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt117 >= 1 ) break loop117;
                                EarlyExitException eee =
                                    new EarlyExitException(117, input);
                                throw eee;
                        }
                        cnt117++;
                    } while (true);


                    }
                    break;

            }

            match(input,END,FOLLOW_END_in_body_block4232); 

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
            	
            // /home/macan/Private/pl2py/PLSQL.g:1984:3: ( ID )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==ID) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:1984:3: ID
                    {
                    match(input,ID,FOLLOW_ID_in_body_block4235); 

                    }
                    break;

            }


            }


            indent_count--;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "body_block"


    // $ANTLR start "label"
    // /home/macan/Private/pl2py/PLSQL.g:1987:1: label : LLABEL ID RLABEL ;
    public final void label() throws RecognitionException {
        Token ID14=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:1987:7: ( LLABEL ID RLABEL )
            // /home/macan/Private/pl2py/PLSQL.g:1988:9: LLABEL ID RLABEL
            {
            match(input,LLABEL,FOLLOW_LLABEL_in_label4261); 
            ID14=(Token)match(input,ID,FOLLOW_ID_in_label4263); 
            match(input,RLABEL,FOLLOW_RLABEL_in_label4265); 

                    	for (int i = 0; i < indent_count; i++) {
            				stat += "\t";
            		}
                    	stat += "# FIXME: there is no goto statement in python. Please fix it!\n";
                    	for (int i = 0; i < indent_count; i++) {
            				stat += "\t";
            		}
            		stat += "# <<" + ID14.getText().toLowerCase() + ">>\n";
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "label"


    // $ANTLR start "qual_id"
    // /home/macan/Private/pl2py/PLSQL.g:2001:1: qual_id : ( COLON )? ID ( DOT ( COLON )? ID )* ;
    public final void qual_id() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2001:9: ( ( COLON )? ID ( DOT ( COLON )? ID )* )
            // /home/macan/Private/pl2py/PLSQL.g:2002:5: ( COLON )? ID ( DOT ( COLON )? ID )*
            {
            // /home/macan/Private/pl2py/PLSQL.g:2002:5: ( COLON )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==COLON) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2002:5: COLON
                    {
                    match(input,COLON,FOLLOW_COLON_in_qual_id4292); 

                    }
                    break;

            }

            match(input,ID,FOLLOW_ID_in_qual_id4295); 
            // /home/macan/Private/pl2py/PLSQL.g:2002:15: ( DOT ( COLON )? ID )*
            loop122:
            do {
                int alt122=2;
                int LA122_0 = input.LA(1);

                if ( (LA122_0==DOT) ) {
                    alt122=1;
                }


                switch (alt122) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:2002:17: DOT ( COLON )? ID
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_qual_id4299); 
            	    // /home/macan/Private/pl2py/PLSQL.g:2002:21: ( COLON )?
            	    int alt121=2;
            	    int LA121_0 = input.LA(1);

            	    if ( (LA121_0==COLON) ) {
            	        alt121=1;
            	    }
            	    switch (alt121) {
            	        case 1 :
            	            // /home/macan/Private/pl2py/PLSQL.g:2002:21: COLON
            	            {
            	            match(input,COLON,FOLLOW_COLON_in_qual_id4301); 

            	            }
            	            break;

            	    }

            	    match(input,ID,FOLLOW_ID_in_qual_id4304); 

            	    }
            	    break;

            	default :
            	    break loop122;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "qual_id"


    // $ANTLR start "sql_statement"
    // /home/macan/Private/pl2py/PLSQL.g:2005:1: sql_statement : ( commit_statement | delete_statement | insert_statement | lock_table_statement | rollback_statement | savepoint_statement | select_statement | set_transaction_statement | update_statement | merge_statement );
    public final void sql_statement() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2006:5: ( commit_statement | delete_statement | insert_statement | lock_table_statement | rollback_statement | savepoint_statement | select_statement | set_transaction_statement | update_statement | merge_statement )
            int alt123=10;
            switch ( input.LA(1) ) {
            case COMMIT:
                {
                alt123=1;
                }
                break;
            case DELETE:
                {
                alt123=2;
                }
                break;
            case INSERT:
                {
                alt123=3;
                }
                break;
            case LOCK:
                {
                alt123=4;
                }
                break;
            case ROLLBACK:
                {
                alt123=5;
                }
                break;
            case SAVEPOINT:
                {
                alt123=6;
                }
                break;
            case SELECT:
                {
                alt123=7;
                }
                break;
            case SET:
                {
                alt123=8;
                }
                break;
            case UPDATE:
                {
                alt123=9;
                }
                break;
            case MERGE:
                {
                alt123=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }

            switch (alt123) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2006:7: commit_statement
                    {
                    pushFollow(FOLLOW_commit_statement_in_sql_statement4325);
                    commit_statement();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:2007:7: delete_statement
                    {
                    pushFollow(FOLLOW_delete_statement_in_sql_statement4333);
                    delete_statement();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:2008:7: insert_statement
                    {
                    pushFollow(FOLLOW_insert_statement_in_sql_statement4342);
                    insert_statement();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // /home/macan/Private/pl2py/PLSQL.g:2009:7: lock_table_statement
                    {
                    pushFollow(FOLLOW_lock_table_statement_in_sql_statement4351);
                    lock_table_statement();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // /home/macan/Private/pl2py/PLSQL.g:2010:7: rollback_statement
                    {
                    pushFollow(FOLLOW_rollback_statement_in_sql_statement4360);
                    rollback_statement();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // /home/macan/Private/pl2py/PLSQL.g:2011:7: savepoint_statement
                    {
                    pushFollow(FOLLOW_savepoint_statement_in_sql_statement4369);
                    savepoint_statement();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // /home/macan/Private/pl2py/PLSQL.g:2012:7: select_statement
                    {
                    pushFollow(FOLLOW_select_statement_in_sql_statement4378);
                    select_statement();

                    state._fsp--;


                    }
                    break;
                case 8 :
                    // /home/macan/Private/pl2py/PLSQL.g:2013:7: set_transaction_statement
                    {
                    pushFollow(FOLLOW_set_transaction_statement_in_sql_statement4387);
                    set_transaction_statement();

                    state._fsp--;


                    }
                    break;
                case 9 :
                    // /home/macan/Private/pl2py/PLSQL.g:2014:7: update_statement
                    {
                    pushFollow(FOLLOW_update_statement_in_sql_statement4395);
                    update_statement();

                    state._fsp--;


                    }
                    break;
                case 10 :
                    // /home/macan/Private/pl2py/PLSQL.g:2015:7: merge_statement
                    {
                    pushFollow(FOLLOW_merge_statement_in_sql_statement4404);
                    merge_statement();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "sql_statement"


    // $ANTLR start "commit_statement"
    // /home/macan/Private/pl2py/PLSQL.g:2018:1: commit_statement : COMMIT ( swallow_to_semi )? ;
    public final void commit_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2028:1: ( COMMIT ( swallow_to_semi )? )
            // /home/macan/Private/pl2py/PLSQL.g:2029:5: COMMIT ( swallow_to_semi )?
            {
            match(input,COMMIT,FOLLOW_COMMIT_in_commit_statement4431); 
            // /home/macan/Private/pl2py/PLSQL.g:2029:12: ( swallow_to_semi )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==ID) ) {
                int LA124_1 = input.LA(2);

                if ( ((LA124_1>=DIVIDE && LA124_1<=PROCEDURE)||(LA124_1>=FUNCTION && LA124_1<=PROMPT)) ) {
                    alt124=1;
                }
                else if ( (LA124_1==ID) ) {
                    alt124=1;
                }
            }
            else if ( (LA124_0==DIVIDE||LA124_0==PROCEDURE||(LA124_0>=FUNCTION && LA124_0<=PROMPT)) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2029:12: swallow_to_semi
                    {
                    pushFollow(FOLLOW_swallow_to_semi_in_commit_statement4433);
                    swallow_to_semi();

                    state._fsp--;


                    }
                    break;

            }


                    	stat += "commit()";
                

            }


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "commit_statement"


    // $ANTLR start "delete_statement"
    // /home/macan/Private/pl2py/PLSQL.g:2035:1: delete_statement : DELETE swallow_to_semi ;
    public final void delete_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2045:1: ( DELETE swallow_to_semi )
            // /home/macan/Private/pl2py/PLSQL.g:2046:2: DELETE swallow_to_semi
            {
            int start = input.LT(1).getTokenIndex();
            match(input,DELETE,FOLLOW_DELETE_in_delete_statement4476); 
            pushFollow(FOLLOW_swallow_to_semi_in_delete_statement4478);
            swallow_to_semi();

            state._fsp--;

            int end = input.LT(-1).getTokenIndex();
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


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "delete_statement"


    // $ANTLR start "insert_statement"
    // /home/macan/Private/pl2py/PLSQL.g:2064:1: insert_statement : INSERT swallow_to_semi ;
    public final void insert_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2074:1: ( INSERT swallow_to_semi )
            // /home/macan/Private/pl2py/PLSQL.g:2075:2: INSERT swallow_to_semi
            {
            int start = input.LT(1).getTokenIndex();
            match(input,INSERT,FOLLOW_INSERT_in_insert_statement4530); 
            pushFollow(FOLLOW_swallow_to_semi_in_insert_statement4532);
            swallow_to_semi();

            state._fsp--;

            int end = input.LT(-1).getTokenIndex();
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


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "insert_statement"


    // $ANTLR start "lock_table_statement"
    // /home/macan/Private/pl2py/PLSQL.g:2092:1: lock_table_statement : LOCK TABLE swallow_to_semi ;
    public final void lock_table_statement() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2092:22: ( LOCK TABLE swallow_to_semi )
            // /home/macan/Private/pl2py/PLSQL.g:2093:9: LOCK TABLE swallow_to_semi
            {
            match(input,LOCK,FOLLOW_LOCK_in_lock_table_statement4566); 
            match(input,TABLE,FOLLOW_TABLE_in_lock_table_statement4568); 
            pushFollow(FOLLOW_swallow_to_semi_in_lock_table_statement4570);
            swallow_to_semi();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "lock_table_statement"


    // $ANTLR start "rollback_statement"
    // /home/macan/Private/pl2py/PLSQL.g:2096:1: rollback_statement : ROLLBACK ( swallow_to_semi )? ;
    public final void rollback_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2106:1: ( ROLLBACK ( swallow_to_semi )? )
            // /home/macan/Private/pl2py/PLSQL.g:2107:9: ROLLBACK ( swallow_to_semi )?
            {
            match(input,ROLLBACK,FOLLOW_ROLLBACK_in_rollback_statement4600); 
            // /home/macan/Private/pl2py/PLSQL.g:2107:18: ( swallow_to_semi )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==ID) ) {
                int LA125_1 = input.LA(2);

                if ( (LA125_1==SEMI||LA125_1==ID) ) {
                    alt125=1;
                }
                else if ( (LA125_1==DIVIDE||LA125_1==PROCEDURE||(LA125_1>=FUNCTION && LA125_1<=PROMPT)) ) {
                    alt125=1;
                }
            }
            else if ( (LA125_0==DIVIDE||LA125_0==PROCEDURE||(LA125_0>=FUNCTION && LA125_0<=PROMPT)) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2107:18: swallow_to_semi
                    {
                    pushFollow(FOLLOW_swallow_to_semi_in_rollback_statement4602);
                    swallow_to_semi();

                    state._fsp--;


                    }
                    break;

            }


                    	stat += "rollback()";
                    

            }


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "rollback_statement"


    // $ANTLR start "savepoint_statement"
    // /home/macan/Private/pl2py/PLSQL.g:2113:1: savepoint_statement : SAVEPOINT ID ;
    public final void savepoint_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2123:1: ( SAVEPOINT ID )
            // /home/macan/Private/pl2py/PLSQL.g:2124:2: SAVEPOINT ID
            {
            int start = input.LT(1).getTokenIndex();
            match(input,SAVEPOINT,FOLLOW_SAVEPOINT_in_savepoint_statement4647); 
            match(input,ID,FOLLOW_ID_in_savepoint_statement4649); 
            int end = input.LT(-1).getTokenIndex();
                    int pos = end + 1;
                    while(input.get(pos).getChannel() != 0)
                    	pos++;
                    end = pos - 1;
                    stat += input.toString(start, end);

            }


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "savepoint_statement"


    // $ANTLR start "select_statement"
    // /home/macan/Private/pl2py/PLSQL.g:2134:1: select_statement : SELECT swallow_to_semi ;
    public final void select_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2144:1: ( SELECT swallow_to_semi )
            // /home/macan/Private/pl2py/PLSQL.g:2145:2: SELECT swallow_to_semi
            {
            int start = input.LT(1).getTokenIndex();
            match(input,SELECT,FOLLOW_SELECT_in_select_statement4706); 
            pushFollow(FOLLOW_swallow_to_semi_in_select_statement4708);
            swallow_to_semi();

            state._fsp--;

            int end = input.LT(-1).getTokenIndex();
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


            stat += '\n';

        }
        catch (StringIndexOutOfBoundsException e) {
            e.getMessage();
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "select_statement"


    // $ANTLR start "set_transaction_statement"
    // /home/macan/Private/pl2py/PLSQL.g:2197:1: set_transaction_statement : SET TRANSACTION swallow_to_semi ;
    public final void set_transaction_statement() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2197:27: ( SET TRANSACTION swallow_to_semi )
            // /home/macan/Private/pl2py/PLSQL.g:2198:9: SET TRANSACTION swallow_to_semi
            {
            match(input,SET,FOLLOW_SET_in_set_transaction_statement4758); 
            match(input,TRANSACTION,FOLLOW_TRANSACTION_in_set_transaction_statement4760); 
            pushFollow(FOLLOW_swallow_to_semi_in_set_transaction_statement4762);
            swallow_to_semi();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "set_transaction_statement"


    // $ANTLR start "update_statement"
    // /home/macan/Private/pl2py/PLSQL.g:2201:1: update_statement : UPDATE swallow_to_semi ;
    public final void update_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2211:1: ( UPDATE swallow_to_semi )
            // /home/macan/Private/pl2py/PLSQL.g:2212:2: UPDATE swallow_to_semi
            {
            int start = input.LT(1).getTokenIndex();
            match(input,UPDATE,FOLLOW_UPDATE_in_update_statement4796); 
            pushFollow(FOLLOW_swallow_to_semi_in_update_statement4798);
            swallow_to_semi();

            state._fsp--;

            int end = input.LT(-1).getTokenIndex();
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


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "update_statement"


    // $ANTLR start "merge_statement"
    // /home/macan/Private/pl2py/PLSQL.g:2230:1: merge_statement : MERGE swallow_to_semi ;
    public final void merge_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2240:1: ( MERGE swallow_to_semi )
            // /home/macan/Private/pl2py/PLSQL.g:2241:2: MERGE swallow_to_semi
            {
            int start = input.LT(1).getTokenIndex();
            match(input,MERGE,FOLLOW_MERGE_in_merge_statement4851); 
            pushFollow(FOLLOW_swallow_to_semi_in_merge_statement4854);
            swallow_to_semi();

            state._fsp--;

            int end = input.LT(-1).getTokenIndex();
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


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "merge_statement"


    // $ANTLR start "swallow_to_semi"
    // /home/macan/Private/pl2py/PLSQL.g:2259:1: swallow_to_semi : (~ ( SEMI ) )+ ;
    public final void swallow_to_semi() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2259:17: ( (~ ( SEMI ) )+ )
            // /home/macan/Private/pl2py/PLSQL.g:2260:9: (~ ( SEMI ) )+
            {
            // /home/macan/Private/pl2py/PLSQL.g:2260:9: (~ ( SEMI ) )+
            int cnt126=0;
            loop126:
            do {
                int alt126=2;
                int LA126_0 = input.LA(1);

                if ( (LA126_0==ID) ) {
                    int LA126_2 = input.LA(2);

                    if ( (LA126_2==SEMI||LA126_2==ID) ) {
                        alt126=1;
                    }
                    else if ( (LA126_2==DIVIDE||LA126_2==PROCEDURE||(LA126_2>=FUNCTION && LA126_2<=PROMPT)) ) {
                        alt126=1;
                    }


                }
                else if ( (LA126_0==DIVIDE||LA126_0==PROCEDURE||(LA126_0>=FUNCTION && LA126_0<=PROMPT)) ) {
                    alt126=1;
                }


                switch (alt126) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:2260:9: ~ ( SEMI )
            	    {
            	    if ( input.LA(1)==DIVIDE||(input.LA(1)>=PROCEDURE && input.LA(1)<=PROMPT) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt126 >= 1 ) break loop126;
                        EarlyExitException eee =
                            new EarlyExitException(126, input);
                        throw eee;
                }
                cnt126++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "swallow_to_semi"


    // $ANTLR start "while_loop_statement"
    // /home/macan/Private/pl2py/PLSQL.g:2263:1: while_loop_statement : WHILE expression LOOP ( statement SEMI )+ END LOOP ( label_name )? ;
    public final void while_loop_statement() throws RecognitionException {

        for(int i = 0; i < indent_count; i++)
        {	
        	stat += '\t';
        }

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2273:1: ( WHILE expression LOOP ( statement SEMI )+ END LOOP ( label_name )? )
            // /home/macan/Private/pl2py/PLSQL.g:2274:5: WHILE expression LOOP ( statement SEMI )+ END LOOP ( label_name )?
            {
            match(input,WHILE,FOLLOW_WHILE_in_while_loop_statement4921); 
            pushFollow(FOLLOW_expression_in_while_loop_statement4923);
            expression();

            state._fsp--;

            match(input,LOOP,FOLLOW_LOOP_in_while_loop_statement4925); 

                stat += "while " + exp + ":\n"; 
                exp = "";
            // /home/macan/Private/pl2py/PLSQL.g:2278:5: ( statement SEMI )+
            int cnt127=0;
            loop127:
            do {
                int alt127=2;
                int LA127_0 = input.LA(1);

                if ( (LA127_0==ID||LA127_0==RETURN||LA127_0==NULL||LA127_0==BEGIN||(LA127_0>=COLON && LA127_0<=CASE)||(LA127_0>=CLOSE && LA127_0<=CONTINUE)||(LA127_0>=EXIT && LA127_0<=FETCH)||(LA127_0>=FOR && LA127_0<=FORALL)||(LA127_0>=GOTO && LA127_0<=IF)||LA127_0==OPEN||(LA127_0>=RAISE && LA127_0<=LLABEL)||(LA127_0>=COMMIT && LA127_0<=SET)||(LA127_0>=UPDATE && LA127_0<=WHILE)) ) {
                    alt127=1;
                }


                switch (alt127) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:2278:7: statement SEMI
            	    {
            	    indent_count++;
            	    pushFollow(FOLLOW_statement_in_while_loop_statement4950);
            	    statement();

            	    state._fsp--;

            	    indent_count--;
            	    match(input,SEMI,FOLLOW_SEMI_in_while_loop_statement4954); 

            	    }
            	    break;

            	default :
            	    if ( cnt127 >= 1 ) break loop127;
                        EarlyExitException eee =
                            new EarlyExitException(127, input);
                        throw eee;
                }
                cnt127++;
            } while (true);

            match(input,END,FOLLOW_END_in_while_loop_statement4959); 
            match(input,LOOP,FOLLOW_LOOP_in_while_loop_statement4961); 
            // /home/macan/Private/pl2py/PLSQL.g:2278:70: ( label_name )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==ID) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2278:70: label_name
                    {
                    pushFollow(FOLLOW_label_name_in_while_loop_statement4963);
                    label_name();

                    state._fsp--;


                    }
                    break;

            }


            }


            stat += '\n';

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "while_loop_statement"


    // $ANTLR start "match_parens"
    // /home/macan/Private/pl2py/PLSQL.g:2281:1: match_parens : ( ( options {greedy=false; } : ~ ( RPAREN | LPAREN | SEMI | AS | IS | IN | OUT ) )* | RPAREN match_parens LPAREN );
    public final void match_parens() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2282:5: ( ( options {greedy=false; } : ~ ( RPAREN | LPAREN | SEMI | AS | IS | IN | OUT ) )* | RPAREN match_parens LPAREN )
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==DIVIDE||(LA130_0>=PROCEDURE && LA130_0<=COMMA)||(LA130_0>=NOCOPY && LA130_0<=CURSOR)||(LA130_0>=NOT && LA130_0<=RESULT_CACHE)||(LA130_0>=BEGIN && LA130_0<=PROMPT)) ) {
                alt130=1;
            }
            else if ( (LA130_0==RPAREN) ) {
                alt130=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;
            }
            switch (alt130) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2282:7: ( options {greedy=false; } : ~ ( RPAREN | LPAREN | SEMI | AS | IS | IN | OUT ) )*
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:2282:7: ( options {greedy=false; } : ~ ( RPAREN | LPAREN | SEMI | AS | IS | IN | OUT ) )*
                    loop129:
                    do {
                        int alt129=2;
                        int LA129_0 = input.LA(1);

                        if ( (LA129_0==DIVIDE||(LA129_0>=PROCEDURE && LA129_0<=RETURN)||LA129_0==COMMA||(LA129_0>=NOCOPY && LA129_0<=CURSOR)||(LA129_0>=NOT && LA129_0<=RESULT_CACHE)||(LA129_0>=BEGIN && LA129_0<=PROMPT)) ) {
                            alt129=1;
                        }
                        else if ( (LA129_0==LPAREN) ) {
                            alt129=2;
                        }


                        switch (alt129) {
                    	case 1 :
                    	    // /home/macan/Private/pl2py/PLSQL.g:2282:35: ~ ( RPAREN | LPAREN | SEMI | AS | IS | IN | OUT )
                    	    {
                    	    if ( input.LA(1)==DIVIDE||(input.LA(1)>=PROCEDURE && input.LA(1)<=RETURN)||input.LA(1)==COMMA||(input.LA(1)>=NOCOPY && input.LA(1)<=CURSOR)||(input.LA(1)>=NOT && input.LA(1)<=RESULT_CACHE)||(input.LA(1)>=BEGIN && input.LA(1)<=PROMPT) ) {
                    	        input.consume();
                    	        state.errorRecovery=false;
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop129;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:2283:7: RPAREN match_parens LPAREN
                    {
                    match(input,RPAREN,FOLLOW_RPAREN_in_match_parens5040); 
                    pushFollow(FOLLOW_match_parens_in_match_parens5042);
                    match_parens();

                    state._fsp--;

                    match(input,LPAREN,FOLLOW_LPAREN_in_match_parens5044); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "match_parens"


    // $ANTLR start "label_name"
    // /home/macan/Private/pl2py/PLSQL.g:2286:1: label_name : ID ;
    public final void label_name() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2286:11: ( ID )
            // /home/macan/Private/pl2py/PLSQL.g:2287:2: ID
            {
            match(input,ID,FOLLOW_ID_in_label_name5057); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "label_name"


    // $ANTLR start "expression"
    // /home/macan/Private/pl2py/PLSQL.g:2290:1: expression : or_expr ;
    public final void expression() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2293:5: ( or_expr )
            // /home/macan/Private/pl2py/PLSQL.g:2293:7: or_expr
            {
            pushFollow(FOLLOW_or_expr_in_expression5078);
            or_expr();

            state._fsp--;


            }



        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "expression"


    // $ANTLR start "or_expr"
    // /home/macan/Private/pl2py/PLSQL.g:2296:1: or_expr : and_expr ( OR and_expr )* ;
    public final void or_expr() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2297:5: ( and_expr ( OR and_expr )* )
            // /home/macan/Private/pl2py/PLSQL.g:2297:8: and_expr ( OR and_expr )*
            {
            pushFollow(FOLLOW_and_expr_in_or_expr5096);
            and_expr();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:2297:17: ( OR and_expr )*
            loop131:
            do {
                int alt131=2;
                int LA131_0 = input.LA(1);

                if ( (LA131_0==OR) ) {
                    alt131=1;
                }


                switch (alt131) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:2297:19: OR and_expr
            	    {
            	    match(input,OR,FOLLOW_OR_in_or_expr5100); 
            	     exp += " or ";
            	    pushFollow(FOLLOW_and_expr_in_or_expr5104);
            	    and_expr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop131;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "or_expr"


    // $ANTLR start "and_expr"
    // /home/macan/Private/pl2py/PLSQL.g:2300:1: and_expr : not_expr ( AND not_expr )* ;
    public final void and_expr() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2301:5: ( not_expr ( AND not_expr )* )
            // /home/macan/Private/pl2py/PLSQL.g:2301:7: not_expr ( AND not_expr )*
            {
            pushFollow(FOLLOW_not_expr_in_and_expr5126);
            not_expr();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:2301:16: ( AND not_expr )*
            loop132:
            do {
                int alt132=2;
                int LA132_0 = input.LA(1);

                if ( (LA132_0==AND) ) {
                    alt132=1;
                }


                switch (alt132) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:2301:18: AND not_expr
            	    {
            	    match(input,AND,FOLLOW_AND_in_and_expr5130); 
            	     exp += " and ";
            	    pushFollow(FOLLOW_not_expr_in_and_expr5135);
            	    not_expr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop132;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "and_expr"


    // $ANTLR start "not_expr"
    // /home/macan/Private/pl2py/PLSQL.g:2304:1: not_expr : ( NOT )? compare_expr ;
    public final void not_expr() throws RecognitionException {
        Token NOT15=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2305:5: ( ( NOT )? compare_expr )
            // /home/macan/Private/pl2py/PLSQL.g:2305:9: ( NOT )? compare_expr
            {
            // /home/macan/Private/pl2py/PLSQL.g:2305:9: ( NOT )?
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==NOT) ) {
                alt133=1;
            }
            switch (alt133) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2305:9: NOT
                    {
                    NOT15=(Token)match(input,NOT,FOLLOW_NOT_in_not_expr5162); 

                    }
                    break;

            }

             if(NOT15 != null) exp += " not ";
            pushFollow(FOLLOW_compare_expr_in_not_expr5167);
            compare_expr();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "not_expr"


    // $ANTLR start "compare_expr"
    // /home/macan/Private/pl2py/PLSQL.g:2308:1: compare_expr : is_null_expr ( ( EQ | NOT_EQ | LTH | LEQ | GTH | GEQ ) is_null_expr )? ;
    public final void compare_expr() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2309:6: ( is_null_expr ( ( EQ | NOT_EQ | LTH | LEQ | GTH | GEQ ) is_null_expr )? )
            // /home/macan/Private/pl2py/PLSQL.g:2309:8: is_null_expr ( ( EQ | NOT_EQ | LTH | LEQ | GTH | GEQ ) is_null_expr )?
            {
            pushFollow(FOLLOW_is_null_expr_in_compare_expr5189);
            is_null_expr();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:2309:21: ( ( EQ | NOT_EQ | LTH | LEQ | GTH | GEQ ) is_null_expr )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( ((LA135_0>=EQ && LA135_0<=GEQ)) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2310:6: ( EQ | NOT_EQ | LTH | LEQ | GTH | GEQ ) is_null_expr
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:2310:6: ( EQ | NOT_EQ | LTH | LEQ | GTH | GEQ )
                    int alt134=6;
                    switch ( input.LA(1) ) {
                    case EQ:
                        {
                        alt134=1;
                        }
                        break;
                    case NOT_EQ:
                        {
                        alt134=2;
                        }
                        break;
                    case LTH:
                        {
                        alt134=3;
                        }
                        break;
                    case LEQ:
                        {
                        alt134=4;
                        }
                        break;
                    case GTH:
                        {
                        alt134=5;
                        }
                        break;
                    case GEQ:
                        {
                        alt134=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 134, 0, input);

                        throw nvae;
                    }

                    switch (alt134) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:2310:8: EQ
                            {
                            match(input,EQ,FOLLOW_EQ_in_compare_expr5201); 
                            exp += " == ";

                            }
                            break;
                        case 2 :
                            // /home/macan/Private/pl2py/PLSQL.g:2310:30: NOT_EQ
                            {
                            match(input,NOT_EQ,FOLLOW_NOT_EQ_in_compare_expr5207); 
                            exp += " != ";

                            }
                            break;
                        case 3 :
                            // /home/macan/Private/pl2py/PLSQL.g:2310:55: LTH
                            {
                            match(input,LTH,FOLLOW_LTH_in_compare_expr5212); 
                            exp += " < ";

                            }
                            break;
                        case 4 :
                            // /home/macan/Private/pl2py/PLSQL.g:2310:76: LEQ
                            {
                            match(input,LEQ,FOLLOW_LEQ_in_compare_expr5217); 
                            exp += " <= ";

                            }
                            break;
                        case 5 :
                            // /home/macan/Private/pl2py/PLSQL.g:2310:98: GTH
                            {
                            match(input,GTH,FOLLOW_GTH_in_compare_expr5222); 
                            exp += " > ";

                            }
                            break;
                        case 6 :
                            // /home/macan/Private/pl2py/PLSQL.g:2310:119: GEQ
                            {
                            match(input,GEQ,FOLLOW_GEQ_in_compare_expr5227); 
                            exp += " >= ";

                            }
                            break;

                    }

                    pushFollow(FOLLOW_is_null_expr_in_compare_expr5241);
                    is_null_expr();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "compare_expr"


    // $ANTLR start "is_null_expr"
    // /home/macan/Private/pl2py/PLSQL.g:2314:1: is_null_expr : like_expr ( IS ( NOT )? NULL )? ;
    public final void is_null_expr() throws RecognitionException {
        Token NOT16=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2315:6: ( like_expr ( IS ( NOT )? NULL )? )
            // /home/macan/Private/pl2py/PLSQL.g:2315:8: like_expr ( IS ( NOT )? NULL )?
            {
            pushFollow(FOLLOW_like_expr_in_is_null_expr5262);
            like_expr();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:2315:18: ( IS ( NOT )? NULL )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==IS) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2315:20: IS ( NOT )? NULL
                    {
                    match(input,IS,FOLLOW_IS_in_is_null_expr5266); 
                    exp += " is ";
                    // /home/macan/Private/pl2py/PLSQL.g:2315:40: ( NOT )?
                    int alt136=2;
                    int LA136_0 = input.LA(1);

                    if ( (LA136_0==NOT) ) {
                        alt136=1;
                    }
                    switch (alt136) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:2315:40: NOT
                            {
                            NOT16=(Token)match(input,NOT,FOLLOW_NOT_in_is_null_expr5270); 

                            }
                            break;

                    }

                     if(NOT16 != null) exp += " not ";
                    match(input,NULL,FOLLOW_NULL_in_is_null_expr5275); 
                     exp += " None ";

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "is_null_expr"


    // $ANTLR start "like_expr"
    // /home/macan/Private/pl2py/PLSQL.g:2318:1: like_expr : between_expr ( ( NOT )? LIKE between_expr )? ;
    public final void like_expr() throws RecognitionException {
        Token NOT17=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2319:6: ( between_expr ( ( NOT )? LIKE between_expr )? )
            // /home/macan/Private/pl2py/PLSQL.g:2319:8: between_expr ( ( NOT )? LIKE between_expr )?
            {
            pushFollow(FOLLOW_between_expr_in_like_expr5304);
            between_expr();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:2319:21: ( ( NOT )? LIKE between_expr )?
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==NOT||LA139_0==LIKE) ) {
                alt139=1;
            }
            switch (alt139) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2320:6: ( NOT )? LIKE between_expr
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:2320:6: ( NOT )?
                    int alt138=2;
                    int LA138_0 = input.LA(1);

                    if ( (LA138_0==NOT) ) {
                        alt138=1;
                    }
                    switch (alt138) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:2320:6: NOT
                            {
                            NOT17=(Token)match(input,NOT,FOLLOW_NOT_in_like_expr5314); 

                            }
                            break;

                    }

                     if(NOT17 != null) exp += " not ";
                    match(input,LIKE,FOLLOW_LIKE_in_like_expr5319); 
                     exp += " == ";
                    pushFollow(FOLLOW_between_expr_in_like_expr5329);
                    between_expr();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "like_expr"


    // $ANTLR start "between_expr"
    // /home/macan/Private/pl2py/PLSQL.g:2324:1: between_expr : in_expr ( ( NOT )? BETWEEN in_expr AND in_expr )? ;
    public final void between_expr() throws RecognitionException {
        Token NOT18=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2325:6: ( in_expr ( ( NOT )? BETWEEN in_expr AND in_expr )? )
            // /home/macan/Private/pl2py/PLSQL.g:2325:8: in_expr ( ( NOT )? BETWEEN in_expr AND in_expr )?
            {
            pushFollow(FOLLOW_in_expr_in_between_expr5353);
            in_expr();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:2325:16: ( ( NOT )? BETWEEN in_expr AND in_expr )?
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==NOT) ) {
                int LA141_1 = input.LA(2);

                if ( (LA141_1==BETWEEN) ) {
                    alt141=1;
                }
            }
            else if ( (LA141_0==BETWEEN) ) {
                alt141=1;
            }
            switch (alt141) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2325:18: ( NOT )? BETWEEN in_expr AND in_expr
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:2325:18: ( NOT )?
                    int alt140=2;
                    int LA140_0 = input.LA(1);

                    if ( (LA140_0==NOT) ) {
                        alt140=1;
                    }
                    switch (alt140) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:2325:18: NOT
                            {
                            NOT18=(Token)match(input,NOT,FOLLOW_NOT_in_between_expr5357); 

                            }
                            break;

                    }

                     if(NOT18 != null) exp += " not ";
                    match(input,BETWEEN,FOLLOW_BETWEEN_in_between_expr5362); 
                     exp += " between ";
                    pushFollow(FOLLOW_in_expr_in_between_expr5377);
                    in_expr();

                    state._fsp--;

                    match(input,AND,FOLLOW_AND_in_between_expr5379); 
                    exp += "and";
                    pushFollow(FOLLOW_in_expr_in_between_expr5383);
                    in_expr();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "between_expr"


    // $ANTLR start "in_expr"
    // /home/macan/Private/pl2py/PLSQL.g:2329:1: in_expr : add_expr ( ( NOT )? IN LPAREN add_expr ( COMMA add_expr )* RPAREN )? ;
    public final void in_expr() throws RecognitionException {
        Token NOT19=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2330:5: ( add_expr ( ( NOT )? IN LPAREN add_expr ( COMMA add_expr )* RPAREN )? )
            // /home/macan/Private/pl2py/PLSQL.g:2330:8: add_expr ( ( NOT )? IN LPAREN add_expr ( COMMA add_expr )* RPAREN )?
            {
            pushFollow(FOLLOW_add_expr_in_in_expr5408);
            add_expr();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:2330:17: ( ( NOT )? IN LPAREN add_expr ( COMMA add_expr )* RPAREN )?
            int alt144=2;
            int LA144_0 = input.LA(1);

            if ( (LA144_0==NOT) ) {
                int LA144_1 = input.LA(2);

                if ( (LA144_1==IN) ) {
                    alt144=1;
                }
            }
            else if ( (LA144_0==IN) ) {
                alt144=1;
            }
            switch (alt144) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2330:19: ( NOT )? IN LPAREN add_expr ( COMMA add_expr )* RPAREN
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:2330:19: ( NOT )?
                    int alt142=2;
                    int LA142_0 = input.LA(1);

                    if ( (LA142_0==NOT) ) {
                        alt142=1;
                    }
                    switch (alt142) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:2330:19: NOT
                            {
                            NOT19=(Token)match(input,NOT,FOLLOW_NOT_in_in_expr5412); 

                            }
                            break;

                    }

                     if(NOT19 != null) exp += " not ";
                    match(input,IN,FOLLOW_IN_in_in_expr5417); 
                    match(input,LPAREN,FOLLOW_LPAREN_in_in_expr5419); 
                    exp += " in (";
                    pushFollow(FOLLOW_add_expr_in_in_expr5423);
                    add_expr();

                    state._fsp--;

                    // /home/macan/Private/pl2py/PLSQL.g:2331:6: ( COMMA add_expr )*
                    loop143:
                    do {
                        int alt143=2;
                        int LA143_0 = input.LA(1);

                        if ( (LA143_0==COMMA) ) {
                            alt143=1;
                        }


                        switch (alt143) {
                    	case 1 :
                    	    // /home/macan/Private/pl2py/PLSQL.g:2331:8: COMMA add_expr
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_in_expr5433); 
                    	    exp += ", ";
                    	    pushFollow(FOLLOW_add_expr_in_in_expr5438);
                    	    add_expr();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop143;
                        }
                    } while (true);

                    match(input,RPAREN,FOLLOW_RPAREN_in_in_expr5443); 
                    exp += ") ";

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "in_expr"


    // $ANTLR start "numeric_expression"
    // /home/macan/Private/pl2py/PLSQL.g:2334:1: numeric_expression : add_expr ;
    public final void numeric_expression() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2335:5: ( add_expr )
            // /home/macan/Private/pl2py/PLSQL.g:2335:7: add_expr
            {
            pushFollow(FOLLOW_add_expr_in_numeric_expression5468);
            add_expr();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "numeric_expression"


    // $ANTLR start "add_expr"
    // /home/macan/Private/pl2py/PLSQL.g:2338:1: add_expr : mul_expr ( ( MINUS | PLUS | DOUBLEVERTBAR ) mul_expr )* ;
    public final void add_expr() throws RecognitionException {

        int double_vertbar = 0;
        int pos = 0;
        String saved = exp;
        exp = "";

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2348:5: ( mul_expr ( ( MINUS | PLUS | DOUBLEVERTBAR ) mul_expr )* )
            // /home/macan/Private/pl2py/PLSQL.g:2348:7: mul_expr ( ( MINUS | PLUS | DOUBLEVERTBAR ) mul_expr )*
            {
            pushFollow(FOLLOW_mul_expr_in_add_expr5494);
            mul_expr();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:2349:6: ( ( MINUS | PLUS | DOUBLEVERTBAR ) mul_expr )*
            loop146:
            do {
                int alt146=2;
                int LA146_0 = input.LA(1);

                if ( ((LA146_0>=MINUS && LA146_0<=DOUBLEVERTBAR)) ) {
                    alt146=1;
                }


                switch (alt146) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:2350:6: ( MINUS | PLUS | DOUBLEVERTBAR ) mul_expr
            	    {
            	    // /home/macan/Private/pl2py/PLSQL.g:2350:6: ( MINUS | PLUS | DOUBLEVERTBAR )
            	    int alt145=3;
            	    switch ( input.LA(1) ) {
            	    case MINUS:
            	        {
            	        alt145=1;
            	        }
            	        break;
            	    case PLUS:
            	        {
            	        alt145=2;
            	        }
            	        break;
            	    case DOUBLEVERTBAR:
            	        {
            	        alt145=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 145, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt145) {
            	        case 1 :
            	            // /home/macan/Private/pl2py/PLSQL.g:2350:8: MINUS
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_add_expr5512); 
            	            exp += " - ";

            	            }
            	            break;
            	        case 2 :
            	            // /home/macan/Private/pl2py/PLSQL.g:2351:8: PLUS
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_add_expr5524); 
            	            exp += " + ";

            	            }
            	            break;
            	        case 3 :
            	            // /home/macan/Private/pl2py/PLSQL.g:2352:8: DOUBLEVERTBAR
            	            {
            	            match(input,DOUBLEVERTBAR,FOLLOW_DOUBLEVERTBAR_in_add_expr5536); 
            	             exp += " || "; pos = exp.lastIndexOf("||");double_vertbar = 1;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_mul_expr_in_add_expr5556);
            	    mul_expr();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop146;
                }
            } while (true);


            }


            exp = saved + exp;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "add_expr"


    // $ANTLR start "mul_expr"
    // /home/macan/Private/pl2py/PLSQL.g:2388:1: mul_expr : unary_sign_expr ( ( ASTERISK | DIVIDE | kMOD ) unary_sign_expr )* ;
    public final void mul_expr() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2389:5: ( unary_sign_expr ( ( ASTERISK | DIVIDE | kMOD ) unary_sign_expr )* )
            // /home/macan/Private/pl2py/PLSQL.g:2389:8: unary_sign_expr ( ( ASTERISK | DIVIDE | kMOD ) unary_sign_expr )*
            {
            pushFollow(FOLLOW_unary_sign_expr_in_mul_expr5593);
            unary_sign_expr();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:2389:24: ( ( ASTERISK | DIVIDE | kMOD ) unary_sign_expr )*
            loop148:
            do {
                int alt148=2;
                int LA148_0 = input.LA(1);

                if ( (LA148_0==DIVIDE||LA148_0==ID||LA148_0==ASTERISK) ) {
                    alt148=1;
                }


                switch (alt148) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:2390:6: ( ASTERISK | DIVIDE | kMOD ) unary_sign_expr
            	    {
            	    // /home/macan/Private/pl2py/PLSQL.g:2390:6: ( ASTERISK | DIVIDE | kMOD )
            	    int alt147=3;
            	    switch ( input.LA(1) ) {
            	    case ASTERISK:
            	        {
            	        alt147=1;
            	        }
            	        break;
            	    case DIVIDE:
            	        {
            	        alt147=2;
            	        }
            	        break;
            	    case ID:
            	        {
            	        alt147=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 147, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt147) {
            	        case 1 :
            	            // /home/macan/Private/pl2py/PLSQL.g:2390:8: ASTERISK
            	            {
            	            match(input,ASTERISK,FOLLOW_ASTERISK_in_mul_expr5605); 
            	            exp += " * ";

            	            }
            	            break;
            	        case 2 :
            	            // /home/macan/Private/pl2py/PLSQL.g:2390:34: DIVIDE
            	            {
            	            match(input,DIVIDE,FOLLOW_DIVIDE_in_mul_expr5610); 
            	            exp += " / ";

            	            }
            	            break;
            	        case 3 :
            	            // /home/macan/Private/pl2py/PLSQL.g:2390:59: kMOD
            	            {
            	            pushFollow(FOLLOW_kMOD_in_mul_expr5616);
            	            kMOD();

            	            state._fsp--;

            	            exp += " % ";

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unary_sign_expr_in_mul_expr5632);
            	    unary_sign_expr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop148;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "mul_expr"


    // $ANTLR start "unary_sign_expr"
    // /home/macan/Private/pl2py/PLSQL.g:2394:1: unary_sign_expr : ( MINUS | PLUS )? exponent_expr ;
    public final void unary_sign_expr() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2395:5: ( ( MINUS | PLUS )? exponent_expr )
            // /home/macan/Private/pl2py/PLSQL.g:2396:6: ( MINUS | PLUS )? exponent_expr
            {
            // /home/macan/Private/pl2py/PLSQL.g:2396:6: ( MINUS | PLUS )?
            int alt149=3;
            int LA149_0 = input.LA(1);

            if ( (LA149_0==MINUS) ) {
                alt149=1;
            }
            else if ( (LA149_0==PLUS) ) {
                alt149=2;
            }
            switch (alt149) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2396:8: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_unary_sign_expr5662); 
                    exp += " - ";

                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:2396:32: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_unary_sign_expr5668); 
                    exp += " + ";

                    }
                    break;

            }

            pushFollow(FOLLOW_exponent_expr_in_unary_sign_expr5683);
            exponent_expr();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "unary_sign_expr"


    // $ANTLR start "exponent_expr"
    // /home/macan/Private/pl2py/PLSQL.g:2400:1: exponent_expr : atom ( EXPONENT atom )? ;
    public final void exponent_expr() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2401:5: ( atom ( EXPONENT atom )? )
            // /home/macan/Private/pl2py/PLSQL.g:2401:7: atom ( EXPONENT atom )?
            {
            pushFollow(FOLLOW_atom_in_exponent_expr5703);
            atom();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:2401:12: ( EXPONENT atom )?
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==EXPONENT) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2401:14: EXPONENT atom
                    {
                    match(input,EXPONENT,FOLLOW_EXPONENT_in_exponent_expr5707); 
                    exp += " ** ";
                    pushFollow(FOLLOW_atom_in_exponent_expr5711);
                    atom();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "exponent_expr"


    // $ANTLR start "atom"
    // /home/macan/Private/pl2py/PLSQL.g:2404:1: atom : ( variable_or_function_call ( PERCENT attribute )? | SQL PERCENT attribute | string_literal | numeric_atom | boolean_atom | NULL | LPAREN expression RPAREN | LPAREN dbmsfunc_call ( EQ | NOT_EQ | LTH | LEQ | GTH | GEQ ) INTEGER RPAREN );
    public final void atom() throws RecognitionException {

        String saved = exp;
        exp = "";

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2412:6: ( variable_or_function_call ( PERCENT attribute )? | SQL PERCENT attribute | string_literal | numeric_atom | boolean_atom | NULL | LPAREN expression RPAREN | LPAREN dbmsfunc_call ( EQ | NOT_EQ | LTH | LEQ | GTH | GEQ ) INTEGER RPAREN )
            int alt152=8;
            alt152 = dfa152.predict(input);
            switch (alt152) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2412:8: variable_or_function_call ( PERCENT attribute )?
                    {
                    pushFollow(FOLLOW_variable_or_function_call_in_atom5743);
                    variable_or_function_call();

                    state._fsp--;

                    // /home/macan/Private/pl2py/PLSQL.g:2412:34: ( PERCENT attribute )?
                    int alt151=2;
                    int LA151_0 = input.LA(1);

                    if ( (LA151_0==PERCENT) ) {
                        alt151=1;
                    }
                    switch (alt151) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:2413:6: PERCENT attribute
                            {
                            match(input,PERCENT,FOLLOW_PERCENT_in_atom5754); 
                            exp += " % ";
                            pushFollow(FOLLOW_attribute_in_atom5758);
                            attribute();

                            state._fsp--;


                                	if (exp.toLowerCase().contains("rowcount")) {
                                		exp = "tdw.getrowcount()";
                                	} else if (exp.toLowerCase().contains("isopen")) {
                                		String var = exp.substring(0, exp.indexOf("%"));
                                		exp = var + "['isopen']";
                                	} else if (exp.toLowerCase().contains("notfound")) {
                                		String var = exp.substring(0, exp.indexOf("%"));
                                		exp = var + "== \"\"";
                                	} else if (exp.toLowerCase().contains("found")) {
                                		String var = exp.substring(0, exp.indexOf("%"));
                                		exp = var + "!= \"\"";
                                	}
                                	

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:2428:6: SQL PERCENT attribute
                    {
                    int start = input.LT(1).getTokenIndex();
                    match(input,SQL,FOLLOW_SQL_in_atom5786); 
                    match(input,PERCENT,FOLLOW_PERCENT_in_atom5788); 
                    int end = input.LT(-1).getTokenIndex();
                            int pos = end + 1;
                            while(input.get(pos).getChannel() != 0)
                            	pos++;
                            end = pos - 1;
                            exp += input.toString(start, end).toLowerCase();
                    pushFollow(FOLLOW_attribute_in_atom5804);
                    attribute();

                    state._fsp--;


                        		if (exp.toLowerCase().contains("rowcount")) {
                        			exp = "tdw.getrowcount()";
                        		}
                        	

                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:2441:8: string_literal
                    {
                    pushFollow(FOLLOW_string_literal_in_atom5815);
                    string_literal();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // /home/macan/Private/pl2py/PLSQL.g:2442:8: numeric_atom
                    {
                    pushFollow(FOLLOW_numeric_atom_in_atom5824);
                    numeric_atom();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // /home/macan/Private/pl2py/PLSQL.g:2443:8: boolean_atom
                    {
                    pushFollow(FOLLOW_boolean_atom_in_atom5833);
                    boolean_atom();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // /home/macan/Private/pl2py/PLSQL.g:2444:8: NULL
                    {
                    match(input,NULL,FOLLOW_NULL_in_atom5842); 
                    exp += "None ";

                    }
                    break;
                case 7 :
                    // /home/macan/Private/pl2py/PLSQL.g:2446:6: LPAREN expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_atom5863); 
                    exp += "( ";
                    pushFollow(FOLLOW_expression_in_atom5877);
                    expression();

                    state._fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_atom5885); 
                    exp += " )";

                    }
                    break;
                case 8 :
                    // /home/macan/Private/pl2py/PLSQL.g:2449:8: LPAREN dbmsfunc_call ( EQ | NOT_EQ | LTH | LEQ | GTH | GEQ ) INTEGER RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_atom5903); 
                    pushFollow(FOLLOW_dbmsfunc_call_in_atom5905);
                    dbmsfunc_call();

                    state._fsp--;

                    if ( (input.LA(1)>=EQ && input.LA(1)<=GEQ) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    match(input,INTEGER,FOLLOW_INTEGER_in_atom5933); 
                    match(input,RPAREN,FOLLOW_RPAREN_in_atom5935); 

                    }
                    break;

            }

            exp = saved + exp;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "atom"


    // $ANTLR start "variable_or_function_call"
    // /home/macan/Private/pl2py/PLSQL.g:2452:1: variable_or_function_call : call ( DOT call )* ( DOT delete_call )? ;
    public final void variable_or_function_call() throws RecognitionException {

        String previous_id = "";
        String saved_exp = "";
        int found = 0;
        int suspect = 1;
        int replaced = 0;
        last_id = "";

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2461:5: ( call ( DOT call )* ( DOT delete_call )? )
            // /home/macan/Private/pl2py/PLSQL.g:2461:8: call ( DOT call )* ( DOT delete_call )?
            {
            pushFollow(FOLLOW_call_in_variable_or_function_call5961);
            call();

            state._fsp--;

            previous_id = last_id; saved_exp = exp;
            // /home/macan/Private/pl2py/PLSQL.g:2461:55: ( DOT call )*
            loop153:
            do {
                int alt153=2;
                int LA153_0 = input.LA(1);

                if ( (LA153_0==DOT) ) {
                    int LA153_1 = input.LA(2);

                    if ( (LA153_1==ID||LA153_1==COLON) ) {
                        alt153=1;
                    }


                }


                switch (alt153) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:2461:57: DOT call
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_variable_or_function_call5967); 

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
            	        
            	    pushFollow(FOLLOW_call_in_variable_or_function_call5971);
            	    call();

            	    state._fsp--;


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
            	        

            	    }
            	    break;

            	default :
            	    break loop153;
                }
            } while (true);

            exp = saved_exp;
            // /home/macan/Private/pl2py/PLSQL.g:2520:29: ( DOT delete_call )?
            int alt154=2;
            int LA154_0 = input.LA(1);

            if ( (LA154_0==DOT) ) {
                alt154=1;
            }
            switch (alt154) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2520:31: DOT delete_call
                    {
                    match(input,DOT,FOLLOW_DOT_in_variable_or_function_call5982); 
                    exp += '.'; suspect = 0;
                    pushFollow(FOLLOW_delete_call_in_variable_or_function_call5986);
                    delete_call();

                    state._fsp--;


                    }
                    break;

            }


                
                if (replaced == 0) {
                	//exp = exp.toLowerCase();
                }
                exp = exp.replace("[tdw, ", "[");
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "variable_or_function_call"


    // $ANTLR start "attribute"
    // /home/macan/Private/pl2py/PLSQL.g:2530:1: attribute : ( BULK_ROWCOUNT LPAREN expression RPAREN | kFOUND | ISOPEN | NOTFOUND | kROWCOUNT );
    public final void attribute() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2530:11: ( BULK_ROWCOUNT LPAREN expression RPAREN | kFOUND | ISOPEN | NOTFOUND | kROWCOUNT )
            int alt155=5;
            switch ( input.LA(1) ) {
            case BULK_ROWCOUNT:
                {
                alt155=1;
                }
                break;
            case FOUND:
                {
                alt155=2;
                }
                break;
            case ISOPEN:
                {
                alt155=3;
                }
                break;
            case NOTFOUND:
                {
                alt155=4;
                }
                break;
            case ROWCOUNT:
                {
                alt155=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 155, 0, input);

                throw nvae;
            }

            switch (alt155) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2531:6: BULK_ROWCOUNT LPAREN expression RPAREN
                    {
                    int start = input.LT(1).getTokenIndex();
                    match(input,BULK_ROWCOUNT,FOLLOW_BULK_ROWCOUNT_in_attribute6021); 
                    match(input,LPAREN,FOLLOW_LPAREN_in_attribute6023); 
                    int end = input.LT(-1).getTokenIndex();
                            int pos = end + 1;
                            while(input.get(pos).getChannel() != 0)
                            	pos++;
                            end = pos - 1;
                            exp += input.toString(start, end).toLowerCase();
                    pushFollow(FOLLOW_expression_in_attribute6043);
                    expression();

                    state._fsp--;

                    start = input.LT(1).getTokenIndex();
                    match(input,RPAREN,FOLLOW_RPAREN_in_attribute6058); 
                    end = input.LT(-1).getTokenIndex();
                            pos = end + 1;
                            while(input.get(pos).getChannel() != 0)
                            	pos++;
                            end = pos - 1;
                            exp += input.toString(start, end).toLowerCase();

                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:2549:6: kFOUND
                    {
                    int start = input.LT(1).getTokenIndex();
                    pushFollow(FOLLOW_kFOUND_in_attribute6094);
                    kFOUND();

                    state._fsp--;

                    int end = input.LT(-1).getTokenIndex();
                            int pos = end + 1;
                            while(input.get(pos).getChannel() != 0)
                            	pos++;
                            end = pos - 1;
                            exp += input.toString(start, end).toLowerCase();

                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:2558:6: ISOPEN
                    {
                    int start = input.LT(1).getTokenIndex();
                    match(input,ISOPEN,FOLLOW_ISOPEN_in_attribute6126); 
                    int end = input.LT(-1).getTokenIndex();
                            int pos = end + 1;
                            while(input.get(pos).getChannel() != 0)
                            	pos++;
                            end = pos - 1;
                            exp += input.toString(start, end).toLowerCase();

                    }
                    break;
                case 4 :
                    // /home/macan/Private/pl2py/PLSQL.g:2567:6: NOTFOUND
                    {
                    int start = input.LT(1).getTokenIndex();
                    match(input,NOTFOUND,FOLLOW_NOTFOUND_in_attribute6158); 
                    int end = input.LT(-1).getTokenIndex();
                            int pos = end + 1;
                            while(input.get(pos).getChannel() != 0)
                            	pos++;
                            end = pos - 1;
                            exp += input.toString(start, end).toUpperCase();

                    }
                    break;
                case 5 :
                    // /home/macan/Private/pl2py/PLSQL.g:2576:6: kROWCOUNT
                    {
                    int start = input.LT(1).getTokenIndex();
                    pushFollow(FOLLOW_kROWCOUNT_in_attribute6195);
                    kROWCOUNT();

                    state._fsp--;

                    int end = input.LT(-1).getTokenIndex();
                            int pos = end + 1;
                            while(input.get(pos).getChannel() != 0)
                            	pos++;
                            end = pos - 1;
                            exp += input.toString(start, end).toLowerCase();

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "attribute"


    // $ANTLR start "call_args"
    // /home/macan/Private/pl2py/PLSQL.g:2586:1: call_args : LPAREN ( parameter ( COMMA parameter )* )? RPAREN ;
    public final void call_args() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2587:5: ( LPAREN ( parameter ( COMMA parameter )* )? RPAREN )
            // /home/macan/Private/pl2py/PLSQL.g:2588:5: LPAREN ( parameter ( COMMA parameter )* )? RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_call_args6234); 
            // /home/macan/Private/pl2py/PLSQL.g:2588:12: ( parameter ( COMMA parameter )* )?
            int alt157=2;
            int LA157_0 = input.LA(1);

            if ( (LA157_0==ID||LA157_0==LPAREN||(LA157_0>=NOT && LA157_0<=NULL)||LA157_0==COLON||(LA157_0>=MINUS && LA157_0<=PLUS)||(LA157_0>=SQL && LA157_0<=INTEGER)||(LA157_0>=REAL_NUMBER && LA157_0<=QUOTED_STRING)||(LA157_0>=INSERTING && LA157_0<=DELETING)) ) {
                alt157=1;
            }
            switch (alt157) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2588:14: parameter ( COMMA parameter )*
                    {
                    pushFollow(FOLLOW_parameter_in_call_args6238);
                    parameter();

                    state._fsp--;

                    // /home/macan/Private/pl2py/PLSQL.g:2588:24: ( COMMA parameter )*
                    loop156:
                    do {
                        int alt156=2;
                        int LA156_0 = input.LA(1);

                        if ( (LA156_0==COMMA) ) {
                            alt156=1;
                        }


                        switch (alt156) {
                    	case 1 :
                    	    // /home/macan/Private/pl2py/PLSQL.g:2588:26: COMMA parameter
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_call_args6242); 
                    	    pushFollow(FOLLOW_parameter_in_call_args6246);
                    	    parameter();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop156;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_call_args6254); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "call_args"


    // $ANTLR start "boolean_atom"
    // /home/macan/Private/pl2py/PLSQL.g:2591:1: boolean_atom : ( boolean_literal | collection_exists | conditional_predicate );
    public final void boolean_atom() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2592:5: ( boolean_literal | collection_exists | conditional_predicate )
            int alt158=3;
            switch ( input.LA(1) ) {
            case TRUE:
            case FALSE:
                {
                alt158=1;
                }
                break;
            case ID:
                {
                alt158=2;
                }
                break;
            case INSERTING:
            case UPDATING:
            case DELETING:
                {
                alt158=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 158, 0, input);

                throw nvae;
            }

            switch (alt158) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2592:7: boolean_literal
                    {
                    pushFollow(FOLLOW_boolean_literal_in_boolean_atom6279);
                    boolean_literal();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:2593:7: collection_exists
                    {
                    pushFollow(FOLLOW_collection_exists_in_boolean_atom6287);
                    collection_exists();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:2594:7: conditional_predicate
                    {
                    pushFollow(FOLLOW_conditional_predicate_in_boolean_atom6295);
                    conditional_predicate();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "boolean_atom"


    // $ANTLR start "numeric_atom"
    // /home/macan/Private/pl2py/PLSQL.g:2597:1: numeric_atom : numeric_literal ;
    public final void numeric_atom() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2598:5: ( numeric_literal )
            // /home/macan/Private/pl2py/PLSQL.g:2598:7: numeric_literal
            {
            pushFollow(FOLLOW_numeric_literal_in_numeric_atom6312);
            numeric_literal();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "numeric_atom"


    // $ANTLR start "numeric_literal"
    // /home/macan/Private/pl2py/PLSQL.g:2601:1: numeric_literal : ( INTEGER | REAL_NUMBER );
    public final void numeric_literal() throws RecognitionException {
        Token INTEGER20=null;
        Token REAL_NUMBER21=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2602:5: ( INTEGER | REAL_NUMBER )
            int alt159=2;
            int LA159_0 = input.LA(1);

            if ( (LA159_0==INTEGER) ) {
                alt159=1;
            }
            else if ( (LA159_0==REAL_NUMBER) ) {
                alt159=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 159, 0, input);

                throw nvae;
            }
            switch (alt159) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2602:7: INTEGER
                    {
                    INTEGER20=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_numeric_literal6329); 
                    exp += INTEGER20.getText();

                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:2603:7: REAL_NUMBER
                    {
                    REAL_NUMBER21=(Token)match(input,REAL_NUMBER,FOLLOW_REAL_NUMBER_in_numeric_literal6339); 
                    exp += REAL_NUMBER21.getText();

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "numeric_literal"


    // $ANTLR start "boolean_literal"
    // /home/macan/Private/pl2py/PLSQL.g:2606:1: boolean_literal : ( TRUE | FALSE );
    public final void boolean_literal() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2607:5: ( TRUE | FALSE )
            int alt160=2;
            int LA160_0 = input.LA(1);

            if ( (LA160_0==TRUE) ) {
                alt160=1;
            }
            else if ( (LA160_0==FALSE) ) {
                alt160=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 160, 0, input);

                throw nvae;
            }
            switch (alt160) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2607:8: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_boolean_literal6359); 
                    exp += "True";

                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:2607:31: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_boolean_literal6364); 
                    exp += "False";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "boolean_literal"


    // $ANTLR start "string_literal"
    // /home/macan/Private/pl2py/PLSQL.g:2610:1: string_literal : QUOTED_STRING ;
    public final void string_literal() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2611:5: ( QUOTED_STRING )
            // /home/macan/Private/pl2py/PLSQL.g:2612:6: QUOTED_STRING
            {
            int start = input.LT(1).getTokenIndex();
            match(input,QUOTED_STRING,FOLLOW_QUOTED_STRING_in_string_literal6398); 
            int end = input.LT(-1).getTokenIndex();
                    String tmp = input.toString(start, end);
                    int length = tmp.length();
                    
                    for(int i = 0; i < length; i++)
                    	if(tmp.charAt(i) == '\n') {
                    		sql_count++;
                    	}
                   	exp += tmp.replace("\'", "\"\"\"");
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "string_literal"


    // $ANTLR start "collection_exists"
    // /home/macan/Private/pl2py/PLSQL.g:2626:1: collection_exists : ID DOT EXISTS LPAREN expression RPAREN ;
    public final void collection_exists() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2627:5: ( ID DOT EXISTS LPAREN expression RPAREN )
            // /home/macan/Private/pl2py/PLSQL.g:2627:7: ID DOT EXISTS LPAREN expression RPAREN
            {
            match(input,ID,FOLLOW_ID_in_collection_exists6425); 
            match(input,DOT,FOLLOW_DOT_in_collection_exists6427); 
            match(input,EXISTS,FOLLOW_EXISTS_in_collection_exists6429); 
            match(input,LPAREN,FOLLOW_LPAREN_in_collection_exists6431); 
            pushFollow(FOLLOW_expression_in_collection_exists6433);
            expression();

            state._fsp--;

            match(input,RPAREN,FOLLOW_RPAREN_in_collection_exists6435); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "collection_exists"


    // $ANTLR start "conditional_predicate"
    // /home/macan/Private/pl2py/PLSQL.g:2630:1: conditional_predicate : ( INSERTING | UPDATING ( LPAREN QUOTED_STRING RPAREN )? | DELETING );
    public final void conditional_predicate() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2631:5: ( INSERTING | UPDATING ( LPAREN QUOTED_STRING RPAREN )? | DELETING )
            int alt162=3;
            switch ( input.LA(1) ) {
            case INSERTING:
                {
                alt162=1;
                }
                break;
            case UPDATING:
                {
                alt162=2;
                }
                break;
            case DELETING:
                {
                alt162=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 162, 0, input);

                throw nvae;
            }

            switch (alt162) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2631:7: INSERTING
                    {
                    match(input,INSERTING,FOLLOW_INSERTING_in_conditional_predicate6452); 

                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:2632:7: UPDATING ( LPAREN QUOTED_STRING RPAREN )?
                    {
                    match(input,UPDATING,FOLLOW_UPDATING_in_conditional_predicate6460); 
                    // /home/macan/Private/pl2py/PLSQL.g:2632:16: ( LPAREN QUOTED_STRING RPAREN )?
                    int alt161=2;
                    int LA161_0 = input.LA(1);

                    if ( (LA161_0==LPAREN) ) {
                        alt161=1;
                    }
                    switch (alt161) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:2632:18: LPAREN QUOTED_STRING RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_conditional_predicate6464); 
                            match(input,QUOTED_STRING,FOLLOW_QUOTED_STRING_in_conditional_predicate6466); 
                            match(input,RPAREN,FOLLOW_RPAREN_in_conditional_predicate6468); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:2633:7: DELETING
                    {
                    match(input,DELETING,FOLLOW_DELETING_in_conditional_predicate6479); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "conditional_predicate"


    // $ANTLR start "parameter"
    // /home/macan/Private/pl2py/PLSQL.g:2636:1: parameter : ( ID ARROW )? expression ;
    public final void parameter() throws RecognitionException {
        Token ID22=null;


        int has_arrow = 0;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2640:5: ( ( ID ARROW )? expression )
            // /home/macan/Private/pl2py/PLSQL.g:2641:5: ( ID ARROW )? expression
            {
            // /home/macan/Private/pl2py/PLSQL.g:2641:5: ( ID ARROW )?
            int alt163=2;
            int LA163_0 = input.LA(1);

            if ( (LA163_0==ID) ) {
                int LA163_1 = input.LA(2);

                if ( (LA163_1==ARROW) ) {
                    alt163=1;
                }
            }
            switch (alt163) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2641:7: ID ARROW
                    {
                    ID22=(Token)match(input,ID,FOLLOW_ID_in_parameter6506); 
                    match(input,ARROW,FOLLOW_ARROW_in_parameter6508); 
                    has_arrow = 1; exp += "'" + ID22.getText().toLowerCase() + " => ";

                    }
                    break;

            }

            pushFollow(FOLLOW_expression_in_parameter6521);
            expression();

            state._fsp--;

            if (has_arrow == 1) {exp += "'";}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "parameter"


    // $ANTLR start "index"
    // /home/macan/Private/pl2py/PLSQL.g:2646:1: index : expression ;
    public final void index() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2647:5: ( expression )
            // /home/macan/Private/pl2py/PLSQL.g:2647:7: expression
            {
            pushFollow(FOLLOW_expression_in_index6546);
            expression();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "index"


    // $ANTLR start "create_package"
    // /home/macan/Private/pl2py/PLSQL.g:2650:1: create_package : CREATE ( OR kREPLACE )? PACKAGE (schema_name= ID DOT )? package_name= ID ( invoker_rights_clause )? ( IS | AS ) ( declare_section )? END ( ID )? SEMI ;
    public final void create_package() throws RecognitionException {
        Token schema_name=null;
        Token package_name=null;


        create_package = 1;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2657:1: ( CREATE ( OR kREPLACE )? PACKAGE (schema_name= ID DOT )? package_name= ID ( invoker_rights_clause )? ( IS | AS ) ( declare_section )? END ( ID )? SEMI )
            // /home/macan/Private/pl2py/PLSQL.g:2658:2: CREATE ( OR kREPLACE )? PACKAGE (schema_name= ID DOT )? package_name= ID ( invoker_rights_clause )? ( IS | AS ) ( declare_section )? END ( ID )? SEMI
            {
            match(input,CREATE,FOLLOW_CREATE_in_create_package6570); 
            // /home/macan/Private/pl2py/PLSQL.g:2659:2: ( OR kREPLACE )?
            int alt164=2;
            int LA164_0 = input.LA(1);

            if ( (LA164_0==OR) ) {
                alt164=1;
            }
            switch (alt164) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2659:4: OR kREPLACE
                    {
                    match(input,OR,FOLLOW_OR_in_create_package6577); 
                    pushFollow(FOLLOW_kREPLACE_in_create_package6579);
                    kREPLACE();

                    state._fsp--;


                    }
                    break;

            }

            match(input,PACKAGE,FOLLOW_PACKAGE_in_create_package6584); 
            // /home/macan/Private/pl2py/PLSQL.g:2659:27: (schema_name= ID DOT )?
            int alt165=2;
            int LA165_0 = input.LA(1);

            if ( (LA165_0==ID) ) {
                int LA165_1 = input.LA(2);

                if ( (LA165_1==DOT) ) {
                    alt165=1;
                }
            }
            switch (alt165) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2659:29: schema_name= ID DOT
                    {
                    schema_name=(Token)match(input,ID,FOLLOW_ID_in_create_package6590); 
                    match(input,DOT,FOLLOW_DOT_in_create_package6592); 

                    }
                    break;

            }

            package_name=(Token)match(input,ID,FOLLOW_ID_in_create_package6599); 
            // /home/macan/Private/pl2py/PLSQL.g:2660:9: ( invoker_rights_clause )?
            int alt166=2;
            int LA166_0 = input.LA(1);

            if ( (LA166_0==AUTHID) ) {
                alt166=1;
            }
            switch (alt166) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2660:11: invoker_rights_clause
                    {
                    pushFollow(FOLLOW_invoker_rights_clause_in_create_package6611);
                    invoker_rights_clause();

                    state._fsp--;


                    }
                    break;

            }

            if ( input.LA(1)==IS||input.LA(1)==AS ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // /home/macan/Private/pl2py/PLSQL.g:2662:9: ( declare_section )?
            int alt167=2;
            int LA167_0 = input.LA(1);

            if ( ((LA167_0>=PROCEDURE && LA167_0<=FUNCTION)||LA167_0==CURSOR||LA167_0==SUBTYPE||LA167_0==PRAGMA) ) {
                alt167=1;
            }
            switch (alt167) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2662:11: declare_section
                    {
                    indent_count = 1;
                    pushFollow(FOLLOW_declare_section_in_create_package6647);
                    declare_section();

                    state._fsp--;


                    }
                    break;

            }

            create_package = 0;
            match(input,END,FOLLOW_END_in_create_package6662); 
            // /home/macan/Private/pl2py/PLSQL.g:2663:13: ( ID )?
            int alt168=2;
            int LA168_0 = input.LA(1);

            if ( (LA168_0==ID) ) {
                alt168=1;
            }
            switch (alt168) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2663:15: ID
                    {
                    match(input,ID,FOLLOW_ID_in_create_package6666); 

                    }
                    break;

            }

            match(input,SEMI,FOLLOW_SEMI_in_create_package6671); 

            }


            pkg_current = package_name.getText().toLowerCase();

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "create_package"


    // $ANTLR start "create_package_body"
    // /home/macan/Private/pl2py/PLSQL.g:2666:1: create_package_body : CREATE ( OR kREPLACE )? PACKAGE BODY (schema_name= ID DOT )? package_name= ID ( IS | AS ) ( declare_section )? (initialize_section= body | END (package_name2= ID )? ) SEMI ;
    public final void create_package_body() throws RecognitionException {
        Token schema_name=null;
        Token package_name=null;
        Token package_name2=null;


        String saved_output = "";
        indent_count = 1;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2671:1: ( CREATE ( OR kREPLACE )? PACKAGE BODY (schema_name= ID DOT )? package_name= ID ( IS | AS ) ( declare_section )? (initialize_section= body | END (package_name2= ID )? ) SEMI )
            // /home/macan/Private/pl2py/PLSQL.g:2672:9: CREATE ( OR kREPLACE )? PACKAGE BODY (schema_name= ID DOT )? package_name= ID ( IS | AS ) ( declare_section )? (initialize_section= body | END (package_name2= ID )? ) SEMI
            {
            match(input,CREATE,FOLLOW_CREATE_in_create_package_body6698); 
            // /home/macan/Private/pl2py/PLSQL.g:2672:16: ( OR kREPLACE )?
            int alt169=2;
            int LA169_0 = input.LA(1);

            if ( (LA169_0==OR) ) {
                alt169=1;
            }
            switch (alt169) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2672:18: OR kREPLACE
                    {
                    match(input,OR,FOLLOW_OR_in_create_package_body6702); 
                    pushFollow(FOLLOW_kREPLACE_in_create_package_body6704);
                    kREPLACE();

                    state._fsp--;


                    }
                    break;

            }

            match(input,PACKAGE,FOLLOW_PACKAGE_in_create_package_body6709); 
            match(input,BODY,FOLLOW_BODY_in_create_package_body6711); 
            // /home/macan/Private/pl2py/PLSQL.g:2672:46: (schema_name= ID DOT )?
            int alt170=2;
            int LA170_0 = input.LA(1);

            if ( (LA170_0==ID) ) {
                int LA170_1 = input.LA(2);

                if ( (LA170_1==DOT) ) {
                    alt170=1;
                }
            }
            switch (alt170) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2672:48: schema_name= ID DOT
                    {
                    schema_name=(Token)match(input,ID,FOLLOW_ID_in_create_package_body6717); 
                    match(input,DOT,FOLLOW_DOT_in_create_package_body6719); 

                    }
                    break;

            }

            package_name=(Token)match(input,ID,FOLLOW_ID_in_create_package_body6726); 

                    global = 0;
                    String FileName = package_name.getText().toLowerCase() + ".py";
                    
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
            	
            if ( input.LA(1)==IS||input.LA(1)==AS ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // /home/macan/Private/pl2py/PLSQL.g:2693:21: ( declare_section )?
            int alt171=2;
            int LA171_0 = input.LA(1);

            if ( ((LA171_0>=PROCEDURE && LA171_0<=FUNCTION)||LA171_0==CURSOR||LA171_0==SUBTYPE||LA171_0==PRAGMA) ) {
                alt171=1;
            }
            switch (alt171) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2693:23: declare_section
                    {
                    create_package = 1;
                    pushFollow(FOLLOW_declare_section_in_create_package_body6768);
                    declare_section();

                    state._fsp--;


                    }
                    break;

            }

            create_package = 0; saved_output = output; output = "";
            // /home/macan/Private/pl2py/PLSQL.g:2694:9: (initialize_section= body | END (package_name2= ID )? )
            int alt173=2;
            int LA173_0 = input.LA(1);

            if ( (LA173_0==BEGIN) ) {
                alt173=1;
            }
            else if ( (LA173_0==END) ) {
                alt173=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 173, 0, input);

                throw nvae;
            }
            switch (alt173) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2694:11: initialize_section= body
                    {
                    pushFollow(FOLLOW_body_in_create_package_body6786);
                    body();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:2694:37: END (package_name2= ID )?
                    {
                    match(input,END,FOLLOW_END_in_create_package_body6790); 
                    // /home/macan/Private/pl2py/PLSQL.g:2694:41: (package_name2= ID )?
                    int alt172=2;
                    int LA172_0 = input.LA(1);

                    if ( (LA172_0==ID) ) {
                        alt172=1;
                    }
                    switch (alt172) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:2694:43: package_name2= ID
                            {
                            package_name2=(Token)match(input,ID,FOLLOW_ID_in_create_package_body6796); 

                            }
                            break;

                    }


                    }
                    break;

            }

            match(input,SEMI,FOLLOW_SEMI_in_create_package_body6803); 
              
                    pfops.close(); 
                    
            	File readfile = new File(path + FileName);
            	FileInputStream ipfs = new FileInputStream(readfile);
            	
            	FileName = package_name.getText().toLowerCase() + "_tmp.py";	
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
            		if (pkg_list[i][0].equalsIgnoreCase(package_name.getText().toLowerCase())) {
            			outs += pkg_list[i][1];
            			break;
            		}
            	}
            	System.out.println("Write package " + package_name.getText() + " and check pkg_list @" + i);
            	
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

        }
        catch (RecognitionException re) {
            reportError(re);recover(input,re);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "create_package_body"


    // $ANTLR start "create_procedure"
    // /home/macan/Private/pl2py/PLSQL.g:2764:1: create_procedure : CREATE ( OR kREPLACE )? PROCEDURE (schema_name= ID DOT )? procedure_name= ID ( LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN )? ( invoker_rights_clause )? ( IS | AS ) ( ( declare_section )? body | call_spec | EXTERNAL ) SEMI ;
    public final void create_procedure() throws RecognitionException {
        Token schema_name=null;
        Token procedure_name=null;


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

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2783:2: ( CREATE ( OR kREPLACE )? PROCEDURE (schema_name= ID DOT )? procedure_name= ID ( LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN )? ( invoker_rights_clause )? ( IS | AS ) ( ( declare_section )? body | call_spec | EXTERNAL ) SEMI )
            // /home/macan/Private/pl2py/PLSQL.g:2784:9: CREATE ( OR kREPLACE )? PROCEDURE (schema_name= ID DOT )? procedure_name= ID ( LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN )? ( invoker_rights_clause )? ( IS | AS ) ( ( declare_section )? body | call_spec | EXTERNAL ) SEMI
            {
            match(input,CREATE,FOLLOW_CREATE_in_create_procedure6869); 
            // /home/macan/Private/pl2py/PLSQL.g:2784:16: ( OR kREPLACE )?
            int alt174=2;
            int LA174_0 = input.LA(1);

            if ( (LA174_0==OR) ) {
                alt174=1;
            }
            switch (alt174) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2784:18: OR kREPLACE
                    {
                    match(input,OR,FOLLOW_OR_in_create_procedure6873); 
                    pushFollow(FOLLOW_kREPLACE_in_create_procedure6875);
                    kREPLACE();

                    state._fsp--;


                    }
                    break;

            }

            match(input,PROCEDURE,FOLLOW_PROCEDURE_in_create_procedure6880); 
            // /home/macan/Private/pl2py/PLSQL.g:2784:43: (schema_name= ID DOT )?
            int alt175=2;
            int LA175_0 = input.LA(1);

            if ( (LA175_0==ID) ) {
                int LA175_1 = input.LA(2);

                if ( (LA175_1==DOT) ) {
                    alt175=1;
                }
            }
            switch (alt175) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2784:45: schema_name= ID DOT
                    {
                    schema_name=(Token)match(input,ID,FOLLOW_ID_in_create_procedure6886); 
                    match(input,DOT,FOLLOW_DOT_in_create_procedure6888); 

                    }
                    break;

            }

            procedure_name=(Token)match(input,ID,FOLLOW_ID_in_create_procedure6895); 
                    
                    String tmp = procedure_name.getText();
                    if(tmp.startsWith("\"")&&tmp.endsWith("\""))
                    	tmp = tmp.substring(1, tmp.length() -1 );
                    	
                    output += "def " + tmp.toLowerCase() + "(tdw, ";
            // /home/macan/Private/pl2py/PLSQL.g:2791:9: ( LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN )?
            int alt177=2;
            int LA177_0 = input.LA(1);

            if ( (LA177_0==LPAREN) ) {
                alt177=1;
            }
            switch (alt177) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2791:11: LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_create_procedure6919); 
                    pushFollow(FOLLOW_parameter_declaration_in_create_procedure6921);
                    parameter_declaration();

                    state._fsp--;

                    // /home/macan/Private/pl2py/PLSQL.g:2791:40: ( COMMA parameter_declaration )*
                    loop176:
                    do {
                        int alt176=2;
                        int LA176_0 = input.LA(1);

                        if ( (LA176_0==COMMA) ) {
                            alt176=1;
                        }


                        switch (alt176) {
                    	case 1 :
                    	    // /home/macan/Private/pl2py/PLSQL.g:2791:42: COMMA parameter_declaration
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_create_procedure6925); 
                    	    pushFollow(FOLLOW_parameter_declaration_in_create_procedure6927);
                    	    parameter_declaration();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop176;
                        }
                    } while (true);

                    match(input,RPAREN,FOLLOW_RPAREN_in_create_procedure6931); 

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
                    break;

            }

            output += ")";
            output += ":\n";
                   	if(initial_statement_count >= 0)
                   	{
                   		for(int i = 0; i <= initial_statement_count; i++)
                   		{
                   			output += '\t' + initial_statement[i] + "\n";
                   		}
                   		initial_statement_count = -1;
                   	}        
                    
            // /home/macan/Private/pl2py/PLSQL.g:2829:9: ( invoker_rights_clause )?
            int alt178=2;
            int LA178_0 = input.LA(1);

            if ( (LA178_0==AUTHID) ) {
                alt178=1;
            }
            switch (alt178) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2829:9: invoker_rights_clause
                    {
                    pushFollow(FOLLOW_invoker_rights_clause_in_create_procedure6983);
                    invoker_rights_clause();

                    state._fsp--;


                    }
                    break;

            }

            if ( input.LA(1)==IS||input.LA(1)==AS ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // /home/macan/Private/pl2py/PLSQL.g:2831:9: ( ( declare_section )? body | call_spec | EXTERNAL )
            int alt180=3;
            switch ( input.LA(1) ) {
            case PROCEDURE:
            case ID:
            case FUNCTION:
            case CURSOR:
            case SUBTYPE:
            case BEGIN:
            case PRAGMA:
                {
                alt180=1;
                }
                break;
            case LANGUAGE:
                {
                alt180=2;
                }
                break;
            case EXTERNAL:
                {
                alt180=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 180, 0, input);

                throw nvae;
            }

            switch (alt180) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2831:11: ( declare_section )? body
                    {
                    indent_count = 1;
                    // /home/macan/Private/pl2py/PLSQL.g:2831:31: ( declare_section )?
                    int alt179=2;
                    int LA179_0 = input.LA(1);

                    if ( ((LA179_0>=PROCEDURE && LA179_0<=FUNCTION)||LA179_0==CURSOR||LA179_0==SUBTYPE||LA179_0==PRAGMA) ) {
                        alt179=1;
                    }
                    switch (alt179) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:2831:31: declare_section
                            {
                            pushFollow(FOLLOW_declare_section_in_create_procedure7032);
                            declare_section();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_body_in_create_procedure7035);
                    body();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:2832:11: call_spec
                    {
                    pushFollow(FOLLOW_call_spec_in_create_procedure7047);
                    call_spec();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:2833:11: EXTERNAL
                    {
                    match(input,EXTERNAL,FOLLOW_EXTERNAL_in_create_procedure7059); 

                    }
                    break;

            }


                    	for(int i = 0; i <= variables_list_cnt; i++ )
                    	{
                    		String reg = "(?i)" + variables_list[i];
                    		String repl = variables_list[i].toLowerCase();
                    		//output = output.replaceAll(reg, repl);
                    	}	
                    
            match(input,SEMI,FOLLOW_SEMI_in_create_procedure7090); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "create_procedure"


    // $ANTLR start "create_function"
    // /home/macan/Private/pl2py/PLSQL.g:2846:1: create_function : CREATE ( OR kREPLACE )? FUNCTION (schema_name= ID DOT )? function_name= ID ( LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN )? RETURN datatype ( invoker_rights_clause )? ( IS | AS ) ( ( declare_section )? body | call_spec | EXTERNAL ) SEMI ;
    public final void create_function() throws RecognitionException {
        Token schema_name=null;
        Token function_name=null;

        try {
            // /home/macan/Private/pl2py/PLSQL.g:2864:2: ( CREATE ( OR kREPLACE )? FUNCTION (schema_name= ID DOT )? function_name= ID ( LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN )? RETURN datatype ( invoker_rights_clause )? ( IS | AS ) ( ( declare_section )? body | call_spec | EXTERNAL ) SEMI )
            // /home/macan/Private/pl2py/PLSQL.g:2865:2: CREATE ( OR kREPLACE )? FUNCTION (schema_name= ID DOT )? function_name= ID ( LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN )? RETURN datatype ( invoker_rights_clause )? ( IS | AS ) ( ( declare_section )? body | call_spec | EXTERNAL ) SEMI
            {
            match(input,CREATE,FOLLOW_CREATE_in_create_function7117); 
            // /home/macan/Private/pl2py/PLSQL.g:2865:9: ( OR kREPLACE )?
            int alt181=2;
            int LA181_0 = input.LA(1);

            if ( (LA181_0==OR) ) {
                alt181=1;
            }
            switch (alt181) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2865:11: OR kREPLACE
                    {
                    match(input,OR,FOLLOW_OR_in_create_function7121); 
                    pushFollow(FOLLOW_kREPLACE_in_create_function7123);
                    kREPLACE();

                    state._fsp--;


                    }
                    break;

            }

            match(input,FUNCTION,FOLLOW_FUNCTION_in_create_function7128); 
            // /home/macan/Private/pl2py/PLSQL.g:2865:35: (schema_name= ID DOT )?
            int alt182=2;
            int LA182_0 = input.LA(1);

            if ( (LA182_0==ID) ) {
                int LA182_1 = input.LA(2);

                if ( (LA182_1==DOT) ) {
                    alt182=1;
                }
            }
            switch (alt182) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2865:37: schema_name= ID DOT
                    {
                    schema_name=(Token)match(input,ID,FOLLOW_ID_in_create_function7134); 
                    match(input,DOT,FOLLOW_DOT_in_create_function7136); 

                    }
                    break;

            }

            function_name=(Token)match(input,ID,FOLLOW_ID_in_create_function7143); 

                    String tmp = function_name.getText();
                    if(tmp.startsWith("\"")&&tmp.endsWith("\""))
                    	tmp = tmp.substring(1, tmp.length() -1 );
                    	
                    output += "def " + tmp.toLowerCase() + "(tdw, ";
            // /home/macan/Private/pl2py/PLSQL.g:2872:9: ( LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN )?
            int alt184=2;
            int LA184_0 = input.LA(1);

            if ( (LA184_0==LPAREN) ) {
                alt184=1;
            }
            switch (alt184) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2872:11: LPAREN parameter_declaration ( COMMA parameter_declaration )* RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_create_function7161); 
                    pushFollow(FOLLOW_parameter_declaration_in_create_function7163);
                    parameter_declaration();

                    state._fsp--;

                    // /home/macan/Private/pl2py/PLSQL.g:2872:40: ( COMMA parameter_declaration )*
                    loop183:
                    do {
                        int alt183=2;
                        int LA183_0 = input.LA(1);

                        if ( (LA183_0==COMMA) ) {
                            alt183=1;
                        }


                        switch (alt183) {
                    	case 1 :
                    	    // /home/macan/Private/pl2py/PLSQL.g:2872:42: COMMA parameter_declaration
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_create_function7167); 
                    	    pushFollow(FOLLOW_parameter_declaration_in_create_function7170);
                    	    parameter_declaration();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop183;
                        }
                    } while (true);

                    match(input,RPAREN,FOLLOW_RPAREN_in_create_function7175); 

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
                    break;

            }

            output += ")";
            output += ":\n";
                   	if(initial_statement_count >= 0)
                   	{
                   		for(int i = 0; i <= initial_statement_count; i++)
                   		{
                   			output += '\t' + initial_statement[i] + "\n";
                   		}
                   		initial_statement_count = -1;
                   	}        
                    
            match(input,RETURN,FOLLOW_RETURN_in_create_function7235); 
            pushFollow(FOLLOW_datatype_in_create_function7237);
            datatype();

            state._fsp--;

            // /home/macan/Private/pl2py/PLSQL.g:2910:9: ( invoker_rights_clause )?
            int alt185=2;
            int LA185_0 = input.LA(1);

            if ( (LA185_0==AUTHID) ) {
                alt185=1;
            }
            switch (alt185) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2910:9: invoker_rights_clause
                    {
                    pushFollow(FOLLOW_invoker_rights_clause_in_create_function7247);
                    invoker_rights_clause();

                    state._fsp--;


                    }
                    break;

            }

            if ( input.LA(1)==IS||input.LA(1)==AS ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // /home/macan/Private/pl2py/PLSQL.g:2912:9: ( ( declare_section )? body | call_spec | EXTERNAL )
            int alt187=3;
            switch ( input.LA(1) ) {
            case PROCEDURE:
            case ID:
            case FUNCTION:
            case CURSOR:
            case SUBTYPE:
            case BEGIN:
            case PRAGMA:
                {
                alt187=1;
                }
                break;
            case LANGUAGE:
                {
                alt187=2;
                }
                break;
            case EXTERNAL:
                {
                alt187=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 187, 0, input);

                throw nvae;
            }

            switch (alt187) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:2912:11: ( declare_section )? body
                    {
                    indent_count = 1;
                    // /home/macan/Private/pl2py/PLSQL.g:2912:31: ( declare_section )?
                    int alt186=2;
                    int LA186_0 = input.LA(1);

                    if ( ((LA186_0>=PROCEDURE && LA186_0<=FUNCTION)||LA186_0==CURSOR||LA186_0==SUBTYPE||LA186_0==PRAGMA) ) {
                        alt186=1;
                    }
                    switch (alt186) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:2912:31: declare_section
                            {
                            pushFollow(FOLLOW_declare_section_in_create_function7291);
                            declare_section();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_body_in_create_function7294);
                    body();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:2913:11: call_spec
                    {
                    pushFollow(FOLLOW_call_spec_in_create_function7306);
                    call_spec();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:2914:11: EXTERNAL
                    {
                    match(input,EXTERNAL,FOLLOW_EXTERNAL_in_create_function7318); 

                    }
                    break;

            }


                    	for(int i = 0; i <= variables_list_cnt; i++ )
                    	{
                    		String reg = "(?i)" + variables_list[i];
                    		String repl = variables_list[i].toLowerCase();
                    		//output = output.replaceAll(reg, repl);
                    	}	
                    
            match(input,SEMI,FOLLOW_SEMI_in_create_function7356); 

            }


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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "create_function"


    // $ANTLR start "invoker_rights_clause"
    // /home/macan/Private/pl2py/PLSQL.g:2927:1: invoker_rights_clause : AUTHID ( CURRENT_USER | DEFINER ) ;
    public final void invoker_rights_clause() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2927:23: ( AUTHID ( CURRENT_USER | DEFINER ) )
            // /home/macan/Private/pl2py/PLSQL.g:2928:9: AUTHID ( CURRENT_USER | DEFINER )
            {
            match(input,AUTHID,FOLLOW_AUTHID_in_invoker_rights_clause7394); 
            if ( (input.LA(1)>=CURRENT_USER && input.LA(1)<=DEFINER) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "invoker_rights_clause"


    // $ANTLR start "call_spec"
    // /home/macan/Private/pl2py/PLSQL.g:2931:1: call_spec : LANGUAGE swallow_to_semi ;
    public final void call_spec() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2932:5: ( LANGUAGE swallow_to_semi )
            // /home/macan/Private/pl2py/PLSQL.g:2932:7: LANGUAGE swallow_to_semi
            {
            match(input,LANGUAGE,FOLLOW_LANGUAGE_in_call_spec7421); 
            pushFollow(FOLLOW_swallow_to_semi_in_call_spec7423);
            swallow_to_semi();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "call_spec"


    // $ANTLR start "kERRORS"
    // /home/macan/Private/pl2py/PLSQL.g:2935:1: kERRORS : {...}? ID ;
    public final void kERRORS() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2935:9: ({...}? ID )
            // /home/macan/Private/pl2py/PLSQL.g:2935:11: {...}? ID
            {
            if ( !((input.LT(1).getText().length() >= 3 && "errors".startsWith(input.LT(1).getText().toLowerCase()))) ) {
                throw new FailedPredicateException(input, "kERRORS", "input.LT(1).getText().length() >= 3 && \"errors\".startsWith(input.LT(1).getText().toLowerCase())");
            }
            match(input,ID,FOLLOW_ID_in_kERRORS7438); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "kERRORS"


    // $ANTLR start "kEXCEPTIONS"
    // /home/macan/Private/pl2py/PLSQL.g:2936:1: kEXCEPTIONS : {...}? ID ;
    public final void kEXCEPTIONS() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2936:13: ({...}? ID )
            // /home/macan/Private/pl2py/PLSQL.g:2936:15: {...}? ID
            {
            if ( !((input.LT(1).getText().equalsIgnoreCase("exceptions"))) ) {
                throw new FailedPredicateException(input, "kEXCEPTIONS", "input.LT(1).getText().equalsIgnoreCase(\"exceptions\")");
            }
            match(input,ID,FOLLOW_ID_in_kEXCEPTIONS7447); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "kEXCEPTIONS"


    // $ANTLR start "kFOUND"
    // /home/macan/Private/pl2py/PLSQL.g:2938:1: kFOUND : FOUND ;
    public final void kFOUND() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2938:8: ( FOUND )
            // /home/macan/Private/pl2py/PLSQL.g:2938:10: FOUND
            {
            match(input,FOUND,FOLLOW_FOUND_in_kFOUND7455); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "kFOUND"


    // $ANTLR start "kINDICES"
    // /home/macan/Private/pl2py/PLSQL.g:2941:1: kINDICES : {...}? ID ;
    public final void kINDICES() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2941:10: ({...}? ID )
            // /home/macan/Private/pl2py/PLSQL.g:2941:12: {...}? ID
            {
            if ( !((input.LT(1).getText().equalsIgnoreCase("indices"))) ) {
                throw new FailedPredicateException(input, "kINDICES", "input.LT(1).getText().equalsIgnoreCase(\"indices\")");
            }
            match(input,ID,FOLLOW_ID_in_kINDICES7473); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "kINDICES"


    // $ANTLR start "kMOD"
    // /home/macan/Private/pl2py/PLSQL.g:2942:1: kMOD : {...}? ID ;
    public final void kMOD() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2942:6: ({...}? ID )
            // /home/macan/Private/pl2py/PLSQL.g:2942:8: {...}? ID
            {
            if ( !((input.LT(1).getText().equalsIgnoreCase("mod"))) ) {
                throw new FailedPredicateException(input, "kMOD", "input.LT(1).getText().equalsIgnoreCase(\"mod\")");
            }
            match(input,ID,FOLLOW_ID_in_kMOD7482); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "kMOD"


    // $ANTLR start "kNAME"
    // /home/macan/Private/pl2py/PLSQL.g:2943:1: kNAME : {...}? ID ;
    public final void kNAME() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2943:7: ({...}? ID )
            // /home/macan/Private/pl2py/PLSQL.g:2943:9: {...}? ID
            {
            if ( !((input.LT(1).getText().equalsIgnoreCase("name"))) ) {
                throw new FailedPredicateException(input, "kNAME", "input.LT(1).getText().equalsIgnoreCase(\"name\")");
            }
            match(input,ID,FOLLOW_ID_in_kNAME7491); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "kNAME"


    // $ANTLR start "kOF"
    // /home/macan/Private/pl2py/PLSQL.g:2944:1: kOF : {...}? ID ;
    public final void kOF() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2944:5: ({...}? ID )
            // /home/macan/Private/pl2py/PLSQL.g:2944:8: {...}? ID
            {
            if ( !((input.LT(1).getText().equalsIgnoreCase("of"))) ) {
                throw new FailedPredicateException(input, "kOF", "input.LT(1).getText().equalsIgnoreCase(\"of\")");
            }
            match(input,ID,FOLLOW_ID_in_kOF7501); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "kOF"


    // $ANTLR start "kREPLACE"
    // /home/macan/Private/pl2py/PLSQL.g:2945:1: kREPLACE : {...}? ID ;
    public final void kREPLACE() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2945:10: ({...}? ID )
            // /home/macan/Private/pl2py/PLSQL.g:2945:12: {...}? ID
            {
            if ( !((input.LT(1).getText().equalsIgnoreCase("replace"))) ) {
                throw new FailedPredicateException(input, "kREPLACE", "input.LT(1).getText().equalsIgnoreCase(\"replace\")");
            }
            match(input,ID,FOLLOW_ID_in_kREPLACE7510); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "kREPLACE"


    // $ANTLR start "kROWCOUNT"
    // /home/macan/Private/pl2py/PLSQL.g:2946:1: kROWCOUNT : ROWCOUNT ;
    public final void kROWCOUNT() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2946:11: ( ROWCOUNT )
            // /home/macan/Private/pl2py/PLSQL.g:2946:13: ROWCOUNT
            {
            match(input,ROWCOUNT,FOLLOW_ROWCOUNT_in_kROWCOUNT7517); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "kROWCOUNT"


    // $ANTLR start "kSAVE"
    // /home/macan/Private/pl2py/PLSQL.g:2949:1: kSAVE : {...}? ID ;
    public final void kSAVE() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2949:7: ({...}? ID )
            // /home/macan/Private/pl2py/PLSQL.g:2949:9: {...}? ID
            {
            if ( !((input.LT(1).getText().equalsIgnoreCase("save"))) ) {
                throw new FailedPredicateException(input, "kSAVE", "input.LT(1).getText().equalsIgnoreCase(\"save\")");
            }
            match(input,ID,FOLLOW_ID_in_kSAVE7536); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "kSAVE"


    // $ANTLR start "kSHOW"
    // /home/macan/Private/pl2py/PLSQL.g:2950:1: kSHOW : {...}? ID ;
    public final void kSHOW() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2950:7: ({...}? ID )
            // /home/macan/Private/pl2py/PLSQL.g:2950:9: {...}? ID
            {
            if ( !((input.LT(1).getText().equalsIgnoreCase("show"))) ) {
                throw new FailedPredicateException(input, "kSHOW", "input.LT(1).getText().equalsIgnoreCase(\"show\")");
            }
            match(input,ID,FOLLOW_ID_in_kSHOW7545); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "kSHOW"


    // $ANTLR start "kTYPE"
    // /home/macan/Private/pl2py/PLSQL.g:2951:1: kTYPE : {...}? ID ;
    public final void kTYPE() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2951:7: ({...}? ID )
            // /home/macan/Private/pl2py/PLSQL.g:2951:9: {...}? ID
            {
            if ( !((input.LT(1).getText().equalsIgnoreCase("type"))) ) {
                throw new FailedPredicateException(input, "kTYPE", "input.LT(1).getText().equalsIgnoreCase(\"type\")");
            }
            match(input,ID,FOLLOW_ID_in_kTYPE7554); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "kTYPE"


    // $ANTLR start "kVALUES"
    // /home/macan/Private/pl2py/PLSQL.g:2952:1: kVALUES : {...}? ID ;
    public final void kVALUES() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:2952:9: ({...}? ID )
            // /home/macan/Private/pl2py/PLSQL.g:2952:11: {...}? ID
            {
            if ( !((input.LT(1).getText().equalsIgnoreCase("values"))) ) {
                throw new FailedPredicateException(input, "kVALUES", "input.LT(1).getText().equalsIgnoreCase(\"values\")");
            }
            match(input,ID,FOLLOW_ID_in_kVALUES7563); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "kVALUES"

    // Delegated rules


    protected DFA14 dfa14 = new DFA14(this);
    protected DFA102 dfa102 = new DFA102(this);
    protected DFA152 dfa152 = new DFA152(this);
    static final String DFA14_eotS =
        "\13\uffff";
    static final String DFA14_eofS =
        "\13\uffff";
    static final String DFA14_minS =
        "\1\6\1\uffff\1\7\6\uffff\1\5\1\uffff";
    static final String DFA14_maxS =
        "\1\112\1\uffff\1\40\6\uffff\1\42\1\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\10\1\uffff\1\2\1\3\1\5\1\6\1\7\1\4\1\uffff\1\1";
    static final String DFA14_specialS =
        "\13\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\6\1\2\1\5\11\uffff\1\4\5\uffff\1\3\20\uffff\2\1\37\uffff"+
            "\1\7",
            "",
            "\1\11\16\uffff\2\10\10\uffff\1\10",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\10\4\uffff\1\10\5\uffff\2\10\1\uffff\1\12\1\10\14\uffff"+
            "\2\10",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "()+ loopback of 465:6: ( type_definition SEMI | subtype_definition SEMI | cursor_definition SEMI | item_declaration SEMI | function_declaration_or_definition SEMI | procedure_declaration_or_definition SEMI | pragma SEMI )+";
        }
    }
    static final String DFA102_eotS =
        "\22\uffff";
    static final String DFA102_eofS =
        "\22\uffff";
    static final String DFA102_minS =
        "\1\7\3\uffff\1\0\15\uffff";
    static final String DFA102_maxS =
        "\1\162\3\uffff\1\0\15\uffff";
    static final String DFA102_acceptS =
        "\1\uffff\1\1\16\uffff\1\2\1\3";
    static final String DFA102_specialS =
        "\4\uffff\1\0\15\uffff}>";
    static final String[] DFA102_transitionS = {
            "\1\4\2\uffff\1\1\12\uffff\1\1\31\uffff\1\1\61\uffff\2\1\3\uffff"+
            "\2\1\3\uffff\4\1\1\uffff\3\1",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA102_eot = DFA.unpackEncodedString(DFA102_eotS);
    static final short[] DFA102_eof = DFA.unpackEncodedString(DFA102_eofS);
    static final char[] DFA102_min = DFA.unpackEncodedStringToUnsignedChars(DFA102_minS);
    static final char[] DFA102_max = DFA.unpackEncodedStringToUnsignedChars(DFA102_maxS);
    static final short[] DFA102_accept = DFA.unpackEncodedString(DFA102_acceptS);
    static final short[] DFA102_special = DFA.unpackEncodedString(DFA102_specialS);
    static final short[][] DFA102_transition;

    static {
        int numStates = DFA102_transitionS.length;
        DFA102_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA102_transition[i] = DFA.unpackEncodedString(DFA102_transitionS[i]);
        }
    }

    class DFA102 extends DFA {

        public DFA102(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 102;
            this.eot = DFA102_eot;
            this.eof = DFA102_eof;
            this.min = DFA102_min;
            this.max = DFA102_max;
            this.accept = DFA102_accept;
            this.special = DFA102_special;
            this.transition = DFA102_transition;
        }
        public String getDescription() {
            return "1775:1: bounds_clause : ( numeric_expression DOUBLEDOT numeric_expression | kINDICES kOF atom ( BETWEEN numeric_expression AND numeric_expression )? | kVALUES kOF atom );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA102_4 = input.LA(1);

                         
                        int index102_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((((input.LT(1).getText().equalsIgnoreCase("indices"))||(input.LT(1).getText().equalsIgnoreCase("values")))))) ) {s = 1;}

                        else if ( ((input.LT(1).getText().equalsIgnoreCase("indices"))) ) {s = 16;}

                        else if ( ((input.LT(1).getText().equalsIgnoreCase("values"))) ) {s = 17;}

                         
                        input.seek(index102_4);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 102, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA152_eotS =
        "\14\uffff";
    static final String DFA152_eofS =
        "\2\uffff\1\1\11\uffff";
    static final String DFA152_minS =
        "\1\7\1\uffff\1\4\5\uffff\2\7\2\uffff";
    static final String DFA152_maxS =
        "\1\162\1\uffff\1\145\5\uffff\1\162\1\157\2\uffff";
    static final String DFA152_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\2\uffff\1\7\1\10";
    static final String DFA152_specialS =
        "\14\uffff}>";
    static final String[] DFA152_transitionS = {
            "\1\2\2\uffff\1\10\12\uffff\1\7\31\uffff\1\1\66\uffff\1\3\1\5"+
            "\3\uffff\1\5\2\6\1\4\1\uffff\3\6",
            "",
            "\2\1\1\uffff\1\1\1\uffff\5\1\5\uffff\2\1\14\uffff\1\11\1\1"+
            "\10\uffff\2\1\1\uffff\1\1\3\uffff\2\1\10\uffff\2\1\1\uffff\2"+
            "\1\2\uffff\3\1\11\uffff\7\1\1\uffff\2\1\1\uffff\14\1",
            "",
            "",
            "",
            "",
            "",
            "\1\12\2\uffff\1\12\11\uffff\2\12\31\uffff\1\12\1\13\60\uffff"+
            "\2\12\3\uffff\2\12\3\uffff\4\12\1\uffff\3\12",
            "\1\1\47\uffff\1\1\2\uffff\1\1\74\uffff\1\6",
            "",
            ""
    };

    static final short[] DFA152_eot = DFA.unpackEncodedString(DFA152_eotS);
    static final short[] DFA152_eof = DFA.unpackEncodedString(DFA152_eofS);
    static final char[] DFA152_min = DFA.unpackEncodedStringToUnsignedChars(DFA152_minS);
    static final char[] DFA152_max = DFA.unpackEncodedStringToUnsignedChars(DFA152_maxS);
    static final short[] DFA152_accept = DFA.unpackEncodedString(DFA152_acceptS);
    static final short[] DFA152_special = DFA.unpackEncodedString(DFA152_specialS);
    static final short[][] DFA152_transition;

    static {
        int numStates = DFA152_transitionS.length;
        DFA152_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA152_transition[i] = DFA.unpackEncodedString(DFA152_transitionS[i]);
        }
    }

    class DFA152 extends DFA {

        public DFA152(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 152;
            this.eot = DFA152_eot;
            this.eof = DFA152_eof;
            this.min = DFA152_min;
            this.max = DFA152_max;
            this.accept = DFA152_accept;
            this.special = DFA152_special;
            this.transition = DFA152_transition;
        }
        public String getDescription() {
            return "2404:1: atom : ( variable_or_function_call ( PERCENT attribute )? | SQL PERCENT attribute | string_literal | numeric_atom | boolean_atom | NULL | LPAREN expression RPAREN | LPAREN dbmsfunc_call ( EQ | NOT_EQ | LTH | LEQ | GTH | GEQ ) INTEGER RPAREN );";
        }
    }
 

    public static final BitSet FOLLOW_create_object_in_sqlplus_file58 = new BitSet(new long[]{0x0000000000000010L,0x0010000000000000L});
    public static final BitSet FOLLOW_DIVIDE_in_sqlplus_file62 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_show_errors_in_sqlplus_file64 = new BitSet(new long[]{0x0000000000000010L,0x0010000000000000L});
    public static final BitSet FOLLOW_DIVIDE_in_sqlplus_file69 = new BitSet(new long[]{0x0000000000000010L,0x0010000000000000L});
    public static final BitSet FOLLOW_EOF_in_sqlplus_file75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_kSHOW_in_show_errors121 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_kERRORS_in_show_errors123 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_SEMI_in_show_errors125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_create_package_in_create_object143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_create_package_body_in_create_object156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_create_function_in_create_object166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_create_procedure_in_create_object184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROCEDURE_in_procedure_heading225 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_procedure_heading227 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_parameter_declarations_in_procedure_heading252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function_heading303 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_function_heading305 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_parameter_declarations_in_function_heading326 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RETURN_in_function_heading362 = new BitSet(new long[]{0x0000000100000080L});
    public static final BitSet FOLLOW_datatype_in_function_heading364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_parameter_declarations383 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parameter_declaration_in_parameter_declarations385 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_COMMA_in_parameter_declarations389 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parameter_declaration_in_parameter_declarations391 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RPAREN_in_parameter_declarations396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_parameter_declaration436 = new BitSet(new long[]{0x0000000100006080L});
    public static final BitSet FOLLOW_IN_in_parameter_declaration442 = new BitSet(new long[]{0x0000000100000080L});
    public static final BitSet FOLLOW_OUT_in_parameter_declaration450 = new BitSet(new long[]{0x0000000100008080L});
    public static final BitSet FOLLOW_IN_in_parameter_declaration454 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_OUT_in_parameter_declaration456 = new BitSet(new long[]{0x0000000100008080L});
    public static final BitSet FOLLOW_NOCOPY_in_parameter_declaration460 = new BitSet(new long[]{0x0000000100000080L});
    public static final BitSet FOLLOW_datatype_in_parameter_declaration477 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_ASSIGN_in_parameter_declaration483 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_DEFAULT_in_parameter_declaration489 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_parameter_declaration495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_definition_in_declare_section548 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_declare_section550 = new BitSet(new long[]{0x00000000010401C2L,0x0000000000000400L});
    public static final BitSet FOLLOW_subtype_definition_in_declare_section561 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_declare_section577 = new BitSet(new long[]{0x00000000010401E2L,0x0000000000000400L});
    public static final BitSet FOLLOW_cursor_definition_in_declare_section593 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_declare_section595 = new BitSet(new long[]{0x00000000010401E2L,0x0000000000000400L});
    public static final BitSet FOLLOW_item_declaration_in_declare_section606 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_declare_section608 = new BitSet(new long[]{0x00000000010401E2L,0x0000000000000400L});
    public static final BitSet FOLLOW_function_declaration_or_definition_in_declare_section619 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_declare_section621 = new BitSet(new long[]{0x00000000010401E2L,0x0000000000000400L});
    public static final BitSet FOLLOW_procedure_declaration_or_definition_in_declare_section632 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_declare_section634 = new BitSet(new long[]{0x00000000010401E2L,0x0000000000000400L});
    public static final BitSet FOLLOW_pragma_in_declare_section645 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_declare_section647 = new BitSet(new long[]{0x00000000010401E2L,0x0000000000000400L});
    public static final BitSet FOLLOW_CURSOR_in_cursor_definition694 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_cursor_definition696 = new BitSet(new long[]{0x0000000000080400L});
    public static final BitSet FOLLOW_parameter_declarations_in_cursor_definition702 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IS_in_cursor_definition708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_select_statement_in_cursor_definition710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_item_declaration760 = new BitSet(new long[]{0x0000000100000080L});
    public static final BitSet FOLLOW_datatype_in_item_declaration773 = new BitSet(new long[]{0x0000000000130002L});
    public static final BitSet FOLLOW_NOT_in_item_declaration791 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_NULL_in_item_declaration793 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_set_in_item_declaration798 = new BitSet(new long[]{0x0001800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_item_declaration812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dbmsfunc_call_in_item_declaration826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_declaration_in_item_declaration841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exception_declaration_in_item_declaration855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_constant_declaration887 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_CONSTANT_in_constant_declaration889 = new BitSet(new long[]{0x0000000100000080L});
    public static final BitSet FOLLOW_datatype_in_constant_declaration891 = new BitSet(new long[]{0x0000000000130000L});
    public static final BitSet FOLLOW_NOT_in_constant_declaration895 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_NULL_in_constant_declaration897 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_set_in_constant_declaration902 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_constant_declaration916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_exception_declaration947 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_EXCEPTION_in_exception_declaration949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_kTYPE_in_type_definition973 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_type_definition975 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IS_in_type_definition977 = new BitSet(new long[]{0x0000000136000000L});
    public static final BitSet FOLLOW_record_type_definition_in_type_definition981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collection_type_definition_in_type_definition986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ref_cursor_type_definition_in_type_definition991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBTYPE_in_subtype_definition1022 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_subtype_definition1024 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IS_in_subtype_definition1026 = new BitSet(new long[]{0x0000000100000080L});
    public static final BitSet FOLLOW_datatype_in_subtype_definition1056 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_NOT_in_subtype_definition1079 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_NULL_in_subtype_definition1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECORD_in_record_type_definition1133 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_record_type_definition1135 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_record_field_declaration_in_record_type_definition1142 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_COMMA_in_record_type_definition1151 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_record_field_declaration_in_record_type_definition1159 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RPAREN_in_record_type_definition1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_record_field_declaration1192 = new BitSet(new long[]{0x0000000100000080L});
    public static final BitSet FOLLOW_datatype_in_record_field_declaration1194 = new BitSet(new long[]{0x0000000000130002L});
    public static final BitSet FOLLOW_NOT_in_record_field_declaration1202 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_NULL_in_record_field_declaration1204 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_set_in_record_field_declaration1209 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_record_field_declaration1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varray_type_definition_in_collection_type_definition1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_table_type_definition_in_collection_type_definition1254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARYING_in_varray_type_definition1270 = new BitSet(new long[]{0x0000000008000400L});
    public static final BitSet FOLLOW_ARRAY_in_varray_type_definition1272 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_VARRAY_in_varray_type_definition1277 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_varray_type_definition1281 = new BitSet(new long[]{0x0000000000000000L,0x0000088000000000L});
    public static final BitSet FOLLOW_numeric_literal_in_varray_type_definition1283 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_varray_type_definition1285 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_kOF_in_varray_type_definition1287 = new BitSet(new long[]{0x0000000100000080L});
    public static final BitSet FOLLOW_datatype_in_varray_type_definition1289 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_NOT_in_varray_type_definition1293 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_NULL_in_varray_type_definition1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TABLE_in_nested_table_type_definition1318 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_kOF_in_nested_table_type_definition1320 = new BitSet(new long[]{0x0000000100000080L});
    public static final BitSet FOLLOW_datatype_in_nested_table_type_definition1322 = new BitSet(new long[]{0x0000000040100002L});
    public static final BitSet FOLLOW_NOT_in_nested_table_type_definition1326 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_NULL_in_nested_table_type_definition1328 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_INDEX_in_nested_table_type_definition1335 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_BY_in_nested_table_type_definition1337 = new BitSet(new long[]{0x0000000100000080L});
    public static final BitSet FOLLOW_associative_index_type_in_nested_table_type_definition1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_datatype_in_associative_index_type1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REF_in_ref_cursor_type_definition1388 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_CURSOR_in_ref_cursor_type_definition1390 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_RETURN_in_ref_cursor_type_definition1394 = new BitSet(new long[]{0x0000000100000080L});
    public static final BitSet FOLLOW_datatype_in_ref_cursor_type_definition1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REF_in_datatype1429 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_datatype1434 = new BitSet(new long[]{0x0000000600000402L});
    public static final BitSet FOLLOW_DOT_in_datatype1438 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_datatype1440 = new BitSet(new long[]{0x0000000400000402L});
    public static final BitSet FOLLOW_LPAREN_in_datatype1447 = new BitSet(new long[]{0x0000000000000000L,0x0000088000000000L});
    public static final BitSet FOLLOW_numeric_literal_in_datatype1449 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_COMMA_in_datatype1453 = new BitSet(new long[]{0x0000000000000000L,0x0000088000000000L});
    public static final BitSet FOLLOW_numeric_literal_in_datatype1455 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RPAREN_in_datatype1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERCENT_in_datatype1464 = new BitSet(new long[]{0x0000000800000080L});
    public static final BitSet FOLLOW_kTYPE_in_datatype1468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROWTYPE_in_datatype1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_heading_in_function_declaration_or_definition1509 = new BitSet(new long[]{0x000001F000080002L});
    public static final BitSet FOLLOW_set_in_function_declaration_or_definition1521 = new BitSet(new long[]{0x000001F000080002L});
    public static final BitSet FOLLOW_set_in_function_declaration_or_definition1550 = new BitSet(new long[]{0x00000200010401E0L,0x0000000000000400L});
    public static final BitSet FOLLOW_declare_section_in_function_declaration_or_definition1560 = new BitSet(new long[]{0x00000200010401E0L,0x0000000000000400L});
    public static final BitSet FOLLOW_body_in_function_declaration_or_definition1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procedure_heading_in_procedure_declaration_or_definition1630 = new BitSet(new long[]{0x0000010000080002L});
    public static final BitSet FOLLOW_set_in_procedure_declaration_or_definition1643 = new BitSet(new long[]{0x00000200010401E0L,0x0000000000000400L});
    public static final BitSet FOLLOW_declare_section_in_procedure_declaration_or_definition1653 = new BitSet(new long[]{0x00000200010401E0L,0x0000000000000400L});
    public static final BitSet FOLLOW_body_in_procedure_declaration_or_definition1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BEGIN_in_body1733 = new BitSet(new long[]{0x06DF820000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_statement_in_body1737 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_body1742 = new BitSet(new long[]{0x06DF860001B407E0L,0x000778C603BFBEC6L});
    public static final BitSet FOLLOW_statement_in_body1746 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_body1751 = new BitSet(new long[]{0x06DF860001B407E0L,0x000778C603BFBEC6L});
    public static final BitSet FOLLOW_pragma_in_body1755 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_body1757 = new BitSet(new long[]{0x06DF860001B407E0L,0x000778C603BFBEC6L});
    public static final BitSet FOLLOW_EXCEPTION_in_body1767 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_exception_handler_in_body1771 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_END_in_body1779 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ID_in_body1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHEN_in_exception_handler1799 = new BitSet(new long[]{0x0000A00000000080L});
    public static final BitSet FOLLOW_qual_id_in_exception_handler1803 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_OR_in_exception_handler1807 = new BitSet(new long[]{0x0000800000000080L});
    public static final BitSet FOLLOW_qual_id_in_exception_handler1809 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_OTHERS_in_exception_handler1818 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_THEN_in_exception_handler1824 = new BitSet(new long[]{0x06DF820000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_statement_in_exception_handler1841 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_exception_handler1843 = new BitSet(new long[]{0x06DF820000300682L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_label_in_statement1865 = new BitSet(new long[]{0x06DF820000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_assign_or_call_statement_in_statement1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_statement_in_statement1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_close_statement_in_statement1890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continue_statement_in_statement1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_basic_loop_statement_in_statement1906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_execute_immediate_statement_in_statement1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exit_statement_in_statement1922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fetch_statement_in_statement1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_for_loop_statement_in_statement1938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forall_statement_in_statement1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goto_statement_in_statement1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_statement_in_statement1962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_null_statement_in_statement1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_open_statement_in_statement1978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plsql_block_in_statement1986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_raise_statement_in_statement1995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_statement_in_statement2004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sql_statement_in_statement2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_loop_statement_in_statement2021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dbmsfunc_call_in_statement2030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_lvalue_in_lvalue2071 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_DOT_in_lvalue2077 = new BitSet(new long[]{0x0000800000000080L});
    public static final BitSet FOLLOW_call_lvalue_in_lvalue2081 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_lvalue_in_assign_or_call_statement2134 = new BitSet(new long[]{0x0000000200010002L});
    public static final BitSet FOLLOW_DOT_in_assign_or_call_statement2155 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_delete_call_in_assign_or_call_statement2178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_assign_or_call_statement2188 = new BitSet(new long[]{0x0001800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_assign_or_call_statement2200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dbmsfunc_call_in_assign_or_call_statement2210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_call2241 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_call2246 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_LPAREN_in_call2257 = new BitSet(new long[]{0x0000800000301480L,0x000778C600000000L});
    public static final BitSet FOLLOW_parameter_in_call2269 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_COMMA_in_call2286 = new BitSet(new long[]{0x0001800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_parameter_in_call2291 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_dbmsfunc_call_in_call2307 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RPAREN_in_call2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_call_lvalue2347 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_call_lvalue2350 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_LPAREN_in_call_lvalue2373 = new BitSet(new long[]{0x0000800000301480L,0x000778C600000000L});
    public static final BitSet FOLLOW_parameter_in_call_lvalue2379 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_COMMA_in_call_lvalue2385 = new BitSet(new long[]{0x0001800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_parameter_in_call_lvalue2390 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_dbmsfunc_call_in_call_lvalue2394 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RPAREN_in_call_lvalue2402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DBMS_in_dbmsfunc_call2425 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_DOT_in_dbmsfunc_call2427 = new BitSet(new long[]{0x0002000000000080L});
    public static final BitSet FOLLOW_set_in_dbmsfunc_call2429 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_LPAREN_in_dbmsfunc_call2439 = new BitSet(new long[]{0x0000800000301480L,0x000778C600000000L});
    public static final BitSet FOLLOW_parameter_in_dbmsfunc_call2443 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_COMMA_in_dbmsfunc_call2446 = new BitSet(new long[]{0x0001800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_parameter_in_dbmsfunc_call2449 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_dbmsfunc_call_in_dbmsfunc_call2452 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RPAREN_in_dbmsfunc_call2460 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_DELETE_in_delete_call2480 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_LPAREN_in_delete_call2484 = new BitSet(new long[]{0x0000800000301480L,0x000778C600000000L});
    public static final BitSet FOLLOW_parameter_in_delete_call2486 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_delete_call2489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOOP_in_basic_loop_statement2519 = new BitSet(new long[]{0x06DF820000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_statement_in_basic_loop_statement2531 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_basic_loop_statement2535 = new BitSet(new long[]{0x06DF860000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_END_in_basic_loop_statement2541 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_LOOP_in_basic_loop_statement2543 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_label_name_in_basic_loop_statement2545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_case_statement2580 = new BitSet(new long[]{0x0000880000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_case_statement2582 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_WHEN_in_case_statement2605 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_case_statement2607 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_THEN_in_case_statement2609 = new BitSet(new long[]{0x06DF820000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_statement_in_case_statement2634 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_case_statement2638 = new BitSet(new long[]{0x06FF8E0000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_ELSE_in_case_statement2656 = new BitSet(new long[]{0x06DF820000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_statement_in_case_statement2679 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_case_statement2681 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_END_in_case_statement2687 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_CASE_in_case_statement2689 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_label_name_in_case_statement2709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLOSE_in_close_statement2747 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_close_statement2749 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_DOT_in_close_statement2753 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_close_statement2755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_continue_statement2803 = new BitSet(new long[]{0x0000080000000082L});
    public static final BitSet FOLLOW_ID_in_continue_statement2809 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_WHEN_in_continue_statement2816 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_continue_statement2818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXECUTE_in_execute_immediate_statement2868 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IMMEDIATE_in_execute_immediate_statement2870 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_execute_immediate_statement2872 = new BitSet(new long[]{0xB000000000000202L,0x0000000000000001L});
    public static final BitSet FOLLOW_into_clause_in_execute_immediate_statement2896 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_bulk_collect_into_clause_in_execute_immediate_statement2918 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_using_clause_in_execute_immediate_statement2921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_using_clause_in_execute_immediate_statement2934 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000001L});
    public static final BitSet FOLLOW_dynamic_returning_clause_in_execute_immediate_statement2936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dynamic_returning_clause_in_execute_immediate_statement2949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXIT_in_exit_statement2989 = new BitSet(new long[]{0x0000080000000082L});
    public static final BitSet FOLLOW_ID_in_exit_statement2995 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_WHEN_in_exit_statement3002 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_exit_statement3004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FETCH_in_fetch_statement3048 = new BitSet(new long[]{0x0000800000000080L});
    public static final BitSet FOLLOW_qual_id_in_fetch_statement3050 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_into_clause_in_fetch_statement3073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bulk_collect_into_clause_in_fetch_statement3077 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_fetch_statement3081 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_numeric_expression_in_fetch_statement3083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_into_clause3120 = new BitSet(new long[]{0x0000800000000080L});
    public static final BitSet FOLLOW_lvalue_in_into_clause3122 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_into_clause3133 = new BitSet(new long[]{0x0000800000000080L});
    public static final BitSet FOLLOW_lvalue_in_into_clause3135 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_BULK_in_bulk_collect_into_clause3177 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_COLLECT_in_bulk_collect_into_clause3179 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTO_in_bulk_collect_into_clause3181 = new BitSet(new long[]{0x0000800000000080L});
    public static final BitSet FOLLOW_lvalue_in_bulk_collect_into_clause3183 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_bulk_collect_into_clause3188 = new BitSet(new long[]{0x0000800000000080L});
    public static final BitSet FOLLOW_lvalue_in_bulk_collect_into_clause3190 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_USING_in_using_clause3215 = new BitSet(new long[]{0x0000800000306480L,0x000778C600000000L});
    public static final BitSet FOLLOW_param_modifiers_in_using_clause3217 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_using_clause3220 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_using_clause3224 = new BitSet(new long[]{0x0000800000306480L,0x000778C600000000L});
    public static final BitSet FOLLOW_param_modifiers_in_using_clause3226 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_using_clause3229 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_IN_in_param_modifiers3246 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_OUT_in_param_modifiers3248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUT_in_param_modifiers3253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_dynamic_returning_clause3271 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_into_clause_in_dynamic_returning_clause3283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bulk_collect_into_clause_in_dynamic_returning_clause3287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_for_loop_statement3318 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_for_loop_statement3320 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IN_in_for_loop_statement3322 = new BitSet(new long[]{0xFFF7FFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_set_in_for_loop_statement3346 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_LOOP_in_for_loop_statement3379 = new BitSet(new long[]{0x06DF820000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_statement_in_for_loop_statement3385 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_for_loop_statement3389 = new BitSet(new long[]{0x06DF860000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_END_in_for_loop_statement3394 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_LOOP_in_for_loop_statement3396 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_label_name_in_for_loop_statement3414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORALL_in_forall_statement3445 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_forall_statement3447 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IN_in_forall_statement3449 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_bounds_clause_in_forall_statement3487 = new BitSet(new long[]{0x0004000000000000L,0x0000000001BF8000L});
    public static final BitSet FOLLOW_sql_statement_in_forall_statement3527 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_kSAVE_in_forall_statement3550 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_kEXCEPTIONS_in_forall_statement3552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_expression_in_bounds_clause3582 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_DOUBLEDOT_in_bounds_clause3586 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_numeric_expression_in_bounds_clause3588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_kINDICES_in_bounds_clause3598 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_kOF_in_bounds_clause3600 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_atom_in_bounds_clause3602 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_BETWEEN_in_bounds_clause3606 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_numeric_expression_in_bounds_clause3608 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_AND_in_bounds_clause3612 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_numeric_expression_in_bounds_clause3614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_kVALUES_in_bounds_clause3627 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_kOF_in_bounds_clause3629 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_atom_in_bounds_clause3631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GOTO_in_goto_statement3655 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_goto_statement3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_if_statement3696 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_if_statement3698 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_THEN_in_if_statement3700 = new BitSet(new long[]{0x06DF820000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_statement_in_if_statement3730 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_if_statement3734 = new BitSet(new long[]{0x06FF860000300680L,0x000778C603BFBBC6L});
    public static final BitSet FOLLOW_ELSIF_in_if_statement3749 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_if_statement3752 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_THEN_in_if_statement3754 = new BitSet(new long[]{0x06DF820000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_statement_in_if_statement3781 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_if_statement3785 = new BitSet(new long[]{0x06FF860000300680L,0x000778C603BFBBC6L});
    public static final BitSet FOLLOW_ELSE_in_if_statement3803 = new BitSet(new long[]{0x06DF820000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_statement_in_if_statement3833 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_if_statement3837 = new BitSet(new long[]{0x06DF860000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_END_in_if_statement3860 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_IF_in_if_statement3862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_null_statement3898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_open_statement3942 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_open_statement3944 = new BitSet(new long[]{0x0000000200000402L,0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_open_statement3950 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_open_statement3952 = new BitSet(new long[]{0x0000000200000402L,0x0000000000000002L});
    public static final BitSet FOLLOW_call_args_in_open_statement3957 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_open_statement3971 = new BitSet(new long[]{0x0000000000000080L,0x0000000000100000L});
    public static final BitSet FOLLOW_select_statement_in_open_statement3974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_open_statement3979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRAGMA_in_pragma4015 = new BitSet(new long[]{0xFFFFFFFFFFFFFFD0L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_swallow_to_semi_in_pragma4017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RAISE_in_raise_statement4041 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ID_in_raise_statement4054 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_DOT_in_raise_statement4060 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_raise_statement4064 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_RETURN_in_return_statement4107 = new BitSet(new long[]{0x0000800000300482L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_return_statement4111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECLARE_in_plsql_block4150 = new BitSet(new long[]{0x00000000010401E0L,0x0000000000000400L});
    public static final BitSet FOLLOW_declare_section_in_plsql_block4152 = new BitSet(new long[]{0x0000020000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_body_block_in_plsql_block4157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BEGIN_in_body_block4181 = new BitSet(new long[]{0x06DF820000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_statement_in_body_block4186 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_body_block4191 = new BitSet(new long[]{0x06DF860001B407E0L,0x000778C603BFBEC6L});
    public static final BitSet FOLLOW_statement_in_body_block4195 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_body_block4200 = new BitSet(new long[]{0x06DF860001B407E0L,0x000778C603BFBEC6L});
    public static final BitSet FOLLOW_pragma_in_body_block4204 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_body_block4206 = new BitSet(new long[]{0x06DF860001B407E0L,0x000778C603BFBEC6L});
    public static final BitSet FOLLOW_EXCEPTION_in_body_block4220 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_exception_handler_in_body_block4224 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_END_in_body_block4232 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ID_in_body_block4235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LLABEL_in_label4261 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_label4263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_RLABEL_in_label4265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_qual_id4292 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_qual_id4295 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_DOT_in_qual_id4299 = new BitSet(new long[]{0x0000800000000080L});
    public static final BitSet FOLLOW_COLON_in_qual_id4301 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_qual_id4304 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_commit_statement_in_sql_statement4325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delete_statement_in_sql_statement4333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insert_statement_in_sql_statement4342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lock_table_statement_in_sql_statement4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rollback_statement_in_sql_statement4360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_savepoint_statement_in_sql_statement4369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_statement_in_sql_statement4378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_transaction_statement_in_sql_statement4387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_update_statement_in_sql_statement4395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_merge_statement_in_sql_statement4404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMIT_in_commit_statement4431 = new BitSet(new long[]{0xFFFFFFFFFFFFFFD2L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_swallow_to_semi_in_commit_statement4433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_delete_statement4476 = new BitSet(new long[]{0xFFFFFFFFFFFFFFD0L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_swallow_to_semi_in_delete_statement4478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSERT_in_insert_statement4530 = new BitSet(new long[]{0xFFFFFFFFFFFFFFD0L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_swallow_to_semi_in_insert_statement4532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_in_lock_table_statement4566 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_TABLE_in_lock_table_statement4568 = new BitSet(new long[]{0xFFFFFFFFFFFFFFD0L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_swallow_to_semi_in_lock_table_statement4570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLBACK_in_rollback_statement4600 = new BitSet(new long[]{0xFFFFFFFFFFFFFFD2L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_swallow_to_semi_in_rollback_statement4602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAVEPOINT_in_savepoint_statement4647 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_savepoint_statement4649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select_statement4706 = new BitSet(new long[]{0xFFFFFFFFFFFFFFD0L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_swallow_to_semi_in_select_statement4708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_set_transaction_statement4758 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_TRANSACTION_in_set_transaction_statement4760 = new BitSet(new long[]{0xFFFFFFFFFFFFFFD0L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_swallow_to_semi_in_set_transaction_statement4762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_update_statement4796 = new BitSet(new long[]{0xFFFFFFFFFFFFFFD0L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_swallow_to_semi_in_update_statement4798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MERGE_in_merge_statement4851 = new BitSet(new long[]{0xFFFFFFFFFFFFFFD0L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_swallow_to_semi_in_merge_statement4854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_swallow_to_semi4889 = new BitSet(new long[]{0xFFFFFFFFFFFFFFD2L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_WHILE_in_while_loop_statement4921 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_while_loop_statement4923 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_LOOP_in_while_loop_statement4925 = new BitSet(new long[]{0x06DF820000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_statement_in_while_loop_statement4950 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_while_loop_statement4954 = new BitSet(new long[]{0x06DF860000300680L,0x000778C603BFBAC6L});
    public static final BitSet FOLLOW_END_in_while_loop_statement4959 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_LOOP_in_while_loop_statement4961 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_label_name_in_while_loop_statement4963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_match_parens5000 = new BitSet(new long[]{0xFFFFFEFFFFF78BD2L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_RPAREN_in_match_parens5040 = new BitSet(new long[]{0xFFFFFEFFFFF79FD0L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_match_parens_in_match_parens5042 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_match_parens5044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_label_name5057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_or_expr_in_expression5078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_and_expr_in_or_expr5096 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_OR_in_or_expr5100 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_and_expr_in_or_expr5104 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_not_expr_in_and_expr5126 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_AND_in_and_expr5130 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_not_expr_in_and_expr5135 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_NOT_in_not_expr5162 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_compare_expr_in_not_expr5167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_is_null_expr_in_compare_expr5189 = new BitSet(new long[]{0x0000000000000002L,0x00000000FC000000L});
    public static final BitSet FOLLOW_EQ_in_compare_expr5201 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_NOT_EQ_in_compare_expr5207 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_LTH_in_compare_expr5212 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_LEQ_in_compare_expr5217 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_GTH_in_compare_expr5222 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_GEQ_in_compare_expr5227 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_is_null_expr_in_compare_expr5241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_like_expr_in_is_null_expr5262 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_IS_in_is_null_expr5266 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_NOT_in_is_null_expr5270 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_NULL_in_is_null_expr5275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_between_expr_in_like_expr5304 = new BitSet(new long[]{0x0000000000100002L,0x0000000100000000L});
    public static final BitSet FOLLOW_NOT_in_like_expr5314 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_LIKE_in_like_expr5319 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_between_expr_in_like_expr5329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_in_expr_in_between_expr5353 = new BitSet(new long[]{0x0000000000100002L,0x0000000000000010L});
    public static final BitSet FOLLOW_NOT_in_between_expr5357 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_BETWEEN_in_between_expr5362 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_in_expr_in_between_expr5377 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_AND_in_between_expr5379 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_in_expr_in_between_expr5383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_expr_in_in_expr5408 = new BitSet(new long[]{0x0000000000102002L});
    public static final BitSet FOLLOW_NOT_in_in_expr5412 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IN_in_in_expr5417 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_in_expr5419 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_add_expr_in_in_expr5423 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_COMMA_in_in_expr5433 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_add_expr_in_in_expr5438 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RPAREN_in_in_expr5443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_expr_in_numeric_expression5468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mul_expr_in_add_expr5494 = new BitSet(new long[]{0x0000000000000002L,0x0000000E00000000L});
    public static final BitSet FOLLOW_MINUS_in_add_expr5512 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_PLUS_in_add_expr5524 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_DOUBLEVERTBAR_in_add_expr5536 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_mul_expr_in_add_expr5556 = new BitSet(new long[]{0x0000000000000002L,0x0000000E00000000L});
    public static final BitSet FOLLOW_unary_sign_expr_in_mul_expr5593 = new BitSet(new long[]{0x0000000000000092L,0x0000001000000000L});
    public static final BitSet FOLLOW_ASTERISK_in_mul_expr5605 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_DIVIDE_in_mul_expr5610 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_kMOD_in_mul_expr5616 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_unary_sign_expr_in_mul_expr5632 = new BitSet(new long[]{0x0000000000000092L,0x0000001000000000L});
    public static final BitSet FOLLOW_MINUS_in_unary_sign_expr5662 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_PLUS_in_unary_sign_expr5668 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_exponent_expr_in_unary_sign_expr5683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_exponent_expr5703 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_EXPONENT_in_exponent_expr5707 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_atom_in_exponent_expr5711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_or_function_call_in_atom5743 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_PERCENT_in_atom5754 = new BitSet(new long[]{0x0000000000000000L,0x3000070000000000L});
    public static final BitSet FOLLOW_attribute_in_atom5758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQL_in_atom5786 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_PERCENT_in_atom5788 = new BitSet(new long[]{0x0000000000000000L,0x3000070000000000L});
    public static final BitSet FOLLOW_attribute_in_atom5804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_literal_in_atom5815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_atom_in_atom5824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_atom_in_atom5833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_atom5842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom5863 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_atom5877 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_atom5885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom5903 = new BitSet(new long[]{0x0001800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_dbmsfunc_call_in_atom5905 = new BitSet(new long[]{0x0000000000000000L,0x00000000FC000000L});
    public static final BitSet FOLLOW_set_in_atom5907 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_INTEGER_in_atom5933 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_atom5935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_in_variable_or_function_call5961 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_DOT_in_variable_or_function_call5967 = new BitSet(new long[]{0x0000800000000080L});
    public static final BitSet FOLLOW_call_in_variable_or_function_call5971 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_DOT_in_variable_or_function_call5982 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_delete_call_in_variable_or_function_call5986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BULK_ROWCOUNT_in_attribute6021 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_attribute6023 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_attribute6043 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_attribute6058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_kFOUND_in_attribute6094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ISOPEN_in_attribute6126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOTFOUND_in_attribute6158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_kROWCOUNT_in_attribute6195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_call_args6234 = new BitSet(new long[]{0x0000800000301480L,0x000778C600000000L});
    public static final BitSet FOLLOW_parameter_in_call_args6238 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_COMMA_in_call_args6242 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_parameter_in_call_args6246 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RPAREN_in_call_args6254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_literal_in_boolean_atom6279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collection_exists_in_boolean_atom6287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditional_predicate_in_boolean_atom6295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_literal_in_numeric_atom6312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_numeric_literal6329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_NUMBER_in_numeric_literal6339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_boolean_literal6359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_boolean_literal6364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_STRING_in_string_literal6398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_collection_exists6425 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_DOT_in_collection_exists6427 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_EXISTS_in_collection_exists6429 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_collection_exists6431 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_collection_exists6433 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_collection_exists6435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSERTING_in_conditional_predicate6452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATING_in_conditional_predicate6460 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_LPAREN_in_conditional_predicate6464 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_QUOTED_STRING_in_conditional_predicate6466 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_conditional_predicate6468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETING_in_conditional_predicate6479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_parameter6506 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_ARROW_in_parameter6508 = new BitSet(new long[]{0x0000800000300480L,0x000778C600000000L});
    public static final BitSet FOLLOW_expression_in_parameter6521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_index6546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_create_package6570 = new BitSet(new long[]{0x0000100000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_OR_in_create_package6577 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_kREPLACE_in_create_package6579 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_PACKAGE_in_create_package6584 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_create_package6590 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_DOT_in_create_package6592 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_create_package6599 = new BitSet(new long[]{0x0000010000080000L,0x0100000000000000L});
    public static final BitSet FOLLOW_invoker_rights_clause_in_create_package6611 = new BitSet(new long[]{0x0000010000080000L});
    public static final BitSet FOLLOW_set_in_create_package6624 = new BitSet(new long[]{0x00000400010401E0L,0x0000000000000400L});
    public static final BitSet FOLLOW_declare_section_in_create_package6647 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_END_in_create_package6662 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_ID_in_create_package6666 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_create_package6671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_create_package_body6698 = new BitSet(new long[]{0x0000100000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_OR_in_create_package_body6702 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_kREPLACE_in_create_package_body6704 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_PACKAGE_in_create_package_body6709 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_BODY_in_create_package_body6711 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_create_package_body6717 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_DOT_in_create_package_body6719 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_create_package_body6726 = new BitSet(new long[]{0x0000010000080000L});
    public static final BitSet FOLLOW_set_in_create_package_body6754 = new BitSet(new long[]{0x00000600010401E0L,0x0000000000000400L});
    public static final BitSet FOLLOW_declare_section_in_create_package_body6768 = new BitSet(new long[]{0x00000600010401E0L,0x0000000000000400L});
    public static final BitSet FOLLOW_body_in_create_package_body6786 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_END_in_create_package_body6790 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_ID_in_create_package_body6796 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_create_package_body6803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_create_procedure6869 = new BitSet(new long[]{0x0000100000000040L});
    public static final BitSet FOLLOW_OR_in_create_procedure6873 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_kREPLACE_in_create_procedure6875 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PROCEDURE_in_create_procedure6880 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_create_procedure6886 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_DOT_in_create_procedure6888 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_create_procedure6895 = new BitSet(new long[]{0x0000010000080400L,0x0100000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_create_procedure6919 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parameter_declaration_in_create_procedure6921 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_COMMA_in_create_procedure6925 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parameter_declaration_in_create_procedure6927 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RPAREN_in_create_procedure6931 = new BitSet(new long[]{0x0000010000080000L,0x0100000000000000L});
    public static final BitSet FOLLOW_invoker_rights_clause_in_create_procedure6983 = new BitSet(new long[]{0x0000010000080000L});
    public static final BitSet FOLLOW_set_in_create_procedure6994 = new BitSet(new long[]{0x00000200010401E0L,0x0880000000000400L});
    public static final BitSet FOLLOW_declare_section_in_create_procedure7032 = new BitSet(new long[]{0x00000200010401E0L,0x0000000000000400L});
    public static final BitSet FOLLOW_body_in_create_procedure7035 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_call_spec_in_create_procedure7047 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EXTERNAL_in_create_procedure7059 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_create_procedure7090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_create_function7117 = new BitSet(new long[]{0x0000100000000100L});
    public static final BitSet FOLLOW_OR_in_create_function7121 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_kREPLACE_in_create_function7123 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_FUNCTION_in_create_function7128 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_create_function7134 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_DOT_in_create_function7136 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_create_function7143 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_LPAREN_in_create_function7161 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parameter_declaration_in_create_function7163 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_COMMA_in_create_function7167 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parameter_declaration_in_create_function7170 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RPAREN_in_create_function7175 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RETURN_in_create_function7235 = new BitSet(new long[]{0x0000000100000080L});
    public static final BitSet FOLLOW_datatype_in_create_function7237 = new BitSet(new long[]{0x0000010000080000L,0x0100000000000000L});
    public static final BitSet FOLLOW_invoker_rights_clause_in_create_function7247 = new BitSet(new long[]{0x0000010000080000L});
    public static final BitSet FOLLOW_set_in_create_function7258 = new BitSet(new long[]{0x00000200010401E0L,0x0880000000000400L});
    public static final BitSet FOLLOW_declare_section_in_create_function7291 = new BitSet(new long[]{0x00000200010401E0L,0x0000000000000400L});
    public static final BitSet FOLLOW_body_in_create_function7294 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_call_spec_in_create_function7306 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EXTERNAL_in_create_function7318 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_create_function7356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AUTHID_in_invoker_rights_clause7394 = new BitSet(new long[]{0x0000000000000000L,0x0600000000000000L});
    public static final BitSet FOLLOW_set_in_invoker_rights_clause7396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LANGUAGE_in_call_spec7421 = new BitSet(new long[]{0xFFFFFFFFFFFFFFD0L,0xFFFFFFFFFFFFFFFFL,0x00000000000007FFL});
    public static final BitSet FOLLOW_swallow_to_semi_in_call_spec7423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_kERRORS7438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_kEXCEPTIONS7447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOUND_in_kFOUND7455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_kINDICES7473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_kMOD7482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_kNAME7491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_kOF7501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_kREPLACE7510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROWCOUNT_in_kROWCOUNT7517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_kSAVE7536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_kSHOW7545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_kTYPE7554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_kVALUES7563 = new BitSet(new long[]{0x0000000000000002L});

}