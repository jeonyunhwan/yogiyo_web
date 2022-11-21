package DeliverySystem;

import Database.AllSelectVo;
import Database.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AllSelectDAO {
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    // 전체 식당 조회 list형식
    public ArrayList<AllSelectVo> Allselect() {
        ArrayList<AllSelectVo> allSelectVos = new ArrayList<AllSelectVo>();
        try {
            //순서는 order by로 받아와도 됨
            String query = "select s.STORENAME,avg(r.STAR),count(r.REVIEW),s.MINODER,nvl2(od.COUPONNUM,'쿠폰','쿠폰없음'),\n" +
                    "    s.DILIVERYCOST\n" +
                    "from STORE s,ORDERPROD od,REVIEW r,event e,coupon c\n" +
                    "where s.REGISTNUM = od.REGISTNUM\n" +
                    "and od.ORDERNUM = r.ORDERNUM\n" +
                    "group by s.STORENAME, od.COUPONNUM, s.DILIVERYCOST,s.MINODER";
            con = DB.con();
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                allSelectVos.add(new AllSelectVo(rs.getString(1),rs.getDouble(2),
                        rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(rs, pstmt, con);
        }
        return allSelectVos;
    }

    public ArrayList<AllSelectVo> CategorySelect(String cs) {
        ArrayList<AllSelectVo> allSelectVos = new ArrayList<AllSelectVo>();
        try {
            //순서는 order by로 받아와도 됨
            String query = "select s.STORENAME,avg(r.STAR),count(r.REVIEW),s.MINODER,nvl2(od.COUPONNUM,'쿠폰','쿠폰없음'),\n" +
                    "    s.DILIVERYCOST\n" +
                    "from STORE s,ORDERPROD od,REVIEW r,event e,coupon c\n" +
                    "where s.REGISTNUM = od.REGISTNUM\n" +
                    "and od.ORDERNUM = r.ORDERNUM\n" +
                    "and s.CATEGORY = ?\n" +
                    "group by s.STORENAME, od.COUPONNUM, s.DILIVERYCOST,s.MINODER";
            con = DB.con();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,cs);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                allSelectVos.add(new AllSelectVo(rs.getString(1),rs.getDouble(2),
                        rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(rs, pstmt, con);
        }
        return allSelectVos;
    }
    public ArrayList<AllSelectVo> InfoArray(String cs) {
        ArrayList<AllSelectVo> infoArray = new ArrayList<AllSelectVo>();
        try {
            //정렬 순서는 order by로 받아와도 됨
            //comparator 인터페이스 오버라이딩 해서 정렬 해도 됨
            String query = "select s.STORENAME,avg(r.STAR),count(r.REVIEW),s.MINODER,nvl2(od.COUPONNUM,'쿠폰','쿠폰없음'),\n" +
                    "    s.DILIVERYCOST\n" +
                    "from STORE s,ORDERPROD od,REVIEW r\n" +
                    "where s.REGISTNUM = od.REGISTNUM\n" +
                    "and od.ORDERNUM = r.ORDERNUM\n" +
                    "and s.STORENAME = '동궁찜닭연신내점'\n" +
                    "group by s.STORENAME, od.COUPONNUM,r.REVIEW, s.DILIVERYCOST,s.MINODER;";
            con = DB.con();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,cs);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                infoArray.add(new AllSelectVo(rs.getString(1),rs.getDouble(2),
                        rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(rs, pstmt, con);
        }
        return infoArray;
    }


}



