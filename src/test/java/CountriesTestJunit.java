import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class CountriesTestJunit {

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
    public void countriesTest (){
       // User connects to the database
       JdbcUtils.connectToDatabase("localhost","postgres","postgres","564Irem.");
       JdbcUtils.createStatement();

       //User sends the query to get the region ids from "countries" table
        List<Object> regionIdList =JdbcUtils.getColumnList("countries","region_id");
        System.out.println("list = " + regionIdList);

        //Verify that the number of region ids greater than 1 is 17.
        int listSize = (int) regionIdList.stream().filter(t->(int) t>1).count();
        System.out.println("list size = "+listSize);//17
        Assert.assertEquals(17,listSize);

        //User closes the connection
        JdbcUtils.closeConnectionAndStatement();



    }

}
