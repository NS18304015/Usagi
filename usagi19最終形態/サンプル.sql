
drop table RESPONSE_TABLE;
drop table THREAD_TABLE;

drop sequence test_seq_a;
drop sequence test_seq_b;
drop sequence test_seq_c;

create SEQUENCE TEST_SEQ_A
START WITH 1
INCREMENT BY 1
MAXVALUE 500
MINVALUE 1
;
create SEQUENCE TEST_SEQ_B
START WITH 1
INCREMENT BY 1
MAXVALUE 500
MINVALUE 1
;
create SEQUENCE TEST_SEQ_C
START WITH 1
INCREMENT BY 1
MAXVALUE 500
MINVALUE 1
;

CREATE TABLE THREAD_TABLE(
 Thread_No Number(5) constraint pk_th_no primary key,
 Thread_Name VARCHAR2(200) constraint UK_th_NAME UNIQUE,
 Thread_Time VARCHAR2(19),
 Thread_Report Number(3) NOT NULL 
 );


create table RESPONSE_TABLE(
	Response_No Number(6) constraint pk_rt_no primary key,
	Response_SerialNo Number(4) NOT NULL
								constraint ck_rsn_no CHECK(Response_SerialNo<=1000),
	Response_UserName VARCHAR2(20) NOT NULL,
	Response_Contents VARCHAR2(300) NOT NULL,
	Response_Time VARCHAR2(19) ,
	Thread_No Number(5) constraint FK_RES_THN references Thread_table (Thread_no),
	Response_Rating Number(5) DEFAULT(0) NOT NULL,
	Response_ParentNo Number(3) ,
	Response_Report Number(3) DEFAULT(0) NOT NULL
);