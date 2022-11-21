package DeliverySystem;

import Database.AllSelectVo;
import Database.RestaurantSelectVO;

import java.util.Comparator;

public class MainUtil {
    // 찜할때 데이터베이스에 포함 유무 확인

    public static void firstMenu() {
        System.out.println("--------------요기요 음식점 조회---------------");
        System.out.println("1.전체보기 2.1인분 주문 3.한식 4.돈까스/일식 5.나가기");
        System.out.println("------------------------------------------");
    }
    public static void SelectMenu(AllSelectVo a){
        System.out.println(a.getPname());
        System.out.println("⭐" + a.getStar() + "(" + a.getReviewCnt() + ")");
        System.out.println("배달요금: " + a.getDeliveryCost());
        System.out.println("최소주문금액: " + a.getMinOrderCost());
        System.out.println(a.getCouponState());
        System.out.println("-----------------------------------------------------");
    }
    public static void MenuSelect(RestaurantSelectVO a){
        System.out.println(a.getmCategory()+" 메뉴");
        System.out.println(a.getMenuName());
        System.out.println(a.getDescriptionMenu());
        System.out.println(a.getPrice()+ "원");
        System.out.println("-----------------------------------------------------");
    }
    public static void CleanReviewInfo(RestaurantSelectVO a){
        System.out.println(a.getName()+"님"+"⭐ "+a.getStar());
        System.out.println("---------------------------------");
        System.out.println(a.getComment());
        System.out.println("---------------------------------");
        System.out.println(">사장님 댓글<");
        System.out.println(a.getRpcomment());
        System.out.println("---------------------------------");
        System.out.println(a.getOrderMenuName());
        System.out.println("---------------------------------");
    }

    public static void RestaurantInfo(RestaurantSelectVO a,AllSelectVo b){
        System.out.println("☊ "+"사장님 알림");
        System.out.println(a.getRpComments());
        System.out.println();
        System.out.println("가게정보");
        System.out.println("---------------------------------");
        System.out.println("영업시간 " +a.getBusinessHour());
        System.out.println("전화번호 " +a.getContect());
        System.out.println(" 주소  " +a.getAdress());
        System.out.println();
        System.out.println("배달요금안내");
        System.out.println("---------------------------------");
        System.out.println("배달요금은 배달거리,주문금액,시간,날씨에 따라 달라질 수 있습니다.");
        System.out.println(" 배달요금 "+b.getDeliveryCost());
        System.out.println();
        System.out.println("결제 정보");
        System.out.println("---------------------------------");
        System.out.println(" 최소 주문 금액 "+b.getMinOrderCost());
        System.out.println();
        System.out.println("사업자 정보");
        System.out.println("---------------------------------");
        System.out.println(" 상호명 "+a.getBrand());
        System.out.println(" 대표자명 "+a.getRpName());
        System.out.println();
        System.out.println("원산지 정보");
        System.out.println("---------------------------------");
        System.out.println(a.getOrigin());

    }


}


