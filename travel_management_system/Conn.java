
package travel_management_system;

 import java.sql.*;
public class Conn {
     Connection c;
     Statement s;
    Conn (){
    
    //1 step register the driver
    try{
       //creating the connection string 
     
    
       Class.forName ("com.mysql.cj.jdbc.Driver");
       c=DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","riyasaraswat28");
            //create statement
         s = c.createStatement();
               
               
               
    }
    catch(Exception e){
    e.printStackTrace();
    }
    }
}
