--가게 정보 등록
insert into Store values(1068123498,'롯데리아','차우철',050352594353,'ROTTE001','서울특별시 은평구 대조동 6-5 신흥빌딩 6-5','1인분 주문',10000,'롯데리아','매일 24시간','불고기버거: 쇠고기(국내산 한우), 핫 크리스피버거 : 닭고기(국내산),불고기버거:쇠고기(호주산),클래식 치즈버거:쇠고기(호주산), 클래식 치즈버거(버터번):쇠고기(호주산),치킨 1조각:닭고기(국내산),순살치킨:닭고기(브라질산),빅불버거:쇠고기(호주산),모짜렐라 언더버거(더블):쇠고기(호주산),모짜렐라 언더버거(베이컨):쇠고기(호주산),T-REX 버거:닭고기(브라질산),새우버거:명태연육(미국산),DoubleX2버거:쇠고기(한우),비프패티토핑:쇠고기(호주산),베이컨토핑:베이컨(외국산),지파이:닭고기(국내산),치킨너겟:닭고기(국내산),쉑쉑치킨:닭고기(한우),화이어윙:닭고기(덴마크산),치킨버거:닭고기(국내산 브라질산 섞음),1인혼닭:닭고기(국내산),사각새우더블버거:명태연육(미국산),4DX버거:쇠고기(호주산),통오징어링:오징어(중국산)','입점신청완료');
insert into Store values(8963600619,'동궁찜닭연신내점','오우택',050718618529,'DONGGUNG','서울특별시 은평구 갈현동 399-5','한식',18000,'동궁찜닭','오전10시~오후10시','닭고기(뼈):국산,닭고기(순살):국산,야채(국산),메추리알(국산),고춧가루(국산),매운맛고춧가루(베트남),공기밥(국산)','입점신청완료',1500);
insert into Store values(3043006825,'아오리라멘연신내점','오정훈',050323424344,'Ramen11','서울특별시 은평구 갈현동 456-3456-3 2층','돈까스/일식',15000,'아오리','오전10시~오후9시','쇠고기(미국산),돼지고기(국내산),돼지고기(차슈용/독일산),돼지고기(육수용/국내산),닭고기(육수용/브라질산/국내산),쌀(국내산),배추김치(국내산)','입점신청완료',2900,'저희 아오리라멘 강남점은 직접 12시간 동안 우려낸 국물로 육수를 만들어내는 과정을 거치므로 아오리 돈코츠라멘과 미소라멘의 육수를 다 드신다면 몸보신이란 생각이 들것입니다. 믿고 찾아주시는 고객님들이 맛있는 라멘을 드시도록 항상 신경쓰겠습니다.');
ALTER TABLE STORE ADD diliveryCost number;
ALTER TABLE STORE MODIFY STORENAME VARCHAR2(50);
ALTER TABLE STORE MODIFY BUSINESSHOUR VARCHAR2(50);
select*from STORE;
UPDATE store SET STORE.diliveryCost = 2000  WHERE STORE.diliveryCost is null;
commit;
--menu
insert into MENU values(1068123498,'슈퍼소니팩',13700,'불고기버거+새우버거+포테이토R+모짜렐라치즈볼+콜라2+스크래치박스');
insert into MENU values(1068123498,'더블한우불고기세트',13700,'국내산 한우를 사용한 패티 2장 구성으로 육즙가득! 묵직한 육풍미 자극한 프리미엄 버거');
ALTER TABLE MENU MODIFY MENUNAME VARCHAR2(50);
ALTER TABLE MENU MODIFY DESCRIPTION VARCHAR2(200);
insert into MENU values(1068123498,'NEW홈투게더팩',12200,'새우B+데리B+포테이토R+치즈스틱+콜라1.25L');
insert into MENU values(1068123498,'더블한우불고기버거',12000,'국내산 한우를 사용한 패티 2장 구성으로 육즙가득! 묵직한 육풍미 자극한 프리미엄 버거','1인분 주문');
insert into MENU values(1068123498,'한우트러플머쉬룸세트',11000,'양송이버섯이 들어있는 은은한 트러플 풍미의 크림 소스와 한우 패티가 조화로운 새로운 타입의 프리미엄 버거','1인분 주문');
insert into MENU values(1068123498,'슈퍼소니팩',13700,'불고기버거+새우버거+포테이토R+모짜렐라치즈볼+콜라2+스크래치박스','팩류');
insert into MENU values(1068123498,'힙&BEST팩',23200,'힙&핫치킨버거와 롯데리아 Best 불고기버거,새우버거와 함께 즐기자','팩류');
insert into MENU values(1068123498,'힙&모짜팩',18100,'힙&핫치킨버거와 모짜렐라인더베이컨버거를 함께 즐기자','팩류');
insert into MENU values(1068123498,'NEW홈패밀리팩(사이다)',20100,'불고기버거,새우버거,데리버거,치즈스틱,양념감자,통오징어링,사이다1.25L','팩류');
insert into MENU values(1068123498,'NEW홈더블팩',15000,'핫크리스피버거+불고기버거+치즈스틱+양념감자+PET콜라1.25L','팩류');
insert into MENU values(1068123498,'NEW홈더블팩(사이다)',15000,'핫크리스피버거+불고기버거+치즈스틱+양념감자+PET사이다1.25L','팩류');
insert into MENU values(1068123498,'NEW홈투게더팩',12200,'새우B+데리B+포테이토R+치즈스틱+콜라1.25L','팩류');
insert into MENU values(1068123498,'NEW홈투게더팩(사이다)',12200,'새우B+데리B+포테이토R+치즈스틱+사이다1.25L','팩류');
insert into MENU values(1068123498,'합&치킨버거세트',8300,'바삭한 치킨패티와 매콤한 양념소스,아삭한 적채당근피클로 식감과 풍미를 더한 치킨버거','세트');
insert into MENU values(1068123498,'더블한우불고기버거세트',13700,'국내산 한우를 사용한 패티 2장 구성으로 육즙가득! 묵직한 육풍미 자극한 프리미엄 버거 세트','세트');
insert into MENU values(1068123498,'한우트러플머쉬룸세트',11000,'양송이버섯이 들어있는 은은한 트러플 풍미의 크림 소스와 한우 패티가 조화로운 새로운 타입의 프리미엄 버거 세트','세트');
insert into MENU values(1068123498,'모짜렐라인더 버거-베이컨 세트',9700,'브리오쉬번에 국내선 한우를 사용한 패티,신선한 야채,특제 소스로 완성한 프리미엄 버거 세트','세트');
insert into MENU values(1068123498,'원조빅불세트',8800,'불고기패티 2장으로 더 진하고 더 커진 빅불고기 버거','세트');
insert into MENU values(1068123498,'불고기 4DX 세트',8300,'직화로 구워내 풍미와 식감이 살아있는 리얼 불고기와 깔끔하게 매운맛의 청양고추마요가 조화로운 불고기버거','세트');
insert into MENU values(1068123498,'DoubleX2세트',8300,'순비프패티 2장,치즈 2장을 활용한 맛이 조화로운 정통 아메리칸 버거','세트');
insert into MENU values(1068123498,'리아미라클세트',8300,'고기없이 고기맛이 나는 기적, 100% 식물성 패티로 만든 대체육버거','세트');
insert into MENU values(1068123498,'핫크리스피버거세트',7400,'핫크리스피버거세트','세트');
insert into MENU values(1068123498,'사각새우더블세트',7300,'미니새우패티 2장으로 구성된 새우버거 매니아를 위한 버거','세트');
insert into MENU values(1068123498,'클래식치즈버거 세트',6900,'부드러운 치즈와 호주산 쇠고기패티의 본연의 맛을 느낄 수 있는 치즈버거','세트');
insert into MENU values(1068123498,'클래식치즈세트_(버터번)',6900,'비프와 치즈 본연의 맛에 딜향의 피클이 조화된 클래식 치즈버거','세트');
insert into MENU values(1068123498,'불고기버거세트',6600,'두툼한 쇠고기 패티와 한국적인 맛의 소스가 잘 조화된 롯데리아 대표버거','세트');
insert into MENU values(1068123498,'새우버거세트',6600,'새우살을 가득넣어 더 맛있어진 오리지널 새우버거','세트');
insert into MENU values(1068123498,'T-REX버거 세트',6500,'빵보다 큰 쫄깃한 통닭다리살 패티와 부드러운 크림 소스의 만남','세트');
insert into MENU values(1068123498,'치킨버거세트',5900,'닭고기패티와 데리야끼 소스로 만든 담백하고 달콤한 맛의 치킨버거','세트');
insert into MENU values(1068123498,'데리세트',5100,'쇠고기패티에 달콤짭잘한 데리소스를 더한 가성비 갑 버거','세트');
--
insert into MENU values(1068123498,'힙&핫치킨버거',6500,'바삭한 치킨패티와 매콤한 양념소스,아삭한 적채당근피클로 식감과 풍미를 더한 치킨버거','버거');
insert into MENU values(1068123498,'더블한우불고기버거',12000,'국내산 한우를 사용한 패티 2장 구성으로 육즙가득! 묵직한 육풍미 자극한 프리미엄 버거','버거');
insert into MENU values(1068123498,'한우트러플머쉬룸버거',9300,'양송이버섯이 들어있는 은은한 트러플 풍미의 크림 소스와 한우 패티가 조화로운 새로운 타입의 프리미엄 버거','버거');
insert into MENU values(1068123498,'한우불고기버거',8000,'브리오쉬번에 국내선 한우를 사용한 패티,신선한 야채,특제 소스로 완성한 프리미엄 버거 ','버거');
insert into MENU values(1068123498,'모짜렐라인더버거-베이컨',7000,'자연산 모짜렐라 치즈와 고소한 베이컨이 만나 풍부한 맛의 버거','버거');
insert into MENU values(1068123498,'불고기4DX',6500,'직화로 구워내 풍미와 식감이 살아있는 리얼 불고기와 깔끔하게 매운맛의 청양고추마요가 조화로운 불고기버거','버거');
insert into MENU values(1068123498,'DoubleX2버거',6500,'순비프패티 2장,치즈 2장을 활용한 맛이 조화로운 정통 아메리칸 버거','버거');
insert into MENU values(1068123498,'리아미라클버거',6500,'고기없이 고기맛이 나는 기적, 100% 식물성 패티로 만든 대체육버거','버거');
insert into MENU values(1068123498,'핫크리스피버거',5600,'닭가슴살 패티로 만든 매콤 화끈 프리미엄 치킨버거','버거');
insert into MENU values(1068123498,'사각새우더블버거',5300,'미니새우패티 2장으로 구성된 새우버거 매니아를 위한 버거','버거');
insert into MENU values(1068123498,'클래식치즈버거',4900,'부드러운 치즈와 호주산 쇠고기패티의 본연의 맛을 느낄 수 있는 치즈버거','버거');
insert into MENU values(1068123498,'클래식치즈버거_(버터번)',4900,'비프와 치즈 본연의 맛에 딜향의 피클이 조화된 클래식 치즈버거','버거');
insert into MENU values(1068123498,'불고기버거',4500,'두툼한 쇠고기 패티와 한국적인 맛의 소스가 잘 조화된 롯데리아 대표버거','버거');
insert into MENU values(1068123498,'새우버거',4500,'새우살을 가득넣어 더 맛있어진 오리지널 새우버거','버거');
insert into MENU values(1068123498,'T-REX버거',4400,'빵보다 큰 쫄깃한 통닭다리살 패티와 부드러운 크림 소스의 만남','버거');
insert into MENU values(1068123498,'치킨버거',3700,'닭고기패티와 데리야끼 소스로 만든 담백하고 달콤한 맛의 치킨버거','버거');
insert into MENU values(1068123498,'데리버거',2900,'쇠고기패티에 달콤짭잘한 데리소스를 더한 가성비 갑 버거','버거');

