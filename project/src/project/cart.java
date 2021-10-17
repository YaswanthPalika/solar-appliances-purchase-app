package project;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.Scanner;
public class cart {
    public void ca(){
        while(true){
            cart c =new cart();
            c.cart();
            Scanner sc=new Scanner(System.in);
            System.out.println("type \n\t'1' for deleting item from cart \n\t'2' for checking out\n");
            String op=sc.nextLine();
            int x=parseInt(op);
            if(x==2){
                break;
            }
            switch(x){
                case 1:
                    del d=new del();
                    d.deletefromcart();
                    break;
                default:
                    System.out.println("enter a proper number");
                    break;
            }
            
        }
        
    }
    
    public void cart(){
                float total=(float)0.0;
                    try{
            String Query="select * from cart1";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","candy","candy");
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(Query);
            System.out.println("sno\tproduct name\tquantity\tprice");
            while(rs.next()){
                String name=rs.getString(2);
                int q=parseInt(rs.getString(3));
                int sno=parseInt(rs.getString(1));
                float t=Float.parseFloat(rs.getString(4));
                System.out.println(sno+"\t"+name+"\t"+q+"\t\t"+t);
                total=t+total;
            }
            System.out.println("amount="+total);
            float d=discount(total);
            System.out.println("discount ="+d);
            System.out.println("amount to be paid="+(total-d));
            con.close();
        }catch(Exception E){
            System.out.print(E);
        }
    }
    public float discount(float total){
        float res=(float)0.0;
        try{
            String Query="select * from discount";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","candy","candy");
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(Query);
            rs.next();
            float d=Float.parseFloat(rs.getString(1));
            res=(d/100)*total;
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return res;
    }
    
}
