import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","564Irem.");
        Statement statement = connection.createStatement();

        //1.Example : Select the country names whose region ids are 1
        String sql1 = "SELECT country_name FROM countries WHERE region_id = 1 ;";
        boolean r1 = statement.execute(sql1);
        System.out.println(r1);//If you use only execute() method, it will return true or false
        System.out.println("r1 = "+r1);//true

        //To see the records we have another method which is "executeQuery()" it returns ResultSet
//        ResultSet resultSet1 = statement.executeQuery(sql1);
//        resultSet1.next();
//        resultSet1.next();
//        resultSet1.next();
//        String r2 = resultSet1.getString("country_name");
//        System.out.println(  "country = "  +r2);//Germany

        ResultSet rS1 = statement.executeQuery(sql1);
        while(rS1.next()){
            System.out.println(rS1.getString("country_name"));
        }
        /*
        output:
            Belgium
            Switzerland
            Germany
            Denmark
            France
            Italy
            Netherlands
            United Kingdom
         */

        //2.Example: Select the country_id and country_name whose region_id's are greater than 2
        String sql2 = "SELECT country_id , country_name FROM countries WHERE region_id>2;";
        ResultSet rS2 = statement.executeQuery(sql2);
        while (rS2.next()){
            System.out.println(rS2.getString("country_id")+ "--> "+rS2.getString("country_name"));
        }
        /*
        output :
              AU --> Australia
              CN --> China
              EG --> Egypt
              IL --> Israel
              IN --> India
              JP --> Japan
              KW --> Kuwait
              ML --> Malaysia
              NG --> Nigeria
              SG --> Singapore
              ZM --> Zambia
              ZW --> Zimbabwe
         */


        //3.Example: Select all columns whose number_of_employees is the lowest from companies table
        String sql3 = "SELECT * FROM companies WHERE number_of_employees = (SELECT MIN (number_of_employees) FROM companies)";
        ResultSet rS3 = statement.executeQuery(sql3);
        while(rS3.next()){
            System.out.println(rS3.getString("company_id")+" "+rS3.getString("company")+" "+rS3.getString("number_of_employees"));
        }
        //output : 102 MICROSOFT 10000

        //5.Step: Close the connection and statement
        connection.close();
        statement.close();

    }
}
