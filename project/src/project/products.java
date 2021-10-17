package project;
import java.sql.*;
public class products {
    public void display_products(){
        try{
            String Query="select*from products";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","candy","candy");
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(Query);
            /*String spass=rs.getString(2);*/
            System.out.println("s.no\tproduct name\tquantity left\tprice");
            while(rs.next()){
                String sno=String.valueOf(rs.getInt(1));
                String name=rs.getString(2);
                String q=String.valueOf(rs.getInt(3));
                String p=String.valueOf(rs.getInt(4));
                System.out.println(sno+"\t"+name+"\t"+q+"\t\t"+p);
            } 
            con.close();
       }
       catch(Exception e){
           System.out.print(e);
       }
    }
    
}
