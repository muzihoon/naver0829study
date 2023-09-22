-- 2023-09-22 프로시져
/*
프로시져(procedure)
:프로시져는 특정 작업을 수행하는 일종의 서브 프로그램으로
데이타베이스에 저장되는 객체이다
반복되는 코드같은 경우 프로시져에 저장해두었다가 호출해서
실행만 하면 되므로 재사용성이 높다
 
형식
create : 새로 생성, 기존 프로시져가 존재할 경우 오류 발생
create or replace : 새로 생성, 근데 기존 프로시저가 있으면 덮어쓴다.

create [or replace] procedure 프로시져명
   [파라미터 모드 데이타타입,....]
is
       	변수 선언
begin
            	코드;
end;
/
 
호출:   exec 프로시져명
            	exec 프로시져명(값..)

*/


-- 예제 1
-- 초 간단 프로시저 생성해보기

create or replace PROCEDURE mytest
is
begin
    DBMS_OUTPUT.PUT_LINE('첫 프로시저를 만들었어요!');
end;
/
-- mytest 프로시저 안에서 편집하면 안된다. 
--mytest 프로시저 호출
exec mytest;

-- 예제 2: 숫자를 인자로 보내면 구구단 출력

create or replace PROCEDURE gugu(dan number)
is
begin
    if dan<2 or dan>9 then
        DBMS_OUTPUT.PUT_LINE('잘못된 숫자 입니다. 2-9사이 값 요구!');
    else
        DBMS_OUTPUT.PUT_LINE(' **'||dan||'단 **');
        
        for a in 1..9 loop
            DBMS_OUTPUT.PUT_LINE(dan||'X'||a||'='||dan*a);
        end loop;
    end if;
end;
/

-- 실행
exec gugu(11);
exec gugu(5);


-- shop 에 데이터 추가하기 
insert into shop values (seq_shop.nextval,'레이스블라우스',23000,'white');

-- shop 의 sang_color 의 타입 길이 변경해보기
alter table shop modify sang_color varchar2(30);
insert into shop values (seq_shop.nextval,'체크조끼',39000,'rainbow');
insert into shop values (seq_shop.nextval,'칠부청바지',56000,'rainbow');
insert into shop values (seq_shop.nextval,'레이스조끼',19000,'blue');
commit;

--- 예제 3 : 상품명을 인자로 보내면 그 단어가 포함된 모든 상품들 출력하기
create or replace PROCEDURE product(prod varchar2)
is
    Cursor s1
    is
    select * from shop where sang_name like '%'||prod||'%'; -- % 이게 포함된 % 이라는 뜻
    
    --검색된 상품 개수를 구할 변수
    v_cnt number(2);

begin

     select count(*) into v_cnt from shop where sang_name like '%'||prod||'%';
     if v_cnt=0 then
        DBMS_OUTPUT.PUT_LINE(prod||' 상품은 목록에 없습니다.');
    else 
        DBMS_OUTPUT.PUT_LINE(prod||'상품 조회하기');
        DBMS_OUTPUT.PUT_LINE('총 '||v_cnt||'개 조회');
        DBMS_OUTPUT.PUT_LINE('상품번호  상품명  가격   색상');
        DBMS_OUTPUT.PUT_LINE('--------------------------------');
        for s in s1 loop
            DBMS_OUTPUT.PUT_LINE(s.sang_no||'   '||s.sang_name||'     '||
                s.sang_price||'    '||s.sang_color);
            exit when s1%notfound;
        end loop;
        end if;
end;
/

-- 실행
exec product('조끼');
exec product('청바지');
exec product('한복');


-- 예제 4

/*
    exec addupdate('레이스조끼','black'); : '레이스조끼' 상품이 없으면 추가
                                            : '레이스조끼' 상품이 있으면 색상만 수정
                                            : 수정되었습니다. 추가되었습니다. 메세지 출력
*/


create or replace PROCEDURE addupdate(prod varchar2, price number,color varchar2)
is
    Cursor s1
    is
    select * from shop where sang_name like '%'||prod||'%'; -- % 이게 포함된 % 이라는 뜻
    
    --검색된 상품 개수를 구할 변수
    v_cnt number(2);

begin

     select count(*) into v_cnt from shop where sang_name like '%'||prod||'%';
     if v_cnt=0 then
        DBMS_OUTPUT.PUT_LINE(prod||' 상품이 추가되었습니다.');
    insert into shop values(seq_shop.nextval,prod,price,color);
     DBMS_OUTPUT.PUT_LINE(prod||' 상품을 수정하였습니다.');
        DBMS_OUTPUT.PUT_LINE(prod||'상품 조회하기');
        DBMS_OUTPUT.PUT_LINE('총 '||v_cnt||'개 조회');
        DBMS_OUTPUT.PUT_LINE('상품번호  상품명  가격   색상');
        DBMS_OUTPUT.PUT_LINE('--------------------------------');
        for s in s1 loop
            DBMS_OUTPUT.PUT_LINE(s.sang_no||'   '||s.sang_name||'     '||
                s.sang_price||'    '||s.sang_color);
            exit when s1%notfound;
        end loop;
    else 
        update shop set sang_color=color where sang_name=prod;
        update shop set sang_price=price where sang_name=prod;

        DBMS_OUTPUT.PUT_LINE(prod||' 상품을 수정하였습니다.');
        DBMS_OUTPUT.PUT_LINE(prod||'상품 조회하기');
        DBMS_OUTPUT.PUT_LINE('총 '||v_cnt||'개 조회');
        DBMS_OUTPUT.PUT_LINE('상품번호  상품명  가격   색상');
        DBMS_OUTPUT.PUT_LINE('--------------------------------');
        for s in s1 loop
            DBMS_OUTPUT.PUT_LINE(s.sang_no||'   '||s.sang_name||'     '||
                s.sang_price||'    '||s.sang_color);
            exit when s1%notfound;
        end loop;
        end if;
end;
/

exec addupdate('조끼',34000,'purple');
exec addupdate('양복정장',150000,'blue');
exec addupdate('양복정장3',150000,'gray');