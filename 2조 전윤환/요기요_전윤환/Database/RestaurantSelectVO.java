package Database;

public class RestaurantSelectVO {
    private String mCategory;
    private String menuName;
    private String descriptionMenu;
    private int price;

    //리뷰확인 전역변수
    private String name;
    private int star;
    private String comment;
    private String rpcomment;
    private String orderMenuName;
    //음식점 정보
    private String rpComments;
    private String rpName;
    private long contect;
    private String brand;
    private String adress;
    private String businessHour;
    private String origin;
    private String state;
     // 찜하기
    private String userId;
    private long regis;
    public RestaurantSelectVO() {
    }
    //찜 생성자
    public RestaurantSelectVO(String userId, long regis) {
        this.userId = userId;
        this.regis = regis;
    }

    public RestaurantSelectVO(String rpComments, String rpName, long contect, String brand, String adress, String businessHour, String origin, String state) {
        this.rpComments = rpComments;
        this.rpName = rpName;
        this.contect = contect;
        this.brand = brand;
        this.adress = adress;
        this.businessHour = businessHour;
        this.origin = origin;
        this.state = state;
    }

    public RestaurantSelectVO(String name, int star, String comment, String rpcomment, String orderMenuName) {
        this.name = name;
        this.star = star;
        this.comment = comment;
        this.rpcomment = rpcomment;
        this.orderMenuName = orderMenuName;
    }

    public RestaurantSelectVO(String mCategory, String menuName, String descriptionMenu, int price) {
        this.mCategory = mCategory;
        this.menuName = menuName;
        this.descriptionMenu = descriptionMenu;
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getRegis() {
        return regis;
    }

    public void setRegis(long regis) {
        this.regis = regis;
    }

    public String getRpComments() {
        return rpComments;
    }

    public void setRpComments(String rpComments) {
        this.rpComments = rpComments;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getDescriptionMenu() {
        return descriptionMenu;
    }

    public void setDescriptionMenu(String descriptionMenu) {
        this.descriptionMenu = descriptionMenu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRpcomment() {
        return rpcomment;
    }

    public void setRpcomment(String rpcomment) {
        this.rpcomment = rpcomment;
    }

    public String getOrderMenuName() {
        return orderMenuName;
    }

    public void setOrderMenuName(String orderMenuName) {
        this.orderMenuName = orderMenuName;
    }

    public String getRpName() {
        return rpName;
    }

    public void setRpName(String rpName) {
        this.rpName = rpName;
    }

    public long getContect() {
        return contect;
    }

    public void setContect(long contect) {
        this.contect = contect;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getBusinessHour() {
        return businessHour;
    }

    public void setBusinessHour(String businessHour) {
        this.businessHour = businessHour;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