--치킨
insert into MENU values(1068123498,'순살치킨풀팩',16300,'바삭한 외피와 육즙 가득 닭다리살 순살 치킨 22조각+소스2개','치킨');
insert into MENU values(1068123498,'1인혼닭9.9',9900,'겉바속촉 혼자먹는 치킨 한마리(치킨무별도)','치킨');
insert into MENU values(1068123498,'화이어윙4조각(태)',5100,'담백한 맛과 매콤한 맛 잘 조화된 특별한 타입의 치킨','치킨');
insert into MENU values(1068123498,'순살치킨 하프팩',9300,'바삭한 외피와 육즙 가득 닭다리살 순살 치킨 11조각+소스1개','치킨');
insert into MENU values(1068123498,'화이어윙2조각(태)',2900,'담백한 맛과 매콤한 맛 잘 조화된 특별한 타입의 치킨','치킨');
insert into MENU values(1068123498,'치킨휠레4조각',5100,'신선한 치킨만을 사용하여 부드럽고 담백함과 매콤한 맛이 어우러진 순살치킨','치킨');
insert into MENU values(1068123498,'치킨휠레2조각',2900,'신선한 치킨만을 사용하여 부드럽고 담백함과 매콤한 맛이 어우러진 순살치킨','치킨');

--동궁찜닭
insert into MENU values(8963600619,'동궁황금찜닭',19000,null,'메인메뉴');
insert into MENU values(8963600619,'동궁안동찜닭',19000,null,'메인메뉴');
insert into MENU values(8963600619,'동궁고추장찜닭',19000,null,'메인메뉴');
insert into MENU values(8963600619,'동궁바베큐쪼림닭',20000,null,'메인메뉴');
insert into MENU values(8963600619,'동궁닭도리탕',25000,null,'메인메뉴');
insert into MENU values(8963600619,'동궁로제찜닭',22000,null,'메인메뉴');
-- 토핑 사리
insert into MENU values(8963600619,'체다치즈',19000,null,'토핑&사리');
insert into MENU values(8963600619,'김+참기름',500,null,'토핑&사리');
insert into MENU values(8963600619,'모짜렐라치즈',3500,null,'토핑&사리');
insert into MENU values(8963600619,'찍먹방',1000,null,'토핑&사리');
insert into MENU values(8963600619,'떡추가(10개)',1000,null,'토핑&사리');
insert into MENU values(8963600619,'고구마떡',2000,null,'토핑&사리');
insert into MENU values(8963600619,'치즈떡',2000,null,'토핑&사리');
insert into MENU values(8963600619,'콘치즈떡',2000,null,'토핑&사리');
insert into MENU values(8963600619,'모듬떡(3개)',2000,null,'토핑&사리');
insert into MENU values(8963600619,'메추리알(5개)',1000,null,'토핑&사리');
insert into MENU values(8963600619,'감자만두(4개)',2000,null,'토핑&사리');
insert into MENU values(8963600619,'감자(3~4조각)',2000,null,'토핑&사리');
insert into MENU values(8963600619,'우동(1봉지)',2000,null,'토핑&사리');
insert into MENU values(8963600619,'당면(150g)',2000,null,'토핑&사리');
insert into MENU values(8963600619,'중국왕당면(100g)',2000,null,'토핑&사리');
insert into MENU values(8963600619,'분모자당면(3줄)',2000,null,'토핑&사리');
insert into MENU values(8963600619,'비트무',500,null,'토핑&사리');

