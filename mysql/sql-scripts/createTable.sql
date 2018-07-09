use projectdb;

CREATE TABLE projectdb.tbl_persisting_trans(msg_id varchar(100) NOT NULL,trx_id varchar(256) NOT NULL,credit_date_time TIMESTAMP,BSB varchar(20),sum_amt float,branch_id varchar(40),stlmnt_amt float,debtor_name varchar(256),creditor_name varchar(256),currency varchar(20), request_obj text NOT NULL, creditor_acc bigint NOT NULL, debtor_acc  bigint NOT NULL, PRIMARY KEY (msg_id));

