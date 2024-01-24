package ex_popular_group_story;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Ex03 {
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
            sql = "SELECT name,birth_day,gender,color_id FROM members;";
            pstmt =con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String name =rs.getString("name");
                String birth_day =rs.getString("birth_day");
                String gender =rs.getString("gender");
                int color_id =rs.getInt("color_id");
                System.out.print("name"+name);
                System.out.print(" age"+birth_day);
                System.out.println(" gender"+gender);
                System.out.println(" color_id"+color_id);
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