--음료메뉴
insert into MENU values(8963600619,'생수500ml',1000,null,'음료메뉴');
insert into MENU values(8963600619,'동궁식혜',3000,null,'음료메뉴');
insert into MENU values(8963600619,'펩시제로500ml',2000,null,'음료메뉴');
insert into MENU values(8963600619,'사이다500ml',2000,null,'음료메뉴');
insert into MENU values(8963600619,'펩시1.25L',2500,null,'음료메뉴');
--아오리
insert into menu values(3043006825,'세트2',16000,'미소라멘+간장밥,마늘/파선택가능','세트');
insert into menu values(3043006825,'세트3',15000,'마제멘+공기밥+음료/소스선택가능','세트');
insert into menu values(3043006825,'세트4',27500,'아오리라멘+마제멘+계란간장밥+마늘/파/소스 선택가능','세트');
insert into menu values(3043006825,'아오리라멘',10500,'마늘/파/소스선택','단품');
insert into menu values(3043006825,'미소라멘',11000,'마늘/파선택','단품');
insert into menu values(3043006825,'마제멘',12000,'/소스선택가능','단품');
insert into menu values(3043006825,'아지타마고',1500,'#마약계란장#일본식장조림','토핑메뉴');
insert into menu values(3043006825,'숙주',1000,'숙주추가','토핑');
insert into menu values(3043006825,'차슈',2500,'2장','토핑');
insert into menu values(3043006825,'김',500,'3장','토핑');
insert into menu values(3043006825,'멘마',1500,'','토핑');
insert into menu values(3043006825,'면추가',2500,'','토핑');
insert into menu values(3043006825,'TKG계란간장밥',3000,'','사이드메뉴');
insert into menu values(3043006825,'마제고항',3000,'','사이드메뉴');
insert into menu values(3043006825,'문어가라아게',3500,'','사이드메뉴');
insert into menu values(3043006825,'치킨가라아게',3000,'','사이드메뉴');
insert into menu values(3043006825,'오사카풍야끼교자',3000,'','사이드메뉴');
insert into menu values(3043006825,'우롱차',2500,'','음료메뉴');
insert into menu values(3043006825,'탄산수355ml',2000,'','음료메뉴');
insert into menu values(3043006825,'콜라355ml',2000,'','음료메뉴');
insert into menu values(3043006825,'사이다355ml',2000,'','음료메뉴');
insert into menu values(3043006825,'라무네',3000,'구슬사이다','음료메뉴');


