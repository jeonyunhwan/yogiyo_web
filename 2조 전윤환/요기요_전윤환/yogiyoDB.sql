create table Store(
    registNum number constraint Store_registNum_pk primary key,--사업자 등록번호
    storeName varchar2(20), --
    rpName varchar(20), -- 대표자명
    contact number,
    pw varchar2(20),
    address varchar2(100),
    category varchar2(20),
    minOder varchar2(20),
    brand varchar2(20),
    businessHour varchar2(20),
    origin varchar2(100),-- 원산지 정보
    state varchar2(20) -- 입점 신청 상태
 );
select * from Store;

create table menu(
    registNum number constraint menu_registNum_fk references Store(registNum),
    menuName varchar2(20),
    price number,
    description varchar2(100)
);

select * from menu;

create table event(
    eventName varchar2(20) constraint event_eventName_pk primary key,
    discount number,
    condition varchar2(100),
    registNum number constraint event_registNum_fk references Store(registNum)
);

select*from event;

--고객 테이블 생성
create table customer(
    userID varchar2(20) constraint customer_userID_pk primary key,
    pw varchar2(20),
    name varchar2(20),
    address varchar2(100),
    mobile number
);

--찜테이블
create table favorite(
    userID varchar2(20) constraint favorite_userID_fk references customer(userID),
    registNum number constraint favorite_registNum_fk references Store(registNum)
);

-- 쿠폰 엔터티
create table coupon(
    couponNum number constraint coupon_coponNum_pk primary key,
    discount number
);

create table orderProd(
    orderNum number constraint order_orderNum_pk primary key,
    contect number,
    request varchar2(100),
    menu varchar2(100),
    price number,
    payment varchar2(20),
    state varchar2(20),
    registNum number constraint order_registNum_fk references Store(registNum),
    userID varchar2(20) constraint order_userID_fk references customer(userID),
    couponNum number constraint order_couponNum_fk references coupon(couponNum),
    eventName varchar2(20) constraint order_eventName_fk references event(eventName)
);

select * from orderProd;

create table review(
    orderNum number constraint review_orderNum_fk primary key,
    star number,
    review varchar2(100),
    Rpcomment varchar2(100) -- 사장님 댓글
);

create table admin(
    adminID varchar2(20) constraint admin_adminID_pk primary key,
    pw varchar2(20)
);