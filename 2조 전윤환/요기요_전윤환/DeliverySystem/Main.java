package DeliverySystem;

import Database.AllSelectVo;
import Database.RestaurantSelectVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
//mainutil 은 그냥 형식 static 으로 담아둔것.
//compareMethod 사전,별점,배달,최소금액순으로 정렬해주는 인터페이스를 다시 오버라이딩한거
//Collections.sort()로 arraylist 정렬
//이미 찜한 목록 찜 못하게 구현해놨음.
//목요일까지 코드줄이고, 영업시간에 대한 테이블을 다시 짜서 현재시간 비교하여 목록에 안뜨게 하는 구현할 예정
public class Main {
    public static void main(String[] args) {
        AllSelectDAO allSelectDAO = new AllSelectDAO();
        RestaurantDAO menuSelectDao = new RestaurantDAO();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            MainUtil.firstMenu();
            try {
                System.out.print("메뉴선택>");
                String ch = br.readLine();
                if (ch.equals("전체보기") || ch.equals("1")) {
                    System.out.println(">전체 보기 음식점 목록<");
                    System.out.println("1. 사전순 2. 별점순 3. 배달요금순 4. 최소주문금액순 5. 나가기");
                    System.out.print("메뉴선택>");
                    String ch1 = br.readLine();
                    if (ch1.equals("1")) {
                        System.out.println("---------------------요기요 등록맛집-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.Allselect();
                        Collections.sort(alist, new CompareList02());
                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }

                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        while(true){
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                        }else {
                            System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                            System.out.print("메뉴선택>");
                            String ch3 = br.readLine();
                            if(ch3.equals("1")){
                                for (RestaurantSelectVO a : blist) {
                                    MainUtil.MenuSelect(a);
                                }
                            }
                            else if (ch3.equals("2")) {
                                ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                if (clist.size() == 0) {
                                    System.out.println("리뷰가 없습니다.");
                                } else {
                                    for (RestaurantSelectVO a : clist) {
                                        MainUtil.CleanReviewInfo(a);
                                    }
                                }
                            }else if(ch3.equals("3")){
                                ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                for(RestaurantSelectVO a: dlist) {
                                    for (AllSelectVo c : elist) {
                                        MainUtil.RestaurantInfo(a,c);
                                    }
                                }
                            }else if(ch3.equals("4")){
                                //찜하기
                                System.out.println("-----------찜하기----------");
                                System.out.println("아이디 입력 : ");
                                String id = br.readLine();
                                RestaurantDAO a = new RestaurantDAO();
                                a.favoriteInsert(id,ch2);
                            }else if(ch3.equals("5")){
                                break;
                            }else{
                                System.out.println("선택이 적절하지않습니다.");
                            }
                        }
                        }
                        //별점
                    } else if (ch1.equals("2")) {
                        System.out.println("---------------------요기요 별점순-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.Allselect();
                        Collections.sort(alist, new CompareList());

                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }

                    } else if (ch1.equals("3")) {
                        System.out.println("---------------------요기요 배달요금순-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.Allselect();
                        Collections.sort(alist, new CompareList03());

                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }



                    } else if (ch1.equals("4")) {
                        System.out.println("---------------------요기요 최소금액순-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.Allselect();
                        Collections.sort(alist, new CompareList04());

                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }

                    } else if (ch1.equals("5")) {
                        System.out.println("전체보기 창을 나갑니다.");

                    } else {

                    }
                } else if (ch.equals("1인분 주문") || ch.equals("2")) {
                    System.out.println(">1인분 주문 음식점 목록<");
                    System.out.println("1. 사전순 2. 별점순 3. 배달요금순 4. 최소주문금액순 5. 나가기");
                    System.out.print("메뉴선택>");
                    String ch1 = br.readLine();
                    if (ch1.equals("1")) {
                        System.out.println("---------------------요기요 등록맛집-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.CategorySelect("1인분 주문");
                        Collections.sort(alist, new CompareList02());
                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                            break;
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }

                        //별점
                    } else if (ch1.equals("2")) {
                        System.out.println("---------------------요기요 별점순-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.CategorySelect("1인분 주문");
                        Collections.sort(alist, new CompareList());

                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }


                    } else if (ch1.equals("3")) {
                        System.out.println("---------------------요기요 배달요금순-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.CategorySelect("1인분 주문");
                        Collections.sort(alist, new CompareList03());

                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }


                    } else if (ch1.equals("4")) {
                        System.out.println("---------------------요기요 최소금액순-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.CategorySelect("1인분 주문");
                        Collections.sort(alist, new CompareList04());

                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }

                    } else if (ch1.equals("5")) {
                        System.out.println("1인분 주문창을 나갑니다.");
                    } else {
                    }
                } else if (ch.equals("한식") || ch.equals("3")) {
                    System.out.println(">한식 주문 음식점 목록<");
                    System.out.println("1. 사전순 2. 별점순 3. 배달요금순 4. 최소주문금액순 5. 나가기");
                    System.out.print("메뉴선택>");
                    String ch1 = br.readLine();
                    if (ch1.equals("1")) {
                        System.out.println("---------------------요기요 등록맛집-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.CategorySelect("한식");
                        Collections.sort(alist, new CompareList02());
                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }

                        //별점
                    } else if (ch1.equals("2")) {
                        System.out.println("---------------------요기요 별점순-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.CategorySelect("한식");
                        Collections.sort(alist, new CompareList());

                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }


                    } else if (ch1.equals("3")) {
                        System.out.println("---------------------요기요 배달요금순-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.CategorySelect("한식");
                        Collections.sort(alist, new CompareList03());

                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }


                    } else if (ch1.equals("4")) {
                        System.out.println("---------------------요기요 최소금액순-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.CategorySelect("한식");
                        Collections.sort(alist, new CompareList04());

                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }

                    } else if (ch1.equals("5")) {
                        System.out.println("한식 주문창을 나갑니다.");
                    } else {
                        break;
                    }
                }else if (ch.equals("돈까스/일식") || ch.equals("4")) {
                    System.out.println(">돈까스/일식 주문 음식점 목록<");
                    System.out.println("1. 사전순 2. 별점순 3. 배달요금순 4. 최소주문금액순 5. 나가기");
                    System.out.print("메뉴선택>");
                    String ch1 = br.readLine();
                    if (ch1.equals("1")) {
                        System.out.println("---------------------요기요 등록맛집-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.CategorySelect("돈까스/일식");
                        Collections.sort(alist, new CompareList02());
                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            break;
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                                continue;
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }

                        //별점
                    } else if (ch1.equals("2")) {
                        System.out.println("---------------------요기요 별점순-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.CategorySelect("돈까스/일식");
                        Collections.sort(alist, new CompareList());

                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }


                    } else if (ch1.equals("3")) {
                        System.out.println("---------------------요기요 배달요금순-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.CategorySelect("돈까스/일식");
                        Collections.sort(alist, new CompareList03());

                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }


                    } else if (ch1.equals("4")) {
                        System.out.println("---------------------요기요 최소금액순-------------------");
                        ArrayList<AllSelectVo> alist = allSelectDAO.CategorySelect("돈까스/일식");
                        Collections.sort(alist, new CompareList04());

                        for (AllSelectVo a : alist) {
                            MainUtil.SelectMenu(a);
                        }
                        System.out.println("음식점 이름을 적어주세요:");
                        String ch2 = br.readLine();
                        ArrayList<RestaurantSelectVO> blist = menuSelectDao.MenuSelect(ch2);
                        if(blist.size() == 0){
                            System.out.println("음식점 이름이 없습니다.");
                            System.out.println("다시 입력해주세요");
                        }else{
                            for(RestaurantSelectVO a:blist){
                                MainUtil.MenuSelect(a);
                            }
                        }
                        while(true){
                            if(blist.size() == 0){
                                System.out.println("음식점 이름이 없습니다.");
                                System.out.println("다시 입력해주세요");
                            }else {
                                System.out.println("1. 메뉴확인 2. 클린 리뷰확인 3. 음식점 정보확인 4. 찜하기 5. 나가기");
                                System.out.print("메뉴선택>");
                                String ch3 = br.readLine();
                                if(ch3.equals("1")){
                                    for (RestaurantSelectVO a : blist) {
                                        MainUtil.MenuSelect(a);
                                    }
                                }
                                else if (ch3.equals("2")) {
                                    ArrayList<RestaurantSelectVO> clist = menuSelectDao.CleanReview(ch2);
                                    if (clist.size() == 0) {
                                        System.out.println("리뷰가 없습니다.");
                                    } else {
                                        for (RestaurantSelectVO a : clist) {
                                            MainUtil.CleanReviewInfo(a);
                                        }
                                    }
                                }else if(ch3.equals("3")){
                                    ArrayList<RestaurantSelectVO> dlist = menuSelectDao.RestaurantInfo(ch2);
                                    ArrayList<AllSelectVo> elist = allSelectDAO.InfoArray(ch2);
                                    for(RestaurantSelectVO a: dlist) {
                                        for (AllSelectVo c : elist) {
                                            MainUtil.RestaurantInfo(a,c);
                                        }
                                    }
                                }else if(ch3.equals("4")){
                                    //찜하기
                                    System.out.println("-----------찜하기----------");
                                    System.out.println("아이디 입력 : ");
                                    String id = br.readLine();
                                    RestaurantDAO a = new RestaurantDAO();
                                    a.favoriteInsert(id,ch2);
                                }else if(ch3.equals("5")){
                                    break;
                                }else{
                                    System.out.println("선택이 적절하지않습니다.");
                                }
                            }
                        }

                    } else if (ch1.equals("5")) {
                        System.out.println("돈까스/일식 조회창을 나갑니다.");
                    } else {
                        break;
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}