insert into MENU values()
select * from store;
ALTER TABLE Store ADD rpComments VARCHAR(500);
update store set STORE.rpComments = '배달이 지연될 수 있습니다. 참고하시길바랍니다!'
where STORENAME = '롯데리아';
update store set STORE.rpComments = '리뷰이벤트 진행합니다❤️❤️' ||
                                    '1번 : 치즈추가' ||
                                    '2번 : 떡추가' ||
                                    '3번 : 콜라 사이즈업' ||
                                    '리뷰 안써주시는 사람이 많아요..' ||
                                    '리뷰 이벤트 후 꼭 써주세요!' ||
                                    '찜도 같이 눌러주세요!'
where STORENAME = '동궁찜닭연신내점';
commit;
-- 카테고리 추가
ALTER TABLE MENU ADD Mcategory VARCHAR(25);
select*from menu;
CREATE SEQUENCE order_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 10000
       NOCYCLE
       NOCACHE
       NOORDER;

--고객 등록
select*from customer;
insert into customer values('javaCode01','asdf123','임꺽정','서울시 은평구 불광동',01033114422);
insert into customer values('javaCode02','asdf123','심꺽정','서울시 은평구 불광동',01044223313);
insert into customer values('javaCode03','asdf123','오꺽정','서울시 은평구 불광동',01022331131);
insert into customer values('javaCode04','QWER123','지꺽정','서울시 은평구 갈현동',01022123132);
insert into customer values('javaCode05','QWES123','상꺽정','서울시 은평구 진관동',01055483211);
insert into customer values('javaCode06','fdsa342','조꺽정','서울시 은평구 갈현동',01055324313);
insert into customer values('javaCode07','qerkoqw132','박꺽정','서울시 은평구 갈현동',0105513311);
insert into customer values('javaCode08','cvxz321','임수정','서울시 은평구 진관동',01055413131);

