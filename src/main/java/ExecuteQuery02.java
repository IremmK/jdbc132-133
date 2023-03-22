import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","564Irem.");
        Statement statement = connection.createStatement();

        //1.Example: Find the company and number_of_employees whose number_of_employees is the second highest from the companies table
        String sql1 = "SELECT company , number_of_employees FROM companies ORDER BY number_of_employees DESC OFFSET 1 ROW LIMIT 1";
        ResultSet rS1 = statement.executeQuery(sql1);
        while (rS1.next()){
            System.out.println(rS1.getString("company")+"--"+rS1.getInt("number_of_employees"));
        }
        //2.WAY:
        String sql2 = "SELECT company , number_of_employees FROM companies WHERE number_of_employees = (SELECT MAX (number_of_employees) FROM companies WHERE number_of_employees < (SELECT MAX (number_of_employees) FROM companies))";
        ResultSet rS2 = statement.executeQuery(sql2);
        while (rS2.next()){
            System.out.println(rS2.getString("company")+"--"+rS2.getInt("number_of_employees"));
        }

        //2.Example: Find the company names and number of employees whose number of employees is less than the average number of employees
        String sql3 = "SELECT company , number_of_employees FROM companies WHERE number_of_employees< (SELECT AVG (number_of_employees) FROM companies)";
        ResultSet rs3 = statement.executeQuery(sql3);
        while (rs3.next()){
            System.out.println(rs3.getString("company") + "--" + rs3.getInt("number_of_employees"));
        }

        connection.close();
        statement.close();



    }
}
