package project;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.Scanner;
public class Project {
    public static void main(String[] args) throws IOException{
        System.out.println("SOLAR APPLIANCES PURCHASE APP");
        Scanner sc=new Scanner(System.in);
        while(true){
        System.out.println("type \n\t'1' for worker \n\t'2' for customer\n\t'3' for exit");
        String op=sc.nextLine();
        int x=parseInt(op);
        if(x==3){
                System.out.println("thank you");
                break;
        }
        switch (x) {
            case 1:
                login();
                break;
            case 2:
                customers c=new customers();
                c.customer();
                break;
            default:
                System.out.println("wrong option");
                break;
        }
        }
    }
    static void login(){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter username: ");
        String name=sc.nextLine();
        System.out.print("enter password: ");
        String password=sc.nextLine();
        
        try{
            String Query="select*from users where name='"+name+"'";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","candy","candy");
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(Query);
            rs.next();
            String spass=rs.getString(2);
            if(password.equals(spass)){
                System.out.println("logged in !");
                worker work=new worker();
                work.workers();
            }
            else{
                System.out.print("Sorry ,login failed!");
            }
            con.close();
        }catch(Exception E){
            System.out.print(E);
        }
    }
    
}
