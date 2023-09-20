-- angel 계정 연습

-- 시퀀스 연습  - 게시글 번호에 사용하기 좋아보임 

-- 전체 시퀀스 조회
select * from seq;

-- sequence 생성
create SEQUENCE seq1 start with 1 INCREMENT by 1; -- 1붙터 1씩 증가되는 시퀀스를 생성한다.
create SEQUENCE seq2 start with 5 INCREMENT by 3 nocache; -- 5부터 3씩 증가, cache 값은 0
create SEQUENCE seq3 maxvalue 100 nocache; -- start with 와 increment 생략시 1로 초기값 지정

-- 값 발생을 시키기 
select seq1.nextval,seq2.nextval,seq3.nextval from dual;
select seq2.nextval from dual;

-- 시퀀스 제거
drop SEQUENCE seq1;
drop SEQUENCE seq2;
drop SEQUENCE seq3;

-- 새로운 시퀀스 생성
create SEQUENCE seq_test nocache;

-- table 생성

create table test(
    num number(3) primary key, -- notnull 과 sequence 합친 것
    name varchar2(20) not null,
    blood char(2) default 'A',
    weight number(5,2), --5자리, 소수점 2자리 까지 
    birthday date
    );


-- 데이터 추가
-- 일부 데이터만 넣는 경우 컬럼명을 반드시 표기한다.
insert into test (num,name) values (seq_test.nextval,'카리나');

-- 순서대로 모든 컬럼값을 넣는 경우 컬럼명 생략 가능
insert into test values (seq_test.nextval,'캐서린','AB',67.89,sysdate);

-- 제약조건에 안맞는 경우 오류 확인
insert into test (num,blood) values (seq_test.nextval,'O');
insert into test (num,name,blood) values (2,'Lee','O');

--제대로 된 데이타 3개 정도 추가하기, 공백도 제대로 해야 나중에 java에서 넣을때 문제 안생김
insert into test values (seq_test.nextval,'하니','B',59.12,'2003-10-10');
insert into test values (seq_test.nextval,'혜린','A',54.12,'2005-11-10');
insert into test values (seq_test.nextval,'혜인','O',57.12,'2007-12-10');


--rollback; -- 마지막 commit 한 이후 sql문 (DML:insert,delete,update) 모두 취소
commit; -- 더이상 rollback 안됨. 내가 직접 지우지 않으면 없어지지 않는다.

insert into test values (seq_test.nextval,'김말동','B',56.78,'1989-0909');

-- 이상태에서 rollback 하면 누가 취소 될까 ? 
rollback; 

-- update 명령어 할때 where 조건 안넣으면 모든게 다 바뀐다. 조건 필수임 

-- from은 select 와 delete만 쓴다.
-- 수정, 강호동의 혈액형을 'AB'형으로 수정
update test set blood='AB' where name='하니';

-- 두개의 컬럼 수정
update test set weight=60.8, birthday=sysdate where num=7;

--삭제
delete from test; -- 모든 데이터가 삭제 되니 주의해야 한다.
rollback;

-- num 이 7,9,10을 삭제하려면 
delete from test where num IN(7,9,10);
rollback;

-- table 제거 
drop table test; -- 이건 롤백이 안된다.
-- 시퀀스 제거
drop SEQUENCE seq_test;
rollback; -- DML(insert,delete,update 인경우만 롤백이 되고 drop은 안된다)


-------------------------------------------------------------------------------


create table person (
    num number(3) CONSTRAINT person_pk_num primary key,
    blood char(2)  
);


-- 기존 제약조건 제거
alter table person drop CONSTRAINT person_pk_num;
alter table person drop CONSTRAINT person_ck_java;



-- 다시 primary key 에 대한 제약조건 추가
alter table person add CONSTRAINT person_pk_num primary key (num);


-- blood 에 대해서 check 제약조건 추가
alter table person add CONSTRAINT person_ck_blood check (blood in ('A','B','O','AB')); -- blood 에 대해서 이 4가지만 허용하겠다. 그외는 에러



-- 데이터 추가
insert into person values (1,'A');
insert into person values (1,'B'); -- 에러 발생 : 무결성 제약 조건(ANGEL.PERSON_PK_NUM)에 위배됩니다
insert into person values (2,'b'); -- 에러 발생 : 체크 제약조건(ANGEL.PERSON_CK_BLOOD)이 위배되었습니다
insert into person values (2,'O'); -- OK



-- 컬럼을 추가, column 이란 단어는  drop r과 rename에 들어간다.
alter table person add name varchar2(20);
alter table person add score number(5,1) default 30.5;



-- 컬럼명 제거 (drop colum)
alter table person drop column num;



-- java 라는 컬럼을 number 타입으로 추가 후 1~100 사이의 값만 들어오도록 제약조건도 추가
alter table person add java number(3) default 0;
alter table person add CONSTRAINT person_ck_java check (java>=0 and java<=100);
alter table person add CONSTRAINT person_ck_java check (java BETWEEN 0 and 100); -- 위와 동일



-- 컬럼명 변경 rename column 
alter table person rename COLUMN java to spring;



-- 데이터 추가시 컬럼 순서대로 주기 싫을 경우 컬럼명 주면된다.
insert into person (name,blood,spring,score) values ('lee','O',90,35);

drop table person; 