--찜 등록
insert into favorite values('javaCode01',1068123498);
insert into favorite values('javaCode02',1068123498);
insert into favorite values('javaCode03',8963600619);
insert into favorite values('javaCode02',8963600619);
--event 등록
insert into event values('배달비 할인',2000,'14000원 이상 주문시 배달비 할인',1068123498);
insert into event values('쿠폰 할인',1000,'15000원 이상 주문시 1000원 할인',3043006825);

--쿠폰 등록
insert into coupon values(1001,3500);
insert into coupon values(1002,1000);
--주문
insert into orderProd values(ORDER_SEQ.nextval,01033114422,'리뷰이벤트 참여 1번 감사합니다.','슈퍼소니팩,치킨버거',16700,'신용카드/계좌','주문진행',1068123498,'javaCode01',1001,'배달비 할인');
insert into orderProd values(ORDER_SEQ.nextval,01033114422,'맛있게 만들어주세요.','세트2',15000,'신용카드/계좌','주문완료',3043006825,'javaCode05',1002,'쿠폰 할인');
insert into orderProd values(ORDER_SEQ.nextval,01044223313,'젓가락 포함입니다! ','동궁황금찜닭',19000,'신용카드/계좌','주문진행',8963600619,'javaCode02',null,null);
select * from ORDERPROD;
--리뷰
insert into review values(3,4,'너무 맛있어요 진심!','감사합니다. 노력하겠습니다.');
insert into REVIEW values(4,5,'맛과 양을 충분히 잡았습니다. 하지만 너무짜요진심 !','고객님 입맛을 맞추지 못해 죄송합니다. 다음에 더 노력하겠습니다.');
insert into review values(5,3,'아 올만에 라멘땡겨서 시켰는데 굿','감사합니다 !!');
select s.STORENAME,avg(r.STAR),count(r.REVIEW),s.MINODER,nvl2(od.COUPONNUM,'쿠폰','쿠폰없음'),
    s.DILIVERYCOST
