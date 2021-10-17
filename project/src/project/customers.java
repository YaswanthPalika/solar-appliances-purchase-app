package project;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.Scanner;
public class customers {
        public void customer(){
            Scanner sc=new Scanner(System.in);
            while(true){
            System.out.println("type\n\t'1' for login\n\t'2' for new customer\n\t'3' for going back");
            int n=parseInt(sc.nextLine());
            if(n==3){
                break;
            }
         switch(n){
            case 1:
                login();
                break;
            case 2:
                newcustomer c=new newcustomer();
                c.newcustomer();
                break;
            default:
                System.out.println("Wrong input");
                 }
            }
        
        }
        public void tasks(){
            try{
                Scanner sc=new Scanner(System.in);
                while(true){
                    System.out.println("type\n\t"
                        + "'1' for shoping\n\t"
                        + "'2' for checking cart and bill\n\t"
                        + "'3' for exiting");
                int x=parseInt(sc.nextLine());
                if(x==3){
                    del d=new del();
                    d.delete();
                    break;
                }
                switch(x){
                    case 1:
                        buy b=new buy();
                        b.buy();
                        break;
                    case 2:
                        cart c=new cart();
                        c.ca();
                        break;
                    default:
                        System.out.print("Wrong input");
                }
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
       public void login(){
           Scanner sc=new Scanner(System.in);
        System.out.print("enter username: ");
        String name=sc.nextLine();
        System.out.print("enter password: ");
        String password=sc.nextLine();
        try{
            String Query="select*from customer where name='"+name+"'";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","candy","candy");
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(Query);
            rs.next();
            String spass=rs.getString(2);
            if(password.equals(spass)){
                System.out.println("logged in !");
                /*products p=new products();
                p.display_products();*/
                tasks();
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
