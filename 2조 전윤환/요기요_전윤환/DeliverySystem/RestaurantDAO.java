package DeliverySystem;

import Database.AllSelectVo;
import Database.DB;
import Database.RestaurantSelectVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RestaurantDAO {
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private String id;
    private long rNum;
    //비교하기 위한 변수 선언
    private int s;
    private long rNum01;

    public ArrayList<RestaurantSelectVO> MenuSelect(String cs) {
        ArrayList<RestaurantSelectVO> menuSelect = new ArrayList<RestaurantSelectVO>();
        try {
            //순서는 order by로 받아와도 됨
            String query = "select m.MCATEGORY,m.MENUNAME,m.DESCRIPTION,m.price from store s,menu m\n" +
                    "where s.REGISTNUM = m.REGISTNUM\n" +
                    "and s.STORENAME = ?";
            con = DB.con();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, cs);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                menuSelect.add(new RestaurantSelectVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(rs, pstmt, con);
        }
        return menuSelect;
    }

    public ArrayList<RestaurantSelectVO> CleanReview(String cs) {
        ArrayList<RestaurantSelectVO> cleanReview = new ArrayList<RestaurantSelectVO>();
        try {
            String query = "select c.NAME,re.STAR,re.REVIEW,re.RPCOMMENT,od.MENU from REVIEW re, ORDERPROD od,CUSTOMER c,store s\n" +
                    "where od.ORDERNUM = re.ORDERNUM\n" +
                    "and od.USERID = c.USERID\n" +
                    "and s.REGISTNUM = od.REGISTNUM\n" +
                    "and s.STORENAME = ?";
            con = DB.con();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, cs);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cleanReview.add(new RestaurantSelectVO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                        rs.getString(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(rs, pstmt, con);
        }
        return cleanReview;
    }

    public ArrayList<RestaurantSelectVO> RestaurantInfo(String cs) {
        ArrayList<RestaurantSelectVO> restaurantInfo = new ArrayList<RestaurantSelectVO>();
        try {
            String query = "select RPCOMMENTS,RPNAME,CONTACT,BRAND,ADDRESS,BUSINESSHOUR,ORIGIN,STATE from store\n" +
                    "where STORENAME = ?";
            con = DB.con();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, cs);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                restaurantInfo.add(new RestaurantSelectVO(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(rs, pstmt, con);
        }
        return restaurantInfo;
    }

    public void favoriteInsert(String userId, String sName) {
        try {

            RestaurantSelectVO a = new RestaurantSelectVO();
            String query1 = "select distinct c.USERID,s.REGISTNUM from STORE s,CUSTOMER c\n" +
                    "where USERID = ? and s.STORENAME = ?";
            con = DB.con();
            pstmt = con.prepareStatement(query1);
            pstmt.setString(1, userId);
            pstmt.setString(2, sName);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                id = rs.getString(1);
                rNum = rs.getLong(2);
            }

            String query2 = "select count(USERID) from FAVORITE where USERID = ? and REGISTNUM = ?";
            con = DB.con();
            pstmt = con.prepareStatement(query2);
            pstmt.setString(1, id);
            pstmt.setLong(2, rNum);
            rs = pstmt.executeQuery();

            //이미 찜한 목록 안됨.
            if (rs.next()) {
                s = rs.getInt(1);
                if (s > 0) {
                    System.out.println("이미 찜한 목록입니다.");
                } else {
                    String query3 = "insert into favorite values(?,?)";
                    con = DB.con();
                    con.setAutoCommit(false);
                    pstmt = con.prepareStatement(query3);
                    pstmt.setString(1, id);
                    pstmt.setLong(2, rNum);
                    int updateCount = pstmt.executeUpdate();
                    if (updateCount != 0) {
                        System.out.println("❤️");
                    } else {
                        System.out.println("다시시도해주세요");
                    }
                    con.commit();
                    pstmt.close();
                    con.close();
                }
            }
        }catch(SQLException e){
            System.out.println("다시 시도해주세요.");
            try {
                con.rollback();
            } catch (SQLException e1) {
                System.out.println("rollback 에러:" + e.getMessage());
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}



