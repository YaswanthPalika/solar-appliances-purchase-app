package project;
import java.sql.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class buy {
    public void buy(){
        try{
            while(true){
                products p=new products();
                p.display_products();
                Scanner sc = new Scanner(System.in);
                System.out.println("enter the product sno/or -1 to exit: ");
                int x=parseInt(sc.nextLine());
                if(x==-1){
                    break;
                }
                System.out.println("enter the quantity: ");
                int y=parseInt(sc.nextLine());
                if(check(x,y)){
                    
                   System.out.println("done");
                   
            float t= tot(x,y);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","candy","candy");
            Statement st= con.createStatement();
            String s="select*from products where id="+x;
            
            ResultSet rs1= st.executeQuery(s);
            rs1.next();
           String pname=rs1.getString(2);
            String Query="insert into cart1(sno,name,quantity,total) values("+x+",'"+pname+"',"+y+","+t+")";
            //System.out.println(Query);
            ResultSet rs= st.executeQuery(Query);
            con.close();
                }
                else{
                    System.out.println("quantity exceeds");
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public boolean check(int x,int y){
        int i=-1; 
        try{
             
            String Query="select*from products where id="+x;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","candy","candy");
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(Query);
           rs.next();
           String spass=rs.getString(3);
           int q=parseInt(spass);
           if(q>y){
               i=1;
           }
            con.close();
       }
       catch(Exception e){
           System.out.print(e);
       }
        //return true;
        if(i==1){
            return true;
        }
        else{
            return false;
        }
        
    }
    public float tot(int x,int y){
        float t=(float)0.0;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","candy","candy");
            Statement st= con.createStatement();
            String s="select*from products where id="+x; 
            ResultSet rs1= st.executeQuery(s);
            rs1.next();
           float p=Float.parseFloat(rs1.getString(4));
           t=p*y;

        }catch(Exception e){
            
        }
        return t;
    }
}
