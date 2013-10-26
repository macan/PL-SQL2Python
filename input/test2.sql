create or replace package body TestPackage is   
    procedure UpdateRecords(id_in in number, newName in varchar2, newAge  in number) as   
    begin   
     update test set age = newAge, name = newName where id = id_in;   
    end UpdateRecords;   
  
    procedure DeleteRecords(id_in in number) as   
    begin   
       delete from test where id = id_in;   
    end DeleteRecords;  
 
    procedure InsertRecords(name_in in varchar2, age_in in number) as   
    begin   
       insert into test values (test_seq.nextval, name_in, age_in);    
    --test_seq是一个已建的Sequence对象，请参照前面的示例    
    end InsertRecords;   
    end TestPackage;
