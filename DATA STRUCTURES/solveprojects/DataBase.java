package solveprojects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase{
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost/farzad","postgres","farzad2010");
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("select * from jokar_tbl");
            while (set.next()){
                System.out.println(set.getString("name"));
                System.out.println(set.getString("grade"));
                System.out.println(set.getString("id"));
            }
set.close();
        }catch (Exception x){
            x.printStackTrace();
        }
    }
}