from STORE s,ORDERPROD od,REVIEW r,event e,coupon c
where s.REGISTNUM = od.REGISTNUM
and od.ORDERNUM = r.ORDERNUM
group by s.STORENAME, od.COUPONNUM, s.DILIVERYCOST,s.MINODER;

--전체조회<사전순서대로 나옴>
select s.STORENAME,avg(r.STAR),count(r.REVIEW),s.MINODER,nvl2(c.COUPONNUM,'쿠폰','쿠폰없음'),
    s.DILIVERYCOST
from STORE s,ORDERPROD od,REVIEW r,event e,coupon c
where s.REGISTNUM = od.REGISTNUM
and od.COUPONNUM = c.COUPONNUM
and s.REGISTNUM = e.REGISTNUM
and od.ORDERNUM = r.ORDERNUM
group by s.STORENAME, c.COUPONNUM, s.DILIVERYCOST,s.MINODER
order by s.STORENAME; -- order 써도 된다.
--별점순 조회
select s.STORENAME,avg(r.STAR),count(r.REVIEW),s.MINODER,nvl2(c.COUPONNUM,'쿠폰','쿠폰없음'),
    s.DILIVERYCOST
from STORE s,ORDERPROD od,REVIEW r,event e,coupon c
where s.REGISTNUM = od.REGISTNUM
and od.COUPONNUM = c.COUPONNUM
and s.REGISTNUM = e.REGISTNUM
and od.ORDERNUM = r.ORDERNUM
group by s.STORENAME, c.COUPONNUM, s.DILIVERYCOST,s.MINODER
order by avg(r.STAR) desc; -- 오름차순 정렬
--리뷰 개수순으로 조회
select s.STORENAME,avg(r.STAR),count(r.REVIEW),s.MINODER,nvl2(c.COUPONNUM,'쿠폰','쿠폰없음'),
    s.DILIVERYCOST
from STORE s,ORDERPROD od,REVIEW r,event e,coupon c
where s.REGISTNUM = od.REGISTNUM
and od.COUPONNUM = c.COUPONNUM
and s.REGISTNUM = e.REGISTNUM
and od.ORDERNUM = r.ORDERNUM
group by s.STORENAME, c.COUPONNUM, s.DILIVERYCOST,s.MINODER
order by count(r.REVIEW) desc;--오름차순 정렬
-- 최소주문금액순
select s.STORENAME,avg(r.STAR),count(r.REVIEW),s.MINODER,nvl2(c.COUPONNUM,'쿠폰','쿠폰없음'),
    s.DILIVERYCOST
from STORE s,ORDERPROD od,REVIEW r,event e,coupon c
where s.REGISTNUM = od.REGISTNUM
and od.COUPONNUM = c.COUPONNUM
and s.REGISTNUM = e.REGISTNUM
and od.ORDERNUM = r.ORDERNUM
group by s.STORENAME, c.COUPONNUM, s.DILIVERYCOST,s.MINODER
order by s.MINODER; --내림차순
--
--카테고리별 조회 SQL문
select s.STORENAME,avg(r.STAR),count(r.REVIEW),nvl2(c.COUPONNUM,'쿠폰','쿠폰없음'),
    s.DILIVERYCOST
