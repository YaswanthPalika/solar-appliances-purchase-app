package project;
import java.sql.*;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
public class worker {
    public static void workers(){
         try{
             
           Scanner sc=new Scanner(System.in);
           while(true){
                           System.out.println("type "
                    + "\n\t'1' for updating products\n\t"
                    + "'2' for new product"
                    + "\n\t'3' for updating discount\n\t"
                    + "'4' for displaying products\n\t"
                    + "'5' for exiting");
            int x=parseInt(sc.nextLine());
            if(x==5){
                break;
            }
            switch(x){
                case 1:
                    update();
                    break;
                case 2:
                    newproduct();
                    break;
                case 3:
                    discount();
                    break;
                case 4:
                    products p=new products();
                    p.display_products();
                    break;
                default:
                    System.out.print("Wrong option");
            }
           }
       }
       catch(Exception e){
           System.out.print(e);
       }
    }
    static void update(){
               try{
              products p=new products();
              p.display_products();
             Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","candy","candy");
            Statement st= con.createStatement();
           Scanner sc=new Scanner(System.in);
            System.out.println("type \n\t'1' for updating price of a product\n\t"
                    + "'2' for updating quantity of a product\n\t"
                    + "'3' for updating both ");
            int x=parseInt(sc.nextLine());
            String Query=new String();
            String up_name=new String();
            int up_q=0;
            float up_p=(float) 0.0;
            switch(x){
                case 1:
                    System.out.println("enter the name of the product");
                    up_name=sc.nextLine();
                    System.out.println("enter the new price of the product");
                    up_p=Float.parseFloat(sc.nextLine());
                    Query="update products set price="+up_p+" where name='"+up_name+"'";
                    ResultSet rs=st.executeQuery(Query);
                    break;
                case 2:
                    System.out.println("enter the name of the product");
                    up_name=sc.nextLine();
                    System.out.println("enter the quantity of the product to be added");
                    up_q=parseInt(sc.nextLine());
                    String Query2="select*from products where name='"+up_name+"'";
                    ResultSet rs1=st.executeQuery(Query2);
                    rs1.next();
                    int s=parseInt(rs1.getString(3));
                    int n=s+up_q;
                    Query="update products set quantity="+n+" where name='"+up_name+"'";
                    ResultSet rs2=st.executeQuery(Query);
                    break;
                case 3:
                    System.out.println("enter the name of the product");
                    up_name=sc.nextLine();
                    System.out.println("enter the quantity of the product to be added");
                    up_q=parseInt(sc.nextLine());
                    System.out.println("enter the new price of the product");
                    up_p=parseInt(sc.nextLine());
                    String Query3="select*from products where name='"+up_name+"'";
                    ResultSet rs3=st.executeQuery(Query3);
                    rs3.next();
                    int s1=parseInt(rs3.getString(3));
                    int n1=s1+up_q;
                    Query="update products set quantity="+n1+" where name='"+up_name+"'";
                    ResultSet rs4=st.executeQuery(Query);
                    Query="update products set price="+up_p+" where name='"+up_name+"'";
                    ResultSet rs5=st.executeQuery(Query);
                    break;
                default:
                    System.out.print("Wrong input");
            }

            
            con.close();
       }
       catch(Exception e){
           System.out.print(e);
       }
        
    }
    static void newproduct(){
        try{
            Scanner sc =new Scanner(System.in);
            System.out.println("enter the new id: ");
            int new_id=parseInt(sc.nextLine());
            System.out.println("enter the name: ");
            String new_name=sc.nextLine();
            System.out.println("enter the quantity of the product: ");
            int new_quantity=parseInt(sc.nextLine());
            System.out.println("enter the price of the product: ");
            int new_price=parseInt(sc.nextLine());
            
            String Query="insert into products(id,name,quantity,price) values("+new_id+",'"+new_name+"',"+new_quantity+","+new_price+")";
            //System.out.print(Query);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","candy","candy");
            Statement st= con.createStatement();
            int rs= st.executeUpdate(Query);
            if(rs>0){
                System.out.println("added the product");
            }
            else{
                System.out.println("Sorry!\nproduct is not added");
            }
            con.close();
        }catch(Exception e){
            System.out.print(e);
        }
    }
    static void discount(){
        try{
            Scanner sc =new Scanner(System.in);
            System.out.println("enter new discount: ");
            Float new_disc=Float.parseFloat(sc.nextLine());
            String Query="update discount set discount="+new_disc;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","candy","candy");
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(Query);
            con.close();
        }catch(Exception e){
            System.out.print(e);
        }
    }
    
}
