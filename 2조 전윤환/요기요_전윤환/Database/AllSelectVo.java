package Database;

public class AllSelectVo {
    private String pname;
    private double star;
    private int reviewCnt;
    private int minOrderCost;
    private String couponState;
    private int deliveryCost;
    public AllSelectVo(){}
    public AllSelectVo(String pname, double star, int reviewCnt, int minOrderCost, String couponState, int deliveryCost) {
        this.pname = pname;
        this.star = star;
        this.reviewCnt = reviewCnt;
        this.minOrderCost = minOrderCost;
        this.couponState = couponState;
        this.deliveryCost = deliveryCost;
    }


    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public int getReviewCnt() {
        return reviewCnt;
    }

    public void setReviewCnt(int reviewCnt) {
        this.reviewCnt = reviewCnt;
    }

    public int getMinOrderCost() {
        return minOrderCost;
    }

    public void setMinOrderCost(int minOrderCost) {
        this.minOrderCost = minOrderCost;
    }

    public String getCouponState() {
        return couponState;
    }

    public void setCouponState(String couponState) {
        this.couponState = couponState;
    }

    public int getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(int deliveryCost) {
        this.deliveryCost = deliveryCost;
    }
}
