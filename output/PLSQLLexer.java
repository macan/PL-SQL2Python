// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/macan/Private/pl2py/PLSQL.g 2013-10-26 13:48:40

package org.plsql;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PLSQLLexer extends Lexer {
    public static final int FUNCTION=8;
    public static final int PACKAGE=117;
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
    public static final int LOOP=51;
    public static final int BEGIN=41;
    public static final int SAVEPOINT=83;
    public static final int RETURN=9;
    public static final int RAISE=75;
    public static final int BODY=118;
    public static final int GEQ=95;
    public static final int EQ=90;
    public static final int GOTO=70;
    public static final int DBMS=48;
    public static final int SELECT=84;
    public static final int INTO=60;
    public static final int ISOPEN=105;
    public static final int ARRAY=27;
    public static final int DIVIDE=4;
    public static final int EXCEPTION=23;
    public static final int EXIT=57;
    public static final int RBRACK=129;
    public static final int SPOOL=137;
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
    public static final int INDEX=30;
    public static final int ML_COMMENT=136;
    public static final int AS=40;
    public static final int ROWTYPE=35;
    public static final int THEN=46;
    public static final int IN=13;
    public static final int CONTINUE=55;
    public static final int COMMA=11;
    public static final int IS=19;
    public static final int PLUS=98;
    public static final int QUOTED_STRING=110;
    public static final int EXISTS=111;
    public static final int DOT=33;
    public static final int ROWCOUNT=125;
    public static final int LIKE=96;
    public static final int INTEGER=103;
    public static final int VARRAY=28;
    public static final int BY=31;
    public static final int PERCENT=34;
    public static final int PARALLEL_ENABLE=38;
    public static final int DOUBLEQUOTED_STRING=126;
    public static final int MERGE=88;
    public static final int DEFAULT=17;
    public static final int FORALL=66;
    public static final int SET=85;
    public static final int MINUS=97;
    public static final int SEMI=5;
    public static final int TRUE=108;
    public static final int PROCEDURE=6;
    public static final int NOT_EQ=91;
    public static final int REF=32;
    public static final int VERTBAR=131;
    public static final int OPEN=73;
    public static final int COLON=47;
    public static final int LTH=92;
    public static final int COMMIT=79;
    public static final int BULK_ROWCOUNT=104;
    public static final int CLOSE=54;
    public static final int WHEN=43;
    public static final int ASSIGN=16;
    public static final int FOUND=124;
    public static final int IMMEDIATE=56;
    public static final int NUMBER_VALUE=133;
    public static final int DECLARE=76;
    public static final int ARROW=115;
    public static final int DELETING=114;
    public static final int BULK=61;
    public static final int BETWEEN=68;
    public static final int LEQ=93;


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


    // delegates
    // delegators

    public PLSQLLexer() {;} 
    public PLSQLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PLSQLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/macan/Private/pl2py/PLSQL.g"; }

    // $ANTLR start "FOUND"
    public final void mFOUND() throws RecognitionException {
        try {
            int _type = FOUND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2939:7: ( 'found' )
            // /home/macan/Private/pl2py/PLSQL.g:2939:9: 'found'
            {
            match("found"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FOUND"

    // $ANTLR start "ROWCOUNT"
    public final void mROWCOUNT() throws RecognitionException {
        try {
            int _type = ROWCOUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2947:10: ( 'rowcount' )
            // /home/macan/Private/pl2py/PLSQL.g:2947:12: 'rowcount'
            {
            match("rowcount"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ROWCOUNT"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2954:5: ( 'and' )
            // /home/macan/Private/pl2py/PLSQL.g:2954:7: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "ARRAY"
    public final void mARRAY() throws RecognitionException {
        try {
            int _type = ARRAY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2955:7: ( 'array' )
            // /home/macan/Private/pl2py/PLSQL.g:2955:9: 'array'
            {
            match("array"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ARRAY"

    // $ANTLR start "AS"
    public final void mAS() throws RecognitionException {
        try {
            int _type = AS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2956:4: ( 'as' )
            // /home/macan/Private/pl2py/PLSQL.g:2956:6: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AS"

    // $ANTLR start "AUTHID"
    public final void mAUTHID() throws RecognitionException {
        try {
            int _type = AUTHID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2957:7: ( 'authid' )
            // /home/macan/Private/pl2py/PLSQL.g:2957:9: 'authid'
            {
            match("authid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AUTHID"

    // $ANTLR start "BETWEEN"
    public final void mBETWEEN() throws RecognitionException {
        try {
            int _type = BETWEEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2958:9: ( 'between' )
            // /home/macan/Private/pl2py/PLSQL.g:2958:11: 'between'
            {
            match("between"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BETWEEN"

    // $ANTLR start "BODY"
    public final void mBODY() throws RecognitionException {
        try {
            int _type = BODY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2959:6: ( 'body' )
            // /home/macan/Private/pl2py/PLSQL.g:2959:8: 'body'
            {
            match("body"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BODY"

    // $ANTLR start "BULK"
    public final void mBULK() throws RecognitionException {
        try {
            int _type = BULK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2960:5: ( 'bulk' )
            // /home/macan/Private/pl2py/PLSQL.g:2960:7: 'bulk'
            {
            match("bulk"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BULK"

    // $ANTLR start "BULK_ROWCOUNT"
    public final void mBULK_ROWCOUNT() throws RecognitionException {
        try {
            int _type = BULK_ROWCOUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2961:14: ( 'bulk_rowcount' )
            // /home/macan/Private/pl2py/PLSQL.g:2961:16: 'bulk_rowcount'
            {
            match("bulk_rowcount"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BULK_ROWCOUNT"

    // $ANTLR start "BY"
    public final void mBY() throws RecognitionException {
        try {
            int _type = BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2962:4: ( 'by' )
            // /home/macan/Private/pl2py/PLSQL.g:2962:6: 'by'
            {
            match("by"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BY"

    // $ANTLR start "CASE"
    public final void mCASE() throws RecognitionException {
        try {
            int _type = CASE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2963:5: ( 'case' )
            // /home/macan/Private/pl2py/PLSQL.g:2963:7: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CASE"

    // $ANTLR start "CREATE"
    public final void mCREATE() throws RecognitionException {
        try {
            int _type = CREATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2964:7: ( 'create' )
            // /home/macan/Private/pl2py/PLSQL.g:2964:9: 'create'
            {
            match("create"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CREATE"

    // $ANTLR start "COLLECT"
    public final void mCOLLECT() throws RecognitionException {
        try {
            int _type = COLLECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2965:8: ( 'collect' )
            // /home/macan/Private/pl2py/PLSQL.g:2965:10: 'collect'
            {
            match("collect"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLLECT"

    // $ANTLR start "COMMIT"
    public final void mCOMMIT() throws RecognitionException {
        try {
            int _type = COMMIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2966:8: ( 'commit' )
            // /home/macan/Private/pl2py/PLSQL.g:2966:10: 'commit'
            {
            match("commit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMIT"

    // $ANTLR start "CURRENT_USER"
    public final void mCURRENT_USER() throws RecognitionException {
        try {
            int _type = CURRENT_USER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2967:13: ( 'current_user' )
            // /home/macan/Private/pl2py/PLSQL.g:2967:15: 'current_user'
            {
            match("current_user"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CURRENT_USER"

    // $ANTLR start "DBMS"
    public final void mDBMS() throws RecognitionException {
        try {
            int _type = DBMS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2968:6: ( 'dbms_sql' )
            // /home/macan/Private/pl2py/PLSQL.g:2968:8: 'dbms_sql'
            {
            match("dbms_sql"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DBMS"

    // $ANTLR start "DEFAULT"
    public final void mDEFAULT() throws RecognitionException {
        try {
            int _type = DEFAULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2969:9: ( 'default' )
            // /home/macan/Private/pl2py/PLSQL.g:2969:11: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEFAULT"

    // $ANTLR start "DEFINER"
    public final void mDEFINER() throws RecognitionException {
        try {
            int _type = DEFINER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2970:8: ( 'definer' )
            // /home/macan/Private/pl2py/PLSQL.g:2970:10: 'definer'
            {
            match("definer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEFINER"

    // $ANTLR start "DELETE"
    public final void mDELETE() throws RecognitionException {
        try {
            int _type = DELETE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2971:8: ( 'delete' )
            // /home/macan/Private/pl2py/PLSQL.g:2971:10: 'delete'
            {
            match("delete"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DELETE"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2972:6: ( 'else' )
            // /home/macan/Private/pl2py/PLSQL.g:2972:8: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "ELSIF"
    public final void mELSIF() throws RecognitionException {
        try {
            int _type = ELSIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2973:7: ( 'elsif' )
            // /home/macan/Private/pl2py/PLSQL.g:2973:9: 'elsif'
            {
            match("elsif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSIF"

    // $ANTLR start "EXTERNAL"
    public final void mEXTERNAL() throws RecognitionException {
        try {
            int _type = EXTERNAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2974:9: ( 'external' )
            // /home/macan/Private/pl2py/PLSQL.g:2974:11: 'external'
            {
            match("external"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXTERNAL"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2975:7: ( 'false' )
            // /home/macan/Private/pl2py/PLSQL.g:2975:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "FETCH"
    public final void mFETCH() throws RecognitionException {
        try {
            int _type = FETCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2976:7: ( 'fetch' )
            // /home/macan/Private/pl2py/PLSQL.g:2976:9: 'fetch'
            {
            match("fetch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FETCH"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2977:5: ( 'for' )
            // /home/macan/Private/pl2py/PLSQL.g:2977:7: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "FORALL"
    public final void mFORALL() throws RecognitionException {
        try {
            int _type = FORALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2978:8: ( 'forall' )
            // /home/macan/Private/pl2py/PLSQL.g:2978:10: 'forall'
            {
            match("forall"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FORALL"

    // $ANTLR start "GOTO"
    public final void mGOTO() throws RecognitionException {
        try {
            int _type = GOTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2979:6: ( 'goto' )
            // /home/macan/Private/pl2py/PLSQL.g:2979:8: 'goto'
            {
            match("goto"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GOTO"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2980:4: ( 'if' )
            // /home/macan/Private/pl2py/PLSQL.g:2980:6: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2981:4: ( 'in' )
            // /home/macan/Private/pl2py/PLSQL.g:2981:6: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "INDEX"
    public final void mINDEX() throws RecognitionException {
        try {
            int _type = INDEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2982:7: ( 'index' )
            // /home/macan/Private/pl2py/PLSQL.g:2982:9: 'index'
            {
            match("index"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INDEX"

    // $ANTLR start "INSERT"
    public final void mINSERT() throws RecognitionException {
        try {
            int _type = INSERT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2983:8: ( 'insert' )
            // /home/macan/Private/pl2py/PLSQL.g:2983:10: 'insert'
            {
            match("insert"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INSERT"

    // $ANTLR start "INTO"
    public final void mINTO() throws RecognitionException {
        try {
            int _type = INTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2984:6: ( 'into' )
            // /home/macan/Private/pl2py/PLSQL.g:2984:8: 'into'
            {
            match("into"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTO"

    // $ANTLR start "IS"
    public final void mIS() throws RecognitionException {
        try {
            int _type = IS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2985:4: ( 'is' )
            // /home/macan/Private/pl2py/PLSQL.g:2985:6: 'is'
            {
            match("is"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IS"

    // $ANTLR start "LANGUAGE"
    public final void mLANGUAGE() throws RecognitionException {
        try {
            int _type = LANGUAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2986:9: ( 'language' )
            // /home/macan/Private/pl2py/PLSQL.g:2986:11: 'language'
            {
            match("language"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LANGUAGE"

    // $ANTLR start "LIKE"
    public final void mLIKE() throws RecognitionException {
        try {
            int _type = LIKE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2987:6: ( 'like' )
            // /home/macan/Private/pl2py/PLSQL.g:2987:8: 'like'
            {
            match("like"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LIKE"

    // $ANTLR start "LIMIT"
    public final void mLIMIT() throws RecognitionException {
        try {
            int _type = LIMIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2988:7: ( 'limit' )
            // /home/macan/Private/pl2py/PLSQL.g:2988:9: 'limit'
            {
            match("limit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LIMIT"

    // $ANTLR start "LOCK"
    public final void mLOCK() throws RecognitionException {
        try {
            int _type = LOCK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2989:6: ( 'lock' )
            // /home/macan/Private/pl2py/PLSQL.g:2989:8: 'lock'
            {
            match("lock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOCK"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2990:5: ( 'not' )
            // /home/macan/Private/pl2py/PLSQL.g:2990:7: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "NOTFOUND"
    public final void mNOTFOUND() throws RecognitionException {
        try {
            int _type = NOTFOUND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2991:9: ( 'notfound' )
            // /home/macan/Private/pl2py/PLSQL.g:2991:11: 'notfound'
            {
            match("notfound"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOTFOUND"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2992:6: ( 'null' )
            // /home/macan/Private/pl2py/PLSQL.g:2992:8: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NULL"

    // $ANTLR start "OPEN"
    public final void mOPEN() throws RecognitionException {
        try {
            int _type = OPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2993:6: ( 'open' )
            // /home/macan/Private/pl2py/PLSQL.g:2993:8: 'open'
            {
            match("open"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPEN"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2994:4: ( 'or' )
            // /home/macan/Private/pl2py/PLSQL.g:2994:6: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "PACKAGE"
    public final void mPACKAGE() throws RecognitionException {
        try {
            int _type = PACKAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2995:8: ( 'package' )
            // /home/macan/Private/pl2py/PLSQL.g:2995:10: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PACKAGE"

    // $ANTLR start "RAISE"
    public final void mRAISE() throws RecognitionException {
        try {
            int _type = RAISE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2996:7: ( 'raise' )
            // /home/macan/Private/pl2py/PLSQL.g:2996:9: 'raise'
            {
            match("raise"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RAISE"

    // $ANTLR start "ROLLBACK"
    public final void mROLLBACK() throws RecognitionException {
        try {
            int _type = ROLLBACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2997:9: ( 'rollback' )
            // /home/macan/Private/pl2py/PLSQL.g:2997:11: 'rollback'
            {
            match("rollback"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ROLLBACK"

    // $ANTLR start "SAVEPOINT"
    public final void mSAVEPOINT() throws RecognitionException {
        try {
            int _type = SAVEPOINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2998:11: ( 'savepoint' )
            // /home/macan/Private/pl2py/PLSQL.g:2998:13: 'savepoint'
            {
            match("savepoint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SAVEPOINT"

    // $ANTLR start "SELECT"
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:2999:8: ( 'select' )
            // /home/macan/Private/pl2py/PLSQL.g:2999:10: 'select'
            {
            match("select"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SELECT"

    // $ANTLR start "SET"
    public final void mSET() throws RecognitionException {
        try {
            int _type = SET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3000:5: ( 'set' )
            // /home/macan/Private/pl2py/PLSQL.g:3000:7: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SET"

    // $ANTLR start "SQL"
    public final void mSQL() throws RecognitionException {
        try {
            int _type = SQL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3001:5: ( 'sql' )
            // /home/macan/Private/pl2py/PLSQL.g:3001:7: 'sql'
            {
            match("sql"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL"

    // $ANTLR start "TABLE"
    public final void mTABLE() throws RecognitionException {
        try {
            int _type = TABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3002:7: ( 'table' )
            // /home/macan/Private/pl2py/PLSQL.g:3002:9: 'table'
            {
            match("table"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TABLE"

    // $ANTLR start "TRANSACTION"
    public final void mTRANSACTION() throws RecognitionException {
        try {
            int _type = TRANSACTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3003:13: ( 'transaction' )
            // /home/macan/Private/pl2py/PLSQL.g:3003:15: 'transaction'
            {
            match("transaction"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRANSACTION"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3004:6: ( 'true' )
            // /home/macan/Private/pl2py/PLSQL.g:3004:8: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3005:6: ( 'then' )
            // /home/macan/Private/pl2py/PLSQL.g:3005:8: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "UPDATE"
    public final void mUPDATE() throws RecognitionException {
        try {
            int _type = UPDATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3006:8: ( 'update' )
            // /home/macan/Private/pl2py/PLSQL.g:3006:10: 'update'
            {
            match("update"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UPDATE"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3007:7: ( 'while' )
            // /home/macan/Private/pl2py/PLSQL.g:3007:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "INSERTING"
    public final void mINSERTING() throws RecognitionException {
        try {
            int _type = INSERTING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3009:2: ( 'inserting' )
            // /home/macan/Private/pl2py/PLSQL.g:3009:4: 'inserting'
            {
            match("inserting"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INSERTING"

    // $ANTLR start "UPDATING"
    public final void mUPDATING() throws RecognitionException {
        try {
            int _type = UPDATING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3010:9: ( 'updating' )
            // /home/macan/Private/pl2py/PLSQL.g:3010:11: 'updating'
            {
            match("updating"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UPDATING"

    // $ANTLR start "DELETING"
    public final void mDELETING() throws RecognitionException {
        try {
            int _type = DELETING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3011:9: ( 'deleting' )
            // /home/macan/Private/pl2py/PLSQL.g:3011:11: 'deleting'
            {
            match("deleting"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DELETING"

    // $ANTLR start "ISOPEN"
    public final void mISOPEN() throws RecognitionException {
        try {
            int _type = ISOPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3012:8: ( 'isopen' )
            // /home/macan/Private/pl2py/PLSQL.g:3012:10: 'isopen'
            {
            match("isopen"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ISOPEN"

    // $ANTLR start "EXISTS"
    public final void mEXISTS() throws RecognitionException {
        try {
            int _type = EXISTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3013:8: ( 'exists' )
            // /home/macan/Private/pl2py/PLSQL.g:3013:10: 'exists'
            {
            match("exists"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXISTS"

    // $ANTLR start "BEGIN"
    public final void mBEGIN() throws RecognitionException {
        try {
            int _type = BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3015:7: ( 'begin' )
            // /home/macan/Private/pl2py/PLSQL.g:3015:9: 'begin'
            {
            match("begin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BEGIN"

    // $ANTLR start "CLOSE"
    public final void mCLOSE() throws RecognitionException {
        try {
            int _type = CLOSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3016:7: ( 'close' )
            // /home/macan/Private/pl2py/PLSQL.g:3016:9: 'close'
            {
            match("close"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSE"

    // $ANTLR start "CONSTANT"
    public final void mCONSTANT() throws RecognitionException {
        try {
            int _type = CONSTANT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3017:10: ( 'constant' )
            // /home/macan/Private/pl2py/PLSQL.g:3017:12: 'constant'
            {
            match("constant"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONSTANT"

    // $ANTLR start "CONTINUE"
    public final void mCONTINUE() throws RecognitionException {
        try {
            int _type = CONTINUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3018:9: ( 'continue' )
            // /home/macan/Private/pl2py/PLSQL.g:3018:11: 'continue'
            {
            match("continue"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONTINUE"

    // $ANTLR start "CURSOR"
    public final void mCURSOR() throws RecognitionException {
        try {
            int _type = CURSOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3019:8: ( 'cursor' )
            // /home/macan/Private/pl2py/PLSQL.g:3019:10: 'cursor'
            {
            match("cursor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CURSOR"

    // $ANTLR start "DECLARE"
    public final void mDECLARE() throws RecognitionException {
        try {
            int _type = DECLARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3020:9: ( 'declare' )
            // /home/macan/Private/pl2py/PLSQL.g:3020:11: 'declare'
            {
            match("declare"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECLARE"

    // $ANTLR start "DETERMINISTIC"
    public final void mDETERMINISTIC() throws RecognitionException {
        try {
            int _type = DETERMINISTIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3021:15: ( 'deterministic' )
            // /home/macan/Private/pl2py/PLSQL.g:3021:17: 'deterministic'
            {
            match("deterministic"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DETERMINISTIC"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3022:5: ( 'end' )
            // /home/macan/Private/pl2py/PLSQL.g:3022:7: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "EXCEPTION"
    public final void mEXCEPTION() throws RecognitionException {
        try {
            int _type = EXCEPTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3023:11: ( 'exception' )
            // /home/macan/Private/pl2py/PLSQL.g:3023:13: 'exception'
            {
            match("exception"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXCEPTION"

    // $ANTLR start "EXECUTE"
    public final void mEXECUTE() throws RecognitionException {
        try {
            int _type = EXECUTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3024:9: ( 'execute' )
            // /home/macan/Private/pl2py/PLSQL.g:3024:11: 'execute'
            {
            match("execute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXECUTE"

    // $ANTLR start "EXIT"
    public final void mEXIT() throws RecognitionException {
        try {
            int _type = EXIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3025:6: ( 'exit' )
            // /home/macan/Private/pl2py/PLSQL.g:3025:8: 'exit'
            {
            match("exit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXIT"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3026:10: ( 'function' )
            // /home/macan/Private/pl2py/PLSQL.g:3026:12: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "IMMEDIATE"
    public final void mIMMEDIATE() throws RecognitionException {
        try {
            int _type = IMMEDIATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3027:11: ( 'immediate' )
            // /home/macan/Private/pl2py/PLSQL.g:3027:13: 'immediate'
            {
            match("immediate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IMMEDIATE"

    // $ANTLR start "LOOP"
    public final void mLOOP() throws RecognitionException {
        try {
            int _type = LOOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3028:6: ( 'loop' )
            // /home/macan/Private/pl2py/PLSQL.g:3028:8: 'loop'
            {
            match("loop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOOP"

    // $ANTLR start "MERGE"
    public final void mMERGE() throws RecognitionException {
        try {
            int _type = MERGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3029:7: ( 'merge' )
            // /home/macan/Private/pl2py/PLSQL.g:3029:9: 'merge'
            {
            match("merge"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MERGE"

    // $ANTLR start "NOCOPY"
    public final void mNOCOPY() throws RecognitionException {
        try {
            int _type = NOCOPY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3030:8: ( 'nocopy' )
            // /home/macan/Private/pl2py/PLSQL.g:3030:10: 'nocopy'
            {
            match("nocopy"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOCOPY"

    // $ANTLR start "OTHERS"
    public final void mOTHERS() throws RecognitionException {
        try {
            int _type = OTHERS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3031:8: ( 'others' )
            // /home/macan/Private/pl2py/PLSQL.g:3031:10: 'others'
            {
            match("others"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OTHERS"

    // $ANTLR start "OUT"
    public final void mOUT() throws RecognitionException {
        try {
            int _type = OUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3032:5: ( 'out' )
            // /home/macan/Private/pl2py/PLSQL.g:3032:7: 'out'
            {
            match("out"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OUT"

    // $ANTLR start "PARALLEL_ENABLE"
    public final void mPARALLEL_ENABLE() throws RecognitionException {
        try {
            int _type = PARALLEL_ENABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3033:17: ( 'parallel_enable' )
            // /home/macan/Private/pl2py/PLSQL.g:3033:19: 'parallel_enable'
            {
            match("parallel_enable"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PARALLEL_ENABLE"

    // $ANTLR start "PIPELINED"
    public final void mPIPELINED() throws RecognitionException {
        try {
            int _type = PIPELINED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3034:11: ( 'pipelined' )
            // /home/macan/Private/pl2py/PLSQL.g:3034:13: 'pipelined'
            {
            match("pipelined"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PIPELINED"

    // $ANTLR start "PRAGMA"
    public final void mPRAGMA() throws RecognitionException {
        try {
            int _type = PRAGMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3035:8: ( 'pragma' )
            // /home/macan/Private/pl2py/PLSQL.g:3035:10: 'pragma'
            {
            match("pragma"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRAGMA"

    // $ANTLR start "PROCEDURE"
    public final void mPROCEDURE() throws RecognitionException {
        try {
            int _type = PROCEDURE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3036:11: ( 'procedure' )
            // /home/macan/Private/pl2py/PLSQL.g:3036:13: 'procedure'
            {
            match("procedure"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROCEDURE"

    // $ANTLR start "RECORD"
    public final void mRECORD() throws RecognitionException {
        try {
            int _type = RECORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3037:8: ( 'record' )
            // /home/macan/Private/pl2py/PLSQL.g:3037:10: 'record'
            {
            match("record"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RECORD"

    // $ANTLR start "REF"
    public final void mREF() throws RecognitionException {
        try {
            int _type = REF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3038:5: ( 'ref' )
            // /home/macan/Private/pl2py/PLSQL.g:3038:7: 'ref'
            {
            match("ref"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REF"

    // $ANTLR start "RESULT_CACHE"
    public final void mRESULT_CACHE() throws RecognitionException {
        try {
            int _type = RESULT_CACHE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3039:14: ( 'result_cache' )
            // /home/macan/Private/pl2py/PLSQL.g:3039:16: 'result_cache'
            {
            match("result_cache"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RESULT_CACHE"

    // $ANTLR start "RETURN"
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3040:8: ( 'return' )
            // /home/macan/Private/pl2py/PLSQL.g:3040:10: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RETURN"

    // $ANTLR start "RETURNING"
    public final void mRETURNING() throws RecognitionException {
        try {
            int _type = RETURNING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3041:11: ( 'returning' )
            // /home/macan/Private/pl2py/PLSQL.g:3041:13: 'returning'
            {
            match("returning"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RETURNING"

    // $ANTLR start "ROWTYPE"
    public final void mROWTYPE() throws RecognitionException {
        try {
            int _type = ROWTYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3042:9: ( 'rowtype' )
            // /home/macan/Private/pl2py/PLSQL.g:3042:11: 'rowtype'
            {
            match("rowtype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ROWTYPE"

    // $ANTLR start "SUBTYPE"
    public final void mSUBTYPE() throws RecognitionException {
        try {
            int _type = SUBTYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3043:9: ( 'subtype' )
            // /home/macan/Private/pl2py/PLSQL.g:3043:11: 'subtype'
            {
            match("subtype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUBTYPE"

    // $ANTLR start "USING"
    public final void mUSING() throws RecognitionException {
        try {
            int _type = USING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3044:6: ( 'using' )
            // /home/macan/Private/pl2py/PLSQL.g:3044:8: 'using'
            {
            match("using"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "USING"

    // $ANTLR start "VARRAY"
    public final void mVARRAY() throws RecognitionException {
        try {
            int _type = VARRAY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3045:8: ( 'varray' )
            // /home/macan/Private/pl2py/PLSQL.g:3045:10: 'varray'
            {
            match("varray"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARRAY"

    // $ANTLR start "VARYING"
    public final void mVARYING() throws RecognitionException {
        try {
            int _type = VARYING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3046:9: ( 'varying' )
            // /home/macan/Private/pl2py/PLSQL.g:3046:11: 'varying'
            {
            match("varying"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARYING"

    // $ANTLR start "WHEN"
    public final void mWHEN() throws RecognitionException {
        try {
            int _type = WHEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3047:6: ( 'when' )
            // /home/macan/Private/pl2py/PLSQL.g:3047:8: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHEN"

    // $ANTLR start "QUOTED_STRING"
    public final void mQUOTED_STRING() throws RecognitionException {
        try {
            int _type = QUOTED_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3050:2: ( ( 'n' )? '\\'' ( '\\'\\'' | ~ ( '\\'' ) )* '\\'' )
            // /home/macan/Private/pl2py/PLSQL.g:3050:4: ( 'n' )? '\\'' ( '\\'\\'' | ~ ( '\\'' ) )* '\\''
            {
            // /home/macan/Private/pl2py/PLSQL.g:3050:4: ( 'n' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='n') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:3050:6: 'n'
                    {
                    match('n'); 

                    }
                    break;

            }

            match('\''); 
            // /home/macan/Private/pl2py/PLSQL.g:3050:18: ( '\\'\\'' | ~ ( '\\'' ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\'') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='\'') ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='\uFFFF')) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:3050:20: '\\'\\''
            	    {
            	    match("''"); 


            	    }
            	    break;
            	case 2 :
            	    // /home/macan/Private/pl2py/PLSQL.g:3050:29: ~ ( '\\'' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTED_STRING"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3054:2: ( ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' | '$' | '#' )* | DOUBLEQUOTED_STRING | ( '\\uB0A1' .. '\\uF7FE' ) | ( '\\u4E00' .. '\\u9FA5' ) | ( '\\uF900' .. '\\uFA2D' ) )
            int alt4=5;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>='a' && LA4_0<='z')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='\"') ) {
                alt4=2;
            }
            else if ( ((LA4_0>='\uB0A1' && LA4_0<='\uF7FE')) ) {
                alt4=3;
            }
            else if ( ((LA4_0>='\u4E00' && LA4_0<='\u9FA5')) ) {
                alt4=4;
            }
            else if ( ((LA4_0>='\uF900' && LA4_0<='\uFA2D')) ) {
                alt4=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:3054:4: ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' | '$' | '#' )*
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:3054:4: ( 'a' .. 'z' )
                    // /home/macan/Private/pl2py/PLSQL.g:3054:6: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }

                    // /home/macan/Private/pl2py/PLSQL.g:3055:3: ( 'a' .. 'z' | '0' .. '9' | '_' | '$' | '#' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='#' && LA3_0<='$')||(LA3_0>='0' && LA3_0<='9')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/macan/Private/pl2py/PLSQL.g:
                    	    {
                    	    if ( (input.LA(1)>='#' && input.LA(1)<='$')||(input.LA(1)>='0' && input.LA(1)<='9')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:3056:4: DOUBLEQUOTED_STRING
                    {
                    mDOUBLEQUOTED_STRING(); 

                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:3057:4: ( '\\uB0A1' .. '\\uF7FE' )
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:3057:4: ( '\\uB0A1' .. '\\uF7FE' )
                    // /home/macan/Private/pl2py/PLSQL.g:3057:5: '\\uB0A1' .. '\\uF7FE'
                    {
                    matchRange('\uB0A1','\uF7FE'); 

                    }


                    }
                    break;
                case 4 :
                    // /home/macan/Private/pl2py/PLSQL.g:3058:4: ( '\\u4E00' .. '\\u9FA5' )
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:3058:4: ( '\\u4E00' .. '\\u9FA5' )
                    // /home/macan/Private/pl2py/PLSQL.g:3058:5: '\\u4E00' .. '\\u9FA5'
                    {
                    matchRange('\u4E00','\u9FA5'); 

                    }


                    }
                    break;
                case 5 :
                    // /home/macan/Private/pl2py/PLSQL.g:3059:5: ( '\\uF900' .. '\\uFA2D' )
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:3059:5: ( '\\uF900' .. '\\uFA2D' )
                    // /home/macan/Private/pl2py/PLSQL.g:3059:6: '\\uF900' .. '\\uFA2D'
                    {
                    matchRange('\uF900','\uFA2D'); 

                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3062:2: ( ';' )
            // /home/macan/Private/pl2py/PLSQL.g:3062:4: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3065:2: ( ':' )
            // /home/macan/Private/pl2py/PLSQL.g:3065:4: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "DOUBLEDOT"
    public final void mDOUBLEDOT() throws RecognitionException {
        try {
            int _type = DOUBLEDOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3068:2: ( POINT POINT )
            // /home/macan/Private/pl2py/PLSQL.g:3068:4: POINT POINT
            {
            mPOINT(); 
            mPOINT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLEDOT"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3071:2: ( POINT )
            // /home/macan/Private/pl2py/PLSQL.g:3071:4: POINT
            {
            mPOINT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "POINT"
    public final void mPOINT() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:3075:2: ( '.' )
            // /home/macan/Private/pl2py/PLSQL.g:3075:4: '.'
            {
            match('.'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "POINT"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3078:2: ( ( ',' ) | ( '\\uFF0C' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==',') ) {
                alt5=1;
            }
            else if ( (LA5_0=='\uFF0C') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:3078:4: ( ',' )
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:3078:4: ( ',' )
                    // /home/macan/Private/pl2py/PLSQL.g:3078:5: ','
                    {
                    match(','); 

                    }


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:3078:10: ( '\\uFF0C' )
                    {
                    // /home/macan/Private/pl2py/PLSQL.g:3078:10: ( '\\uFF0C' )
                    // /home/macan/Private/pl2py/PLSQL.g:3078:11: '\\uFF0C'
                    {
                    match('\uFF0C'); 

                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            int _type = EXPONENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3081:2: ( '**' )
            // /home/macan/Private/pl2py/PLSQL.g:3081:4: '**'
            {
            match("**"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "ASTERISK"
    public final void mASTERISK() throws RecognitionException {
        try {
            int _type = ASTERISK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3084:2: ( '*' )
            // /home/macan/Private/pl2py/PLSQL.g:3084:4: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASTERISK"

    // $ANTLR start "AT_SIGN"
    public final void mAT_SIGN() throws RecognitionException {
        try {
            int _type = AT_SIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3087:2: ( '@' )
            // /home/macan/Private/pl2py/PLSQL.g:3087:4: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT_SIGN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3090:2: ( ')' | '\\uFF09' )
            // /home/macan/Private/pl2py/PLSQL.g:
            {
            if ( input.LA(1)==')'||input.LA(1)=='\uFF09' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3093:2: ( '(' | '\\uFF08' )
            // /home/macan/Private/pl2py/PLSQL.g:
            {
            if ( input.LA(1)=='('||input.LA(1)=='\uFF08' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RBRACK"
    public final void mRBRACK() throws RecognitionException {
        try {
            int _type = RBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3096:2: ( ']' )
            // /home/macan/Private/pl2py/PLSQL.g:3096:4: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACK"

    // $ANTLR start "LBRACK"
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3099:2: ( '[' )
            // /home/macan/Private/pl2py/PLSQL.g:3099:4: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACK"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3102:2: ( '+' )
            // /home/macan/Private/pl2py/PLSQL.g:3102:4: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3105:2: ( '-' )
            // /home/macan/Private/pl2py/PLSQL.g:3105:4: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "DIVIDE"
    public final void mDIVIDE() throws RecognitionException {
        try {
            int _type = DIVIDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3108:2: ( '/' )
            // /home/macan/Private/pl2py/PLSQL.g:3108:4: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIVIDE"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3111:2: ( '=' )
            // /home/macan/Private/pl2py/PLSQL.g:3111:4: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "PERCENT"
    public final void mPERCENT() throws RecognitionException {
        try {
            int _type = PERCENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3114:2: ( '%' )
            // /home/macan/Private/pl2py/PLSQL.g:3114:4: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PERCENT"

    // $ANTLR start "LLABEL"
    public final void mLLABEL() throws RecognitionException {
        try {
            int _type = LLABEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3117:2: ( '<<' )
            // /home/macan/Private/pl2py/PLSQL.g:3117:4: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LLABEL"

    // $ANTLR start "RLABEL"
    public final void mRLABEL() throws RecognitionException {
        try {
            int _type = RLABEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3120:2: ( '>>' )
            // /home/macan/Private/pl2py/PLSQL.g:3120:4: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RLABEL"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3123:2: ( ':=' )
            // /home/macan/Private/pl2py/PLSQL.g:3123:4: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "ARROW"
    public final void mARROW() throws RecognitionException {
        try {
            int _type = ARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3126:2: ( '=>' )
            // /home/macan/Private/pl2py/PLSQL.g:3126:4: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ARROW"

    // $ANTLR start "VERTBAR"
    public final void mVERTBAR() throws RecognitionException {
        try {
            int _type = VERTBAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3129:2: ( '|' )
            // /home/macan/Private/pl2py/PLSQL.g:3129:4: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VERTBAR"

    // $ANTLR start "DOUBLEVERTBAR"
    public final void mDOUBLEVERTBAR() throws RecognitionException {
        try {
            int _type = DOUBLEVERTBAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3132:2: ( '||' )
            // /home/macan/Private/pl2py/PLSQL.g:3132:4: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLEVERTBAR"

    // $ANTLR start "NOT_EQ"
    public final void mNOT_EQ() throws RecognitionException {
        try {
            int _type = NOT_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3135:2: ( '<>' | '!=' | '~=' | '^=' )
            int alt6=4;
            switch ( input.LA(1) ) {
            case '<':
                {
                alt6=1;
                }
                break;
            case '!':
                {
                alt6=2;
                }
                break;
            case '~':
                {
                alt6=3;
                }
                break;
            case '^':
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:3135:4: '<>'
                    {
                    match("<>"); 


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:3135:11: '!='
                    {
                    match("!="); 


                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:3135:18: '~='
                    {
                    match("~="); 


                    }
                    break;
                case 4 :
                    // /home/macan/Private/pl2py/PLSQL.g:3135:24: '^='
                    {
                    match("^="); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT_EQ"

    // $ANTLR start "LTH"
    public final void mLTH() throws RecognitionException {
        try {
            int _type = LTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3138:2: ( '<' )
            // /home/macan/Private/pl2py/PLSQL.g:3138:4: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LTH"

    // $ANTLR start "LEQ"
    public final void mLEQ() throws RecognitionException {
        try {
            int _type = LEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3141:2: ( '<=' )
            // /home/macan/Private/pl2py/PLSQL.g:3141:4: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEQ"

    // $ANTLR start "GTH"
    public final void mGTH() throws RecognitionException {
        try {
            int _type = GTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3144:2: ( '>' )
            // /home/macan/Private/pl2py/PLSQL.g:3144:4: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GTH"

    // $ANTLR start "GEQ"
    public final void mGEQ() throws RecognitionException {
        try {
            int _type = GEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3147:2: ( '>=' )
            // /home/macan/Private/pl2py/PLSQL.g:3147:4: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GEQ"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3150:6: ( N )
            // /home/macan/Private/pl2py/PLSQL.g:3150:10: N
            {
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "REAL_NUMBER"
    public final void mREAL_NUMBER() throws RecognitionException {
        try {
            int _type = REAL_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3153:2: ( NUMBER_VALUE ( 'e' ( PLUS | MINUS )? N )? )
            // /home/macan/Private/pl2py/PLSQL.g:3153:4: NUMBER_VALUE ( 'e' ( PLUS | MINUS )? N )?
            {
            mNUMBER_VALUE(); 
            // /home/macan/Private/pl2py/PLSQL.g:3153:17: ( 'e' ( PLUS | MINUS )? N )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='e') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:3153:19: 'e' ( PLUS | MINUS )? N
                    {
                    match('e'); 
                    // /home/macan/Private/pl2py/PLSQL.g:3153:23: ( PLUS | MINUS )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='+'||LA7_0=='-') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    mN(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REAL_NUMBER"

    // $ANTLR start "NUMBER_VALUE"
    public final void mNUMBER_VALUE() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:3157:2: ({...}? => N POINT ( N )? | POINT N | N )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:3157:4: {...}? => N POINT ( N )?
                    {
                    if ( !((numberDotValid())) ) {
                        throw new FailedPredicateException(input, "NUMBER_VALUE", "numberDotValid()");
                    }
                    mN(); 
                    mPOINT(); 
                    // /home/macan/Private/pl2py/PLSQL.g:3157:34: ( N )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /home/macan/Private/pl2py/PLSQL.g:3157:34: N
                            {
                            mN(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:3158:4: POINT N
                    {
                    mPOINT(); 
                    mN(); 

                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:3159:4: N
                    {
                    mN(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER_VALUE"

    // $ANTLR start "N"
    public final void mN() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:3163:2: ( '0' .. '9' ( '0' .. '9' )* )
            // /home/macan/Private/pl2py/PLSQL.g:3163:4: '0' .. '9' ( '0' .. '9' )*
            {
            matchRange('0','9'); 
            // /home/macan/Private/pl2py/PLSQL.g:3163:15: ( '0' .. '9' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:3163:17: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "N"

    // $ANTLR start "DOUBLEQUOTED_STRING"
    public final void mDOUBLEQUOTED_STRING() throws RecognitionException {
        try {
            // /home/macan/Private/pl2py/PLSQL.g:3167:2: ( '\"' (~ ( '\"' ) )* '\"' )
            // /home/macan/Private/pl2py/PLSQL.g:3167:4: '\"' (~ ( '\"' ) )* '\"'
            {
            match('\"'); 
            // /home/macan/Private/pl2py/PLSQL.g:3167:8: (~ ( '\"' ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:3167:10: ~ ( '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match('\"'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DOUBLEQUOTED_STRING"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3169:4: ( ( ' ' | '\\r' | '\\t' | '\\n' | '\\u3000' ) )
            // /home/macan/Private/pl2py/PLSQL.g:3169:6: ( ' ' | '\\r' | '\\t' | '\\n' | '\\u3000' )
            {
            // /home/macan/Private/pl2py/PLSQL.g:3169:6: ( ' ' | '\\r' | '\\t' | '\\n' | '\\u3000' )
            int alt13=5;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt13=1;
                }
                break;
            case '\r':
                {
                alt13=2;
                }
                break;
            case '\t':
                {
                alt13=3;
                }
                break;
            case '\n':
                {
                alt13=4;
                }
                break;
            case '\u3000':
                {
                alt13=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:3169:7: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // /home/macan/Private/pl2py/PLSQL.g:3169:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // /home/macan/Private/pl2py/PLSQL.g:3169:16: '\\t'
                    {
                    match('\t'); 

                    }
                    break;
                case 4 :
                    // /home/macan/Private/pl2py/PLSQL.g:3169:21: '\\n'
                    {
                    match('\n'); 
                    row_count++;

                    }
                    break;
                case 5 :
                    // /home/macan/Private/pl2py/PLSQL.g:3169:42: '\\u3000'
                    {
                    match('\u3000'); 

                    }
                    break;

            }

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3172:2: ( '--' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /home/macan/Private/pl2py/PLSQL.g:3172:4: '--' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("--"); 

            // /home/macan/Private/pl2py/PLSQL.g:3172:9: (~ ( '\\n' | '\\r' ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:3172:9: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // /home/macan/Private/pl2py/PLSQL.g:3172:23: ( '\\r' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:3172:23: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3175:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /home/macan/Private/pl2py/PLSQL.g:3175:4: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /home/macan/Private/pl2py/PLSQL.g:3175:9: ( options {greedy=false; } : . )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='*') ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1=='/') ) {
                        alt16=2;
                    }
                    else if ( ((LA16_1>='\u0000' && LA16_1<='.')||(LA16_1>='0' && LA16_1<='\uFFFF')) ) {
                        alt16=1;
                    }


                }
                else if ( ((LA16_0>='\u0000' && LA16_0<=')')||(LA16_0>='+' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:3175:37: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            match("*/"); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "SPOOL"
    public final void mSPOOL() throws RecognitionException {
        try {
            int _type = SPOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3178:7: ( 'spool' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /home/macan/Private/pl2py/PLSQL.g:3178:9: 'spool' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("spool"); 

            // /home/macan/Private/pl2py/PLSQL.g:3178:17: (~ ( '\\n' | '\\r' ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:3178:17: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // /home/macan/Private/pl2py/PLSQL.g:3178:31: ( '\\r' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='\r') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:3178:31: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SPOOL"

    // $ANTLR start "PROMPT"
    public final void mPROMPT() throws RecognitionException {
        try {
            int _type = PROMPT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/macan/Private/pl2py/PLSQL.g:3180:8: ( 'prompt' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /home/macan/Private/pl2py/PLSQL.g:3180:10: 'prompt' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("prompt"); 

            // /home/macan/Private/pl2py/PLSQL.g:3180:19: (~ ( '\\n' | '\\r' ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='\u0000' && LA19_0<='\t')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /home/macan/Private/pl2py/PLSQL.g:3180:19: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // /home/macan/Private/pl2py/PLSQL.g:3180:33: ( '\\r' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='\r') ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/macan/Private/pl2py/PLSQL.g:3180:33: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROMPT"

    public void mTokens() throws RecognitionException {
        // /home/macan/Private/pl2py/PLSQL.g:1:8: ( FOUND | ROWCOUNT | AND | ARRAY | AS | AUTHID | BETWEEN | BODY | BULK | BULK_ROWCOUNT | BY | CASE | CREATE | COLLECT | COMMIT | CURRENT_USER | DBMS | DEFAULT | DEFINER | DELETE | ELSE | ELSIF | EXTERNAL | FALSE | FETCH | FOR | FORALL | GOTO | IF | IN | INDEX | INSERT | INTO | IS | LANGUAGE | LIKE | LIMIT | LOCK | NOT | NOTFOUND | NULL | OPEN | OR | PACKAGE | RAISE | ROLLBACK | SAVEPOINT | SELECT | SET | SQL | TABLE | TRANSACTION | TRUE | THEN | UPDATE | WHILE | INSERTING | UPDATING | DELETING | ISOPEN | EXISTS | BEGIN | CLOSE | CONSTANT | CONTINUE | CURSOR | DECLARE | DETERMINISTIC | END | EXCEPTION | EXECUTE | EXIT | FUNCTION | IMMEDIATE | LOOP | MERGE | NOCOPY | OTHERS | OUT | PARALLEL_ENABLE | PIPELINED | PRAGMA | PROCEDURE | RECORD | REF | RESULT_CACHE | RETURN | RETURNING | ROWTYPE | SUBTYPE | USING | VARRAY | VARYING | WHEN | QUOTED_STRING | ID | SEMI | COLON | DOUBLEDOT | DOT | COMMA | EXPONENT | ASTERISK | AT_SIGN | RPAREN | LPAREN | RBRACK | LBRACK | PLUS | MINUS | DIVIDE | EQ | PERCENT | LLABEL | RLABEL | ASSIGN | ARROW | VERTBAR | DOUBLEVERTBAR | NOT_EQ | LTH | LEQ | GTH | GEQ | INTEGER | REAL_NUMBER | WS | SL_COMMENT | ML_COMMENT | SPOOL | PROMPT )
        int alt21=131;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // /home/macan/Private/pl2py/PLSQL.g:1:10: FOUND
                {
                mFOUND(); 

                }
                break;
            case 2 :
                // /home/macan/Private/pl2py/PLSQL.g:1:16: ROWCOUNT
                {
                mROWCOUNT(); 

                }
                break;
            case 3 :
                // /home/macan/Private/pl2py/PLSQL.g:1:25: AND
                {
                mAND(); 

                }
                break;
            case 4 :
                // /home/macan/Private/pl2py/PLSQL.g:1:29: ARRAY
                {
                mARRAY(); 

                }
                break;
            case 5 :
                // /home/macan/Private/pl2py/PLSQL.g:1:35: AS
                {
                mAS(); 

                }
                break;
            case 6 :
                // /home/macan/Private/pl2py/PLSQL.g:1:38: AUTHID
                {
                mAUTHID(); 

                }
                break;
            case 7 :
                // /home/macan/Private/pl2py/PLSQL.g:1:45: BETWEEN
                {
                mBETWEEN(); 

                }
                break;
            case 8 :
                // /home/macan/Private/pl2py/PLSQL.g:1:53: BODY
                {
                mBODY(); 

                }
                break;
            case 9 :
                // /home/macan/Private/pl2py/PLSQL.g:1:58: BULK
                {
                mBULK(); 

                }
                break;
            case 10 :
                // /home/macan/Private/pl2py/PLSQL.g:1:63: BULK_ROWCOUNT
                {
                mBULK_ROWCOUNT(); 

                }
                break;
            case 11 :
                // /home/macan/Private/pl2py/PLSQL.g:1:77: BY
                {
                mBY(); 

                }
                break;
            case 12 :
                // /home/macan/Private/pl2py/PLSQL.g:1:80: CASE
                {
                mCASE(); 

                }
                break;
            case 13 :
                // /home/macan/Private/pl2py/PLSQL.g:1:85: CREATE
                {
                mCREATE(); 

                }
                break;
            case 14 :
                // /home/macan/Private/pl2py/PLSQL.g:1:92: COLLECT
                {
                mCOLLECT(); 

                }
                break;
            case 15 :
                // /home/macan/Private/pl2py/PLSQL.g:1:100: COMMIT
                {
                mCOMMIT(); 

                }
                break;
            case 16 :
                // /home/macan/Private/pl2py/PLSQL.g:1:107: CURRENT_USER
                {
                mCURRENT_USER(); 

                }
                break;
            case 17 :
                // /home/macan/Private/pl2py/PLSQL.g:1:120: DBMS
                {
                mDBMS(); 

                }
                break;
            case 18 :
                // /home/macan/Private/pl2py/PLSQL.g:1:125: DEFAULT
                {
                mDEFAULT(); 

                }
                break;
            case 19 :
                // /home/macan/Private/pl2py/PLSQL.g:1:133: DEFINER
                {
                mDEFINER(); 

                }
                break;
            case 20 :
                // /home/macan/Private/pl2py/PLSQL.g:1:141: DELETE
                {
                mDELETE(); 

                }
                break;
            case 21 :
                // /home/macan/Private/pl2py/PLSQL.g:1:148: ELSE
                {
                mELSE(); 

                }
                break;
            case 22 :
                // /home/macan/Private/pl2py/PLSQL.g:1:153: ELSIF
                {
                mELSIF(); 

                }
                break;
            case 23 :
                // /home/macan/Private/pl2py/PLSQL.g:1:159: EXTERNAL
                {
                mEXTERNAL(); 

                }
                break;
            case 24 :
                // /home/macan/Private/pl2py/PLSQL.g:1:168: FALSE
                {
                mFALSE(); 

                }
                break;
            case 25 :
                // /home/macan/Private/pl2py/PLSQL.g:1:174: FETCH
                {
                mFETCH(); 

                }
                break;
            case 26 :
                // /home/macan/Private/pl2py/PLSQL.g:1:180: FOR
                {
                mFOR(); 

                }
                break;
            case 27 :
                // /home/macan/Private/pl2py/PLSQL.g:1:184: FORALL
                {
                mFORALL(); 

                }
                break;
            case 28 :
                // /home/macan/Private/pl2py/PLSQL.g:1:191: GOTO
                {
                mGOTO(); 

                }
                break;
            case 29 :
                // /home/macan/Private/pl2py/PLSQL.g:1:196: IF
                {
                mIF(); 

                }
                break;
            case 30 :
                // /home/macan/Private/pl2py/PLSQL.g:1:199: IN
                {
                mIN(); 

                }
                break;
            case 31 :
                // /home/macan/Private/pl2py/PLSQL.g:1:202: INDEX
                {
                mINDEX(); 

                }
                break;
            case 32 :
                // /home/macan/Private/pl2py/PLSQL.g:1:208: INSERT
                {
                mINSERT(); 

                }
                break;
            case 33 :
                // /home/macan/Private/pl2py/PLSQL.g:1:215: INTO
                {
                mINTO(); 

                }
                break;
            case 34 :
                // /home/macan/Private/pl2py/PLSQL.g:1:220: IS
                {
                mIS(); 

                }
                break;
            case 35 :
                // /home/macan/Private/pl2py/PLSQL.g:1:223: LANGUAGE
                {
                mLANGUAGE(); 

                }
                break;
            case 36 :
                // /home/macan/Private/pl2py/PLSQL.g:1:232: LIKE
                {
                mLIKE(); 

                }
                break;
            case 37 :
                // /home/macan/Private/pl2py/PLSQL.g:1:237: LIMIT
                {
                mLIMIT(); 

                }
                break;
            case 38 :
                // /home/macan/Private/pl2py/PLSQL.g:1:243: LOCK
                {
                mLOCK(); 

                }
                break;
            case 39 :
                // /home/macan/Private/pl2py/PLSQL.g:1:248: NOT
                {
                mNOT(); 

                }
                break;
            case 40 :
                // /home/macan/Private/pl2py/PLSQL.g:1:252: NOTFOUND
                {
                mNOTFOUND(); 

                }
                break;
            case 41 :
                // /home/macan/Private/pl2py/PLSQL.g:1:261: NULL
                {
                mNULL(); 

                }
                break;
            case 42 :
                // /home/macan/Private/pl2py/PLSQL.g:1:266: OPEN
                {
                mOPEN(); 

                }
                break;
            case 43 :
                // /home/macan/Private/pl2py/PLSQL.g:1:271: OR
                {
                mOR(); 

                }
                break;
            case 44 :
                // /home/macan/Private/pl2py/PLSQL.g:1:274: PACKAGE
                {
                mPACKAGE(); 

                }
                break;
            case 45 :
                // /home/macan/Private/pl2py/PLSQL.g:1:282: RAISE
                {
                mRAISE(); 

                }
                break;
            case 46 :
                // /home/macan/Private/pl2py/PLSQL.g:1:288: ROLLBACK
                {
                mROLLBACK(); 

                }
                break;
            case 47 :
                // /home/macan/Private/pl2py/PLSQL.g:1:297: SAVEPOINT
                {
                mSAVEPOINT(); 

                }
                break;
            case 48 :
                // /home/macan/Private/pl2py/PLSQL.g:1:307: SELECT
                {
                mSELECT(); 

                }
                break;
            case 49 :
                // /home/macan/Private/pl2py/PLSQL.g:1:314: SET
                {
                mSET(); 

                }
                break;
            case 50 :
                // /home/macan/Private/pl2py/PLSQL.g:1:318: SQL
                {
                mSQL(); 

                }
                break;
            case 51 :
                // /home/macan/Private/pl2py/PLSQL.g:1:322: TABLE
                {
                mTABLE(); 

                }
                break;
            case 52 :
                // /home/macan/Private/pl2py/PLSQL.g:1:328: TRANSACTION
                {
                mTRANSACTION(); 

                }
                break;
            case 53 :
                // /home/macan/Private/pl2py/PLSQL.g:1:340: TRUE
                {
                mTRUE(); 

                }
                break;
            case 54 :
                // /home/macan/Private/pl2py/PLSQL.g:1:345: THEN
                {
                mTHEN(); 

                }
                break;
            case 55 :
                // /home/macan/Private/pl2py/PLSQL.g:1:350: UPDATE
                {
                mUPDATE(); 

                }
                break;
            case 56 :
                // /home/macan/Private/pl2py/PLSQL.g:1:357: WHILE
                {
                mWHILE(); 

                }
                break;
            case 57 :
                // /home/macan/Private/pl2py/PLSQL.g:1:363: INSERTING
                {
                mINSERTING(); 

                }
                break;
            case 58 :
                // /home/macan/Private/pl2py/PLSQL.g:1:373: UPDATING
                {
                mUPDATING(); 

                }
                break;
            case 59 :
                // /home/macan/Private/pl2py/PLSQL.g:1:382: DELETING
                {
                mDELETING(); 

                }
                break;
            case 60 :
                // /home/macan/Private/pl2py/PLSQL.g:1:391: ISOPEN
                {
                mISOPEN(); 

                }
                break;
            case 61 :
                // /home/macan/Private/pl2py/PLSQL.g:1:398: EXISTS
                {
                mEXISTS(); 

                }
                break;
            case 62 :
                // /home/macan/Private/pl2py/PLSQL.g:1:405: BEGIN
                {
                mBEGIN(); 

                }
                break;
            case 63 :
                // /home/macan/Private/pl2py/PLSQL.g:1:411: CLOSE
                {
                mCLOSE(); 

                }
                break;
            case 64 :
                // /home/macan/Private/pl2py/PLSQL.g:1:417: CONSTANT
                {
                mCONSTANT(); 

                }
                break;
            case 65 :
                // /home/macan/Private/pl2py/PLSQL.g:1:426: CONTINUE
                {
                mCONTINUE(); 

                }
                break;
            case 66 :
                // /home/macan/Private/pl2py/PLSQL.g:1:435: CURSOR
                {
                mCURSOR(); 

                }
                break;
            case 67 :
                // /home/macan/Private/pl2py/PLSQL.g:1:442: DECLARE
                {
                mDECLARE(); 

                }
                break;
            case 68 :
                // /home/macan/Private/pl2py/PLSQL.g:1:450: DETERMINISTIC
                {
                mDETERMINISTIC(); 

                }
                break;
            case 69 :
                // /home/macan/Private/pl2py/PLSQL.g:1:464: END
                {
                mEND(); 

                }
                break;
            case 70 :
                // /home/macan/Private/pl2py/PLSQL.g:1:468: EXCEPTION
                {
                mEXCEPTION(); 

                }
                break;
            case 71 :
                // /home/macan/Private/pl2py/PLSQL.g:1:478: EXECUTE
                {
                mEXECUTE(); 

                }
                break;
            case 72 :
                // /home/macan/Private/pl2py/PLSQL.g:1:486: EXIT
                {
                mEXIT(); 

                }
                break;
            case 73 :
                // /home/macan/Private/pl2py/PLSQL.g:1:491: FUNCTION
                {
                mFUNCTION(); 

                }
                break;
            case 74 :
                // /home/macan/Private/pl2py/PLSQL.g:1:500: IMMEDIATE
                {
                mIMMEDIATE(); 

                }
                break;
            case 75 :
                // /home/macan/Private/pl2py/PLSQL.g:1:510: LOOP
                {
                mLOOP(); 

                }
                break;
            case 76 :
                // /home/macan/Private/pl2py/PLSQL.g:1:515: MERGE
                {
                mMERGE(); 

                }
                break;
            case 77 :
                // /home/macan/Private/pl2py/PLSQL.g:1:521: NOCOPY
                {
                mNOCOPY(); 

                }
                break;
            case 78 :
                // /home/macan/Private/pl2py/PLSQL.g:1:528: OTHERS
                {
                mOTHERS(); 

                }
                break;
            case 79 :
                // /home/macan/Private/pl2py/PLSQL.g:1:535: OUT
                {
                mOUT(); 

                }
                break;
            case 80 :
                // /home/macan/Private/pl2py/PLSQL.g:1:539: PARALLEL_ENABLE
                {
                mPARALLEL_ENABLE(); 

                }
                break;
            case 81 :
                // /home/macan/Private/pl2py/PLSQL.g:1:555: PIPELINED
                {
                mPIPELINED(); 

                }
                break;
            case 82 :
                // /home/macan/Private/pl2py/PLSQL.g:1:565: PRAGMA
                {
                mPRAGMA(); 

                }
                break;
            case 83 :
                // /home/macan/Private/pl2py/PLSQL.g:1:572: PROCEDURE
                {
                mPROCEDURE(); 

                }
                break;
            case 84 :
                // /home/macan/Private/pl2py/PLSQL.g:1:582: RECORD
                {
                mRECORD(); 

                }
                break;
            case 85 :
                // /home/macan/Private/pl2py/PLSQL.g:1:589: REF
                {
                mREF(); 

                }
                break;
            case 86 :
                // /home/macan/Private/pl2py/PLSQL.g:1:593: RESULT_CACHE
                {
                mRESULT_CACHE(); 

                }
                break;
            case 87 :
                // /home/macan/Private/pl2py/PLSQL.g:1:606: RETURN
                {
                mRETURN(); 

                }
                break;
            case 88 :
                // /home/macan/Private/pl2py/PLSQL.g:1:613: RETURNING
                {
                mRETURNING(); 

                }
                break;
            case 89 :
                // /home/macan/Private/pl2py/PLSQL.g:1:623: ROWTYPE
                {
                mROWTYPE(); 

                }
                break;
            case 90 :
                // /home/macan/Private/pl2py/PLSQL.g:1:631: SUBTYPE
                {
                mSUBTYPE(); 

                }
                break;
            case 91 :
                // /home/macan/Private/pl2py/PLSQL.g:1:639: USING
                {
                mUSING(); 

                }
                break;
            case 92 :
                // /home/macan/Private/pl2py/PLSQL.g:1:645: VARRAY
                {
                mVARRAY(); 

                }
                break;
            case 93 :
                // /home/macan/Private/pl2py/PLSQL.g:1:652: VARYING
                {
                mVARYING(); 

                }
                break;
            case 94 :
                // /home/macan/Private/pl2py/PLSQL.g:1:660: WHEN
                {
                mWHEN(); 

                }
                break;
            case 95 :
                // /home/macan/Private/pl2py/PLSQL.g:1:665: QUOTED_STRING
                {
                mQUOTED_STRING(); 

                }
                break;
            case 96 :
                // /home/macan/Private/pl2py/PLSQL.g:1:679: ID
                {
                mID(); 

                }
                break;
            case 97 :
                // /home/macan/Private/pl2py/PLSQL.g:1:682: SEMI
                {
                mSEMI(); 

                }
                break;
            case 98 :
                // /home/macan/Private/pl2py/PLSQL.g:1:687: COLON
                {
                mCOLON(); 

                }
                break;
            case 99 :
                // /home/macan/Private/pl2py/PLSQL.g:1:693: DOUBLEDOT
                {
                mDOUBLEDOT(); 

                }
                break;
            case 100 :
                // /home/macan/Private/pl2py/PLSQL.g:1:703: DOT
                {
                mDOT(); 

                }
                break;
            case 101 :
                // /home/macan/Private/pl2py/PLSQL.g:1:707: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 102 :
                // /home/macan/Private/pl2py/PLSQL.g:1:713: EXPONENT
                {
                mEXPONENT(); 

                }
                break;
            case 103 :
                // /home/macan/Private/pl2py/PLSQL.g:1:722: ASTERISK
                {
                mASTERISK(); 

                }
                break;
            case 104 :
                // /home/macan/Private/pl2py/PLSQL.g:1:731: AT_SIGN
                {
                mAT_SIGN(); 

                }
                break;
            case 105 :
                // /home/macan/Private/pl2py/PLSQL.g:1:739: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 106 :
                // /home/macan/Private/pl2py/PLSQL.g:1:746: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 107 :
                // /home/macan/Private/pl2py/PLSQL.g:1:753: RBRACK
                {
                mRBRACK(); 

                }
                break;
            case 108 :
                // /home/macan/Private/pl2py/PLSQL.g:1:760: LBRACK
                {
                mLBRACK(); 

                }
                break;
            case 109 :
                // /home/macan/Private/pl2py/PLSQL.g:1:767: PLUS
                {
                mPLUS(); 

                }
                break;
            case 110 :
                // /home/macan/Private/pl2py/PLSQL.g:1:772: MINUS
                {
                mMINUS(); 

                }
                break;
            case 111 :
                // /home/macan/Private/pl2py/PLSQL.g:1:778: DIVIDE
                {
                mDIVIDE(); 

                }
                break;
            case 112 :
                // /home/macan/Private/pl2py/PLSQL.g:1:785: EQ
                {
                mEQ(); 

                }
                break;
            case 113 :
                // /home/macan/Private/pl2py/PLSQL.g:1:788: PERCENT
                {
                mPERCENT(); 

                }
                break;
            case 114 :
                // /home/macan/Private/pl2py/PLSQL.g:1:796: LLABEL
                {
                mLLABEL(); 

                }
                break;
            case 115 :
                // /home/macan/Private/pl2py/PLSQL.g:1:803: RLABEL
                {
                mRLABEL(); 

                }
                break;
            case 116 :
                // /home/macan/Private/pl2py/PLSQL.g:1:810: ASSIGN
                {
                mASSIGN(); 

                }
                break;
            case 117 :
                // /home/macan/Private/pl2py/PLSQL.g:1:817: ARROW
                {
                mARROW(); 

                }
                break;
            case 118 :
                // /home/macan/Private/pl2py/PLSQL.g:1:823: VERTBAR
                {
                mVERTBAR(); 

                }
                break;
            case 119 :
                // /home/macan/Private/pl2py/PLSQL.g:1:831: DOUBLEVERTBAR
                {
                mDOUBLEVERTBAR(); 

                }
                break;
            case 120 :
                // /home/macan/Private/pl2py/PLSQL.g:1:845: NOT_EQ
                {
                mNOT_EQ(); 

                }
                break;
            case 121 :
                // /home/macan/Private/pl2py/PLSQL.g:1:852: LTH
                {
                mLTH(); 

                }
                break;
            case 122 :
                // /home/macan/Private/pl2py/PLSQL.g:1:856: LEQ
                {
                mLEQ(); 

                }
                break;
            case 123 :
                // /home/macan/Private/pl2py/PLSQL.g:1:860: GTH
                {
                mGTH(); 

                }
                break;
            case 124 :
                // /home/macan/Private/pl2py/PLSQL.g:1:864: GEQ
                {
                mGEQ(); 

                }
                break;
            case 125 :
                // /home/macan/Private/pl2py/PLSQL.g:1:868: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 126 :
                // /home/macan/Private/pl2py/PLSQL.g:1:876: REAL_NUMBER
                {
                mREAL_NUMBER(); 

                }
                break;
            case 127 :
                // /home/macan/Private/pl2py/PLSQL.g:1:888: WS
                {
                mWS(); 

                }
                break;
            case 128 :
                // /home/macan/Private/pl2py/PLSQL.g:1:891: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 129 :
                // /home/macan/Private/pl2py/PLSQL.g:1:902: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 130 :
                // /home/macan/Private/pl2py/PLSQL.g:1:913: SPOOL
                {
                mSPOOL(); 

                }
                break;
            case 131 :
                // /home/macan/Private/pl2py/PLSQL.g:1:919: PROMPT
                {
                mPROMPT(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA10_eotS =
        "\1\uffff\1\4\1\uffff\1\4\2\uffff";
    static final String DFA10_eofS =
        "\6\uffff";
    static final String DFA10_minS =
        "\2\56\1\uffff\1\56\2\uffff";
    static final String DFA10_maxS =
        "\2\71\1\uffff\1\71\2\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\uffff\1\3\1\1";
    static final String DFA10_specialS =
        "\1\uffff\1\0\1\uffff\1\1\2\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\5\1\uffff\12\3",
            "",
            "\1\5\1\uffff\12\3",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "3155:1: fragment NUMBER_VALUE : ({...}? => N POINT ( N )? | POINT N | N );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_1 = input.LA(1);

                         
                        int index10_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA10_1>='0' && LA10_1<='9')) ) {s = 3;}

                        else if ( (LA10_1=='.') && ((numberDotValid()))) {s = 5;}

                        else s = 4;

                         
                        input.seek(index10_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA10_3 = input.LA(1);

                         
                        int index10_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA10_3>='0' && LA10_3<='9')) ) {s = 3;}

                        else if ( (LA10_3=='.') && ((numberDotValid()))) {s = 5;}

                        else s = 4;

                         
                        input.seek(index10_3);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA21_eotS =
        "\1\uffff\23\25\3\uffff\1\143\1\144\1\uffff\1\150\6\uffff\1\152\1"+
        "\154\1\156\1\uffff\1\161\1\164\1\166\1\uffff\1\170\1\uffff\11\25"+
        "\1\u0088\4\25\1\u008e\13\25\1\u00a2\1\u00a6\1\u00a8\7\25\1\u00b3"+
        "\22\25\25\uffff\1\170\2\uffff\1\25\1\u00ce\7\25\1\u00d7\2\25\1\u00da"+
        "\1\25\1\uffff\5\25\1\uffff\21\25\1\u00f7\1\25\1\uffff\3\25\1\uffff"+
        "\1\25\1\uffff\6\25\1\u0104\3\25\1\uffff\1\25\1\u0109\7\25\1\u0112"+
        "\1\u0113\14\25\1\uffff\2\25\1\uffff\10\25\1\uffff\2\25\1\uffff\4"+
        "\25\1\u0131\1\u0133\1\u0134\16\25\1\u0143\3\25\1\u0147\2\25\1\uffff"+
        "\1\u014a\2\25\1\u014d\3\25\1\u0151\1\25\1\u0153\1\u0154\1\25\1\uffff"+
        "\1\25\1\u0157\1\u0158\1\25\1\uffff\10\25\2\uffff\4\25\1\u0166\1"+
        "\u0167\3\25\1\u016b\3\25\1\u016f\1\25\1\u0171\1\u0172\4\25\1\u0177"+
        "\3\25\1\u017b\2\25\1\u017e\1\uffff\1\25\2\uffff\7\25\1\u0187\6\25"+
        "\1\uffff\1\u018f\2\25\1\uffff\2\25\1\uffff\1\u0194\1\25\1\uffff"+
        "\3\25\1\uffff\1\u0199\2\uffff\2\25\2\uffff\13\25\1\u01a8\1\25\2"+
        "\uffff\1\25\1\u01ac\1\u01ad\1\uffff\1\u01ae\2\25\1\uffff\1\u01b1"+
        "\2\uffff\4\25\1\uffff\1\u01b6\1\25\1\u01b9\1\uffff\1\u01ba\1\25"+
        "\1\uffff\1\25\1\u01bd\1\25\1\u01bf\3\25\1\u01c3\1\uffff\3\25\1\u01c7"+
        "\3\25\1\uffff\1\25\1\u01cc\2\25\1\uffff\1\u01d0\1\u01d1\2\25\1\uffff"+
        "\1\25\1\u01d5\1\u01d6\3\25\1\u01da\3\25\1\u01df\2\25\2\uffff\1\25"+
        "\1\u01e2\1\25\3\uffff\1\u01e4\1\25\1\uffff\2\25\1\u01e8\1\25\1\uffff"+
        "\2\25\2\uffff\1\u01ec\1\25\1\uffff\1\u01ee\1\uffff\3\25\1\uffff"+
        "\1\25\1\u01f3\1\u01f4\1\uffff\1\25\1\u01f6\2\25\1\uffff\1\25\1\u01fa"+
        "\1\25\2\uffff\3\25\2\uffff\1\u01ff\2\25\1\uffff\2\25\1\uffff\1\25"+
        "\1\uffff\1\u0204\1\25\1\uffff\1\25\1\uffff\1\u0207\1\u0208\1\u0209"+
        "\1\uffff\1\u020a\2\25\1\uffff\1\25\1\uffff\1\u020e\1\u020f\1\25"+
        "\1\u0211\2\uffff\1\u0212\1\uffff\1\25\1\u0214\1\25\1\uffff\2\25"+
        "\1\u0218\1\u0219\1\uffff\4\25\1\uffff\1\25\1\u021f\4\uffff\1\25"+
        "\1\u0221\1\25\2\uffff\1\25\2\uffff\1\25\1\uffff\1\u0225\1\u0226"+
        "\1\u0227\2\uffff\1\25\1\u0229\1\u022a\1\u022b\1\25\1\uffff\1\25"+
        "\1\uffff\3\25\3\uffff\1\25\3\uffff\6\25\1\u0238\1\u0239\1\25\1\u023b"+
        "\2\25\2\uffff\1\u023e\1\uffff\1\u023f\1\25\2\uffff\1\25\1\u0242"+
        "\1\uffff";
    static final String DFA21_eofS =
        "\u0243\uffff";
    static final String DFA21_minS =
        "\1\11\2\141\1\156\1\145\1\141\1\142\1\154\1\157\1\146\1\141\1\47"+
        "\1\160\3\141\1\160\1\150\1\145\1\141\3\uffff\1\75\1\56\1\uffff\1"+
        "\52\6\uffff\1\55\1\52\1\76\1\uffff\1\74\1\75\1\174\1\uffff\1\56"+
        "\1\uffff\1\162\1\154\1\164\1\156\1\154\1\151\1\143\1\144\1\162\1"+
        "\43\1\164\1\147\1\144\1\154\1\43\1\163\1\145\1\154\1\162\1\157\1"+
        "\155\1\143\1\163\1\143\1\144\1\164\3\43\1\155\1\156\1\153\2\143"+
        "\1\154\1\145\1\43\1\150\1\164\1\143\1\160\1\141\1\166\2\154\1\142"+
        "\1\157\1\142\1\141\1\145\1\144\1\151\1\145\2\162\25\uffff\1\56\2"+
        "\uffff\1\156\1\43\1\163\3\143\1\154\1\163\1\157\1\43\2\165\1\43"+
        "\1\141\1\uffff\1\150\1\167\1\151\1\171\1\153\1\uffff\1\145\1\141"+
        "\1\154\1\155\1\163\1\162\2\163\1\141\1\145\1\154\3\145\1\163\1\145"+
        "\1\143\1\43\1\157\1\uffff\2\145\1\157\1\uffff\1\160\1\uffff\1\145"+
        "\1\147\1\145\1\151\1\153\1\160\1\43\1\157\1\154\1\156\1\uffff\1"+
        "\145\1\43\1\153\1\141\1\145\1\147\1\143\2\145\2\43\1\164\1\157\1"+
        "\154\1\156\1\145\1\156\1\141\1\156\1\154\1\156\1\147\1\162\1\uffff"+
        "\1\144\1\154\1\uffff\1\145\1\150\1\164\1\157\1\171\1\142\1\145\1"+
        "\162\1\uffff\1\154\1\162\1\uffff\1\171\1\151\1\145\1\156\3\43\1"+
        "\164\1\145\1\151\1\164\1\151\1\145\1\157\1\145\1\137\1\165\1\156"+
        "\1\164\1\141\1\162\1\43\1\146\1\162\1\164\1\43\1\160\1\165\1\uffff"+
        "\1\43\1\170\1\162\1\43\1\145\1\144\1\165\1\43\1\164\2\43\1\157\1"+
        "\uffff\1\160\2\43\1\162\1\uffff\1\141\2\154\1\155\1\145\2\160\1"+
        "\143\2\uffff\1\171\1\154\1\145\1\163\2\43\1\164\1\147\1\145\1\43"+
        "\1\145\1\141\1\151\1\43\1\154\2\43\1\151\1\165\1\160\1\141\1\43"+
        "\1\144\1\164\1\156\1\43\1\144\1\145\1\43\1\uffff\1\162\2\uffff\1"+
        "\145\1\143\1\164\1\141\2\156\1\162\1\43\1\163\1\154\2\145\1\162"+
        "\1\155\1\uffff\1\43\1\156\1\163\1\uffff\2\164\1\uffff\1\43\1\164"+
        "\1\uffff\1\156\1\151\1\141\1\uffff\1\43\2\uffff\1\165\1\171\2\uffff"+
        "\1\163\1\147\1\154\1\151\1\141\1\144\1\164\1\157\1\164\1\160\1\0"+
        "\1\43\1\141\2\uffff\1\145\2\43\1\uffff\1\43\1\171\1\156\1\uffff"+
        "\1\43\2\uffff\1\157\1\156\1\145\1\143\1\uffff\1\43\1\137\1\43\1"+
        "\uffff\1\43\1\156\1\uffff\1\157\1\43\1\164\1\43\1\156\1\165\1\164"+
        "\1\43\1\uffff\1\161\1\164\1\162\1\43\1\156\1\145\1\151\1\uffff\1"+
        "\141\1\43\1\151\1\145\1\uffff\2\43\1\141\1\147\1\uffff\1\156\2\43"+
        "\2\145\1\156\1\43\1\165\1\0\1\151\1\43\1\145\1\0\2\uffff\1\143\1"+
        "\43\1\156\3\uffff\1\43\1\147\1\uffff\1\156\1\164\1\43\1\153\1\uffff"+
        "\1\143\1\156\2\uffff\1\43\1\167\1\uffff\1\43\1\uffff\1\164\1\145"+
        "\1\137\1\uffff\1\154\2\43\1\uffff\1\147\1\43\1\156\1\154\1\uffff"+
        "\1\157\1\43\1\156\2\uffff\1\164\1\145\1\144\2\uffff\1\43\1\154\1"+
        "\145\1\uffff\1\162\1\0\1\uffff\1\156\1\uffff\1\43\1\164\1\uffff"+
        "\1\147\1\uffff\3\43\1\uffff\1\43\1\141\1\147\1\uffff\1\143\1\uffff"+
        "\2\43\1\165\1\43\2\uffff\1\43\1\uffff\1\151\1\43\1\156\1\uffff\1"+
        "\147\1\145\2\43\1\uffff\1\137\1\144\1\145\1\164\1\uffff\1\151\1"+
        "\43\4\uffff\1\143\1\43\1\157\2\uffff\1\163\2\uffff\1\163\1\uffff"+
        "\3\43\2\uffff\1\145\3\43\1\157\1\uffff\1\150\1\uffff\1\165\1\145"+
        "\1\164\3\uffff\1\156\3\uffff\1\156\1\145\1\156\1\162\1\151\1\141"+
        "\2\43\1\164\1\43\1\143\1\142\2\uffff\1\43\1\uffff\1\43\1\154\2\uffff"+
        "\1\145\1\43\1\uffff";
    static final String DFA21_maxS =
        "\1\uff0c\1\165\1\157\1\165\1\171\1\165\1\145\1\170\1\157\1\163\1"+
        "\157\2\165\1\162\1\165\1\162\1\163\1\150\1\145\1\141\3\uffff\1\75"+
        "\1\71\1\uffff\1\52\6\uffff\1\55\1\52\1\76\1\uffff\2\76\1\174\1\uffff"+
        "\1\145\1\uffff\1\165\1\154\1\164\1\156\1\167\1\151\1\164\1\144\1"+
        "\162\1\172\2\164\1\144\1\154\1\172\1\163\1\145\1\156\1\162\1\157"+
        "\1\155\1\164\1\163\1\164\1\144\1\164\3\172\1\155\1\156\1\155\1\157"+
        "\1\164\1\154\1\145\1\172\1\150\1\164\1\162\1\160\1\157\1\166\1\164"+
        "\1\154\1\142\1\157\1\142\1\165\1\145\1\144\2\151\2\162\25\uffff"+
        "\1\145\2\uffff\1\156\1\172\1\163\2\143\1\164\1\154\1\163\1\157\1"+
        "\172\2\165\1\172\1\141\1\uffff\1\150\1\167\1\151\1\171\1\153\1\uffff"+
        "\1\145\1\141\1\154\1\155\1\164\3\163\1\151\1\145\1\154\1\145\1\151"+
        "\1\145\1\164\1\145\1\143\1\172\1\157\1\uffff\2\145\1\157\1\uffff"+
        "\1\160\1\uffff\1\145\1\147\1\145\1\151\1\153\1\160\1\172\1\157\1"+
        "\154\1\156\1\uffff\1\145\1\172\1\153\1\141\1\145\1\147\1\155\2\145"+
        "\2\172\1\164\1\157\1\154\1\156\1\145\1\156\1\141\1\156\1\154\1\156"+
        "\1\147\1\171\1\uffff\1\144\1\154\1\uffff\1\145\1\150\1\164\1\157"+
        "\1\171\1\142\1\145\1\162\1\uffff\1\154\1\162\1\uffff\1\171\1\151"+
        "\1\145\1\156\3\172\1\164\1\145\1\151\1\164\1\151\1\145\1\157\1\145"+
        "\1\137\1\165\1\156\1\164\1\141\1\162\1\172\1\146\1\162\1\164\1\172"+
        "\1\160\1\165\1\uffff\1\172\1\170\1\162\1\172\1\145\1\144\1\165\1"+
        "\172\1\164\2\172\1\157\1\uffff\1\160\2\172\1\162\1\uffff\1\141\2"+
        "\154\1\155\1\145\2\160\1\143\2\uffff\1\171\1\154\1\145\1\163\2\172"+
        "\1\164\1\147\1\145\1\172\1\145\1\141\1\151\1\172\1\154\2\172\1\151"+
        "\1\165\1\160\1\141\1\172\1\144\1\164\1\156\1\172\1\144\1\145\1\172"+
        "\1\uffff\1\162\2\uffff\1\145\1\143\1\164\1\141\2\156\1\162\1\172"+
        "\1\163\1\154\1\145\1\151\1\162\1\155\1\uffff\1\172\1\156\1\163\1"+
        "\uffff\2\164\1\uffff\1\172\1\164\1\uffff\1\156\1\151\1\141\1\uffff"+
        "\1\172\2\uffff\1\165\1\171\2\uffff\1\163\1\147\1\154\1\151\1\141"+
        "\1\144\1\164\1\157\1\164\1\160\1\uffff\1\172\1\141\2\uffff\1\151"+
        "\2\172\1\uffff\1\172\1\171\1\156\1\uffff\1\172\2\uffff\1\157\1\156"+
        "\1\145\1\143\1\uffff\1\172\1\137\1\172\1\uffff\1\172\1\156\1\uffff"+
        "\1\157\1\172\1\164\1\172\1\156\1\165\1\164\1\172\1\uffff\1\161\1"+
        "\164\1\162\1\172\1\156\1\145\1\151\1\uffff\1\141\1\172\1\151\1\145"+
        "\1\uffff\2\172\1\141\1\147\1\uffff\1\156\2\172\2\145\1\156\1\172"+
        "\1\165\1\uffff\1\151\1\172\1\145\1\uffff\2\uffff\1\143\1\172\1\156"+
        "\3\uffff\1\172\1\147\1\uffff\1\156\1\164\1\172\1\153\1\uffff\1\143"+
        "\1\156\2\uffff\1\172\1\167\1\uffff\1\172\1\uffff\1\164\1\145\1\137"+
        "\1\uffff\1\154\2\172\1\uffff\1\147\1\172\1\156\1\154\1\uffff\1\157"+
        "\1\172\1\156\2\uffff\1\164\1\145\1\144\2\uffff\1\172\1\154\1\145"+
        "\1\uffff\1\162\1\uffff\1\uffff\1\156\1\uffff\1\172\1\164\1\uffff"+
        "\1\147\1\uffff\3\172\1\uffff\1\172\1\141\1\147\1\uffff\1\143\1\uffff"+
        "\2\172\1\165\1\172\2\uffff\1\172\1\uffff\1\151\1\172\1\156\1\uffff"+
        "\1\147\1\145\2\172\1\uffff\1\137\1\144\1\145\1\164\1\uffff\1\151"+
        "\1\172\4\uffff\1\143\1\172\1\157\2\uffff\1\163\2\uffff\1\163\1\uffff"+
        "\3\172\2\uffff\1\145\3\172\1\157\1\uffff\1\150\1\uffff\1\165\1\145"+
        "\1\164\3\uffff\1\156\3\uffff\1\156\1\145\1\156\1\162\1\151\1\141"+
        "\2\172\1\164\1\172\1\143\1\142\2\uffff\1\172\1\uffff\1\172\1\154"+
        "\2\uffff\1\145\1\172\1\uffff";
    static final String DFA21_acceptS =
        "\24\uffff\1\137\1\140\1\141\2\uffff\1\145\1\uffff\1\150\1\151\1"+
        "\152\1\153\1\154\1\155\3\uffff\1\161\3\uffff\1\170\1\uffff\1\177"+
        "\67\uffff\1\164\1\142\1\144\1\176\1\143\1\146\1\147\1\u0080\1\156"+
        "\1\u0081\1\157\1\165\1\160\1\162\1\172\1\171\1\163\1\174\1\173\1"+
        "\167\1\166\1\uffff\1\175\1\176\16\uffff\1\5\5\uffff\1\13\23\uffff"+
        "\1\35\3\uffff\1\36\1\uffff\1\42\12\uffff\1\53\27\uffff\1\176\2\uffff"+
        "\1\32\10\uffff\1\125\2\uffff\1\3\34\uffff\1\105\14\uffff\1\47\4"+
        "\uffff\1\117\10\uffff\1\61\1\62\35\uffff\1\10\1\uffff\1\11\1\14"+
        "\16\uffff\1\25\3\uffff\1\110\2\uffff\1\34\2\uffff\1\41\3\uffff\1"+
        "\44\1\uffff\1\46\1\113\2\uffff\1\51\1\52\15\uffff\1\65\1\66\3\uffff"+
        "\1\136\3\uffff\1\1\1\uffff\1\30\1\31\4\uffff\1\55\3\uffff\1\4\2"+
        "\uffff\1\76\10\uffff\1\77\7\uffff\1\26\4\uffff\1\37\4\uffff\1\45"+
        "\15\uffff\1\u0082\1\63\3\uffff\1\133\1\70\1\114\2\uffff\1\33\4\uffff"+
        "\1\124\2\uffff\1\127\1\6\2\uffff\1\15\1\uffff\1\17\3\uffff\1\102"+
        "\3\uffff\1\24\4\uffff\1\75\3\uffff\1\40\1\74\3\uffff\1\115\1\116"+
        "\3\uffff\1\122\2\uffff\1\u0083\1\uffff\1\60\2\uffff\1\67\1\uffff"+
        "\1\134\3\uffff\1\131\3\uffff\1\7\1\uffff\1\16\4\uffff\1\22\1\23"+
        "\1\uffff\1\103\3\uffff\1\107\4\uffff\1\54\4\uffff\1\132\2\uffff"+
        "\1\135\1\111\1\2\1\56\3\uffff\1\100\1\101\1\uffff\1\21\1\73\1\uffff"+
        "\1\27\3\uffff\1\43\1\50\5\uffff\1\72\1\uffff\1\130\3\uffff\1\106"+
        "\1\71\1\112\1\uffff\1\121\1\123\1\57\14\uffff\1\64\1\126\1\uffff"+
        "\1\20\2\uffff\1\12\1\104\2\uffff\1\120";
    static final String DFA21_specialS =
        "\51\uffff\1\1\115\uffff\1\5\u00eb\uffff\1\4\76\uffff\1\3\3\uffff"+
        "\1\2\65\uffff\1\0\146\uffff}>";
    static final String[] DFA21_transitionS = {
            "\2\52\2\uffff\1\52\22\uffff\1\52\1\50\1\25\2\uffff\1\44\1\uffff"+
            "\1\24\1\35\1\34\1\32\1\40\1\31\1\41\1\30\1\42\12\51\1\27\1\26"+
            "\1\45\1\43\1\46\1\uffff\1\33\32\uffff\1\37\1\uffff\1\36\1\50"+
            "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\1\1\10\1\25\1\11\2\25\1\12\1"+
            "\22\1\13\1\14\1\15\1\25\1\2\1\16\1\17\1\20\1\23\1\21\3\25\1"+
            "\uffff\1\47\1\uffff\1\50\u2f81\uffff\1\52\u1dff\uffff\u51a6"+
            "\25\u10fb\uffff\u475e\25\u0101\uffff\u012e\25\u04da\uffff\1"+
            "\35\1\34\2\uffff\1\31",
            "\1\54\3\uffff\1\55\11\uffff\1\53\5\uffff\1\56",
            "\1\60\3\uffff\1\61\11\uffff\1\57",
            "\1\62\3\uffff\1\63\1\64\1\uffff\1\65",
            "\1\66\11\uffff\1\67\5\uffff\1\70\3\uffff\1\71",
            "\1\72\12\uffff\1\76\2\uffff\1\74\2\uffff\1\73\2\uffff\1\75",
            "\1\77\2\uffff\1\100",
            "\1\101\1\uffff\1\103\11\uffff\1\102",
            "\1\104",
            "\1\105\6\uffff\1\110\1\106\4\uffff\1\107",
            "\1\111\7\uffff\1\112\5\uffff\1\113",
            "\1\24\107\uffff\1\114\5\uffff\1\115",
            "\1\116\1\uffff\1\117\1\uffff\1\120\1\121",
            "\1\122\7\uffff\1\123\10\uffff\1\124",
            "\1\125\3\uffff\1\126\12\uffff\1\131\1\127\3\uffff\1\130",
            "\1\132\6\uffff\1\134\11\uffff\1\133",
            "\1\135\2\uffff\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "",
            "",
            "",
            "\1\142",
            "\1\146\1\uffff\12\145",
            "",
            "\1\147",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\151",
            "\1\153",
            "\1\155",
            "",
            "\1\157\1\160\1\50",
            "\1\163\1\162",
            "\1\165",
            "",
            "\1\171\1\uffff\12\167\53\uffff\1\145",
            "",
            "\1\173\2\uffff\1\172",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\u0080\12\uffff\1\177",
            "\1\u0081",
            "\1\u0082\2\uffff\1\u0083\14\uffff\1\u0084\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0089",
            "\1\u008b\14\uffff\1\u008a",
            "\1\u008c",
            "\1\u008d",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091\1\u0092\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0099\2\uffff\1\u0097\5\uffff\1\u0098\7\uffff\1\u009a",
            "\1\u009b",
            "\1\u009e\1\uffff\1\u009f\3\uffff\1\u009d\12\uffff\1\u009c",
            "\1\u00a0",
            "\1\u00a1",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\3\25\1\u00a3\16"+
            "\25\1\u00a4\1\u00a5\6\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\16\25\1\u00a7\13"+
            "\25",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab\1\uffff\1\u00ac",
            "\1\u00ad\13\uffff\1\u00ae",
            "\1\u00b0\20\uffff\1\u00af",
            "\1\u00b1",
            "\1\u00b2",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6\16\uffff\1\u00b7",
            "\1\u00b8",
            "\1\u00b9\15\uffff\1\u00ba",
            "\1\u00bb",
            "\1\u00bc\7\uffff\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2\23\uffff\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c8\3\uffff\1\u00c7",
            "\1\u00c9",
            "\1\u00ca",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\171\1\uffff\12\167\53\uffff\1\u00cb",
            "",
            "",
            "\1\u00cc",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\1\u00cd\31\25",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2\20\uffff\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u00d8",
            "\1\u00d9",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u00db",
            "",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5\1\u00e6",
            "\1\u00e7\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb\7\uffff\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0\3\uffff\1\u00f1",
            "\1\u00f2",
            "\1\u00f3\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u00f8",
            "",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "",
            "\1\u00fc",
            "",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\5\25\1\u0103\24"+
            "\25",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "",
            "\1\u0108",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e\11\uffff\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f\6\uffff\1\u0120",
            "",
            "\1\u0121",
            "\1\u0122",
            "",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "",
            "\1\u012b",
            "\1\u012c",
            "",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\u0132\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0148",
            "\1\u0149",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u014b",
            "\1\u014c",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0152",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0155",
            "",
            "\1\u0156",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0159",
            "",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "",
            "",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0168",
            "\1\u0169",
            "\1\u016a",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0170",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0173",
            "\1\u0174",
            "\1\u0175",
            "\1\u0176",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0178",
            "\1\u0179",
            "\1\u017a",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u017c",
            "\1\u017d",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "",
            "\1\u017f",
            "",
            "",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "\1\u0185",
            "\1\u0186",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0188",
            "\1\u0189",
            "\1\u018a",
            "\1\u018b\3\uffff\1\u018c",
            "\1\u018d",
            "\1\u018e",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0190",
            "\1\u0191",
            "",
            "\1\u0192",
            "\1\u0193",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0195",
            "",
            "\1\u0196",
            "\1\u0197",
            "\1\u0198",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "",
            "",
            "\1\u019a",
            "\1\u019b",
            "",
            "",
            "\1\u019c",
            "\1\u019d",
            "\1\u019e",
            "\1\u019f",
            "\1\u01a0",
            "\1\u01a1",
            "\1\u01a2",
            "\1\u01a3",
            "\1\u01a4",
            "\1\u01a5",
            "\43\u01a7\2\u01a6\13\u01a7\12\u01a6\45\u01a7\1\u01a6\1\u01a7"+
            "\32\u01a6\uff85\u01a7",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01a9",
            "",
            "",
            "\1\u01aa\3\uffff\1\u01ab",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01af",
            "\1\u01b0",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "",
            "",
            "\1\u01b2",
            "\1\u01b3",
            "\1\u01b4",
            "\1\u01b5",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01b7",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\10\25\1\u01b8\21"+
            "\25",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01bb",
            "",
            "\1\u01bc",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01be",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01c0",
            "\1\u01c1",
            "\1\u01c2",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "",
            "\1\u01c4",
            "\1\u01c5",
            "\1\u01c6",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01c8",
            "\1\u01c9",
            "\1\u01ca",
            "",
            "\1\u01cb",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01cd",
            "\1\u01ce",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\10\25\1\u01cf\21"+
            "\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01d2",
            "\1\u01d3",
            "",
            "\1\u01d4",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01d7",
            "\1\u01d8",
            "\1\u01d9",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01db",
            "\43\u01dd\2\u01dc\13\u01dd\12\u01dc\45\u01dd\1\u01dc\1\u01dd"+
            "\32\u01dc\uff85\u01dd",
            "\1\u01de",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01e0",
            "\43\u01a7\2\u01a6\13\u01a7\12\u01a6\45\u01a7\1\u01a6\1\u01a7"+
            "\32\u01a6\uff85\u01a7",
            "",
            "",
            "\1\u01e1",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01e3",
            "",
            "",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01e5",
            "",
            "\1\u01e6",
            "\1\u01e7",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01e9",
            "",
            "\1\u01ea",
            "\1\u01eb",
            "",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01ed",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "",
            "\1\u01ef",
            "\1\u01f0",
            "\1\u01f1",
            "",
            "\1\u01f2",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "",
            "\1\u01f5",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01f7",
            "\1\u01f8",
            "",
            "\1\u01f9",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u01fb",
            "",
            "",
            "\1\u01fc",
            "\1\u01fd",
            "\1\u01fe",
            "",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0200",
            "\1\u0201",
            "",
            "\1\u0202",
            "\43\u01dd\2\u01dc\13\u01dd\12\u01dc\45\u01dd\1\u01dc\1\u01dd"+
            "\32\u01dc\uff85\u01dd",
            "",
            "\1\u0203",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0205",
            "",
            "\1\u0206",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u020b",
            "\1\u020c",
            "",
            "\1\u020d",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0210",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "",
            "\1\u0213",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0215",
            "",
            "\1\u0216",
            "\1\u0217",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "",
            "\1\u021a",
            "\1\u021b",
            "\1\u021c",
            "\1\u021d",
            "",
            "\1\u021e",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "",
            "",
            "",
            "",
            "\1\u0220",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0222",
            "",
            "",
            "\1\u0223",
            "",
            "",
            "\1\u0224",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "",
            "",
            "\1\u0228",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u022c",
            "",
            "\1\u022d",
            "",
            "\1\u022e",
            "\1\u022f",
            "\1\u0230",
            "",
            "",
            "",
            "\1\u0231",
            "",
            "",
            "",
            "\1\u0232",
            "\1\u0233",
            "\1\u0234",
            "\1\u0235",
            "\1\u0236",
            "\1\u0237",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u023a",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u023c",
            "\1\u023d",
            "",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            "\1\u0240",
            "",
            "",
            "\1\u0241",
            "\2\25\13\uffff\12\25\45\uffff\1\25\1\uffff\32\25",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( FOUND | ROWCOUNT | AND | ARRAY | AS | AUTHID | BETWEEN | BODY | BULK | BULK_ROWCOUNT | BY | CASE | CREATE | COLLECT | COMMIT | CURRENT_USER | DBMS | DEFAULT | DEFINER | DELETE | ELSE | ELSIF | EXTERNAL | FALSE | FETCH | FOR | FORALL | GOTO | IF | IN | INDEX | INSERT | INTO | IS | LANGUAGE | LIKE | LIMIT | LOCK | NOT | NOTFOUND | NULL | OPEN | OR | PACKAGE | RAISE | ROLLBACK | SAVEPOINT | SELECT | SET | SQL | TABLE | TRANSACTION | TRUE | THEN | UPDATE | WHILE | INSERTING | UPDATING | DELETING | ISOPEN | EXISTS | BEGIN | CLOSE | CONSTANT | CONTINUE | CURSOR | DECLARE | DETERMINISTIC | END | EXCEPTION | EXECUTE | EXIT | FUNCTION | IMMEDIATE | LOOP | MERGE | NOCOPY | OTHERS | OUT | PARALLEL_ENABLE | PIPELINED | PRAGMA | PROCEDURE | RECORD | REF | RESULT_CACHE | RETURN | RETURNING | ROWTYPE | SUBTYPE | USING | VARRAY | VARYING | WHEN | QUOTED_STRING | ID | SEMI | COLON | DOUBLEDOT | DOT | COMMA | EXPONENT | ASTERISK | AT_SIGN | RPAREN | LPAREN | RBRACK | LBRACK | PLUS | MINUS | DIVIDE | EQ | PERCENT | LLABEL | RLABEL | ASSIGN | ARROW | VERTBAR | DOUBLEVERTBAR | NOT_EQ | LTH | LEQ | GTH | GEQ | INTEGER | REAL_NUMBER | WS | SL_COMMENT | ML_COMMENT | SPOOL | PROMPT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_476 = input.LA(1);

                        s = -1;
                        if ( ((LA21_476>='#' && LA21_476<='$')||(LA21_476>='0' && LA21_476<='9')||LA21_476=='_'||(LA21_476>='a' && LA21_476<='z')) ) {s = 476;}

                        else if ( ((LA21_476>='\u0000' && LA21_476<='\"')||(LA21_476>='%' && LA21_476<='/')||(LA21_476>=':' && LA21_476<='^')||LA21_476=='`'||(LA21_476>='{' && LA21_476<='\uFFFF')) ) {s = 477;}

                        else s = 21;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_41 = input.LA(1);

                         
                        int index21_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_41>='0' && LA21_41<='9')) ) {s = 119;}

                        else if ( (LA21_41=='e') ) {s = 101;}

                        else if ( (LA21_41=='.') && ((numberDotValid()))) {s = 121;}

                        else s = 120;

                         
                        input.seek(index21_41);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_422 = input.LA(1);

                        s = -1;
                        if ( ((LA21_422>='\u0000' && LA21_422<='\"')||(LA21_422>='%' && LA21_422<='/')||(LA21_422>=':' && LA21_422<='^')||LA21_422=='`'||(LA21_422>='{' && LA21_422<='\uFFFF')) ) {s = 423;}

                        else if ( ((LA21_422>='#' && LA21_422<='$')||(LA21_422>='0' && LA21_422<='9')||LA21_422=='_'||(LA21_422>='a' && LA21_422<='z')) ) {s = 422;}

                        else s = 21;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA21_418 = input.LA(1);

                        s = -1;
                        if ( ((LA21_418>='#' && LA21_418<='$')||(LA21_418>='0' && LA21_418<='9')||LA21_418=='_'||(LA21_418>='a' && LA21_418<='z')) ) {s = 476;}

                        else if ( ((LA21_418>='\u0000' && LA21_418<='\"')||(LA21_418>='%' && LA21_418<='/')||(LA21_418>=':' && LA21_418<='^')||LA21_418=='`'||(LA21_418>='{' && LA21_418<='\uFFFF')) ) {s = 477;}

                        else s = 21;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA21_355 = input.LA(1);

                        s = -1;
                        if ( ((LA21_355>='#' && LA21_355<='$')||(LA21_355>='0' && LA21_355<='9')||LA21_355=='_'||(LA21_355>='a' && LA21_355<='z')) ) {s = 422;}

                        else if ( ((LA21_355>='\u0000' && LA21_355<='\"')||(LA21_355>='%' && LA21_355<='/')||(LA21_355>=':' && LA21_355<='^')||LA21_355=='`'||(LA21_355>='{' && LA21_355<='\uFFFF')) ) {s = 423;}

                        else s = 21;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA21_119 = input.LA(1);

                         
                        int index21_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_119=='e') ) {s = 203;}

                        else if ( ((LA21_119>='0' && LA21_119<='9')) ) {s = 119;}

                        else if ( (LA21_119=='.') && ((numberDotValid()))) {s = 121;}

                        else s = 120;

                         
                        input.seek(index21_119);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}