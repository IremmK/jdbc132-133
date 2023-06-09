import org.junit.Assert;
import org.junit.Test;

import java.sql.Statement;
import java.util.List;

public class GmiBankTest {
    /*
        Given
          User connects to the database
          (Host name: gmibank.com, Database name: gmibank_db, Usename: techprodb_user, Password: Techpro_@126))
        When
          User sends the query to get the user ids from "tp_customer" table
        Then
          Assert that number of all null user ids is 1338
        And
          User closes the connection
       */

    @Test
    public void gmiBankTest (){
        //User connects to the database
        JdbcUtils.connectToDatabase("gmibank.com","gmibank_db","techprodb_user","Techpro_@126");
        Statement statement = JdbcUtils.createStatement();

        //User sends the query to get the user ids from "tp_customer" table
        List<Object> objectList = JdbcUtils.getColumnList("tp_customer","user_id");
        System.out.println("object list = " + objectList);

        // Assert that number of all null user ids is 1338
        long numberOfNullElements = objectList.stream().filter(t-> t==null).count();
        System.out.println("numberOfNullElements = "+numberOfNullElements);//1338
        Assert.assertEquals(1338,numberOfNullElements);

        //User closes the connection
        JdbcUtils.closeConnectionAndStatement();

    }


}
