import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {
        //1.Step : Create the connection
       JdbcUtils.connectToDatabase("localhost","postgres","postgres","564Irem.");

       //2.Step : Create statement
        JdbcUtils.createStatement();

        //3.Step : Execute the query
        JdbcUtils.execute("CREATE TABLE workers (worker_id INT, worker_name VARCHAR (30), worker_salary SMALLINT );");
        JdbcUtils.execute("DROP TABLE workers");

        //4.Step : Close Connection and statement
        JdbcUtils.closeConnectionAndStatement();

        //drop the table method
        JdbcUtils.dropTable("workers");




    }
}
