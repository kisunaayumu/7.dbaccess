package ex_popular_group_story2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EX03 {
    public static void main(String[] args) {
        String url ="jdbc:postgresql://localhost:5432/student";
        String user ="postgres";
        String password = "postgres";

        Connection con =null;
        PreparedStatement pstmt=null;
        ResultSet rs =null;
        String sql=null;


        try{
            con = DriverManager.getConnection(url, user, password);
            sql = "SELECT m.name as m_name, m.brith_day, m.gender, c.name as c_name FROM members m JOIN colors c ON c.id = m.color_id;";
            pstmt =con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String name =rs.getString("m_name");
                String birth_day =rs.getString("brith_day");
                String gender =rs.getString("gender");
                String cname =rs.getString("c_name");
                System.out.print("name "+name);
                System.out.println();
                System.out.print("brith_day "+birth_day);
                System.out.println();
                System.out.println("gender "+gender);
                System.out.println("color_name "+cname);
                System.out.println();
            }

        }catch(SQLException ex){
            System.out.println("SQLの障害が発生しました");
            System.out.println("発行したSQLは["+sql+"]");
            ex.printStackTrace();
        }finally{
            try{
                if(con!=null){
                    con.close();
                }
                if(pstmt!=null){
                    pstmt.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
