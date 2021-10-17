package project;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.Scanner;
public class del {
    public void delete(){
        try{
            String Query="delete from cart1";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","candy","candy");
            Statement st= con.createStatement();
            int rs= st.executeUpdate(Query);
            System.out.println("thank you! please visit again.");
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void deletefromcart(){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("enter the sno of the item");
            String op=sc.nextLine();
            int x=parseInt(op);
            String Query="delete from cart1 where sno="+x;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","candy","candy");
            Statement st= con.createStatement();
            int rs= st.executeUpdate(Query);
            con.close();
            System.out.println("deleted from cart\n");
            cart c =new cart();
            c.ca();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
