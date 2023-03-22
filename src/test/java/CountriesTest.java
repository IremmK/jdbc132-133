import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountriesTest {
    /*
        Given
          User connects to the database
        When
          User sends the query to get the region ids from "countries" table
        Then
          Verify that the number of region ids greater than 1 is 17.
        And
          User closes the connection
       */
    public static void main(String[] args) throws SQLException {
        //User connects to the database
        JdbcUtils.connectToDatabase("localhost","postgres","postgres","564Irem.");
        JdbcUtils.createStatement();

        //User sends the query to get the region ids from countries table
        String sql1 = "SELECT region_id FROM countries";
        ResultSet rs1 = JdbcUtils.statement.executeQuery(sql1);
        List<Integer> list =new ArrayList<>();

        while (rs1.next()) {
            list.add(rs1.getInt(1));
        }
        System.out.println("list = "+list);//list = [2, 3, 1, 2, 2, 1, 3, 1, 1, 4, 1, 4, 3, 1, 3, 4, 3, 2, 4, 1, 3, 1, 2, 4, 4]

        //Verify that the number of region ids greater than 1 is 17.
        int counter = 0 ;
        for(int w : list) {
            if(w>1){
                counter++;
            }
        }
        System.out.println("Counter = "+counter);//Counter = 17

    }



}
