import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSample {
    public static void main(String[] args) {
        String url ="jdbc:postgresql://localhost:5432/student";
        String user ="postgres";
        String password = "postgres";

        Connection con =null;
        PreparedStatement pstmt=null;
        String sql=null;


        try{
            con = DriverManager.getConnection(url, user, password);
            sql = "INSERT INTO employees(name,age)VALUES('テスト太朗',19);";
            pstmt =con.prepareStatement(sql);
            int numOfUpdate = pstmt.executeUpdate();
            System.out.println(numOfUpdate+"件データを操作しました。");
        


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

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}

