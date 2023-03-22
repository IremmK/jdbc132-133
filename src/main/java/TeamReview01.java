import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TeamReview01 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","564Irem.");
        Statement statement = connection.createStatement();

        String sql1 = "CREATE TABLE companies (company_id SMALLINT, company VARCHAR, (20) , number_of_employees SMALLINT)";



    }
}
