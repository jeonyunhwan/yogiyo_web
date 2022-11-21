package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DB {
    public static Connection con() throws SQLException {
        Connection con = null;
        //1. 메모리 로딩
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // System.out.println("드라이버 로딩 성공");
        }catch (ClassNotFoundException e) {
            // TODO: handle exception
            System.out.println("드라이브 에러: "+e.getMessage());
        }
        String info = "jdbc:oracle:thin:@z16f3671nnnfk94j_high?TNS_ADMIN=/Users/yunhwan-i/ADMIN";
        con = DriverManager.getConnection(info,"ADMIN","Uni42181123a");
        //System.out.println("연결 성공");
        return con;


    }

    public static void close(ResultSet rs,Statement stmt,Connection con) {
        try {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
            if(con!=null) con.close();
        }catch(SQLException e){
            System.out.println("연결 종료 예외 발생:"+e.getMessage());
            if(rs!=null) {
                try {
                    rs.close();
                }catch(SQLException e1) {
                    System.out.println("ResultSet: "+e1.getMessage());
                }
            }
            if(stmt!=null) {
                try {
                    stmt.close();
                }catch(SQLException e1) {
                    System.out.println("Statement: "+e1.getMessage());
                }
            }
            if(con!=null) {
                try {
                    con.close();
                }catch(SQLException e1) {
                    System.out.println("Connection: "+e1.getMessage());
                }
            }
        }
    }
}