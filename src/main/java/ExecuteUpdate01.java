import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","564Irem.");
        Statement statement = connection.createStatement();

        //1.Example: Update the number of employees to 16000 if the number of employees is less than the average number of employees
        String sql1 = "UPDATE companies SET number_of_employees=16000 WHERE number_of_employees < (SELECT AVG (number_of_employees) FROM companies)";
        int numOfRowsUpdated = statement.executeUpdate(sql1);// executeUpdate() method returns number of records updated.
        System.out.println(numOfRowsUpdated);

        String sql2 = "SELECT * FROM companies";
        ResultSet rs1 = statement.executeQuery(sql2);
        while (rs1.next()){
            System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+ rs1.getInt(3));
        }










        connection.close();
        statement.close();
    }
}
