package sample;

import java.sql.*;
//import java.sql.PreparedStatement;


public class Connector {
    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static String url = "jdbc:mysql://localhost:3306/carmech";
    private static String user = "root", psw = "root";

    public void readDataBase() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, psw);
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from customers");

            while(resultSet.next()){
                String name = resultSet.getString(1);
                String surname = resultSet.getString(2);
                String mobile = resultSet.getString(3);
                System.out.println(name + " " + surname + " " + mobile );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}

