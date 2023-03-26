import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ladies  {
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

    @Test
    public void ladies () throws SQLException {
        JdbcUtils.connectToDatabase("localhost","postgres","postgres","564Irem.");
        JdbcUtils.createStatement();

        //User sends the query to get the id from "ladies" table
        List<Object> ladiesId = JdbcUtils.getColumnList("ladies","id");
        System.out.println("Ladies Ids = "  +ladiesId);

        //ladies table
        String sql1 = "SELECT * FROM ladies";
        ResultSet rs1 = JdbcUtils.statement.executeQuery(sql1);

        while (rs1.next()){
            System.out.println(rs1.getInt(1) +" "+ rs1.getString(2) +" "+ rs1.getDate(3));
        }

        //id 2 den buyuk olanlar
        String sql2 = " SELECT name FROM ladies WHERE id>2";
        ResultSet rs2 = JdbcUtils.statement.executeQuery(sql2);
        List<String> name = new ArrayList<>();
        while(rs2.next()){
            name.add(rs2.getString("name"));
        }
        System.out.println(name);

    }





}

