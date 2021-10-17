package project;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.Scanner;
public class newcustomer {
    public void newcustomer(){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.print("enter your name");
            String name=sc.nextLine();
            System.out.print("create a password");
            String password=sc.nextLine();
            System.out.print("enter your number");
            int number=parseInt(sc.nextLine());
            String Query="insert into customer(name,password,phone)"
                    + " values('"+name+"','"+password+"',"+number+")";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","candy","candy");
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(Query);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
