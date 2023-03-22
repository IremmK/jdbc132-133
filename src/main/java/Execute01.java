import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.Step : Registration to the driver
        Class.forName("org.postgresql.Driver");//This is not necessary since JDBC 4

        //2.Step : Create the connection to database
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","564Irem.");

        //3.Step : Create Statement for execute the queries
        Statement statement = connection.createStatement();

        //4.Step : Execute the query
        /*
        execute () method can be used in ddl (data definition language --> Create table, drop table, alter table) and DQL (data query language-->SELECT)
             1) If you use execute method with DDL everytime you will get false.
             2) If you use execute method with DQL you will get false or true.
             If you get the resultSet object as return you will get true otherwise you will get false
         */
        //1.Example: Create a workers table with these columns; worker_id, worker_name and worker_salary
        String dropTable  = "DROP TABLE workers";// --> you can drop the table in intelliJ like this way
        statement.execute(dropTable);

        String sql1 = "CREATE TABLE workers (worker_id VARCHAR (20),worker_name VARCHAR (50),worker_salary INT );";
        boolean sqlResult = statement.execute(sql1);
        System.out.println(sqlResult);//false

        //2.Example: Alter table by adding worker_address column into the workers table
        String sql2 = "ALTER TABLE workers ADD worker_address VARCHAR (100);";
        statement.execute(sql2);

        //3.Example: Drop the table
        String dropTable1 = "DROP TABLE workers";
        statement.execute(dropTable1);

        //5.Step : Close the connection and statement
        connection.close();
        statement.close();





    }
}
