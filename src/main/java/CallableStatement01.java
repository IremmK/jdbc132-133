import java.sql.*;

public class CallableStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","564Irem.");
        Statement statement = connection.createStatement();

        //1.Example: Create a function which uses 2 parameters and return the sum of the parameters
        //1.Step : Type code to create function
        String sql1 = "CREATE OR REPLACE FUNCTION additionF (x NUMERIC ,y NUMERIC) RETURNS NUMERIC LANGUAGE plpgsql AS $$ BEGIN  RETURN x+y; END $$ ";

        //2.Step : Execute the function
        statement.execute(sql1);

        //3.Step : Prepare the CallableStatement
        CallableStatement cs1 = connection.prepareCall("{? = call additionF(?,?)}");

        //4.Step : use registerOutParameter() method for result container and use setInt(), setString()... for parameters
        cs1.registerOutParameter(1,Types.NUMERIC);
        cs1.setInt(2,9);
        cs1.setInt(3,4);

        //5.Step : Execute the CallableStatement
        cs1.execute();

        //6.Step : See the result
        System.out.println(cs1.getObject(1));

        //2.Example: Create a function which calculates the volume of cone
        String sql2 = "CREATE OR REPLACE FUNCTION volumeOfCone(r NUMERIC, h NUMERIC) RETURNS NUMERIC LANGUAGE plpgsql AS $$ BEGIN RETURN r*r*h*3.14/3; END $$";
        statement.execute(sql2);
        CallableStatement cs2 = connection.prepareCall("{? = call volumeOfCone(?,?)}");
        cs2.registerOutParameter(1,Types.NUMERIC);
        cs2.setInt(2,2);
        cs2.setInt(3,6);
        cs2.execute();
        System.out.println(cs2.getObject(1));//25.1200000000000000
        System.out.printf("%.2f", cs2.getObject(1));//25.12



        connection.close();
        statement.close();
    }
}