from STORE s,ORDERPROD od,REVIEW r,event e,coupon c
where s.REGISTNUM = od.REGISTNUM
and od.COUPONNUM = c.COUPONNUM
and s.REGISTNUM = e.REGISTNUM
and od.ORDERNUM = r.ORDERNUM
and s.CATEGORY = '한식'
group by s.STORENAME, c.COUPONNUM, s.DILIVERYCOST
order by s.STORENAME;

--카테고리별 조회
select s.STORENAME,avg(r.STAR),count(r.REVIEW),s.MINODER,nvl2(od.COUPONNUM,'쿠폰','쿠폰없음'),
    s.DILIVERYCOST
from STORE s,ORDERPROD od,REVIEW r,event e,coupon c
where s.REGISTNUM = od.REGISTNUM
and od.ORDERNUM = r.ORDERNUM
and s.CATEGORY = '1인분 주문'
group by s.STORENAME, od.COUPONNUM, s.DILIVERYCOST,s.MINODER;

select s.STORENAME,avg(r.STAR),count(r.REVIEW),s.MINODER,nvl2(od.COUPONNUM,'쿠폰','쿠폰없음'),
    s.DILIVERYCOST
from STORE s,ORDERPROD od,REVIEW r,event e,coupon c
where s.REGISTNUM = od.REGISTNUM
and od.ORDERNUM = r.ORDERNUM
and s.STORENAME = '롯데리아'
group by s.STORENAME, od.COUPONNUM, s.DILIVERYCOST,s.MINODER;
select * from REVIEW;
select distinct count(r.REVIEW) from REVIEW r,ORDERPROD od,store s
where r.ORDERNUM = od.ORDERNUM
and s.REGISTNUM = od.REGISTNUM
and s.STORENAME = '동궁찜닭연신내점';

-- 음식점 선택
select s.STORENAME,avg(r.STAR),count(r.REVIEW),s.MINODER,nvl2(od.COUPONNUM,'쿠폰','쿠폰없음'),
    s.DILIVERYCOST
from STORE s,ORDERPROD od,REVIEW r
where s.REGISTNUM = od.REGISTNUM
and od.ORDERNUM = r.ORDERNUM
and s.STORENAME = '동궁찜닭연신내점'
group by s.STORENAME, od.COUPONNUM,r.REVIEW, s.DILIVERYCOST,s.MINODER;

select*from ORDERPROD;
-- 클린 리뷰
select c.NAME,re.REVIEW,re.STAR,re.RPCOMMENT,m.MENUNAME from STORE s,menu m,ORDERPROD od,REVIEW re,CUSTOMER c
where s.REGISTNUM = od.REGISTNUM
and od.ORDERNUM = re.ORDERNUM
and s.REGISTNUM = m.REGISTNUM
and od.USERID = c.USERID
and od.MENU = m.MENUNAME
and s.STORENAME = '롯데리아';

select * from REVIEW;
select * from ORDERPROD;

select c.NAME,re.STAR,re.REVIEW,re.RPCOMMENT,od.MENU from REVIEW re, ORDERPROD od,CUSTOMER c,store s
where od.ORDERNUM = re.ORDERNUM
and od.USERID = c.USERID
and s.REGISTNUM = od.REGISTNUM
and s.STORENAME = '동궁찜닭연신내점';

--음식점 정보
select RPCOMMENTS,RPNAME,CONTACT,BRAND,ADDRESS,BUSINESSHOUR,ORIGIN,STATE from store
where STORENAME = '롯데리아';

--찜하기
select * from FAVORITE;

select distinct c.USERID,s.REGISTNUM from STORE s,CUSTOMER c
where USERID = 'javaCode01' and s.STORENAME ='롯데리아';

insert into favorite values(?,?);

select count(USERID) from FAVORITE where USERID = '?' and REGISTNUM = '?';
commit;