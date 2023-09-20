-- angel ���� ����

-- ������ ����  - �Խñ� ��ȣ�� ����ϱ� ���ƺ��� 

-- ��ü ������ ��ȸ
select * from seq;

-- sequence ����
create SEQUENCE seq1 start with 1 INCREMENT by 1; -- 1���� 1�� �����Ǵ� �������� �����Ѵ�.
create SEQUENCE seq2 start with 5 INCREMENT by 3 nocache; -- 5���� 3�� ����, cache ���� 0
create SEQUENCE seq3 maxvalue 100 nocache; -- start with �� increment ������ 1�� �ʱⰪ ����

-- �� �߻��� ��Ű�� 
select seq1.nextval,seq2.nextval,seq3.nextval from dual;
select seq2.nextval from dual;

-- ������ ����
drop SEQUENCE seq1;
drop SEQUENCE seq2;
drop SEQUENCE seq3;

-- ���ο� ������ ����
create SEQUENCE seq_test nocache;

-- table ����

create table test(
    num number(3) primary key, -- notnull �� sequence ��ģ ��
    name varchar2(20) not null,
    blood char(2) default 'A',
    weight number(5,2), --5�ڸ�, �Ҽ��� 2�ڸ� ���� 
    birthday date
    );


-- ������ �߰�
-- �Ϻ� �����͸� �ִ� ��� �÷����� �ݵ�� ǥ���Ѵ�.
insert into test (num,name) values (seq_test.nextval,'ī����');

-- ������� ��� �÷����� �ִ� ��� �÷��� ���� ����
insert into test values (seq_test.nextval,'ĳ����','AB',67.89,sysdate);

-- �������ǿ� �ȸ´� ��� ���� Ȯ��
insert into test (num,blood) values (seq_test.nextval,'O');
insert into test (num,name,blood) values (2,'Lee','O');

--����� �� ����Ÿ 3�� ���� �߰��ϱ�, ���鵵 ����� �ؾ� ���߿� java���� ������ ���� �Ȼ���
insert into test values (seq_test.nextval,'�ϴ�','B',59.12,'2003-10-10');
insert into test values (seq_test.nextval,'����','A',54.12,'2005-11-10');
insert into test values (seq_test.nextval,'����','O',57.12,'2007-12-10');


--rollback; -- ������ commit �� ���� sql�� (DML:insert,delete,update) ��� ���
commit; -- ���̻� rollback �ȵ�. ���� ���� ������ ������ �������� �ʴ´�.

insert into test values (seq_test.nextval,'�踻��','B',56.78,'1989-0909');

-- �̻��¿��� rollback �ϸ� ���� ��� �ɱ� ? 
rollback; 

-- update ��ɾ� �Ҷ� where ���� �ȳ����� ���� �� �ٲ��. ���� �ʼ��� 

-- from�� select �� delete�� ����.
-- ����, ��ȣ���� �������� 'AB'������ ����
update test set blood='AB' where name='�ϴ�';

-- �ΰ��� �÷� ����
update test set weight=60.8, birthday=sysdate where num=7;

--����
delete from test; -- ��� �����Ͱ� ���� �Ǵ� �����ؾ� �Ѵ�.
rollback;

-- num �� 7,9,10�� �����Ϸ��� 
delete from test where num IN(7,9,10);
rollback;

-- table ���� 
drop table test; -- �̰� �ѹ��� �ȵȴ�.
-- ������ ����
drop SEQUENCE seq_test;
rollback; -- DML(insert,delete,update �ΰ�츸 �ѹ��� �ǰ� drop�� �ȵȴ�)


-------------------------------------------------------------------------------


create table person (
    num number(3) CONSTRAINT person_pk_num primary key,
    blood char(2)  
);


-- ���� �������� ����
alter table person drop CONSTRAINT person_pk_num;
alter table person drop CONSTRAINT person_ck_java;



-- �ٽ� primary key �� ���� �������� �߰�
alter table person add CONSTRAINT person_pk_num primary key (num);


-- blood �� ���ؼ� check �������� �߰�
alter table person add CONSTRAINT person_ck_blood check (blood in ('A','B','O','AB')); -- blood �� ���ؼ� �� 4������ ����ϰڴ�. �׿ܴ� ����



-- ������ �߰�
insert into person values (1,'A');
insert into person values (1,'B'); -- ���� �߻� : ���Ἲ ���� ����(ANGEL.PERSON_PK_NUM)�� ����˴ϴ�
insert into person values (2,'b'); -- ���� �߻� : üũ ��������(ANGEL.PERSON_CK_BLOOD)�� ����Ǿ����ϴ�
insert into person values (2,'O'); -- OK



-- �÷��� �߰�, column �̶� �ܾ��  drop r�� rename�� ����.
alter table person add name varchar2(20);
alter table person add score number(5,1) default 30.5;



-- �÷��� ���� (drop colum)
alter table person drop column num;



-- java ��� �÷��� number Ÿ������ �߰� �� 1~100 ������ ���� �������� �������ǵ� �߰�
alter table person add java number(3) default 0;
alter table person add CONSTRAINT person_ck_java check (java>=0 and java<=100);
alter table person add CONSTRAINT person_ck_java check (java BETWEEN 0 and 100); -- ���� ����



-- �÷��� ���� rename column 
alter table person rename COLUMN java to spring;



-- ������ �߰��� �÷� ������� �ֱ� ���� ��� �÷��� �ָ�ȴ�.
insert into person (name,blood,spring,score) values ('lee','O',90,35);

drop table person; 
